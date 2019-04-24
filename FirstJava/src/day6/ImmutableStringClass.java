package day6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ImmutableStringClass {
	public static void main(String[] args) {
		char[] chars = {'S','O','N'};
		String stringChars = new String(chars);
//		String stringVal = new String("IAm");
//		String stringVal = "Hi";
//		String stringVal = new String("HS" + "N");
//		String stringVal = "a" + "b";
		String string1 = "SON" + "";
		String string2 = "SON";
		String string3 = stringChars;
		if(string1.equals(string2)) {
			System.out.println("String1 equal String 2");
		} else {
			System.err.println("String 1 not equal string 2");
		}
		if(string1 == string2) {
			System.out.println("String 1 == string 2");
		} else {
			System.err.println("String 1 != string 2");
		}
		if(string1.equals(stringChars)) {
			System.out.println("String 1 equal String chars");
		} else {
			System.err.println("String 1 not equal String chars");
		}
		if(string1 == stringChars) {
			System.out.println("String 1 == String chars");
		} else {
			System.err.println("String 1 != String chars");
		}
		string1.concat("hehehe");
		System.out.println(string1+ " " + (string1 ==string2));
	}
}
