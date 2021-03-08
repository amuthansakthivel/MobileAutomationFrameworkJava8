package com.appium.nativeapppages;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.driver.DriverManager;
import com.appium.locators.LocatorFactory;
import com.appium.locators.LocatorType;
import com.appium.pages.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class NativeAppBasePage extends BasePage{

	public NativeAppBasePage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	}

	TouchAction ta;

	@Override
	protected void scrollToSpecificElement(By by) {
		while(DriverManager.getDriver().findElements(by).isEmpty())
		{
			Dimension dimensions = DriverManager.getDriver().manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			int center = (int) (dimensions.width*0.5);
			ta=new TouchAction<>(DriverManager.getDriver());
			ta.press(PointOption.point(center,scrollStart))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
				.moveTo(PointOption.point(center,scrollEnd)).release().perform();
		}

		if(!DriverManager.getDriver().findElements(by).isEmpty())
		{
			click(by);	
		}
	}

	@Override
	protected void dragAndDrop(MobileElement source, MobileElement target) {
		ta=new AndroidTouchAction(DriverManager.getDriver());
		ta.longPress(longPressOptions().withElement(element(source))).moveTo(element(target)).release().perform();

	}

	protected void dragAndDrop(LocatorType type, String source, String target) {
		dragAndDrop(DriverManager.getDriver().findElement( LocatorFactory.get(type, source)),DriverManager.getDriver().findElement(LocatorFactory.get(type, target)));
	}
	
	protected void dragAndDropForIOS(LocatorType type, String source, String target) {
		//implementation for ios
	}

	protected void dragAndDrop(LocatorType type, String sourceA, String targetA, String sourceI, String targetI) {
		if(DriverManager.isAndroid()) {
			dragAndDrop(type,sourceA,targetA);
		}
		else {
			dragAndDropForIOS(type,sourceI,targetI);
		}
	}


	protected void swipe(WebElement source,WebElement target) {
		ta=new TouchAction<>(DriverManager.getDriver());
		ta.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(3)))
		.moveTo(element(target)).release().perform();
	}

	protected void tapByCoordinates (int x,  int y) {
		new TouchAction<>(DriverManager.getDriver())
		.tap(point(x,y))
		.waitAction(waitOptions(Duration.ofMillis(250))).perform();
	}



}
