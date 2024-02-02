package Abstractcomponentsreusable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SaurabhSeleniumPackage.PageObjectModel.CartPage;
import SaurabhSeleniumPackage.PageObjectModel.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="nav ul li:nth-child(4)")
	WebElement cartHeader;
	
	@FindBy(css="button[routerlink*=\"/dashboard/myorders\"]")
	WebElement orderHeader;
	
	
	
	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
		
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
		
	}
	
	public  OrderPage goToOrdersPage() {
		
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		
		
		
	}
	public void waitForElementToDisappear(WebElement element) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
	wait.until(ExpectedConditions.invisibilityOf(element));
		
		
	}
	
	public CartPage goToCart() {
		
		cartHeader.click();
		CartPage cartPage= new CartPage(driver);
		return cartPage;
	}
	
	
	
	
	
}




