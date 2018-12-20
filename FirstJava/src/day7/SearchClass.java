package day7;

import java.util.Arrays;
import java.util.Comparator;

public class SearchClass implements Comparator<String>{
	public static void main(String[] args) {
		String[] stringArray = {"Ump","Hka", "ahj", "Cab", "rmt", "AAA", "1"};
		System.out.println(Arrays.toString(stringArray));
		System.out.println("Cab = " + Arrays.binarySearch(stringArray, "Cab"));
		Arrays.sort(stringArray);
		System.out.println(Arrays.toString(stringArray));
		System.out.println("Cab = " + Arrays.binarySearch(stringArray, "Cab"));
	}

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}
