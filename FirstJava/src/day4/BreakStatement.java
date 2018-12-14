package day4;

public class BreakStatement {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			if(i == 3)
				break;
		}
		
		OuterLoop: for (int i = 0; i < 5; i++) {
			for (int j = 5; j > 0 ; j--) {
				if(i == j) break OuterLoop;
				else
					System.out.println("i = " + i + ", j = " + j);
			}
		}
		int whileVar = 5;
		while (whileVar > 0) {
			if(whileVar == 3) break;
			System.out.println(whileVar);
			whileVar--;
		}
	}
}
