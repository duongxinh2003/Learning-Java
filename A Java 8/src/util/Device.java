package util;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Device implements Delayed {

  public void handleData(ObjectTest2 objectTest2, String thread) {
    System.out.println(thread + " " + objectTest2.toString());
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int compareTo(Delayed o) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public long getDelay(TimeUnit unit) {
    long diff = System.currentTimeMillis();
    return unit.convert(diff, TimeUnit.MILLISECONDS);
  }
}
