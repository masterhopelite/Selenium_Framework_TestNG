package absolvetechbyrohit.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import absolvetechbyrohit.TestComponents.BaseTest;
import absolvetechbyrohit.pageobjects.CartPage;
import absolvetechbyrohit.pageobjects.ProductCatalogue;

public class ErrorValiations extends BaseTest {
	@Test(groups = {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException , InterruptedException {
	
	// TODO Auto-generated method stub
		String productName="ZARA COAT 3";
		landingPage.loginApplication("contact@rohit.com", "Cricket@123");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	}
	
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("rahulshetty@gmail.com", "Iamking@000");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	

	}
}