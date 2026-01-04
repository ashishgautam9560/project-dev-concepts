package com.project.dev.webapp.concepts.endpoints;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dev.webapp.concepts.model.EmployeeDto;
import com.project.dev.webapp.concepts.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

	private final EmployeeService employeeService;

	@GetMapping(value = "all")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
		log.info("Starting API Call");
		return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
	}

}
