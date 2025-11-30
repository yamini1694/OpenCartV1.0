package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC005_AddToCartTest extends BaseClass{
	
	@Test
	public void productAddToCart()
	{
		try
		{
			HomePage hp= new HomePage(driver);
			
			SearchPage sp= new SearchPage(driver);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
			
			hp.setSearchText("iPhone");
			hp.clickSearch();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			if(sp.isProductExist("iPhone"))
			{
				sp.selectproduct("iPhone");
				sp.setQuantity("2");
				sp.clickAddToCart();
			}
			
			
			Assert.assertEquals(sp.isProductAddedToCart(), true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}

	}

}
