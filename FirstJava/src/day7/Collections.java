package day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class Collections {
	public static void main(String[] args) {
		//List Interface
		//ArrayList
		List<String> arrayList = new ArrayList<>();
		arrayList.add("H");
		arrayList.add("D");
		arrayList.add("A");
		arrayList.add("C");
		arrayList.add("B");
		arrayList.add("D");
		arrayList.add("B");
//		System.out.println(arrayList.toString());
		arrayList.add(4, "P");
		arrayList.remove("i");
		System.out.println("Array List: "+arrayList.toString());
		//LinkedList
		List<String> linkedList = new LinkedList<>();
		linkedList.add("H");
		linkedList.add("D");
		linkedList.add("A");
		linkedList.add("C");
		linkedList.add("B");
		linkedList.add(4, "P");
		System.out.println("LinkedList: " +linkedList.size() + linkedList.toString());
		//Vector synchronization
		List<String> vector = new Vector<>(arrayList);
		System.out.println("Vector List: "+vector.toString());
		//Set Interface
		//HashSet fastest, not synchronization
		Set<String> hashSet = new HashSet<>(arrayList);
		System.out.println("HashSet: "+hashSet.toString());
		//TreeSet not synchronization, default sort ascending
		Set<String> treeSet = new TreeSet<>(arrayList);
		System.out.println("TreeSet: " + treeSet.toString());
		//LinkedHashSet not synchronization, output by insertion
		Set<String> linkedHashSet = new LinkedHashSet<>(arrayList);
		System.out.println("LinkedHashSet: " + linkedHashSet.toString());
		
		//Map Interface
		//HashTable not null key or value, synchronized, not ordered(replace first val dup)
		Map<Integer, String> hashTable = new Hashtable<>();
		hashTable.put(33, "K");
		hashTable.put(16, "M");
		hashTable.put(29, "G");
		hashTable.put(9, "1");
		hashTable.put(81, "B");
		hashTable.put(70, "J");
		hashTable.put(8, "9");
		hashTable.put(16, "C");
		hashTable.put(25, "A");
		System.out.println("HashTable: " + hashTable);
		//Hashmap null k/v,unsync, not ordered 
		Map<Integer, String> hashMap = new HashMap<>(hashTable);
		hashMap.put(null, "P");
		hashMap.put(42, null);
		hashMap.put(null, null);
		System.out.println("HashMap: " + hashMap);
		//LinkedHashMap null K/V, output by insertion
		Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put(33, "K");
		linkedHashMap.put(16, "M");
		linkedHashMap.put(29, "G");
		linkedHashMap.put(81, "B");
		linkedHashMap.put(70, "J");
		linkedHashMap.put(16, "C");
		linkedHashMap.put(25, "A");
		System.out.println("LinkedHashMap: " + linkedHashMap);
		//Treemap default ascending, sync, not null K/V
		Map<Integer, String> treeMap = new TreeMap<>(hashTable);
//		treeMap.put(null, "G");
		System.out.println("TreeMap: " + treeMap);
	}
}
