package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePOM {
private WebDriver driver;
	
	public ProfilePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="profile_password0")
	private WebElement password;
	
	@FindBy(id="password1")
	private WebElement newPassword;
	
	@FindBy(id="profile_password2")
	private WebElement confirmPassword;
	
	@FindBy(id="profile_apply_change")
	private WebElement saveChangesBtn;
	
	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void enterNewPassword(String newPassword) {
		this.newPassword.clear();
		this.newPassword.sendKeys(newPassword);
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(newPassword);
	}
	
	public void clickSaveChangesBtn() {
		this.saveChangesBtn.click();
	}

}
