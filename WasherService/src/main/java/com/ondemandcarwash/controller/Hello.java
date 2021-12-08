package com.ondemandcarwash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/washer")
public class Hello {

	@GetMapping("/hello")
public String sayhello() {
	return" hello from washer";
}
}
