package SaurabhSeleniumPackage.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SaurabhSeleniumPackage.PageObjectModel.CartPage;
import SaurabhSeleniumPackage.PageObjectModel.ProductCatalogue;
import SaurabhSeleniumPackage.TestComponents.BaseTest;
import SaurabhSeleniumPackage.TestComponents.Retryfailedtestcases;

public class ErrorValidations extends BaseTest{

	@Test (groups= {"ErrorHandling"}, retryAnalyzer=Retryfailedtestcases.class)
	public void loginErrorMessage() throws IOException , InterruptedException {
	
		
		
		String productName = "ZARA COAT 3";
		landingPage.loginApplication("pratishtha@mailinator.com", "Welcome@1234");
		Assert.assertEquals("Incorrect email or password",landingPage.getErrorMessage());
		
		
	}
	
	@Test
	public void productErrorValidation() throws IOException , InterruptedException {
	
		
		
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("saurabh@yopmail.com", "Dots@123");
		List <WebElement>products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	
		
		
	}


}
