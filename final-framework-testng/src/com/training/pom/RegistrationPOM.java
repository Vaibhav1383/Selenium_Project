package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPOM {

	private WebDriver driver;
	


	public RegistrationPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[starts-with(@id,'qf')])[1]")
	private WebElement student;  

	public WebElement getStudent() {
		return student;
	}

	@FindBy(xpath = "(//input[starts-with(@id,'qf')])[2]")
	private WebElement teacher;

	public WebElement getTeacher() {
		return teacher;
	}

	@FindBy(id = "registration_firstname")
	private WebElement firstName;

	@FindBy(id = "registration_lastname")
	private WebElement lastName;

	@FindBy(id = "registration_email")
	private WebElement email;

	@FindBy(id = "username")
	private WebElement userName;

	@FindBy(id = "pass1")
	private WebElement password;

	@FindBy(id = "pass2")
	private WebElement confirmPassword;

	@FindBy(id = "registration_phone")
	private WebElement phone;

	@FindBy(xpath = "//select[@id='registration_language']")
	private WebElement Language;

	@FindBy(id = "registration_official_code")
	private WebElement code;

	@FindBy(id = "extra_skype")
	private WebElement skype;

	@FindBy(id = "extra_linkedin_url")
	private WebElement linkedinUrl;

	@FindBy(id = "registration_submit")
	private WebElement registerBtn;
	
	public void checkAndSelectRadioButton(WebElement element) {

		if (!element.isSelected()) {
			element.click();
		}
	}

	public void enterFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		/*String FN = this.firstName.getAttribute("value");
		return FN;*/
	}

	public void enterLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		/*String LN = this.lastName.getAttribute("value");
		return LN;*/
	}

	public void enterEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void enterUserName(String user) {
		this.userName.clear();
		this.userName.sendKeys(user);
	}

	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(password);
	}

	public void enterPhone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);
	}
	
	public void clickRegisterBtn() {
		this.registerBtn.click();
	}
	
	

	

}
