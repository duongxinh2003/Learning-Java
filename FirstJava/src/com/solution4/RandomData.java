package com.solution4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class RandomData implements Runnable {

	private BlockingQueue<Information> listData;

	public RandomData(BlockingQueue<Information> listData) {
		this.listData = listData;
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		int cnt = 0;
		while (true) {
			try {
				listData.offer(randomInformation(), 10, TimeUnit.SECONDS);
				
			} catch (InterruptedException | ParseException e) {
				e.printStackTrace();
			}
			long end = System.currentTimeMillis();
			System.out.println("Size: " + listData.size());
			if (((end - start) / 1000) >= 900 && ((end - start) / 5) % 900 == 0) { //900
					System.out.println("Random is stopped.....");
					return;
			}
		}

	}

	public static long randomBetween(long max, long min) {
		Random random = new Random();
		if (min == 0)
			return (long) (random.nextDouble() * max);
		else // random year and phone
			return (long) min + (long) (random.nextDouble() * (max - min));
	}

	public synchronized Information randomInformation() throws ParseException {
		Information information = new Information();
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
		information = new Information(id, sdf.parse(date), gender, phone);
		return information;
	}

}
