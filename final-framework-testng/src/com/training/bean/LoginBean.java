package com.training.bean;

public class LoginBean {
	private String FirstName;
	private String lastname;
	private String email;
	private String Phone;
	private String Login;
	private String Userpassword;
	
	
	public LoginBean() {
	}
	
	
	public LoginBean(String FirstName, String lastname, String email, String Phone,String Login, String Userpassword) {
		super();
		this.FirstName = FirstName;
		this.lastname = lastname;
		this.email = email;
		this.Phone = Phone;
		this.Login =  Login;
		this.Userpassword = Userpassword;
	}


	public String getFirstName() {
		return FirstName;
	}


	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		this.Phone = phone;
	}


	public String getLogin() {
		return Login;
	}


	public void setLogin(String login) {
		this.Login = login;
	}


	public String getUserpassword() {
		return Userpassword;
	}


	public void setUserpassword(String Userpassword) {
		this.Userpassword = Userpassword;
	}


	@Override
	public String toString() {
		return "LoginBean [FirstName=" + FirstName + ",lastname=" + lastname + ",email=" + email + ",Phone=" + Phone + ",Login=" + Login + ",Userpassword=" + Userpassword + "]";
	}

}
