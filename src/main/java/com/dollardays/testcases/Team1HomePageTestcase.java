package com.dollardays.testcases;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dollardays.listners.ExtentTestManager;
import com.dollardays.pages.Team1HomePage;
import com.dollardays.utilities.DDDataProvider;
import com.dollardays.utilities.TestUtil;
import com.dollardays.utilities.VideoRecorder_utlity;

public class Team1HomePageTestcase extends BaseTest{

	@DDDataProvider(datafile = "testdata/Dollardays_Test Cases_Team1_10thSept2020_ver1.0.xlsx", sheetName = "Sheet2",  testcaseID = "TC6", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void tc_06_CheckPageTitle(Hashtable<String, String> datatable) throws Exception{
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		ExtentTestManager.getTest().log(Status.INFO, "Home Pagetestcase verfifying the title");
		

		Team1HomePage homePage = new Team1HomePage(driver);
		System.out.println(homePage.PageTitle());
		Assert.assertEquals(homePage.PageTitle(), datatable.get("HomePageTitle"));
		VideoRecorder_utlity.stopRecord();//End point of video recording
	}
	@Test
	public void tc_verfiyDdLogo() throws Exception {
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		Team1HomePage homePage = new Team1HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Home Pagetestcase verfifying the Dollar Days LOGO");
		boolean ddLogo = homePage.isDdLogoPresent();
		Assert.assertTrue(ddLogo);
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		//driver.manage().window().ses
		// assert.asserttrue
	}
	@Test
	public void tc_verfiySignInLogo() throws Exception {
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		Team1HomePage homePage = new Team1HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Home Pagetestcase verfifying the SIgn IN LOGO");
		boolean signInLogo = homePage.isSignInIconPresent();
		Assert.assertTrue(signInLogo);
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
	}
	@Test
	public void tc_verfiyWishListLogo() throws Exception {
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		Team1HomePage homePage = new Team1HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Home Pagetestcase verfifying the WishList LOGO");
		boolean wishListLogo = homePage.isWishListIconPresent();
		Assert.assertTrue(wishListLogo);
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
	}
	@Test
	public void tc_verfiyCartLogo() throws Exception {
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		Team1HomePage homePage = new Team1HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Home Pagetestcase verfifying the Cart LOGO");
		boolean wishListLogo = homePage.isCartIconPresent();
		Assert.assertTrue(wishListLogo);
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
	}
	@DDDataProvider(datafile = "testdata/Dollardays_Test Cases_Team1_10thSept2020_ver1.0.xlsx", sheetName = "Sheet2",  testcaseID = "TC11", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class,groups="sanity")
	public void tc_verfiySignInList(Hashtable<String,String> datatable) throws Exception {
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		Team1HomePage homePage = new Team1HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Home Pagetestcase verfifying the Sign IN List");
		//getting SignInList from HomePage
		ArrayList<String> ESignInList=homePage.signInList();
		System.out.println("****************"+datatable.get("SignInList"));
		//getting SignInList from excel
		String signList = datatable.get("SignInList");
		ArrayList<String> expectedvalues = new ArrayList<String>();
		String[] lists = signList.split(",");
		for(String s:lists) {
			expectedvalues.add(s);
		}
		
		System.out.println("expectedvalues"+expectedvalues);
		System.out.println("signInList"+ESignInList);

		Assert.assertTrue(expectedvalues.equals(ESignInList));
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording


	}
	@DDDataProvider(datafile = "testdata/Dollardays_Test Cases_Team1_10thSept2020_ver1.0.xlsx", sheetName = "Sheet2",  testcaseID = "TC12", runmode = "Yes")
	@Test(dataProvider = "dd-dataprovider", dataProviderClass = TestUtil.class)
	public void tc_verfiyWishList(Hashtable<String,String> datatable) throws Exception {
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		Team1HomePage homePage = new Team1HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Home Pagetestcase verfifying the Wish List");
		//getting wishList from HomePage
		ArrayList<String> eWishList=homePage.WishList();
		
		System.out.println("****************"+datatable.get("WishList"));
		//getting wishList from excel
		String wishList = datatable.get("WishList");
		ArrayList<String> expectedvalues = new ArrayList<String>();
		String[] lists = wishList.split(",");
		for(String s:lists) {
			expectedvalues.add(s);
		}
		
		System.out.println("expectedvalues"+expectedvalues);
		System.out.println("signInList"+eWishList);
    
		Assert.assertTrue(expectedvalues.equals(eWishList));
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording


	}
	@Test
	public void tc_verfiySearchBar() throws Exception {
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		Team1HomePage homePage = new Team1HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Home Pagetestcase verfifying the Search Bar");
		boolean SearchBar = homePage.isSearchBarPresent();
		Assert.assertTrue(SearchBar);
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
	}
	@Test(enabled=false)
	public void tc_verfiyFooterLinks() throws Exception {
		System.out.println("entered the test");
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
		Team1HomePage homePage = new Team1HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Home Pagetestcase verfifying the footer Links");
		Map<String,String> activeLinks = homePage.footerLinks();
		Iterator hmIterator = activeLinks.entrySet().iterator();
		while(hmIterator.hasNext()) {
			Map.Entry mapElement = (Entry) hmIterator.next();
			ExtentTestManager.getTest().log(Status.INFO, mapElement.getKey()+"---->"+mapElement.getValue());
		}
		VideoRecorder_utlity.startRecord("GoogleTestRecording");//Starting point of video recording
	}
}
