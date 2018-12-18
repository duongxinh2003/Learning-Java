package day6;

public class Wrapper {
	public static void main(String[] args) {
		int i = 16; //boxing
		Integer integer = new Integer(i);
		Double doubleVal = Double.valueOf("10.1");
		System.out.println(integer.toString());
		System.out.println(doubleVal.toString());
		Wrapper wrapper = new Wrapper();
		System.out.println(wrapper.setIntegerValue(integer).toString());
		System.out.println(integer);
		
		//Extract wrapped values
		Float floatVal = 10.26f;
		Byte b = 10;
		Boolean check = new Boolean("abc");
		System.out.println("Float value: " + (b.floatValue() + floatVal));
		System.out.println("Boolean : " + check.booleanValue());
		
		//Parse to primitive type
		String parseString = "2";
		byte byteVal = Byte.parseByte(parseString);
		int intVal = Integer.parseInt(parseString);
		double parseDouble = Double.parseDouble(parseString);
		System.out.println(byteVal + intVal + parseDouble);
	}
	
	public Integer setIntegerValue(Integer number) {
		number = 5;
		return number;
	}
}
