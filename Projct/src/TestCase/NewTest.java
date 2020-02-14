package TestCase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.page.object.spicejet.flightBooking;
import com.page.object.spicejet.flightStatusCheck;

import pack1.MyException;
import pack1.dataprovider;
import pack1.utility;


import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import org.apache.log4j.spi.ErrorCode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeMethod;

public class NewTest {
	
	WebDriver driver;
	com.page.object.spicejet.flightBooking flightbooking;
	flightStatusCheck flightStatusCheck;
	SoftAssert check;
	 utility ul ;
	 Map<String, Object[]> TestNGResults;

  @Test(dataProvider = "dp1",dataProviderClass = dataprovider.class,description = "check flight status")
  public void f1(Map<Object,Object> map) throws Exception 
  {
	  try {
	  Reporter.log("Check Flight");
	  flightStatusCheck.selectflightstatuscheck();
	  Thread.sleep(30);
	  
	  flightStatusCheck.selectDepCIty(map.get("From").toString());
	  flightStatusCheck.selectArrCIty(map.get("To").toString());
	  flightStatusCheck.selectDate(map.get("date").toString());
	  utility.takeScreenshot(driver);
	  flightStatusCheck.SelectSearch();
	  System.out.println(map.get("To").toString());
	  try
	  {
	  flightStatusCheck.SelectflightSearch();
	  }catch(Exception e)
	  {
		  throw new MyException("Invalid Selector",e,ErrorCode.GENERIC_FAILURE);
	  }
	  flightStatusCheck.Displayflightinfo();
	  utility.takeScreenshot(driver);
	  }catch(Exception e)
	  {
		  throw new MyException("Invalid Selector",e,ErrorCode.GENERIC_FAILURE);
	  }
	  
	  //check.assertEquals(actual, expected);
	  check.assertAll();
	  
	  
	 
  }
  
 
@BeforeMethod
  public void beforeachTest() {
	check= new SoftAssert();
	 System.setProperty("webdriver.gecko.driver","C:\\eclipse\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get("https://www.spicejet.com/");
	  System.out.println(driver.getTitle());
	  
	  //set screenshot path
  
  String scrFolder = "E:\\Projct\\Result\\Res"
	            + new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString();
    new File(scrFolder).mkdir();
    System.setProperty("scr.folder", scrFolder);//set path to environment variable
	    
	  //AssertJUnit.assertEquals(driver.getTitle(),"SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
	 check.assertEquals(driver.getTitle(), "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
	 
	  flightbooking =PageFactory.initElements(driver, flightBooking.class);
	  flightStatusCheck =PageFactory.initElements(driver, flightStatusCheck.class);
	  
	  
	 Reporter.log("Befor class pass");
	  
	  
  }

  @AfterMethod
  public void afterTest() {
	 
	  System.out.println("After");
	 driver.close();
  }
  @AfterSuite
  public void teardown() {
  
  }

}
