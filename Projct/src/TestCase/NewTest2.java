package TestCase;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.page.object.spicejet.flightBooking;
import com.page.object.spicejet.flightStatusCheck;

import pack1.dataprovider;
import pack1.utility;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.spi.ErrorCode;
//import org.apache.poi.hssf.model.Sheet;
//import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class NewTest2 {
	
	WebDriver driver;
	com.page.object.spicejet.flightBooking flightbooking;
	flightStatusCheck flightStatusCheck;
	SoftAssert check;
	 utility ul ;
  
  
  @Test(dataProvider = "dp1",dataProviderClass = dataprovider.class)
  public void f2(Map<Object,Object> map) throws Exception 
  {
	String[] date = map.get("date").toString().split("-");
	
	  Reporter.log("Book Flight");
	  Thread.sleep(30);
	  flightbooking.checkFamFren();
	  //System.out.println(map.get("From").toString()+map.get("To").toString());
	  flightbooking.selectDepartureCity(map.get("From").toString());
	  Thread.sleep(30);
	  
	  
	 flightbooking.selectArrivalCity(map.get("To").toString());
	  Thread.sleep(30);  
	  flightbooking.selectDeptDtae(date);
	  flightbooking.selectpassenger(3);
	  flightbooking.selectcurrency("INR");
	  flightbooking.search();
	
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
	 //driver.close();
  }

}

