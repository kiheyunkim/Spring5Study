package com.Spring.Shape;

import org.springframework.stereotype.Component;

import com.Spring.ShapeConfig.LoggingRequired;


@Component
@LoggingRequired
public class Circle implements Shape {
	int radius;
	
	public Circle() {
		super();
	}
	
	public Circle(int radius){
		super();		
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return radius * radius * 3.14;
	}

}
	