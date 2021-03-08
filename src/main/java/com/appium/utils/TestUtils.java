package com.appium.utils;

import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.appium.driver.DriverManager;

public final class TestUtils {
	
	private TestUtils() {
		
	}
	
	public static  String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
	public static String decrpt(String encryptedstring) {
		return new String(Base64.getDecoder().decode(encryptedstring));
		
	}

}
