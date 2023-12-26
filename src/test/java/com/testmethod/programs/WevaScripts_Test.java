package com.testmethod.programs;

import java.io.IOException;

import org.Weva.WevaReusables.WevaUtils;
import org.Weva.baseclass.BaseTest;
import org.Weva.objectrepository.WevaLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Weva.common.utilities.SeleniumUtilities;
import com.Weva.common.utilities.IDriverFactory.BrowserType;
import com.Weva.common.utilities.IDriverFactory.LocatorType;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.Weva.common.utilities.ExtentReportListeners.class)

public class WevaScripts_Test {
	WevaUtils wevaUtils;
	SeleniumUtilities seleniumUtilities;
	WebDriver driver;

	@BeforeMethod
	public void browserinvoke() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(6000);

		driver.get("https://3.105.110.219/login");
		System.out.println("driver invoked");

	}

	@Test
	public void LoginTest_single() throws Exception {

		/*
		 * WebDriver driver; WebDriverManager.chromedriver().setup(); driver = new
		 * ChromeDriver(); driver.manage().window().maximize(); Thread.sleep(6000);
		 * 
		 * driver.get(properties.getProperty("Weva_Url"));
		 */
		driver.findElement(By.name("email")).sendKeys("sirishapatient@yopmail.com");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		driver.close();

	}

	@Test
	public void LoginTest_single_two() throws Exception {
		/*
		 * WebDriver driver; WebDriverManager.chromedriver().setup(); driver = new
		 * ChromeDriver(); driver.manage().window().maximize();
		 * driver.get(properties.getProperty("Weva_Url")); Thread.sleep(6000);
		 */

		driver.findElement(By.name("email")).sendKeys("sirishapatient@yopmail.com");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("Test@1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		driver.close();
	}

	@AfterMethod
	public void browserquit() throws IOException {
		// driver.close();
	}

}
