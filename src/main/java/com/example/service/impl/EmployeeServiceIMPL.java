package com.example.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.DTO.EmployeeDTO;
import com.example.DTO.LoginDTO;
import com.example.entity.EmployeeEntity;
import com.example.repository.EmployeeRepository;
import com.example.response.LoginMesage;
import com.example.service.EmployeeService;

@Service
public class EmployeeServiceIMPL implements EmployeeService {
	
    @Autowired
	private EmployeeRepository employeeRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override	
   public String addEmployee(EmployeeDTO employeeDTO){
	   EmployeeEntity emp=new EmployeeEntity(
			   
			employeeDTO.getEmployeeid(),
			employeeDTO.getEmployeename(),
			employeeDTO.getEmail(),
			this.passwordEncoder.encode(employeeDTO.getPassword())
			);
	   
			employeeRepository.save(emp); 
			return emp.getEmployeename();
		}

      @Override
      public LoginMesage loginEmployee(LoginDTO loginDTO) {
      EmployeeEntity emp1=employeeRepository.findByEmail(loginDTO.getEmail());
	  if(emp1 != null) {
		  String password =loginDTO.getPassword();
		  String encodedPassword=emp1.getPassword();
		  Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
		  if(isPwdRight) {
			  Optional<EmployeeEntity> employee= employeeRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
			  if(employee.isPresent()) {
				  return new LoginMesage( "Login Success", true);
			  }else {
				  return new LoginMesage("Login Failed", false);
			  }
		  }else {
			  return new LoginMesage("Password Not Match", false);
		  }
	  }else {
		  return new LoginMesage("Email Not Exits", false);
	  }
  }
}