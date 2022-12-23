package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClassCucumber;

public class BookingConfirmPage extends BaseClassCucumber {

	public BookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//td[text()='Booking Confirmation ']")
	private WebElement txtBookingConfirmMsg;

	
	@FindAll({@FindBy(xpath = "//input[@id='order_no']"), @FindBy(id ="order_no")})
	private WebElement txtOrderNo;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement clkBookedItinerary;

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	
	}
	public WebElement getClkBookedItinerary() {
		return clkBookedItinerary;
	}

	public WebElement getTxtBookingConfirmMsg() {
		return txtBookingConfirmMsg;
	}

	public String getOrderId() {

		String orderId = elementGetAttributeValue(getTxtOrderNo());
		System.out.println(orderId);
		return orderId;

	}
	
	
	}

