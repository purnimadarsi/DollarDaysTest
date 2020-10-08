package com.dollardays.commons;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserUtil {

	//Use this Upload file functionality when window based pop up is available
	public static void fileupload(String file) throws AWTException, InterruptedException {
		StringSelection s = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
	//	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER	);
	}

	public static void switchToNewWindow(WebDriver driver) {
		String parenWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		for(String childWindow : childWindows) {
			if (!parenWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println("title of current window -->"+ driver.getTitle());
			}	
		}
		
	}

	// move to Parent Window -- in Progress
	public static void switchToOldWindow(WebDriver driver) {
		String parenWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		for(String childWindow : childWindows) {
			if (!parenWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.close();
			}	
		}
		driver.switchTo().window(parenWindow);
		System.out.println("title of current window -->"+ driver.getTitle());
	}

	// window based on title
	public static WebDriver getHandleToWindow(WebDriver driver, String title) {

		WebDriver popup = null;
		Set<String> windowIterator = driver.getWindowHandles();
		System.err.println("No of windows :  " + windowIterator.size());
		for (String s : windowIterator) {
			String windowHandle = s;
			popup = driver.switchTo().window(windowHandle);
			System.out.println("Window Title : " + popup.getTitle());
			System.out.println("Window Url : " + popup.getCurrentUrl());
			if (popup.getTitle().equals(title)) {
				System.out.println("Selected Window Title : " + popup.getTitle());
				return popup;
			}

		}
		System.out.println("Window Title :" + popup.getTitle());
		System.out.println();
		return popup;
	}

	// Switch to the frame by Name or ID:
	public static void iframe(WebDriver driver, String value) {

		driver.switchTo().frame(value);

	}

	// Switch to the frame by index
	public static void iframe(WebDriver driver, int indexframe) throws Exception {
		int size = driver.findElements(By.tagName("iframe")).size();
		if (size > 0) {
			driver.switchTo().frame(indexframe);
		} else {
			throw new Exception("No frames re available");
		}

	}

	// Switch to the frame by webelement
	public static void iframe(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);

	}

	public void switchToPaarentFrame(WebDriver driver) {
		try {

			driver.switchTo().parentFrame();

		} catch (Exception e) {
			driver.switchTo().defaultContent();
		}

	}

	// scroll to given element
	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	// scroll down the page
	public static void scrollToDown(WebDriver driver) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	// scroll up the page
	public static void scrollToUp(WebDriver driver) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

	}

	//screenshot
	 public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		   try{
	      
		   TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	       File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	       File DestFile=new File(fileWithPath);
	       FileUtils.copyFile(SrcFile, DestFile);

		   }catch(Exception e){
			   throw new Exception("No element found for TakesnapShot " +e );
		   }
	   }
}
