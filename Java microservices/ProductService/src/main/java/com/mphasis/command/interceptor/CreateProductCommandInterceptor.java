package com.mphasis.command.interceptor;

import java.util.List;
import java.util.function.BiFunction;

import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mphasis.command.CreateProductCommand;
import com.mphasis.core.data.ProductLookupEntity;
import com.mphasis.core.data.ProductLookupRepository;

@Component
public class CreateProductCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

	private final ProductLookupRepository productLookupRepository;
	
	public CreateProductCommandInterceptor(ProductLookupRepository productLookupRepository) {
		this.productLookupRepository = productLookupRepository;
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreateProductCommandInterceptor.class);

	@Override
	public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(
			List<? extends CommandMessage<?>> messages) {

		return (index, command) -> {

			LOGGER.info("Intercepted command: " + command.getPayloadType());
			
			if (CreateProductCommand.class.equals(command.getPayloadType())) {

				CreateProductCommand createProductCommand = (CreateProductCommand) command.getPayload();
				
				ProductLookupEntity productLookupEntity = 
						productLookupRepository.findByProductIdOrTitle(
								createProductCommand.getProductId(), createProductCommand.getTitle());
				
				if (productLookupEntity != null) {
					
					throw new IllegalStateException(
							String.format("Product with product %s or title %s already exist", 
									createProductCommand.getProductId(),
									createProductCommand.getTitle()));
				}	
			}
			
			/*
			if (CreateProductCommand.class.equals(command.getPayloadType())) {

				CreateProductCommand createProductCommand = (CreateProductCommand) command.getPayload();

				// Validate Create Product Command
				if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
					throw new IllegalArgumentException("Intercepted: Price cannot be less than or equal to zero");
				}

				if (createProductCommand.getTitle() == null || createProductCommand.getTitle().isEmpty()) {
					throw new IllegalArgumentException("Intercepted: Title cannot be empty");
				}
			}
			*/
			
			return command;
		};
	}

}
