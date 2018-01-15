package model;

import java.io.Serializable;

public class User implements Serializable{

	private String loginID;
	private String password;

	public User() {

	}

	public User(String loginID,String password) {
		this.loginID = loginID;
		this.password = password;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
