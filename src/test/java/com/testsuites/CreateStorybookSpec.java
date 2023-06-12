package com.testsuites;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.reusablemethods.AllureListeners;
import com.reusablemethods.BaseSetUp;
import com.reusablemethods.ReadProperties;

@Listeners({ AllureListeners.class })
public class CreateStorybookSpec extends BaseSetUp {
	ReadProperties data = new ReadProperties();
	LoginPage loginPage;

	@BeforeClass
	public void beforeClass() {
		System.out.print("Executed before method");
	}

	@Test(description = "Verify login with valid credentials")
	public void verifyLoginwithInValidInfo() {
		setUpBrowser();
		driver.manage().deleteAllCookies();
		String URL = data.getProperty("URL");
		String userName = data.getProperty("username");
		String password = data.getProperty("password");
		getBrowser().get(URL);
		loginPage = new LoginPage(getBrowser());
		loginPage.enterusernameandpassword(userName, password);
		loginPage.clickonSignInButton();
	}
	
	@Test()
	public void test2() {
		System.out.println("Test2");
	}

	@AfterClass
	public void afterClass() {
		System.out.print("Executed after method");
		driver.quit();
	}
}