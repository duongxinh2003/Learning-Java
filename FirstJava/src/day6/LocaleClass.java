package day6;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class LocaleClass {
	public static void main(String[] args) {
		Locale vietnam = new Locale("vi","VN");
		Locale usa = Locale.US;
		Locale english = new Locale("en");
		Locale uk = Locale.ENGLISH;
		System.out.println(Arrays.toString(Locale.getISOCountries()));
		System.out.println(Arrays.toString(Locale.getISOLanguages()));
		if(vietnam.equals(usa)) {
			System.out.println("Something went wrong.");
		}
		if (english.equals(uk)) {
			System.out.println("English = United kingdom");
		}
		System.out.println("Default locale: " + Locale.getDefault());
		System.out.println("Vietnam language: " + vietnam.getLanguage());
		System.out.println("VN country: " + vietnam.getDisplayCountry());
		
		//Number format by locale
		double point = 189.425;
		double percent = 0.56;
		NumberFormat numberFormatVietNam = NumberFormat.getInstance(vietnam);
		System.out.println(numberFormatVietNam.format(point));
		numberFormatVietNam = NumberFormat.getPercentInstance(vietnam);
		System.out.println(numberFormatVietNam.format(percent));
		NumberFormat numberFormatUS = NumberFormat.getInstance(usa);
		System.out.println("US");
		System.out.println(numberFormatUS.format(point));
		numberFormatUS = NumberFormat.getPercentInstance(usa);
		System.out.println(numberFormatUS.format(percent));
		
		//Format date
		Date date = new Date();
		DateFormat dateFormatVietNam = DateFormat.getDateInstance(DateFormat.MEDIUM, vietnam);
		DateFormat dateFormatUS = DateFormat.getDateInstance(DateFormat.MEDIUM, usa);
		DateFormat dateFormatChina = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CHINA);
		System.out.println(dateFormatVietNam.format(date));
		System.out.println(dateFormatUS.format(date));
		System.out.println(dateFormatChina.format(date));
	}
}
