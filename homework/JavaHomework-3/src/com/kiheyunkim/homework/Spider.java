package com.kiheyunkim.homework;

public class Spider extends Animal {

	public Spider() {
		super(8);
	}
	
	@Override
	public void eat() {
		System.out.println("거미는 날벌래를 먹어요.");
	}

}
