package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;
	ContactsPage contactsPage;
	
//	public HomePageTest(){
//		super();
//	}
	
	@BeforeMethod
	public void setup() throws IOException{
		initialization();
		testUtil=new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void veriftHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page Title NOT matched"); //Remember - You can pass string message in the assertion.This message gets printed only when TC fails. 
	}
	
	@Test(priority=2)
	//@Test(priority='2')
	public void verifyCorrectUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		//Switching the frame.
		testUtil.switchToFrame();
		//Click on Contacts.
		contactsPage = homePage.clickOnContactsLink();
		

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		System.out.println("Closeing browser");
	}
	
	
	
	

}
