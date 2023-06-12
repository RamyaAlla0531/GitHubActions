package com.pages;

import org.openqa.selenium.WebDriver;
import com.locators.LoginPageLocators;
import com.reusablemethods.SyncMethod;
import com.reusablemethods.TimeOuts;

public class LoginPage extends SyncMethod implements LoginPageLocators, TimeOuts {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterusernameandpassword(String username, String password) {
		type(Username, username, SHORTWAIT);
		type(Password, password, SHORTWAIT);

	}

	public void clickonSignInButton() {
		click(SignInButton, MEDIUMWAIT);
	}

}
