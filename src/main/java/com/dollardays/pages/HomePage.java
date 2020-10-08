package com.dollardays.pages;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className="header-user")
	public WebElement signInElement;	

	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	public WebElement signInLink;

	@FindBy(xpath="//div[@class='mobile-menu-toggle']//following::img[contains(@class,'img-responsive ') and  @alt='DollarDays']")
	public WebElement ddLogo;

	@FindBy(className="header-user")
	public WebElement signinLogo;

	@FindBy(className="header-wishlist")
	public WebElement wistListLogo;

	@FindBy(className="header-cart")
	public WebElement cartLogo;

	@FindBy(xpath="//a[contains(text(),'account')]")
	public WebElement createAccount;

	@FindBy(xpath="//ul[@id='loginDropdownMenu']//child::li")
	public WebElement signinDropDown;

	
	public String PageTitle() {
		return driver.getTitle();

	}
	public boolean isDdLogoPresent() {

		return getDdLogo().isDisplayed();

	}
	public boolean isSignInIconPresent() {

		return getSigninLogo().isDisplayed();

	}
	public boolean isWishListIconPresent() {

		return getWistListLogo().isDisplayed();

	}
	public boolean isCartIconPresent() {

		return getCartLogo().isDisplayed();

	}
	public ArrayList<String> signInList() {

		getSignInElement().click();
		ArrayList<String> ar = new ArrayList<String>();
		List<WebElement> signinList = driver.findElements(By.xpath("//ul[contains(@class,'logMenu')]/child::li"));

		for(int i=0;i<signinList.size();i++) {
			System.out.println(signinList.get(i).getText());
			ar.add(signinList.get(i).getText());
		}
		
		return ar;
	}
	public ArrayList<String> WishList() {

		getWistListLogo().click();
		ArrayList<String> ar = new ArrayList<String>();
		List<WebElement> wishList = driver.findElements(By.xpath("//a[@class='dropdown-toggle']/following-sibling::ul[@class='dropdown-menu']//li"));

		for(int i=0;i<wishList.size();i++) {
			System.out.println(wishList.get(i).getText());
			ar.add(wishList.get(i).getText());
		}
		
		return ar;
	}

	public WebElement getSignInElement() {
		return signInElement;
	}
	public WebElement getSignInLink() {
		return signInLink;
	}
	public WebElement getDdLogo() {
		return ddLogo;
	}
	public WebElement getSigninLogo() {
		return signinLogo;
	}
	public WebElement getWistListLogo() {
		return wistListLogo;
	}
	public WebElement getCartLogo() {
		return cartLogo;
	}
	public WebElement getCreateAccount() {
		return createAccount;
	}
	public WebElement getSigninDropDown() {
		return signinDropDown;
	}

}
