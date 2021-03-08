package com.appium.nativeapppages;

import com.appium.locators.LocatorType;

public final class DragAndDropPage extends ViewsLandingPage{
	
	private static final String SOURCE_A = "io.appium.android.apis:id/drag_dot_1";
	private static final String TARGET_A = "io.appium.android.apis:id/drag_dot_2";
	private static final String SOURCE_I = "";
	private static final String TARGET_I = "";
	
	
	
	
	public void performDragAndDrop() {
		dragAndDrop(LocatorType.ID, SOURCE_A, TARGET_A, SOURCE_I,TARGET_I);
	}




	
}
