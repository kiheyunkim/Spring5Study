package com.workshop.animal.entity;

public abstract class Animal {
	protected int legs;
	protected Animal(int legs){
		this.legs = legs;
	}
	
	public void walk() {
		System.out.println("동물은 " + this.legs + "개의 다리로 걷는다");
	}
	
	abstract public void eat();
}
