package com.example.service;

import com.example.DTO.EmployeeDTO;
import com.example.DTO.LoginDTO;
import com.example.response.LoginMesage;

public interface EmployeeService {

	public String addEmployee(EmployeeDTO employeeDTO) ;

	public LoginMesage loginEmployee(LoginDTO loginDTO);

}
