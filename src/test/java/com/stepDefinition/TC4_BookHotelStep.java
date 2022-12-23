package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pageManager.PageObjectManager;

import baseClass.BaseClassCucumber;
import io.cucumber.java.en.Then;

public class TC4_BookHotelStep extends BaseClassCucumber {

PageObjectManager pom = new PageObjectManager();


	@Then("User should enter book hotel fields {string},{string},{string} and Credit card fields")
	public void userShouldEnterBookHotelFieldsAndCreditCardFields(String firstName, String lastName, String billingAddress, io.cucumber.datatable.DataTable dataTable) {
	  
		pom.getBookHotelPage().bookHotel(firstName, lastName, billingAddress, dataTable);
		
		
	}
	@Then("User should verify after booking hotel success message {string} and save the Order ID")
	public void userShouldVerifyAfterBookingHotelSuccessMessageAndSaveTheOrderID(String expBookingConfirmMsg) {

		WebElement txtBookingConfirmMsg = pom.getBookingConfirmPage().getTxtBookingConfirmMsg();
		String getBookingConfirmText = elementGetText(txtBookingConfirmMsg);
		Assert.assertEquals("Verify after Book Hotel success message", expBookingConfirmMsg, getBookingConfirmText);
		
	}

	@Then("User should enter book now without entering book hotel fields and Credit card fields")
	public void userShouldEnterBookNowWithoutEnteringBookHotelFieldsAndCreditCardFields() {

		pom.getBookHotelPage().bookHotel();

	}
	

	@Then("User should verify error messages after clicking book now button {string}, {string}, {string},{string}, {string}, {string}, {string}")
	public void userShouldVerifyErrorMessagesAfterClickingBookNowButton(String expEnterFirstNameMsg,
			String expEnterLastNameMsg, String expEnterAddressMsg, String expEnterCardNoMsg, String expEnterCardTypeMsg,
			String expEnterCardExpiryMonthMsg, String expEnterCardCvvMsg) {

		WebElement txtEnterFirstNameMsg = pom.getBookHotelPage().getTxtEnterFirstName();
		String getFirstNameText = elementGetText(txtEnterFirstNameMsg);
		boolean b = getFirstNameText.contains(expEnterFirstNameMsg);
		Assert.assertTrue("Verify after Book Hotel Enter FirstName message contains", b);

		WebElement txtEnterLastNameMsg = pom.getBookHotelPage().getTxtEnterLastName();
		String getLastNameText = elementGetText(txtEnterLastNameMsg);
		boolean b1 = getLastNameText.contains(expEnterLastNameMsg);
		Assert.assertTrue("Verify after Book Hotel Enter FirstName message contains", b1);

		WebElement txtEnterAddressMsg = pom.getBookHotelPage().getTxtEnterAddress();
		String getAddressText = elementGetText(txtEnterAddressMsg);
		boolean b2 = getAddressText.contains(expEnterAddressMsg);
		Assert.assertTrue("Verify after Book Hotel Enter LastName message contains", b2);

		WebElement txtEnterCardNoMsg = pom.getBookHotelPage().getTxtEnterCardNo();
		String getCardNoText = elementGetText(txtEnterCardNoMsg);
		boolean b3 = getCardNoText.contains(expEnterCardNoMsg);
		Assert.assertTrue("Verify after Book Hotel Enter Card Number message contains", b3);

		WebElement txtEnterCardTypeMsg = pom.getBookHotelPage().getTxtEnterCardType();
		String getCardTypeText = elementGetText(txtEnterCardTypeMsg);
		boolean b4 = getCardTypeText.contains(expEnterCardTypeMsg);
		Assert.assertTrue("Verify after Book Hotel Enter Card Type message contains", b4);

		WebElement txtEnterCardExpiryMonthMsg = pom.getBookHotelPage().getTxtEnterCardExpiryMonth();
		String getCardExpiryMonthText = elementGetText(txtEnterCardExpiryMonthMsg);
		boolean b5 = getCardExpiryMonthText.contains(expEnterCardExpiryMonthMsg);
		Assert.assertTrue("Verify after Book Hotel Enter Card Expiry Month message contains", b5);

//		WebElement txtEnterCardExpiryYearMsg = pom.getBookHotelPage().getTxtEnterCardExpiryYear();
//		String getCardExpiryYearText = elementGetText(txtEnterCardExpiryYearMsg);
//		boolean b6 = getCardExpiryYearText.contains(expEnterCardExpiryYearMsg);
//		Assert.assertTrue("Verify after Book Hotel Enter Card Expiry Year message contains", b6);

		WebElement txtEnterCardCvvMsg = pom.getBookHotelPage().getTxtEnterCardCvv();
		String getCardCvvText = elementGetText(txtEnterCardCvvMsg);
		boolean b7 = getCardCvvText.contains(expEnterCardCvvMsg);
		Assert.assertTrue("Verify after Book Hotel Enter Card CVV message contains", b7);
	}


}
