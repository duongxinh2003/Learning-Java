/** This is a class that create object - mapping in the real-world
* public: Access in anywhere
* class: It's a class
* 'Human': Name of class ** Human # human
**/
public class Human {
	private static int TEST = 10;
	/**
	* public: Access in anywhere
	* static: method can be invoked without instantiating the class
	* void: return nothing
	* main: name of the method
	* String[] args: agruments of String, contain charaters
	**/
	public static void main(String[] args) {
		//valid name
		int aName = 0;
		int Abc = 1;
		int _ghA = 2;
		int $name = 3;
		//invalid name
		// String 45vH = "45vH";
		// int *jk = 4;
		// int $ = 6;
		System.out.println(aName + Abc + _ghA + $name + TEST);
	}

	static {
		System.out.println("This line appear first");
	}
}