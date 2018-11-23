package ru.makhnutin.contacts.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="CONTACTS")
public class Contact {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="F_NAME", nullable=false)
	private String firstName;

	@Column(name="S_NAME", nullable=false)
	private String secondName;

	@Column(name="E_MAIL")
	private String email;

	@Column(name="PHONE")
	private String phone;

	@Column(name="B_DAY")
	private Date birthDay;

	public Contact() {
	}

	public Contact(String firstName, String secondName, String email, String phone, Date birthDay) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.email = email;
		this.phone = phone;
		this.birthDay = birthDay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

}
