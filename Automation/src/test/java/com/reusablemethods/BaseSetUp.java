package com.reusablemethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSetUp {
	public static  WebDriver driver;
	String fileSeperator = System.getProperty("file.separator");
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	/*
	 * Webdriver setup for chrome browser
	 */	
	public WebDriver setUpBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + fileSeperator + "resources" + fileSeperator + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		tdriver.set(driver);
		return getDriver();
	}
	
	public WebDriver getBrowser() {
		return driver;
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
}
