package com.appium.tests;

import java.net.MalformedURLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.driver.Driver;
import com.appium.exception.FrameworkException;
import com.appium.nativeapppages.DragAndDropPage;
import com.appium.nativeapppages.HomePage;
import com.appium.nativeapppages.ViewsLandingPage;

public class SwipeTests extends BaseTest{


	private HomePage hpage;
	private ViewsLandingPage viewsLandingPage;

	@Test(dataProvider="getData")
	public void dragAndDropTest(String platform,String mode, String udid, String port  ,String url) throws FrameworkException, MalformedURLException  {
		Driver.getInstance(platform,mode,udid, port ,url);
		hpage = new HomePage();
		viewsLandingPage = hpage.clickViews().clickAnItemInThePage("Drag and Drop");
		if(viewsLandingPage instanceof DragAndDropPage) {
			((DragAndDropPage)viewsLandingPage).performDragAndDrop();
		}
		else {
			throw new FrameworkException("There is problem with page instance creation");
		}
	}

	@DataProvider(parallel=true)
	public Object[][] getData() {
		return new Object[][] {
			{"android", 			"local"		, "58H3Y18831003940", 	"8200",	"http://127.0.0.1:4723/wd/hub"},
		//	{"ios"					,"local"		, "58H3Y1883100323", 	"8201",	"http://127.0.0.1:4723/wd/hub"},
			{"android"			,"browserstack",   "Google Pixel 3",	"",	"http://hub.browserstack.com/wd/hub"}
			
		};
	}

}
