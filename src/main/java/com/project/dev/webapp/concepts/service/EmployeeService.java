package com.project.dev.webapp.concepts.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.project.dev.webapp.concepts.model.EmployeeDto;
import com.project.dev.webapp.concepts.repository.EmployeeJdbcRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeJdbcRepository employeeJdbcRepository;

	public List<EmployeeDto> getAllEmployees() {
		return employeeJdbcRepository.getAllEmployeesRowMapper();
	}

	public String getEmployeeNameById(Integer id) {
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(id.toString());
		
		if (matcher.matches()) {
			return "Employee Id: " + id;
		} else {
			return "Invalid ID Format";
		}
	}

}
