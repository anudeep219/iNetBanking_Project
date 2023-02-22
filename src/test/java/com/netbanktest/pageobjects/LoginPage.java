package com.netbanktest.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	
}
	@FindBy(name="uid") WebElement txtusername;
	@FindBy(name="password") WebElement txtpassword;
	@FindBy(name="btnLogin") WebElement loginbtn;
	@FindBy(xpath="//a[@href='Logout.php']") WebElement logoutbtn;
	//@FindBy(linkText="Log out")WebElement logoutbtn;
	
	public void setUname(String uname)
	{
      txtusername.sendKeys(uname);
	}
	
	public void setPwd(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
    public void Clickbtn()
    {
    	loginbtn.click();
    	
    }
    public void ClickLogout() {
    	
    	logoutbtn.click();
    	
    }
}



