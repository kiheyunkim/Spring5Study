package com.workshop.animal.entity;


//interface의 모든 함수들은 앞에 public abstract가 생략되어 있다고 생각한다.
//명시적으로 붙여도 상관은 없다.
public interface Pet {
	public abstract void setName(String name);
	public abstract String getName();
	public abstract void play();
}
