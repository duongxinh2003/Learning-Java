package day3;

public class MethodOverride {

}
class Shape {
	int i = 1;
	void draw() {
	}
	void print() {
		System.out.println("This is abstract class");
	}
	
	protected void run() { //cannot override method make it less access
	}
	
	public final void testFinal() {
	}
	
	public static void testStatic() {
	}
	
	void testParam(int agrument) {}
	
	void testThrows() throws Exception {}
	
	void testThrows2() {}
	
	int testReturn() {return 0;}
	
	Shape myMethod(Shape shape) { return shape;}
}
class Rectangle extends Shape {

	@Override
	void draw() {
		System.out.println("Rectangle");
	}
	
	@Override
	void print() {
		System.out.println("This is rectangle");
	}
	
	@Override
	public void run() {
		System.out.println("Start rectangle");
	}
	
//	void testFinal() {}
	
//	public void testStatic() {}
	
	public static void testStatic() {} //not a override method
	
	@Override
	public void testParam(int integerVal) {} //can change name of param
	
	@Override
	void testThrows() {}
	
//	@Override
//	void testThrows2() throws Exception {}
	
//	@Override
//	double testReturn() {
//		return 4;
//	}
	
	@Override
	Circle myMethod(Shape shape) {
		Circle cirlce = null;
		return cirlce;
	}
}
class Circle extends Shape {

	@Override
	void draw() {
		System.out.println("Circle");
		
	}
	
	@Override
	void print() {
		System.out.println("This is circle");
	}
}