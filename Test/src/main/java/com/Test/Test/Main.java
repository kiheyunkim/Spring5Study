package com.Test.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class Main {

	public static void main(String[] args) throws IOException {
		
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
		
		Resource resource = new ClassPathResource("dinfo.properties");
		Properties props = PropertiesLoaderUtils.loadProperties(resource);
		
		System.out.println(props);
		
		
		String alert = context.getMessage("alert.checkout",null,Locale.US);
		System.out.println(alert);
	}
}
