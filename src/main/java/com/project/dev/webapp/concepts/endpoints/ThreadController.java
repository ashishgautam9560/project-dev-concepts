package com.project.dev.webapp.concepts.endpoints;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "thread")
public class ThreadController {

	@GetMapping
	public ResponseEntity<String> analyzeThread() {

		return new ResponseEntity<>("Threads are working", HttpStatus.OK);
	}

}
