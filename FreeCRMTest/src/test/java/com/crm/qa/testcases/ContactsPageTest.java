package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	TestUtil testUtil;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName="contacts";
	
	@BeforeMethod
	public void setup() throws IOException{
		initialization();
		testUtil=new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage= homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsLableTest(){	
		Assert.assertTrue(contactsPage.verifyContactsLable(),"Contacts lable is Missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsByNameTest(){		
		contactsPage.selectContactsByName("James Bond");
		// See how can you put an assertion here.
	}
	
	@Test(priority=3)
	public void selectMultipleContactsByNameTest() {
		contactsPage.selectContactsByName("James Bond");
		contactsPage.selectContactsByName("Dexter Morgan");
		contactsPage.selectContactsByName("Jack Sparrow");
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName,String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactsPage.createNewContact(title,firstName,lastName,company);
	}
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
		System.out.println("Closeing browser");
	}
}
