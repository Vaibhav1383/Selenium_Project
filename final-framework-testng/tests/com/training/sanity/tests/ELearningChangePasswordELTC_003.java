package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.MyCourcesPOM;
import com.training.pom.ProfilePOM;
import com.training.pom.RegistrationPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ELearningChangePasswordELTC_003 {

	private WebDriver driver;
	private String baseUrl;
	private static Properties properties;
	private ProfilePOM profilePOM;
	private LoginPOM loginPOM;
	private MyCourcesPOM myCourcesPOM;
	private ScreenShot screenShot;
	private String expectedMessage;
	private String actualMessage;	
	

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		profilePOM = new ProfilePOM(driver);
		myCourcesPOM = new MyCourcesPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		driver.get(baseUrl);
		driver.manage().window().maximize();
		loginPOM.sendUserName("reva1234");
		loginPOM.sendPassword("reva123");
		loginPOM.clickLoginBtn();
	}

	@Test
	public void changePasswordTest() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myCourcesPOM.clickEditProfile();
		profilePOM.enterPassword("reva123");
		profilePOM.enterNewPassword("reva321");
		profilePOM.clickSaveChangesBtn();
		screenShot.captureScreenShot("ChangePasswordSuccessful");
		
		expectedMessage = "Your new profile has been saved";
		actualMessage = profilePOM.getMessage();
		
		Assert.assertEquals(expectedMessage, actualMessage);
		
		
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		loginPOM.clickUserDropdown();
		loginPOM.clickLogoff();
		Thread.sleep(3000);
		driver.close();
	}

}
