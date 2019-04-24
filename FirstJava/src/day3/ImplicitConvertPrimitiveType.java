package day3;

public class ImplicitConvertPrimitiveType {
	public static void main(String[] args) {
//		boolean check = true; //cannot convert to any non-boolean type
		int integerVal = 15;
//		byte byteVal = 150; // out of range
		short shortVal = 10;
//		shortVal = integerVal;
		integerVal = shortVal;
//		integerVal = check;
		char charVal = '\u00e9';
//		charVal = shortVal;
		integerVal = charVal;
		long longVal = 9223372036854775807l;
		float floatVal = 124.5f;
		floatVal = longVal;
		System.out.println("Short: " + shortVal);
		System.out.println("Char: " + charVal);
		System.out.println("Integer: " + integerVal);
		System.out.println("Long: " + longVal);
		System.out.println("Float: " + floatVal);
		short shortVal2 = 30;
		int integerVal2 = charVal * shortVal2;
		System.out.println(integerVal2);
	}
}
