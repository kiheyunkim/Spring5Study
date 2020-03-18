package com.kiheyunkim.kim.common.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@EnableWebMvc
@Configuration
public class I18NConfiguration implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(localeInterceptor());
	}
	
	@Bean
	public LocaleChangeInterceptor localeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		return localeChangeInterceptor;
	}
	
	/*
	@Bean
	public LocaleResolver sessionLocaleResolver() {
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(new Locale("en"));
		
		return sessionLocaleResolver;
	}
	*/
	@Bean(name = {"localeResolver"})
	public LocaleResolver cookieLocaleResolver() {
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setCookieName("language");
		cookieLocaleResolver.setCookieMaxAge(3600);
		cookieLocaleResolver.setDefaultLocale(new Locale("en"));
		
		return cookieLocaleResolver;
	}
}
