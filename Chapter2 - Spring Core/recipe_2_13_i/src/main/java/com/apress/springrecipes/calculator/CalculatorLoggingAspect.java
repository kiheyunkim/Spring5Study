package com.apress.springrecipes.calculator;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.ast.Instanceof;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorLoggingAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Around("execution(* *.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
    	log.info("The method {}() begins with {}", joinPoint.getSignature().getName(),
    			Arrays.toString(joinPoint.getArgs()));
    	
    	try {
    		Object result = joinPoint.proceed();
			log.info("The method {}() ends with ", joinPoint.getSignature().getName(),result);
			
			return result;
		} catch (Exception e) {
			System.out.println("catch");
			// TODO: handle exception
			log.error("Illegal argument {} in {}();",Arrays.toString(joinPoint.getArgs()),joinPoint.getSignature().getName());
			throw e;
		}
    	
    }
    
    /*
	    //			  * -> All Access Modifier   ..-> any parameters
    @Before("execution(* ArithmeticCalculator.add(..))")
    public void logBefore() {
    	log.info("The Method add() begins");
    }
    */
    
    /*
    @Before("execution(* *.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("The method {}() begins with {} ", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }
    */
    
    /*
    @After("execution(* *.*(..))")	//->Execute After Success and Fail
    public void logAfter(JoinPoint joinPoint) {
    	log.info("The method {}() ends with {} ", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }
     */
    
    /*
    @AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint) {
    	log.info("The method {}() ends with {} ", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }
    */
    
    /*	
    @AfterThrowing("execution(* *.*(..))")
    public void logBefore2(JoinPoint joinPoint) {
        log.info("An exception has been thrown {}()", joinPoint.getSignature().getName());
    }
    */
    
    /*
    @AfterThrowing(pointcut = "execution(* *.*(..))",throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {		//Assign All Exception Type
    	log.error("An exception {} has been thrown in {}()", e, joinPoint.getSignature().getName());
    }
    */
    
    /*
    @AfterThrowing(pointcut = "execution(* *.*(..))",throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, IllegalArgumentException e) {	//assign Exception Type
    	log.error("An exception {} has been thrown in {}()", e, joinPoint.getSignature().getName());
    }
    */
}