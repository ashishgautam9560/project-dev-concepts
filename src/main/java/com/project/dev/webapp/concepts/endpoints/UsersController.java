package com.project.dev.webapp.concepts.endpoints;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dev.webapp.concepts.entity.Users;
import com.project.dev.webapp.concepts.service.UsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "users")
@RequiredArgsConstructor
@Slf4j
public class UsersController {

	private final UsersService usersService;

	@GetMapping(value = "all")
	public ResponseEntity<List<Users>> getAllEmployees() {
		log.info("Starting API Call");
		return new ResponseEntity<>(usersService.getAllCreds(), HttpStatus.OK);
	}

}
