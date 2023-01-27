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

public class RegistrationPage{
	WebDriver driver;

	public RegistrationPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;

	@FindBy(id="EMAIL_REG_FORM_SUBMIT")
	WebElement registerButton;
	
	public void Register(String firstname, String Lastname, String Email, String Password)
	{
		firstName.sendKeys(firstname);
		lastName.sendKeys(Lastname);
		email.sendKeys(Email);
		password.sendKeys(Password);
		registerButton.click();
		
	}
	
	
}

