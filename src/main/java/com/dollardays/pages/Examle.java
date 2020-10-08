package com.dollardays.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dollardays.commons.DDWebElement;

public class Examle extends DDWebElement{
	
	
	public Examle(WebDriver driver2, String element) {
		super(driver2, element);
		// TODO Auto-generated constructor stub
	}





	WebDriver driver;

	



	public DDWebElement signInlink(WebDriver driver) {
		return new DDWebElement(driver,"//*[@id=\"header-main\"]/div/div/div[2]/div[1]/div[1]/input");
	}

}
