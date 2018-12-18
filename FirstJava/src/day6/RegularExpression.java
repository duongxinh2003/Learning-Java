package day6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	public static void main(String[] args) {
		String email = "sonnhse03996@gmail.com";
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_\\.]+\\@{1}[a-z]{3,5}\\.[a-z]{3,4}(\\.[a-z]+){1}$");
		Matcher matcher = pattern.matcher(email); //matches(String input);???
		boolean check = matcher.find();
		if (check) {
			System.out.println("This is email");
		} else {
			System.out.println("Invalid email");
		}
	}
}
