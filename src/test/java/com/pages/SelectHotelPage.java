package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBtnRadioSelectHotel() {
		return btnRadioSelectHotel;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public WebElement getTxtSelectErrorMsg() {
		return txtSelectErrorMsg;
	}

	public WebElement getTextSelectHotelMsg() {
		return textSelectHotelMsg;
	}

	@FindBy(id = "radiobutton_0")
	private WebElement btnRadioSelectHotel;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	@FindBy(id = "radiobutton_span")
	private WebElement txtSelectErrorMsg;

	@FindBy(xpath = "//td[@class='login_title']")
	private WebElement textSelectHotelMsg;

	// 1.Common step
	public void SelectHotelCommonSteps() {
		click(getBtnContinue());
	}

	// 2.With select a Hotel name
	public void SelectHotelName() {
		click(getBtnRadioSelectHotel());
		SelectHotelCommonSteps();
	}

	// 3.Without Select Hotel Click
	public void ClickContinue() {
		SelectHotelCommonSteps();
	}

}
