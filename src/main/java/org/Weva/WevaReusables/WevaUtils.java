package org.Weva.WevaReusables;

import java.io.FileInputStream;

import org.Weva.baseclass.BaseTest;
import org.Weva.constants.Constants;
import org.Weva.objectrepository.WevaLoginPage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Weva.common.utilities.CommonUtils;
import com.Weva.common.utilities.IDriverFactory.BrowserType;
import com.Weva.common.utilities.IDriverFactory.LocatorType;
import com.Weva.common.utilities.SeleniumUtilities;

public class WevaUtils extends BaseTest {

	static String username = "";
	static String password = "";

	public void WevaLogin(SeleniumUtilities seleniumUtilities) throws Exception {
		extentTest.info("Enter valid username as " + properties.getProperty("username"));
		seleniumUtilities.EnterText(WevaLoginPage.getUsername(), LocatorType.xpath, properties.getProperty("username"));
		extentTest.info("Enter Valid Password as " + properties.getProperty("password"));
		seleniumUtilities.EnterText(WevaLoginPage.getPassword(), LocatorType.xpath, properties.getProperty("password"));
		extentTest.info("Click on Sign in button");
		seleniumUtilities.Click(WevaLoginPage.getSubmit(), LocatorType.xpath);

		Thread.sleep(5000);

	}

	public void WevaLogin_muliple(SeleniumUtilities seleniumUtilities) throws Exception {

		FileInputStream fis = new FileInputStream(Constants.LoginTestData);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		for (int rownum = 1; rownum <= sheet.getLastRowNum(); rownum++) {
			seleniumUtilities = new SeleniumUtilities(BrowserType.chrome, properties.getProperty("Weva_Url"), 30);
			CommonUtils.ExcelReader();

			Row row = sheet.getRow(rownum);
			username = row.getCell(0).getStringCellValue();
			System.out.println(username);
			password = row.getCell(1).getStringCellValue();
			System.out.println(password);
			seleniumUtilities.EnterText(WevaLoginPage.getUsername(), LocatorType.xpath, username);
			seleniumUtilities.EnterText(WevaLoginPage.getPassword(), LocatorType.xpath, password);
			seleniumUtilities.Click(WevaLoginPage.getSubmit(), LocatorType.xpath);
			Thread.sleep(5000);
			seleniumUtilities.CloseWindow();
		}
	}

	public void WevaLogout(SeleniumUtilities seleniumUtilities) throws Exception {

		Thread.sleep(5000);
	}

}
