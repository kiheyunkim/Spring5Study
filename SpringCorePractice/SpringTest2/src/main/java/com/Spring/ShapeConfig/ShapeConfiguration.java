package com.Spring.ShapeConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.Spring.Shape.Circle;
import com.Spring.Shape.Square;
import com.Spring.Shape.Triangle;

@Configuration
@PropertySource("classpath:info.properties")
public class ShapeConfiguration {
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer 
		propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public Triangle getTriangle(
			@Value("${triangle.bottom:2}")int height,
			@Value("${triangle.hieght:2}")int bottom){
		Triangle tri = new Triangle(height, bottom);
		
		return tri;
	}
	
	@Bean
	public Square getSquare(
			@Value("${square.height:2}")int height,
			@Value("${square.width:2}")int width) {
		Square sqr = new Square(width, height);
		
		return sqr;
	}
	
	@Bean
	public Circle getCircle(@Value("${circle.radius:2}")int radius) {
		Circle circle = new Circle(radius);
		
		return circle;
	}
	
}
