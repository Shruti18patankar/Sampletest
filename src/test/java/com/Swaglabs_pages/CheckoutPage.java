package com.Swaglabs_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.SwageLabs_utility.Utility;

public class CheckoutPage 
{
      private WebDriver driver; //declaration
      
      public CheckoutPage (WebDriver driver)//initialization
      {
    	this.driver = driver;  
      }
      
    

	//Locators
      private By fname = By.id("first-name");
      private  By lname = By.id("last-name");
      private By zcode = By.name("postalCode");
      private By cancelbtn = By.id("cancel");
      private By countinuebtn = By.id("continue");
      
      
      //methods 
      public void docancel()
      {
    	  driver.findElement(cancelbtn).click();
      }
      
      public void docountinue(String fn,String ln,String zc)
      {
    	  System.out.println("user details");
    	  driver.findElement(fname).sendKeys(fn);
    	  driver.findElement(lname).sendKeys(ln);
    	  driver.findElement(zcode).sendKeys(zc);
    	  Utility.getScreenShot(driver);
    	  driver.findElement(countinuebtn).click();
      }
	
	
	
	
	
	
}
