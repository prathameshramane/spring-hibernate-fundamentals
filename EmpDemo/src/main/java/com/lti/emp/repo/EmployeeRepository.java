package com.lti.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lti.emp.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
