/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.TC_Reports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Fee.Reports.Yearly_Fee_Collection_Report;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author Arvind
 *
 */
public class TC_Yearly_Fee_Collection_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Yearly_Fee_Collection_Report.class.getName());

	Yearly_Fee_Collection_Report yarlyfeecollectionreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_YearlyFeeCollectionReportData")
	public String[][] getTestWrittenData() {
		String[][] testRecordsYearlyFeeCollection = getData("FeeReportsData.xlsx", "YearlyFeeCollection_Report");
		return testRecordsYearlyFeeCollection;
	}

	@DataProvider(name = "Search_ClassWiseAttendanceReportData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearchDetails = getData("AdmissionReports.xlsx", "Search_ClasswiseAttendance");
		return testRecordsSearchDetails;
	}

	@DataProvider(name = "ValidationData_ClassWiseAttendanceReportData")
	public String[][] getTestValidationData() {
		String[][] testRecordsValidationDetails = getData("AdmissionReports.xlsx", "ValidationData_ClassWiseAttend");
		return testRecordsValidationDetails;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		yarlyfeecollectionreport = new Yearly_Fee_Collection_Report(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting login to the Vaps IVRM application===========");
			getScreenShot("Login Page");
			ivrmportallogin.loginToApplication(username, password);

			boolean status = ivrmportallogin.verifyLoginToIVRMportal();

			Assert.assertEquals(status, true);
			log.info("============= Finished loginToappWithrequiredCredentials===========");

			getScreenShot("loginToappWithrequiredCredentials");
		} catch (Exception e) {
			getScreenShot("loginToappWithrequiredCredentials");
		}
	}

	@Test(priority = 2)
	public void tcHomeButtonValidation() {

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			boolean status = yarlyfeecollectionreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFee_Reports_YearlyFeeCollectionReport() {

		try {
			log.info("============= Strting tcNavigateToFee_Reports_YearlyFeeCollectionReport Test===========");

			yarlyfeecollectionreport.navigateToFee_Reports_YearlyFeeCollectionReport();

			log.info("============= Finished tcNavigateToFee_Reports_YearlyFeeCollectionReport Test===========");
			getScreenShot("tcNavigateToFee_Reports_YearlyFeeCollectionReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFee_Reports_YearlyFeeCollectionReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeReports_YearlyFeeCollectionReport_Page() {

		try {
			log.info("============= Strting tcVerifyFeeReports_YearlyFeeCollectionReport_Page Test===========");

			boolean status = yarlyfeecollectionreport.verifyFeeReports_YearlyFeeCollectionReport_Page();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeReports_YearlyFeeCollectionReport_Page Test===========");
			getScreenShot("tcVerifyFeeReports_YearlyFeeCollectionReport_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeReports_YearlyFeeCollectionReport_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_YearlyFeeCollectionReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_YearlyFeeCollectionReportForm Test===========");

			yarlyfeecollectionreport.submitBlank_YearlyFeeCollectionReportForm();

			log.info("============= Finished tcSubmitBlank_YearlyFeeCollectionReportForm Test===========");
			getScreenShot("tcSubmitBlank_YearlyFeeCollectionReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_YearlyFeeCollectionReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise");
		}
	}

	@Test(priority = 8)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_YearlyFeeCollectionReport_Form() {

		try {
			log.info("============= Strting tcMinimize_YearlyFeeCollectionReport_Form Test===========");

			yarlyfeecollectionreport.min_Max_YearlyFeeCollectionReport_Form();

			log.info("============= Finished tcMinimize_YearlyFeeCollectionReport_Form Test===========");
			getScreenShot("tcMinimize_YearlyFeeCollectionReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_YearlyFeeCollectionReport_Form");
		}
	}

	@Test(priority = 10)
	public void tcSortRecordsByGroupName() {

		try {
			log.info("============= Strting tcSortRecordsByGroupName Test===========");
			getScreenShot("BeforeSorting_tcSortRecordsByGroupName");

			yarlyfeecollectionreport.sortRecordsByGroupName();

			log.info("============= Finished tcSortRecordsByGroupName Test===========");
			getScreenShot("tcSortRecordsByGroupName");
		} catch (Exception e) {
			getScreenShot("tcSortRecordsByGroupName");
		}
	}

	@Test(priority = 11)
	public void tcMinimize_YearlyFeeCollectionReport_Grid() {

		try {
			log.info("============= Strting tcMinimize_YearlyFeeCollectionReport_Grid Test===========");

			yarlyfeecollectionreport.min_Max_YearlyFeeCollectionReport_Grid();

			log.info("============= Finished tcMinimize_YearlyFeeCollectionReport_Grid Test===========");
			getScreenShot("tcMinimize_YearlyFeeCollectionReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMinimize_YearlyFeeCollectionReport_Grid");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_YearlyFeeCollectionReport_Grid() {

		try {
			log.info("============= Strting tcMaximize_YearlyFeeCollectionReport_Grid Test===========");

			yarlyfeecollectionreport.min_Max_YearlyFeeCollectionReport_Grid();

			log.info("============= Finished tcMaximize_YearlyFeeCollectionReport_Grid Test===========");
			getScreenShot("tcMaximize_YearlyFeeCollectionReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMaximize_YearlyFeeCollectionReport_Grid");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_YearlyFeeCollectionReport_Form() {

		try {
			log.info("============= Strting tcMaximize_YearlyFeeCollectionReport_Form Test===========");

			yarlyfeecollectionreport.min_Max_YearlyFeeCollectionReport_Form();

			log.info("============= Finished tcMaximize_YearlyFeeCollectionReport_Form Test===========");
			getScreenShot("tcMaximize_YearlyFeeCollectionReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_YearlyFeeCollectionReport_Form");
		}
	}

	@Test(priority = 14)
	public void tcSelectColumnName_ForDisplayInGrid() {

		try {
			log.info("============= Strting tcSelectColumnName_ForDisplayInGrid Test===========");

			yarlyfeecollectionreport.selectColumnName_ForDisplayInGrid();

			log.info("============= Finished tcSelectColumnName_ForDisplayInGrid Test===========");
			getScreenShot("tcSelectColumnName_ForDisplayInGrid");
		} catch (Exception e) {
			getScreenShot("tcSelectColumnName_ForDisplayInGrid");
		}
	}

	@Test(priority = 15)
	public void tcCloseDisplayPopUpWindow() {

		try {
			log.info("============= Strting tcCloseDisplayPopUpWindow Test===========");

			yarlyfeecollectionreport.closeDisplayPopUpWindow();

			log.info("============= Finished tcCloseDisplayPopUpWindow Test===========");
			getScreenShot("tcCloseDisplayPopUpWindow");
		} catch (Exception e) {
			getScreenShot("tcCloseDisplayPopUpWindow");
		}
	}

	@Test(priority = 16)
	public void tcClickClearButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm Test===========");

			yarlyfeecollectionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm");
		}
	}

	/*
	 * Fee Group Wise
	 */
	@Test(priority = 17, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterClearingFilledData(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterClearingFilledData Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterClearingFilledData Test===========");
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterClearingFilledData");
		}
	}

	@Test(priority = 18)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_AfterClearingFilledData Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_AfterClearingFilledData Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_AfterClearingFilledData");
		}
	}

	@Test(priority = 19)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_AfterClearingFilledData Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_AfterClearingFilledData Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_AfterClearingFilledData");
		}
	}

	@Test(priority = 20)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active");
		}
	}

	@Test(priority = 21)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active");
		}
	}

	@Test(priority = 22, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 23)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 24)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_ForDeactiveStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 25)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_DeActive Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_DeActive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_DeActive");
		}
	}

	@Test(priority = 26)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_DeActive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_DeActive Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_DeActive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_DeActive");
		}
	}

	@Test(priority = 27, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent");
		}
	}

	@Test(priority = 28)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForLeftStudent Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForLeftStudent");
		}
	}

	@Test(priority = 29)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_ForLeftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_ForLeftStudent");
		}
	}

	@Test(priority = 30)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left");
		}
	}

	@Test(priority = 31)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left");
		}
	}

	@Test(priority = 32, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent(
							academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 33)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 34)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 35)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 36)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 37, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student(
							academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 38)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 39)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 40)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 41)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}

	/**
	 * Fee Head wise
	 */
	@Test(priority = 42, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent");
		}
	}

	@Test(priority = 43)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_Active Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_Active Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_Active");
		}
	}

	@Test(priority = 44)
	public void tcSelectRecordToGenerateReport_YearlyFeeHeadWise_Active() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyFeeHeadWise_Active Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyFeeHeadWise_Active Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyFeeHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyFeeHeadWise_Active");
		}
	}

	@Test(priority = 45)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_Active Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_Active");
		}
	}

	@Test(priority = 46)
	public void tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_Active Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_Active");
		}
	}

	@Test(priority = 47, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 48)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 49)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_ForDeactiveStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 50)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_DeActive Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_DeActive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_DeActive");
		}
	}

	@Test(priority = 51)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_DeActive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_DeActive Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_DeActive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_DeActive");
		}
	}

	@Test(priority = 52, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent");
		}
	}

	@Test(priority = 53)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForLeftStudent Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForLeftStudent");
		}
	}

	@Test(priority = 54)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_ForLeftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_ForLeftStudent");
		}
	}

	@Test(priority = 55)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left");
		}
	}

	@Test(priority = 56)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left");
		}
	}

	@Test(priority = 57, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent(
							academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 58)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 59)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 60)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 61)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 62, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student(
							academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 63)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 64)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 65)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 66)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHead Wise_WithoutActive_Deactive_Left_Student");
		}
	}
/*
 * Class Wise
 */
	@Test(priority = 67, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActiveStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActiveStudent");
		}
	}

	@Test(priority = 68)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_Active Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_Active Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_Active");
		}
	}

	@Test(priority = 69)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_Active() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_Active Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_Active Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Active");
		}
	}

	@Test(priority = 70)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active");
		}
	}

	@Test(priority = 71)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active");
		}
	}

	@Test(priority = 72, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForDeactiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForDeactiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 73)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 74)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_ForDeactiveStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 75)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_DeActive Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_DeActive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_DeActive");
		}
	}

	@Test(priority = 76)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_DeActive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_DeActive Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_DeActive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_DeActive");
		}
	}

	@Test(priority = 77, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForLeftStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForLeftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForLeftStudent");
		}
	}

	@Test(priority = 78)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForLeftStudent Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForLeftStudent");
		}
	}

	@Test(priority = 79)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_ForLeftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_ForLeftStudent");
		}
	}

	@Test(priority = 80)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left");
		}
	}

	@Test(priority = 81)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left");
		}
	}

	@Test(priority = 82, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_FeeClassWise_ForActive_Deactive_leftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent(
							academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 83)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 84)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 85)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 86)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 87, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student(
							academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 88)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 89)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 90)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 91)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		}
	}
	/*
	 * Student Wise(Yearly Wise)
	 */
	
	@Test(priority = 92, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActiveStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActiveStudent");
		}
	}

	@Test(priority = 93)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_Active Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_Active Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_Active");
		}
	}

	@Test(priority = 94)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_Active() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_Active Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_Active Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Active");
		}
	}

	@Test(priority = 95)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active");
		}
	}

	@Test(priority = 96)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active");
		}
	}

	@Test(priority = 97, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForDeactiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForDeactiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 98)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 99)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_ForDeactiveStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 100)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_DeActive Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_DeActive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_DeActive");
		}
	}

	@Test(priority = 101)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_DeActive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_DeActive Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_DeActive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_DeActive");
		}
	}

	@Test(priority = 102, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForLeftStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForLeftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForLeftStudent");
		}
	}

	@Test(priority = 103)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForLeftStudent Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForLeftStudent");
		}
	}

	@Test(priority = 104)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_ForLeftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_ForLeftStudent");
		}
	}

	@Test(priority = 105)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left");
		}
	}

	@Test(priority = 106)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left");
		}
	}

	@Test(priority = 107, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent(
							academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 108)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 109)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 110)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 111)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 112, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student(
							academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 113)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 114)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 115)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 116)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		}
	}
	/*
	 * Category wise(Yearly wise)
	 */
	@Test(priority = 117, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActiveStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActiveStudent");
		}
	}

	@Test(priority = 118)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_Active Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_Active Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_Active");
		}
	}

	@Test(priority = 119)
	public void tcSelectRecordToGenerateReport_YearlyCategoryWise_Active() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyCategoryWise_Active Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyCategoryWise_Active Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyCategoryWise_Active");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyCategoryWise_Active");
		}
	}

	@Test(priority = 120)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_Active Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_Active");
		}
	}

	@Test(priority = 121)
	public void tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_Active Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_Active");
		}
	}

	@Test(priority = 122, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForDeactiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForDeactiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 123)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 124)
	public void tcSelectRecordToGenerateReport_YearlyCategoryWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyCategoryWise_ForDeactiveStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyCategoryWise_ForDeactiveStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyCategoryWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyCategoryWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 125)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_DeActive Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_DeActive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_DeActive");
		}
	}

	@Test(priority = 126)
	public void tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_DeActive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_DeActive Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_DeActive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_DeActive");
		}
	}

	@Test(priority = 127, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForLeftStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForLeftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForLeftStudent");
		}
	}

	@Test(priority = 128)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForLeftStudent Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForLeftStudent");
		}
	}

	@Test(priority = 129)
	public void tcSelectRecordToGenerateReport_YearlyCategoryWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyCategoryWise_ForLeftStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyCategoryWise_ForLeftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyCategoryWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyCategoryWise_ForLeftStudent");
		}
	}

	@Test(priority = 130)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_Left Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_Left");
		}
	}

	@Test(priority = 131)
	public void tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_Left Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_Left");
		}
	}

	@Test(priority = 132, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActive_Deactive_leftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActive_Deactive_leftStudent(
							academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 133)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 134)
	public void tcSelectRecordToGenerateReport_YearlyCategoryWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyCategoryWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyCategoryWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyCategoryWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyCategoryWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 135)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 136)
	public void tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 137, dataProvider = "Reports_YearlyFeeCollectionReportData")
	public void tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_WithoutActive_Deactive_Left_Student(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport
					.fill_YearlyFeeCollectionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student(
							academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeCollectionReportForm_YearlyWise_CategoryWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 138)
	public void tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickReport_ToGenerate_YearlyFeeCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeCollectionReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 139)
	public void tcSelectRecordToGenerateReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 140)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyCategoryWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 141)
	public void tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeecollectionreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyCategoryWise_WithoutActive_Deactive_Left_Student");
		}
	}
}
