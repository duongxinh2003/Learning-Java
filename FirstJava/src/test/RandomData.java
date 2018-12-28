package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import day11.Information;

public class RandomData {
	
	public MyList myList;
	
	public RandomData(MyList myList) {
		this.myList = myList;
	}
	
	public long randomBetween(long max, long min) {
		Random random = new Random();
		if (min == 0)
			return (long) (random.nextDouble() * max);
		else // random year and phone
			return (long) min + (long) (random.nextDouble() * (max - min));
	}

	public synchronized MyData randomInformation() throws ParseException {
		MyData information = new MyData();
		GregorianCalendar gCalendar = new GregorianCalendar();
		long id = randomBetween(1000000000000L, 0);
		int year = (int) randomBetween(2020L, 1900L);
		gCalendar.set(Calendar.YEAR, year);
		int day = (int) randomBetween(1, gCalendar.getActualMaximum(Calendar.DAY_OF_YEAR));
		gCalendar.set(Calendar.DAY_OF_YEAR, day);
		int month = gCalendar.get(Calendar.MONTH) + 1;
		String date = day + "/" + month + "/" + year;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		byte gender = (byte) randomBetween(2, 0);
		String phone = "+84" + randomBetween(1000000000, 10000000);
		information = new MyData(id, sdf.parse(date), gender, phone);
		return information;
	}
	
	public void runThread(Object object) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				ArrayList<MyData> list = new ArrayList<>();
				while (true) {
					synchronized (myList) {
						try {
							list.add(randomInformation());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						myList.setList(list);
//						System.out.println(myList.getList().toString());
//						myList.notify();
						
						long end = System.currentTimeMillis();
						synchronized (myList) {
							if (((end - start) / 1000) >= 5 && ((end - start) / 1000) % 5 == 0) {
								String time = (end - start) / 1000 + "";
								System.out.println(time);
								try {
									myList.wait(30000);
									start = System.currentTimeMillis();
									list.removeAll(list);
									myList.notify();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}).start();
	}
}
