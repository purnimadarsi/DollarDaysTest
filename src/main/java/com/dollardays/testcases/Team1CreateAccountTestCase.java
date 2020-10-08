package com.dollardays.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.Team1CreateAccountPage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;

public class Team1CreateAccountTestCase extends BaseTest{
	
	@DDDataProvider(datafile = "testdata/Dollardays_Test Cases_Team1_10thSept2020_ver1.0.xlsx", sheetName = "Sheet3",  testcaseID = "TC1", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void createlogin(Hashtable<String, String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.getTest().log(Status.INFO, "createlogin tstcase");
		Thread.sleep(1000);
		Team1CreateAccountPage Crpage = new Team1CreateAccountPage(driver);
		Crpage.getsignInButton().click();
		Crpage.getcreateAccount().click();
		Crpage.sendSignUpInformation(datatable.get("Fname"),datatable.get("Lname"),datatable.get("Email"),datatable.get("Phno"),datatable.get("Password"),datatable.get("ConfPassword"));
		Crpage.getuserSignUpButton().click();
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
}
