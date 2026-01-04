package com.project.dev.webapp.concepts.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.project.dev.webapp.concepts.model.EmployeeDto;

public class EmpRowMapper implements RowMapper<EmployeeDto> {

	/**
	 * RowMapper implementation to map each row of the ResultSet to an instance of
	 * EmployeeDto.
	 *
	 * The JdbcTemplate automatically iterates through all rows and collects the
	 * mapped objects into a List.
	 *
	 * logger(rowNum) - 0 to 999 it will print
	 */

	@Override
	public EmployeeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmpNo(rs.getString("emp_no"));
		employeeDto.setBirthDate(rs.getDate("birth_date"));
		employeeDto.setFirstName(rs.getString("first_name"));
		employeeDto.setLastName(rs.getString("last_name"));
		employeeDto.setGender(rs.getString("gender"));
		employeeDto.setHireDate(rs.getDate("hire_date"));
		return employeeDto;
	}
}