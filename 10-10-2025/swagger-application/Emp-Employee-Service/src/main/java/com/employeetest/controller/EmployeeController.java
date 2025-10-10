package com.employeetest.controller;
 
import java.util.HashMap;
import java.util.Map;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employeetest.model.EmployeeModel;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
 
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getOrder/{id}")
	public Map<String, Object>getOrderdetails(@PathVariable int id){
		String url = "http://localhost:8082/Order/"+id;
		Map<String, Object> response = restTemplate.getForObject(url, Map.class);
		response.put("message", "order fetched successfully");
		return response;
		
	}
	@GetMapping("/Info")
	public String getOderInfo() {
		return "Order Completed";
	}
	
	@PostMapping("/post")
	public Map<String, Object> createEmployee(@RequestBody EmployeeModel employee) {
	    System.out.println("Received Employee: " + employee.getId() + ", " + employee.getName() + ", " + employee.getDepartment());

	    Map<String, Object> response = new HashMap<>();
	    response.put("employee", employee);
	    response.put("message", "Employee created successfully");
	    return response;
	}

 
}