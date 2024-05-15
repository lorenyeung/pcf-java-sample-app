package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/error")
	public ResponseEntity<String> error() {
		return new ResponseEntity<String>("ERROR Response", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/warn")
	public ResponseEntity<String> warn() {
		return new ResponseEntity<String>("warn Response", HttpStatus.BAD_REQUEST);
	}

}
