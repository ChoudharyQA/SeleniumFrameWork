package SaurabhSeleniumPackage.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponentsreusable.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	WebDriver driver;
	
	@FindBy(css="tr td:nth-child(3)")
	List <WebElement> productNames;
	
	@FindBy(css="ul li button[class='btn btn-primary']:nth-last-of-type(1)")
	WebElement checkOutEle;
	
	

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	public Boolean verifyOrderDisplay(String productName) {
		
		Boolean match =productNames.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	

		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

