package com.pagemanagers;

import com.pages.BookHotelPage;
import com.pages.BookingConfirmationPage;
import com.pages.CancelPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

public class PageObjectManager {

	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmationPage bookingConfirmationPage;
	private CancelPage cancelPage;
	
	
	public LoginPage getLoginPage() {
		return (loginPage==null)?loginPage = new LoginPage():loginPage;
	}
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage==null)?searchHotelPage = new SearchHotelPage():searchHotelPage;
	}
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage==null)?selectHotelPage = new SelectHotelPage():selectHotelPage;
	}
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage==null)?bookHotelPage = new BookHotelPage():bookHotelPage;
	}
	public BookingConfirmationPage getBookingConfirmPage() {
		return (bookingConfirmationPage==null)?bookingConfirmationPage = new BookingConfirmationPage():bookingConfirmationPage;
	}
	public CancelPage getCancelPage() {
		return (cancelPage==null)?cancelPage = new CancelPage():cancelPage;
	}	
	
	
}
