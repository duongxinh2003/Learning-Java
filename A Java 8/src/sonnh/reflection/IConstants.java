package sonnh.reflection;

public interface IConstants {
  int DAYS_IN_WEEK = 7;
}

class A implements IConstants {
  private int aPrivate;
  public int aPublic;
  protected int bProtected;
}

class B extends A {
  private int bPrivate;
  public int bPublic;
  protected int bProtected;
}
