package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;


public interface EmployeeService {
	
	public List<EmployeeEntity> getALLEmployees();
	public EmployeeEntity getEmployeeByID(Long ID);
	public List<EmployeeDTO> getEmployeeByName(String name);
	public void deleteEmployee(Long ID);
	public void updateEmployee(EmployeeDTO employee);
	

}
