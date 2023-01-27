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
import org.testng.Assert;

public class CartPage{
	WebDriver driver;

	public CartPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement AddToCart;
	
	@FindBy(xpath="//div[@class='item-price font-title-3']//span[contains(text(),'$')]")
	WebElement CartValue;

	@FindBy(xpath="//div[@class='quantity']//span//select")
	WebElement QtyDropdown;	
	
	public void AddToCart()
	{
		AddToCart.click();
	}
	
	public void UpdateQuanityandVerifyTotalCost(String qty) throws InterruptedException
	{	
		 double productCost= Double.parseDouble(CartValue.getText().substring(4));
		 System.out.println("Total Product Cost: "+productCost);
		 double exceptedProductCost= productCost*2;
		 Select qtydropdown= new Select(QtyDropdown);
		 qtydropdown.selectByValue(qty);
		 Thread.sleep(4000);
		 double productCostUpdated= Double.parseDouble(CartValue.getText().substring(4));
		 System.out.println("Total Product Cost: "+exceptedProductCost);
		 System.out.println("Total Product Cost: "+productCostUpdated);
		 if(productCostUpdated==exceptedProductCost)
		 {
			 System.out.println("Price Updated Correctly");
		 }
		 else
		 {
			 System.out.println("Price Not updated correctly.");
		 }
		 Assert.assertTrue(productCostUpdated==exceptedProductCost);
	}
	
}

