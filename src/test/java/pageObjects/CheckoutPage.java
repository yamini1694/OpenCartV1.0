package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='payment_address' and @value='new']")
	WebElement newaddress;

	@FindBy(xpath = "//input[@id='button-account']")
	WebElement btnContinueOnCheckoutOption;

	@FindBy(xpath = "//input[@id='button-payment-address']")
	WebElement btnContinueOnBillingOption;

	@FindBy(xpath = "//input[@id='button-shipping-address']")
	WebElement btnContinueOnDeliveryOption;

	@FindBy(xpath = "//input[@id='button-shipping-method']")
	WebElement btnContinueOnDeliveryMethod;

	@FindBy(xpath = "//input[@id='button-payment-method']")
	WebElement btnContinueOnPaymentMethod;

	@FindBy(xpath = "//input[@id='button-confirm']")
	WebElement btnConfirmOrder;

	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	WebElement firstname;

	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	WebElement lastname;

	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	WebElement address;

	@FindBy(xpath = "//input[@id='input-payment-city']")
	WebElement city;

	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	WebElement postcode;

	@FindBy(xpath = "//select[@id='input-payment-country']")
	WebElement country;

	@FindBy(xpath = "//select[@id='input-payment-zone']")
	WebElement state;

	

	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkboxOnBillingDetails;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkboxOnPaymentMethod;

	@FindBy(xpath = "//h1[text()='Your order has been placed!']")
	WebElement msgConfirmationOrderPlaced;

	public void setFirstName(String name) {
		firstname.sendKeys(name);
	}

	public void setLastName(String name) {
		lastname.sendKeys(name);
	}

	



	public void setCity(String name) {
		city.sendKeys(name);
	}

	public void setaddress(String name) {
		address.sendKeys(name);
	}

	public void setPostCode(String name) {
		postcode.sendKeys(name);
	}
	
	

	public void ClickContinueOnBilling() {
		btnContinueOnBillingOption.click();
	}

	public void ClickContinueOnCheckout() {
		btnContinueOnCheckoutOption.click();
	}

	public void ClickConfirmOrder() {
		btnConfirmOrder.click();
	}

	public void ClickContinueOnPaymentMethod() {
		btnContinueOnPaymentMethod.click();
	}

	public void ClickContinueOnDeliveryMethod() {
		btnContinueOnDeliveryMethod.click();
	}

	public void ClickContinueOnDeliveryOption() {
		btnContinueOnDeliveryOption.click();
	}

	public void AddNewAddress() {
		newaddress.click();
	}

	public void ClickcheckboxOnBillingDetails() {
		checkboxOnBillingDetails.click();
	}
	
	public void ClickcheckboxOnPaymentMethod() {
		checkboxOnPaymentMethod.click();
	}
	
	
	
	public boolean isOrderPlaced() throws InterruptedException
	{
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		btnConfirmOrder.click();
		Thread.sleep(3000);
		
		if(msgConfirmationOrderPlaced.getText().equals("Your order has been placed!"))
		{
			return true;
		}
		
		else
			return false;
	}
	
	public void setCountry(String name)
	{
		Select s= new Select(country);
		s.selectByVisibleText(name);
	}
	
	public void setState(String name)
	{
		Select s= new Select(state);
		s.selectByVisibleText(name);
	}
}
