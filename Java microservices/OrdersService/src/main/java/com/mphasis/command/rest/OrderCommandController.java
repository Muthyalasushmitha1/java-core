package com.mphasis.command.rest;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.command.commands.CreateOrderCommand;
import com.mphasis.core.model.OrderStatus;
import com.mphasis.core.model.OrderSummary;
import com.mphasis.query.FindOrderQuery;

@RestController
@RequestMapping("/orders")
public class OrderCommandController {

	private final CommandGateway commandGateway;
	private final QueryGateway queryGateway;

	public OrderCommandController(CommandGateway commandGateway, QueryGateway queryGateway) {
		this.commandGateway = commandGateway;
		this.queryGateway = queryGateway;
	}
	
	@PostMapping
	public OrderSummary createOrder(@Valid @RequestBody OrderCreateRest order) throws InterruptedException, ExecutionException {
		
		String userId = "27b95829-4f3f-4ddf-8983-151ba010e35b";
		String orderId = UUID.randomUUID().toString();
		
		CreateOrderCommand createOrderCommand = CreateOrderCommand.builder()
				.addressId(order.getAddressId())
				.productId(order.getProductId())
				.userId(userId)
				.quantity(order.getQuantity())
				.orderId(orderId)
				.orderStatus(OrderStatus.CREATED).build();
		
		commandGateway.sendAndWait(createOrderCommand);
		
		System.out.println("OrderId:==================== " + orderId);
		
		FindOrderQuery findOrderQuery = new FindOrderQuery(orderId);
		OrderSummary orderSummary = queryGateway.query(findOrderQuery, 
				ResponseTypes.instanceOf(OrderSummary.class)).get();
		
		return orderSummary;
	}
}


