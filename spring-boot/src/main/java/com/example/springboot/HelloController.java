package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

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
	@GetMapping("/javaopts")
	public ResponseEntity<String> javaopts() {
		RuntimeMXBean mxBean = ManagementFactory.getRuntimeMXBean();
		System.out.println("beans");
		System.out.println(mxBean.getInputArguments());
		String javaopts = System.getenv("JAVA_OPTS");
		String cfinstanceindex = System.getenv("CF_INSTANCE_INDEX");
		return new ResponseEntity<String>("beans:"+mxBean.getInputArguments()+" envar:"+javaopts + " index:"+ cfinstanceindex,HttpStatus.OK);
	}

}
