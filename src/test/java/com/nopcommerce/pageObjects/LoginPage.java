package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="Email")
	WebElement txtusername;
	
	@FindBy(id="Password")
	WebElement txtpwd;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement btnlogin;
	
	@FindBy(linkText="Logout")
	WebElement lnklogout;
	
	public void setUserName(String uname) 
	{
		txtusername.clear();
		txtusername.sendKeys(uname);
	}
	
	public void setPassword(String pwd) 
	{
		txtpwd.clear();
		txtpwd.sendKeys(pwd);
	}
	
	public void clickLogin() 
	{
		btnlogin.click();
	}
	
	public void clickLogout() 
	{
		lnklogout.click();
	}
}
