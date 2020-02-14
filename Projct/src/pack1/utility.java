package pack1;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utility {
	
	public static void takeScreenshot(WebDriver driver) throws IOException
	{
	String scrFolder = System.getProperty("scr.folder");
    File scrFile = ((TakesScreenshot) driver)
            .getScreenshotAs(OutputType.FILE);
    //copy screenshot to screenshot folder
    FileUtils.copyFile(
            scrFile,
            new File(scrFolder
                    + "/screenshot"
                    + new SimpleDateFormat("HHmmss").format(
                            Calendar.getInstance().getTime()).toString()
                    + ".png"));
	}

	
}
