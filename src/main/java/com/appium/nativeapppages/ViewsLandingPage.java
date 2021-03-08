package com.appium.nativeapppages;

import com.appium.locators.LocatorType;
import com.appium.pages.base.BasePage;


public class ViewsLandingPage extends NativeAppBasePage{
	
	
	private static final String OBJECT = "//android.widget.TextView[@text='%replaceable%']";
	
	
	public ViewsLandingPage clickAnItemInThePage(String value) {
		String newstring = OBJECT.replace("%replaceable%", value);
		click(LocatorType.XPATH, newstring);
		return PageInstanceFactory.get(value);
	}

	/*
	 * 1 ->Send a string --> new Instance of page based on the input
	 */
	/*
	 * At run time I get a input. 
	 * Drag and drop --> return new DragAndDropPage
	 * Animation --> return new AnimationPage
	 * 
	 */
}
