package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath ="//input[@id='input-lastname']")
	WebElement txtLastName;
			
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement txtEmail;
					
	@FindBy(xpath ="//input[@id='input-telephone']")
	WebElement txtTelephone;
							
	@FindBy(xpath ="//input[@id='input-password']")
	WebElement	txtpwd;							
	
	@FindBy(xpath ="//input[@id='input-confirm']") 
	WebElement txtConfirmPwd;
	
	@FindBy(xpath ="//input[@name='agree']") 
	WebElement agree;
	
	@FindBy(xpath ="//input[@value='Continue']") 
	WebElement btnContinue; 
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String firstname)
	{
		txtFirstName.sendKeys(firstname);
	}
	public void setLastName(String lastname)
	{
		txtLastName.sendKeys(lastname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPwd(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void setConfirmPwd(String ConfirmPwd)
	{
		txtConfirmPwd.sendKeys(ConfirmPwd);
	}

	public void clickAgree()
	{
		agree.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMessage()
	{
		try {
			return msgConfirmation.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
}
