package sonnh.reflection;

import java.io.Serializable;

public class Person implements Serializable, Cloneable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private int id = 1;
  private String name = "Son";

  public Person() {}

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public Object clone() {
    try {
      return super.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + "]";
  }

}
