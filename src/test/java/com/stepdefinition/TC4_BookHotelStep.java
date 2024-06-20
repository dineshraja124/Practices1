package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should book hotel {string}, {string}, {string}")
	public void user_should_book_hotel(String firstName, String lastName, String address,
			io.cucumber.datatable.DataTable dataTable) {

		List<List<String>> card = dataTable.asLists();
		List<String> list = card.get(1);
		String ccNum = list.get(0);
		String ccType = list.get(1);
		String ccMonth = list.get(2);
		String ccYear = list.get(3);
		String cvvNum = list.get(4);

		WebElement txtCCNum = pom.getBookHotelPage().getTxtCCNum();
		elementSendKeys(txtCCNum, ccNum);

		WebElement ddnCardType = pom.getBookHotelPage().getDdnCardType();
		elementSendKeys(ddnCardType, ccType);

		WebElement ddnMonth = pom.getBookHotelPage().getDdnMonth();
		elementSendKeys(ddnMonth, ccMonth);

		WebElement ddnYear = pom.getBookHotelPage().getDdnYear();
		elementSendKeys(ddnYear, ccYear);

		WebElement txtCVV = pom.getBookHotelPage().getTxtCVV();
		elementSendKeys(txtCVV, cvvNum);

		pom.getBookHotelPage().BookHotel(firstName, lastName, address);

		implicitWait(10);

	}

	@Then("User should click book now button without field details")
	public void user_should_click_book_now_button_without_field_details() {
		pom.getBookHotelPage().BookHotel();

	}

	@Then("User should verify after book hotel displayed error message {string}, {string}, {string}, {string},{string}, {string}, {string}")
	public void user_should_verify_after_book_hotel_displayed_error_message(String expFirstnameError,
			String expLastnameError, String expAddressError, String expccNumError, String expccTypeError,
			String expccMonthError, String expcvvError) {

		WebElement firstNameError = pom.getBookHotelPage().getTxtFirstNameError();
		String text1 = getText(firstNameError);
		boolean a = text1.contains(expFirstnameError);
		Assert.assertTrue("verify after book hotel using invalid first name error msg contains", a);

		WebElement lastNameError = pom.getBookHotelPage().getTxtLastNameError();
		String text2 = getText(lastNameError);
		boolean b = text2.contains(expLastnameError);
		Assert.assertTrue("verify after book hotel using invalid last name error msg contains", b);

		WebElement AddressError = pom.getBookHotelPage().getTxtAddressError();
		String text3 = getText(AddressError);
		boolean c = text3.contains(expAddressError);
		Assert.assertTrue("verify after book hotel using invalid address error msg contains", c);

		WebElement ccNumError = pom.getBookHotelPage().getTxtCCNoError();
		String text4 = getText(ccNumError);
		boolean d = text4.contains(expccNumError);
		Assert.assertTrue("verify after book hotel using invalid cc num error msg contains", d);

		WebElement ccTypeError = pom.getBookHotelPage().getTxtCCTypeError();
		String text5 = getText(ccTypeError);
		boolean e = text5.contains(expccTypeError);
		Assert.assertTrue("verify after book hotel using invalid cc type error msg contains", e);

		WebElement ccMonthError = pom.getBookHotelPage().getTxtCCMonthError();
		String text6 = getText(ccMonthError);
		boolean f = text6.contains(expccMonthError);
		Assert.assertTrue("verify after book hotel using invalid cc month error msg contains", f);

		WebElement cvvError = pom.getBookHotelPage().getTxtCVVError();
		String text7 = getText(cvvError);
		boolean g = text7.contains(expcvvError);
		Assert.assertTrue("verify after book hotel using invalid cvv error msg contains", g);
	}

}
