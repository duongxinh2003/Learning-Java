package day9;

public class Practice {
	public static void main(String[] args) {
		Practice p = new Practice();
	}
	
	public Practice() {
		System.out.println("Test");
	}
	
	static {
		System.out.println("B");
	}
}
