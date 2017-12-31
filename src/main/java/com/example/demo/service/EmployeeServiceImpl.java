package com.example.demo.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo employeeRepository;

	@Override
	public List<EmployeeEntity> getALLEmployees() {

		return (List<EmployeeEntity>) employeeRepository.findAll();
	}

	@Override
	public EmployeeEntity getEmployeeByID(Long ID) {
		return employeeRepository.findOne(ID);
	}

	 @Override
	public List<EmployeeDTO> getEmployeeByName(String name) {
		List<EmployeeEntity> employeesList = (List<EmployeeEntity>) employeeRepository.findAll();
		List<EmployeeDTO> employeesListDTO = employeesList.stream()
				.filter(e -> e.getName().equals(name))
				.map(e -> converEmployeeEntityToDTO(e))
				.collect(Collectors.toList());
		employeesListDTO.sort((e1,e2)-> Long.compare(e1.getId(), e2.getId()));
		return employeesListDTO;
	}

	@Override
	public void deleteEmployee(Long ID) {
		employeeRepository.delete(getEmployeeByID(ID));
	}

	@Override
	public void updateEmployee(EmployeeDTO employee) {
		employeeRepository.save(convertEmployeeDTOToEntity(employee));
	}

	private EmployeeEntity convertEmployeeDTOToEntity(EmployeeDTO employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		employeeEntity.setCreated_by(employee.getCreated_by());
		employeeEntity.setCreated_date(employee.getCreated_date());
		employeeEntity.setLast_modified_by(employee.getLast_modified_by());
		employeeEntity.setModified_date(employee.getModified_date());
		employeeEntity.setName(employee.getName());
		employeeEntity.setPosition(employee.getPosition());

		return employeeEntity;
	}

	private EmployeeDTO converEmployeeEntityToDTO(EmployeeEntity employee) {
		EmployeeDTO employeeDTO = new EmployeeDTO();

		employeeDTO.setCreated_by(employee.getCreated_by());
		employeeDTO.setCreated_date(employee.getCreated_date());
		employeeDTO.setId(employee.getId());
		employeeDTO.setLast_modified_by(employee.getLast_modified_by());
		employeeDTO.setModified_date(employee.getModified_date());
		employeeDTO.setName(employee.getName());
		employeeDTO.setPosition(employee.getPosition());

		return employeeDTO;

	}

}
