package com.Test.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigClassTestConfig {
	
	@Autowired
	ConfigClassTest test;

	@Bean
	public String ReturnValue() {
		System.out.println(test);
		return new String(String.format("%d", test.GetIndex()));
	}
	
}
