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
		System.out.println("����Ⱑ ����� ġ�� ��� �ִ�.");
	}

	@Override
	public void eat() {
		System.out.println("����Ⱑ ��Ḧ �԰� �ִ�.");
		
	}

	@Override
	public void walk() {
		System.out.println("������ ���� �ʾƿ�.");
	}

}
