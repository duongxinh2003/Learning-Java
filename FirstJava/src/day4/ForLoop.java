package day4;

public class ForLoop {
	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			System.out.println(i);
		}
		int i = 0;
		int j = 1;
		for (i += j ;i < 5; i++) {
			System.out.println(i);
		}
		for ( double a = 1; a < 5; a = a + 0.2) {
			System.out.printf("a="+a +"\n");
		}
//		for(;;) {
//			System.out.println("a");
//		}
		
		int[] intArray = new int[4];
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		for (int index : intArray) {
			System.out.println(index);
		}
	}
}
