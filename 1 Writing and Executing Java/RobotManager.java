public class RobotManager {
	public static void main(String[] args) {
		Robot robot;
		int nargs = args.length;
		if(nargs <= 1) {
			System.out.println("Must me 2 argruments");
			System.out.println("For example: A B");
			System.exit(0);
		} else {
			for(int i = 1; i < nargs;i++) {
				robot = new Robot();
				robot.getName(args[i]);
				robot.getTag(args[0]);
			}
		}
	}
}

class Robot {
	private String nName = "nobody";
	public void getName(String name) {
		nName = name;
		System.out.println("Hello: " + nName);
	}
	public void getTag(String name) {
		nName = name;
		System.out.println("I'm Robot " + nName);
	}
}