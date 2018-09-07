package raugh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class clickContacts {
	
	@Test
	public void clickContactsLink() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "M:\\SeleniumFiles\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.name("username")).sendKeys("mukeshd");
		driver.findElement(By.name("password")).sendKeys("P@ssword");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(1000);
		
		driver.switchTo().frame("mainpanel");	
		driver.findElement(By.xpath("//a[@title='Contacts']")).click();;
		driver.quit();

	
	}

}
