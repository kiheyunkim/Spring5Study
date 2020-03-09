package com.Test.Spring;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectClassTest {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	@Before("execution(* *.*(..))")
	public void logBefore() {
		log.info("Log!!!!!!!!!!!!!!!!!!!!!!!");
	}
}
