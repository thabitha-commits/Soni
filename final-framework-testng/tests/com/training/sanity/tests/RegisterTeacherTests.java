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
import com.training.pom.RegisterTeacherPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTeacherTests {

	private WebDriver driver;
	private String baseUrl;
	private RegisterTeacherPOM registerTeacherPOM;
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
		registerTeacherPOM = new RegisterTeacherPOM(driver);
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
	public void validRegisterTeacherTest() {
		
		registerTeacherPOM.clickSignupTeacher();
		registerTeacherPOM.selectTeachcourses();
		registerTeacherPOM.sendFirstname("keerthi1");
		registerTeacherPOM.sendlastname("bang");
		registerTeacherPOM.sendemail("sthabitha@gmail.com");
		registerTeacherPOM.sendusername("keerthi1");
		registerTeacherPOM.sendPassword("keerthi$123");
		registerTeacherPOM.sendconfirmpassword("keerthi$123");
		registerTeacherPOM.sendPhone("9876543220");
		registerTeacherPOM.selectLanguage("English");
		registerTeacherPOM.clickRegisterBtn();
		
	   String expected= "An e-mail has been sent to remind you of your login and password.";
	   String actual= registerTeacherPOM.registermsgdisplay();
	   Assert.assertEquals(actual, expected);			
		screenShot.captureScreenShot("RegisteredTeacher");
		
	}
}
