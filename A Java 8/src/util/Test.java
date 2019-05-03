package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.springframework.util.ObjectUtils;

public class Test {
  private ObjectTest data = new ObjectTest(10, "test");

  public static void main(String[] args)
      throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    LocalDateTime departureDate = LocalDate
        .parse("20190226", DateTimeFormatter.ofPattern("yyyyMMdd")).atStartOfDay();
    List<String> listString = Arrays.asList("5", "a", "A", "g", "9");
    Consumer<String> print = e -> {
      System.out.println(e.equalsIgnoreCase("a"));
    };
    listString.forEach(print);
    System.out.println(departureDate);
    Test test = new Test();
    test.getIdTest();
    // Class<ObjectTest> obj = ObjectTest.class;
    ObjectTest objectTest = new ObjectTest();
    extracted(objectTest);
    System.out.println(objectTest.getName());
    List<String> content = new ArrayList<>();
    content.add(new ObjectTest(50, "xjz").getName());
    content.add(new ObjectTest2(50, "xjzfsdfa").getName());
    System.out.println(content.toString());
    List<String> data = new ArrayList<>();
    ObjectTest3 test3 = new ObjectTest3(data, data);
    System.out.println(ObjectUtils.isEmpty(test3));
    data.add("1");
    data.add("3");
    data.add("6");
    data.add("1");
    data.add("9");
    data.removeIf(e -> !"0".equals(e));
    data.stream().findFirst();
    System.out.println(data.toString());
    int count = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.println(count++);
      }
      for (int j = 0; j < 3; j++) {
        System.out.println(count++);
      }
    }
    int[] arr = {3, 1, 4, 5, 0, 9, 7, 6, 8, 2};
    quickSort(arr, 0, arr.length - 1);
  }

  private static void extracted(ObjectTest objectTest)
      throws IllegalAccessException, InvocationTargetException {
    try {
      Method method = ObjectTest.class.getDeclaredMethod("setName", String.class);
      method.setAccessible(true);
      method.invoke(objectTest, "testttttttttt");
      // System.out.println(objectTest.getName());
    } catch (Exception e1) {
      e1.printStackTrace();
    }
  }

  public void getIdTest() {
    int c = data.getId();
    System.out.println(c);
    c = 90;
    System.out.println(c);
  }

  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pivot = partition(arr, low, high);
      quickSort(arr, pivot, low - 1);
      quickSort(arr, high + 1, pivot);
    }
  }

  private static int partition(int[] arr, int low, int high) {

    return low;
  }

}
