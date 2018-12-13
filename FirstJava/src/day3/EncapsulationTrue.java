package day3;

public class EncapsulationTrue {
	public static void main(String[] args) {
		Human human = new Human();
		human.setName("Son");
		System.out.println("Student = " + human.getName());
	}
}
class Human {
	private String name;
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
}