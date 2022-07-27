package com.lti.emp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.emp.model.Department;
import com.lti.emp.repo.DepartmentRepository;

@RestController  //RequestBody and controller
@CrossOrigin    //Cors policy
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping("/departments")
	public Department createDepartment(@Valid @RequestBody Department dept) {
		return departmentRepository.save(dept);
	}
	
	@GetMapping("/departments")
	public List<Department> listDepartments(){
		List<Department> ls = departmentRepository.findAll();
		return ls;
	}
	

	@GetMapping("/departments/{dept_id}")
	public Department listDepartments(@PathVariable Long dept_id){
		Department dept = departmentRepository.findById(dept_id).orElse(new Department());
		System.out.println(dept.getEmployees().toString());
		return dept;
	}
	
	
	@DeleteMapping("/departments/{id}")
//	@RequestMapping(value="/empdelete/{id}", method=RequestMethod.DELETE)
	public Department delete(@PathVariable Long id) {
		Optional<Department> entity = departmentRepository.findById(id);
		Department e = entity.get();
		departmentRepository.delete(e);
		System.out.println("Deleted data:"+id);
//		System.out.println("Deleted record with ID:"+e.getId());
		return e;
	}
	
//	@RequestMapping("/handle")
//	 public ResponseEntity<String> handle() {
//	   URI location = ...;
//	   HttpHeaders responseHeaders = new HttpHeaders();
//	   responseHeaders.setLocation(location);
//	   responseHeaders.set("MyResponseHeader", "MyValue");
//	   return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
//	 }
	
//	@GetMapping("/employees/{id}")
//  public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
//      throws ResourceNotFoundException {
//      Employee employee = employeeRepository.findById(employeeId)
//        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//      return ResponseEntity.ok().body(employee);
//  }
}
