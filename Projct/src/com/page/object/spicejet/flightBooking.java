package com.page.object.spicejet;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class flightBooking {
	WebDriver driver;
	
	@FindBy(id="ctl00_mainContent_ddl_originStation1_CTXT")
	private WebElement depCityInput;
	

	@FindBy(id="ctl00_mainContent_ddl_destinationStation1_CTXT")
	private WebElement arrivalCityInput;
	
	@FindBy(xpath="//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']")
	private WebElement depCitydropdown;
	
	@FindBy(xpath="//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']")
	private WebElement arrivalCitydropdown;
	
	@FindBy(name = "ctl00$mainContent$view_date1")
	private  WebElement depDateInput;
	
	@FindBy(xpath = "//div[@class='ui-datepicker-group ui-datepicker-group-first']//table[@class='ui-datepicker-calendar']")
	private WebElement depdatetable;
	
	@FindBy(xpath = "//div[@id='divpaxinfo']")
	private WebElement passengersinput;
	
	@FindBy(xpath = "//select[@id='ctl00_mainContent_ddl_Adult']")
	private WebElement passengersAdult;
	
	@FindBy(xpath = "//input[@id='ctl00_mainContent_chk_friendsandfamily']")
	private WebElement FamFrenCheck;
	
	@FindBy(xpath = "//select[@id='ctl00_mainContent_DropDownListCurrency']")
	private WebElement currency;
	
	@FindBy(id="ctl00_mainContent_btn_FindFlights")
	private WebElement findsubmit;
	
	
	
	
	public flightBooking(WebDriver driver)
	{
		Reporter.log("Inside flightbooking constructor");
		this.driver = driver;
	}
	
	public void checkFamFren()
	{
		System.out.println("Check box");
		if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", FamFrenCheck);
	    }
		try {
//		if(!FamFrenCheck.isSelected())
//		{
			FamFrenCheck.click();
//		}
		}catch(Exception e)
		{
			Reporter.log("No Such Element found : Check Box Familyand Friends");
		}
	}


	public void selectDepartureCity(String city) throws Exception
	{
		Reporter.log("Inside flightbooking dep");
		depCityInput.sendKeys(city);
		Thread.sleep(10);

	}
	public void selectArrivalCity(String city1) throws Exception
	{
			Reporter.log("Inside flightbooking dep2");
			System.out.println(city1);
			arrivalCityInput.click();
			Thread.sleep(10);
			List<WebElement> arrcitys = arrivalCitydropdown.findElements(By.tagName("a"));
			
			for(WebElement arrcity:arrcitys)
			{
				String cityname = arrcity.getText();
				//System.out.println(cityname + city1);
				if(cityname.equals(city1))
				{
					
					arrcity.click();
					break;
				}
			}
	}
	
	public void selectDeptDtae(String[] date) throws InterruptedException
	{
		depDateInput.click();
		Thread.sleep(200);
		List <WebElement> ls = depdatetable.findElements(By.tagName("td"));
		
		for(WebElement l : ls)
		{
			String cityname1 = l.getText();
			if(cityname1.equals(date[0]))
			{
				l.click();
				break;
			}
			
		}
		System.out.println(date[0]);
	}
	
	public void selectpassenger(int no ) throws InterruptedException
	{
		passengersinput.click();
		Thread.sleep(200);
		
		Select adult = new Select(passengersAdult);
		adult.selectByIndex(no);
	}
	public void selectcurrency(String currency1) throws InterruptedException
	{
		currency.click();
		Thread.sleep(200);
		
		Select curry = new Select(currency);
		curry.selectByValue(currency1);
	}
	public void search()
	{
		findsubmit.click();
	}
	
	
}
