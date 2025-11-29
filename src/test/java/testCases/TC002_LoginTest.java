package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"sanity","master"})
	public void Verify_Login() throws InterruptedException
	{
		try 
		{
			HomePage hp =new HomePage(driver);
			LoginPage lp= new LoginPage(driver);
			MyAccountPage map = new MyAccountPage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			logger.info("----Entering email and password-----");
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			
			logger.info("---Click Login----");
			lp.clickLogin();
			
			
			Assert.assertEquals(map.IsMyAccountPageExist(), true);
		Thread.sleep(4000);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}
