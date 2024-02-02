package SaurabhSeleniumPackage.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SaurabhSeleniumPackage.PageObjectModel.CartPage;
import SaurabhSeleniumPackage.PageObjectModel.CheckoutPage;
import SaurabhSeleniumPackage.PageObjectModel.ConfirmationPage;
import SaurabhSeleniumPackage.PageObjectModel.LandingPage;
import SaurabhSeleniumPackage.PageObjectModel.ProductCatalogue;
import SaurabhSeleniumPackage.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest{
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		
		
		landingPage = launchApplication();
	}

	@Given ("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username,String password) {
		productCatalogue = landingPage.loginApplication(username,password);
		
	}
	
	@When ("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productName) throws InterruptedException{
		List <WebElement>products= productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		
	}
	
	 @When ("^Checkout (.+) and submit the order$")
	 public void Checkout_and_submit_the_order(String productName) {
		 
		 CartPage cartPage = productCatalogue.goToCart();
			Boolean match = cartPage.verifyProductDisplay(productName);
			Assert.assertTrue(match);
			CheckoutPage checkoutpage =cartPage.goToCheckout();
			checkoutpage.selectCountry("india");
			 confirmationPage =checkoutpage.submitButton();
		 
	 }
	
	 @Then ("{string} message is displayed on ConfirmationPage")
	 public void Conformation_message_displayed(String string) {
		 
		 String confirmMessage = confirmationPage.verifyConfirmationMessage();
			Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
			driver.close();
	 }
	
	 @Then ("{string} message is displayed on loginpage")
	 public void Conformation_message_displayed_on_loginpage(String string) throws   InterruptedException  {
		 
		 Assert.assertEquals(string,landingPage.getErrorMessage());
		 driver.close();
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
