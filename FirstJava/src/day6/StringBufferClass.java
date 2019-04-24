package day6;

public class StringBufferClass {
	public static void main(String[] args) {
		String stringVal = "Hello";
		stringVal.concat("olleH");
		StringBuffer stringBufferVal= new StringBuffer("Hi");
//		stringBufferVal.insert(5, "fad");
		stringBufferVal.reverse();
		stringBufferVal.append("HI");
		System.out.println(stringVal);
		System.out.println(stringBufferVal);
	}
}
