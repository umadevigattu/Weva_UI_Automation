package com.Weva.common.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.Weva.baseclass.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Weva.common.utilities.IDriverFactory.BrowserType;
import com.Weva.common.utilities.IDriverFactory.LocatorType;

public class SeleniumUtilities extends BaseTest {

	protected IDriverFactory driverFactory = new DriverFactory();

	public SeleniumUtilities(BrowserType browser, String URL, int wait) throws Exception {
		Thread.sleep(5000);
		driver = driverFactory.CreateWebDriver(browser);
		driver.get(URL);
		String title = driver.getTitle();
		driver.manage().window().maximize();
		System.out.println(title);
		
	}

	public void Click(String element, LocatorType locatorType) {
		FindElement(element, locatorType).click();
	}

	public void ClickElement(String element, LocatorType locatorType, String value) {
		FindElement(element, locatorType).click();
		FindElement(element, locatorType).sendKeys(value);
	}

	public WebElement FindElement(String element, LocatorType elementType) {
		WebElement findElement = null;
		try {
			if (elementType == LocatorType.id) {
				findElement = driver.findElement(By.id(element));
			} else if (elementType == LocatorType.name) {
				findElement = driver.findElement(By.name(element));
			} else if (elementType == LocatorType.xpath) {
				findElement = driver.findElement(By.xpath(element));
			} else if (elementType == LocatorType.linktext) {
				findElement = driver.findElement(By.linkText(element));
			} else if (elementType == LocatorType.classname) {
				findElement = driver.findElement(By.className(element));
			} else if (elementType == LocatorType.tagname) {
				findElement = driver.findElement(By.tagName(element));
			} else if (elementType == LocatorType.cssselector) {
				findElement = driver.findElement(By.cssSelector(element));
			} else if (elementType == LocatorType.partiallinktext) {
				findElement = driver.findElement(By.partialLinkText(element));
			}
			return findElement;

		} catch (Exception e) {
			System.out.println(e);
			return null;

		}

	}
	
	public void EnterText(String element, LocatorType locatorType, String value) {
		ClearText(element, locatorType);
		FindElement(element, locatorType).sendKeys(value);
		
	}
	public void ClearText(String element, LocatorType locatorType) {
		FindElement(element, locatorType).clear();
	}
	public String GetText(String element, LocatorType locatorType) {
		return FindElement(element, locatorType).getText();
	}
	public void Sleep() throws InterruptedException {
		Thread.sleep(4000);
	}
	public void Refresh(){
		driver.navigate().refresh();
	}
	
	public void CloseWindow() {
		driver.quit();
	}
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException 
	{
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ScreenShots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	public void Waitforelementuntilloaded(LocatorType locatorType, String element, Duration timesec) {
		/*
		 * 
		 * 
		 * try { WebDriverWait wait=new WebDriverWait(driver,timesec);
		 * if(locatorType.equals(LocatorType.id)) {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element))); }
		 * else if(locatorType.equals(LocatorType.name)) {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
		 * } else if(locatorType.equals(LocatorType.classname)) {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element
		 * ))); } else if(locatorType.equals(LocatorType.cssselector)) {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * element))); } else if(locatorType.equals(LocatorType.linktext)) {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)
		 * )); } else if(locatorType.equals(LocatorType.xpath)) {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		 * } else if(locatorType.equals(LocatorType.partiallinktext)) {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(
		 * element))); } else if(locatorType.equals(LocatorType.tagname)) {
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(element))
		 * ); }
		 * 
		 * } catch(Exception e) { System.out.println(e); }
		 */}



	//To Select Radio Button.
		public void selectRadioButton(List<WebElement> element, String value)
		{
			for(WebElement elements : element)
			{
				if(elements.getText().equalsIgnoreCase(value))
				{
					elements.click();
					break;
				}
			}
		}
		
	

		//To Handle Multiple Windows or Switch Between Multiple Windows.
		public void switchWindow(WebDriver driver, String firstWindow, String secondWindow) 
		{
			Set<String> windowHandles = driver.getWindowHandles();
			for(String windows : windowHandles) 
			{
				if(!windows.equals(firstWindow) && !windows.equals(secondWindow)) 
				{
					driver.switchTo().window(windows);
				}
			}
		}

		//Element is displayed or not
		public Boolean IsElementDisplayed(String element, LocatorType locatorType)
        {
            try
            {
                WebElement ele = this.FindElement(element, locatorType);
                if (ele.isDisplayed())
                {
                    return true;

                }
                else
                {
                    return false;
                }
            }
            catch (Exception e)
            {
                return false;
            }
        }

		
		//Get text of a web element if element is displayed
		public String GetTextIfElementDisplayed(String element, LocatorType locatorType) {
			 if (IsElementDisplayed(element, locatorType))
	            {

	               String text = GetText(element, locatorType);
	               System.out.println(text);
	            }
			return null;
			 
		}
		
		//Click on the element if element is displayed
		 public void ClickElementIfDisplayed(String element, LocatorType locatorType)
	        {
	            if (IsElementDisplayed(element, locatorType))
	            {

	                Click(element, locatorType);
	            }

	        }
		
		//To Check Element is Displayed or No.
		public static void isElementDisplayed(WebElement element) 
		{
			boolean elementDisplayed = element.isDisplayed();
			if(elementDisplayed) 
			{
				System.out.println("Element is Displayed");
			} 
			else 
			{
				System.out.println("Element is not Displayed");
			}
		}

		//To Check Element is Enabled or No.
		public static void isElementEnabled(WebElement element) 
		{
			boolean elementEnabled = element.isEnabled();
			if(elementEnabled) 
			{
				System.out.println("Element is Enabled");
			} 
			else 
			{
				System.out.println("Element is not Enabled");
			}
		}
		public List<WebElement> FindElements(String element, LocatorType elementType){
			List<WebElement> findElements = null;
			try {
				if(elementType == LocatorType.id) {
					findElements = driver.findElements(By.id(element));
				}
				else if(elementType == LocatorType.name){
					findElements = driver.findElements(By.name(element));
				}
				else if(elementType == LocatorType.xpath) {
					findElements = driver.findElements(By.xpath(element));
				}
				else if(elementType == LocatorType.cssselector) {
					findElements = driver.findElements(By.cssSelector(element));
				}
				else if(elementType == LocatorType.tagname) {
					findElements = driver.findElements(By.tagName(element));
				}
				else if(elementType == LocatorType.classname) {
					findElements = driver.findElements(By.className(element));
				}
				else if(elementType == LocatorType.linktext) {
					findElements = driver.findElements(By.linkText(element));
				}
				else if(elementType == LocatorType.partiallinktext) {
					findElements = driver.findElements(By.partialLinkText(element));
				}
				return findElements;
			}
			catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}

	
}
