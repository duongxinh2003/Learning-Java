package day11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandomData {

	public ArrayList<Information> data = new ArrayList<>();

	public long randomBetween(long max, long min) {
		Random random = new Random();
		if (min == 0)
			return (long) (random.nextDouble() * max);
		else // random year and phone
			return (long) min + (long) (random.nextDouble() * (max - min));
	}

//	public synchronized Information randomInformation() throws ParseException {
//		Information information = new Information();
//		GregorianCalendar gCalendar = new GregorianCalendar();
//		long id = randomBetween(1000000000000L, 0);
//		int year = (int) randomBetween(2020L, 1900L);
//		gCalendar.set(Calendar.YEAR, year);
//		int day = (int) randomBetween(1, gCalendar.getActualMaximum(Calendar.DAY_OF_YEAR));
//		gCalendar.set(Calendar.DAY_OF_YEAR, day);
//		int month = gCalendar.get(Calendar.MONTH) + 1;
//		String date = day + "/" + month + "/" + year;
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		byte gender = (byte) randomBetween(2, 0);
//		String phone = "+84" + randomBetween(1000000000, 10000000);
//		information = new Information(id, sdf.parse(date), gender, phone);
//		return information;
//	}

	public Date randomDate() throws ParseException {
		GregorianCalendar gCalendar = new GregorianCalendar();
		int year = (int) randomBetween(2020L, 1900L);
		gCalendar.set(Calendar.YEAR, year);
		int day = (int) randomBetween(1, gCalendar.getActualMaximum(Calendar.DAY_OF_YEAR));
		gCalendar.set(Calendar.DAY_OF_YEAR, day);
		int month = gCalendar.get(Calendar.MONTH) + 1;
		String date = day + "/" + month + "/" + year;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(date);
	}

	public void runRandom(Information information) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				ArrayList<Information> i = new ArrayList<>();
				while (true) {
					try {
						synchronized (information) {
							information.setId(randomBetween(1000000000000L, 0L));
							information.setDate(randomDate());
							information.setGender((byte) randomBetween(2, 0));
							information.setPhone("+84" + randomBetween(1000000000, 10000000));
							i.add(information);
						}
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

//					System.out.println(information.toString());
					long end = System.currentTimeMillis();
					if (((end - start) / 1000) >= 5 && ((end - start) / 1000) % 5 == 0) {
						String time = (end - start) / 1000 + "";
						System.out.println(time);
//						System.out.println(i.size());
						try {
							Thread.sleep(30000);
							start = System.currentTimeMillis();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

			}
		}).start();
	}
}
