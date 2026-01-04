package com.project.dev.webapp.concepts.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.dev.webapp.concepts.model.EmployeeDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EmployeeJdbcRepository {

	private final Properties queriesXml;

	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<EmployeeDto> getAllEmployees() {
		String query = queriesXml.getProperty("getAllEmployeesQuery");
		return namedParameterJdbcTemplate.query(query, rs -> {
			List<EmployeeDto> employeeDtos = new ArrayList<>();
			while (rs.next()) {
				EmployeeDto employeeDto = new EmployeeDto();
				employeeDto.setEmpNo(rs.getString("emp_no"));
				employeeDto.setBirthDate(rs.getDate("birth_date"));
				employeeDto.setFirstName(rs.getString("first_name"));
				employeeDto.setLastName(rs.getString("last_name"));
				employeeDto.setGender(rs.getString("gender"));
				employeeDto.setHireDate(rs.getDate("hire_date"));
				employeeDtos.add(employeeDto);
			}
			return employeeDtos;
		});
	}

	public List<EmployeeDto> getAllEmployeesRowMapper() {
		String query = queriesXml.getProperty("getAllEmployeesQuery");
		return namedParameterJdbcTemplate.query(query, (rs, rowNum) -> {
			log.info("rowNum: {}", rowNum);
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setEmpNo(rs.getString("emp_no"));
			employeeDto.setBirthDate(rs.getDate("birth_date"));
			employeeDto.setFirstName(rs.getString("first_name"));
			employeeDto.setLastName(rs.getString("last_name"));
			employeeDto.setGender(rs.getString("gender"));
			employeeDto.setHireDate(rs.getDate("hire_date"));
			return employeeDto;
		});

	}

}
