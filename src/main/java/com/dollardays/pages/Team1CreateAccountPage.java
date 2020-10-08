package com.dollardays.pages;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Team1CreateAccountPage {
	WebDriver driver;

	
	public Team1CreateAccountPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
}
	@FindBy(xpath = "//li[@class='dropdown']//a[@class='dropdown-toggle']")
	private WebElement signInButton;
	
	public WebElement getsignInButton() {
		return signInButton;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Create account')]")
	private WebElement createAccount;
	
	public WebElement getcreateAccount() {
		return createAccount;
	}
	
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtFName']")
	private WebElement userFirstNameTextField;
	
	public WebElement getuserFirstNameTextField() {
		return userFirstNameTextField;
	}
	
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtLName']")
	private WebElement userLastNameTextField;
	public WebElement getuserLastNameTextField() {
		return userLastNameTextField;
	}
	
	
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtClientEmail']")
	private WebElement userEmailTextField;
	public WebElement getuserEmailTextField() {
		return userEmailTextField;
	}
	
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtPhoneMain']")
	private WebElement userPhoneTextField;
	public WebElement getuserPhoneTextField() {
		return userPhoneTextField;
	}
	
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtPassword']")
	private WebElement userPasswordField;
	public WebElement getuserPasswordField() {
		return userPasswordField;
	}
	
	@FindBy(xpath = "//input[@id='ctl00_cphContent_txtPasswordConfirm']")
	private WebElement userConfirmPasswordField;
	public WebElement getuserConfirmPasswordField() {
		return userConfirmPasswordField;
	}
	
	@FindBy(xpath = "//input[@id='ctl00_cphContent_btnRegister']")
	private WebElement userSignUpButton;
	public WebElement getuserSignUpButton() {
		return userSignUpButton;
	}
	
	@FindBy(xpath = "//h4[contains(text(),'Welcome to DollarDays!')]")
	private WebElement successfulRegistrationMessage;
	public WebElement getsuccessfulRegistrationMessage() {
		return successfulRegistrationMessage;
	}

	public void sendSignUpInformation(String Fname, String Lname, String Email, String Phone, String Pwd, String Cpwd) {
		
		getuserFirstNameTextField().sendKeys(Fname);
		getuserLastNameTextField().sendKeys(Lname);
		getuserEmailTextField().sendKeys(Email);
		getuserPhoneTextField().sendKeys(Phone);
		getuserPasswordField().sendKeys(Pwd);
		getuserConfirmPasswordField().sendKeys(Cpwd);
	}
}
