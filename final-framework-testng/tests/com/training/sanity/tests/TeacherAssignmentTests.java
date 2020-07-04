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
import com.training.pom.RegisterTeacherPOM;
import com.training.pom.TeacherAssignmentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


//Objective:  Verify whether application allows teacher to add assignments & change default settings


public class TeacherAssignmentTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginTeacherPOM loginTeacherPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private TeacherAssignmentPOM teacherAssignmentPOM;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginTeacherPOM = new LoginTeacherPOM(driver);
		teacherAssignmentPOM = new TeacherAssignmentPOM(driver);
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
	public void TeacherAssignmentTests() throws InterruptedException {
		loginTeacherPOM.sendUserName("pinky");
		loginTeacherPOM.sendPassword("pinky123");
		loginTeacherPOM.clickLoginBtn(); 
		Thread.sleep(2000);
		teacherAssignmentPOM.clickcourse();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,50)");  
		
		teacherAssignmentPOM.clickAssignments();
		teacherAssignmentPOM.createAssignments();
		teacherAssignmentPOM.enterAssignmentname("ManipalCourses");
		Thread.sleep(10000);
		teacherAssignmentPOM.frameDescription();
		teacherAssignmentPOM.inputDescription("tests");
		Thread.sleep(2000);
		teacherAssignmentPOM.Advancedsettings();
		teacherAssignmentPOM.enterMaximumscore("10");
		teacherAssignmentPOM.clickvalidate();
		
	   String Expected = "Directory created";
	   String Actual= teacherAssignmentPOM.dircreated();      
	   Assert.assertEquals(Actual, Expected);               //Verifying the text after creating assignment whether directory created or not.
	   screenShot.captureScreenShot("AssignmentCreation");
		
	}
	
}
