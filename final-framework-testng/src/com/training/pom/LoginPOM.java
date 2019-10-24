package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Sign up!')]")
	private WebElement signUp;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement userDropdown;
	
	@FindBy(id="logout_button")
	private WebElement logoff;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click();
	}
	
	public void clickSignUp() {
		this.signUp.click();
	}
	
	public void clickUserDropdown() {
		this.userDropdown.click();
	}
	
	public void clickLogoff() {
		this.logoff.click();
	}
}
