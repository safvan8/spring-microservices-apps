package com.safvan.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable{

	private static final long serialVersionUID = -6996089775081523197L;
	
	private Integer stdId;
	private String stdName;
	private Double stdFee;
	

}
