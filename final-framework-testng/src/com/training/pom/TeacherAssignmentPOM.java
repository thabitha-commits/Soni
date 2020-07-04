package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherAssignmentPOM {
	private WebDriver driver; 
	
	public TeacherAssignmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),'testing innovation')]")
	private WebElement course;
		
	@FindBy(xpath="//img[@id='toolimage_20023']")
	private WebElement Assignment;
	
	@FindBy(xpath="//img[@title='Create assignment']")
	private WebElement createAssignment;
	
	@FindBy(xpath="//input[@id='form1_new_dir']")
	private WebElement Assignmentname;
	
	@FindBy(xpath="//div[@id='cke_1_contents']//iframe")
	private WebElement frameDescription;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement inputDescription;
	
	@FindBy(xpath="//text()[contains(.,'Advanced settings')]/ancestor::button[1]")
	private WebElement advancedsettings;
	
	@FindBy(xpath="//input[@id='form1_qualification']")
	private WebElement Maximumscore;
	
	@FindBy(xpath="//button[@id='form1_submit']")
	private WebElement validatebtn;
	
	@FindBy(xpath="//div[(text())='Directory created']")
	private WebElement dircreated;
		
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
		this.course.click();
	}
	
	public void clickAssignments() {
		this.Assignment.click();
	}
	
	public void createAssignments() {
		this.createAssignment.click();
	}
	
	public void enterAssignmentname(String Assignmentname) {
		
		this.Assignmentname.sendKeys(Assignmentname);
	}
	
	public void frameDescription() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(this.frameDescription);
	}
	
	public void Advancedsettings() {
		driver.switchTo().defaultContent();
		this.advancedsettings.click();
		}
	
	public void enterMaximumscore(String Maximumscore) {
		this.Maximumscore.sendKeys(Maximumscore);
	}
	
	public void clickvalidate() {
		this.validatebtn.click(); 
	}
	
	public String dircreated() {

		return this.dircreated.getText();	
		}
	
	public void inputDescription(String inputDescription) {
		
		this.inputDescription.sendKeys(inputDescription);
	}
	
}
