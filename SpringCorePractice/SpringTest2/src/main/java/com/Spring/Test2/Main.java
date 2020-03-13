package com.Spring.Test2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Spring.Shape.Circle;
import com.Spring.Shape.Shape;
import com.Spring.Shape.SpringConfig;
import com.Spring.Shape.Square;
import com.Spring.Shape.Triangle;


public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(SpringConfig.class) ;
		//	= new AnnotationConfigApplicationContext(ShapeConfiguration.class); 
		
		//Log log = LogFactory.getLog(Main.class);
		
		Shape triangle = context.getBean("getTriangle",Shape.class);
		System.out.println(triangle.getArea());
		//log.info("Triangle Area = " + triangle.getArea());
		
		Shape square = context.getBean("getSquare",Shape.class);
		System.out.println(square.getArea());
		//log.info("Square Area = " + square.getArea());
		
		Shape circle = context.getBean("getCircle",Shape.class);
		System.out.println(circle.getArea());
		//log.info("Circle Area = " + circle.getArea());
		
		context.close();
	}
}
