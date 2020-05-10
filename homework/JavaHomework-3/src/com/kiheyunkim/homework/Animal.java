package com.kiheyunkim.homework;

public abstract class Animal {
	protected int legs;
	
	protected Animal(int legs) {
		this.legs = legs;
	}
	
	abstract public void eat();
	public void walk() {
		System.out.println(legs +"개의 다리로 걷습니다.");
	}
}
