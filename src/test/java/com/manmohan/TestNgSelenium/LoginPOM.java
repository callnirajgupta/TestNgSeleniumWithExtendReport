package com.manmohan.TestNgSelenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPOM {
	public static final String Title="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
	public static final String TitleYahoo="Yahoo India";
	
	public static void validatetitle(WebDriver d){
		String siteTitle=d.getTitle();
		Assert.assertEquals( Title,siteTitle,"the tile of the page is not matching");
		
	}
	public static void validatetitleYahoo(WebDriver driver){
		String siteTitle=driver.getTitle();
		Assert.assertEquals( TitleYahoo,siteTitle,"the tile of the page is not matching");
		
	}
}
