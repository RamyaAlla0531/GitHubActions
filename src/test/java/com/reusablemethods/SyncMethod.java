package com.reusablemethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncMethod {
private final WebDriver driver;
	
	public SyncMethod(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Method - Method for Click operation, waits until the element is loaded and
	 * then performs a click action
	 * 
	 * @param locator
	 * @param waitTime for driver
	 */
	public void click(By locator, int WaitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTime));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			WebElement element = driver.findElement(locator);
			element.click();
		}  
		catch (Exception e) {
			System.out.println("Exception message: " + e.getMessage());
		}
	}
	
	/*
	 * Method - Method for typing data, waits until the element is loaded and
	 * then enters some text
	 * 
	 * @param locator
	 * @param text
	 * @param optionWaitTime
	 */
	public void type(By locator, String text, int WaitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTime));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement element = driver.findElement(locator);
			element.sendKeys(text);
		}
		catch (Exception e) {
			System.out.println("Exception message: " + e.getMessage());
		}
	}
	
	/*
	 * Method -  Waits for an element till the element is visible
	 * @param locator 
	 * @param waitTime
	 * @return - True if element is located and is visible on screen within timeout period else false
	 */
	public boolean verifyElementVisibility(By locator, int WaitTime)
	{
		boolean flag = false;
		try
		{			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			if(driver.findElement((locator)).isDisplayed())
			{
				flag = true;
			}
		}
		catch (Exception e){
			System.out.println("Exception message:"+e.getMessage());
		}
		return flag;
	}
	
	/*
	 * 
	 * TODO Safe method to get text from an element
	 *
	 * @param locator
	 *            - locator value by which an element is located
	 * @param waitTime
	 *            - Time to wait for an element
	 * @return - returns the text value from element
	 */
	public String getText(By locator, int waitTime) {
		String sValue = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				sValue = driver.findElement(locator).getText();

		}
		catch (Exception e) {
			System.out.println("Exception message:"+e.getMessage());
		}
		return sValue;
	}
	
	public void scrollIntoElement(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
			
			Actions actions=new Actions(driver);
			actions.moveToElement(element);
			actions.perform();
			} 
		catch (Exception e) {
			System.out.println("Unable to scroll "+e.getMessage());
			}
	}
	
	public void hardWait() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifyElementInVisibility(By locator, int WaitTime)
	{
		boolean flag = false;
		try
		{			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTime));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			flag = true;
		}
		catch (Exception e){
			System.out.println("Exception message:"+e.getMessage());
		}
		return flag;
	}
}
