package com.controller;

public class EnumTest {
	public static final int TUE = 3;
	public static final int WED = 4;
	public enum weekDay {TUE, WED};
	public EnumTest() {
	}
	
	public static void main(String[] args) {
		System.out.println(CupSize.SMALL.getsize());
		weekDay tuesday = weekDay.TUE;
		System.out.println(TUE);
	}
	
	public enum CupSize {
		SMALL(35), LARGE(40);
		private int size;
		
		CupSize (int size) { //constructor
			this.size = size;
		}
		public int getsize() {
			return size;
		}
		
	}
}
