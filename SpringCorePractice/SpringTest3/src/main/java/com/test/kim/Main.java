package com.test.kim;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	static public void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		                                                                                                                                                                                                                                                                                                                                                                                                              
		ParentPrintInt print = context.getBean("parentPrint",ParentPrintInt.class);
		System.out.println(print);
		
		MaxNumber maxP = (MaxNumber)print;
		System.out.println(maxP.max(3.0, 2.1));
		
		MinNumber minP = (MinNumber)print;
		System.out.println(minP.min(4.1, 1.1));
		
		Counter counter = (Counter)print;
		System.out.println(counter.getCount());
		
		context.close();
	}
}
