package com.appium.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.constants.FrameworkConstants;
import com.appium.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public final class DriverFactory {
	
	private DriverFactory() {
		
	}

	public static AppiumDriver<MobileElement> driver; 
	
	public static AppiumDriver<MobileElement> getDriver(String platform,String mode, String udid,String port, String url) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		if(platform.equalsIgnoreCase("android")) {
		if(mode.equalsIgnoreCase("local")) {
			cap.setCapability(MobileCapabilityType.UDID, "58H3Y18831003940");
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, FrameworkConstants.UIAUTOMATOR);
			cap.setCapability(MobileCapabilityType.APP,FrameworkConstants.APKFILEPATH);
			cap.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, Integer.parseInt(port));  //8200-8300
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "myHonorPlayDevice");
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.0");
			cap.setCapability("skipDeviceInitialization", true); //Appium Settings app installation in device
			cap.setCapability("skipServerInstallation", true); //uiautomator server installation in device
			
		}
		else if(mode.equalsIgnoreCase("browserstack")) {
			cap.setCapability("browserstack.user", "amuthansakthivel1");
			cap.setCapability("browserstack.key", TestUtils.decrpt("eEVUMXo1dGNoRHdEWjRBbndlcGE="));
			cap.setCapability("app", "bs://45e212b5594b54ee7d6ae72fa1701120f51114c1");
			cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
			cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
			cap.setCapability("device", udid );
			cap.setCapability("os_version", "9.0");
			cap.setCapability("project", "First Java Project");
			cap.setCapability("build", "Java Android");
			cap.setCapability("name", "first_test");
		}
			driver= new AndroidDriver<>(new URL(url), cap); 
		}else if(platform.equalsIgnoreCase("ios")) {
			if(mode.equalsIgnoreCase("local")) {
				/*cap.setCapability(MobileCapabilityType.UDID, "58H3Y18831003940");
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, FrameworkConstants.UIAUTOMATOR);
				cap.setCapability(MobileCapabilityType.APP,FrameworkConstants.APKFILEPATH);
				cap.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, Integer.parseInt(port));  //8200-8300
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, "myHonorPlayDevice");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.0");
				cap.setCapability("skipDeviceInitialization", true); //Appium Settings app installation in device
				cap.setCapability("skipServerInstallation", true); //uiautomator server installation in device
*/				
			}
			else if(mode.equalsIgnoreCase("browserstack")) {
				/*cap.setCapability("browserstack.user", "amuthansakthivel1");
				cap.setCapability("browserstack.key", TestUtils.decrpt("eEVUMXo1dGNoRHdEWjRBbndlcGE="));
				cap.setCapability("app", "bs://45e212b5594b54ee7d6ae72fa1701120f51114c1");
				cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
				cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
				cap.setCapability("device", udid );
				cap.setCapability("os_version", "9.0");
				cap.setCapability("project", "First Java Project");
				cap.setCapability("build", "Java Android");
				cap.setCapability("name", "first_test");*/
			}
				 driver= new IOSDriver<>(new URL(url), cap); 
		}
		return driver;
		
	}
	
}
