package com.kiheyunkim.kim.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
public class MeasurementInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime = (Long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		
		long endTime = System.currentTimeMillis();
		modelAndView.addObject("handlingTime",endTime - startTime);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) throws Exception {
	}
}
*/

public class MeasurementInterceptor implements AsyncHandlerInterceptor{
	public static final String START_TIME = "startTime";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(request.getAttribute(START_TIME) == null) {
			request.setAttribute(START_TIME, System.currentTimeMillis());
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime = (Long)request.getAttribute(START_TIME);
		request.removeAttribute(START_TIME);
		long endTime = System.currentTimeMillis();
		System.out.println("Response-Processing-Time: "+ (endTime - startTime) +"ms.");
		System.out.println("Response-processing-Thread: " + Thread.currentThread().getName());
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = (Long)request.getAttribute(START_TIME);
		request.setAttribute(START_TIME, System.currentTimeMillis());
		long endTime = System.currentTimeMillis();
		
		System.out.println("Request-Processing-Time: "+ (endTime - startTime) +"ms.");
		System.out.println("Request-processing-Thread: " + Thread.currentThread().getName());
	}
}