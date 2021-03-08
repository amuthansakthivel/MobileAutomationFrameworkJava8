package com.appium.locators;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.By;

public final class LocatorFactory {
	
	private LocatorFactory() {
		
	}
	private static Map<LocatorType, Function<String, By>> locatormap = new EnumMap<>(LocatorType.class);
	
	private static final Function<String, By> XPATH = By::xpath;
	private static final Function<String, By> CSS = By::cssSelector;
	private static final Function<String, By> ID = By::id;
	private static final Function<String, By> NAME = By::name;
	private static final Function<String, By> CLASSNAME = By::className;
	
	static {
		locatormap.put(LocatorType.XPATH, XPATH);
		locatormap.put(LocatorType.CSS, CSS);
		locatormap.put(LocatorType.NAME, NAME);
		locatormap.put(LocatorType.ID, ID);
		locatormap.put(LocatorType.CLASSNAME, CLASSNAME);
	}
	
	public static By get(LocatorType value , String value1) {
		return locatormap.get(value).apply(value1);
	}
}
