package com.vapsTechnosoft.IVRM.testBase;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vapsTechnosoft.IVRM.ColumnHeader.Column_Header;
import com.vapsTechnosoft.IVRM.customListner.WebEventListener;
import com.vapsTechnosoft.IVRM.excelReader.Excel_Reader;
import com.vapsTechnosoft.IVRM.sorting.Sort;

/**
 * 
 * @author Arvind
 *
 */
public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver driver;
	Excel_Reader excel;
	private Select select;
	private WebElement option;
	// public EventFiringWebDriver driver;
	public WebEventListener eventListener;
	public Properties OR = new Properties();
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
	Sort sort;

	public WebDriver getDriver() {
		return driver;
	}

	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/com/vapsTechnosoft/IVRM/report/test"
				+ formater.format(calendar.getTime()) + ".html", false);
	}

	public void loadData() throws IOException {
		File file = new File(
				System.getProperty("user.dir") + "/src/main/java/com/vapsTechnosoft/IVRM/config/config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);

	}

	public void setDriver(EventFiringWebDriver driver) {
		this.driver = driver;
	}

	public void init() throws IOException {
		loadData();
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		System.out.println(OR.getProperty("browser"));
		selectBrowser(OR.getProperty("browser"));
		getUrl(OR.getProperty("url"));
	}

	public void selectBrowser(String browser) {
		System.out.println(System.getProperty("os.name"));
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equals("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/chromedriver.exe");
				//

				// String downloadFilepath = "c:\\download";

				String downloadFilepath = System.getProperty("user.dir")
						+ "\\src\\main\\java\\com\\vapsTechnosoft\\IVRM\\downloadFile\\";

				// Setting new download directory path
				Map<String, Object> prefs = new HashMap<String, Object>();

				prefs.put("download.default_directory", downloadFilepath);
				prefs.put("download.prompt_for_download", false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);

				// Printing set download directory
				System.out.println(options.getExperimentalOption("prefs"));
				driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				// driver = new EventFiringWebDriver(dr);
				eventListener = new WebEventListener();
				// driver.register(eventListener);
				// setDriver(driver);
			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			if (browser.equals("chrome")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				// driver = new EventFiringWebDriver(dr);
				// eventListener = new WebEventListener();
				// driver.register(eventListener);
			} else if (browser.equals("firefox")) {
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.firefox.marionette",
						System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				// driver = new EventFiringWebDriver(dr);
				eventListener = new WebEventListener();
				// driver.register(eventListener);
				// setDriver(driver);
			}
		}
	}

	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(pageLoadCondition);
	}

	public void getUrl(String url) {
		log.info("navigating to :-" + url);

		driver.get(url);

	}

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + "/src/main/java/com/vapsTechnosoft/IVRM/data/" + excelName;
		excel = new Excel_Reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}

	/**
	 * wait for visibility of elements
	 * 
	 * @param driver
	 * @param timeOutInSeconds
	 * @param element
	 */
	public void waitForElement(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void getScreenShot(String name) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/vapsTechnosoft/IVRM/screenshot/";
			File destFile = new File(
					(String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void highlightMe(WebDriver driver, WebElement element) throws InterruptedException {
		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute javascript
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		Thread.sleep(3000);
		js.executeScript("arguments[0].style.border=''", element);
	}

	public Iterator<String> getAllWindows() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		return itr;
	}

	public void getScreenShot(WebDriver driver, ITestResult result, String folderName) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		String methodName = result.getName();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/vapsTechnosoft/IVRM/";
			File destFile = new File((String) reportDirectory + "/" + folderName + "/" + methodName + "_"
					+ formater.format(calendar.getTime()) + ".png");

			FileUtils.copyFile(scrFile, destFile);

			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getScreenShotOnSucess(WebDriver driver, ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		String methodName = result.getName();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/vapsTechnosoft/IVRM/";
			File destFile = new File((String) reportDirectory + "/failure_screenshots/" + methodName + "_"
					+ formater.format(calendar.getTime()) + ".png");

			FileUtils.copyFile(scrFile, destFile);

			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String captureScreen(String fileName) {
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/vapsTechnosoft/IVRM/screenshot/";
			destFile = new File(
					(String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
		test.log(LogStatus.INFO, data);
	}

	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			String screen = captureScreen("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) {
		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		closeBrowser();
	}

	public void closeBrowser() {
		// driver.quit();
		log.info("browser closed");
		extent.endTest(test);
		extent.flush();
	}

	/**
	 * Wait for the element to be clickable
	 * 
	 * @param driver
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public WebElement waitForElementClickable(WebDriver driver, WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	// @Parameters("browser")
	// @BeforeTest
	// public void launchapp(String browser) throws IOException {
	//
	// if (System.getProperty("os.name").contains("Mac")) {
	// if (browser.equals("chrome")) {
	// //System.setProperty("webdriver.chrome.driver",
	// System.getProperty("user.dir") + "/drivers/chromedriver");
	// System.out.println(" Executing on CHROME");
	// DesiredCapabilities cap = DesiredCapabilities.chrome();
	// cap.setBrowserName("chrome");
	// String Node = "http://localhost:5001/wd/hub";
	// driver = new RemoteWebDriver(new URL(Node), cap);
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// // Launch website
	// loadData();
	// getUrl(OR.getProperty("url"));
	// } else if (browser.equals("firefox")) {
	// //System.setProperty("webdriver.gecko.driver",
	// System.getProperty("user.dir") + "/drivers/geckodriver.exe");
	// System.out.println(" Executing on FireFox");
	// String Node = "http://172.16.123.130:5000/wd/hub";
	// DesiredCapabilities cap = DesiredCapabilities.firefox();
	// cap.setBrowserName("firefox");
	// driver = new RemoteWebDriver(new URL(Node), cap);
	// loadData();
	// getUrl(OR.getProperty("url"));
	// } else if (browser.equalsIgnoreCase("ie")) {
	// System.out.println(" Executing on IE");
	// DesiredCapabilities cap = DesiredCapabilities.chrome();
	// cap.setBrowserName("ie");
	// String Node = "http://192.168.0.101:5555/wd/hub";
	// driver = new RemoteWebDriver(new URL(Node), cap);
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// // Launch website
	// loadData();
	// getUrl(OR.getProperty("url"));
	// } else {
	// throw new IllegalArgumentException("The Browser Type is Undefined");
	// }
	// }
	// if (System.getProperty("os.name").contains("Window")) {
	// if (browser.equals("chrome")) {
	// System.out.println(System.getProperty("user.dir"));
	// System.setProperty("webdriver.chrome.driver",
	// System.getProperty("user.dir") + "/drivers/chromedriver.exe");
	// System.out.println(" Executing on CHROME");
	// DesiredCapabilities cap = DesiredCapabilities.chrome();
	// cap.setBrowserName("chrome");
	//
	// String Node = "http://localhost:5555/wd/hub";
	// driver = new RemoteWebDriver(new URL(Node), cap);
	// //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// // Launch website
	// loadData();
	// getUrl(OR.getProperty("url"));
	// } else if (browser.equals("firefox")) {
	// System.out.println(System.getProperty("user.dir"));
	// System.setProperty("webdriver.gecko.driver",
	// System.getProperty("user.dir") + "/drivers/geckodriver.exe");
	// System.out.println(" Executing on FireFox");
	// String Node = "http://172.16.123.130:5554/wd/hub";
	// DesiredCapabilities cap = DesiredCapabilities.firefox();
	// cap.setBrowserName("firefox");
	// driver = new RemoteWebDriver(new URL(Node), cap);
	// loadData();
	// getUrl(OR.getProperty("url"));
	// } else if (browser.equalsIgnoreCase("ie")) {
	// System.out.println(" Executing on IE");
	// DesiredCapabilities cap = DesiredCapabilities.chrome();
	// cap.setBrowserName("ie");
	// String Node = "http://192.168.0.101:5555/wd/hub";
	// driver = new RemoteWebDriver(new URL(Node), cap);
	// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// // Launch website
	// getUrl(OR.getProperty("url"));
	// } else {
	// throw new IllegalArgumentException("The Browser Type is Undefined");
	// }
	// }
	// }
	public void selectDate(List<WebElement> calYear, List<WebElement> calMonth, List<WebElement> calDays,
			String yearValue, String monthValue, String dayValue) {

		try {

			for (WebElement cells : calYear) {
				if (cells.getText().equals(yearValue)) {
					for (WebElement monthcell : calMonth) {
						if (monthcell.getText().equals(monthValue)) {
							monthcell.click();
							Thread.sleep(2000);
							for (WebElement dayscell : calDays) {
								System.out.println(dayscell);
								if (dayscell.getText().equals(dayValue)) {
									dayscell.click();
									log("selcted the date from calendar");
									Thread.sleep(2000);
									break;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * imageAndDocumentUpload for admission form and whereever its required in
	 * application using Robot class
	 * 
	 * @param imageName
	 * @throws Exception
	 */
	public void imageAndDocumentUpload(WebElement imgElement, String imageName) throws Exception {

		imgElement.click();
		Thread.sleep(2000);
		log("cliked on documents link to upload jpg/jpeg format document:-and object is " + imgElement.toString());
		ClipboardOwner owner = null;
		String imagepath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\vapsTechnosoft\\IVRM\\data\\"
				+ imageName;
		System.out.println(System.getProperty("user.dir"));
		Robot robot = new Robot();
		StringSelection attachmentpath = new StringSelection(imagepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(attachmentpath, owner);
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(5000);
	}

	public void copyToClipbord(String copyTo) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection str = new StringSelection(copyTo);
		clipboard.setContents(str, null);
	}

	public void enterdateIntoDateField(String copyDate, WebElement dateElement) throws Exception {

		Clipboard clipboard1 = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection str1 = new StringSelection(copyDate);
		clipboard1.setContents(str1, null);
		Thread.sleep(2000);
		Actions oAction = new Actions(driver);
		oAction.moveToElement(dateElement);
		oAction.contextClick(dateElement).build()
				.perform(); /* this will perform right click */
		//

		Robot oRobot = new Robot();
		oRobot.keyPress(KeyEvent.VK_DOWN);
		oRobot.keyRelease(KeyEvent.VK_DOWN);
		oRobot.keyPress(KeyEvent.VK_DOWN);
		oRobot.keyRelease(KeyEvent.VK_DOWN);
		oRobot.keyPress(KeyEvent.VK_ENTER);
		oRobot.keyRelease(KeyEvent.VK_ENTER);

	}

	public void calendarDatePicker(WebElement calendarBtn, WebElement MonthYear, WebElement date) throws Exception {
		if (calendarBtn.isDisplayed()) {
			calendarBtn.click();
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MonthYear);
			Thread.sleep(2000);
			date.click();
			Thread.sleep(1000);
		} else {
			log("Calendar button element not present.");
			Thread.sleep(500);
		}
	}

	public void inputTextIntoInputField(WebElement element, String value) {
		try {
			isDisplayed(element);
			element.clear();
			element.sendKeys(value);
			log("Entered value to input Field is " + value + " and object is:- " + element.toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void isDisplayed(WebElement element) {
		try {
			element.isDisplayed();
			log("Element is present...and object is: " + element.toString());
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			log("Element is not present...and object is: " + element.toString());

		}
	}

	public void selectedDropdownItemValidation(WebElement element, String value) {
		try {
			isDisplayed(element);
			select = new Select(element);
			log("Selected Value from drop down for validation " + value + " and object is:- " + element.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), value);
			log("Selected item from drop down list is verified and selected item is: " + option.getText().trim());
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			log("Element is not present...and object is: " + element.toString());

		}
	}

	public void selectElementFromDropDown(WebElement element, String value) {
		try {
			isDisplayed(element);
			select = new Select(element);
			select.selectByVisibleText(value);
			log("Selected Value from drop down " + value + " and object is:- " + element.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), value);
			log("Selected item from drop down list is verified and selected item is: " + option.getText().trim());
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			log("Element is not present...and object is: " + element.toString());

		}
	}

	public void clickOnButton(WebElement element) {
		try {
			isDisplayed(element);
			element.click();
//			log("Clicked on button for specific action and object is:- " + element.toString());
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			log("Element is not present...and object is: " + element.toString());
		}
	}

	public void SortData_InColumn_DescendingOrder(List<WebElement> elementList) {
		try {
			sort = new Sort();
			sort.Sort_ColumnData_DescendingOrder(elementList);
			// log("Sorted element in descending order and object is:-
			// "+elementList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SortData_InColumn_AscendingOrder(List<WebElement> elementList) {
		try {
			sort = new Sort();
			sort.Sort_ColumnData_AscendingOrder(elementList);
			// log("Sorted element in descending order and object is:-
			// "+elementList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyColumnHeaderWithExcelData(List<WebElement> xpath, String filePath, String columnName,
			String sheetName) throws Exception {
		ArrayList<String> listArray = Column_Header.getColumns(xpath);
		log("Grid Column Header from web Page:- " + listArray);
		//System.out.println(listArray);

		ArrayList<String> nameList = Excel_Reader.getXLData(filePath, columnName, sheetName);
		System.out.println("Grid Column Header From Excel: "+nameList);
		log("Grid Column Header From Excel: "+nameList);
		compareExcelValues(nameList, listArray);
		// assertEquals(nameList, nameList);

	}

	public void verifyRowValuesWithExcelData(List<WebElement> xpath, String filePath, String columnName,
			String sheetName) throws Exception {
		ArrayList<String> listArray = Column_Header.getColumns(xpath);
		log("Grid Row Values:- " + listArray);
		System.out.println(listArray);

		ArrayList<String> nameList = Excel_Reader.getXLData(filePath, columnName, sheetName);
		System.out.println(nameList);
		compareExcelValues_WithRowValues(nameList, listArray);
		// assertEquals(listArray, nameList);
	}

	/**
	 * Compare data of two array
	 * 
	 * @param expectedArrayList:
	 *            List of expected data
	 * @param actualArrayList:
	 *            List of actual data
	 * @throws IOException
	 */
	public void compareExcelValues(ArrayList<String> expectedArrayList, ArrayList<String> actualArrayList)
			throws IOException {
		try {
			main: for (int expectedList = 0; expectedList < expectedArrayList.size(); expectedList++) {
				for (int actualList = 0; actualList < actualArrayList.size(); actualList++) {
					if (expectedArrayList.get(expectedList).trim().equals(actualArrayList.get(actualList).trim())) {

						log("Column Header matched with Excel data, Expected value: '"
								+ expectedArrayList.get(expectedList).toString() + "'== Actual Value : '"
								+ actualArrayList.get(actualList).toString() + "'");

						continue main;
					}
				}

				log("Column Header not matched with Excel data ,Item '" + expectedArrayList.get(expectedList)
						+ "' does not exists.");

			}

		} catch (Exception e) {
			e.printStackTrace();
			log("failed");
		}
	}

	/**
	 * Compare data of two array
	 * 
	 * @param expectedArrayList:
	 *            List of expected data
	 * @param actualArrayList:
	 *            List of actual data
	 * @throws IOException
	 */
	public void compareExcelValues_WithRowValues(ArrayList<String> expectedArrayList, ArrayList<String> actualArrayList)
			throws IOException {
		try {
			main: for (int expectedList = 0; expectedList < expectedArrayList.size(); expectedList++) {
				for (int actualList = 0; actualList < actualArrayList.size(); actualList++) {
					if (expectedArrayList.get(expectedList).trim().equals(actualArrayList.get(actualList).trim())) {

						// log("Row values matched with Excel data, Expected
						// value: '"
						// + expectedArrayList.get(expectedList).toString() +
						// "'== Actual Value : '"
						// + actualArrayList.get(actualList).toString() + "'");
						System.out.println("Pass");
						continue main;
					}
				}
				System.out.println("Fail");
				// log("Row values not matched with Excel data ,Item '" +
				// expectedArrayList.get(expectedList)
				// + "' does not exists.");

			}

		} catch (Exception e) {
			e.printStackTrace();
			log("failed");
		}
	}

	public void verifyRowValuesWithExcelData_Download_Header(List<WebElement> xpath, String filePath, String sheetName)
			throws Exception {
		ArrayList<String> listArray = Column_Header.getColumns(xpath);
		log("Grid Row Values:- " + listArray);
		System.out.println("WebPage list: " + listArray);

		ArrayList<String> headerList = Excel_Reader.getXLDataRowWise(filePath, sheetName);
		// ArrayList headerList1= new ArrayList();
		// headerList1={headerList1.add(headerList.get(0))};
		// headerList1.add(headerList.get(0));
		System.out.println("Excel data list: " + headerList);
		/// compareExcelValues_WithRowValues(headerList.get(0), listArray);
		compareExcelValues_WithRowValues(headerList, listArray);
		// assertEquals(listArray, nameList);
	}

	public void verifyRowValuesWithExcelData_Download_1stRowValues(List<WebElement> xpath, String filePath,
			String sheetName) throws Exception {
		ArrayList<String> listArray = Column_Header.getColumns(xpath);
		log("Grid Row Values:- " + listArray);
		System.out.println(listArray);

		ArrayList<String> headerList = Excel_Reader.getXLDataRowWise(filePath, sheetName);
		ArrayList<String> headerList1 = new ArrayList<String>();
		headerList1.add(headerList.get(1));
		System.out.println(headerList);
		/// compareExcelValues_WithRowValues(headerList.get(0), listArray);
		compareExcelValues_WithRowValues(headerList1, listArray);
		// assertEquals(listArray, nameList);
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * TestBase tb = new TestBase(); //Excel_Reader er= new Excel_Reader();
	 * ArrayList listdata =
	 * Excel_Reader.getXLDataRowWise("AdmissionReports.xlsx",
	 * "Search_TotalStrength"); //ArrayList<String> listdata1= new
	 * ArrayList<String>(); //listdata1.add(listdata.get(0)); //String[][] list
	 * = tb.getXlData("AdmissionReports.xlsx", "Search_TotalStrength");
	 * System.out.println(listdata.size()); System.out.println(listdata.get(0));
	 * }
	 */
}
