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

import com.vapsTechnosoft.IVRM.Admission.Reports.ClassWise_Daily_Attendance_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author arvind
 *Login with Staff login credentials UserName: Priya Password:
 *         Password@123
 */
public class TC_ClassWise_Daily_Attendance_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_ClassWise_Daily_Attendance_Report.class.getName());

	ClassWise_Daily_Attendance_Report classwiseAttendance;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData_Staff")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("AdmissionReports.xlsx", "IVRM_StaffLogin_Data");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_ClassWiseAttendanceReportData")
	public String[][] getTestWrittenData() {
		String[][] testRecordsClassWiseAttendance = getData("AdmissionReports.xlsx",
				"ClassWiseAttendanceReportData");
		return testRecordsClassWiseAttendance;
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
		classwiseAttendance = new ClassWise_Daily_Attendance_Report(driver);
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

			boolean status = classwiseAttendance.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Reports_ClassWiseDaily_AttendanceReport() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_Reports_ClassWiseDaily_AttendanceReport Test===========");

			classwiseAttendance.navigateToAdmission_Reports_ClassWiseDaily_AttendanceReport();

			log.info(
					"============= Finished tcNavigateToAdmission_Reports_ClassWiseDaily_AttendanceReport Test===========");
			getScreenShot("tcNavigateToAdmission_Reports_ClassWiseDaily_AttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Reports_ClassWiseDaily_AttendanceReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyReports_ClassWiseDailyAttendanceReport_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyReports_ClassWiseDailyAttendanceReport_BGHSPage Test===========");

			boolean status = classwiseAttendance.verifyReports_ClassWiseDailyAttendanceReport_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyReports_ClassWiseDailyAttendanceReport_BGHSPage Test===========");
			getScreenShot("tcVerifyReports_ClassWiseDailyAttendanceReport_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyReports_ClassWiseDailyAttendanceReport_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_ClassWiseDailyAttendanceReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_ClassWiseDailyAttendanceReportForm Test===========");

			classwiseAttendance.submitBlank_ClassWiseDailyAttendanceReportForm();

			log.info("============= Finished tcSubmitBlank_ClassWiseDailyAttendanceReportForm Test===========");
			getScreenShot("tcSubmitBlank_ClassWiseDailyAttendanceReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_ClassWiseDailyAttendanceReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_ClassWiseAttendanceReportData")
	public void tcFillClassWiseDailyAttendanceReportForm(String academicYr, String class_Rep, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillClassWiseDailyAttendanceReportForm Test===========");

			classwiseAttendance.fillClassWiseDailyAttendanceReportForm(academicYr, class_Rep, section);

			log.info("============= Finished tcFillClassWiseDailyAttendanceReportForm Test===========");
			getScreenShot("tcFillClassWiseDailyAttendanceReportForm");
		} catch (Exception e) {
			getScreenShot("tcFillClassWiseDailyAttendanceReportForm");
		}
	}
	@Test(priority = 7)
	public void tcClickOnReportButtonToGenerateReport() {

		try {
			log.info("============= Strting tcClickOnReportButtonToGenerateReport Test===========");

			classwiseAttendance.clickOnReportButtonToGenerateReport();

			log.info("============= Finished tcClickOnReportButtonToGenerateReport Test===========");
			getScreenShot("tcClickOnReportButtonToGenerateReport");
		} catch (Exception e) {
			getScreenShot("tcClickOnReportButtonToGenerateReport");
		}
	}
	@Test(priority = 8)
	public void tcValidateGrid_ColumnHeader_WithExcelValue() {

		try {
			log.info("============= Strting tcValidateGrid_ColumnHeader_WithExcelValue Test===========");

			classwiseAttendance.validateGrid_ColumnHeader();

			log.info("============= Finished tcValidateGrid_ColumnHeader_WithExcelValue Test===========");
			getScreenShot("tcValidateGrid_ColumnHeader_WithExcelValue");
		} catch (Exception e) {
			getScreenShot("tcValidateGrid_ColumnHeader_WithExcelValue");
		}
	}
	@Test(priority = 9)
	public void tcMinimizeClassWiseDailyAttendance() {

		try {
			log.info("============= Strting tcMinimizeClassWiseDailyAttendance Test===========");

			classwiseAttendance.minimizeClassWiseDailyAttendance();

			log.info("============= Finished tcMinimizeClassWiseDailyAttendance Test===========");
			getScreenShot("tcMinimizeClassWiseDailyAttendance");
		} catch (Exception e) {
			getScreenShot("tcMinimizeClassWiseDailyAttendance");
		}
	}

	@Test(priority = 10)
	public void tcMinimizeClassWiseDailyAttendanceListGrid() {

		try {
			log.info("============= Strting tcMinimizeClassWiseDailyAttendanceListGrid Test===========");

			classwiseAttendance.minimizeClassWiseDailyAttendanceListGrid();

			log.info("============= Finished tcMinimizeClassWiseDailyAttendanceListGrid Test===========");
			getScreenShot("tcMinimizeClassWiseDailyAttendanceListGrid");
		} catch (Exception e) {
			getScreenShot("tcMinimizeClassWiseDailyAttendanceListGrid");
		}
	}

	@Test(priority = 11)
	public void tcMaximizeClassWiseDailyAttendance() {

		try {
			log.info("============= Strting tcMaximizeClassWiseDailyAttendance Test===========");

			classwiseAttendance.maximizeClassWiseDailyAttendance();

			log.info("============= Finished tcMaximizeClassWiseDailyAttendance Test===========");
			getScreenShot("tcMaximizeClassWiseDailyAttendance");
		} catch (Exception e) {
			getScreenShot("tcMaximizeClassWiseDailyAttendance");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeClassWiseDailyAttendanceListGrid() {

		try {
			log.info("============= Strting tcMaximizeAttendanceEntryTypeList Test===========");

			classwiseAttendance.maximizeClassWiseDailyAttendanceListGrid();

			log.info("============= Finished tcMaximizeAttendanceEntryTypeList Test===========");
			getScreenShot("tcMaximizeAttendanceEntryTypeList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeAttendanceEntryTypeList");
		}
	}
	@Test(priority = 13)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			classwiseAttendance.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton Test===========");
			getScreenShot("tcClickOnCancelButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton");
		}
	}
	@Test(priority = 14, dataProvider = "Reports_ClassWiseAttendanceReportData")
	public void tcFillClassWiseDailyAttendanceReportForm_AfterCancel(String academicYr, String class_Rep, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillClassWiseDailyAttendanceReportForm_AfterCancel Test===========");

			classwiseAttendance.fillClassWiseDailyAttendanceReportForm(academicYr, class_Rep, section);

			log.info("============= Finished tcFillClassWiseDailyAttendanceReportForm_AfterCancel Test===========");
			getScreenShot("tcFillClassWiseDailyAttendanceReportForm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFillClassWiseDailyAttendanceReportForm_AfterCancel");
		}
	}
	@Test(priority = 15)
	public void tcClickOnReportButtonToGenerateReport_AfterCancel() {

		try {
			log.info("============= Strting tcClickOnReportButtonToGenerateReport_AfterCancel Test===========");

			classwiseAttendance.clickOnReportButtonToGenerateReport();

			log.info("============= Finished tcClickOnReportButtonToGenerateReport_AfterCancel Test===========");
			getScreenShot("tcClickOnReportButtonToGenerateReport_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnReportButtonToGenerateReport_AfterCancel");
		}
	}
	@Test(priority = 16, dataProvider = "Search_ClassWiseAttendanceReportData")
	public void tcSearchWithAdmissionNumberInThe_ClasswiseAttendanceReportListGrid(String AdmissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithAdmissionNumberInThe_ClasswiseAttendanceReportListGrid Test===========");

			classwiseAttendance.searchWithAdmissionNumberInThe_ClasswiseAttendanceReportListGrid(AdmissionNum);

			log.info("============= Finished tcSearchWithAdmissionNumberInThe_ClasswiseAttendanceReportListGrid Test===========");
			getScreenShot("tcSearchWithAdmissionNumberInThe_ClasswiseAttendanceReportListGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumberInThe_ClasswiseAttendanceReportListGrid");
		}
	}
	@Test(priority = 17, dataProvider = "Search_ClassWiseAttendanceReportData")
	public void tcVerifyStudentForAttendanceIn_ClassWiseAttendanceReportListGrid(String AdmissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentForAttendanceIn_ClassWiseAttendanceReportListGrid Test===========");

			classwiseAttendance.verifyStudentForAttendanceIn_ClassWiseAttendanceReportListGrid(AdmissionNum);

			log.info("============= Finished tcVerifyStudentForAttendanceIn_ClassWiseAttendanceReportListGrid Test===========");
			getScreenShot("tcVerifyStudentForAttendanceIn_ClassWiseAttendanceReportListGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentForAttendanceIn_ClassWiseAttendanceReportListGrid");
		}
	}
	@Test(priority = 18, dataProvider = "ValidationData_ClassWiseAttendanceReportData")
	public void tcValidateStudentAttendanceStatus_And_SelectStudentToDownloadToExcel(String AdmissionNum,String attendance_Status, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcValidateStudentAttendanceStatus_And_SelectStudentToDownloadToExcel Test===========");

			classwiseAttendance.validateStudentAttendanceStatus_And_SelectStudentToDownloadToExcel(AdmissionNum, attendance_Status);

			log.info("============= Finished tcValidateStudentAttendanceStatus_And_SelectStudentToDownloadToExcel Test===========");
			getScreenShot("tcValidateStudentAttendanceStatus_And_SelectStudentToDownloadToExcel");
		} catch (Exception e) {
			getScreenShot("tcValidateStudentAttendanceStatus_And_SelectStudentToDownloadToExcel");
		}
	}
	@Test(priority = 19)
	public void tcClickOnExportButton_ToDownloadExcelReport() {

		try {
			log.info("============= Strting tcClickOnExportButton_ToDownloadExcelReport Test===========");

			classwiseAttendance.clickOnExportButton_ToDownloadExcelReport();

			log.info("============= Finished tcClickOnExportButton_ToDownloadExcelReport Test===========");
			getScreenShot("tcClickOnExportButton_ToDownloadExcelReport");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportButton_ToDownloadExcelReport");
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
