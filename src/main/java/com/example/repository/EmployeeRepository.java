package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.EmployeeEntity;



public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	Optional<EmployeeEntity> findOneByEmailAndPassword(String email, String encodedPassword);

	EmployeeEntity findByEmail(String email);

}
