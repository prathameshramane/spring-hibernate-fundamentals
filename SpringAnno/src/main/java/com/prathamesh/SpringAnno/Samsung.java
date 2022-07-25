package com.prathamesh.SpringAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Samsung {
	
	@Autowired
	@Qualifier("snapDragon")
	MobileProcessor processor;
	
	public void config() {
		System.out.println("RAM 4GB, Octa Core, 12MP Camera");
		processor.process();
	}
}
