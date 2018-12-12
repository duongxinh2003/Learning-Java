package day2;

public class RunShape {
	
//	protected void finalize() {
//		System.out.println("Finalized");
//	}

	public RunShape() {}
	
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle();
		Shape circle = new Circle();
		rectangle.draw();
		rectangle.run();
		rectangle.print();
		circle.draw();
		circle.print();
	}

}
abstract class Shape {
	int i = 1;
	abstract void draw();
	void print() {
		System.out.println("This is abstract class");
	}
}
class Rectangle extends Shape {

	@Override
	void draw() {
		System.out.println("Rectangle");
	}
	
	void print() {
		System.out.println("This is rectangle");
	}
	
	void run() {
		System.out.println("Start rectangle");
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