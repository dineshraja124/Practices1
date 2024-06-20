package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotelPage extends BaseClass{
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first_name")
	private WebElement txtFirstName;

	@FindBy(id="last_name")
	private WebElement txtLastName;
	
	@FindBy(id="address")
	private WebElement txtAddres;
	
	@FindBy(id="cc_num")
	private WebElement txtCCNum;
	
	@FindBy(id="cc_type")
	private WebElement ddnCardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement ddnMonth;

	@FindBy(id="cc_exp_year")
	private WebElement ddnYear;
	
	@FindBy(id="cc_cvv")
	private WebElement txtCVV;
	
	@FindBy(id="book_now")
	private WebElement btnBookNow;
	
	
	@FindBy (id = "first_name_span")
	private WebElement txtFirstNameError;
	
	@FindBy (id = "last_name_span")
	private WebElement txtLastNameError;
	
	@FindBy (id = "address_span")
	private WebElement txtAddressError;
	
	@FindBy (id = "cc_num_span")
	private WebElement txtCCNoError;
	
	@FindBy (id = "cc_type_span")
	private WebElement txtCCTypeError;
	
	@FindBy (id = "cc_cvv_span")
	private WebElement txtCVVError;
	
	@FindBy (id = "cc_expiry_span")
	private WebElement txtCCMonthError;
	
	@FindBy(xpath="(//td[@class='login_title'])[2]")
	private WebElement txtBookHotelMsg;
	

	public WebElement getTxtBookHotelMsg() {
		return txtBookHotelMsg;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddres() {
		return txtAddres;
	}

	public WebElement getTxtCCNum() {
		return txtCCNum;
	}

	public WebElement getDdnCardType() {
		return ddnCardType;
	}

	public WebElement getDdnMonth() {
		return ddnMonth;
	}

	public WebElement getDdnYear() {
		return ddnYear;
	}

	public WebElement getTxtCVV() {
		return txtCVV;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}
	
	
	public WebElement getTxtFirstNameError() {
		return txtFirstNameError;
	}

	public WebElement getTxtLastNameError() {
		return txtLastNameError;
	}

	public WebElement getTxtAddressError() {
		return txtAddressError;
	}

	public WebElement getTxtCCNoError() {
		return txtCCNoError;
	}

	public WebElement getTxtCCTypeError() {
		return txtCCTypeError;
	}

	public WebElement getTxtCCMonthError() {
		return txtCCMonthError;
	}

	public WebElement getTxtCVVError() {
		return txtCVVError;
	}
	
	
	//Common step
	public void BookHotelCommonStep() {
		click(getBtnBookNow());
	}
	
	//By select all the fields 
	public void BookHotel(String firstName, String lastName, String address) {
		elementSendKeys(getTxtFirstName(), firstName);
		elementSendKeys(getTxtLastName(), lastName);
		elementSendKeys(getTxtAddres(), address);		
		BookHotelCommonStep();
		
	}
	//Without select any fields click book 	
	public void BookHotel() {
		BookHotelCommonStep();
		
	}
	
}
