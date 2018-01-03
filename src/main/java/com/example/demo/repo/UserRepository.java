package com.example.demo.repo;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
}
