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
import com.training.pom.LoginPOM;
import com.training.pom.LoginTeacherPOM;
import com.training.pom.ReviewAssignmentsPOM;
import com.training.pom.ReviewrateMailPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


// Objective:  Verify whether application allows teacher to review, rate & send email about the test

public class ReviewrateMailTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginTeacherPOM loginTeacherPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ReviewAssignmentsPOM reviewAssignmentPOM;
	private ReviewrateMailPOM reviewrateMailPOM;
    
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		reviewAssignmentPOM = new ReviewAssignmentsPOM(driver); 
		loginTeacherPOM = new LoginTeacherPOM(driver); 
		reviewrateMailPOM = new ReviewrateMailPOM(driver);
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
	public void ReviewrateMailtests() {
		
		reviewrateMailPOM.sendUserName("pinky");
		reviewrateMailPOM.sendPassword("pinky123");
		reviewrateMailPOM.clickLoginBtn(); 
		reviewrateMailPOM.clickcourse();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,50)"); 
		reviewrateMailPOM.clickAssigned();
		reviewrateMailPOM.clickdispAssignments();
		reviewrateMailPOM.clickcorrectandrate();
		reviewrateMailPOM.EnterScore("15");
		reviewrateMailPOM.SendMail();
		reviewrateMailPOM.SendMessage();

		String Expected ="Update";
		String Actual = reviewrateMailPOM.update();
		Boolean actualtext = Actual.contains(Expected);
		Assert.assertTrue(actualtext);					//Verifying the Actual & displayed text  'Updated' while sending mail
		screenShot.captureScreenShot("SendMailforTest");
	}
}
