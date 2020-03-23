package com.page.object.spicejet;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.testng.Reporter;

public class flightStatusCheck {
	
	WebDriver driver;
	
	public flightStatusCheck(WebDriver drivers)
	{
		this.driver=drivers;
	}
	String expr = "//*[regexp:test(@id, 'sometext[0-9]+_text')]";
	
	@FindBy(className = "flight_status")
	private WebElement flightstatus;
	
	@FindBy(id="FlifoSearchInputSearchView_originStation")
	private WebElement depCityInput;
	

	@FindBy(id="FlifoSearchInputSearchView_destinationStation")
	private WebElement arrivalCityInput;
	
	@FindBy(id="FlifoSearchInputSearchView_DropDownListFlightDate")
	private WebElement depdate;
	
	@FindBy(id="FlifoSearchInputSearchView_ButtonSubmit")
	private WebElement search;
	////a[@id^= 'flightAction_'][@id$='[0-9]'] input[id^='combo-'][id$='-inputWrap'][@id$='[0-9]']/a[@id="flightAction_1_1"]/
	@FindBy(id="flightAction_1_1")
	private WebElement flightsearch;
	
	@FindBy(xpath="//table[contains(@id,'flifoFlightInfo')]/tbody")
	private WebElement infoTable;
	
	@FindBy(xpath="//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-draggable']//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	private WebElement infoTableexit;
	
	
	
	public void selectflightstatuscheck() {
		Reporter.log("Check Flight staus link");
		flightstatus.click();
	}
	
	public void selectDepCIty(String depcity)
	{
		
		Select depcit = new Select(depCityInput);
		depcit.selectByVisibleText(depcity);
	}

	public void selectArrCIty(String arrcity)
	{
		Select arrcit = new Select(arrivalCityInput);
		arrcit.selectByVisibleText(arrcity);
	}
	public void selectDate(String date)
	{
		 Select depdates = new Select(depdate);
		depdates.selectByIndex(1);
	}
	
	public void SelectSearch()
	{
		search.click();
	}
	
	public void SelectflightSearch()
	{
		
		flightsearch.click();
		
	}
	public void Displayflightinfo()
	{
		
		List<WebElement> ls =infoTable.findElements(By.tagName("tr"));
		
		for (WebElement ls1 :ls)
		{
			System.out.println(ls1.getText());
		}
		try
		{
			
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[contains(@class,'titlebar-close')]")));
		infoTableexit.click();
			//driver.findElement(By.xpath("//button[contains(@class,'titlebar-close')]")).sendKeys(Keys.ESCAPE);
		}catch(Exception e)
		{
			Reporter.log("Not interactable Element found");
			infoTableexit.sendKeys(Keys.ESCAPE);
		}
	}
	
}
