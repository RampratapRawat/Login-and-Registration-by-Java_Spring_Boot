package com.example.response;

public class LoginMesage {
      String message;
      Boolean status;
	
      public LoginMesage(String message, Boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LoginMesage() {
		super();
		// TODO Auto-generated constructor stub
	}
      
	@Override
	public String toString() {
		return "LoginMesage [message=" + message + ", status=" + status + "]";
	} 
      
}
