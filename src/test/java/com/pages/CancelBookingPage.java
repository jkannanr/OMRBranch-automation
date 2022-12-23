package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClassCucumber;

public class CancelBookingPage extends BaseClassCucumber {


	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement txtBookedItinerary;

	@FindBy(id = "order_id_text")
	private WebElement txtOrderID;

	@FindBy(id = "search_hotel_id")
	private WebElement btnClickId;

	@FindBy(xpath = "(//input[@type='button'])") 
	private WebElement btnCancelSelected;
	
	@FindBy(id = "search_result_error")
	private WebElement txtCancelSuccessMsg;


public WebElement getTxtBookedItinerary() {
	return txtBookedItinerary;
}

public WebElement getTxtCancelSuccessMsg() {
	return txtCancelSuccessMsg;
}
	public WebElement getTxtOrderID() {
		return txtOrderID;
	}

	public WebElement getBtnClickId() {
		return btnClickId;
	}

	public WebElement getBtnCancelSelected() {
		return btnCancelSelected;
	}

	public void cancelBooking(String orderId) {
		elementClick(getTxtBookedItinerary());
		elementSendKeys(getTxtOrderID(), orderId);
		elementClick(getBtnClickId());
		elementClick(getBtnCancelSelected());
		acceptAlert();
	}

	public void cancelExistingOrderId(String orderId) {

		elementClick(getTxtBookedItinerary());
		elementSendKeys(getTxtOrderID(), orderId);
		elementClick(getBtnClickId());
		elementClick(getBtnCancelSelected());
		acceptAlert();

	}

	

}
