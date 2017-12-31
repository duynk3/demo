package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeService;

import util.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<?> getAllEmployees() {
		List<EmployeeEntity> employee;
			employee = employeeService.getALLEmployees();
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		try {
			employeeService.updateEmployee(employeeDTO);
		}catch(Exception e) {
			return new ResponseEntity<String>(Constant.MSG_INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(Constant.CREATE_EMPLOYEE_SUCCESSFUL, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/getbyname", method = RequestMethod.POST)
	public ResponseEntity<?> getEmployeeByName(@RequestHeader(value="name", required=true) String  employeeName) {
		List<EmployeeDTO> employee;
		try {
			employee = employeeService.getEmployeeByName(employeeName);
		}catch(Exception e) {
			return new ResponseEntity<String>(Constant.MSG_INTERNAL_SERVER_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}
	

}
