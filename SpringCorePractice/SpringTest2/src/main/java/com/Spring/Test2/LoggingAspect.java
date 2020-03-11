package com.Spring.Test2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private Log log = LogFactory.getLog(LoggingAspect.class);
	
	//@Before("execution(* com.Spring.Shape.Shape.getArea(..))")
	@Before("execution(* com.Spring.Shape.getArea.*(..))")
	public void logBefore() {
		log.info("Method getArea Called");
	}
}
