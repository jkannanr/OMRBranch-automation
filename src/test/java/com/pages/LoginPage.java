package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClassCucumber;

public class LoginPage extends BaseClassCucumber {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogin;

	@FindBy(className = "auth_error")
	private WebElement txtErrorMessage;

	public WebElement getTxtErrorLogin() {
		return txtErrorMessage;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public void login(String username, String password) {

		elementSendKeys(getTxtUserName(), username);
		elementSendKeys(getTxtPassword(), password);
		elementClick(getBtnLogin());

	}

	public void loginWithEnterKey(String username, String password) throws AWTException {

		elementSendKeys(getTxtUserName(), username);
		elementSendKeys(getTxtPassword(), password);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

}
