package com.Spring.Shape;

import org.springframework.stereotype.Component;

@Component
public class Square implements Shape {

	private int width;
	private int height;
	
	public Square() {
		
	}
	
	public Square(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return width * height;
	}

}
