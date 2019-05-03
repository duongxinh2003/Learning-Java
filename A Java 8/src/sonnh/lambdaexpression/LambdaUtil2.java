package sonnh.lambdaexpression;

public class LambdaUtil2 {
  public void test(Adder adder) {
    double x = 199.90;
    double y = 8.50;
    double sum = adder.add(x, y);
    System.out.println("Using an adder: ");
    System.out.println(x + " + " + y + " = " + sum);
  }

  public void test(Joiner joiner) {
    String s1 = "Hello";
    String s2 = "World";
    String s3 = joiner.join(s1, s2);
    System.out.println("Using a joiner: ");
    System.out.println("\"" + s1 + "\" + \"" + s2 + "\" = \"" + s3 + "\"");
  }
}
