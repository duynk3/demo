package com.example.demo.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import com.example.demo.entity.EmployeeEntity;

public interface EmployeeRepo extends  PagingAndSortingRepository<EmployeeEntity, Long>{

}
