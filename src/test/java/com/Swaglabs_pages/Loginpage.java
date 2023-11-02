package com.Swaglabs_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.SwageLabs_utility.Utility;

public class Loginpage
{
	//Encapsulation = data + function 
	private WebDriver driver;
	
	//Initialize driver
	public Loginpage(WebDriver driver)//base class driver
	{
		this.driver = driver;
	}
	
	
	//Locators
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By btn = By.id("login-button");

	 //Methods
	public void doLogin(String un,String psw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		Utility.getScreenShot(driver);
		driver.findElement(btn).click();
		//validation
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login Failed");
		System.out.println("user succesfully login");		
		
	}

	public String getAppTitle()
	{
		return driver.getTitle();
		
	}
	public String getAppurl()
	{
		return driver.getCurrentUrl();
	}
	
	
	
	
	
}
