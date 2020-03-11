package com.Spring.Shape;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {
	int radius;
	
	public Circle() {
	
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
