package sonnh.lambdaexpression;

public class TargetTypeTest {
  public static void main(String[] args) {
    // Create an Adder using a Lambda expression
    Adder adder = (x, y) -> x + y;

    // Creates a Joiner using a Lambda expression
    Joiner joiner = (x, y) -> x + y;

    // Adds two doubles
    double sum1 = adder.add(10.34, 89.22);

    // Add two lists
    double sum2 = adder.add(10, 89);

    // Joins two strings
    String str = joiner.join("Hello", " lambda");

    System.out.println("sum1 = " + sum1);
    System.out.println("sum2 = " + sum2);
    System.out.println("str = " + str);
  }
}
