package utility;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class CommonFunctions {
	
	public static void TakeScrShot(String path, WebDriver driver) throws IOException
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
		LocalDateTime now = LocalDateTime.now();
		String screenshotFileName= dtf.format(now); 
		
		System.out.println(path);
		String fileName=screenshotFileName+".PNG";
		System.out.println(fileName);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File scrShotFile= scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(path+"\\"+fileName);
		System.out.println("Full file name"+path+"\\"+fileName);
		Files.copy(scrShotFile, DestFile);	
	}
	
	public static WebDriverWait wait(WebDriver driver,int druation)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(druation));
		return wait;
	}
}
