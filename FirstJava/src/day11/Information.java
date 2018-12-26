package day11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Information {
	private long id;
	private Date date;
	private byte gender;
	private String phone;
	
	public Information() {
	}

	public Information(long id, Date date, byte gender, String phone) {
		this.id = id;
		this.date = date;
		this.gender = gender;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "id=" + id + ", date=" + simpleDateFormat.format(date) + ", gender=" + (gender==0?"Male":"Female") + ", phone=" + phone +"\n";
	}

	
}
