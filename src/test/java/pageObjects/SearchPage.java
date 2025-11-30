package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) 
	{
		super(driver);
	}

	
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btnAddToCart;
	
	@FindBy(xpath="//input[@name='quantity']")
	WebElement txtquantity;
	
	@FindBy(xpath="//*[@id='content']/div[3]//img")
	List<WebElement> searchProduct;
	
	@FindBy(xpath="//div[contains(text(),'Success: You have added')]")
	WebElement msgConfirmation;
	
	public void clickAddToCart()
	{
		btnAddToCart.click();
	}
	
	public boolean isProductExist(String productname)
	{
		boolean flag= false;
		
		
		for(WebElement product:searchProduct)
		{
			if(product.getAttribute("title").equals(productname))
			{
				flag=true;
				break;
			}
			
		}
		return flag;
	}
	
	
	public void selectproduct(String productname)
	{
		
		for(WebElement product : searchProduct)
		{
			if(product.getAttribute("title").equals(productname))
			{
				product.click();
			}
		}
	}
	
	public void setQuantity(String quantity)
	{
		txtquantity.sendKeys(quantity);
	}
	
	public boolean isProductAddedToCart()
	{
		
		
		if(msgConfirmation.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	
	
	
	
	
	
}
