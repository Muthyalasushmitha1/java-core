package com.mphasis.query;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mphasis.core.data.ProductEntity;
import com.mphasis.core.data.ProductRepository;
import com.mphasis.query.rest.ProductRestModel;

@Component
//@Service
public class ProductQueryHandler {

	private ProductRepository productRepository;

	public ProductQueryHandler(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@QueryHandler
	public List<ProductRestModel> findProducts(FindProductsQuery findProductsQuery) {
				
		List<ProductRestModel> productsRest = new ArrayList<>();
		
		List<ProductEntity> storedProducts = productRepository.findAll();
		
		for (ProductEntity productEntity : storedProducts) {
			
			ProductRestModel productRestModel = new ProductRestModel();
			BeanUtils.copyProperties(productEntity, productRestModel);
			productsRest.add(productRestModel);
		}
		
		return productsRest;
	}
}




