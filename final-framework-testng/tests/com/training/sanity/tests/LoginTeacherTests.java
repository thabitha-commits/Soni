package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginTeacherPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


//Logging as Teacher successfully with the entered username and password

public class LoginTeacherTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginTeacherPOM loginTeacherPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private LoginPOM loginPOM;
	static ExtentReports extent;
	static ExtentTest extentTest;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/soni.html");
		extentTest = extent.startTest("Login Teacher");
		
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		loginTeacherPOM = new LoginTeacherPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		 extent.endTest(extentTest);
		 extent.flush();
	     
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validLoginTeacherTest() {
		loginTeacherPOM.sendUserName("abc123");
		loginTeacherPOM.sendPassword("Kristafar$123");
		loginTeacherPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoginTeacher");
       
		
		String expected= "welcome";
		String actual = loginTeacherPOM.succesloginTeacher();
		Boolean actualtext = actual.contains(expected);
		 
		if (actualtext){
			
			extentTest.log(LogStatus.PASS, "Login successful");

		}else
		{
			extentTest.log(LogStatus.FAIL, "Login unsuccessful");

		}
		
		//screenShot.captureScreenShot("RegisteredTeacher");
	}
}
