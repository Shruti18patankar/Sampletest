package com.SwagLabs_Testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.SwageLabs_utility.Utility;
import com.SwageLabs_utility.propertiesUtil;
import com.Swaglabs_pages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass
{
	public WebDriver driver;
	public Loginpage lp;
	public Invantorypage ip;
	public AddTocartPage ap;
	public CheckoutPage cp;
	public Overviewpage op;
	public propertiesUtil Ps;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
     public 	ExtentTest test;
	
	@BeforeSuite
	public void reportsSetup()
	{
		extent = new ExtentReports();

		  //path of report
		   spark = new ExtentSparkReporter("Reports/SwagLabs.html");
		  
		  //configuration for report
		  spark.config().setReportName("SwagLabs_Automation_report");
		  spark.config().setDocumentTitle("sprint1 report");
		  spark.config().setTheme(Theme.DARK);
		  
		  //atteched report
		  extent.attachReporter(spark);
		  
		  //creat a test
		  
		  test =  extent.createTest("SwagLabsTest");
	}
	
	@BeforeTest
	public void broswersetup()
	{
		driver = new ChromeDriver();
		Reporter.log("Log:Webdriver session is created!",true);
		test.pass("driver session is created");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		Reporter.log("Log:Swaglab application is open",true);
		test.pass("application open succesfully");
		Ps = new propertiesUtil ();
		lp = new Loginpage(driver);
		ip =  new Invantorypage(driver);
		ap = new AddTocartPage(driver);
		cp = new CheckoutPage(driver);
		op = new Overviewpage(driver);
		
		
	}
	
	@BeforeClass
	public void pagesetup()
	{
		System.out.println("**************login functionality**********");
		System.out.println("system titile is "+lp.getAppTitle());
		System.out.println("application url is"+lp.getAppurl());
		lp.doLogin(Ps.getData("un"),Ps.getData("psw"));
		Reporter.log("Log:user login is completed",true);
		test.pass("user login is completed");
		Utility.getScreenShot(driver);
		pause();
		System.out.println("******************invantorypage***************");
		System.out.println("product count are "+ip.getproductcount());
		Reporter.log("Log:total product count is calculated",true);
		test.pass("total product count is calculated");
		pause();
		ip.getproductlable();
		ip.Addproductocart(Ps.getData("pname"));
		Reporter.log("Log:product added into cart",true);
		test.pass("product added succesfully");
		pause();
		Utility.getScreenShot(driver);
		System.out.println("***********cart page******************");	
		ap.opencartpage();
		Utility.getScreenShot(driver);
		ap.doCheckout();
		Utility.getScreenShot(driver);
		test.pass("chekout is completed");
		System.out.println("*************chekout***********");
		cp.docountinue(Ps.getData("fname"),Ps.getData("lname"),Ps.getData("zcode"));
		Utility.getScreenShot(driver);
		System.out.println("*********overviewpage*****************");
		Reporter.log("Log:order completd",true);
		test.pass("order placed");
	}
	
	public void pause()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@AfterSuite()
	public void exitreports()
	{
		extent.flush();
	}
	
	
	

}
