package com.mphasis.query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mphasis.core.data.OrderEntity;
import com.mphasis.core.data.OrderRepository;
import com.mphasis.core.events.OrderCreatedEvent;
import com.mphasis.core.events.OrderRejectedEvent;
import com.mphasis.core.model.OrderApprovedEvent;

@Component
@ProcessingGroup("order-group")
public class OrderEventsHandler {

	private final OrderRepository orderRepository;
	
	public OrderEventsHandler(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@EventHandler
	public void on(OrderCreatedEvent event) throws Exception {
		
		OrderEntity orderEntity = new OrderEntity();
		BeanUtils.copyProperties(event, orderEntity);
		
		orderRepository.save(orderEntity);
	}
	
	@EventHandler
	public void on(OrderApprovedEvent event) throws Exception {
		
		OrderEntity orderEntity = orderRepository.findByOrderId(event.getOrderId());
		if (orderEntity == null) {
			//TODO: Do something about ids
			return;
		}
		orderEntity.setOrderStatus(event.getOrderStatus());
		orderRepository.save(orderEntity);
	}
	
	@EventHandler
	public void on(OrderRejectedEvent event) throws Exception {
		
		OrderEntity orderEntity = orderRepository.findByOrderId(event.getOrderId());
		
		orderEntity.setOrderStatus(event.getOrderStatus());
		
		orderRepository.save(orderEntity);
	}
}
