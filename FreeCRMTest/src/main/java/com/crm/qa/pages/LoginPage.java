package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Object Repository:
	@FindBy(name = "username111")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[@type='button' and text()='Sign Up']") 
	WebElement signUpBtn;

	@FindBy(xpath = "//img[@ alt='free crm logo' ]")
	WebElement crmLogo;

	// Initialize all the above Object Repository (Page Objects).
	public LoginPage() {
		PageFactory.initElements(driver, this); // Here "this" means it is
												// pointing towards current
												// class objects
		// OR
		// PageFactory.initElements(driver, LoginPage.class);

	}

	/*
	 * Actions:
	 */

	// Verify title of the page
	public String validatePageTitle() {
		return driver.getTitle();
	}

	// Validate CRM image(Logo)
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String usr, String pwd) {
		username.sendKeys(usr);
		password.sendKeys(pwd);
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		System.out.println("Clicking on Login button now");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginBtn.click();
		

		// Home page is a landing page of a LoginPage. 
		// Therefore, login method should return HomePage class object
		return new HomePage();
	}

}
