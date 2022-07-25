package com.prathamesh.DemoHibMappingManyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Laptop {
	@Id
	private int lid;
	private String brand;
	@ManyToMany
	private List<Student> students = new ArrayList<Student>();
	
	public Laptop(int lid, String brand) {
		super();
		this.lid = lid;
		this.brand = brand;
	}
	
	public Laptop() {
		super();
	}

	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public  List<Student>  getStudent() {
		return students;
	}

	public void setStudent( List<Student>  student) {
		this.students = student;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + "]";
	}
	
}
