package org.Weva.baseclass;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;


public class BaseTest {
	
	protected static WebDriver driver;

	public static Properties property;

	public BaseTest() {
		/*
		 * 
		 * // logger = Logger.getLogger(this.getClass());
		 * 
		 * try { property = new Properties(); FileInputStream file = new
		 * FileInputStream(Constants.TestReportsPath);
		 * 
		 * property.load(file);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */}

	public static WebDriver instance() {

		return driver;

	}

	@BeforeTest
	public void SetUpLoggers() {
		// CommonUtils.SetLog4j();

	}

}
