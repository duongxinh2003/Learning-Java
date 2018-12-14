package day4;

public class ThrowingException {
	public static void main(String[] args) {
		float x = 10;
		float y = 0;
		ThrowingException throwingException = new ThrowingException();
		try {
			throwingException.divide(x, y);
		} catch (Exception e) {
			System.out.println("Exception... " + e);
		}
	}
	
	public float divide(float x, float y) {
		if(y == 0) {
			throw new ArithmeticException("Cannot divide zero");
		}
		else
			return x/y;
	}
	
}
