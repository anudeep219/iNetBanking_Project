package com.netbanktest.testcases;

import java.io.IOException;

import com.netbanktest.pageobjects.LoginPage;
import com.netbanktest.utilities.XLUtils;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.*;


public class TC2_Loginpage_Test extends Baseclass {

	@Test (dataProvider = "LoginData")
	public void loginDDT(String user, String passWord)throws IOException {
		logger.info("Inside LogindDDT");
		String url1 ="https://demo.guru99.com/V1/";
		driver.get(url1);
		
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setUname(user);
		logger.info("username provided");
	    lp.setPwd(passWord);
	    logger.info("password provided");
	    lp.Clickbtn();
	    
	    if(isAlertPresent()==true)
	    {
	    	driver.switchTo().alert().accept();
	    	driver.switchTo().defaultContent();
	    	Assert.assertTrue(false);
	    	logger.warn("login Failed");
	    	
	    }
	    else {
	    	Assert.assertTrue(true);;
	    	logger.info("login passed");
	        lp.ClickLogout();;
	        driver.switchTo().alert().accept();
	        driver.switchTo().defaultContent();
	    }
	}
	        
		public boolean isAlertPresent() {
			try {
				driver.switchTo().alert();
				return true;
			}
			catch(NoAlertPresentException e) {
				return false;
		}
		
	}
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path="C:\\Users\\balak\\eclipse-workspace\\netbanking_testv1\\src\\test\\java\\com\\netbanktest\\testdata\\LoginData.xlsx";
		//String path="./netbanking_testv1/src/test/java/com/netbanktest/testdata/LoginData.xlsx";
		int rownum= XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		for(int i=1; i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
	
}
