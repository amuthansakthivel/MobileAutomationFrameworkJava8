package com.appium.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public final class DriverManager {
	
	private DriverManager() {
		
	}
	//Sonarqube -->Static analysis tool which will help you to write better java code
	
	private static  ThreadLocal<AppiumDriver<MobileElement>>  dr = new ThreadLocal<>();
	private static ThreadLocal<String> runmode= new ThreadLocal<>();
	private static ThreadLocal<Boolean> isAndroid= new ThreadLocal<>();
	
	//2 threads --> 1 thread update mode to browserstack and second thread updated to local
	

	public static boolean isAndroid() {
		return isAndroid.get();
	}
	
	public static void setIsAndroid(boolean value) {
		isAndroid.set(value);
	}
	
	public static String getMode() {
		return runmode.get();
	}

	public static void setMode(String mode) {
		runmode.set(mode);
	}

	public static AppiumDriver<MobileElement> getDriver() {
		return dr.get();
	}

	public static void setDriver(AppiumDriver<MobileElement> driver) {
		dr.set(driver);
	}

	public static void unload() {
		
		if(getMode().equalsIgnoreCase("browserstack")) {
			DriverManager.getDriver().quit();
		}
		dr.remove();
		runmode.remove();
		isAndroid.remove();
	}
	
	
	

}
