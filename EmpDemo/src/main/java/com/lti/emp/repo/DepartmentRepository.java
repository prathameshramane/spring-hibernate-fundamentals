package com.lti.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.emp.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
