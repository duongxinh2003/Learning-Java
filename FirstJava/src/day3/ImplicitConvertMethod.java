package day3;

public class ImplicitConvertMethod {
	public static void main(String[] args) {
		int integerVal = 10;
		long longVal = 16;
		byte byteVal = 8;
		short shortVal = 3;
		float floatVal = 1.5f;
		double doubleVal = 10.5;
		ImplicitConvertMethod implicitConvertMethod = new ImplicitConvertMethod();
//		System.out.println(implicitConvertMethod.add(integerVal, longVal));
		System.out.println(implicitConvertMethod.add(shortVal, byteVal));
		System.out.println(implicitConvertMethod.addFloat(floatVal, longVal));
		if((doubleVal - floatVal) >= (-byteVal*integerVal)) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public double addFloat(double a, double b) {
		return a + b;
	}
}
