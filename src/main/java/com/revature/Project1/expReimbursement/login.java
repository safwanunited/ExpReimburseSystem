package com.revature.Project1.expReimbursement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

public class login {
	int uid;
private String pwd,des;
public login() {
	super();
	// TODO Auto-generated constructor stub
}
public login(int uid, String pwd, String des) {
	super();
	this.uid = uid;
	this.pwd = pwd;
	this.des = des;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getDes() {
	return des;
}
public void setDes(String des) {
	this.des = des;
}
@Override
public String toString() {
	return "login [uid=" + uid + ", pwd=" + pwd + ", des=" + des + "]";
}












}