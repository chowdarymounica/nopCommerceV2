package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustRegistration extends LoginPage {
	
	public CustRegistration(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a")
	WebElement drpdwnCustomers;
	
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a")
	WebElement lnkCustomers;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/form[1]/div/div/a")
	WebElement btnaddnew;
	
	@FindBy(id="Email")
	WebElement txtbxemail;
	
	@FindBy(id="Password")
	WebElement txtpwd;
	
	@FindBy(id="FirstName")
	WebElement txtfname;
	
	@FindBy(id="LastName")
	WebElement txtlname;
	
	@FindBy(id="Gender_Female")
	WebElement rdbtngender;
	
	@FindBy(id="DateOfBirth")
	WebElement txtdob;
	
	@FindBy(id="Company")
	WebElement txtcmpnyname;
	
	@FindBy(name="save")
	WebElement btnsave;
	
	@FindBy(xpath="/html/body/div[3]/div[1]/div[1]")
	WebElement msgbox;
	
	public void clickCustomerDropdown()
	{
		drpdwnCustomers.click();
	}
	
	public void clickCustomer()
	{
		lnkCustomers.click();
	}
	
	public void clickAddNew()
	{
		btnaddnew.click();
	}
	
	public void setEmail(String email)
	{
		txtbxemail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void setFirstName(String fname)
	{
		txtfname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtlname.sendKeys(lname);
	}
	
	public void setDateofBirth(String dob)
	{
		txtdob.sendKeys(dob);
	}
	
	public void setGender()
	{
		rdbtngender.click();
	}
	
	public void setCompany(String cmpny)
	{
		txtcmpnyname.sendKeys(cmpny);
	}
	
	public void clickSave()
	{
		btnsave.click();
	}
	
	public String getConfigurationMessage()
	{
		try {
		return msgbox.getText();
		} catch(Exception e) {
			return (e.getMessage());
		}
		
		
	}
}
