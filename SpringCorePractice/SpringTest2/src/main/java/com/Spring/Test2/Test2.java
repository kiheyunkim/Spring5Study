package com.Spring.Test2;

import org.springframework.stereotype.Component;

import com.Spring.Shape.Shape;
import com.Spring.ShapeConfig.LoggingRequired;

@Component
@LoggingRequired
class Test2 implements Shape{

	Test2(){
		
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 10;
	}
	
	public int getNumber() {
		return 5;
	}
	
}