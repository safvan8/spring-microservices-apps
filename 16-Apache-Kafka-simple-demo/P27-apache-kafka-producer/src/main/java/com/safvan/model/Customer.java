package com.safvan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class serving as model to hold data
 * 
 * @author Ashok
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private Integer customerId;
	private String customerName;
	private String customerEmail;
}
