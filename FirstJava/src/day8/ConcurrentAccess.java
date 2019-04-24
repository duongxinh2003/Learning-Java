package day8;

public class ConcurrentAccess extends Thread{
	CalculateCount cal = new CalculateCount();
	public static void main(String[] args) {
//		CalculateCount cal = new CalculateCount(12);
		ConcurrentAccess acc1 = new ConcurrentAccess();
		ConcurrentAccess acc2 = new ConcurrentAccess();
		acc1.start();
		acc2.start();
	}
	
	public void run() {
		cal.add();
	}
}
class CalculateCount {
	public int count = 12;
	
	public void add() {
		System.out.println(count+=2);
	}
}