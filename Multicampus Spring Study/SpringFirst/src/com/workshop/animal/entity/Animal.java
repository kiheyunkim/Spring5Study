package com.workshop.animal.entity;

public abstract class Animal {
	protected int legs;
	protected Animal(int legs){
		this.legs = legs;
	}
	
	public void walk() {
		System.out.println("������ " + this.legs + "���� �ٸ��� �ȴ´�");
	}
	
	abstract public void eat();
}
