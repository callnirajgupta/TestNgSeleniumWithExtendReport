package com.manmohan.TestNgSelenium;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Util {
	
	public static String getscreenshot(WebDriver driver) throws IOException{
		
		Date date=new Date();
		long time=date.getTime();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String imagepath=System.getProperty("user.dir") + "//snap//"+time+".png";
		Files.copy(scrFile, new File(imagepath));
		return imagepath;
	}

	
	public static  void failTestStep(WebDriver driver,ExtentTest test,String failureMessage) throws IOException{
		String imagePath=getscreenshot(driver); 
		String snapPath=test.addScreenCapture(imagePath);
		test.log(LogStatus.FAIL, failureMessage,snapPath);
	}
	
	
	public static void PassTestStep(WebDriver driver,ExtentTest test,String passMessage) throws IOException{
		String imagePath=getscreenshot(driver); 
		String snapPath=test.addScreenCapture(imagePath);
		test.log(LogStatus.PASS, passMessage,snapPath);
	}
}
