package test;

public class MainThread {
	public static void main(String[] args) {
		Object object = new Object();
		MyList myList = new MyList();
		RandomData random = new RandomData(myList);
		IOController handle = new IOController(myList);
		random.runThread(object);
		handle.createThreads(object);
	}
}
