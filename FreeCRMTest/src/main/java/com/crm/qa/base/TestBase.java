package com.crm.qa.base;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	private static EventFiringWebDriver e_driver;
	private static WebEventListener eventListener;

//	public TestBase() {
//		try {
//			prop = new Properties();
//			FileInputStream ip = new FileInputStream(System.getProperty(
//					"M://Workspace2018//FreeCRMTest//src//main//java//com//crm/qa/config//config.properties"));
//			prop.load(ip);
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public static void initialization() throws IOException {

		prop= new Properties();
		FileInputStream fis = new FileInputStream("M:\\Workspace2018\\FreeCRMTest\\src\\main\\java\\comcrmqaconfig\\config.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
//		prop = new Properties();
//		FileInputStream ip = new FileInputStream(System.getProperty(
//				"M:\\Workspace2018\\FreeCRMTest\\src\\main\\java\\comcrmqaconfig\\config.properties"));
//		prop.load(ip);
		
//		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "M:\\SeleniumFiles\\Browsers\\chromedriver.exe");
			driver = new ChromeDriver(); // Now the global variable 'driver' is
											// initialized. This 'driver' can
											// now be used inside the Child
											// classes also.
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "M:\\SeleniumFiles\\Browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Incorrect browser specied in 'config.properties' file.");
		}
		
		/* ---------------- For WebDrive FireEven------START-------------------------*/
		
		// Initializing EventFiringWebDriver using Chrome/Firefox WebDriver instance
		e_driver = new EventFiringWebDriver(driver);
		
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		/* ---------------- For WebDrive FireEven------END----------------------------*/

		/*
		 * Maximize the browser window.
		 */
		driver.manage().window().maximize();

		/*
		 * Delete All Cookies.
		 */
		driver.manage().deleteAllCookies();

		/*
		 * Page Load Time Out set to 20 Seconds. Page Load Time is defined in
		 * TestUtil class.
		 */
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		/*
		 * implicitly Wait for 10 Second. Implicit Wait is defined in TestUtil
		 * class.
		 */
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		 * Launch the "url" mentioned in 'config.properties' file
		 */
		driver.get(prop.getProperty("url"));
	}

}
