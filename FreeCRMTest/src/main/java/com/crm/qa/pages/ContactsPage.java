package com.crm.qa.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLable;
	
	//Title dropdown
	@FindBy(xpath ="//select[@name='title']")
	WebElement titleDropdown;
	
	//First Name textbox
	@FindBy (id="first_name")
	WebElement firstName;
	
	//Last Name textbox
	@FindBy (id="surname")
	WebElement lastName;
	
	//Company textbox
	@FindBy (name="client_lookup")
	WebElement company;
	
	//Image Choose File button
	@FindBy (xpath="//input[@id='image_fileINVALID']")
	WebElement imageChooseFile;
	
	@FindBy (xpath="//input[@value='INVALIDLoad From Company']//following-sibling::input[@value='Save']")
	WebElement saveBtn;
	
	//Initializing Page Factory
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Methods and Actions
	 */
	
	public boolean verifyContactsLable(){
		return contactsLable.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		WebElement contactCheckbox =driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
		contactCheckbox.click();			
	}
	
	public void createNewContact(String title,String ftName,String ltName,String comp){
		Select select = new Select(titleDropdown);
		select.selectByValue(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
		
	}

}
