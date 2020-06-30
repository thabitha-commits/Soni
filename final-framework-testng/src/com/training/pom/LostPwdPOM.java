package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LostPwdPOM {

	private WebDriver driver; 
	
	public LostPwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="lost_password_user")
	private WebElement Lusername;
	
	@FindBy(id="lost_password_submit")
	private WebElement clicksendmessage;
	
	@FindBy(linkText="I lost my password")
	private WebElement lostpwd;
	
	public void clicklostpwd() {
		this.lostpwd.click(); 
	}
	
	
	public void sendLusername(String Lusername) {
		this.Lusername.sendKeys(Lusername);
	}

	public void clicksendmessage() {
		this.clicksendmessage.click();
	}
	
	
}
