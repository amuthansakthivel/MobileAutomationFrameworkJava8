package com.appium.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.appium.reports.ExtentLogger;
import com.appium.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.getInstance();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.terminateInstance();
		try {
			Desktop.getDesktop().browse(new File(System.getProperty("user.dir")+"/Extentreports/index.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTestNode(result.getName());
		ExtentLogger.pass(result.getName() + "is started successfully");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName() + "is passed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		result.getThrowable().getMessage();
		ExtentLogger.fail(result.getName() + "is failed ",true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getName() + "is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

}
