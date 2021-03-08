package com.appium.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.appium.driver.Driver;

public class TapTests extends BaseTest{
	
	/*
	 * 1. Just consider - it has to be robust and it should be easy for manual testers or other automation testers to use
	 * 2. Dont hardcode any values
	 * 3. keep everything in the right place
	 */
	
	//Thread safety
	
	@Test
	public void tapTestDemo() throws IOException {
		//driver.findElementsByClassName("android.widget.TextView").forEach(e->System.out.println(e.getText()));
	}

}
