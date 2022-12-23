package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClassCucumber;
import io.cucumber.datatable.DataTable;

public class BookHotelPage extends BaseClassCucumber {


	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindAll({@FindBy(xpath ="//td[text()='Book A Hotel ']"),@FindBy(className = "login_title")})
	private WebElement txtBookHotelMsg;	
	
	@FindBy(id = "first_name_span")
	private WebElement txtEnterFirstName;

	@FindBy(id = "last_name_span")
	private WebElement txtEnterLastName;
	
	public WebElement getTxtEnterFirstName() {
		return txtEnterFirstName;
	}

	public WebElement getTxtEnterLastName() {
		return txtEnterLastName;
	}

	public WebElement getTxtEnterAddress() {
		return txtEnterAddress;
	}

	public WebElement getTxtEnterCardNo() {
		return txtEnterCardNo;
	}

	public WebElement getTxtEnterCardType() {
		return txtEnterCardType;
	}

	public WebElement getTxtEnterCardExpiryMonth() {
		return txtEnterCardExpiryMonth;
	}

	public WebElement getTxtEnterCardExpiryYear() {
		return txtEnterCardExpiryYear;
	}

	public WebElement getTxtEnterCardCvv() {
		return txtEnterCardCvv;
	}

	@FindBy(id = "address_span")
	private WebElement txtEnterAddress;

	@FindBy(id = "cc_num_span")
	private WebElement txtEnterCardNo;

	@FindBy(id = "cc_type_span")
	private WebElement txtEnterCardType;

	@FindBy(id = "cc_expiry_span")
	private WebElement txtEnterCardExpiryMonth;

	@FindBy(id = "cc_expiry_span")
	private WebElement txtEnterCardExpiryYear;

	@FindBy(id = "cc_cvv_span")
	private WebElement txtEnterCardCvv;

		
	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	public WebElement getTxtBookHotelMsg() {
		return txtBookHotelMsg;
	}

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCardNo;

	@FindBy(id = "cc_type")
	private WebElement txtCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement txtCardExpiryMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement txtCardExpiryYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCardCvv;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCardNo() {
		return txtCardNo;
	}

	public WebElement getTxtCardType() {
		return txtCardType;
	}

	public WebElement getTxtCardExpiryMonth() {
		return txtCardExpiryMonth;
	}

	public WebElement getTxtCardExpiryYear() {
		return txtCardExpiryYear;
	}

	public WebElement getTxtCardCvv() {
		return txtCardCvv;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public void bookHotel(String firstName, String lastName, String billingAddress, DataTable dataTable) {

		elementSendKeys(getTxtFirstName(), firstName);
		elementSendKeys(getTxtLastName(), lastName);
		elementSendKeys(getTxtAddress(), billingAddress);
		
		List<Map<String, String>> m= dataTable.asMaps();
		Map<String, String> map = m.get(1);
		String creditcardNo =map.get("creditcardNo");
		String creditCardType =map.get("creditCardType");
		String expiryMonth =map.get("expiryMonth");
		String expiryYear =map.get("expiryYear");
		String cvv =map.get("cvv");
		
		elementSendKeys(getTxtCardNo(), creditcardNo);
		elementSendKeys(getTxtCardType(), creditCardType);
		elementSendKeys(getTxtCardExpiryMonth(), expiryMonth);
		elementSendKeys(getTxtCardExpiryYear(), expiryYear);
		elementSendKeys(getTxtCardCvv(), cvv);
		elementClick(getBtnBookNow());

	}

	public void bookHotel() {

		elementClick(getBtnBookNow());

	}
}
