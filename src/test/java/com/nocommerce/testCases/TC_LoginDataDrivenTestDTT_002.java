package com.nocommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

import utilities.DataProviders;

public class TC_LoginDataDrivenTestDTT_002 extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	
	public void test_LoginDTT(String username, String password, String result) throws InterruptedException
	{
	try {
		logger.info("******** Starting TC_LoginDTT ********");
		driver.get(rb.getString("baseURL"));
		driver.manage().window().maximize();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		Thread.sleep(5000);
		if (result.equals("Valid"))
		{
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
		if (result.equals("Invalid"))
		{
			if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
				{
					Assert.assertTrue(false);
					logger.info("Test Failed");
					Thread.sleep(5000);
					lp.clickLogout();
				}
			else
			{
				logger.info("Test Passed");
				Assert.assertTrue(true);
			}
			
		}
		
	}catch(Exception e)
	{
		Assert.fail();
	}
		
		logger.info("******** Ending TC_LoginDTT ********");
	}
		
}

