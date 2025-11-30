package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.ShoppinCartPage;
import testBase.BaseClass;

public class TC006_CheckoutTest_EndToEnd extends BaseClass{
	
	@Test
	
	public void endToEndTest() throws InterruptedException
	{
		
	
		
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		lp.clickLogin();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		SearchPage sp= new SearchPage(driver);
		hp.setSearchText(prop.getProperty("searchProductName"));
		hp.clickSearch();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		if(sp.isProductExist(prop.getProperty("searchProductName")))
		{
			sp.selectproduct(prop.getProperty("searchProductName"));
			sp.setQuantity("2");
			sp.clickAddToCart();
		}
		
		ShoppinCartPage cart=new ShoppinCartPage(driver);
		cart.clickItem();
		cart.clickViewCart();
		cart.clickCheckout();
		
		CheckoutPage chk = new CheckoutPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		chk.AddNewAddress();
		

		Thread.sleep(1000);
		chk.setFirstName(randomString().toUpperCase());
		
		Thread.sleep(1000);
		chk.setLastName(randomString().toUpperCase());		
		
		Thread.sleep(1000);
		chk.setaddress(randomString()); 
		
		Thread.sleep(1000);	
		chk.setCity("Delhi");
		
		Thread.sleep(1000);
		chk.setPostCode("414007");
		
		Thread.sleep(1000);
		chk.setCountry("India");
		
		Thread.sleep(1000);
		chk.setState("Delhi");
		
	
		chk.ClickContinueOnBilling();
		Thread.sleep(4000);
		
		chk.ClickContinueOnDeliveryOption();
		Thread.sleep(1000);
		chk.ClickContinueOnDeliveryMethod(); 
		Thread.sleep(1000);
		chk.ClickcheckboxOnPaymentMethod();
		Thread.sleep(1000);
		chk.ClickContinueOnPaymentMethod();
		Thread.sleep(1000);
		 chk.ClickConfirmOrder();
			Thread.sleep(5000);
		 
		 Assert.assertEquals(chk.isOrderPlaced(), true);
		
		
		
		
	}

}
