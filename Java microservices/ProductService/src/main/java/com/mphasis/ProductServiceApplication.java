package com.mphasis;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;

import com.mphasis.command.interceptor.CreateProductCommandInterceptor;
import com.mphasis.core.errorhandling.ProductsServiceEventsErrorHandler;

@EnableEurekaClient
@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Autowired
	public void registerCreateProductCommandInterceptor(
			ApplicationContext context, CommandBus commandBus) {
		
		commandBus.registerDispatchInterceptor(context.getBean(CreateProductCommandInterceptor.class));
	}
	
	@Autowired
	public void configure(EventProcessingConfigurer configurer) {
		
		configurer.registerListenerInvocationErrorHandler("product-group", 
				config -> new ProductsServiceEventsErrorHandler());
	}
}

