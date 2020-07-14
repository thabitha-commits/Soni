package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPOM {

private WebDriver driver; 

public AddUserPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}


@FindBy(id="login")
private WebElement userName; 

@FindBy(id="password")
private WebElement password;

@FindBy(id="form-login_submitAuth")
private WebElement loginBtn; 

@FindBy(xpath="//a[contains(text(),'Add a user')]")
private WebElement AddUser;

@FindBy(name="firstname")
private WebElement FirstName;

@FindBy(name="lastname")
private WebElement lastname;

@FindBy(name="email")
private WebElement email;

@FindBy(name="phone")
private WebElement Phone;

@FindBy(name="username")
private WebElement Login;

@FindBy(xpath="//input[@name='password[password_auto]']")
private WebElement passwordcheck;

@FindBy(xpath="//input[@name='password[password]'][@type='password']")
private WebElement Userpassword;

@FindBy (xpath="//div[text()='Learner']")
private WebElement Profile;

@FindBy(xpath="//button[@name='submit']")
private WebElement Addbutton;

@FindBy(xpath="//div[@class='alert alert-info']")
private WebElement useradded;


@FindBy(xpath="//a[text()='Administration']	")
private WebElement Administration;

@FindBy(xpath="//text()[contains(.,'Logout')]/ancestor::a[1]")
private WebElement Logout;

@FindBy(xpath="//span[contains(text(),'Trainer')]")
private WebElement trainer;

public void sendUserName(String userName) {
	this.userName.clear();
	this.userName.sendKeys(userName);
}

public void enterPassword(String password) {
	this.password.clear(); 
	this.password.sendKeys(password); 
}


public void clicklogout() {
	this.Logout.click(); 
}


public void clickLoginBtn() {
	this.loginBtn.click(); 
}

	public void sendFirstName(String FirstName) {
		this.FirstName.sendKeys(FirstName);
	}
	
	public void sendlastname(String lastname) {
		this.lastname.sendKeys(lastname);
	}
	
	public void sendemail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void enterlogin(String Login) {
		this.Login.clear();
		this.Login.sendKeys(Login);
	}
	
	
	public void Phone (String Phone) {
		this.Phone.clear();
		this.Phone.sendKeys(Phone);
	}
	
	public void passwordcheck() {
		this.passwordcheck.click();
	}
	
	public void enterUserpassword(String Userpassword) {
		this.Userpassword.sendKeys(Userpassword);
	}
	
	public void selecprofile() {
		this.Profile.click();
	}
	
	public void trainer() {
		this.trainer.click();
	}
	public void clickAdd() {
		this.Addbutton.click(); 
	}
	
	public String useradded() {
		String text = this.useradded.getText();
		System.out.println(text);
		return this.useradded.getText();
	}
	
	public void AddaUser() {
		this.AddUser.click();
		}
	
	public void clickAdministration() {
		this.Administration.click(); 
	}
}
	
	
	
	
	
		

