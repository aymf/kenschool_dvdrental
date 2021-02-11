package jp.ken.kadai.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeKadaiModel implements Serializable{

	@NotEmpty(message="名前は必須入力です。")
	private String name;
	
	@NotEmpty(message="フリガナは必須入力です。")
	private String kana;
	private String gender;
	private String bYear;
	private String bMonth;
	private String bDay;
	
	@NotEmpty(message="郵便番号は必須入力です。")
	@Pattern(regexp="^[0-9]{3}-[0-9]{4}$",message="郵便番号ではありません。")
	private String zip;
	
	@NotEmpty(message="住所は必須入力です。")
	private String address;
	
	@NotEmpty(message="携帯番号は必須入力です。")
	@Pattern(regexp="^[0-9]{3}-[0-9]{4}-[0-9]{4}$",message="携帯番号ではありません。")
	private String phone;
	
	@NotEmpty(message="メールアドレスは必須入力です。")
	@Email(message="メールアドレスではありません。")
	private String mail;
	private String[] capacities;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKana() {
		return kana;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getbYear() {
		return bYear;
	}

	public void setbYear(String bYear) {
		this.bYear = bYear;
	}

	public String getbMonth() {
		return bMonth;
	}

	public void setbMonth(String bMonth) {
		this.bMonth = bMonth;
	}

	public String getbDay() {
		return bDay;
	}

	public void setbDay(String bDay) {
		this.bDay = bDay;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String[] getCapacities() {
		return capacities;
	}

	public void setCapacities(String[] capacities) {
		this.capacities = capacities;
	}
	
}
