package com.cafe24.zipkin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {
	
	@Autowired
	RestTemplate restTemplate;

	public String testZipkin() {
		String endpoint = "http://localhost:8888/jgmall-api/api/admin";
		String result = restTemplate.getForObject(endpoint, String.class);
		return result;
	}
	
}
