package com.appium.nativeapppages;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public final class PageInstanceFactory {
	
	private PageInstanceFactory() {
		
	}
	
	private static final Supplier<? extends ViewsLandingPage> DRAPANDDROP = DragAndDropPage::new;
	private static final Supplier<? extends ViewsLandingPage> ANIMATION = AnimationPage::new;
	
	private static Map<String, Supplier<? extends ViewsLandingPage>> map = new HashMap<>();
	
	static {
		map.put("Drag and Drop", DRAPANDDROP);
		map.put("Animation", ANIMATION);
		
	}
	
	public static ViewsLandingPage get(String value) {
		return map.get(value).get();
	}

}
