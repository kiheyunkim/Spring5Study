package com.test.kim;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
public class CounterIntroduction {
	@DeclareParents(
			value = "com.test.kim.CounterImp",
			defaultImpl = CounterImp.class)
	public Counter counter;
	
	@After("execution(* *.*(..)" + "&&this(counter)")
	public void increaseCount(Counter counter) {
		counter.Increase();
	}
}
