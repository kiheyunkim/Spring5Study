package com.Spring.ShapeConfig;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class LoggingAspect /*implements Ordered*/{
	private Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* *.getArea(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info("Before Aspect Called" + joinPoint.getSignature().getName() + " / "
				+ Arrays.toString(joinPoint.getArgs()));
		
		
		log.info("JoinPoint Info\n");
		log.info("Join point kind : {}", joinPoint.getKind());
		log.info("Signature declaring type : {}", joinPoint.getSignature().getDeclaringTypeName());
		log.info("Join point kind : {}", joinPoint.getSignature().getName());
		log.info("Join point kind : {}", Arrays.toString(joinPoint.getArgs()));
		log.info("Traget class : {}", joinPoint.getTarget().getClass().getName());
		log.info("This class : {}", joinPoint.getThis().getClass().getName());
		
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
