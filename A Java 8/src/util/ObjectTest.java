package util;

import java.util.List;

/**
 * The Class ObjectTest.
 */
public class ObjectTest {

  /** The id. */
  private int id;

  /** The name. */
  private String name;

  private List<String> dataList;

  /**
   * Instantiates a new object test.
   */
  public ObjectTest() {}

  /**
   * Instantiates a new object test.
   *
   * @param id the id
   * @param name the name
   */
  public ObjectTest(int id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * @param id
   * @param name
   * @param dataList
   */
  public ObjectTest(int id, String name, List<String> dataList) {
    this.id = id;
    this.name = name;
    this.dataList = dataList;
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

  /**
   * @return the dataList
   */
  public List<String> getDataList() {
    return dataList;
  }

  /**
   * @param dataList the dataList to set
   */
  public void setDataList(List<String> dataList) {
    this.dataList = dataList;
  };
}
