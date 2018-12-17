package day5;

public class Assertion {
	public static void main(String[] args) {
		int integerVal = 4;
		String stringVal = "test";
		boolean booleanVal = false;
		Assertion assertion = new Assertion();
		assert assertion.checkedData(booleanVal):"True";
		System.out.println(stringVal + integerVal);
	}
	
	public boolean checkedData(boolean check) {
		return check;
	}
}
