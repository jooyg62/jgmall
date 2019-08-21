package com.cafe24.zipkin.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("mainController")
public class MainController {
	
	private static final Logger LOG = Logger.getLogger(MainController.class.getName());
	
	@RequestMapping("/")
	public String index() {
	      LOG.log(Level.INFO, "Index API is calling");
	      return "Welcome Sleuth!";
	}
	
}
