package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC2_SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should search hotels {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void user_should_search_hotels_and(String location, String hotels, String roomtype, String noofroom,
			String checkin, String checkout, String Adult, String children) {
		pom.getSearchHotelPage().SearchHotels(location, hotels, roomtype, noofroom, checkin, checkout, Adult, children);
	}

	@Then("User should search hotels using mandatory fields {string},{string},{string},{string},{string}")
	public void user_should_search_hotels_using_mandatory_fields(String location, String noofroom, String checkin,
			String checkout, String Adult) {
		pom.getSearchHotelPage().SearchHotels(location, noofroom, checkin, checkout, Adult);
	}

	@Then("User should verify after search hotel displayed Invalid date error message {string},{string}")
	public void user_should_verify_after_search_hotel_displayed_invalid_date_error_message(String expDateInMsg,
			String expDateOutMsg) {
		WebElement txtDateInMsg = pom.getSearchHotelPage().getTxtDateInMsg();
		  String text2 = getText(txtDateInMsg);
		  boolean b1 = text2.contains(expDateInMsg);
		  Assert.assertTrue("verify after search hotel using invalid credentials error msg contains", b1);	
		  
		  
		  WebElement txtDateOutMsg = pom.getSearchHotelPage().getTxtDateOutMsg();
		  String text = getText(txtDateOutMsg);
		  boolean b2 = text.contains(expDateOutMsg);
		  Assert.assertTrue("verify after search hotel using invalid credentials error msg contains", b2);	
		  
	}

	@Then("User should search hotels without field details")
	public void user_should_search_hotels_without_field_details() {
		 pom.getSearchHotelPage().SearchHotels();
		
	}

	@Then("User should verify after search hotel displayed error message {string}")
	public void user_should_verify_after_search_hotel_displayed_error_message(String expSearchErroMsg) {
		WebElement selectLocationMsg = pom.getSearchHotelPage().getTxtSelectLocationMsg();
		String locationMsg = getText(selectLocationMsg);
		boolean b = locationMsg.contains(expSearchErroMsg);
		Assert.assertTrue("verify after search hotel using invalid credentials error msg contains", b);		
	    
	}

}
