package com.mphasis.query;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mphasis.core.data.ProductEntity;
import com.mphasis.core.data.ProductRepository;
import com.mphasis.core.events.ProductCreatedEvent;
import com.mphasis.core.events.ProductReservationCancelledEvent;
import com.mphasis.core.events.ProductReservedEvent;

@Component
//@Service
@ProcessingGroup("product-group")
public class ProductEventsHandler {

	private final ProductRepository productRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductEventsHandler.class);

	public ProductEventsHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@ExceptionHandler(resultType = IllegalArgumentException.class)
	public void handle(IllegalArgumentException exception) {
		//log error message
		throw exception;
	}

	@ExceptionHandler(resultType = Exception.class)
	public void handle(Exception exception) throws Exception {
		//log error message		
		throw exception;
	}

	@EventHandler
	public void on(ProductCreatedEvent productCreatedEvent) throws Exception {
		
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(productCreatedEvent, productEntity);
		
		productRepository.save(productEntity);
		
		/*if (true) {
			throw new Exception("Forcing exception in the Event Handler class");
		}*/
	}
	
	@EventHandler
	public void on(ProductReservedEvent productReservedEvent) {
		
		ProductEntity productEntity = productRepository.findByProductId(productReservedEvent.getProductId());
		productEntity.setQuantity(productEntity.getQuantity() - productReservedEvent.getQuantity());
		productRepository.save(productEntity);
		
		LOGGER.info("ProductReservedEvent is called for productId: " + productReservedEvent.getProductId() +
				" and orderId: " + productReservedEvent.getOrderId());
		
	}
	
	@EventHandler
	public void on(ProductReservationCancelledEvent productReservationCancelledEvent) {
		
		ProductEntity currentlyStoredProduct =
				productRepository.findByProductId(productReservationCancelledEvent.getProductId());
		
		int newQuantity = currentlyStoredProduct.getQuantity() + productReservationCancelledEvent.getQuantity();
		currentlyStoredProduct.setQuantity(newQuantity);
		
		productRepository.save(currentlyStoredProduct);
	}
}





