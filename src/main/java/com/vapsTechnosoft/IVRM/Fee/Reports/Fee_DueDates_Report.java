/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Reports;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vapsTechnosoft.IVRM.excelReader.Excel_Reader;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Fee_DueDates_Report extends TestBase {

	public static final Logger log = Logger.getLogger(Fee_DueDates_Report.class.getName());

	private WebDriver driver;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	private WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	private WebElement btn_Fee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]")
	private WebElement btn_FeeReports;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Reports')][1]/following::li[13]")
	// private WebElement btn_FeeDueDatesReport;

	@FindBy(xpath = "//a[@href='#/app/feeduedatereport/118']")
	private WebElement btn_FeeDueDatesReport;

	@FindBy(xpath = "//div//section//ol//li")
	private WebElement txt_FeeDueDatesReport;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	private WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Class Category:')]/following-sibling::div/select")
	private WebElement sel_ClassCategory;

	@FindBy(xpath = "//span[contains(text(),'Report')]/parent::button")
	private WebElement btn_ShowReport;

	@FindBy(xpath = "//span[contains(text(),'print')]/parent::button")
	private WebElement btn_Print;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	private WebElement btn_Cancel;

	@FindBy(xpath = "//span[contains(text(),'Export to Excel')]/parent::button")
	private WebElement btn_ExportToExcel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	private WebElement btnMin_MaxFeeDueDatesReport;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	private WebElement btnMin_MaxFeeDueDatesReportGrid;

	@FindBy(xpath = "//table[@id='Table']/thead/tr/th[4]/a")
	private WebElement btnSortByFeeHeadName;

	@FindBy(xpath = "//input[@ng-model='searchString']")
	private WebElement input_Search;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement btnOKSuccess;

	@FindBy(xpath = "//table[@id='Table']/tbody/tr/td[1]/label/input")
	private List<WebElement> Chk_Records_FeeDueDatesReportGrid;

	@FindBy(xpath = "//div[@ng-show='grid_flag']/div/h3")
	WebElement grid_HeaderName;

	@FindBy(xpath = "//table/thead/tr/th/a")
	private List<WebElement> HeaderList;

	
	
	public Fee_DueDates_Report(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to Fee > Reports > Fee Due Dates Report
	 * 
	 * @throws Exception
	 */
	public void navigateToFee_Reports_FeeDueDatesReport() throws Exception {

		clickOnButton(btn_Fee);
		log("Clicked on Fee Button in Navigation panel and object is:-" + btn_Fee.toString());

		clickOnButton(btn_FeeReports);
		log("Clicked on Fee reports in navigation panel and object is:-" + btn_FeeReports.toString());

		clickOnButton(btn_FeeDueDatesReport);
		log("Clicked on Fee Due Dates Report Button in navigation panel and object is:-"
				+ btn_FeeDueDatesReport.toString());

	}

	/**
	 * Validation of Fee > Reports > Fee Due Dates Report screen message
	 * 
	 * @return
	 */
	public boolean verifyFeeReports_FeeDueDatesReport_Page() {
		try {
			System.out.println(txt_FeeDueDatesReport.getText().trim());
			txt_FeeDueDatesReport.isDisplayed();
			log("Fee Due Dates Report page text is dispalyed and object is:-" + txt_FeeDueDatesReport.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void submitBlank_FeeDueDatesReportForm() throws Exception {

		clickOnButton(btn_ShowReport);
		log("Submit blank Fee Due Dates Report form and object is:-" + btn_ShowReport.toString());

	}

	/*
	 * Generate report for Fee Due Dates
	 * 
	 */
	public void fill_FeeDueDatesReportForm(String academicYear, String classCategory) throws Exception {

		selectElementFromDropDown(sel_AcademicYear, academicYear);
		log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_ClassCategory, classCategory);
		log("selected class Category: " + classCategory + " and object is:- " + sel_ClassCategory.toString());

	}

	public void clickReport_ToGenerate_FeeDueDatesReport() throws Exception {

		clickOnButton(btn_ShowReport);
		log("Fee Due Dates Report is generated and object is:-" + btn_ShowReport.toString());

	}

	public void clickCancelButton_ToClearFilledForm() throws Exception {

		clickOnButton(btn_Cancel);
		log("Fee Due Dates Report filled form data is cleared and object is:-" + btn_Cancel.toString());

	}

	public void clickOnExportToExcel_ToDownLoadExcelReport() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeDueDatesReport);
		Thread.sleep(1000);

		clickOnButton(btn_ExportToExcel);
		
//		ClipboardOwner owner = null;
//		String imagepath ="Arvind.xlsx";
//		System.out.println(System.getProperty("user.dir"));
//		Robot robot = new Robot();
//		StringSelection attachmentpath = new StringSelection(imagepath);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(attachmentpath, owner);
//		robot.setAutoDelay(2000);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.setAutoDelay(2000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		robot.setAutoDelay(5000);
		log("To Download excel report click on Export to excel and object is:-" + btn_ExportToExcel.toString());
		Thread.sleep(1000);
		
		
//		
//		try 
//		{
//		if ((new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\vapsTechnosoft\\IVRM\\downloadFile\\Arvind.xls")).delete()) {
//		                System.out.println("Desire file is deleted : PASS...");     
//		            } else {
//		                System.out.println("Desire file does not exist in the folder : FAIL...");
//		            }
//
//		          } catch (Exception ex) {
//		            ex.printStackTrace();
//		          }
		
		/*// File (or directory) with old name
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\vapsTechnosoft\\IVRM\\downloadFile\\download.xls");

		// File (or directory) with new name
		File file2 = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\vapsTechnosoft\\IVRM\\downloadFile\\Arvind.xls");

		if (file2.exists())
		   throw new java.io.IOException("file exists");

		// Rename file (or directory)
		boolean success = file.renameTo(file2);

		if (!success) {
		  System.out.println("File was not successfully renamed");
		}*/
		Thread.sleep(3000);
		//Excel_Reader e_r = new Excel_Reader();
		//System.out.println(e_r.getDataFromSheet("FeeDueDates_Report","FeeReportsData.xlsx"));
		//System.out.println(getData("FeeReportsData.xlsx", "FeeDueDates_Report"));
		System.out.println(Excel_Reader.getXLData_Dwn("download.xls", "Fee Group", "WireWorkbenchDataExport"));
		

	}

	public void clickOnPrint_ForPrintPreview() throws Exception {

		String parentWin = driver.getWindowHandle();

		clickOnButton(btn_Print);
		log("Print button is clicked to generate report and object is:-" + btn_Print.toString());

		Set<String> allWin = driver.getWindowHandles();

		System.out.println("Page title before Switching : " + driver.getTitle());
		System.out.println("Total Windows : " + allWin.size());

		for (String windows : allWin) {
			// if(!windows.equals(parentWin)){
			driver.switchTo().window(windows);

			if (driver.getTitle().toLowerCase().contains("Print")) {
				Thread.sleep(1000);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER);
				Thread.sleep(2000);

				break;
			}
		}

		System.out.println("Page title after Switching for print: " + driver.getTitle());
		Thread.sleep(500);

		driver.close();
		driver.switchTo().window(parentWin);
		Thread.sleep(1000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void min_Max_FeeDueDatesReport_Form() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeDueDatesReport);
		Thread.sleep(1000);

		clickOnButton(btnMin_MaxFeeDueDatesReport);
		log("Fee Due Dates Report page minimized or maximized and object is:-"
				+ btnMin_MaxFeeDueDatesReport.toString());

	}

	public void min_Max_FeeDueDatesReport_Grid() throws Exception {

		clickOnButton(btnMin_MaxFeeDueDatesReportGrid);
		log("Fee Due Dates Report Grid page minimized or maximized and object is:-"
				+ btnMin_MaxFeeDueDatesReportGrid.toString());

	}

	public void sortRecordsByFeeHeadName() throws Exception {

		clickOnButton(btnSortByFeeHeadName);
		log("Sorted the record with Fee Head name and object is:-" + btnSortByFeeHeadName.toString());

	}

	public void selectRecordToDownLoadAndPrintPreview() throws Exception {
		try {
			//int no_Of_Record = Chk_Records_FeeDueDatesReportGrid.size();
			for (int i = 0; i < 1; i++) {
				if (!Chk_Records_FeeDueDatesReportGrid.get(i).isSelected()) {
					Chk_Records_FeeDueDatesReportGrid.get(i).click();
					log(i + " records check box is checked.");
					Thread.sleep(1000);
				} else {
					log(i + " records checked box is already checked.");
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchWithFeeHeadName_InFeeDueDatesReportGrid(String feeHeadName) throws Exception {

		inputTextIntoInputField(input_Search, feeHeadName);
		log("Entered Fee Head Name to search: " + feeHeadName + " and object is:-" + input_Search.toString());

	}
	public void validateGrid_RowValue_Header() throws Exception{
		//verifyRowValuesWithExcelData(casteCategoryGrid_Tr1, "AdmissionMasterGridHeader.xlsx", "CasteCategoryData", "Masters_Admission");
		verifyRowValuesWithExcelData_Download_Header(HeaderList, "AdmissionMasterGridHeader.xlsx", "Header_RowWise");
		
		
	}
	
}
