package com.appium.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.driver.DriverManager;
import com.appium.locators.LocatorFactory;
import com.appium.locators.LocatorType;
import com.appium.reports.ExtentLogger;

import io.appium.java_client.MobileElement;

public abstract class BasePage {


	protected void click(MobileElement element) {
		explicitWait(element);
		element.click();
		ExtentLogger.pass(element + "is clicked successfully",true);
	}

	private void explicitWait(MobileElement element) {
		//new WebDriverWait(DriverManager.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element));

		new WebDriverWait(DriverManager.getDriver(), 10).until(d->element.isDisplayed());
	}

	protected void click(By by) {
		click(DriverManager.getDriver().findElement(by));
	}

	protected void click(LocatorType locatortype , String locatorvalue) {

		click(LocatorFactory.get(locatortype, locatorvalue));
	}

	protected void click(LocatorType locatortype , String androidvalue, String iosvalue) {
		if(DriverManager.isAndroid()) {
			click(LocatorFactory.get(locatortype, androidvalue));
		}
		else {
			click(LocatorFactory.get(locatortype, iosvalue));
		}

	}

	protected void sendKeys(MobileElement element, String value) {
		explicitWait(element);
		element.sendKeys(value);
	}

	protected abstract void scrollToSpecificElement(By by);
	protected abstract void dragAndDrop(MobileElement source, MobileElement target);

}
