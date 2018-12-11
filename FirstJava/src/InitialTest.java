import com.entity.ExternalBus;
import com.entity.InternalBus;

public class InitialTest {
	public static void main(String[] args) {
		int x = 2;
		int y = x++;
		int z = ++x;
		int a = x++;
		System.out.println(y + z + a + " " + y);
		InternalBus inter = new InternalBus(1, "Son", "HNHP", 12.1f, 120);
		System.out.println(inter.toString() + "\b");
	}
}
