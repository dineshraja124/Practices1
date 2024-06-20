package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookingConfirmationPage extends BaseClass{

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")
	private WebElement printOrderId;
	
	@FindBy (xpath ="//td[@class='login_title']")
	private WebElement textBookingConfirmation;
	
	public WebElement getPrintOrderId() {	
		return printOrderId;
	}
	
	public WebElement getTextBookingConfirmation() {
		return textBookingConfirmation;
	}
	
	//Get the Order id and return it
	
	public String getOrderId() {
			
			String elementGetAttribute = getAttribute(getPrintOrderId(), "value");
			return elementGetAttribute;
			
		}
}
