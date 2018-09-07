package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory - Object Repository:
	@FindBy(xpath = "//td[contains(text(),'User: Mukesh Deshmukh')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy (xpath = "//a[@title='New Contact']")
	WebElement newContactLink;

	@FindBy(xpath = "//a[@title='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement tasksLink;

	// Initialize all the above Object Repository (Page Objects).
	public HomePage() {
		PageFactory.initElements(driver, this); // Here "this" means it is 	pointing towards current class objects
			// OR
		// PageFactory.initElements(driver, LoginPage.class);
	}
	
	/*
	 * Actions - 
	 */
	// Verify title of the page
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}



	

}
