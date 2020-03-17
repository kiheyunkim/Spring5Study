package com.kiheyunkim.kim.common.config;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringServletContainerInitializer implements ServletContainerInitializer{

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		// TODO Auto-generated method stub
		AnnotationConfigWebApplicationContext applicationContext =	new AnnotationConfigWebApplicationContext();
		applicationContext.register(SpringConfiguration.class);
		
		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
		ServletRegistration.Dynamic courtRegistration = ctx.addServlet("kim", dispatcherServlet);
		courtRegistration.setLoadOnStartup(1);
		courtRegistration.addMapping("/");
	}
}