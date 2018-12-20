package day7;

import java.util.HashMap;
import java.util.Map;

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
	}
}
