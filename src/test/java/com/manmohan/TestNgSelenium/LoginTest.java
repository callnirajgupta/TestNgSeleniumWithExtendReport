package com.manmohan.TestNgSelenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	
	@BeforeTest
	public void beforeMethod(){
		
		
		
	}
	
	@Test
	public void test4() throws IOException{
		driver.get("http://www.amazon.com");
		//LoginPOM.validatetitle(driver);
		Util.getscreenshot(driver);
		
	}
	
	@Test
	public void test3() throws IOException{
		driver.get("http://www.yahoo.com");
		//LoginPOM.validatetitleYahoo(driver);
		//Util.getscreenshot(driver);
	}
	
	@AfterTest
	public void aftermethod(){
		//driver.close();
		//driver.quit();
	}

}
