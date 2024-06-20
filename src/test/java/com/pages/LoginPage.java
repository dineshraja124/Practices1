package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.*;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTxtuserName() {
		return txtuserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTextErrorLogin() {
		return textErrorLogin;
	}

	@FindBy(id = "username")
	private WebElement txtuserName;

	@FindBy(id = "password")
	private WebElement txtPassword;
	@FindBy(id = "login")
	private WebElement btnLogin;
	@FindBy(className= "auth_error")
	private WebElement textErrorLogin;

	public void loginCommonSteps(String userName, String password) {
		elementSendKeys(getTxtuserName(), userName);
		elementSendKeys(getTxtPassword(), password);

	}

	// 1.Valid Credentials
	public void login(String userName, String password) {
		loginCommonSteps(userName, password);
		click(btnLogin);
	}

	// 2.Using Enter Key
	public void loginWithEnterKey(String userName, String password) throws AWTException {
		loginCommonSteps(userName, password);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	// 3. Invalid Credentials
	 public void Invalid(String username, String password) {
		loginCommonSteps(username, password);
		click(getBtnLogin());

	}

}
