package com.cafe24.zipkin.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.zipkin.service.MainService;

@RestController("mainController")
public class MainController {
	
	private static final Logger LOG = Logger.getLogger(MainController.class.getName());
	
	@Autowired
	MainService mainService;
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		LOG.log(Level.INFO, "mainController");
		String result = mainService.testZipkin();
		LOG.log(Level.INFO, "Index API is calling");
		return result;
	}
	
}
