package sonnh.lambdaexpression;

public class MapperTest {
  public static void main(String[] args) {
    // Mapp names using their length
    System.out.println("Mapping names to their lengths: ");
    String[] names = {"David", "Son", "Trng"};
    int[] lengthMapping = Mapper.listToMapper(names, (String name) -> name.length());
    printMapping(names, lengthMapping);

    System.out.println("\nMapping integers to theirs squares: ");
    Integer[] numbers = {7, 3, 67};
    int[] countMapping = Mapper.listToMapper(numbers, (Integer n) -> n * n);
    printMapping(numbers, countMapping);
  }

  public static void printMapping(Object[] from, int[] to) {
    for (int i = 0; i < from.length; i++) {
      System.out.println(from[i] + " mapped to " + to[i]);
    }
  }
}
