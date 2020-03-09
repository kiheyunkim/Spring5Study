package com.Test.Spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("Fuckers");
		context.scan("com.Test.Spring");
		context.refresh();
		
		
		User user = context.getBean("nameUserFactoryBeanForDum", User.class);
		System.out.println(user.getName());
		
		User user2 = context.getBean("nameUserFactoryBeanForAsshole", User.class);
		System.out.println(user2.getName());
		
		context.close();
	}
}
