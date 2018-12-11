package com.controller;

public class NestedClass {

	public static void main(String[] args) {
		OuterClass oc = new OuterClass();
		System.out.println(oc.getInner());
		OuterClass.InnerClass ic = oc.new InnerClass();
		System.out.println(ic.setInnerMethod("Test inner class"));
		
	}
}

class OuterClass {
	String n = "Inner class";
	InnerClass ic = new InnerClass();
	public String getInner() {
		return "Outer class: " + ic.setInnerMethod(n);
	}
	class InnerClass {
		public String setInnerMethod(String name) {
			return name;
		}
	}
}