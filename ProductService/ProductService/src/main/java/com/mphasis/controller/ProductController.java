package com.mphasis.controller;

<<<<<<< HEAD
=======
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
>>>>>>> d73e6efae190e71d9834bf0eef33322b0a7b24fb
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

=======
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.command.CreateProductCommand;

>>>>>>> d73e6efae190e71d9834bf0eef33322b0a7b24fb
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private Environment env;
	
<<<<<<< HEAD
	@PostMapping
	public String createProduct() {
		return " HTTP POST Handled";
	}
	
=======
	@Autowired
	private CommandGateway commandGateway;
	
	@PostMapping
	public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
		
		CreateProductCommand createProductCommand = CreateProductCommand.builder()
		.price(createProductRestModel.getPrice())
		.quantity(createProductRestModel.getQuantity())
		.title(createProductRestModel.getTitle())
		.productId(UUID.randomUUID().toString())
		.build();
		
		String returnValue;
		
		try {
			returnValue = commandGateway.sendAndWait(createProductCommand);
		}catch (Exception ex) {
			returnValue = ex.getLocalizedMessage();
		}
		return returnValue;
	}

>>>>>>> d73e6efae190e71d9834bf0eef33322b0a7b24fb
	@GetMapping
	public String getProduct() {
		return " HTTP GET Handled: " + env.getProperty("local.server.port");
	}
	
	@PutMapping
	public String updateProduct() {
		return " HTTP PUT Handled";
	}
	
	@DeleteMapping
	public String deleteProduct() {
		return " HTTP DELETE Handled";
	}
}
