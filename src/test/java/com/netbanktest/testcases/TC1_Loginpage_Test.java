package com.netbanktest.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netbanktest.pageobjects.LoginPage;

public class TC1_Loginpage_Test extends Baseclass{
	
	@Test
	public void loginTest() throws IOException{
		
		driver.get(url);
		logger.info("url is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUname(uname);
		logger.info("username is set");
		lp.setPwd(pwd);
		lp.Clickbtn();
		
		if (driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login is successful");
		}
		else
		{
			capturescreen(driver, "LoginTest2");
			Assert.assertTrue(false);
			logger.info("login Failed");
		}
		
	}
	


}
