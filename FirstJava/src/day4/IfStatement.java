package day4;

public class IfStatement {
	public static void main(String[] args) {
		boolean booleanVar1 = true;
		boolean booleanVar2 = false;
		if (booleanVar2 = booleanVar1) {
			System.out.println("Boolean: " + booleanVar2);
		}
		IfStatement ifStatement = new IfStatement();
		ifStatement.calculate(1, 2, 3);
		ifStatement.calculate(0, 0, 0);
		ifStatement.calculate(2, 4, 1);
	}

	void calculate(int a, int b, int c) {
		if (a == 0) {
			if (b == 0 && c != 0) {
				System.out.println("Vo nghiem");
			} else if(b == 0 && c == 0){
					System.out.println("Vo so nghiem");
			} else {
				System.out.println("Nghiem = " + (-c / b));
				return;
			}
		} else {
			int delta = b * b - 4 * a * c;
			if (delta < 0) {
				System.out.println("Can not be resolved");
			} else if (delta == 0) {
				System.out.println("Nghiem x1 = x2 = " + (-b / (2 * a)));
			} else {
				System.out.println("Nghiem x1 = " + (float) ((-b - Math.sqrt(delta)) / (2 * a)));
				System.out.println("Nghiem x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)));
			}
		}

	}
}
