package com.controller;

public class StaticTest {
	final static String demoStatic = "Hello";
	int a = 20;
	static {
		System.out.println("Static block load first");
	}
	public StaticTest() {
		System.out.println("Constructor");
	}
	
	//cannot access the non static variables and method of the class
//	static void test( ) {
//		int b = a++;
//	}

	public static void main(String[] args) {
		StaticTest st = new StaticTest();
		System.out.println(demoStatic);
	}

}
