package com.appium.nativeapppages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;

public final class HomePage extends NativeAppBasePage {
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
	@iOSXCUITBy(xpath="//*[text()='somevalue']")
	private MobileElement views;
	
	
	public ViewsLandingPage clickViews() {
		click(views);
		
		return new ViewsLandingPage();
	}

}
