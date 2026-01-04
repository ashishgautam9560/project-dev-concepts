package com.project.dev.webapp.concepts.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	@JsonProperty("EmployeeNo")
	private String empNo;

	@JsonProperty("BirthDate")
	private Date birthDate;

	@JsonProperty("FirstName")
	private String firstName;

	@JsonProperty("LastName")
	private String lastName;

	@JsonProperty("Gender")
	private String gender;

	@JsonProperty("HireDate")
	private Date hireDate;

}
