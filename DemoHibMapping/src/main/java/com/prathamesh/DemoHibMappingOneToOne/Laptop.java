package com.prathamesh.DemoHibMappingOneToOne;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {
	@Id
	private int lid;
	private String brand;
	
	public Laptop(int lid, String brand) {
		super();
		this.lid = lid;
		this.brand = brand;
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
	
}
