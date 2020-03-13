package com.Spring.Test2;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private Log log = LogFactory.getLog(LoggingAspect.class);
	
	@Before("execution(* *.getArea(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info("Before Aspect Called" + joinPoint.getSignature().getName() + " / "
				+ Arrays.toString(joinPoint.getArgs()));
	}
	
	@After("execution(* *.getArea(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info("After Aspect Called" + joinPoint.getSignature().getName() + " / "
				+ Arrays.toString(joinPoint.getArgs()));
	}
	
	/*
	 @AfterReturning(pointcut = "execution(* *.getArea(..))")
	public void logAfterReturning(JoinPoint joinPoint) {
		log.info("AfterReturning Aspect Called" + joinPoint.getSignature().getName() + " / "
				+ Arrays.toString(joinPoint.getArgs()));
	}
	 */
	
	
	@AfterReturning(pointcut = "execution(* *.getArea(..))",returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		log.info("AfterReturning Aspect Called" + joinPoint.getSignature().getName() + " / "
				+ Arrays.toString(joinPoint.getArgs()) + " return value " + result.toString());
	}
	
	/*
	@AfterThrowing(pointcut = "execution(* *.getArea(..))")
	public void logAfterThrowing(JoinPoint joinPoint) {
		log.info("AfterThrowing Aspect Called" + joinPoint.getSignature().getName() + " / "
				+ Arrays.toString(joinPoint.getArgs()));
	}
	*/
	
	@AfterThrowing(pointcut = "execution(* *.getArea(..))", throwing = "except")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable except) {
		log.info("AfterThrowing Aspect Called" + joinPoint.getSignature().getName() + " / "
				+ Arrays.toString(joinPoint.getArgs()) + "Exception: " + except.getMessage());
	}
}
