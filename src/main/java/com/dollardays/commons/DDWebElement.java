package com.dollardays.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class DDWebElement extends RemoteWebElement {

	WebDriver driver;
	
	public DDWebElement(WebDriver driver2, String element) {
		PageFactory.initElements(driver, this);
		 driver.findElement(By.xpath(element));
	}
	
	/*
	 * public void scrollAndSendKeys(String value) {
	 * 
	 * try {
	 * 
	 * super.sendKeys(value);
	 * 
	 * } catch (Exception e) {
	 * 
	 * JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
	 * javascriptExecutor.
	 * executeScript("window.scrollTo(0, document.body.scrollHeight)");
	 * 
	 * try {
	 * 
	 * super.sendKeys(value);
	 * 
	 * }catch (Exception ex) { javascriptExecutor.
	 * executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	 * 
	 * try {
	 * 
	 * super.sendKeys(value);
	 * 
	 * }catch (Exception ex2) { ex2.getMessage(); } }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * public void sendKeys(String value) {
	 * 
	 * try {
	 * 
	 * super.sendKeys(value);
	 * 
	 * } catch (Exception e) {
	 * 
	 * scrollAndSendKeys(value);
	 * 
	 * } }
	 */

}
