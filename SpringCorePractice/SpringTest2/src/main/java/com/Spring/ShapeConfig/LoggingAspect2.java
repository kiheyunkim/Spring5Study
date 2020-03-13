package com.Spring.ShapeConfig;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect2 /*implements Ordered*/{
	private Logger log = LoggerFactory.getLogger(LoggingAspect2.class);
	
	//@Pointcut("")
	//private void logginOperation() {}
	
	@Before("@annotation(com.Spring.ShapeConfig.LoggingRequired)")
	public void logBefore(JoinPoint joinPoint) {	
		log.info("Before Aspect Called222" + joinPoint.getSignature().getName() + " / "
				+ Arrays.toString(joinPoint.getArgs()));
	}
	
	//@After("logginOperation()")
	public void logAfter(JoinPoint joinPoint) {
		log.info("After Aspect Called2" + joinPoint.getSignature().getName() + " / "
				+ Arrays.toString(joinPoint.getArgs()));
	}
}
