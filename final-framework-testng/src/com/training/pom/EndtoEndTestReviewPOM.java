package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EndtoEndTestReviewPOM {
	private WebDriver driver; 
	
	public EndtoEndTestReviewPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//img[@id='toolimage_20016']")
	private WebElement Tests;
	
	@FindBy(xpath="//img[@title='Create a new test']")
	private WebElement CreateTest;
	
	@FindBy(xpath="//*[@class='table-responsive']/table/tbody/tr[@id='exercise_list_386']")
	private WebElement trailtest2;
	
	@FindBy(xpath="//div[@id='cke_1_contents']//iframe")
	private WebElement frameDescription;
	
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement contexttest;
	
	@FindBy(xpath="//text()[contains(.,'Advanced settings')]/ancestor::button[1]")
	private WebElement advancedsettings;
	
	@FindBy(xpath="//label[contains(text(),'Enable start time')]")
	private WebElement EnableStartTime;
	
	@FindBy(xpath="//div[@id='date_time_wrapper_start_time']//span[@class='fa fa-trash text-danger']")
	private WebElement Deletedate;
	
	@FindBy(xpath="//p[@id='start_time_alt_text']")
	private WebElement calendarinput;
	
	
	@FindBy(xpath="//button[@class=\"ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all']")
	private WebElement Donebutton;
	
	@FindBy(xpath="//input[@id='pass_percentage']")
	private WebElement passpercentage;
	
	@FindBy(xpath="//button[@id='exercise_admin_submitExercise']")
	private WebElement proceedtoq;
	
	@FindBy(xpath="//section[@id='cm-content']//li[1]//div[1]")
	private WebElement multiplechoice;
	
	@FindBy(xpath="//input@id='question_admin_form_questionName']")
	private WebElement question;
	
	@FindBy(xpath=" //div[@id='cke_2_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement framechoice1;
	
	@FindBy(xpath="//div[@id='cke_4_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement framechoice2;
	
	@FindBy(xpath="//div[@id='cke_6_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement framechoice3;
	
	@FindBy(xpath="//div[@id='cke_8_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")
	private WebElement framechoice4;
	
	@FindBy(xpath="//button[@id='submit-question']")
	private WebElement Addquestion;
	
	@FindBy(xpath="//section[@id='cm-content']//li[2]/div")
	private WebElement multiplechoice2;
	
	@FindBy(xpath="//input[@id='qf_e1e106']")
	private WebElement radiosecondoption;
	
	@FindBy(xpath="//div[@class='actions']//a[2]//img[1]")
	private WebElement preview;
	
	@FindBy(xpath="//a[@class='btn btn-default btn-sm']")
	private WebElement studentview;
	
	@FindBy(xpath="//a[contains(text(),'My courses')]")
	private WebElement mycourses;
	
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement coursecatalog;
	
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement entersearch;
	
	@FindBy(xpath="//div[@class='input-group']//button[1]")
	private WebElement clicksearch;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-sm']")
	private WebElement subscribebutton;
	
	@FindBy(xpath="//a[contains(text(),'Assignment1')]")
	private WebElement clickAssignment;
	
	@FindBy(xpath="//a[@id='logout_button']")
	private WebElement logout;
	
	@FindBy(xpath="//img[@id='toolimage_20164']")
	private WebElement Testsicon;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	private WebElement starttest;
	
	@FindBy(xpath="//*[@class='question_options']//label/input")
	private WebElement choice1;
	
	@FindBy(xpath="//*[@class='question_options']//label/input[@id='choice-355-1']")
	private WebElement radiobutton2;
	
	@FindBy(xpath="//button[@name='save_now']")
	private WebElement Endtest;
	
	@FindBy(xpath="//*[@class='form-actions']")
	private WebElement Nextquestion;
	
	@FindBy(xpath="//*[@class='table-responsive']/table/tbody/tr/td/a")
	private WebElement studenttestname;
	
	@FindBy(xpath="//li[@id='count_message_li']")
	private WebElement countmessage;
	
	@FindBy(xpath="//td[contains(text(),'soni1 soni (kristafarraj)')]//a[@class='read'][contains(text(),'A learner attempted an exercise')]\n" + 
			"")
	private WebElement message;
	
	@FindBy(xpath="//a[contains(text(),'Click this link to check the answer and')]")
	private WebElement feedbacklink;
	
	@FindBy(xpath=" //input[@id='qf_ce8c33']")
	private WebElement sendemail;
	
	
	@FindBy(xpath="//text()[contains(.,'Correct test')]/ancestor::button[1]")
	private WebElement correcttest;
	
	public void clickcorrecrtest() {
		this.correcttest.click();
	}
	
	public void clicksendemail() {
		this.sendemail.click();
	}
	
	public void clickfeedbacklink() {
		this.feedbacklink.click();
	}
	public void countmessage() {
		this.countmessage.click();
	}
	public void nextquestion() {
		this.Nextquestion.click();
	}
	
	public void multiplechoice2() {
		this.multiplechoice2.click();
	}
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
	
	public void clickTesticon() {
		this.Tests.click();
	}
	public void CreateTest() {
		this.CreateTest.click();
	}

	public void enterquestion(String question) {
		this.question.sendKeys(question);
	}
	
	public void clickAdvancedsettings() {
		driver.switchTo().defaultContent();
		this.advancedsettings.click();
	}
	
	public void frameDescription() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(this.frameDescription);
	}
	
	public void entercontexttest(String contexttest) {
		this.contexttest.sendKeys(contexttest);
	}
	
	public void Enablestarttime() {
		this.EnableStartTime.click();
	}
	public void deletedate() {
		this.Deletedate.click();
	}
	public void inputdate(String calendarinput) {
		this.calendarinput.sendKeys(calendarinput);
	}
	public void enterpasspercentage(String passpercentage) {
		this.passpercentage.sendKeys(passpercentage);
	}
	public void proceedtoq() {
		this.proceedtoq.click();
	}
	public void multiplechoice() {
		this.multiplechoice.click();
	}
	public void question(String question) {
		this.question.sendKeys(question);
	}
	public void framechoice1() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(this.framechoice1);
	}
	public void framechoice2() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(this.framechoice2);
	}
	public void framechoice3() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(this.framechoice3);
	}
	public void framechoice4() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(this.framechoice4);
	}
	public void addquestion() {
		this.Addquestion.click();
	}
	public void radiobutton() {
		this.radiosecondoption.click();
	}
	public void clickpreview() {
		this.preview.click();
	}
	public void studentview() {
		this.studentview.click();
	}
	public void mycourses() {
		this.mycourses.click();
	}
	public void coursecatalog() {
		this.coursecatalog.click();
	}
	public void entersearch(String search) {
		this.entersearch.sendKeys(search);
	}
	//enter assignment name as assignment1
	public void clicksearch() {
		this.clicksearch.click();
	}
	public void clicksubscribe() {
		this.subscribebutton.click();
	}
	public void clickassignment() {
		this.clickAssignment.click();
	}
	public void logout() {
		this.logout.click();
	}
	public void testicon() {
		this.Testsicon.click();
	}
	public void stutestname() {
		this.studenttestname.click();
	}
	public void starttest() {
		this.starttest.click();
	}
	public void clickradiobutton() {
		this.radiobutton2.click();
	}
	public void clickEndtest() {
		this.Endtest.click();
	}
	
	
}

