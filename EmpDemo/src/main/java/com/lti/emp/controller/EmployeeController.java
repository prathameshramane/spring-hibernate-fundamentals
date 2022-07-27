package com.lti.emp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.lti.emp.model.Employee;
import com.lti.emp.repo.EmployeeRepository;

@RestController  //RequestBody and controller
@CrossOrigin    //Cors policy
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp)
	{
		return employeeRepository.save(emp);
	}
	
	@GetMapping("/employees")
	public List<Employee> listEmployees(){
		List<Employee> ls = employeeRepository.findAll();
		
		return ls;
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee emp) {
		//Fix from stack overflow
		Optional<Employee> entity = employeeRepository.findById(id);
		Employee e = entity.get();
		e.setFirstName(emp.getFirstName());
		e.setLastName(emp.getLastName());
		e.setEmailId(emp.getEmailId());
		
		return employeeRepository.save(e);
	}
	
	@DeleteMapping("/employees/{id}")
//	@RequestMapping(value="/empdelete/{id}", method=RequestMethod.DELETE)
	public Employee delete(@PathVariable Long id) {
		Optional<Employee> entity = employeeRepository.findById(id);
		Employee e = entity.get();
		employeeRepository.delete(e);
		System.out.println("Deleted data:"+id);
//		System.out.println("Deleted record with ID:"+e.getId());
		return e;
	}

}
