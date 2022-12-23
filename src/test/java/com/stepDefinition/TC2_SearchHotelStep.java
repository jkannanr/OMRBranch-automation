package com.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pageManager.PageObjectManager;

import baseClass.BaseClassCucumber;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_SearchHotelStep extends BaseClassCucumber {

	PageObjectManager pom = new PageObjectManager();

	@When("User should enter Search Hotel fields {string}, {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldEnterSearchHotelFieldsAnd(String location, String hotelName, String roomType,
			String numberofRooms, String checkInDate, String checkOutDate, String adultsperRoom,
			String childrensPerRoom) {

		pom.getSearchHotelPage().searchHotels(location, hotelName, roomType, numberofRooms, checkInDate, checkOutDate,
				adultsperRoom, childrensPerRoom);
	}

	@Then("User should verify after search hotel success message {string}")
	public void userShouldVerifyAfterSearchHotelSuccessMessage(String expSelectHotelMessage) {

		WebElement txtSelectHotelMsg = pom.getSelectHotelPage().getTxtSelectHotelMsg();
		String elementGetAttributeValue = elementGetText(txtSelectHotelMsg);
		Assert.assertEquals("Verify after Search Hotel success message", expSelectHotelMessage, elementGetAttributeValue);
  
	}

	@When("User should enter only mandatory fields {string},{string},{string},{string} and {string}")
	public void userShouldEnterOnlyMandatoryFieldsAnd(String location, String numberofRooms, String checkInDate,
			String checkOutDate, String adultsperRoom) {

		pom.getSearchHotelPage().searchHotels(location, numberofRooms, checkInDate, checkOutDate, adultsperRoom);
	}

	@Then("User should verify after search hotel failure message {string}, {string}")
	public void userShouldVerifyAfterSearchHotelFailureMessage(String expCheckIndateMsg, String expCheckOutdateMsg) {

//		WebElement txtCheckInDateMsg = pom.getSearchHotelPage().getTxtCheckInDateMsg();
//		String getInText = elementGetText(txtCheckInDateMsg);
//		Assert.assertEquals("Verify after Search Hotel CheckInDate Failure message", expCheckIndateMsg, getInText);
//  
//		WebElement txtCheckOutdateMsg = pom.getSelectHotelPage().getTxtSelectHotelMsg();
//		String getOutText = elementGetText(txtCheckOutdateMsg);
//		Assert.assertEquals("Verify after Search Hotel CheckInDate Failure message", expCheckOutdateMsg, getOutText);
  
		
		WebElement txtCheckInDateMsg = pom.getSearchHotelPage().getTxtCheckInDateMsg();
		String getInText = elementGetText(txtCheckInDateMsg);
		boolean b1 = getInText.contains(expCheckIndateMsg);
		Assert.assertTrue("Verify after Search Hotel CheckInDate Failure message contains", b1);

		WebElement txtCheckOutdateMsg = pom.getSearchHotelPage().getTxtCheckOutDateMsg();
		String getOutText = elementGetText(txtCheckOutdateMsg);
		boolean b2 = getOutText.contains(expCheckOutdateMsg);
		Assert.assertTrue("Verify after Search Hotel CheckInDate Failure message contains", b2);

	}

	@When("User should click Search button without entering Search Hotel fields")
	public void userShouldClickSearchButtonWithoutEnteringSearchHotelFields() {

		pom.getSearchHotelPage().searchHotels();

	}

	@Then("User should verify after search hotel failure message {string}")
	public void userShouldVerifyAfterSearchHotelFailureMessage(String expEnterLocationMsg) {

		WebElement txtEnterLocationMsg = pom.getSearchHotelPage().getTxtEnterLocationMsg();
		String locationTxt = elementGetText(txtEnterLocationMsg);
		boolean b3 = locationTxt.contains(expEnterLocationMsg);
		Assert.assertTrue("Verify after Search Hotel Enter Location message contains", b3);

	}

}
