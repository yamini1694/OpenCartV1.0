package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath ="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement txtSearchBox;
	
	@FindBy(xpath="//span[@class='input-group-btn']//button")
	WebElement btnSearch;
	
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	public void setSearchText(String name)
	{
		txtSearchBox.sendKeys(name);
	}
	
	public void clickSearch()
	{
		btnSearch.click();
	}
}
