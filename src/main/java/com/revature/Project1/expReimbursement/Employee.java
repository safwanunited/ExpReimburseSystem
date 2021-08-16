package com.revature.Project1.expReimbursement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee")

public class Employee {
	@Column(name="des")
	String des="employee";
	@Column(name="fname")
	String fname;
	
	@Column(name="lname")
	String lname;
	@Column(name="uname")
	String pwd;
	@Column(name="email")
	String email;
	@Column(name="pan")
	String pan;
	
	@Column(name="phno")
	String phno;
	@Column(name="dob")
	String dob;
	@Column(name="add")
	String add;
	@Column(name="city")
	String city;
	@Column(name="state")
	String state;
	@Column(name="country")
	String country;
	@Column(name="pin")
	String pin;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee( String fname, String lname, String pwd, String email, String pan, String phno,
			String dob, String add, String city, String state, String country, String pin) {
		super();
		//this.des = des;
		this.fname = fname;
		this.lname = lname;
		this.pwd = pwd;
		this.email = email;
		this.pan = pan;
		this.phno = phno;
		this.dob = dob;
		this.add = add;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin = pin;
		
	}
	
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [des=" + des + ", fname=" + fname + ", lname=" + lname + ", pwd=" + pwd + ", email=" + email
				+ ", pan=" + pan + ", phno=" + phno + ", dob=" + dob + ", add=" + add + ", city=" + city + ", state="
				+ state + ", country=" + country + ", pin=" + pin + ", id=" + id + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}










