/**
 * 
 */
package com.vapsTechnosoft.IVRM.admission.TC_Reports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Admission.Reports.CategoryWise_Attendance_Report;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps Login with Staff credentials UserName: Priya, Password:
 *         password@123
 */
public class TC_CategoryWise_Attendance_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_CategoryWise_Attendance_Report.class.getName());

	CategoryWise_Attendance_Report categorywise_attendancereport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData_Staff")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin_Staff = getData("AdmissionReports.xlsx", "IVRM_StaffLogin_Data");
		return testRecordsLogin_Staff;
	}

	@DataProvider(name = "Reports_CategoryWise_AttendanceReport")
	public String[][] getTestData() {
		String[][] testRecords = getData("AdmissionReports.xlsx", "CategoryWise_AttendReportData");
		return testRecords;
	}

	@DataProvider(name = "Search_CategoryWise_AttendanceReport_Records")
	public String[][] getSearchData() {
		String[][] testRecordsSearch = getData("AdmissionReports.xlsx", "Search_CategoryWise_Attendance");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		categorywise_attendancereport = new CategoryWise_Attendance_Report(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData_Staff")
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

			boolean status = categorywise_attendancereport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Reports_CategoryWise_AttendanceReport_BGHS() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_Reports_CategoryWise_AttendanceReport_BGHS Test===========");

			categorywise_attendancereport.navigateToAdmission_Reports_CategoryWise_AttendanceReport_BGHS();

			log.info(
					"============= Finished tcNavigateToAdmission_Reports_CategoryWise_AttendanceReport_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Reports_CategoryWise_AttendanceReport_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Reports_CategoryWise_AttendanceReport_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmission_Reports_CategoryWise_AttendanceReport_BGHSPage() {

		try {
			log.info(
					"============= Strting tcVerifyAdmission_Reports_CategoryWise_AttendanceReport_BGHSPage Test===========");

			boolean status = categorywise_attendancereport
					.verifyAdmission_Reports_CategoryWise_AttendanceReport_BGHSPage();
			Assert.assertEquals(status, true);
			log.info(
					"============= Finished tcVerifyAdmission_Reports_CategoryWise_AttendanceReport_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmission_Reports_CategoryWise_AttendanceReport_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmission_Reports_CategoryWise_AttendanceReport_BGHSPage");
		}
	}

	@Test(priority = 5, dataProvider = "Reports_CategoryWise_AttendanceReport")
	public void tcFill_CategoryWise_AttendanceReportForm(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_CategoryWise_AttendanceReportForm Test===========");

			categorywise_attendancereport.fill_CategoryWise_AttendanceReportForm(academicYear);

			log.info("============= Finished tcFill_CategoryWise_AttendanceReportForm Test===========");
			getScreenShot("tcFill_CategoryWise_AttendanceReportForm");
		} catch (Exception e) {
			getScreenShot("tcFill_CategoryWise_AttendanceReportForm");
		}
	}

	@Test(priority = 6)
	public void tcClickOnReport_TogetRecords() {

		try {
			log.info("============= Strting tcClickOnReport_TogetRecords Test===========");

			categorywise_attendancereport.clickOnReport_TogetRecords();

			log.info("============= Finished tcClickOnReport_TogetRecords Test===========");
			getScreenShot("tcClickOnReport_TogetRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_TogetRecords");
		}
	}

	@Test(priority = 7)
	public void tcExportReport_ToDownloadExcelReport_WithoutSelectingRecords() {

		try {
			log.info(
					"============= Strting tcExportReport_ToDownloadExcelReport_WithoutSelectingRecords Test===========");

			categorywise_attendancereport.exportReport_ToDownloadExcelReport();

			log.info(
					"============= Finished tcExportReport_ToDownloadExcelReport_WithoutSelectingRecords Test===========");
			getScreenShot("tcExportReport_ToDownloadExcelReport_WithoutSelectingRecords");
		} catch (Exception e) {
			getScreenShot("tcExportReport_ToDownloadExcelReport_WithoutSelectingRecords");
		}
	}

	@Test(priority = 8)
	public void tcClickOnOkSuccessButton_ToDownloadExcelReportPopUp_WithoutSelectingRecords() {

		try {
			log.info(
					"============= Strting tcClickOnOkSuccessButton_ToDownloadExcelReportPopUp_WithoutSelectingRecords Test===========");

			categorywise_attendancereport.clickOnOkSuccessButton();

			log.info(
					"============= Finished tcClickOnOkSuccessButton_ToDownloadExcelReportPopUp_WithoutSelectingRecords Test===========");
			getScreenShot("tcClickOnOkSuccessButton_ToDownloadExcelReportPopUp_WithoutSelectingRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_ToDownloadExcelReportPopUp_WithoutSelectingRecords");
		}
	}

	@Test(priority = 9)
	public void tcClickOnPrint_ToPrintPreviewReport_WithoutSelectingRecords() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ToPrintPreviewReport_WithoutSelectingRecords Test===========");

			categorywise_attendancereport.clickOnPrint_WithoutSelectingRecords();

			log.info(
					"============= Finished tcClickOnPrint_ToPrintPreviewReport_WithoutSelectingRecords Test===========");
			getScreenShot("tcClickOnPrint_ToPrintPreviewReport_WithoutSelectingRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ToPrintPreviewReport_WithoutSelectingRecords");
		}
	}

	@Test(priority = 10)
	public void tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp Test===========");

			categorywise_attendancereport.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp Test===========");
			getScreenShot("tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp");
		}
	}

	@Test(priority = 11)
	public void tcMinimize_CategoryWise_AttendanceReport() {

		try {
			log.info("============= Strting tcMinimize_CategoryWise_AttendanceReport Test===========");

			categorywise_attendancereport.minimize_CategoryWise_AttendanceReport();
			log.info("============= Finished tcMinimize_CategoryWise_AttendanceReport Test===========");
			getScreenShot("tcMinimize_CategoryWise_AttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcMinimize_CategoryWise_AttendanceReport");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_CategoryWise_AttendanceReportCategoryList() {

		try {
			log.info("============= Strting tcMinimize_CategoryWise_AttendanceReportCategoryList Test===========");

			categorywise_attendancereport.minimize_CategoryWise_AttendanceReportCategoryList();
			log.info("============= Finished tcMinimize_CategoryWise_AttendanceReportCategoryList Test===========");
			getScreenShot("tcMinimize_CategoryWise_AttendanceReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimize_CategoryWise_AttendanceReportCategoryList");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_CategoryWise_AttendanceReportCategoryList() {

		try {
			log.info("============= Strting tcMaximize_CategoryWise_AttendanceReportCategoryList Test===========");

			categorywise_attendancereport.maximize_CategoryWise_AttendanceReportCategoryList();
			log.info("============= Finished tcMaximize_CategoryWise_AttendanceReportCategoryList Test===========");
			getScreenShot("tcMaximize_CategoryWise_AttendanceReportCategoryList");
		} catch (Exception e) {
			getScreenShot("tcMaximize_CategoryWise_AttendanceReportCategoryList");
		}
	}

	@Test(priority = 14)
	public void tcMaximize_CategoryWise_AttendanceReport() {

		try {
			log.info("============= Strting tcMaximize_CategoryWise_AttendanceReport Test===========");

			categorywise_attendancereport.maximize_CategoryWise_AttendanceReport();
			log.info("============= Finished tcMaximize_CategoryWise_AttendanceReport Test===========");
			getScreenShot("tcMaximize_CategoryWise_AttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcMaximize_CategoryWise_AttendanceReport");
		}
	}

	@Test(priority = 15, dataProvider = "Search_CategoryWise_AttendanceReport_Records")
	public void tcSearchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid(String categoryName,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid Test===========");

			categorywise_attendancereport
					.searchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid(categoryName);

			log.info(
					"============= Finished tcSearchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid Test===========");
			getScreenShot("tcSearchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid");
		}
	}

	@Test(priority = 16, dataProvider = "Search_CategoryWise_AttendanceReport_Records")
	public void tcVerifyCategory_ForCategoryWiseAttendanceReportInGrid(String categoryName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyCategory_ForCategoryWiseAttendanceReportInGrid Test===========");

			categorywise_attendancereport.verifyCategory_ForCategoryWiseAttendanceReportInGrid(categoryName);

			log.info("============= Finished tcVerifyCategory_ForCategoryWiseAttendanceReportInGrid Test===========");
			getScreenShot("tcVerifyCategory_ForCategoryWiseAttendanceReportInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyCategory_ForCategoryWiseAttendanceReportInGrid");
		}
	}

	@Test(priority = 17, dataProvider = "Search_CategoryWise_AttendanceReport_Records")
	public void tcSelectCategoryFor_CategoryWiseAttendanceReport(String categoryName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectCategoryFor_CategoryWiseAttendanceReport Test===========");

			categorywise_attendancereport.selectCategoryFor_CategoryWiseAttendanceReport(categoryName);

			log.info("============= Finished tcSelectCategoryFor_CategoryWiseAttendanceReport Test===========");
			getScreenShot("tcSelectCategoryFor_CategoryWiseAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcSelectCategoryFor_CategoryWiseAttendanceReport");
		}
	}

	@Test(priority = 18)
	public void tcClickOn_CancelButton_ToClearFilledData() {

		try {
			log.info("============= Strting tcClickOn_CancelButton_ToClearFilledData Test===========");

			categorywise_attendancereport.clickOn_CancelButton_ToClearFilledData();
			log.info("============= Finished tcClickOn_CancelButton_ToClearFilledData Test===========");
			getScreenShot("tcClickOn_CancelButton_ToClearFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickOn_CancelButton_ToClearFilledData");
		}
	}

	@Test(priority = 19, dataProvider = "Reports_CategoryWise_AttendanceReport")
	public void tcFill_CategoryWise_AttendanceReportForm_AfterCancel(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_CategoryWise_AttendanceReportForm_AfterCancel Test===========");

			categorywise_attendancereport.fill_CategoryWise_AttendanceReportForm(academicYear);

			log.info("============= Finished tcFill_CategoryWise_AttendanceReportForm_AfterCancel Test===========");
			getScreenShot("tcFill_CategoryWise_AttendanceReportForm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_CategoryWise_AttendanceReportForm_AfterCancel");
		}
	}

	@Test(priority = 20)
	public void tcClickOnReport_TogetRecords_AfterCancel() {

		try {
			log.info("============= Strting tcClickOnReport_TogetRecords_AfterCancel Test===========");

			categorywise_attendancereport.clickOnReport_TogetRecords();

			log.info("============= Finished tcClickOnReport_TogetRecords_AfterCancel Test===========");
			getScreenShot("tcClickOnReport_TogetRecords_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_TogetRecords_AfterCancel");
		}
	}

	@Test(priority = 21, dataProvider = "Search_CategoryWise_AttendanceReport_Records")
	public void tcSearchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid_AfterCancel(String categoryName,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid_AfterCancel Test===========");

			categorywise_attendancereport
					.searchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid(categoryName);

			log.info(
					"============= Finished tcSearchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid_AfterCancel Test===========");
			getScreenShot("tcSearchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchCategoryToGenerateReport_FromCategoryWiseAttendanceReportGrid_AfterCancel");
		}
	}

	@Test(priority = 22, dataProvider = "Search_CategoryWise_AttendanceReport_Records")
	public void tcVerifyCategory_ForCategoryWiseAttendanceReportInGrid_AfterCancel(String categoryName,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyCategory_ForCategoryWiseAttendanceReportInGrid_AfterCancel Test===========");

			categorywise_attendancereport.verifyCategory_ForCategoryWiseAttendanceReportInGrid(categoryName);

			log.info(
					"============= Finished tcVerifyCategory_ForCategoryWiseAttendanceReportInGrid_AfterCancel Test===========");
			getScreenShot("tcVerifyCategory_ForCategoryWiseAttendanceReportInGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcVerifyCategory_ForCategoryWiseAttendanceReportInGrid_AfterCancel");
		}
	}

	@Test(priority = 23, dataProvider = "Search_CategoryWise_AttendanceReport_Records")
	public void tcSelectCategoryFor_CategoryWiseAttendanceReport_AfterCancel(String categoryName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectCategoryFor_CategoryWiseAttendanceReport_AfterCancel Test===========");

			categorywise_attendancereport.selectCategoryFor_CategoryWiseAttendanceReport(categoryName);

			log.info(
					"============= Finished tcSelectCategoryFor_CategoryWiseAttendanceReport_AfterCancel Test===========");
			getScreenShot("tcSelectCategoryFor_CategoryWiseAttendanceReport_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectCategoryFor_CategoryWiseAttendanceReport_AfterCancel");
		}
	}
	
	@Test(priority = 24)
	public void tcValidateTotalStudentInACategory() {

		try {
			log.info("============= Strting tcValidateTotalStudentInACategory Test===========");

			categorywise_attendancereport.validateTotalStudentInACategory();

			log.info("============= Finished tcValidateTotalStudentInACategory Test===========");
			getScreenShot("tcValidateTotalStudentInACategory");
		} catch (Exception e) {
			getScreenShot("tcValidateTotalStudentInACategory");
		}
	}


	@Test(priority = 25)
	public void tcExportReport_ToDownloadExcelReport() {

		try {
			log.info("============= Strting tcExportReport_ToDownloadExcelReport Test===========");

			categorywise_attendancereport.exportReport_ToDownloadExcelReport();

			log.info("============= Finished tcExportReport_ToDownloadExcelReport Test===========");
			getScreenShot("tcExportReport_ToDownloadExcelReport");
		} catch (Exception e) {
			getScreenShot("tcExportReport_ToDownloadExcelReport");
		}
	}

	@Test(priority = 26)
	public void tcClickOnPrint_CategoryWiseReport() {

		try {
			log.info("============= Strting tcClickOnPrint_CategoryWiseReport Test===========");

			categorywise_attendancereport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_CategoryWiseReport Test===========");
			getScreenShot("tcClickOnPrint_CategoryWiseReport");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_CategoryWiseReport");
		}
	}

	@AfterClass
	public void tearDown() {
		try {
			ivrmportallogin.logOutFromApplication();
		} catch (Exception e) {

			e.printStackTrace();
		}
		driver.quit();
	}

}
