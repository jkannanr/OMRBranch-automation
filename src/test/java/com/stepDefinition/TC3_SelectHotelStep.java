package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pageManager.PageObjectManager;

import baseClass.BaseClassCucumber;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_SelectHotelStep extends BaseClassCucumber {

	PageObjectManager pom = new PageObjectManager();

	@When("User should click continue after selecting hotel name")
	public void userShouldClickContinueAfterSelectingHotelName() {

		pom.getSelectHotelPage().selectHotel();

	}

	@Then("User should verify after Select Hotel success message {string}")
	public void userShouldVerifyAfterSelectHotelSuccessMessage(String expBookHotelMessage) {

		WebElement txtBookHotelMsg = pom.getBookHotelPage().getTxtBookHotelMsg();
		String elementGetAttributeValue = elementGetText(txtBookHotelMsg);
		Assert.assertEquals("Verify after Select Hotel success message", expBookHotelMessage, elementGetAttributeValue);
	}

	@When("User should click continue without selecting any hotel name")
	public void userShouldClickContinueWithoutSelectingAnyHotelName() {

		pom.getSelectHotelPage().clickContinue();

	}

	@Then("User should verify after Select Hotel failure message {string}")
	public void userShouldVerifyAfterSelectHotelFailureMessage(String expSelectAHotelMsg) {

		WebElement txtSelectAHotelMsg = pom.getSelectHotelPage().getTxtSelectAHotelMsg();
		String getSelectAHotelText = elementGetText(txtSelectAHotelMsg);
		boolean b3 = getSelectAHotelText.contains(expSelectAHotelMsg);
		Assert.assertTrue("Verify after Select Hotel failure message", b3);
	}

}
