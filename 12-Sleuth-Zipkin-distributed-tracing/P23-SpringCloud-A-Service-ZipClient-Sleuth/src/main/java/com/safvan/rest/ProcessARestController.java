package com.safvan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ProcessARestController {
	
	@Autowired
	private RestTemplate rt;
	
	@GetMapping("/showA")
	public String showMsg() {
		log.info("WE ARE AT A SERVICE...");
		
		String resp = rt.getForEntity("http://localhost:8082/showB", String.class).getBody();
		
		return "FROM A.."+resp;
	}
}
