package day2;

public class PassingAgruments {
	
	protected int access = 15;

	public static void main(String[] args) {
		Integer count = new Integer(40); //passing a primitive var
		PassingAgruments pa = new PassingAgruments();
		
		pa.printCount(count);
		System.out.println("Count = " + count);
		//passing a reference var
		Student st = new Student("Son", 22);
		System.out.println("Name: " + st.getName() + "\tAge: " + st.getAge());
		pa.changeStudent(st); //passing value of param object
		System.out.println("Name: " + st.getName() + "\tAge: " + st.getAge());
	}
	
	private void printCount(Integer num) {
		num+=10;
		System.out.println("Count in method = "+num);
	}
	
	private void changeStudent(Student st) {
		st.setAge(10);
		st = new Student("ABC", 30);
		System.out.println("Name: " + st.getName() + "\tAge: " + st.getAge());
	}

}
class Student {
	String name;
	int age;
	
	Student(String n, int a) {
		name = n;
		age = a;
	}
	
	String getName() {
		return name;
	}
	
	void setAge(int a) {
		age = a;
	}
	
	int getAge() {
		return age;
	}
}