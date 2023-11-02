package com.Swaglabs_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwageLabs_utility.Utility;

public class Overviewpage
{
	private WebDriver driver;
	
	public Overviewpage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By productDetails =  By.id("checkout_summary_container");
	private By finishbtn = By.id("finish");
	private By msg = By.tagName("h2");
	
	//methods 
	public void getDetails ()
	{
		String text = driver.findElement(productDetails).getText();
		System.out.println("product details are :");
		System.out.println(text);
	}
	
	public void dofinish()
	{
		driver.findElement(finishbtn).click();
		Utility.getScreenShot(driver);
		System.out.println("final result : "+driver.findElement(msg).getText());
	}
	
	
	

}
