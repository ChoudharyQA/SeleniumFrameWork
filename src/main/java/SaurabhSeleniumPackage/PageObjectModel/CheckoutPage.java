package SaurabhSeleniumPackage.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Abstractcomponentsreusable.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

	@FindBy(css="input[placeholder=\"Select Country\"]")
	private WebElement country;
	
	@FindBy(css="a[class='btnn action__submit ng-star-inserted']")
	private WebElement submitButton;
	
	@FindBy(css="div section:nth-child(2) button:nth-child(3)")
	private WebElement selectCountry;
	
	private By results= By.cssSelector("section[class='ta-results list-group ng-star-inserted']");
	

	public void selectCountry(String countryName) {
		
		
		Actions a= new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(results);
		selectCountry.click();
		
	}
	
	public ConfirmationPage submitButton() {
		submitButton.click();
		 return new ConfirmationPage(driver);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}



