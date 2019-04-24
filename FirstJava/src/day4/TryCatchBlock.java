package day4;

public class TryCatchBlock {
	public static void main(String[] args) throws Exception{
		int x = 15;
		int y = 0;
		String z = null;
//		System.exit(0);
		try {
			System.out.println(z.charAt(0) + "Divide: " + x/y);
		}
//		catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("Array index of bound ex.");
//		}
		catch(IllegalArgumentException ie) {
			System.out.println("Illegal");
		}
		catch (ArithmeticException e) {
			System.out.println("Cannot divide zero. " + e);
		} catch (NullPointerException e) {
			System.out.println("Null pointer ex.");
		} 
		catch (Exception e) {
//			throw new Exception();
			System.out.println(e);
		}
		finally {
			System.out.println("Run well.");
		}
		System.out.println("x - y = "+ (x - y));
		System.out.println(test(3));
		try {
			String stringVal = "StringVal:" + x/y;
		} finally {
			System.out.println("stringVal = 0");
		}
	}
	
	@SuppressWarnings("finally")
	private static int test(int a) {
		int b = 8;
		try {
			return b/a;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			return 0;
		}
	}
}
