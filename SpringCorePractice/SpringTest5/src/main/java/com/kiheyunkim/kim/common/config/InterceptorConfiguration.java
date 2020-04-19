package com.kiheyunkim.kim.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.kiheyunkim.kim.common.interceptor.OtherInterceptor;
import com.kiheyunkim.kim.common.config.MeasurementInterceptor;
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
		
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getMeasurementInterceptor());
		registry.addInterceptor(getOtherInterceptor())
			.addPathPatterns("/reservation*");
	}
	
	
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.setDefaultTimeout(1000000);
		configurer.setTaskExecutor(mvcTaskExcutor());
	}
	
	@Bean
	public ThreadPoolTaskExecutor mvcTaskExcutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setThreadGroupName("mvc-executor");
		return taskExecutor;
	}

}
