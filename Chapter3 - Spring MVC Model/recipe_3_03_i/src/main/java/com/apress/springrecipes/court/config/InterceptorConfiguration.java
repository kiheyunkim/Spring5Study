package com.apress.springrecipes.court.config;

import com.apress.springrecipes.court.web.MeasurementInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(measurementInterceptor());
        registry.addInterceptor(measurementInterceptor())
        	.addPathPatterns("/reservationSummary*");	//특정  URL에 매핑
    }

    @Bean
    public MeasurementInterceptor measurementInterceptor() {
        return new MeasurementInterceptor();
    }
}
