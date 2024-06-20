package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC5_CancelBookingStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify after book hotel success message {string} and saved OrderId")
	public void user_should_verify_after_book_hotel_success_message_and_saved_order_id(String expBookSuccessMsg) {

		WebElement textBookingConfirmation = pom.getBookingConfirmPage().getTextBookingConfirmation();
		String text = getText(textBookingConfirmation);
		Assert.assertEquals("Verify after book Hotel Success Msg", expBookSuccessMsg, text);
	}

	@Then("User should cancel booking with orderId {string}")
	public void user_should_cancel_booking_with_orderId(String expBookSuccessMsg) {
		WebElement txtCancelError = pom.getCancelPage().getTxtCancelError();
		String text = getText(txtCancelError);
		Assert.assertEquals("Verify Cancel booking Msg", expBookSuccessMsg, text);
	}

	@Then("User should click booking itinerary and cancel booking with existing {string}")
	public void user_should_click_booking_itinerary_and_cancel_booking_with_existing(String orderId) {
		pom.getCancelPage().cancelOrderID(orderId);
	}

}
