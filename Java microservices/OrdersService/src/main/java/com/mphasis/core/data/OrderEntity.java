package com.mphasis.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mphasis.core.model.OrderStatus;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = -3487330166281575449L;

	@Id
	@Column(unique = true)
	private String orderId;
	private String productId;
	private String userId;
	private int quantity;
	private String addressId;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
}
