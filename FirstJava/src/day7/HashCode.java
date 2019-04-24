package day7;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashCode {
	public static void main(String[] args) {
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(33, "Kvv");
		hashMap.put(16, "Mfw");
		hashMap.put(29, "Ga");
		hashMap.put(81, "By");
		hashMap.put(70, "Joi");
		hashMap.put(16, "Cab");
		hashMap.put(25, "Ath");
		System.out.println("HashTable: " + hashMap);
		for (Integer key : hashMap.keySet()) {
			System.out.println(key + "=" + hashMap.get(key).hashCode());
		}
		System.out.println(hashMap.get(29).equals(hashMap.get(29)));
		Map<Information, String> treeMap = new TreeMap<>();
		treeMap.put(new Information(3, "CGCa", 9), "a");
		treeMap.put(new Information(1, "Xf", 10.2), "baf");
		treeMap.put(new Information(9, "aGa", 91.0), "an");
		treeMap.put(new Information(9, "8aGa", 91.0), "an");
		treeMap.put(new Information(2, "fef", 10.8), "aa");
		treeMap.put(new Information(8, "Ga", 9), "awfew");
		treeMap.put(new Information(1, "Ga", 9), "awfew");
		for (Information i : treeMap.keySet()) {
			System.out.println(i.getName() + " " + i.getId());
		}
//		int[] i1 = {5,3,7};
//		int[] i2 = {1,3,7,8};
//		treeMap.put(i1, "test");
//		treeMap.put(i2, "afwe");
//		for (int[] i : treeMap.keySet()) {
//			System.out.println(i);
//		}
	}
}
