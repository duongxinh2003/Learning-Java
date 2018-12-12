package com.controller;

public class ConstructorTest {
	
	//if have at least 1 constructor, compile does not call default constructor
//	public ConstructorTest(String a) {
//	}

	public static void main(String[] args) {
		ConstructorTest ct = new ConstructorTest();
		ct.invoke();
		SubClass sc = new SubClass();
		sc.getValue();
	}
	
	private void invoke() {
		System.out.println("Run with default constructor");
	}

}

class SuperClass {
	int superVar = 10;
	
	public SuperClass(int superVar) {
		System.out.println("Super class");
	}
}


class SubClass extends SuperClass {
	int subVar = 20;
	public SubClass() {
		super(21);
		System.out.println("Sub var: " + subVar);
	}
	
	void getValue() {
		System.out.println(subVar);
	}
}