package SaurabhSeleniumPackage.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponentsreusable.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;
	
	@FindBy(css="div[class='cart'] h3")
	List <WebElement> cartProducts;
	
	@FindBy(css="ul li button[class='btn btn-primary']:nth-last-of-type(1)")
	WebElement checkOutEle;
	
	

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public Boolean verifyProductDisplay(String productName) {
		
		Boolean match =cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		
		checkOutEle.click();
		
		 return new CheckoutPage(driver);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
