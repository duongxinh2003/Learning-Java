package day4;

public class ContinueStatement {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			if(i == 1 || i == 2) 
				continue;
			System.out.println("i: " + i);
		}
		
		OuterLoop: for (int i = 15; i > 9 ; i--) {
			InnerLoop: for (int j = 10; j < 15; j++) {
				if(i == j) continue OuterLoop;
				System.out.println("i = " + i + " j: " + j);
			}
		}
		int whileVar = 5;
		while (whileVar > 0) {
			if(whileVar == 3) {
				whileVar--;
				continue;
			}
			else {
				System.out.println("whileVar = " + whileVar);
				whileVar--;
			}
		}
	}
}
