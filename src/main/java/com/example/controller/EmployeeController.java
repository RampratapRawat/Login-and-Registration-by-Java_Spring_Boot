package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.DTO.EmployeeDTO;
import com.example.DTO.LoginDTO;
import com.example.response.LoginMesage;
import com.example.service.EmployeeService;
import com.example.service.impl.EmployeeServiceIMPL;

@RestController
@CrossOrigin

public class EmployeeController {
    
	private EmployeeServiceIMPL employeeServiceIMPL;
	
	
	@GetMapping("/ok")
	public String run() {
		return "your program is running";
	}
	
    @PostMapping("/save")
	public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
    	String id=employeeServiceIMPL.addEmployee(employeeDTO);
    	return id;
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){
    	LoginMesage loginMesage= employeeServiceIMPL.loginEmployee(loginDTO);
    	return ResponseEntity.ok(loginMesage);
    }
}
