package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pageManager.PageObjectManager;

import baseClass.BaseClassCucumber;
import io.cucumber.java.en.Then;


public class CommonStep extends BaseClassCucumber {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify after Login success message {string}")
	public void userShouldVerifyAfterLoginSuccessMessage(String expLoginMessage) {
		
		WebElement txtWelcomeMsg = pom.getSearchHotelPage().getTxtWelcomeMsg();
		String elementGetAttributeValue = elementGetAttribute(txtWelcomeMsg);
	   Assert.assertEquals("Verify after login success message", expLoginMessage, elementGetAttributeValue);
	}

}
