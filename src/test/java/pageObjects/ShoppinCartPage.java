package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class ShoppinCartPage extends BasePage{

	public ShoppinCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
@FindBy(xpath="//span[@id='cart-total']")
WebElement btnItem;


@FindBy(xpath="//strong[text()=' View Cart']")
WebElement btnViewCart;

@FindBy(xpath="//a[text()='Checkout']")
WebElement btnCheckout;

@FindBy(xpath="//table[@class='table table-bordered']//strong[text()='Total:']//following::td")
WebElement totalPrice;

public void clickItem()
{
	btnItem.click();
}
	
public void clickViewCart()
{
	btnViewCart.click();
}

public void clickCheckout()
{
	btnCheckout.click();
}

public String getTotalPrice()
{
	return totalPrice.getText();
	}
}
