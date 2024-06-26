package com.mphasis.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.mphasis.command.commands.ApproveOrderCommand;
import com.mphasis.command.commands.CreateOrderCommand;
import com.mphasis.command.commands.RejectOrderCommand;
import com.mphasis.core.events.OrderCreatedEvent;
import com.mphasis.core.events.OrderRejectedEvent;
import com.mphasis.core.model.OrderApprovedEvent;
import com.mphasis.core.model.OrderStatus;

@Aggregate
public class OrderAggregate {

	@AggregateIdentifier
	private String orderId;
	private String productId;
	private String userId;
	private int quantity;
	private String addressId;
	private OrderStatus orderStatus;
	
	public OrderAggregate() {
	}
	
	@CommandHandler
	public OrderAggregate(CreateOrderCommand createOrderCommand) {
		
		OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent();
		BeanUtils.copyProperties(createOrderCommand, orderCreatedEvent);
		
		AggregateLifecycle.apply(orderCreatedEvent);
	}
	
	@EventSourcingHandler
	public void on(OrderCreatedEvent orderCreatedEvent) throws Exception {
		this.orderId = orderCreatedEvent.getOrderId();
		this.productId = orderCreatedEvent.getProductId();
		this.userId = orderCreatedEvent.getUserId();
		this.addressId = orderCreatedEvent.getAddressId();
		this.quantity = orderCreatedEvent.getQuantity();
		this.orderStatus = orderCreatedEvent.getOrderStatus();
	}
	
	@CommandHandler
	public void handle(ApproveOrderCommand approveOrderCommand) {
		
		// Create and publish the OrderApprovedEvent
		OrderApprovedEvent orderApprovedEvent = new OrderApprovedEvent(approveOrderCommand.getOrderId());
		AggregateLifecycle.apply(orderApprovedEvent);
	}
	
	@EventSourcingHandler
	public void on(OrderApprovedEvent orderApprovedEvent) {
		
		this.orderStatus = orderApprovedEvent.getOrderStatus();
	}
	
	@CommandHandler
	public void handle(RejectOrderCommand rejectOrderCommand) {
		
		// BL
		
		// Create and publish the OrderRejectEvent
		OrderRejectedEvent orderRejectedEvent = new OrderRejectedEvent(
				rejectOrderCommand.getOrderId(), rejectOrderCommand.getReason());
		
		AggregateLifecycle.apply(orderRejectedEvent);
	}
	
	@EventSourcingHandler
	public void on(OrderRejectedEvent orderRejectedEvent) {
		
		this.orderStatus = orderRejectedEvent.getOrderStatus();
	}
}
