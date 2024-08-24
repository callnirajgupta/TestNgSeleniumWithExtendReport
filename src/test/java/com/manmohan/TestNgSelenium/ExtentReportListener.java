package com.manmohan.TestNgSelenium;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    private ExtentReports extentReports;
    private ExtentTest extentTest;


    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports
        String reportPath= (String) context.getAttribute("reportPath");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter (reportPath+"extent-report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in the report
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log success
        extentTest.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log failure
        extentTest.fail("Test failed");
        extentTest.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log skipped
        extentTest.skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush the report
        extentReports.flush();
    }
}