package model;

import java.io.Serializable;

public class User implements Serializable{

	private String loginID;
	private String password;
	private String name;

	public User() {

	}

	public User(String loginID,String password,String name) {
		this.loginID = loginID;
		this.password = password;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
