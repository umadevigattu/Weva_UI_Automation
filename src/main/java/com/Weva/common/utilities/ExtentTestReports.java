package com.Weva.common.utilities;

import org.Weva.constants.Constants;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestReports 
{
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReportSetup()
	{
		sparkReporter = new ExtentSparkReporter(Constants.TestReportsPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host Name", "Weva");
		extent.setSystemInfo("Environment", System.getenv("USERNAME"));
		extent.setSystemInfo("User Name", "Sirisha");
		sparkReporter.config().setTimeStampFormat("MM/dd/yyyy");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Weva UI Automation");
		sparkReporter.config().setReportName("Execution Report");
		return extent;
	}
	
	
}
