package com.prathamesh.DemoHibMappingManyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	private int rollNo;
	private String name;
	private String marks;
	@ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
	List<Laptop> laptops = new ArrayList<Laptop>();
	
	public Student(int rollNo, String name, String marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}
	
	public Student() {
		super();
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	
	public List<Laptop> getLaptop() {
		return laptops;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptops = laptop;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + ", laptops=" + laptops.toString() + "]";
	}
	
}
