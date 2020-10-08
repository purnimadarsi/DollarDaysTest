package com.dollardays.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExampleSearch {

	WebDriver driver;

	public ExampleSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='header-main']/div/div/div[2]/div[1]/div[1]/input")
	public WebElement seearch;

	public WebElement getSearchBar() {
		return seearch;
	}
	
	@FindBy(xpath = "//*[@id=\"header-main\"]/div/div/div[2]/div[1]/div[1]/div/div/button/i")
	private WebElement searchBtn;

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void search() {
		getSearchBar().sendKeys("srikanth");
		getSearchBtn().click();
	}
	
	
	
}
