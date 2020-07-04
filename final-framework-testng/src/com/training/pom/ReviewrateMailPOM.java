package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewrateMailPOM {
	private WebDriver driver; 
	
	public ReviewrateMailPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),'innovationtesting1')]")
	private WebElement Course;
	
	//Assignments link
	@FindBy(xpath="//img[@id='toolimage_20171']") 
	private WebElement Assigned;
	
	@FindBy(xpath="//a[text()='AssignmentSoni']")
	private WebElement dispAssignments;
	
	@FindBy(xpath="(//img[@title='Correct and rate'])[2]")
	private WebElement Correctandrate;
	
	@FindBy(xpath="//input[@id='qualification']")
	private WebElement Score;
	
	@FindBy(xpath="//input[@name='send_email']")
	private WebElement SendMail;
	
	@FindBy(xpath="//button[@id='work_comment_button']")
	private WebElement SendMessage;
	
	@FindBy(xpath="//div[text()='Update successful']")
	private WebElement update;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickcourse() {
		this.Course.click();
	}
	
	public void clickAssigned() {
		this.Assigned.click();
	}
	
	public void clickdispAssignments() {
		this.dispAssignments.click();
	}
	
	public void clickcorrectandrate() {
		this.Correctandrate.click();
	}
	
	public void EnterScore(String Score) {
		
		this.Score.clear();
		this.Score.sendKeys(Score);
	}
	
	public void SendMail() {
		 this.SendMail.click();
	}
	
	public void SendMessage() {
		this.SendMessage.click();
	}
	
	public String update() {
		return this.update.getText();
	}
	
}
