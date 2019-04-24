package day3;

public class ExplicitConvertPrimitiveType {
	public static void main(String[] args) {
		long longVal = 10;
		int integerVal = (int) longVal;
		short shortVal = 175;
		byte byteVal = (byte) shortVal;
		System.out.println("Integer:" + integerVal);
		System.out.println("Byte:" + byteVal);
	}
}
