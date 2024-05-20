package com.mphasis.command;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.mphasis.core.data.ProductLookupEntity;
import com.mphasis.core.data.ProductLookupRepository;
import com.mphasis.core.events.ProductCreatedEvent;

@Component
@ProcessingGroup("product-group")
public class ProductLookupEventsHandler {

	private ProductLookupRepository productLookupRepository;

	public ProductLookupEventsHandler(ProductLookupRepository productLookupRepository) {
		
		this.productLookupRepository = productLookupRepository;
	}

	@EventHandler
	public void on(ProductCreatedEvent event) {

		ProductLookupEntity productLookupEntity = new ProductLookupEntity(
				event.getProductId(), event.getTitle());
		
		productLookupRepository.save(productLookupEntity);
	}
}

