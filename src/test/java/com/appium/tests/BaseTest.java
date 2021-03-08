package com.appium.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.appium.driver.Driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseTest {
	
	
	/*
	 * This will be executed before each test method
	 */
	
	
	@AfterMethod
	public void tearDown() {
		Driver.terminateInstance();
	}
	
	
}
