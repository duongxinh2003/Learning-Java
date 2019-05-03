package sonnh.reflection;

import java.util.Arrays;

public class ReflectionTest {
  public static void main(String[] args) {
    // Java reflection classes
    Class<ReflectionTest> test = ReflectionTest.class;
    System.out.println(test.getSimpleName());
    String[] array1 = {"a", "b", "c", "d", "e"};
    String[] array2 = {"1", "2", "3", "4"};
    System.out.println(Arrays.toString(merge(array1, array2)));
  }

  public static String[] merge(String[] arr1, String[] arr2) {
    String[] mergeArr = new String[arr1.length + arr2.length];
    for (int i = 0; i < mergeArr.length; i++) {
      if (i % 2 == 0) {
        mergeArr[i] = arr1[i / 2];
      } else {
        mergeArr[i] = arr2[i / 2];
      }
    }
    return mergeArr;
  }
}
