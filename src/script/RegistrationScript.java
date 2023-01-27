package script;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.RegistrationPage;


public class RegistrationScript {
	
	WebDriver cd=null;
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");		
		cd= new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);
		String url="https://www.ebay.com/";
		System.out.println("Start Script");
		cd.get(url);
	}
	
@Test
	public void steps()
	{
	String url="https://www.ebay.com/";
	System.out.println("Start Script");
	cd.get(url);
	System.out.println("Registerion");
	HomePage hp= new HomePage(cd);
	hp.ClickRegistrationLink();
	RegistrationPage reg= new RegistrationPage(cd);
	reg.Register("Himanshu", "Test", "himanshutest11@gmail.com", "Passw0rd#1123");
	}
	
	@AfterTest
	public void tearDown()
	{
//		cd.close();
	}

}
	
