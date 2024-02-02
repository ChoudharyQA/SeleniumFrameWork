package SaurabhSeleniumPackage.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import SaurabhSeleniumPackage.PageObjectModel.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public  LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src/main//java//SaurabhSeleniumPackage//globalresources//GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		
		
		if(browserName.contains("chrome")) {
			
			ChromeOptions options = new ChromeOptions();  // For running browser in headless mode
			if(browserName.contains("headless")) { // Giving headless instructions
				
				options.addArguments("headless");
			}
				
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900)); //For headless mode, we want to run browser on  full screen in background
			
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
		
	}
	
//	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
//		
//		//Reading json to String 
//		
//	String jsonContent = FileUtils.readFileToString(new File (filePath), StandardCharsets.UTF_8);
//		
//	// Now converting String to HashMap jackon databind
//	
//	ObjectMapper mapper = new ObjectMapper();
//	
//	List <HashMap<String, String>> data =mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String >>>(){
//		
//	});
//	
//	return data;
//	
//	
//	}
	
	public String getScreenShot(String testCasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//" + testCasename +".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//" + testCasename +".png";	
		
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		
		 WebDriver driver = initializeDriver();
		 landingPage =new LandingPage(driver);
			landingPage.goTo();
		return landingPage;
		
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void terminateBrowser() {
		
		driver.close();
	}
	
}
