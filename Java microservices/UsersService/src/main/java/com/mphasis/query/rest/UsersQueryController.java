package com.mphasis.query.rest;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.core.model.User;
import com.mphasis.core.query.FetchUserPaymentDetailsQuery;

@RestController
@RequestMapping("/users")
public class UsersQueryController {

	@Autowired
	private QueryGateway queryGateway;

	@GetMapping("/{userId}/payments-details")
	public User getUserPaymentDetails(@PathVariable String userId ) {
		
		FetchUserPaymentDetailsQuery query = new FetchUserPaymentDetailsQuery(userId);
		
		return queryGateway.query(query, ResponseTypes.instanceOf(User.class)).join();
	}
}
