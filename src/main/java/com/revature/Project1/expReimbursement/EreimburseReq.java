package com.revature.Project1.expReimbursement;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="EreimburseReq")

class EreimburseReq {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="reqNo")
	int reqNo;
	@Column(name="dateofreq")
	Date dateofreq;
	@Column(name="rname")
	String rname;
	@Column(name="amt")
	int amt;
	@Column(name="description")
	String description;
	@Column(name="receipt")
	String receipt;
	@Column(name="status")
	String status;
	@ManyToOne
	@JoinColumn(name="id",referencedColumnName="id")
	Employee emp;
	public EreimburseReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public EreimburseReq(Date dateofreq, String rname, int amt, String description, String status,
			Employee emp) {
		super();
		this.dateofreq = dateofreq;
		this.rname = rname;
		this.amt = amt;
		this.description = description;
	
		this.status = status;
		this.emp = emp;
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

	public Employee getEmp() {
		return emp;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
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
		return "EreimburseReq [reqNo=" + reqNo + ", dateofreq=" + dateofreq + ", rname=" + rname + ", amt=" + amt
				+ ", description=" + description + ", receipt=" + receipt + ", status=" + status + ", emp=" + emp + "]";
	}







	

	
	
	
	
}