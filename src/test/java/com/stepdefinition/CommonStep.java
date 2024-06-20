package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();
	
	@Given("User is on Adactin Hotel login page")
	public void user_is_on_adactin_hotel_login_page() throws FileNotFoundException, IOException {

	

	}

	@Then("User should verify after login success message {string}")
	public void user_should_verify_after_login_success_message(String expLoginSucessMsg) {
		WebElement loginMsg = pom.getSearchHotelPage().getTxtLoginMsg();
		String elementGetAttribute = getAttribute(loginMsg, "value");
		Assert.assertEquals("Verify after login success Msg", expLoginSucessMsg, elementGetAttribute);

	}

	@Then("User should verify after search hotel success message {string}")
	public void user_should_verify_after_search_hotel_success_message(String expSearchSuccessMsg) {

		WebElement searchSuccess = pom.getSelectHotelPage().getTextSelectHotelMsg();
		String text = getText(searchSuccess);
		boolean b = text.contains(expSearchSuccessMsg);
		Assert.assertTrue("verify after search success Msg", b);

	}

	@Then("User should verify after select hotel success message {string}")
	public void user_should_verify_after_select_hotel_success_message(String expSelectHotelSuccessMsg) {
		WebElement bookHotelMsg = pom.getBookHotelPage().getTxtBookHotelMsg();
		String text1 = getText(bookHotelMsg);
		boolean b1 = text1.contains(expSelectHotelSuccessMsg);
		Assert.assertTrue("verify after search success Msg", b1);

	}

	@Then("User should verify after book hotel success message {string}")
	public void user_should_verify_after_book_hotel_success_message(String expBookingSuccessMsg) {
		WebElement bookingConfirmation = pom.getBookingConfirmPage().getTextBookingConfirmation();
		String text2 = getText(bookingConfirmation);
		boolean b2 = text2.contains("Booking Confirmation");
		Assert.assertTrue("verify after search success Msg", b2);

	}
//	@Then("User should verify after search hotel success message {string}")
//	public void user_should_verify_after_search_hotel_success_message(String expSearchSuccessMsg) {
//	      
//	   WebElement searchSuccess = pom.getSelectHotelPage().getTextSelectHotelMsg();
//		String text = getText(searchSuccess);
//		boolean b = text.contains(expSearchSuccessMsg);
//		Assert.assertTrue("verify after search success Msg", b);
//
//	    
//	}

	@Then("User should verify after cancel booking success message {string}")
	public void user_should_verify_after_cancel_booking_success_message(String expCancelSuccessMsg) {
		WebElement cancelError = pom.getCancelPage().getTxtCancelError();
		String text4 = getText(cancelError);
		Assert.assertEquals("Verify after Book Success Msg", expCancelSuccessMsg, text4);

	}

}
