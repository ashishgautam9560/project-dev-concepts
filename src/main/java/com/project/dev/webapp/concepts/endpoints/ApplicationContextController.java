package com.project.dev.webapp.concepts.endpoints;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "application-context")
@Tag(name = "Application Context Controller")
@RequiredArgsConstructor
public class ApplicationContextController {

	private final ApplicationContext applicationContext;

	@Operation(summary = "It will provide all the beans present in the project", 
			   description = "This is the description of Monitor Lock", 
			   tags = {"Thread Controller" }, 
			   responses = { 
					  @ApiResponse(responseCode = "200", description = "Ok"),
					  @ApiResponse(responseCode = "400", description = "Bad Request") 
					  	   }
			  )
	@GetMapping("/beans")
	public List<String> getAllBeans() {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		return Arrays.asList(beanNames);
	}

}
