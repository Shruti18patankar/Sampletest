package com.SwagLabs_Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvantorypageTest extends BaseClass
{
  @Test(priority=1)
  public void varifyproductcount()
  {
	int count = ip.getproductcount();
	Assert.assertEquals(count, 6,"product count is not matched");
	System.out.println("total product count is mathched "+count);
  }
  
  @Test(priority=2)
  public void varifyproductlable()
  {
	  ip.getproductlable();
  }

  @Test(priority=3)
  public void varifyAddtocart()
  {
	 ip.Addproductocart("Test.allTheThings() T-Shirt (Red)"); 
  }
}
