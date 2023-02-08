package absolvetechbyrohit.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import absolvetechbyrohit.TestComponents.BaseTest;
import absolvetechbyrohit.pageobjects.CartPage;
import absolvetechbyrohit.pageobjects.CheckoutPage;
import absolvetechbyrohit.pageobjects.ConfirmationPage;
import absolvetechbyrohit.pageobjects.LandingPage;
import absolvetechbyrohit.pageobjects.OrderPage;
import absolvetechbyrohit.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {

	//public static void main(String[] args) {
	
	String productName="ZARA COAT 3";
	
	@Test(dataProvider = "getData",groups= {"Purchase"})
	public void submitOrder(String email,String password,String productName) throws IOException {
	
	// TODO Auto-generated method stub
		ProductCatalogue productCatalogue= landingPage.loginApplication(email, password);
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage =  cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		WebElement PlaceOrder = driver.findElement(By.cssSelector(".action__submit"));
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//button[contains(text(),\"Apply Coupon\")]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", PlaceOrder);
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue= landingPage.loginApplication("contact@rohit.com", "Cricket@123");
		OrderPage ordersPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName)); 
	
	}
	
	@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"contact@rohit.com","Cricket@123","ZARA COAT 3"},{"contact1@rohit.com","Cricket@1234","ADIDAS ORIGINAL"}};
	}
}
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
		//LandingPage landingPage = launchApplication();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//driver.get("https://rahulshettyacademy.com/client");
		
		
//		LandingPage landingPage = new LandingPage(driver);
//		landingPage.goTo();
		//CartPage cartPage= new CartPage(driver);
		
		//confirmationPage.getConfirmationMessage();
		//ConfirmationPage confirmationPage=  checkoutPage.submitOrder();
		//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
//		driver.findElement(By.id("userEmail")).sendKeys("contact@rohit.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Cricket@123");
//		driver.findElement(By.id("login")).click();
		//ProductCatalogue productCatalogue = new ProductCatalogue(driver);
//		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
//		List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		WebElement prod= products.stream().filter(product->
//		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//		
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//		 //products.stream().filter(item->item.getText().contains("freshwork")).collect(Collectors.toList()).forEach(item->System.out.println(item));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//List <WebElement> cartProducts= driver.findElements(By.cssSelector(".cartSection h3"));
		
		//Boolean match=	cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		//driver.findElement(By.cssSelector(".totalRow button")).click();
//		
		


