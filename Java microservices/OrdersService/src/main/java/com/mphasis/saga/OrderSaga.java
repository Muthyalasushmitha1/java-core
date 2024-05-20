package com.mphasis.saga;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.commandhandling.CommandResultMessage;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.command.commands.ApproveOrderCommand;
import com.mphasis.command.commands.RejectOrderCommand;
import com.mphasis.core.commands.CancelProductReservationCommand;
import com.mphasis.core.commands.ProcessPaymentCommand;
import com.mphasis.core.commands.ReserveProductCommand;
import com.mphasis.core.events.OrderCreatedEvent;
import com.mphasis.core.events.OrderRejectedEvent;
import com.mphasis.core.events.PaymentProcessedEvent;
import com.mphasis.core.events.ProductReservationCancelledEvent;
import com.mphasis.core.events.ProductReservedEvent;
import com.mphasis.core.model.OrderApprovedEvent;
import com.mphasis.core.model.User;
import com.mphasis.core.query.FetchUserPaymentDetailsQuery;

@Saga
public class OrderSaga {

	@Autowired
	private transient CommandGateway commandGateway;

	@Autowired
	private transient QueryGateway queryGateway;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderSaga.class);
	
	@StartSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderCreatedEvent orderCreatedEvent) {
		
		ReserveProductCommand reserveProductCommand = ReserveProductCommand.builder()
				.orderId(orderCreatedEvent.getOrderId())
				.quantity(orderCreatedEvent.getQuantity())
				.userId(orderCreatedEvent.getUserId())
				.productId(orderCreatedEvent.getProductId())
				.build();
		
		LOGGER.info("OrderCreatedEvent handled for orderId: " + reserveProductCommand.getOrderId() +
				" and productId: " + reserveProductCommand.getProductId());
		
		commandGateway.send(reserveProductCommand, new CommandCallback<ReserveProductCommand, Object>() {
		
			@Override
			public void onResult(CommandMessage<? extends ReserveProductCommand> commandMessage,
					CommandResultMessage<? extends Object> commandResultMessage) {

				if (commandResultMessage.isExceptional()) {
					
					// Start a compensating transaction
					RejectOrderCommand rejectOrderCommand = new RejectOrderCommand(
							orderCreatedEvent.getOrderId(),
							commandResultMessage.exceptionResult().getMessage());
					
					commandGateway.send(rejectOrderCommand);
				}
			}
		});
	}
	
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(ProductReservedEvent productReservedEvent) {
		
		// Process User Payment
		LOGGER.info("ProductReservedEvent is called for productId: " + productReservedEvent.getOrderId() +
				" and orderId: " + productReservedEvent.getOrderId());
		
		FetchUserPaymentDetailsQuery fetchUserPaymentDetailsQuery = 
				new FetchUserPaymentDetailsQuery(productReservedEvent.getUserId());
		
		User userPaymentDetails = null;
		
		try {
			userPaymentDetails = queryGateway.query(fetchUserPaymentDetailsQuery, 
				ResponseTypes.instanceOf(User.class)).join();
		}catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			// Start a compensating transaction
			cancelProductReservation(productReservedEvent, ex.getMessage());
			return;
		}
		
		if (userPaymentDetails == null) {
			// Start a compensating transaction
			cancelProductReservation(productReservedEvent, "Could not fetch user payment details");
			return;
		}
		
		LOGGER.info("Successfully fetched user payment details for user: " + userPaymentDetails.getFirstName());

		ProcessPaymentCommand processPaymentCommand = ProcessPaymentCommand.builder()
				.orderId(productReservedEvent.getOrderId())
				.paymentDetails(userPaymentDetails.getPaymentDetails())
				.paymentId(UUID.randomUUID().toString())
				.build();
		
		String result = null;
		try {
			result = commandGateway.sendAndWait(processPaymentCommand, 10, TimeUnit.SECONDS);
		}catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			// Start a compensating transaction
			cancelProductReservation(productReservedEvent, ex.getMessage());
		}
		
		if (result == null) {
			LOGGER.info("The ProcessPaymentCommand resulted in Null.class Initiating a compensating TX");
			// Start a compensating transaction
			cancelProductReservation(productReservedEvent, "Could not process used payment with provided payment details.");
		}
		
	}
	
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(PaymentProcessedEvent paymentProcessedEvent) {
		
		//Send an ApproveOrderCommand
		
		ApproveOrderCommand approveOrderCommand = 
				new ApproveOrderCommand(paymentProcessedEvent.getOrderId());
		
		commandGateway.send(approveOrderCommand);
	}
	
	@EndSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderApprovedEvent orderApprovedEvent) {
		
		LOGGER.info("Order is approved. Order Saga is complete for orderId: " + orderApprovedEvent.getOrderId());
		// SagaLifecycle.end();
	}
	
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(ProductReservationCancelledEvent productReservationCancelledEvent) {
		
		// Create and send a RejectOrderCommand
		RejectOrderCommand rejectOrderCommand = new RejectOrderCommand(
				productReservationCancelledEvent.getOrderId(),
				productReservationCancelledEvent.getReason());
		
		commandGateway.send(rejectOrderCommand);
	}
	
	@EndSaga
	@SagaEventHandler(associationProperty = "orderId")
	public void handle(OrderRejectedEvent orderRejectedEvent) {
		
		LOGGER.info("Successfully reject order with id : " + orderRejectedEvent.getOrderId());
	}
	
	private void cancelProductReservation(ProductReservedEvent productReservedEvent, String reason) {
		
		CancelProductReservationCommand cancelProductReservationCommand = 
				CancelProductReservationCommand.builder()
				.orderId(productReservedEvent.getOrderId())
				.productId(productReservedEvent.getProductId())
				.quantity(productReservedEvent.getQuantity())
				.userId(productReservedEvent.getUserId())
				.reason(reason)
				.build();
		
		commandGateway.send(cancelProductReservationCommand);
	}
}





