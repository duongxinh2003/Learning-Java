package day8;

public class ThreadLifeCircle implements Runnable {
	Thread tThread;
	
	public ThreadLifeCircle() {
		System.out.println("New: Instance thread before start()");
	}
	public static void main(String[] args) {
		ThreadLifeCircle threadLifeCircle = new ThreadLifeCircle();
//		System.out.println("aaa");
		threadLifeCircle.start();
		System.out.println("Before running");
	}

	@Override
	public void run() {
		System.out.println("Running...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Non runnable state");
		}
		System.out.println("Dead.");
	}
	
	public void start() {
		System.out.println("Ready");
		tThread = new Thread(this);
		tThread.start();
	}
}
