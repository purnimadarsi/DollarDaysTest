package com.dollardays.testcases;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Hashtable;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.commons.Base64;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.ExampleSearch;
import com.dollardays.pages.Team1LoginPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;

public class ExampleSearchTestcase extends BaseTest{
	@DDDataProvider(datafile = "testdata/testdata1.xlsx", sheetName = "Sheet1",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void search(Hashtable<String, String> hash) throws UnsupportedEncodingException, InterruptedException, GeneralSecurityException {
		
		Team1LoginPage lpage=new Team1LoginPage(driver);
		lpage.login(hash.get("UserName"), Base64.decrypt(hash.get("Password")));
		ExtentTestManager.getTest().log(Status.INFO, "Test case 1: enter login");//INFO,pASS,
		
		ExampleSearch ex= new ExampleSearch(driver);
		ex.search();
		ExtentTestManager.getTest().log(Status.INFO, "Ste 1: search backack");//INFO,pASS,
		
	}
}
