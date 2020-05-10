package com.kiheyunkim.homework;

public class Fish extends Animal implements Pet{

	public Fish() {
		super(2);
	}

	private String name;
	
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
		System.out.println("물고기는 물속에서 놀아요");
	}

	@Override
	public void eat() {
		System.out.println("물고기는 미생물을 먹어요.");
	}

	@Override
	public void walk() {
		System.out.println("물고기는 걷는 대신에 헤엄을 쳐요.");
	}

}
