package com.appium.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {
		
	}
	
	private static final ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();
	
	public static ExtentTest getExtentTest() {
		return exTest.get();
	}
	
	public static void setExtentTest(ExtentTest test) {
		exTest.set(test);
	}
	
	public static void unload() {
		exTest.remove();
	}

}
