package com.Swaglabs_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SwageLabs_utility.Utility;

public class Invantorypage
{
	private WebDriver driver;//declare driver
	
	public Invantorypage(WebDriver driver)
	{
		this.driver = driver; //initialization		
	}
	
	//Locators
	private By pcount = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']");
	private By plable = By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name ']");
	private By cartbtn = By.xpath("//button[text() = 'Add to cart']");
	
	//methods 
	public int getproductcount()
	{
		return driver.findElements(pcount).size();
	}
	public void getproductlable()
	{
		System.out.println("*************product lable*****************");
		List<WebElement>list = driver.findElements(plable);
		for(WebElement i : list)
		{
			System.out.println(i.getText());
		}
	}
	
	public void Addproductocart(String pname)
	{
		List<WebElement>list = driver.findElements(plable);
		for(WebElement i : list)
		{
			if(i.getText().contains(pname))
			{
				i.click();
				break;
			}
		}
		Utility.getScreenShot(driver);
		
		driver.findElement(cartbtn).click();
		Utility.getScreenShot(driver);
		System.out.println(pname+"product added to the cart");
	}
	
	
	
	
	
	
	
	
	
	

}
