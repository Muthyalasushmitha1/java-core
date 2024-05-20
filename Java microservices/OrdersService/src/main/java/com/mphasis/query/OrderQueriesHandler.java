package com.mphasis.query;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.mphasis.core.data.OrderEntity;
import com.mphasis.core.data.OrderRepository;
import com.mphasis.core.model.OrderSummary;

@Component
public class OrderQueriesHandler {

	private OrderRepository orderRepository;
	
	public OrderQueriesHandler(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@QueryHandler
	public OrderSummary	findOrder(FindOrderQuery findOrderQuery) {
		
		OrderEntity orderEntity = orderRepository.findByOrderId(findOrderQuery.getOrderId());
		System.out.println(orderEntity + "==============================");
		return new OrderSummary(orderEntity.getOrderId(), orderEntity.getOrderStatus(), "");
	}
}

