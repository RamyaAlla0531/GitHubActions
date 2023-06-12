package com.locators;

import org.openqa.selenium.By;

public interface LoginPageLocators {
	By Username = By.id("username");
	By Password = By.id("password");
	By SignInButton = By.xpath("//button[text()='SIGN IN']");
}
