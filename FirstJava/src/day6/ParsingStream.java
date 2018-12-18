package day6;

import java.util.Scanner;

public class ParsingStream {
	public static void main(String[] args) {
		String input = "This is 1 text input 12 line text and create text field.";
		Scanner scanner = null;
		try {
			scanner = new Scanner(input);
			System.out.println(scanner.next()); // return data before whitespace
			System.out.println(scanner.next());
			System.out.println(scanner.nextInt());
			scanner.useDelimiter("text");
			System.out.println(scanner.next());
			System.out.println(scanner.next());
			System.out.println(scanner.nextLine()); // return data before breakline
			scanner = new Scanner(input).useDelimiter("text");
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
		} finally {
			scanner.close();
		}
	}
}
