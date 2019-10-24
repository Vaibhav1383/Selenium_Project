package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCourcesPOM {
	
private WebDriver driver;
	
	public MyCourcesPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='normal-message']")
	private WebElement loginMessage;
	
	@FindBy(xpath = "//a[contains(text(),'Edit profile')]")
	private WebElement editProfile;
	
	public String getLoginMessage() {
		return loginMessage.getText();
	}
	
	public void clickEditProfile() {
		editProfile.click();
	}


	

}
