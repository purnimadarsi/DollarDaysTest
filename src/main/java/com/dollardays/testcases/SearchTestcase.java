package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.Team1LoginPage;
import com.dollardays.pages.SearchPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class SearchTestcase extends BaseTest{

	
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_01_searchWithValidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 1 : Verify Search functionality");
		Team1LoginPage loginPage = new Team1LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		SearchPage searchpage = new SearchPage(driver);
		
		searchpage.getSearchBar().sendKeys("backpack");
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		
		String categoryCount = searchpage.getsearchCount().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+categoryCount+"'");
		
		Thread.sleep(500);
		loginPage.getUserDrodown().click();
		Thread.sleep(500);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
	}

	
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_02_searchWithInvalidDta(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 2 : Verify Search functionality with Invalid data");
		Team1LoginPage loginPage = new Team1LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		Thread.sleep(1000);
		SearchPage searchpage = new SearchPage(driver);
		
		searchpage.getSearchBar().sendKeys("ffffgf");
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		
		String nodatafound = searchpage.getnoDataFoundMsg().getText();
		ExtentTestManager.getTest().log(Status.PASS, "Step 4  : Should display '"+nodatafound+"'");
		
		Thread.sleep(500);
		loginPage.getUserDrodown().click();
		Thread.sleep(500);
		loginPage.getLogoutBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 5  : Clicked on LogOut");
	}
	
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
    public void TC_03_searchPageWithNavigationLinks(Hashtable<String, String> datatable) throws InterruptedException, UnsupportedEncodingException, GeneralSecurityException{
		ExtentTestManager.getTest().log(Status.PASS, "Testcase 3 : Validate Product Navigation Pages ");
		Team1LoginPage loginPage = new Team1LoginPage(driver);
		ExtentTestManager.getTest().log(Status.PASS, "Step 1  : Login with Valid credentials");
		//loginPage.login(datatable.get("UserName"), Base64.decrypt(datatable.get("Password")));
		loginPage.invokeLogin();
		Thread.sleep(1000);
		SearchPage searchpage = new SearchPage(driver);
		searchpage.getSearchBar().sendKeys("backpack");
		ExtentTestManager.getTest().log(Status.PASS, "Step 2  : Enter search data in the search bar");
		
		searchpage.getsearchBtn().click();
		ExtentTestManager.getTest().log(Status.PASS, "Step 3  : clicked on the search button");
		Thread.sleep(500);
		try {
			
			searchpage.getItemCount();
			Thread.sleep(10000);
			
		}catch (Exception e) {
			searchpage.getItemCount();
			Thread.sleep(10000);
		}
		
		
		
	}
	
	
	
	

}
