package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data valid- login success- test pass- logout
 * Data Valid- Login failed - Test Fail - 
 * data Invalid - Login Pass - Test Failed - Logout
 * Data Invalid - Login Failed- Test Pass
 * 
 */
public class TC003_LoginTestUsingTDD extends BaseClass{
	
	
	@Test(dataProvider="logindata", dataProviderClass=DataProviders.class, groups= {"TDDtest"}) // dataprovider class is created in other class/pkg, so 2nd parameter is mandatory
	public void Verify_LoginTDD(String email, String pwd, String response) throws InterruptedException
	{
		try
		{
			HomePage hp =new HomePage(driver);
			LoginPage lp= new LoginPage(driver);
			MyAccountPage map = new MyAccountPage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	
			lp.setEmail(email);
			lp.setPassword(pwd);
			
			
			lp.clickLogin();
			
			/*Data valid- login success- test pass- logout
			 * Data Valid- Login failed - Test Fail - 
			 * data Invalid - Login Pass - Test Failed - Logout
			 * Data Invalid - Login Failed- Test Pass
			 * 
			 */
			boolean targetPage=map.IsMyAccountPageExist();
			
			if(response.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					Assert.assertTrue(true);
					map.clcikLogout();
				}
				else
					Assert.assertTrue(false);
			}
			
			if(response.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					map.clcikLogout();
					Assert.assertTrue(false);
					
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

}
