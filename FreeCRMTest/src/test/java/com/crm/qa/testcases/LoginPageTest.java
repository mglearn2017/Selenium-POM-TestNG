package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

//	public LoginPageTest() {
//		super();
//	}

	@BeforeMethod
	public void setUp() throws IOException {
		// Calling static method 'initialization()'from TestBase
		TestBase.initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title=loginPage.validatePageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag=loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//testUtil.takeScreenshotAtEndOfTest();

		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
