package com.revature.Project1.expReimbursement;

import java.util.Date;

import javax.persistence.Column;

public class ErUtils {

	
	
	
	
	
	int reqNo;

	Date dateofreq;
	@Column(name="rname")
	String rname;

	int amt;
	
	String description;
	
	String receipt;
	
	String status;
	
	int id;
	public ErUtils() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	



	public ErUtils(int reqNo, Date dateofreq, String rname, int amt, String description,String status,
			int id) {
		super();
		this.reqNo = reqNo;
		this.dateofreq = dateofreq;
		this.rname = rname;
		this.amt = amt;
		this.description = description;
		
		this.status = status;
		this.id = id;
	}







	public int getReqNo() {
		return reqNo;
	}
	public void setReqNo(int reqNo) {
		this.reqNo = reqNo;
	}
	public String getRname() {
		return rname;
	}
	




	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	

	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public Date getDateofreq() {
		return dateofreq;
	}



	public void setDateofreq(Date dateofreq) {
		this.dateofreq = dateofreq;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}







	@Override
	public String toString() {
		return "ErUtils [reqNo=" + reqNo + ", dateofreq=" + dateofreq + ", rname=" + rname + ", amt=" + amt
				+ ", description=" + description + ", receipt=" + receipt + ", status=" + status + ", id=" + id + "]";
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
