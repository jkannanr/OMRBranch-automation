package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pageManager.PageObjectManager;

import baseClass.BaseClassCucumber;
import io.cucumber.java.en.Then;

public class TC5_CancelBookingStep extends BaseClassCucumber{

	PageObjectManager pom = new PageObjectManager();
	
	 @Then("User should cancel order ID")
	public void userShouldCancelOrderID() {

        pom.getCancelBookingPage().cancelBooking(pom.getBookingConfirmPage().getOrderId());	
	
	 }
	 @Then("User should cancel Existing order ID {string}")
	 public void userShouldCancelExistingOrderID(String orderId) {
         pom.getCancelBookingPage().cancelExistingOrderId(orderId);	
	}
	 
	@Then("User should verify after cancel order ID success message {string}")
	public void userShouldVerifyAfterCancelOrderIDSuccessMessage(String expCancelSuccessMsg) {

		WebElement txtCancelSuccessMsg = pom.getCancelBookingPage().getTxtCancelSuccessMsg();
		String getCancelSuccessText = elementGetText(txtCancelSuccessMsg);
		boolean b = getCancelSuccessText.contains(expCancelSuccessMsg);
		Assert.assertTrue("Verify after Book Hotel Enter FirstName message contains", b); 
		
	}


	}


