package com.kiheyunkim.kim.common.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@Configuration
public class ViewResolverConfiguration implements WebMvcConfigurer, ResourceLoaderAware  {

	private ResourceLoader resourceLoader;
	
	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	@Bean
	public ViewResolver viewResolver() {
		XmlViewResolver viewResolver = new XmlViewResolver();
		viewResolver.setLocation(resourceLoader.getResource("/WEB-INF/court-view.xml"));
		return viewResolver;
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
		mediaTypes.put("html",MediaType.TEXT_HTML);
		mediaTypes.put("pdf",MediaType.valueOf("application/pdf"));
		mediaTypes.put("xls",MediaType.valueOf("application/vnd.ms-excel"));
		mediaTypes.put("xml", MediaType.APPLICATION_XML);
		mediaTypes.put("json",MediaType.APPLICATION_JSON);
		configurer.mediaTypes(mediaTypes);
		// TODO Auto-generated method stub
	}
	
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver
		(ContentNegotiationManager contentNegotiationManager) {
		ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
		viewResolver.setContentNegotiationManager(contentNegotiationManager);
		return viewResolver;
	}
	
	/*
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	*/
}
