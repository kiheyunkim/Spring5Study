package com.Spring.Shape;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape{
	int height;
	int bottom;
	
	public Triangle() {
		
	}
	
	public Triangle(int height, int bottom){
		super();
		this.height = height;
		this.bottom = bottom;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return height * bottom / 2;
	}

}
