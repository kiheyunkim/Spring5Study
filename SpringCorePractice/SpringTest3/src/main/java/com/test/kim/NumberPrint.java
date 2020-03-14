package com.test.kim;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NumberPrint{
	@DeclareParents(
			value = "com.test.kim.ParentPrint",
			defaultImpl = MaxNumberImp.class)
	public MaxNumber maxNumber;
	
	@DeclareParents(
			value  ="com.test.kim.ParentPrint",
			defaultImpl =  MinNumberImp.class)
	public MinNumber minNumber;
	
	@DeclareParents(
			value = "com.test.kim.ParentPrint",
			defaultImpl = CounterImp.class)
	public Counter counter;
	
	@After("execution(* *.*(..))" + " && this(counter)")
	public void increaseCount(Counter counter) {
		counter.Increase();
	}
}
