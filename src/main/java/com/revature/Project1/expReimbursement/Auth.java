package com.revature.Project1.expReimbursement;

public class Auth {

	private String status;
	private String role;

	public Auth() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Auth(String status, String role) {
		super();
		this.status = status;
		this.role = role;
	}



	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Auth [status=" + status + ", role=" + role + "]";
	}
	
	
	
}
