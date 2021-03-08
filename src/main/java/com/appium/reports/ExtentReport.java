package com.appium.reports;

import java.net.MalformedURLException;
import java.util.Objects;

import com.appium.constants.FrameworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public final class ExtentReport {

	private static ExtentReports extent;

	private ExtentReport() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.EXTENTREPORTPATH); //raised a bug -->5.0.5
		extent.attachReporter(spark);

		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Appium Training");
	}

	public static void getInstance()  {

		if(Objects.isNull(extent))
			new ExtentReport();

	}
	
	public static void createTestNode(String testname) {
		ExtentManager.setExtentTest(extent.createTest(testname));
	}

	public static void terminateInstance() {

		if(Objects.nonNull(extent)) {
			extent.flush();
			ExtentManager.unload();
		}
	}

}
