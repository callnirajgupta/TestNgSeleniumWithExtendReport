package com.manmohan.TestNgSelenium;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
		Assert.assertFalse(true);

	}
	
	@AfterTest
	public void aftermethod(){
		//driver.close();
		//driver.quit();
	}

}
