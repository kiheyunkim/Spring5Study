package com.Test.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dinfo.properties")
public class ConfigClassTestConfig {

	@Value("${somevalue.hi:1}")
	public int value;
	
	@Autowired
	ConfigClassTest test = new ConfigClassTest();

	@Bean
	public String ReturnValue() {
		System.out.println("value " + value);
		return new String(String.format("%d", test.GetIndex()));
	}
	
}
