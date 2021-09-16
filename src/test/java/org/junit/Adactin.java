package org.junit;

import org.openqa.selenium.WebElement;

public class Adactin extends BaseClass {
@Test	
public void adactinHotel() throws InterruptedException {
	browserLaunch("https://adactinhotelapp.com/");
	maximize();
	WebElement username = locators("id", "username");
	enterText(username, "1balagurur1992");
	WebElement password = locators("id", "password");
	enterText(password, "7845751512");
	WebElement login = locators("id", "login");
	click(login);
	Thread.sleep(3000);
	WebElement location = locators("name", "location");
	click(location);
	dropDownVisibleText(location, "Melbourne");
	
	WebElement hotels = locators("name", "hotels");
	click(hotels);
	dropDownVisibleText(hotels, "Hotel Hervey");
	
	WebElement roomtype = locators("name", "room_type");
	click(roomtype);
	dropDownVisibleText(roomtype, "Standard");
	
	WebElement roomnos = locators("name", "room_nos");
	click(roomnos);
	dropDownVisibleText(roomnos, "2 - Two");
	
	WebElement checkin = locators("name", "datepick_in");
	enterText(checkin, "08/09/2021");
	
	WebElement checkout = locators("name", "datepick_out");
	enterText(checkout, "10/09/2021");
	
	WebElement adult = locators("name", "adult_room");
	click(adult);
	dropDownVisibleText(adult, "2 - Two");
	
	WebElement child= locators("name", "child_room");
	click(child);
	dropDownVisibleText(child, "1 - One");
	
	WebElement search = locators("id", "Submit");
	click(search);
	
	Thread.sleep(3000);
	
	WebElement radiobtn = locators("name", "radiobutton_0");
	click(radiobtn);
	
	WebElement continuebtn = locators("name", "continue");
	click(continuebtn);
	
	Thread.sleep(3000);
	
	WebElement firstname = locators("name", "first_name");
	enterText(firstname, "Balaguru");
	WebElement lastname = locators("name", "last_name");
	enterText(lastname, "Raji");
	WebElement address = locators("name", "address");
	enterText(address, "No;56, Mariamman Koil St., Veemacoundamapalayam, Pudhucherry-605009");
	WebElement cardnum = locators("name", "cc_num");
	enterText(cardnum, "6082398940066853");
	WebElement cardtype = locators("name", "cc_type");
	click(cardtype);
	dropDownVisibleText(cardtype, "VISA");
	WebElement expmonth = locators("name", "cc_exp_month");
	click(expmonth);
	dropDownVisibleText(expmonth, "October");
	
	WebElement expyear = locators("name", "cc_exp_year");
	click(expyear);
	dropDownVisibleText(expyear, "2022");
	
	WebElement cvv = locators("name", "cc_cvv");
	enterText(cvv, "456");
	
	WebElement booknow = locators("name", "book_now");
	click(booknow);
	Thread.sleep(5000);
	
	WebElement orderno = locators("id", "order_no");
	String attribute = getAttribute(orderno, "value");
	System.out.println(attribute);
	
	System.out.println("1234");
	System.out.println("12345");
	
	
	
}
}
