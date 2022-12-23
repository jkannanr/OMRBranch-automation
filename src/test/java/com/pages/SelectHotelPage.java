package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClassCucumber;

public class SelectHotelPage extends BaseClassCucumber {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(xpath ="//td[text()='Select Hotel ']"),@FindBy(className = "login_title")})
	private WebElement txtSelectHotelMsg;	

	@FindAll({@FindBy(xpath = "//input[@id='radiobutton_0']"),@FindBy(xpath = "//input[@type='radio']")})
	private WebElement btnRadio;

	@FindBy(id = "continue")
	private WebElement btncontinue;
	
	@FindBy(id = "radiobutton_span")
	private WebElement txtSelectAHotelMsg;

	public WebElement getBtnRadio() {

		return btnRadio;
	}

	public WebElement getTxtSelectAHotelMsg() {
		return txtSelectAHotelMsg;
	}

	public WebElement getTxtSelectHotelMsg() {
		return txtSelectHotelMsg;
	}

	public WebElement getBtncontinue() {
		return btncontinue;
	}

	public void selectHotel() {

		elementClick(getBtnRadio());
		elementClick(getBtncontinue());

	}

	public void clickContinue() {

		elementClick(getBtncontinue());

	}

}
