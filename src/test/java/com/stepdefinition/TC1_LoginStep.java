package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	

	@When("User should perform login {string},{string}")
	public void user_should_perform_login(String userName, String password) {
		pom.getLoginPage().login(userName, password);
	}

	@When("User should perform login {string},{string} with Enter key")
	public void user_should_perform_login_with_enter_key(String userName, String password) {
		pom.getLoginPage().login(userName, password);
		Assert.assertTrue(false);

	}

	@Then("User should verify after login with invalid credentials error message {string}")
	public void user_should_verify_after_login_with_invalid_credentials_error_message(String expLoginErrorMsg) {
		WebElement textErrorLogin = pom.getLoginPage().getTextErrorLogin();

		String text = getText(textErrorLogin);
		boolean contains = text.contains(expLoginErrorMsg);

		Assert.assertTrue("Hello", contains);

	}

}
