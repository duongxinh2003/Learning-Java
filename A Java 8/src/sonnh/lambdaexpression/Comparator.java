package sonnh.lambdaexpression;

@FunctionalInterface
public interface Comparator<T> {
  // Abstract method declare in interface
  int compare(T o1, T o2);

  @Override
  boolean equals(Object object);
}
