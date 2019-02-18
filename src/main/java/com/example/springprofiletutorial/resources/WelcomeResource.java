package com.example.springprofiletutorial.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springprofiletutorial.config.BasicConfiguration;

@RestController
public class WelcomeResource {

	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Autowired
	private BasicConfiguration configuration;
	
	@GetMapping("/welcome")
	public String retrieveWelcomeMessage() {
		return welcomeMessage;
	}
	
	@RequestMapping("/dynamic-configuration")
	public Map<String,Object> dynamicConfiguration(){
		Map<String,Object> map = new HashMap<>();
		map.put("message", configuration.getMessage());
	    map.put("number", configuration.getNumber());
	    map.put("key", configuration.isValue());
		return map;
	}
}
