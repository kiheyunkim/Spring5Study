package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Spring Bean Container + Spring Bean Configuration Class를 Load
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		//Application Type 변경
		SpringApplication application = new SpringApplication(DemoApplication.class);
		
		application.setWebApplicationType(WebApplicationType.SERVLET);//Servlet 기본
		
		application.run(args);
	}

}
