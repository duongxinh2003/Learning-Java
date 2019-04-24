package day4;

public class SwitchStatement {
	public static void main(String[] args) {
		SwitchStatement switchStatement = new SwitchStatement();
//		switchStatement.switchCase(5.6f);
//		switchStatement.switchStringCase("a");
		switchStatement.switch3(1, 2);
	}
	
	private void switch3(int a, int b) {
		switch(b += b) {
//		case 2:
//			System.out.println("This is 2");
//			break;
//		case 3:
//			System.out.println("This is 3");
//			break;
		}
		switch(a++) {
			case 1:
				System.out.println("This is 1");
				break;
			case 2:
				System.out.println("This is 2");
				break;
			default:
				System.out.println("This is = " + a);
				break;
		}
		System.out.println(a);
	}
	
	private void switchStringCase(String string) {
		switch(string) {
		case "A":
			System.out.println("This is A");
//			break;
		case "a":
			System.out.println("This is a");
//			break;
		default:
			System.out.println("This is default");
//			break;
		case ".":
			System.out.println("This is .");
			break;
		}
	}

	public void switchCase(float a) {
		switch((byte)a) {
			case 1:
				System.out.println("This is 1");
//				break;
			case 5:
				System.out.println("This is 5");
//				break;
			case 3:
				System.out.println("This is 3");
				break;
			default:
				System.out.println("This is default");
//				break;
//			case 190:
//				System.out.println("This is 190");
//				break;
			case 2:
				System.out.println("This is 2");
//				break;
			case 4:
				System.out.println("This is 4");
//				break;
		}
	}
}

