package com.Swaglabs_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTocartPage 
{
	private WebDriver driver;//webDriver declaration
	
	public AddTocartPage(WebDriver driver)//Initialize
	{
		this.driver = driver;
	}
     //Locators
	private By cartpage = By.xpath("//a[@class='shopping_cart_link']");
	private By removebtn = By.xpath("//button[text() = 'Remove']");
	private By countshop = By.id("continue-shopping");
	private By checkout = By.xpath("//button[text() = 'Checkout']");
	
	//methods 
	public void doRemove()
	{
		driver.findElement(removebtn).click();
		System.out.println("product got removed From cart");
	}
	public void doCountinue()
	{
		driver.findElement(countshop).click();
		System.out.println("inventory page open");
	}
	public void doCheckout()
	{
		driver.findElement(checkout).click();
	}
	
	public void opencartpage()
	{
		driver.findElement(cartpage).click();
	}
	
	
	
	
	
	
	
}
