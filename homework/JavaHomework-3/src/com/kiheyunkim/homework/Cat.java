package com.kiheyunkim.homework;

public class Cat extends Animal implements Pet{

	private String name;
	
	public Cat() {
		super(4);
	}
	
	public Cat(String name) {
		super(4);
		this.name = name;
	}
	
	@Override
	public void setName(String name) {		
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void play() {
		System.out.println("고양이는 실타래를 가지고 놀아요.");
	}

	@Override
	public void eat() {
		System.out.println("고양이는 생선을 먹어요.");
	}
}
