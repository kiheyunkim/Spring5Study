package com.kiheyunkim.kim.Config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ViewResolverConfiguration implements WebMvcConfigurer{

	@Override
	public  void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		Map<String ,MediaType> mediaTypes = new HashMap<String, MediaType>();
		mediaTypes.put("html", MediaType.TEXT_HTML);
		mediaTypes.put("pdf", MediaType.valueOf("application/pdf"));
		mediaTypes.put("xls",MediaType.valueOf("application/vnd.ms-excel"));
		mediaTypes.put("xml", MediaType.APPLICATION_XML);
		mediaTypes.put("json",MediaType.APPLICATION_JSON);
	}
	
}
