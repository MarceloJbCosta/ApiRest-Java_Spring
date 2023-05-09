package com.marceloapi.apirest.repositories;

import com.marceloapi.apirest.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
