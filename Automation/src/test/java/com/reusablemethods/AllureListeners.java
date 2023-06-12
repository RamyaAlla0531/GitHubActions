package com.reusablemethods;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListeners implements ITestListener{
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	@Attachment
	public byte[] saveFailureScreenshot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	@Attachment
	public static String saveTextLog(String message) {
		return message;

	}
	public void onStart(ITestContext iTestContext) {
	   System.out.println("I am in onstart method" + iTestContext.getName() );
	   iTestContext.setAttribute("WebDriver", BaseSetUp.getDriver());
	  }

	public void onFinish(ITestContext iTestContext) {
		   System.out.println("I am in onfinish method" + iTestContext.getName() );
		  
		  }
	public void onTestStart(ITestResult iTestResult) {
		   System.out.println("I am in onstart method"  + getTestMethodName(iTestResult) + "start"  );
		  
		  }
	public void onTestsuccess(ITestResult iTestResult) {
		   System.out.println("I am in ontestsuccess method" + getTestMethodName(iTestResult) + "Succeed" );
		  
		  }
	public void onTestFailure(ITestResult iTestResult) {
		   System.out.println("I am in ontestfailure method" + getTestMethodName(iTestResult) + "Failed" );
		   Object testClass = iTestResult.getInstance();
		   WebDriver driver = BaseSetUp.getDriver();
		   if (driver instanceof WebDriver) {
			   System.out.println("Screenshot captured for test case:" +getTestMethodName(iTestResult));
			   saveFailureScreenshot(driver);
		   }
		   saveTextLog(getTestMethodName(iTestResult) + "failed and screenshot taken");
		  
		  }
	public void onTestSkipped(ITestResult iTestResult) {
		   System.out.println("I am in ontestskip method" + getTestMethodName(iTestResult) + "Skipped" );
		  
		  }
}
