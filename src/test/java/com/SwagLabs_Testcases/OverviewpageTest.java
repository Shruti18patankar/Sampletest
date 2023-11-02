package com.SwagLabs_Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class OverviewpageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyordersummury()
  {
	 op.getDetails();
  }
  
  @Test(priority=2)
  public void verifycompletorder()
  {
	op.dofinish();  
  }
}
