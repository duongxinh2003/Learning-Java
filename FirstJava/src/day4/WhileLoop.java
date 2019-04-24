package day4;

public class WhileLoop {
	public static void main(String[] args) {
		int integerVal = 5;
		while (integerVal > 5) {
			System.out.println(integerVal);
			integerVal--;
		}
		int integerVal2 = 5;
		do {
			System.out.println(integerVal2);
			integerVal2--;
		} while (integerVal2 > 5);
	}
}
