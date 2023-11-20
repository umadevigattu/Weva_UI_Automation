package com.Weva.common.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.Weva.common.utilities.ExtentTestReports;
import org.Weva.baseclass.BaseTest;
import com.aventstack.extentreports.Status;


public class ExtentReportListeners extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		extentTest = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, result.getMethod().getMethodName());
		extentTest.log(Status.FAIL, result.getThrowable());
	}
	
	
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, result.getMethod().getMethodName());
	
	}

	public void onStart(ITestContext context) {
		extent = ExtentTestReports.extentReportSetup();
	}
	public void onFinish(ITestContext context) {
		extent.flush();
	}


}
