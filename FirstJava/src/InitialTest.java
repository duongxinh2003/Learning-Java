import com.entity.ExternalBus;
import com.entity.InternalBus;

public class InitialTest {
	public static void main(String[] args) {
//		arthOp();
//		InternalBus inter = new InternalBus(1, "Son", "HNHP", 12.1f, 120);
//		System.out.println(inter.toString() + "\b");
//		relaOp(10, 5);
//		StaticTest st1 = new StaticTest();
//		StaticTest st2 = new StaticTest(); //increase test variable to 2 when new instance
//		System.out.println("Static 1: " + st1.test);
		int a=10;
		c(a, 10);
		System.out.println("Static 1: " + a);
	}
	
	//Arithmetic Operators: +, ++, -, --, %, / *
	private static void arthOp() {
		int x = 2;
		int y = x++; //2 x = 3
		int z = ++x; //4
		int a = x++; //4
		System.out.println(y + z + a + "\t" + a);
		float b = 3.8f;
		float c = 1.2f;
		System.out.println(b%c);
	}
	
	//Relational operators: < <= > >= == !=
	private static void c(int a, int b) {
		a=a+1;
		System.out.println(a);
		if(a < b) {
			System.out.println("a < b");
		}
		if(a >= b) {
			System.out.println("a  >= b");
		} else {
			System.out.println(a + b);
		}
	}
	
	}

class StaticTest {
	static int test = 0;
	int count = 0;
	
	StaticTest() { //load static variable first
		test++;
		count++;
	}
}
