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

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginTeacherPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTeacherTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginTeacherPOM loginTeacherPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private LoginPOM loginPOM;
    
	

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
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
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validLoginTeacherTest() {
		loginTeacherPOM.sendUserName("pinky");
		loginTeacherPOM.sendPassword("pinky123");
		loginTeacherPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoginTeacher");
		
		//String expected= "Hello "+Firstname+" "+lastname+" and welcome";
		//String actual=driver.findElement(By.xpath("//p[text()='An e-mail has been sent to remind you of your login and password.']']")).getText();
		//Assert.assertEquals(actual, expected);			
		screenShot.captureScreenShot("RegisteredTeacher");
	}
}
