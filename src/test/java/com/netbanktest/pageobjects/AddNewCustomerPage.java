package com.netbanktest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	WebDriver rdriver;
	
	public AddNewCustomerPage(WebDriver ldriver) {
		rdriver = ldriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(how = How.XPATH, using= "//a[@href='addcustomerpage.php']")
			WebElement clickAddCustomer;
	@FindBy(name="name")
	WebElement customerName;
	@FindBy(name="rad1")
	WebElement customerGender;
	@FindBy(name="dob")
	WebElement dateofBirth;
	@FindBy(name = "addr")
	WebElement txtAddress;
	@FindBy(name="city")
	WebElement txtCity;
	@FindBy(name = "state")
	WebElement txtState;
	@FindBy(name="pinno")
	WebElement txtPinno;
	@FindBy(name="telephoneno")
	WebElement txttelephone;
	@FindBy(name="emailid")
	WebElement txtemailid;
	//@FindBy(name="password")
	//WebElement txtPassword;
	@FindBy(name="sub")
	WebElement btnSubmit;

	public void custName(String cname) {
		customerName.sendKeys(cname);
	}
	public void custGender(String cgender) {
		customerGender.click();
	}
	public void custDob(String yyyy, String mm, String dd) {
		dateofBirth.sendKeys(yyyy);
		dateofBirth.sendKeys(mm);
		dateofBirth.sendKeys(dd);
	}
	public void custAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}
	public void custCity(String ccity) {
		txtCity.sendKeys(ccity);
	}
	public void custState(String cstate) {
		txtState.sendKeys(cstate);
	}
	public void custPinno(String cpinno) {
		txtAddress.sendKeys(String.valueOf(cpinno));
	}
	public void custTelephoneno(String ctelephone) {
		txttelephone.sendKeys(ctelephone);
	}
	public void custEmailid(String cemail) {
		txtemailid.sendKeys(cemail);
	}
	public void custSubmitbutton() {
		btnSubmit.click();
	}
}

