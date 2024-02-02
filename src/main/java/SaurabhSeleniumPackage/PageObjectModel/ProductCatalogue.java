package SaurabhSeleniumPackage.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponentsreusable.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;
		
		
		public ProductCatalogue(WebDriver driver){
			
			super(driver);
			
		this.driver=driver;
		PageFactory.initElements(driver, this);
			
			
		}
		
		
		@FindBy(className="col-lg-4")
		List <WebElement> products;
		
		@FindBy(css=".ng-animating")
		WebElement spinner;
		By proudctBy = By.className("col-lg-4");
		By addToCart =By.cssSelector("button[class='btn w-10 rounded']");
		By toastMessage = By.id("toast-container");
		
		
		public List<WebElement>  getProductList() {
			
			waitForElementToAppear(proudctBy);
			return products;
			
		}
		
		public WebElement getProductByName(String productName) {
			
			
			WebElement prod =products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			
			return prod;
			
		}
		
		public void addProductToCart(String productName) {
			
			WebElement prod= getProductByName(productName);
			prod.findElement(addToCart).click();
			waitForElementToAppear(toastMessage);
			waitForElementToDisappear(spinner);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

}
