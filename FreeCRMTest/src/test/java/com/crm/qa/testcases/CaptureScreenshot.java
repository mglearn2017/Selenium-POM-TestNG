/*
 * Author : MD
 */
package com.crm.qa.testcases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaptureScreenshot {

	@Test
	public void clickScreenshot() throws Exception {

		System.setProperty("webdriver.chrome.driver", "M:\\SeleniumFiles\\Browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com//");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='email']"));

		System.out.println("Copying Scrrnshot to Clipboard...");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		System.out.println("Saving it to loacal file now...");
		FileUtils.copyFile(src, new File("./Screenshots/FBScreenshot" + timeStamp() + ".png"));

		System.out.println("Screenshot Taken");

		driver.quit();
	}

	public String timeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
