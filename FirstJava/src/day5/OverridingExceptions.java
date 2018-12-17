
package day5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;

import javax.naming.NamingException;
import javax.xml.xpath.XPathException;

public abstract class OverridingExceptions {
	public void testParent() throws IOException{
	}
	public abstract void testParent2() throws NullPointerException;
	public void testParent3() {
	}
//	class FirstChild extends OverridingExceptions {
//		public void testParent() throws IOException {
//		}
//	}
//	class SecondChild extends OverridingExceptions {
//		public void testParent() {
//		}
//	}
//	class ThirdChild extends OverridingExceptions {
//		public void testParent() throws FileNotFoundException, SocketException {
//		}
//	}
//	class FourthChild extends OverridingExceptions {
////		public void testParent() throws Exception { //cannot throws parent class
////		}
//		public void testParent() throws VirtualMachineError {
//		}
////		public void testParent3() throws ClassNotFoundException { //cannot throws checked ex
////		}
//		public void testParent3() throws RuntimeException {
//		}
//		public void testParent2() throws VirtualMachineError{
//		}
//	}
}
