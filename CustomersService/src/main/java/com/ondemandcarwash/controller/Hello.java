package com.ondemandcarwash.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class Hello {
@GetMapping("/hello")
	public String sayHello() {
		return" hello from customer";
	}
}
