package testCases;


import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	

	
	@Test(groups={"regression","master"})
	public void Verify_account_regisration()
	{
		try {
			logger.info("-------Starting TC001_AccountRegistrationTest--------");
		
		HomePage hp =new HomePage(driver);
		AccountRegistrationPage regPage= new AccountRegistrationPage(driver);
		
		hp.clickMyAccount();
		hp.clickRegister();
		
		logger.info("...providinmg customer details....");
		regPage.setFirstName(randomString());
		regPage.setLastName(randomString());
		regPage.setEmail(randomString() + "@gmail.com");
		regPage.setTelephone(randomNumber());
		
		String pwd= randomAlphaNumeric();
		regPage.setPwd(pwd);
		regPage.setConfirmPwd(pwd);
		
		regPage.clickAgree();
		regPage.clickContinue();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		logger.info("...Validating message....");
		String actual = regPage.getConfirmationMessage();
		System.out.println("Actual = " + actual); 	
		Assert.assertEquals(actual, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			
			logger.debug("-----Debug Log-------");
			logger.error("Test Failed due to: " + e.getMessage());
		    Assert.fail(e.getMessage());
		}
		
		logger.info("-------Finished TC001_AccountRegistrationTest--------");
	}
	
	
	
	

	
	
}
