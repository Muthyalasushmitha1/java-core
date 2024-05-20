package com.mphasis.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class PaymentEntity implements Serializable {
	
	private static final long serialVersionUID = -5365497269424757005L;

	@Id
	private String paymentId;

	@Column
	private String orderId;
}
