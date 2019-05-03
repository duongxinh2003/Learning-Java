package util;

import java.util.List;

public class ObjectTest3 {

  private List<String> firstList;

  private List<String> secondList;

  /**
   *
   */
  public ObjectTest3() {}

  /**
   * @param firstList
   * @param secondList
   */
  public ObjectTest3(List<String> firstList, List<String> secondList) {
    this.firstList = firstList;
    this.secondList = secondList;
  }

  /**
   * @return the firstList
   */
  public List<String> getFirstList() {
    return firstList;
  }

  /**
   * @param firstList the firstList to set
   */
  public void setFirstList(List<String> firstList) {
    this.firstList = firstList;
  }

  /**
   * @return the secondList
   */
  public List<String> getSecondList() {
    return secondList;
  }

  /**
   * @param secondList the secondList to set
   */
  public void setSecondList(List<String> secondList) {
    this.secondList = secondList;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "ObjectTest3 [firstList=" + firstList + ", secondList=" + secondList + "]";
  }

}
