package com.manmohan.TestNgSelenium;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	
	public static ExtentReports report;
	public static ExtentTest extenttest;
	public static String reportName;
	public WebDriver driver;
	
	/*BaseTest(WebDriver driver){
		this.driver=driver;
		
	}*/
	
	
	@BeforeSuite()
	public void initialSetup(){
		reportName = System.getProperty("user.dir")+"/target/test-report.html";
		report=new ExtentReports(reportName);
		
		File ScreenShotDir= new File(System.getProperty("user.dir")+"//snap//");
		for(File file:ScreenShotDir.listFiles()){
			file.delete();
		}
	}
	
	@BeforeMethod()
	@Parameters({"browser"})
	public void  beforemethod(Method method,String browser) throws MalformedURLException{
		extenttest=report.startTest(method.getName());
		 String browserType=null;
		 if(System.getProperty("Browser")==null){
			 System.out.println("inside testng browser type");
			 browserType= browser;
		 }else {
			 System.out.println("inside jvm  browser type");
			 browserType =System.getProperty("Browser");
		 }
	
		if(driver==null){
			
					if("firefox".equalsIgnoreCase(browserType)){
						FirefoxOptions options = new FirefoxOptions();
					if("yes".equalsIgnoreCase(System.getProperty("remote"))){
						driver= new RemoteWebDriver(new URL("http://192.168.0.8:4444/wd/hub"),options);
					}else{
						System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\geckodriver.exe");
						
						//options.setHeadless(true);
						driver= new FirefoxDriver(options);
						
					}
			  
			}else if("IE".equalsIgnoreCase(browserType)){
				
					System.out.println("i am inside IE");
					 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\IEDriverServer_32.exe");
					driver= new InternetExplorerDriver();
				
				}else if("Chrome".equalsIgnoreCase(browserType)){
					ChromeOptions options = new ChromeOptions();
		
					if("yes".equalsIgnoreCase(System.getProperty("remote"))){
						driver= new RemoteWebDriver(new URL("http://192.168.0.8:4444/wd/hub"),options);
				        
						}else{
							System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriverwin.exe");
							
							if("headless".equalsIgnoreCase(System.getProperty("headless"))){
					        options.addArguments("headless");
					        options.addArguments("window-size=1200x600");
							driver= new ChromeDriver(options);
						}else{
							driver= new ChromeDriver(options);
						}
						}
								
						
				}else if(System.getProperty("ExecuteOn").equalsIgnoreCase("saucelab")){
					 String USERNAME = "roboticautomation";
					   String ACCESS_KEY = "5a8cbd77-9240-46e2-bc4d-8db1a4190794";
					   String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
				
							  DesiredCapabilities caps = DesiredCapabilities.chrome();
					    caps.setCapability("platform", "Windows 10");
					    caps.setCapability("version", "65");
					 
					    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
				
				}
					
		}
					}
	
			
				

		
	
	
	@AfterMethod()
	public void logout(ITestResult testNgResult) throws IOException{
		if(testNgResult.getStatus()==ITestResult.SUCCESS ){
			extenttest.log(LogStatus.PASS, "test case passed");
			Util.PassTestStep(driver, extenttest, "Finished execution");
		}else if(testNgResult.getStatus()==ITestResult.FAILURE){
			extenttest.log(LogStatus.FAIL, "test case failed");
			Util.failTestStep(driver, extenttest, "failed screen shot");
		}
		//driver.close();
		driver.quit();
		driver=null;
		
	}
	
	@AfterSuite()
	public void close(){
		report.flush();
		
	}
	
	
	

}
