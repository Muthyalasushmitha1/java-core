package com.mphasis.query;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.mphasis.core.model.PaymentDetails;
import com.mphasis.core.model.User;
import com.mphasis.core.query.FetchUserPaymentDetailsQuery;

@Component
public class UserEventsHandler {

	@QueryHandler
	public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {
		
		PaymentDetails paymentDetails = PaymentDetails.builder()
				.cardNumber("123Card")
				.cvv("123")
				.name("Manpreet Singh Bindra")
				.validUntilMonth(12)
				.validUntilYear(2030)
				.build();
		
		User user = User.builder()
				.firstName("Manpreet Singh")
				.lastName("Bindra")
				.userId(query.getUserId())
				.paymentDetails(paymentDetails)
				.build();
		
		return user;
	}
}
