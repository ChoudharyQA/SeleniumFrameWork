package SaurabhSeleniumPackage.globalresources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
public static ExtentReports getReportObject() {
		
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Saurabh Automation Report");
		reporter.config().setDocumentTitle("Extent Reports");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Saurabh Choudhary");
		return extent;
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
