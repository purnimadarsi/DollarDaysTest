package com.dollardays.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;




public class Team1HomePage {
	WebDriver driver;
	WebDriverWait wait;
	public Team1HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,30);
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

	@FindBy(xpath="//div[@class='input-group']/child::input[@name='terms']")
	public WebElement SearchBar;
	
	@FindBy(css="div.dollardays-conpany-info>ul>li>a")
	public List<WebElement> comFooterLink;
	
	@FindBy(xpath="//ul[@class='customer-item']//child::li//a")
	public List<WebElement> custFooterLink;
	
	public List<WebElement> getComFooterLink() {
		return comFooterLink;
		
	}
	public List<WebElement> getCustFooterLink() {
		return custFooterLink;
		
	}
	public WebElement getSearchBarElement() {
		return SearchBar;
	}
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
		verifyElementpresent(getWistListLogo());
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
		verifyElementpresent(getWistListLogo());
		getWistListLogo().click();
		ArrayList<String> ar = new ArrayList<String>();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='dropdown-toggle']/following-sibling::ul[@class='dropdown-menu']//li")));
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
	public boolean isSearchBarPresent() {
		return getSearchBarElement().isDisplayed();
		
	}
	public void verifyElementpresent(WebElement ele)
	{
		
			
			try
			{
				wait.until(ExpectedConditions.visibilityOf(ele));
				System.out.println(ele+ " was found");
				
			}
			
			catch(Exception e)
			{
				System.out.println("Unable to find the element "+ele +": "+ e);
				
			}
			
	}
	//div.dollardays-conpany-info>ul>li
	//ul[@class='customer-item']//child::li
	public Map footerLinks() throws MalformedURLException, IOException {
		Map<String,String> activeList = new HashMap<String,String>();
		List<WebElement> linkList = getComFooterLink();
		//linkList.addAll(getCustFooterLink());
		List<WebElement> activeLinks = new ArrayList<WebElement>();
	    for(int i=0;i<linkList.size();i++) {
	    	if(linkList.get(i).getAttribute("href")!=null && !(linkList.get(i).getAttribute("href").contains("javascript"))) {
	    		activeLinks.add(linkList.get(i));
	    	}
	    }
	    HttpURLConnection connection;
	    //200 -- ok
	    //404 -- notfound
	    //500 -- internal error
	    //400 -- badrequest
	    for(int i=0;i<activeLinks.size();i++) {
	    connection = (HttpURLConnection)(new URL(activeLinks.get(i).getAttribute("href")).openConnection());	
	    	connection.connect();
	    	String resopnse = connection.getResponseMessage();
	    	String msg = connection.getResponseMessage();
	    	//connection.disconnect();
	    	System.out.println(activeLinks.get(i).getAttribute("href")+"--->"+msg);
	    	activeList.put(activeLinks.get(i).getAttribute("href"), msg);
	    			
	    	
	    }
	    	
	    	
	    	return activeList;
	    	
	    	
	}
}
