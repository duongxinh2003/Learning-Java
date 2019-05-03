package sonnh.lambdaexpression;

public class LambdaUtil2Test {
  public static void main(String[] args) {
    LambdaUtil2 util2 = new LambdaUtil2();
    // A compile error
    // util2.test((x, y) -> x + y);
    // Fix error
    util2.test((double x, double y) -> x + y); // solution 1
    util2.test((Adder) (x, y) -> x + y); // solution 2
    // Solution 3
    Adder adder = (x, y) -> x + y;
    util2.test(adder);

    // Calls the testJoiner() method
    util2.test((String x, String y) -> x + y);

    // Calls the testJoiner() method. The Joiner will
    // add a space between the two strings
    util2.test((Joiner) (x, y) -> x + y);

    // Call the testJoiner() method. The joiner will
    // reserve the strings and join resulting strings in
    // reserve order adding a comma in between
    util2.test((Joiner) (x, y) -> {
      StringBuilder sbx = new StringBuilder(x);
      StringBuilder sby = new StringBuilder(y);
      sby.reverse().append(",").append(sbx.reverse());
      return sby.toString();
    });
  }
}
