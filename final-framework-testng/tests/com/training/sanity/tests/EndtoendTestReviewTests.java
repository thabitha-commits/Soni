package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.EndtoEndTestReviewPOM;
import com.training.pom.LoginPOM;
import com.training.pom.LoginTeacherPOM;
import com.training.pom.ReviewAssignmentsPOM;
import com.training.pom.ReviewrateMailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


// Objective:  Verify whether application allows teacher to review, rate & send email about the test

public class EndtoendTestReviewTests {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ScreenShot screenShot;
	private EndtoEndTestReviewPOM endtoendtestreviewPOM;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		endtoendtestreviewPOM = new EndtoEndTestReviewPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void EndtoEndTestReviewTests() throws InterruptedException {
		
		endtoendtestreviewPOM.sendUserName("pinky");
		endtoendtestreviewPOM.sendPassword("pinky123");
		endtoendtestreviewPOM.clickLoginBtn(); 
		endtoendtestreviewPOM.clickcourse1();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,50)"); 
		endtoendtestreviewPOM.clickTestsicon();
		endtoendtestreviewPOM.CreateTest();
		endtoendtestreviewPOM.entertestname("Online Quiz");
		endtoendtestreviewPOM.clickAdvancedsettings();
		Thread.sleep(10000);
		endtoendtestreviewPOM.inputcontexttest("quizforstudents");
		endtoendtestreviewPOM.Enablestarttime();
		endtoendtestreviewPOM.deletedate();
		endtoendtestreviewPOM.inputdate("July 14, 2020 at 12:00");
		endtoendtestreviewPOM.enterpasspercentage("80");
		endtoendtestreviewPOM.proceedtoq();
		endtoendtestreviewPOM.multiplechoice();
		endtoendtestreviewPOM.question("which course you are learning");
		Thread.sleep(10000);
		endtoendtestreviewPOM.inputframechoice1("selenium");
		endtoendtestreviewPOM.inputframechoice2("java");
		endtoendtestreviewPOM.inputframechoice3("C");
		endtoendtestreviewPOM.inputframechoice4("C#");
		endtoendtestreviewPOM.addquestion();
		endtoendtestreviewPOM.multiplechoice2();
		endtoendtestreviewPOM.question("which language are you using in selenium");
		endtoendtestreviewPOM.inputframechoice1("Python");
		endtoendtestreviewPOM.inputframechoice2("java");
		endtoendtestreviewPOM.inputframechoice3("C");
		endtoendtestreviewPOM.inputframechoice4("C#");
		endtoendtestreviewPOM.radiobutton();
		endtoendtestreviewPOM.addquestion();
		endtoendtestreviewPOM.clickpreview();
		endtoendtestreviewPOM.logout();
		endtoendtestreviewPOM.sendUserName("student2");
		endtoendtestreviewPOM.sendPassword("Password$123");
		endtoendtestreviewPOM.clickLoginBtn();
		js.executeScript("window.scrollBy(0,50)"); 
		endtoendtestreviewPOM.coursecatalog();
		endtoendtestreviewPOM.entersearch("innovation testing1");
		endtoendtestreviewPOM.clicksearch();
		endtoendtestreviewPOM.clicksubscribe();
		endtoendtestreviewPOM.clickcourse1();
		endtoendtestreviewPOM.clickTestsicon();
		endtoendtestreviewPOM.stutestname();
		endtoendtestreviewPOM.starttest();
		endtoendtestreviewPOM.clickchoice1();
		endtoendtestreviewPOM.nextquestion();
		endtoendtestreviewPOM.clickchoice1();
		endtoendtestreviewPOM.clickEndtest();
		endtoendtestreviewPOM.logout();
		endtoendtestreviewPOM.sendUserName("pinky");
		endtoendtestreviewPOM.sendPassword("pinky123");
		endtoendtestreviewPOM.clickLoginBtn();
		endtoendtestreviewPOM.clickcourse();
		endtoendtestreviewPOM.clickTestsicon();
		endtoendtestreviewPOM.clickcountmessage();
		endtoendtestreviewPOM.clickmessage();
		endtoendtestreviewPOM.clickfeedbacklink();
		endtoendtestreviewPOM.clicksendemail();
		endtoendtestreviewPOM.clickcorrecttest();
		endtoendtestreviewPOM.clickgradeicon();
		endtoendtestreviewPOM.clicksendemail();
		endtoendtestreviewPOM.clickcorrecttest();
		
		String Expected ="Message Sent";
		String Actual = endtoendtestreviewPOM.messagesent();
		Boolean actualtext = Actual.contains(Expected);
		Assert.assertTrue(actualtext);					//Verifying the Actual & displayed text  'Updated' while sending mail
		screenShot.captureScreenShot("Reviewed&sentmessagebyTeacher");
	}
}
