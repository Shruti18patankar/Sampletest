package com.SwagLabs_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginpageTest extends BaseClass
{
	@Test(priority=1)
	  public void verifyCurrentUrl() 
	  {
		String Acturl =   lp.getAppurl();
		Assert.assertTrue(Acturl.contains("demo"), "url is not valid");
		System.out.println(" application url is "+Acturl);
		  
	  }
	
  @Test(priority=2)
  public void verifyTitle() 
  {
	  System.out.println("appilication title is "+lp.getAppTitle());
  }
  
  @Test(priority=3)
  public void verifyLogin() 
  {
	lp.doLogin("standard_user", "secret_sauce");  
  }
}





