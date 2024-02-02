package SaurabhSeleniumPackage.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SaurabhSeleniumPackage.PageObjectModel.CartPage;
import SaurabhSeleniumPackage.PageObjectModel.CheckoutPage;
import SaurabhSeleniumPackage.PageObjectModel.ConfirmationPage;
import SaurabhSeleniumPackage.PageObjectModel.OrderPage;
import SaurabhSeleniumPackage.PageObjectModel.ProductCatalogue;
import SaurabhSeleniumPackage.TestComponents.BaseTest;

public class Submitform extends BaseTest{
	String productName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void SubmitsForm(HashMap<String,String>input) throws IOException , InterruptedException {
	
		
		
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List <WebElement>products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCart();
		Boolean match = cartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutpage =cartPage.goToCheckout();
		checkoutpage.selectCountry("india");
		ConfirmationPage confirmationPage =checkoutpage.submitButton();
		String confirmMessage = confirmationPage.verifyConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		//Above we have submitted the order
	}

	
	// Now here we will validate if our placed order has been displayed in the order section page or not 
	
	
	@Test(dependsOnMethods= {"SubmitsForm"})
	public void orderHistory() {
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("pratishtha@mailinator.com", "Welcome@123");
		
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
		
	}
	
	//@DataProvider
//	public Object[][] getData() {
//		
//		return new Object [][] { {"saurabh@yopmail.com","Dots@123","ADIDAS ORIGINAL"},{"pratishtha@mailinator.com","Welcome@123","ZARA COAT 3"} };
//	}
//	We can use above method as well but as per the standard we are using HashMap method shown as below
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
	
	HashMap<String, String> map = new HashMap <String, String>();
	map.put("email", "saurabh@yopmail.com");
	map.put("password", "Dots@123");
	map.put("product", "ADIDAS ORIGINAL");
	
	HashMap<String, String> map1 = new HashMap <String, String>();
	map1.put("email", "pratishtha@mailinator.com");
	map1.put("password", "Welcome@123");
	map1.put("product", "ZARA COAT 3");
	
	return new Object [][] {{map},{map1}};
		
		// Above method can also use by providing HashMap manually 
		
		//Here we will use external json file to fetch the data instead of writing HashMap manually, it will automatically come when we use json file
	
//		List <HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//SaurabhSeleniumPackage//data//PurchaseOrder.json");
//		
//		
	// return new Object [][] {{data.get(0)},{data.get(1)}};
	
	}
	
	
}
