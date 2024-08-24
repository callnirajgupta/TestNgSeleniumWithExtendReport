package com.manmohan.TestNgSelenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener {
    private String parameter;

    // Constructor to accept parameter
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started with parameter: " + parameter);
    }

    // Implement other methods of ITestListener
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed " + parameter);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed " + parameter);
    }
    @Override
    public void onTestSkipped(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {}
    @Override
    public void onFinish(ITestContext context) {}
}
