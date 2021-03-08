package com.appium.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
	public static final String EXTENTREPORTPATH = System.getProperty("user.dir")+"/ExtentReports/index.html";
	public static final String CHROMEEXECUTABLEPATH = System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";
	public static final String APKFILEPATH = System.getProperty("user.dir")+"/src/test/resources/apkfiles/ApiDemos-debug.apk";
	public static final String UIAUTOMATOR ="uiautomator2";


}
