package com.project.dev.webapp.concepts.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.project.dev.webapp.concepts.model.EmployeeDto;

public class EmployeeMapper implements ResultSetExtractor<List<EmployeeDto>> {

	@Override
	public List<EmployeeDto> extractData(ResultSet rs) throws SQLException, DataAccessException {
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
	}

}
