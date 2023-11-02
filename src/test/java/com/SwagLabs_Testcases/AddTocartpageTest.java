package com.SwagLabs_Testcases;

import org.testng.annotations.Test;

public class AddTocartpageTest extends BaseClass
{
  @Test(priority=1)
  public void verifypageLaunch() 
  {
	 ap.opencartpage(); 
  }
  
  @Test(priority=2)
  public void verifypageRemove() 
  {
	  ap.doRemove();
	  pause();
  }
  
  @Test(priority=3)
  public void verifyCountinue() 
  {
	  ap.doCountinue();
	  pause();
	  ip.Addproductocart("Sauce Labs Bolt T-Shirt");
	  pause();
	  ap.opencartpage();
	  pause();
  }
  
  @Test(priority=4)
  public void verifyCheckout() 
  {
	  ap.doCheckout();
  }
  
  
  
  
}






