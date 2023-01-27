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
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[text()='register']")
	WebElement registrationLink;

	@FindBy(xpath="//span[@class='gh-ug-guest']//a[text()='Sign in']")
	WebElement LoginLink;
		
	@FindBy(xpath="//li/a[contains(text(),'Fashion')]")
	WebElement FashionMenu;

	@FindBy(xpath="//li/a[contains(text(),\"Men's footwear\")]")
	WebElement MenFootwear;

	@FindBy(xpath="//div[@class=\"b-info\"]")
	WebElement firstItem;

	public void ClickRegistrationLink()
	{
		System.out.println("Click Registartion");
		registrationLink.click();
	}
	
	public void ClickLogin()
	{
		System.out.println("Click Registartion");
		LoginLink.click();
	}

	public void HoverOverFashionMenu()
	{
		Actions act= new Actions(driver);
		act.moveToElement(FashionMenu).perform();
	}
	
	public void ClickOnMenFootwear()
	{ 
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(MenFootwear));
		MenFootwear.click();
	}

	public void ClickOnFirstItem()
	{ 
		firstItem.click();
	}
}
