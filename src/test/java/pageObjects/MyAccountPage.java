package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgMyAccount;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement btnLogout;
	
	public void  clcikLogout()
	{
		btnLogout.click();
	}
	public boolean IsMyAccountPageExist()
	{
		try
		{
			return msgMyAccount.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
