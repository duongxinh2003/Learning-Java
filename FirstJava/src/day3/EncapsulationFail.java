package day3;

public class EncapsulationFail {

	public static void main(String[] args) {
		Student student = new Student();
		System.out.println("Student: "+ student.name);
	}

}
class Student {
	public String name = "Son";
}