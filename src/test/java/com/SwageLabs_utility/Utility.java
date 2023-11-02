package com.SwageLabs_utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility

{
	//Screenshot
	public static  void getScreenShot(WebDriver driver)
	{
		 TakesScreenshot st = (TakesScreenshot) driver;
		 File temp =  st.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./"+"\\ScreenShot\\SwagLab"+System.currentTimeMillis()+".png");
		 
		 try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// this is for DropDown
	public static void dropdownselection(WebElement ele,String value)
	{
       Select dd = new Select(ele);
		
     	 List<WebElement> list1 = dd.getOptions();
     	
     	 System.out.println("total options are :"+list1.size());
      	System.out.println("is dropdown support multiple selection :"+dd.isMultiple());

     	for(WebElement i : list1)
     	{
     		System.out.println(i.getText());
     		
     		if(i.getText().contains(value))
     		{
     			i.click();
     			break;
     		}
     	}
	}
	
     	//this is for Explicit wait
     	
     	public static WebElement waitforElementPresent(WebDriver driver,By loc)
    	{
    		 WebDriverWait waitele = new WebDriverWait(driver,Duration.ofSeconds(10));
    		 return   waitele.until(ExpectedConditions.presenceOfElementLocated(loc));
    	}
    	
    	
    	public static WebElement  waitforElementvisibiliity(WebDriver driver, By loc)
    	{
    		WebDriverWait waitele = new WebDriverWait(driver,Duration.ofSeconds(10));
    		 return   waitele.until(ExpectedConditions.presenceOfElementLocated(loc));
    	}
    	
    	public  static WebElement waitforElementToClick(WebDriver driver,By loc)
    	{
    		WebDriverWait waitele = new WebDriverWait(driver,Duration.ofSeconds(10));
    		 return   waitele.until(ExpectedConditions.elementToBeClickable(loc));
    	}
    	
    	public static boolean waitforurlcontains(WebDriver driver,String text)
    	{
    		WebDriverWait waitele = new WebDriverWait(driver,Duration.ofSeconds(10));
    		 return   waitele.until(ExpectedConditions.urlContains(text));
    	}
    	
    	public static  boolean waitforTitlecontains(WebDriver driver,String text)
    	{
    		WebDriverWait waitele = new WebDriverWait(driver,Duration.ofSeconds(10));
    		 return   waitele.until(ExpectedConditions.titleContains(text));
    	}
    	
     	
     	
	}

