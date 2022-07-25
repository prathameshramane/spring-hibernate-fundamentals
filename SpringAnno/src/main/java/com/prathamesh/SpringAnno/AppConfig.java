package com.prathamesh.SpringAnno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.prathamesh.SpringAnno")
public class AppConfig {
//	@Bean
//	public Samsung getSamsung() {
//		return new Samsung();
//	}
//	@Bean
//	public SnapDragon getSnapDragon() {
//		return new SnapDragon();
//	}
//	@Bean
//	@Primary
//	public MediaTek getMediaTek() {
//		return new MediaTek();
//	}
}
