package com.prathamesh.SpringAnno;

import org.springframework.stereotype.Component;

@Component
public class SnapDragon implements MobileProcessor {
	public void process() {
		System.out.println("World's Best Processor");
	}
}
