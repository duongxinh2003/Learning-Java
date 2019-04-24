package day2;

public class FinalizeDemo {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.totalMemory());
		rt.gc();
		System.out.println(rt.freeMemory());
		FinalizeDemo finalizeDemo = new FinalizeDemo();
		try {
			finalizeDemo.finalize();
			System.out.println("Finalized");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
