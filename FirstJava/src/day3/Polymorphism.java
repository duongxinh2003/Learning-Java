package day3;

public class Polymorphism {
	public static void main(String[] args) {
		Car car = new Car();
		Audi audi = new Audi();
		Vinfast vinfast = new Vinfast();
		car = audi;
		car.runCar();
		car = vinfast;
		car.runCar();
	}
}
class Car {
	public void runCar() {
		System.out.println("Carrr");
	}
}
class Audi extends Car {
	public void runCar() {
		System.out.println("This is Audi.");
	}
}
class Vinfast extends Car {
	public void runCar() {
		super.runCar();
		System.out.println("Run Vinfast");
	}
}