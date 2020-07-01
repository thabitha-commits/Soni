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
import com.training.pom.LostPwdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LostPwdTests {

	private WebDriver driver;
	private String baseUrl;
	private LostPwdPOM lostpwdPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		lostpwdPOM = new LostPwdPOM(driver); 
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
	public void validlostpwdTest() {
		lostpwdPOM.clicklostpwd();
		lostpwdPOM.sendLusername("manzoor");
		lostpwdPOM.clicksendmessage();
		String expected="Your password has been emailed to you";
		String actual=driver.findElement(By.xpath("//a[text()='Site Owner']")).getText();
		Assert.assertEquals(actual, expected);			 
		screenShot.captureScreenShot("LostPwd");
	}
	
}
