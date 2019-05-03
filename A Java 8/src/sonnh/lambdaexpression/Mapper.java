package sonnh.lambdaexpression;

public interface Mapper<T> {
  // An abstract method
  int map(T array);

  // A generic static method
  public static <U> int[] listToMapper(U[] list, Mapper<? super U> mapper) {
    int[] mapperValue = new int[list.length];
    for (int i = 0; i < list.length; i++) {
      // Map the object to an int
      mapperValue[i] = mapper.map(list[i]);
    }
    return mapperValue;
  }
}
