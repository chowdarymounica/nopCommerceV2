package com.nocommerce.testCases;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	

	
	@Test
	public void loginTest() throws InterruptedException 
	{
		driver.get(rb.getString("baseURL"));
		logger.info("URL is opened");
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(rb.getString("username"));
		logger.info("Username is provided");
		lp.setPassword(rb.getString("password"));
		logger.info("Password is provided");
		lp.clickLogin();
		Thread.sleep(5000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
			{
				Assert.assertTrue(true);
				logger.info("Test Passed");
				Thread.sleep(5000);
				lp.clickLogout();
			}
		else
		{
			logger.info("Test Failed");
			Assert.fail();
		}
		
	}
	

	
}
