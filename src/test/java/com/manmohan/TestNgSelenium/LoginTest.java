package com.manmohan.TestNgSelenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	private WebDriver driver;
	
	@BeforeTest
	public void beforeMethod(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriverwin.exe");
		driver= new ChromeDriver();
		
		
	}
	
	@Test
	public void test1() throws IOException{
		driver.get("http://www.amazon.com");
		LoginPOM.validatetitle(driver);
		Util.getscreenshot(driver);
		
	}
	
	@Test
	public void test2() throws IOException{
		driver.get("http://www.yahoo.com");
		LoginPOM.validatetitleYahoo(driver);
		Util.getscreenshot(driver);
	}
	
	@AfterTest
	public void aftermethod(){
		driver.close();
		driver.quit();
	}

}
