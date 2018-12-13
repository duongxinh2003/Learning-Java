package day3;

public class MethodOverload {

	float calculateArea(float length, float width) {
		return length*width;
	}
	double calculateArea(double radius) {
		return (Math.PI)*radius*radius;
	}
	double calculateArea(double a, double b, double c) {
		double s = (a+b+c)/2.0;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
}
