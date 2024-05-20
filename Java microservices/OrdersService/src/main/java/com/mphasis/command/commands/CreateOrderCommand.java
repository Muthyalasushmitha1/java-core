package com.mphasis.command.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.mphasis.core.model.OrderStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrderCommand {

	@TargetAggregateIdentifier
	private final String orderId;
	
	private final String userId;
	private final String productId;
	private final int quantity;
	private final String addressId;
	private final OrderStatus orderStatus;
}
