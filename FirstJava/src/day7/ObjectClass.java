package day7;

import day6.Information;

public class ObjectClass {
	public static void main(String[] args) throws CloneNotSupportedException {
		Information information = new Information(2, "a", 20.1, "M"); 
		Information information2 = (Information) information.clone();// implements Cloneable
		ObjectClass objectClass = new ObjectClass();
		System.out.println(information2.toString());
		System.out.println(information.equals(information2));
		System.out.println(objectClass.equals((Object) information2));
	}
	
	public boolean equals(Object object) {
		return true;
	}
}