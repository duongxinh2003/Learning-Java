package com.sonnh.threading;

import java.util.HashSet;
import java.util.Set;

public class ThreadTest {
	public static void main(String[] args) {
//		int[] a = {5,5};
//		System.out.println(duplicate(a));
//		String s = "abacabaabacaba";
//		System.out.println(firstNotRepeatingCharacter(s));
//		int[][] a = {{1, 2, 3},
//			     {4, 5, 6},
//			     {7, 8, 9}};
		int[][] a = {{10,9,6,3,7}, 
				 {6,10,2,9,7}, 
				 {7,6,3,8,2}, 
				 {8,9,7,9,9}, 
				 {6,8,6,8,2}};
		rotateImage(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
				if(j == a.length-1)
					System.out.println();
			}
		}
	}                                
	
	public static int duplicate(int[] a) {
		if(a.length == 2) {
			if(a[0] == a[1])
				return a[0];
		}
		int[] n = new int[a.length+1];
		for (int i = 0; i < a.length; i++) {
			n[a[i]] +=1;
			if(n[a[i]] > 1)
				return a[i];
		}
		return -1;
	}
	
	public static int firstDuplicate(int[] a) {
		Set<Integer> set = new HashSet<>();
		for (Integer i : a) {
			if(!set.add(i))
				return i;
		}
		return -1;
	}
	
	public static char firstNotRepeatingCharacter(String s) {
		String[] split = s.split("");
		int[] intArray = new int[s.length()];
		for (int i = 0; i < split.length; i++) {
			intArray[i] = (int) split[i].charAt(0);
			System.out.println(intArray[i]);
		}
		int[] n = new int[123];
		for (int i = 0; i < intArray.length; i++) {
			n[intArray[i]]+=1;
		}
		for (int i = 0; i < intArray.length; i++) {
			if(n[intArray[i]] == 1) {
				System.out.println("n index: " + intArray[i]);
				return (char) intArray[i];
			}
		}
		return '_';
	}
	
	public static int[][] rotateImage(int[][] a) {
		int temp = 0;
		int max = a.length;
		for (int i = 0; i < max; i++) {
			for (int j = i; j < max; j++) {
				temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max/2; j++) {
				temp = a[i][j];
				a[i][j] = a[i][max-1-j];
				a[i][max-1-j] = temp;
			}
		}
		return a;
	}
}
