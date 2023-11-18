package com.testmethod.programs;

import org.Weva.WevaReusables.WevaUtils;
import org.Weva.baseclass.BaseTest;

import org.testng.annotations.Test;

import com.Weva.common.utilities.SeleniumUtilities;

public class WevaLogin extends BaseTest {
	SeleniumUtilities seleniumUtilities;
	WevaUtils wevaUtils;

	static String username = "";
	static String password = "";

	public WevaLogin() {
		wevaUtils = new WevaUtils();
	}

	@Test
	public void LoginTest() throws Exception {

		wevaUtils.WevaLogin_muliple(seleniumUtilities);

	}

}
