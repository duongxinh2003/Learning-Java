 package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyData {
	
	private long id;
	private Date date;
	private byte gender;
	private String phone;
	
	public MyData() {
	}

	public MyData(long id, Date date, byte gender, String phone) {
		this.id = id;
		this.date = date;
		this.gender = gender;
		this.phone = phone;
	}

	public synchronized long getId() {
		return id;
	}

	public synchronized void setId(long id) {
		this.id = id;
	}

	public synchronized Date getDate() {
		return date;
	}

	public synchronized void setDate(Date date) {
		this.date = date;
	}

	public synchronized byte getGender() {
		return gender;
	}

	public synchronized void setGender(byte gender) {
		this.gender = gender;
	}

	public synchronized String getPhone() {
		return phone;
	}

	public synchronized void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public synchronized String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "id=" + id + ", date=" + simpleDateFormat.format(date) + ", gender=" + (gender==0?"Male":"Female") + ", phone=" + phone+System.getProperty("line.separator");
	}
}
