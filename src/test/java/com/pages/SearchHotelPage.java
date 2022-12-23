package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClassCucumber;

public class SearchHotelPage extends BaseClassCucumber {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement txtWelcomeMsg;

	@FindBy(id = "location_span")
	private WebElement txtEnterLocationMsg;

	@FindBy(id = "checkin_span")
	private WebElement txtCheckInDateMsg;

	@FindBy(id = "checkout_span")
	private WebElement txtCheckOutDateMsg;

	@FindBy(id = "location")
	private WebElement drpDownLocation;

	@FindBy(id = "hotels")
	private WebElement drpDownHotels;

	public WebElement getTxtWelcomeMsg() {
		return txtWelcomeMsg;
	}

	public WebElement getTxtEnterLocationMsg() {
		return txtEnterLocationMsg;
	}

	public WebElement getTxtCheckInDateMsg() {
		return txtCheckInDateMsg;
	}

	public WebElement getTxtCheckOutDateMsg() {
		return txtCheckOutDateMsg;
	}

	@FindBy(id = "room_type")
	private WebElement drpDownRoomType;

	@FindBy(id = "room_nos")
	private WebElement drpDownRoomNo;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement drpDownAdultRoom;

	@FindBy(id = "child_room")
	private WebElement drpDownChildrensPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSubmit;

	public WebElement getDrpDownRoomNo() {
		return drpDownRoomNo;
	}

	public WebElement getDrpDownLocation() {
		return drpDownLocation;
	}

	public WebElement getDrpDownHotels() {
		return drpDownHotels;
	}

	public WebElement getDrpDownRoomType() {
		return drpDownRoomType;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getDrpDownAdultRoom() {
		return drpDownAdultRoom;
	}

	public WebElement getDrpDownChildrensPerRoom() {
		return drpDownChildrensPerRoom;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public void searchHotels(String location, String hotelName, String roomType, String numberofRooms,
			String checkInDate, String checkOutDate, String adultsperRoom, String childrensPerRoom) {

		selectOptionByText(getDrpDownLocation(), location);
		selectOptionByText(getDrpDownHotels(), hotelName);
		selectOptionByText(getDrpDownRoomType(), roomType);
		selectOptionByText(getDrpDownRoomNo(), numberofRooms);
		elementClear(getTxtCheckInDate());
		elementSendKeys(getTxtCheckInDate(), checkInDate);
		elementClear(getTxtCheckOutDate());
		elementSendKeys(getTxtCheckOutDate(), checkOutDate);

		selectOptionByText(getDrpDownAdultRoom(), adultsperRoom);
		selectOptionByText(getDrpDownChildrensPerRoom(), childrensPerRoom);
		elementClick(getBtnSubmit());

	}

	public void searchHotels(String location, String numberofRooms, String checkInDate, String checkOutDate,
			String adultsperRoom) {

		selectOptionByText(getDrpDownLocation(), location);
		selectOptionByText(getDrpDownRoomNo(), numberofRooms);

		elementClear(getTxtCheckInDate());
		elementSendKeys(getTxtCheckInDate(), checkInDate);
		elementClear(getTxtCheckOutDate());
		elementSendKeys(getTxtCheckOutDate(), checkOutDate);

		selectOptionByText(getDrpDownAdultRoom(), adultsperRoom);
		elementClick(getBtnSubmit());

	}

	public void searchHotels() {

		elementClick(getBtnSubmit());

	}

}
