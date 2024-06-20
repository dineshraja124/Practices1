package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class CancelPage extends BaseClass {
	public CancelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement clickBookedItinerary;

	@FindBy(id = "order_id_text")
	private WebElement txtOrderId;

	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;

	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement btnCancel;

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	@FindBy(id = "search_result_error")
	private WebElement txtCancelError;

	public WebElement getClickBookedItinerary() {
		return clickBookedItinerary;
	}

	public WebElement getTxtOrderId() {
		return txtOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getTxtCancelError() {
		return txtCancelError;
	}

	public void cancelOrderID(String orderId) {

		click(getClickBookedItinerary());
		elementSendKeys(getTxtOrderId(), orderId);
		click(getBtnGo());
		click(getBtnCancel());
		acceptalert();

	}

}
