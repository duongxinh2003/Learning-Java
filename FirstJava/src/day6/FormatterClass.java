package day6;

public class FormatterClass {
	public static void main(String[] args) {
		System.out.println(String.format("%b", null).toString());
		System.out.println(String.format("%b", 1314).toString());
		System.out.println(String.format("%2$c %1$,d", 15406, 'w').toString());
		System.out.println(String.format("%10s", "String").toString());
		System.out.println(String.format("%1$10s %2$,15.3f", "aaa", 42596.5789).toString());
	}
}
