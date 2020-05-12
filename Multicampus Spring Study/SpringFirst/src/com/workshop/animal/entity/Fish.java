package com.workshop.animal.entity;

public class Fish extends Animal implements Pet{

	private String name;
	
	Fish() {
		super(2);
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
		System.out.println("물고기가 헤엄을 치며 놀고 있다.");
	}

	@Override
	public void eat() {
		System.out.println("물고기가 사료를 먹고 있다.");
		
	}

	@Override
	public void walk() {
		System.out.println("물고기는 걷지 않아요.");
	}

}
