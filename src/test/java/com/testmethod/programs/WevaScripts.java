package com.testmethod.programs;

import java.io.IOException;

import org.Weva.WevaReusables.WevaUtils;
import org.Weva.baseclass.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Weva.common.utilities.SeleniumUtilities;
import com.Weva.common.utilities.IDriverFactory.BrowserType;

@Listeners(com.Weva.common.utilities.ExtentReportListeners.class)
public class WevaScripts extends BaseTest {
	SeleniumUtilities seleniumUtilities;
	WevaUtils wevaUtils;

	static String username = "";
	static String password = "";
	SoftAssert softassert = new SoftAssert();

	public WevaScripts() {
		wevaUtils = new WevaUtils();
	}

	@BeforeMethod
	public void browserinvoke() {

		seleniumUtilities = new SeleniumUtilities(BrowserType.chrome, properties.getProperty("Weva_Url"), 30);

	}

	@Test
	public void LoginTest_single() throws Exception {
		Thread.sleep(4000);
		wevaUtils.WevaLogin(seleniumUtilities);
		WebElement homepage = driver.findElement(By.xpath("//a[text()='Find a Doctor']"));
		if (homepage.isDisplayed() == true) {
			softassert.assertEquals(homepage.getText(), "Find a Doctor");
			SeleniumUtilities.getScreenshot(driver, "Login_Pass");
			System.out.println("execution  " + Thread.currentThread().getId());

		}

		softassert.assertAll();

	}

	@Test
	public void LoginTest_single_two() throws Exception {
	Thread.sleep(4000);
		wevaUtils.WevaLogin(seleniumUtilities);
		WebElement homepage = driver.findElement(By.xpath("//a[text()='Find a Doctor']"));
		if (homepage.isDisplayed() == true) {
			softassert.assertEquals(homepage.getText(), "Find a Doctor");
			System.out.println("home text is"+homepage.getText());
			SeleniumUtilities.getScreenshot(driver, "Login_Pass");
			System.out.println("execution completed on " + Thread.currentThread().getId());

		}

		softassert.assertAll();

	}

	@AfterMethod
	public void browserquit() throws IOException {
		SeleniumUtilities.getScreenshot(driver, "Login_Status");
		seleniumUtilities.CloseWindow();
	}

}
