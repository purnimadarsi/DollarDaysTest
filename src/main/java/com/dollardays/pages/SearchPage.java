package com.dollardays.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='header-main']/div/div/div[2]/div[1]/div[1]/input")
	private WebElement searchBar;

	public WebElement getSearchBar() {
		return searchBar;
	}
	
	@FindBy(xpath = "//*[@id='header-main']/div/div/div[2]/div[1]/div[1]/div/div/button")
	private WebElement searchBtn;

	public WebElement getsearchBtn() {
		return searchBtn;
	}
	
	@FindBy(xpath = "//*[@id='facetrefinements']/aside[1]/div/h3/span[@class='sku-count']")
	private WebElement searchCount;

	public WebElement getsearchCount() {
		return searchCount;
	}
	
	@FindBy(xpath = "//*[@id='aspnetForm']/div[7]/div[@class='failed-search-results bd']")
	private WebElement noDataFoundMsg;

	public WebElement getnoDataFoundMsg() {
		return noDataFoundMsg;
	}
	
	@FindAll(@FindBy(xpath = "//div[@class='select-bar pagination-bar']//a[contains(@class,'page-link')]"))
	private List<WebElement> pageCount;

	public List<WebElement> getPageCount() {
		return pageCount;
	}
	
	@FindBy(xpath = "//a[@title='Next Page']")
	private WebElement nextBtn;

	public WebElement getNextBtn() {
		return nextBtn;
	}
	
	@FindBy(xpath = "//a[@title='Last Page']")
	private WebElement lastPageBtn;

	public WebElement getLastPageBtn() {
		return lastPageBtn;
	}
	
	@FindBy(xpath = "//a[@title='First Page']")
	private WebElement firstPageBtn;

	public WebElement getfirstPageBtn() {
		return firstPageBtn;
	}
	
	@FindBy(xpath = "//li[@class='active page-item']")
	private WebElement lastBtntext;

	public WebElement getLastBtntext() {
		return lastBtntext;
	}
	
	@FindAll(@FindBy(xpath = "//div[contains(@class,'prod-tile')]"))
	private List<WebElement> pageItemsCount;

	public List<WebElement> getPageItemsCount() {
		return pageItemsCount;
	}
	
	
	
	
	public String getSearchWithValue() throws InterruptedException {
		
		String msg=null;
		String result = getnoDataFoundMsg().getText();
		System.out.println("-->"+result);
		
		if(result.contains("No Results Found")) {
			msg = getnoDataFoundMsg().getText();
			
		}else {
			msg = getsearchCount().getText();
		}
		
		return msg;
	}
	
	public void getItemCount() throws InterruptedException {
		getLastPageBtn().click();
		Thread.sleep(1000);
		String valueount = getLastBtntext().getText();
		getfirstPageBtn().click();
		Thread.sleep(1000);
    	
		for(int i=1;i<Integer.parseInt(valueount);i++) {
		    getNextBtn().click();
			Thread.sleep(1000);
			System.out.println("Page "+ i + "  contains " + getPageItemsCount().size() + " rows");
			ExtentTestManager.getTest().log(Status.PASS, "Page Number "+ i + "  contains " + getPageItemsCount().size() + " rows");
		    Thread.sleep(1000);
		}
	}

}
