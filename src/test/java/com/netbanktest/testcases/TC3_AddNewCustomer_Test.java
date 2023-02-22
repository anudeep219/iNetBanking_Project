package com.netbanktest.testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.netbanktest.pageobjects.AddNewCustomerPage;
import com.netbanktest.pageobjects.LoginPage;

public class TC3_AddNewCustomer_Test extends Baseclass{
	
	@Test
	public void Addcustomerdata() {
		LoginPage lp = new LoginPage(driver);
		lp.setUname(uname);
		lp.setPwd(pwd);
		lp.Clickbtn();
		
		AddNewCustomerPage addcust = new AddNewCustomerPage(driver);
		
		addcust.custName("Testname");
		addcust.custGender("male");
		addcust.custDob("1986","06","10");
		addcust.custAddress("Scarborough, Canada");
		addcust.custCity("Toronto");
		addcust.custState("Ontario");
		addcust.custPinno("12345");
		addcust.custTelephoneno("1234567890");
		
		String email=randomEmail()+"test.com";
		addcust.custEmailid(email);
		
		addcust.custSubmitbutton();
	}
	
	
	public String randomEmail() {
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	

}
