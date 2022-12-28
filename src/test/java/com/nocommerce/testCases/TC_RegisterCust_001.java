package com.nocommerce.testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.CustRegistration;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_RegisterCust_001 extends BaseClass{
	
	@Test
	public void registerCustomer() throws InterruptedException
	{
		try {
		//login to WebSite
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
		
		//Navigating and registering customer
		CustRegistration cr = new CustRegistration(driver);
		logger.info("Before clicking dropdown");
		cr.clickCustomerDropdown();
		logger.info("After clicking dropdown");
		Thread.sleep(2000);
		cr.clickCustomer();
		logger.info("In customer registration page");
		Thread.sleep(2000);
		cr.clickAddNew();
		Thread.sleep(2000);
		cr.setEmail(randomString()+"@email.com");
		cr.setPassword(randomalphanumeric());
		logger.info(randomalphanumeric());
		cr.setFirstName(rb.getString("firstname"));
		cr.setLastName(rb.getString("lastname"));
		cr.setDateofBirth(rb.getString("dob"));
		cr.setGender();
		cr.setCompany(rb.getString("company"));
		cr.clickSave();
		Thread.sleep(2000);
		String msg= cr.getConfigurationMessage();
		logger.info(msg);
		if(msg.contains("The new customer has been added successfully."))
		{
			Assert.assertTrue(true);
			logger.info("Test Case passed");
		}
		else
		{
			Assert.fail();
			logger.info("Test case failed");
		}
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}
