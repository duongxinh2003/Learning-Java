package util;

/**
 * The Class ObjectTest2.
 */
public class ObjectTest2 {

  /** The id. */
  private int id;

  /** The name. */
  private String name;

  /**
   * Instantiates a new object test 2.
   */
  public ObjectTest2() {}

  /**
   * Instantiates a new object test 2.
   *
   * @param id the id
   * @param name the name
   */
  public ObjectTest2(int id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * Sets the id.
   *
   * @param id the new id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   *
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "ObjectTest2 [id=" + id + ", name=" + name + "]";
  }

}
