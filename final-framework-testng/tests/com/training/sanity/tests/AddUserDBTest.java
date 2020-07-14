package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.AddUserPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


//Objective: Verify whether application displays details of added user as trainer by admin in database
public class AddUserDBTest {
	private WebDriver driver;
	private String baseUrl;
	private AddUserPOM adduserPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	static ExtentReports extent;
	static ExtentTest extentTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/soni.html");
		extentTest = extent.startTest("Add users to DB");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adduserPOM = new AddUserPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
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


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void AdduserDBTests(String FirstName, String lastname, String email, String Phone,String Login, String Userpassword) throws InterruptedException {		 
//		genericMethods.getElement("login", "id"); 
		
		adduserPOM.sendUserName("admin");
		adduserPOM.enterPassword("admin@123");
		adduserPOM.clickLoginBtn();
		adduserPOM.AddaUser();
		adduserPOM.sendFirstName(FirstName);
		adduserPOM.sendlastname(lastname);
		Thread.sleep(1000);
		adduserPOM.sendemail(email);
		Thread.sleep(1000);
		adduserPOM.Phone(Phone);
		Thread.sleep(1000);
		adduserPOM.enterlogin(Login);
		Thread.sleep(1000);
		adduserPOM.passwordcheck();
		adduserPOM.enterUserpassword(Userpassword);
		adduserPOM.selecprofile();
		adduserPOM.trainer();
		Thread.sleep(1000);
		adduserPOM.clickAdd();
		Thread.sleep(2000);
		String expected= "user";
		String actual = adduserPOM.useradded();
		Boolean actualtext = actual.contains(expected);
		
		if (actualtext){
			
			extentTest.log(LogStatus.PASS, "user added successfully");

		}else
		{
			extentTest.log(LogStatus.FAIL, "user not added successfully");
		}
		screenShot.captureScreenShot("UsersAddedtoDB");
	}

}