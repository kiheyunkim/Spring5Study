package com.Test.Spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableAspectJAutoProxy
@Profile("Fuckers")
public class UserConfig {
	@Scope("prototype")
	@Bean//(initMethod = "fuckFront", destroyMethod = "fuckBack")
	public User createUser() {
		return new User();
	}
	
	@Bean
	public NameUserFactoryBean nameUserFactoryBeanForDum() {
		NameUserFactoryBean factory = new NameUserFactoryBean();
		factory.setUser(createUser());
		factory.setName("¸ÛÃ»ÀÌ");
		return factory;
	}
	
	@Bean
	public NameUserFactoryBean nameUserFactoryBeanForAsshole() {
		NameUserFactoryBean factory = new NameUserFactoryBean();
		factory.setUser(createUser());
		factory.setName("³ª»Û³ð");
		return factory;
	}
}
