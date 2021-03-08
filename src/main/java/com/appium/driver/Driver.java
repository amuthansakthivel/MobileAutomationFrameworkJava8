package com.appium.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Driver {

	public static AppiumDriver<MobileElement> driver; 


	private Driver(String platform,String mode, String udid, String port,String url) throws MalformedURLException {

		DriverManager.setDriver(DriverFactory.getDriver(platform,mode, udid,port, url));
		DriverManager.setMode(mode);
		if(platform.equalsIgnoreCase("android")) {
			DriverManager.setIsAndroid(true);
		}
		else {
			DriverManager.setIsAndroid(false);
		}
		
	}


	public static void getInstance(String platform,String mode, String udid, String port,String url) throws MalformedURLException {

		if(Objects.isNull(DriverManager.getDriver()))
			new Driver(platform,mode, udid,port, url);
	}

	public static void terminateInstance() {

		if(Objects.nonNull(DriverManager.getDriver()))
			DriverManager.unload();
	}

}
