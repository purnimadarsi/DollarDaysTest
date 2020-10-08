package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.Team1LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.JsonReader;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;

public class Team1LoginTestcase extends BaseTest{


	
	@DDDataProvider(datafile = "testdata/Dollardays_Test Cases_Team1_10thSept2020_ver1.0.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void tc_01_SignInPage_ValidUsername_Password(Hashtable<String, String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.getTest().log(Status.INFO, "login testcase with valid username and password");
		Thread.sleep(1000);
		Team1LoginPage loginPage = new Team1LoginPage(driver);
		
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.dollardays.com/")) {
			System.out.println("login successful");
						
		}else {
			Assert.assertTrue(false);
		}
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	@DDDataProvider(datafile = "testdata/Dollardays_Test Cases_Team1_10thSept2020_ver1.0.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void tc_SignInPage_Display_SignIn_Name(Hashtable<String, String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.getTest().log(Status.INFO, "Checking the display SignIN Name after login ");
		Thread.sleep(1000);
		Team1LoginPage loginPage = new Team1LoginPage(driver);
		
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.dollardays.com/")) {
			String actual = loginPage.getSignInUser_Name();
			ExtentTestManager.getTest().log(Status.INFO, "Actual username is "+ actual);
			System.out.println("Actual username "+ actual);
			String expected = datatable.get("SignInUser_Name");
			ExtentTestManager.getTest().log(Status.INFO, "Expected username is "+ expected);
			System.out.println("expected username "+ expected);
			Assert.assertEquals(actual, expected);
						
		}else {
			Assert.assertTrue(false);
		}
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	@DDDataProvider(datafile = "testdata/Dollardays_Test Cases_Team1_10thSept2020_ver1.0.xlsx", sheetName = "Sheet1",  testcaseID = "TC2", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void tc_02_SignInPageValidUsername_EmptyPassword(Hashtable<String, String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.getTest().log(Status.INFO, "login testcase with correct username and empty password ");
		Thread.sleep(1000);
		Team1LoginPage loginPage = new Team1LoginPage(driver);
		
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.dollardays.com/sitelogin.aspx")) {
			Assert.assertTrue(true);
			
		}else {
			Assert.assertTrue(false);
		}
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	
	@DDDataProvider(datafile = "testdata/Dollardays_Test Cases_Team1_10thSept2020_ver1.0.xlsx", sheetName = "Sheet1",  testcaseID = "TC3", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void tc_03_SignInPageEmptyUsername_EmptyPassword(Hashtable<String, String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.getTest().log(Status.INFO, "login testcase with empty username and empty password");
		Thread.sleep(1000);
		Team1LoginPage loginPage = new Team1LoginPage(driver);
		
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.dollardays.com/sitelogin.aspx")) {
			Assert.assertTrue(true);
			
		}else {
			Assert.assertTrue(false);
		}
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	@DDDataProvider(datafile = "testdata/Dollardays_Test Cases_Team1_10thSept2020_ver1.0.xlsx", sheetName = "Sheet1",  testcaseID = "TC4", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void tc_04_SignInPageInValidEmailAddressFormat(Hashtable<String, String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.getTest().log(Status.INFO, "login testcase with invalid email address format");
		Thread.sleep(1000);
		Team1LoginPage loginPage = new Team1LoginPage(driver);
		
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.dollardays.com/sitelogin.aspx")) {
			Assert.assertTrue(true);
			
		}else {
			Assert.assertTrue(false);
		}
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	
	@DDDataProvider(datafile = "testdata/Dollardays_Test Cases_Team1_10thSept2020_ver1.0.xlsx", sheetName = "Sheet1",  testcaseID = "TC5", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void tc_05_SignInPageValidEmailAddress_InvalidPassword(Hashtable<String,String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.getTest().log(Status.INFO, "login testcase with valid email address and invalid password");
		Thread.sleep(1000);
		Team1LoginPage loginPage = new Team1LoginPage(driver);
		
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.dollardays.com/sitelogin.aspx")) {
			Assert.assertTrue(true);
			
		}else {
			Assert.assertTrue(false);
		}
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	/*@DDDataProvider(datafile = "testdata/testdata.json", runmode = "", sheetName = "", testcaseID = "")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = JsonReader.class)
	
	public void invokeLogin1(Map<String, String> datatable) throws Exception{
		System.out.println("====>"+ datatable);
		System.out.println("Username====>"+ datatable.get("usernme"));
		
		System.out.println("Password====>"+ Base64.decrypt(datatable.get("password")));
		
	}*/
	
}

