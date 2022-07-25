package com.prathamesh.SpringDemoAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {
	@Autowired
	Tyre tyre;
	
	public void drive() {
		System.out.println("Driving a car.");
	}

	@Override
	public String toString() {
		return "Car [tyre=" + tyre + "]";
	}
}
