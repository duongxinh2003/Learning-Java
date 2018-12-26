package day11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandomData implements Runnable {
	
	private Information info;
	
	public static long randomBetween(long max, long min) {
		Random random = new Random();
		if(min == 0) 
			return (long) (random.nextDouble()*max);
		else //random year and phone
			return (long) min + (long) (random.nextDouble()*(max-min));
	}
	
	public synchronized Information randomInformation() throws ParseException {
		Information information = new Information();
		GregorianCalendar gCalendar = new GregorianCalendar();
		long id = randomBetween(1000000000000L,0);
		int year = (int) randomBetween(2020L, 1900L);
		gCalendar.set(Calendar.YEAR, year);
		int day = (int) randomBetween(1, gCalendar.getActualMaximum(Calendar.DAY_OF_YEAR));
		gCalendar.set(Calendar.DAY_OF_YEAR, day);
		int month = gCalendar.get(Calendar.MONTH)+1;
		String date = day + "/" + month + "/" + year;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		byte gender = (byte) randomBetween(2, 0);
		String phone = "+84" + randomBetween(1000000000, 10000000);
		information = new Information(id, sdf.parse(date), gender, phone);
		return information;
	}

	@Override
	public void run() {
		long start = System.currentTimeMillis();
		while (true) {
			long end = System.currentTimeMillis();
			try {
				setInfo(randomInformation());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(((end-start)/1000)>=5 && ((end-start)/1000)%5 == 0) {
				String time = (end -start)/1000 + "";
				System.out.println(time);
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void setInfo(Information info) {
		this.info = info;
	}
	
}
