package model;

import java.io.Serializable;

public class User implements Serializable{

	private String loginID;
	private String password;
	private String name;
	private String birth_date;
	private String create_date;
	private String update_date;
	private String id;

	public User() {

	}

	public User(
			String loginID,String password,String name,String id,
			String birth_date,String create_date,String update_date) {
		this.loginID = loginID;
		this.password = password;
		this.name = name;
		this.id = id;
		this.birth_date = birth_date;
		this.create_date = create_date;
		this.update_date = update_date;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
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
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



}
