package com.revature.Project1.expReimbursement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="manager")

public class Manager {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="mid")
	int mid;
	@Column(name="des")
	String des="manager";
	@Column(name="fname")
	String fname;
	
	@Column(name="lname")
	String lname;
	@Column(name="pwd")
	
	String pwd;
	@Column(name="email")
	String email;
	@Column(name="phno")
	String phno;
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
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(String fname, String lname, String pwd, String email, String phno, String add,
			String city, String state, String country, String pin) {
		super();
		//this.mid = mid;
		//this.des = des;
		this.fname = fname;
		this.lname = lname;
		this.pwd = pwd;
		this.email = email;
		this.phno = phno;
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
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
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
	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", des=" + des + ", fname=" + fname + ", lname=" + lname + ", pwd=" + pwd
				+ ", email=" + email + ", phno=" + phno + ", add=" + add + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pin=" + pin + "]";
	}
	


}
