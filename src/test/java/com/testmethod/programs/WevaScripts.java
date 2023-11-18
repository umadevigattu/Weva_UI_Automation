package com.testmethod.programs;

import org.Weva.constants.Constants;

import org.Weva.WevaReusables.WevaUtils;
import org.Weva.baseclass.BaseTest;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Weva.common.utilities.SeleniumUtilities;
import com.Weva.common.utilities.IDriverFactory.BrowserType;

public class WevaScripts extends BaseTest {
	SeleniumUtilities seleniumUtilities;
	WevaUtils wevaUtils;

	static String username = "";
	static String password = "";

	public WevaScripts() {
		wevaUtils = new WevaUtils();
	}
	
	@BeforeTest
	public void browserinvoke()
	{
		seleniumUtilities = new SeleniumUtilities(BrowserType.chrome, Constants.Weva_Url, 30);
		
	}
	
	@Test
	public void LoginTest_single() throws Exception {
		wevaUtils.WevaLogin(seleniumUtilities);
	}
	

	
	
	@AfterTest
	public void browserquit()
	{
		seleniumUtilities.CloseWindow();
	}

}
