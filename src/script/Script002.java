package script;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pom.CartPage;
import pom.HomePage;
import pom.LoginPage;
import pom.RegistrationPage;


public class Script002 {
	
	WebDriver cd=null;
	
	@BeforeTest
	public void setUp() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");		
		cd= new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);
	}
	
@Test
	public void steps() throws InterruptedException
	{
	String url="https://www.ebay.com/";
	System.out.println("Start Script");
	cd.get(url);
	System.out.println("Login");
	HomePage hp= new HomePage(cd);
	hp.ClickLogin();
	LoginPage  lp=new LoginPage(cd);
	lp.Login("himanshutest11@gmail.com", "Passw0rd#1123");
	hp.HoverOverFashionMenu();
	hp.ClickOnMenFootwear();
	hp.ClickOnFirstItem();
	CartPage cp= new CartPage(cd);
	cp.AddToCart();
	cp.UpdateQuanityandVerifyTotalCost("2");	
	}
	
	@AfterTest
	public void tearDown()
	{
//		cd.close();
	}

}
	
