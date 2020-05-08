package com.workshop.animal.entity;

public class PetTest {
	
	public PetTest() {
		
	}
	
	public void metdhod(Pet pet) {
		System.out.println("hi");
	}
	
	public void TestAnimals() {
		Cat cat = new  Cat();
		System.out.println(cat);
		cat.setName("고양이1");
		System.out.println(cat);
		System.out.println(cat.getName());
		System.out.println(cat);
		cat.play();
		System.out.println(cat);
		cat.eat();
		System.out.println(cat);
		cat.walk();
		System.out.println(cat);
		
		Pet cat2 = new Cat();
		System.out.println(cat2);
		cat2.setName("고양이2");
		System.out.println(cat2);
		System.out.println(cat2.getName());
		System.out.println(cat2);
		cat2.play();
		System.out.println(cat2);
		
		Animal cat3 = new Cat();
		System.out.println(cat3);
		cat3.eat();
		System.out.println(cat3);
		cat3.walk();
		System.out.println(cat3);
	}
	
	
}
