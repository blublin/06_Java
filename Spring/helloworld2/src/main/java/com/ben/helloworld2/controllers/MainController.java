package com.ben.helloworld2.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController  {
	
	@RequestMapping("/")
	public String index() {
		return "Hello World!";
	}
	
	@RequestMapping(value="/cool",  method=RequestMethod.GET)
	public String coolRoute() {
		return "This is cool!";
	}
	
	@RequestMapping("/search")
	public String searchRoute(@RequestParam(value="q", required = false) String searchQuery) {
		// q is the url variable after the route:
		// http://localhost:8080/search?q=searchQuery+stuff		
		return "You searched for " + searchQuery;
	}
	
	@RequestMapping("/find/{varName}")
	public String findRoute(@PathVariable("varName") String varName) {
		return "You're at " + varName;
	}
	
	
	
}
