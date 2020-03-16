package com.kiheyunkim.kim.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.test.Servlet.MeasurementInterceptor;

@EnableWebMvc
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{

	
	@Bean
	public MeasurementInterceptor  measurementInterceptor() {
		return new MeasurementInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(measurementInterceptor())
				.addPathPatterns("/**");
	}
}
