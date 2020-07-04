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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


// Objective: Verify whether application allows teacher to review the assignment submitted by the student & rate

public class ReviewAssignmentsTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginTeacherPOM loginTeacherPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private ReviewAssignmentsPOM reviewAssignmentPOM;
    
	

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
	public void ReviewAssignmentTest() {
		
		loginTeacherPOM.sendUserName("pinky");
		loginTeacherPOM.sendPassword("pinky123");
		loginTeacherPOM.clickLoginBtn(); 
		reviewAssignmentPOM.clickcourse();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,50)"); 
		reviewAssignmentPOM.clickAssigned();
		reviewAssignmentPOM.clickdispAssignments();
		reviewAssignmentPOM.clickcorrectandrate();
		reviewAssignmentPOM.EnterScore("20");
		reviewAssignmentPOM.SendMessage();
		reviewAssignmentPOM.clickdispAssignments();
		
		String Expected ="Revised";
		String Actual = reviewAssignmentPOM.revised(); 
		Boolean actualtext = Actual.contains(Expected);
		Assert.assertTrue(actualtext);					//Verifying the Actual & displayed text  'REVISED' 
		Assert.assertEquals(Expected, Actual);         
		screenShot.captureScreenShot("Reviewed Assignments");

	}
}
