package com;

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

import day11.Information;

public class RandomData implements Runnable {

	private BlockingQueue<String> drop;
	private BlockingQueue<CopyOnWriteArrayList<Information>> listThousandData;

	public RandomData(BlockingQueue<String> drop, BlockingQueue<CopyOnWriteArrayList<Information>> listThousandData) {
		this.drop = drop;
		this.listThousandData = listThousandData;
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		int cnt = 0;
		CopyOnWriteArrayList<Information> list = new CopyOnWriteArrayList<>();
		while (true) {
			try {
				if(drop.offer(randomInformation().toString(), 1, TimeUnit.SECONDS)) {
					
				}
				list.add(randomInformation());
				cnt++;
				if(list.size()% 1000 == 0) {
					listThousandData.offer(list, 1, TimeUnit.SECONDS);
					list.removeAll(list);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long end = System.currentTimeMillis();
			if (((end - start) / 1000) >= 5 && ((end - start) / 1000) % 5 == 0) {
				try {
					listThousandData.offer(list, 1, TimeUnit.SECONDS);
					System.out.println("Total random size: " + cnt);
					System.out.println("Random is sleeping.....");
					Thread.sleep(30000);
					System.out.println("Wake up......");
					start = System.currentTimeMillis();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
