package com.netbanktest.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.netbanktest.utilities.ReadConfig;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Baseclass {
	
	ReadConfig readconfig = new ReadConfig();
		public String url = readconfig.getURL();
		public String uname = readconfig.getUsername();
		public String pwd = readconfig.getPassword();
		public WebDriver driver;
		public Logger logger;
		
		@Parameters("browser")
		@BeforeClass
		public void setup(String br)
		
		{
			logger = Logger.getLogger("netbanking_testv1");
			PropertyConfigurator.configure("log4j.properties.txt");
			
			if (br.equals("Chrome"))
			{
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			} else if(br.equals("edge"))
			{
				driver = new EdgeDriver();
				driver.manage().window().maximize();
			}else {
				System.out.println("Invalid Browser");
			}
			
	
		}
		
		@AfterClass
		public void teardown() {
			
			driver.quit();
		}
		
		public void capturescreen(WebDriver driver, String tname) throws IOException{
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File("./Screenshots/"+ tname + ".png");
			FileUtils.copyFile(source, target);
			System.out.println("Screenshot taken");
			}

}
