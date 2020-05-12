package com.workshop.animal.entity;

public class Cat extends Animal implements Pet {

	private String name;
	
	public Cat(String name) {
		super(4);
		this.name = name;
	}
	
	public Cat(){
		//super(4); 또는
		this("");
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
		System.out.println("고양이가 쥐랑 놀아요");
	}

	@Override
	public void eat() {
		System.out.println("고양이가 물고기를 먹는다.");
	}
}
