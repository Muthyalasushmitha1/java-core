package com.mphasis.command.rest;

import java.util.UUID;

import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.command.CreateProductCommand;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

	@Autowired
	private CommandGateway commandGateway;
	
	@PostMapping
	public String createProduct(@Valid @RequestBody CreateProductRestModel createProductRestModel) {

		CreateProductCommand createProductCommand = CreateProductCommand.builder()
				.price(createProductRestModel.getPrice())
				.quantity(createProductRestModel.getQuantity())
				.title(createProductRestModel.getTitle())
				.productId(UUID.randomUUID().toString())
				.build();
		
		String returnValue;
		//try {
			returnValue = commandGateway.sendAndWait(createProductCommand);			
		//} catch (Exception ex) {
		//	returnValue = ex.getLocalizedMessage();
		//}
		
		return returnValue;
	}
}
