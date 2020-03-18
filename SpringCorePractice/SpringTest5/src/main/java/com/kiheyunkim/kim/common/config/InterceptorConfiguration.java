package com.kiheyunkim.kim.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kiheyunkim.kim.common.interceptor.MeasurementInterceptor;
import com.kiheyunkim.kim.common.interceptor.OtherInterceptor;

@EnableWebMvc
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
	
	@Bean
	public MeasurementInterceptor getMeasurementInterceptor() {
		return new MeasurementInterceptor();
	}
	
	@Bean
	public OtherInterceptor getOtherInterceptor() {
		return new OtherInterceptor();
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getMeasurementInterceptor());
		registry.addInterceptor(getOtherInterceptor())
			.addPathPatterns("/reservation*");
	}
}
