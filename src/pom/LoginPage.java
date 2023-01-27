package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage{
	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userid")
	WebElement UserID;
	
	@FindBy(id="pass")
	WebElement password;

	@FindBy(id="signin-continue-btn")
	WebElement Continue;
	
	@FindBy(id="sgnBt")
	WebElement Signin;
	
	
	public void Login(String username, String Password)
	{
		UserID.sendKeys(username);
		Continue.click();
		password.sendKeys(Password);
		Signin.click();
	}
	
	
}

