package com.stepDefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pageManager.PageObjectManager;

import baseClass.BaseClassCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClassCucumber {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on Adactin Page")
	public void userIsOnAdactinPage() throws FileNotFoundException, IOException {

//		getDriver(getPropertyFileValue("browser"));
//		getUrl(getPropertyFileValue("url"));
//		maximizeWindow();
//		implicitWait();

	}

	@When("User should perform Login {string}, {string}")
	public void userShouldPerformLogin(String username, String password) {

		pom.getLoginPage().login(username, password);

	}

	@When("User should perform Login {string}, {string} with Enter Key")
	public void userShouldPerformLoginWithEnterKey(String username, String password) throws AWTException {

		pom.getLoginPage().loginWithEnterKey(username, password);

	}

	@Then("User should verify after Login with invalid credential error message contains {string}")
	public void userShouldVerifyAfterLoginWithInvalidCredentialErrorMessageContains(String expLoginErrorMessage) {

		WebElement txtErrorLoginMsg = pom.getLoginPage().getTxtErrorLogin();
		String elementGetText = elementGetText(txtErrorLoginMsg);
		boolean b = elementGetText.contains(expLoginErrorMessage);
		Assert.assertTrue("Verify after login with Invalid Credentials contains", b);

	}

}
