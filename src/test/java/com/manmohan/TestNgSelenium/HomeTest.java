package com.manmohan.TestNgSelenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

public class HomeTest extends BaseTest {
//private WebDriver driver;
//public static ExtentTest extenttest;
	
	@BeforeTest
	public void beforeMethod(){
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriverwin.exe");
		//driver= new ChromeDriver();
		
		
	}
	
	@Test
	public void test1() throws IOException{
		driver.get("http://www.gmail.com");
		Util.PassTestStep(driver, extenttest, "gmail open sucessfully");
		//LoginPOM.validatetitle(driver);
		//driver.get("http://www.yahoo.com");
		//Util.PassTestStep(driver, extenttest, "yahoo opened sucessfully");
		//Util.getscreenshot(driver);
		
	}
	
	@Test
	public void test44() throws IOException{
		driver.get("http://www.flipkart.com");
		Util.PassTestStep(driver, extenttest, "pass");
		//LoginPOM.validatetitleYahoo(driver);
		//Util.PassTestStep(driver, extenttest, "pass");
		//Util.getscreenshot(driver);
		
	}	
	
	@Test
	public void test55() throws IOException{
		driver.get("http://www.gmail.com");
		Util.PassTestStep(driver, extenttest, "gmail open sucessfully");
		//LoginPOM.validatetitle(driver);
		//driver.get("http://www.yahoo.com");
		//Util.PassTestStep(driver, extenttest, "yahoo opened sucessfully");
		//Util.getscreenshot(driver);
		
	}
	
	@Test
	public void test2() throws IOException{
		driver.get("http://www.flipkart.com");
		Util.PassTestStep(driver, extenttest, "pass");
		//LoginPOM.validatetitleYahoo(driver);
		//Util.PassTestStep(driver, extenttest, "pass");
		//Util.getscreenshot(driver);
		
	}	
	@AfterTest
	public void aftermethod(){
		//driver.close();
		
		//driver.quit();
	}


}
