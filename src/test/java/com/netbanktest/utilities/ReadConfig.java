package com.netbanktest.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File ("./Configurations/Testconfig.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getURL() {
		String URL=pro.getProperty("url");
		return URL;
	}
	public String getUsername() {
		String Username = pro.getProperty("uname");
		return Username;	
	}
	public String getPassword() {
		String Password = pro.getProperty("pwd");
		return Password;	
	}
}
