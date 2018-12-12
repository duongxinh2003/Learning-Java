package day2;

public class InterfaceTest implements iRobo {
	int parent = 10;
	
	public InterfaceTest() {
	}
	public static void main(String[] args) {
		
		InterfaceTest it = new InterfaceTest();
		System.out.println(it.getData());
		it.printParent();
		System.out.println(iRobo.i);
		System.out.println(iParent.parent);
		System.out.println(it.parent);
	}
	

	public String getData() {
		return "Hello";
	}
	
	@Override //annotation
	public void printParent() {
		System.out.println("This is parent");
		
	}
	@Override
	public int getValue() {
		return 0;
	}
	
	void test() {
		
	}
}
