package com.mphasis.core.events;

import com.mphasis.core.model.OrderStatus;

import lombok.Value;

@Value
public class OrderRejectedEvent {

	private final String orderId;
	private final String reason;
	private OrderStatus orderStatus = OrderStatus.REJECTED;
}
