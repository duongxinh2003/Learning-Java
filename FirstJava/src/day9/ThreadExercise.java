package day9;

public class ThreadExercise implements Runnable{
	public Data data = new Data();
	
	public static void main(String[] args) {
		ThreadExercise threadExercise = new ThreadExercise();
		Thread thread1 = new Thread(threadExercise);
		Thread thread2 = new Thread(threadExercise);
		Thread thread3 = new Thread(threadExercise);
		Thread thread4 = new Thread(threadExercise);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
	}
	@Override
	public void run() {
		synchronized (data) {
//			for (int i = 0; i < 15; i++) {
				data.setIndex(data.getIndex() + 1);
				System.out.println(Thread.currentThread().getName() + " " + data.getIndex());
//			}
		}
	}

}
class Data {
	private int index;
	
	public Data() {
		this.index = 0;
	}

	public synchronized int getIndex() {
		return index;
	}

	public synchronized void setIndex(int index) {
		this.index = index;
	}
	
}