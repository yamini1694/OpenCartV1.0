package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SerachProductTest extends BaseClass{
	
	@Test
	public void searchProduct()
	{
		HomePage hp= new HomePage(driver);
		
		SearchPage sp= new SearchPage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		
		hp.setSearchText("mac");
		hp.clickSearch();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Assert.assertEquals(sp.isProductExist("MacBook"), true);
	}

}
