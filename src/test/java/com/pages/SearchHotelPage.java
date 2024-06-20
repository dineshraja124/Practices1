package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass{
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="location")
	private WebElement ddnLocation;
	
	@FindBy(id="hotels")
	private WebElement ddnHotels;
	
	@FindBy(id="room_type")
	private WebElement ddnRoomtype;

	@FindBy(id="room_nos")
	private WebElement ddnNoOfRoom;
	
	@FindBy(id="datepick_in")
	private WebElement txtCheckIn;

	@FindBy(id="datepick_out")
	private WebElement txtCheckOut;
	
	@FindBy(id="adult_room")
	private WebElement ddnAdultPerson;
	
	@FindBy(id="child_room")
	private WebElement ChildrenPerRoom;

	@FindBy(id="Submit")
	private WebElement btnSearch;
	
	
	@FindBy(className="input_show")
	private WebElement txtLoginMsg;
	
	@FindBy(id="checkin_span")
	private WebElement txtDateInMsg;
	
	@FindBy(id="checkout_span")
	private WebElement txtDateOutMsg;
	
	@FindBy(id="location_span")
	private WebElement txtSelectLocationMsg;

	
	public WebElement getDdnLocation() {
		return ddnLocation;
	}

	public WebElement getDdnHotels() {
		return ddnHotels;
	}

	public WebElement getDdnRoomtype() {
		return ddnRoomtype;
	}

	public WebElement getDdnNoOfRoom() {
		return ddnNoOfRoom;
	}

	public WebElement getTxtCheckIn() {
		return txtCheckIn;
	}

	public WebElement getTxtCheckOut() {
		return txtCheckOut;
	}

	public WebElement getDdnAdultPerson() {
		return ddnAdultPerson;
	}
	
	public WebElement getChildrenPerRoom() {
		return ChildrenPerRoom;
	}
	
	public WebElement getTxtLoginMsg() {
		return txtLoginMsg;
	}
	
	public WebElement getTxtDateInMsg() {
		return txtDateInMsg;
	}

	public WebElement getTxtDateOutMsg() {
		return txtDateOutMsg;
	}

	public WebElement getTxtSelectLocationMsg() {
		return txtSelectLocationMsg;
	}
	public WebElement getBtnSearch() {
		return btnSearch;
	}
	
	//Common Steps
	public void SearchHotelCommonSteps(String location, String noofroom, String checkin, String checkout, String Adult) {
		
		selectOptionByVisibleText(getDdnLocation(), location);
		selectOptionByVisibleText(getDdnNoOfRoom(), noofroom);
		clearText(getTxtCheckIn());
		elementSendKeys(getTxtCheckIn(), checkin);
		clearText(getTxtCheckOut());
		elementSendKeys(getTxtCheckOut(), checkout);
		selectOptionByVisibleText(getDdnAdultPerson(), Adult);
	}
	
	//Click Search Button
	public void SearchButton() {
		click(getBtnSearch());
	}
	
	//1.Select All fields
	public void SearchHotels(String location, String hotels, String roomtype,  String noofroom, String checkin, String checkout, String Adult, String children) {
		selectOptionByVisibleText(getDdnHotels(), hotels);
		selectOptionByVisibleText(getDdnRoomtype(), roomtype);
		selectOptionByVisibleText(getChildrenPerRoom(), children);
		SearchHotelCommonSteps(location, noofroom, checkin, checkout, Adult);
		SearchButton();
		
	}
	
	//2.Enter Only mandatory fields
	public void SearchHotels(String location, String noofroom, String checkin, String checkout, String Adult) {
		SearchHotelCommonSteps(location, noofroom, checkin, checkout, Adult);
		SearchButton();	
		
	}
	
	//3.Date Checking
	public void SearchHotelWithInvalidDate(String hotels, String roomtype, String children, String location, String noofroom, String checkin, String checkout, String Adult) {
		selectOptionByVisibleText(getDdnHotels(), hotels);
		selectOptionByVisibleText(getDdnRoomtype(), roomtype);
		selectOptionByVisibleText(getChildrenPerRoom(), children);
		SearchHotelCommonSteps(location, noofroom, checkin, checkout, Adult);
		SearchButton();
		
	}
	
	//4.Without select any fields and click search button
	public void SearchHotels() {
		SearchButton();
		
	}

}
