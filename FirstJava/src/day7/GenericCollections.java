package day7;

import java.util.ArrayList;
import java.util.List;

public class GenericCollections {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		String a = "Son";
		list.add(a);
		String out = list.get(0);
//		String out2 = list.get(0);
		System.out.println(out);
		ArrayList<Student> students = new ArrayList<Student>();
		Student<Integer, String> student = new Student<Integer, String>(12, "Gab");
		Student<Integer, String> student2 = new Student<Integer, String>(2, "ABCs");
		Student<Integer, Double> student3 = new Student<Integer, Double>(2, 12.6);
		students.add(student);
		students.add(student2);
		students.add(student3);
		for (int i = 0; i < students.size(); i++) {
			System.out.println("Id:" + students.get(i).getId());
			System.out.println("Name:" + students.get(i).getName());
		}
		List<?> list2 = new ArrayList<>(); 
		List<? extends Student> childStudents = new ArrayList<>();
		List<? super Student> parentStudents = new ArrayList<>();
//		List<? extends Object> objects = list2;
		parentStudents.add(new Student<Integer, Double>(1,22.3));
//		list2.add(new Object());
		
	}
}
class Student<K extends Object, V> {
	private K id;
	private V name;
	public Student() {
	}
	public Student(K id, V name) {
		this.id = id;
		this.name = name;
	}
	public K getId() {
		return id;
	}
	public void setId(K id) {
		this.id = id;
	}
	public V getName() {
		return name;
	}
	public void setName(V name) {
		this.name = name;
	}
	
	
}
