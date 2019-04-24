package com.project;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import com.program.Information;

class RandomData {
    private final Random random = new SecureRandom();
    
    public long randomBetween(long max, long min) {
		Random random = new Random();
		if (min == 0)
			return (long) (random.nextDouble() * max);
		else // random year and phone
			return (long) min + (long) (random.nextDouble() * (max - min));
	}

	public Information randomData() throws ParseException {
		GregorianCalendar gCalendar = new GregorianCalendar();
		Information information = new Information();
		int id = (int) randomBetween(1000000000000L, 0L);
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

    private long nextLong(long l, long r) {
        return l + Math.abs(random.nextLong()) % (r - l + 1);
    }

    private int nextInt(int l, int r) {
        return l + random.nextInt(r - l + 1);
    }

    String getRecord() {
        long id = nextLong(100000000000L, 999999999999L);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, nextInt(1950, 2018));
        calendar.set(Calendar.DAY_OF_YEAR, nextInt(1, calendar.getActualMaximum(Calendar.DAY_OF_YEAR)));
        String phoneNumber = "+84" + nextLong(100000000L, 999999999L);
        return id
                + ";"
                + String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
                + "-"
                + String.format("%02d", calendar.get(Calendar.MONTH) + 1)
                + "-"
                + calendar.get(Calendar.YEAR)
                + ";"
                + random.nextInt(2)
                + ";"
                + phoneNumber;
    }

    public static void main(String[] args) {
    }
}
