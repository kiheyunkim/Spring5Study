package com.Spring.Test2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.Spring.Shape.Circle;
import com.Spring.Shape.Square;
import com.Spring.Shape.Triangle;


public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context 
			= new AnnotationConfigApplicationContext(SpringConfig.class) ;
		//	= new AnnotationConfigApplicationContext(ShapeConfiguration.class); 
		
		//Log log = LogFactory.getLog(Main.class);
		
		Triangle triangle = context.getBean("getTriangle",Triangle.class);
		System.out.println(triangle.getArea());
		//log.info("Triangle Area = " + triangle.getArea());
		
		Square square = context.getBean("getSquare",Square.class);
		System.out.println(square.getArea());
		//log.info("Square Area = " + square.getArea());
		
		Circle circle = context.getBean("getCircle",Circle.class);
		System.out.println(circle.getArea());
		//log.info("Circle Area = " + circle.getArea());
		
		context.close();
	}
}
