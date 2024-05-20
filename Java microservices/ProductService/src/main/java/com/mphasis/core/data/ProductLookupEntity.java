package com.mphasis.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productlookup")
public class ProductLookupEntity implements Serializable{
	
	private static final long serialVersionUID = -414393874733686558L;

	@Id
	private String productId;
	
	@Column(unique = true)
	private String title;
}
