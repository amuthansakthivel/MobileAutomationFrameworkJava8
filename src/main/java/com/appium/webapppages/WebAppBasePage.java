package com.appium.webapppages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import com.appium.driver.DriverManager;
import com.appium.pages.base.BasePage;

import io.appium.java_client.MobileElement;

public class WebAppBasePage extends BasePage{
	
	public  WebAppBasePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@Override
	public void scrollToSpecificElement(By by) {
		((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView;", DriverManager.getDriver().findElement(by));
	}

	@Override
	public void dragAndDrop(MobileElement source, MobileElement target) {
		//Action class code -->Add it here
	}

}
