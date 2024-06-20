package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC3_SelectHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should click continue with select hotel")
	public void user_should_click_continue_with_select_hotel() {
		pom.getSelectHotelPage().SelectHotelName();
	}

	@Then("User should click continue without select any hotel")
	public void user_should_click_continue_without_select_any_hotel() {
		pom.getSelectHotelPage().ClickContinue();
	}

	@Then("User should verify after select hotel displayed error message {string}")
	public void user_should_verify_after_select_hotel_displayed_error_message(String expSelectErrorMsg) {

		WebElement selectErrorMsg = pom.getSelectHotelPage().getTxtSelectErrorMsg();
		String text = getText(selectErrorMsg);
		boolean b = text.contains(expSelectErrorMsg);
		Assert.assertTrue("verify after select hotel error msg contains", b);

	}

}
