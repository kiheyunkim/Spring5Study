package com.Test.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext("com.Test.Test");
		
		ConfigClassTest test = context.getBean("configClass",ConfigClassTest.class);
		System.out.println(test.GetIndex());
		System.out.println(test.GetIndex());
		System.out.println(test.GetIndex());
		
		ConfigClassTest test2 = context.getBean("configClass",ConfigClassTest.class);
		System.out.println(test2.GetIndex());
		System.out.println(test2.GetIndex());
		System.out.println(test2.GetIndex());
		
		
		ConfigClassTestConfig test3 = context.getBean("configClassTestConfig",ConfigClassTestConfig.class);
		System.out.println(test3.ReturnValue());
		System.out.println(test3.ReturnValue());
		System.out.println(test3.ReturnValue());
	}
}
