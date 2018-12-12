package day2;

import static java.lang.System.*;
import static java.lang.Math.*;

public class StaticImport {

	public StaticImport() {
		
	}
	
	public static void main(String[] args) {
		out.println("Pi: " + PI);
		out.println("E: " + E);
		double a = sqrt(16);
		out.println(a);
		PassingAgruments pa = new PassingAgruments();
		System.out.println(pa.access);
	}

}
