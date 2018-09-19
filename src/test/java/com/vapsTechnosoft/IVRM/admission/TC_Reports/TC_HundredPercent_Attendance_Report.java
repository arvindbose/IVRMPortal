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

import com.vapsTechnosoft.IVRM.Admission.Reports.HundredPercent_Attendance_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 * Login with Staff credentials UserName: Priya, Password: password@123
 */
public class TC_HundredPercent_Attendance_Report extends TestBase{
	public static final Logger log = Logger.getLogger(TC_HundredPercent_Attendance_Report.class.getName());

	HundredPercent_Attendance_Report percent_100_attendancereport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData_Staff")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin_Staff = getData("AdmissionReports.xlsx", "IVRM_StaffLogin_Data");
		return testRecordsLogin_Staff;
	}

	@DataProvider(name = "Reports_100Percent_AttendanceReport_All_AndIndividual")
	public String[][] getTestData() {
		String[][] testRecords = getData("AdmissionReports.xlsx", "100Percent_AttendanceReportData");
		return testRecords;
	}

	@DataProvider(name = "Search_100Percent_AttendanceReport_Records")
	public String[][] getSearchData() {
		String[][] testRecordsSearch = getData("AdmissionReports.xlsx", "Search_100Percent_Attendance");
		return testRecordsSearch;
	}

	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		percent_100_attendancereport = new HundredPercent_Attendance_Report(driver);
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

			boolean status = percent_100_attendancereport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Reports_100Present_AttendanceReport_BGHS() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_Reports_100Present_AttendanceReport_BGHS Test===========");

			percent_100_attendancereport.navigateToAdmission_Reports_100Present_AttendanceReport_BGHS();

			log.info(
					"============= Finished tcNavigateToAdmission_Reports_100Present_AttendanceReport_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Reports_100Present_AttendanceReport_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Reports_100Present_AttendanceReport_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmission_Reports_100Percent_AttendanceReport_BGHSPage() {

		try {
			log.info(
					"============= Strting tcVerifyAdmission_Reports_100Percent_AttendanceReport_BGHSPage Test===========");

			boolean status = percent_100_attendancereport.verifyAdmission_Reports_100Percent_AttendanceReport_BGHSPage();
			Assert.assertEquals(status, true);
			log.info(
					"============= Finished tcVerifyAdmission_Reports_100Percent_AttendanceReport_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmission_Reports_100Percent_AttendanceReport_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmission_Reports_100Percent_AttendanceReport_BGHSPage");
		}
	}

	@Test(priority = 5, dataProvider = "Reports_100Percent_AttendanceReport_All_AndIndividual")
	public void tcFill100Percent_AttendanceReportForm_All(String academicYear, String Class_100, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill100Percent_AttendanceReportForm_All Test===========");

			percent_100_attendancereport.fill100Percent_AttendanceReportForm_All(academicYear, Class_100, section);

			log.info("============= Finished tcFill100Percent_AttendanceReportForm_All Test===========");
			getScreenShot("tcFill100Percent_AttendanceReportForm_All");
		} catch (Exception e) {
			getScreenShot("tcFill100Percent_AttendanceReportForm_All");
		}
	}

	@Test(priority = 6)
	public void tcClickOnReport_TogetRecords_All() {

		try {
			log.info("============= Strting tcClickOnReport_TogetRecords_All Test===========");

			percent_100_attendancereport.clickOnReport_TogetRecords();

			log.info("============= Finished tcClickOnReport_TogetRecords_All Test===========");
			getScreenShot("tcClickOnReport_TogetRecords_All");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_TogetRecords_All");
		}
	}

	
	@Test(priority = 7)
	public void tcExportReport_ToDownloadExcelReport_All_WithoutSelectingRecords() {

		try {
			log.info("============= Strting tcExportReport_ToDownloadExcelReport_All_WithoutSelectingRecords Test===========");

			percent_100_attendancereport.exportReport_ToDownloadExcelReport();

			log.info("============= Finished tcExportReport_ToDownloadExcelReport_All_WithoutSelectingRecords Test===========");
			getScreenShot("tcExportReport_ToDownloadExcelReport_All_WithoutSelectingRecords");
		} catch (Exception e) {
			getScreenShot("tcExportReport_ToDownloadExcelReport_All_WithoutSelectingRecords");
		}
	}
	@Test(priority = 8)
	public void tcClickOnOkSuccessButton_ToDownloadExcelReportPopUp_WithoutSelectingRecords() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_ToDownloadExcelReportPopUp_WithoutSelectingRecords Test===========");

			percent_100_attendancereport.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_ToDownloadExcelReportPopUp_WithoutSelectingRecords Test===========");
			getScreenShot("tcClickOnOkSuccessButton_ToDownloadExcelReportPopUp_WithoutSelectingRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_ToDownloadExcelReportPopUp_WithoutSelectingRecords");
		}
	}
	@Test(priority = 9)
	public void tcClickOnPrint_ToPrintPreviewReport_WithoutSelectingRecords() {

		try {
			log.info("============= Strting tcClickOnPrint_ToPrintPreviewReport_WithoutSelectingRecords Test===========");

			percent_100_attendancereport.clickOnPrint_WithoutSelectingRecords();

			log.info("============= Finished tcClickOnPrint_ToPrintPreviewReport_WithoutSelectingRecords Test===========");
			getScreenShot("tcClickOnPrint_ToPrintPreviewReport_WithoutSelectingRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ToPrintPreviewReport_WithoutSelectingRecords");
		}
	}
	@Test(priority = 10)
	public void tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp Test===========");

			percent_100_attendancereport.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp Test===========");
			getScreenShot("tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp");
		}
	}
	@Test(priority = 11)
	public void tcMinimize_100_PercentAttendanceReport() {

		try {
			log.info("============= Strting tcMinimize_100_PercentAttendanceReport Test===========");

			percent_100_attendancereport.minimize_100_PercentAttendanceReport();
			log.info("============= Finished tcMinimize_100_PercentAttendanceReport Test===========");
			getScreenShot("tcMinimize_100_PercentAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcMinimize_100_PercentAttendanceReport");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_100_PercentAttendanceReportStudentList() {

		try {
			log.info("============= Strting tcMinimize_100_PercentAttendanceReportStudentList Test===========");

			percent_100_attendancereport.minimize_100_PercentAttendanceReportStudentList();
			log.info("============= Finished tcMinimize_100_PercentAttendanceReportStudentList Test===========");
			getScreenShot("tcMinimize_100_PercentAttendanceReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimize_100_PercentAttendanceReportStudentList");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_100_PercentAttendanceReportStudentList() {

		try {
			log.info("============= Strting tcMaximize_100_PercentAttendanceReportStudentList Test===========");

			percent_100_attendancereport.maximize_100_PercentAttendanceReportStudentList();
			log.info("============= Finished tcMaximize_100_PercentAttendanceReportStudentList Test===========");
			getScreenShot("tcMaximize_100_PercentAttendanceReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximize_100_PercentAttendanceReportStudentList");
		}
	}

	@Test(priority = 14)
	public void tcMaximize_100_PercentAttendanceReport() {

		try {
			log.info("============= Strting tcMaximize_100_PercentAttendanceReport Test===========");

			percent_100_attendancereport.maximize_100_PercentAttendanceReport();
			log.info("============= Finished tcMaximize_100_PercentAttendanceReport Test===========");
			getScreenShot("tcMaximize_100_PercentAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcMaximize_100_PercentAttendanceReport");
		}
	}
	@Test(priority = 15, dataProvider = "Search_100Percent_AttendanceReport_Records")
	public void tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid Test===========");

			percent_100_attendancereport.searchStudentToGenerateReport_From100_PercentAttendanceReportGrid(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid");
		}
	}

	@Test(priority = 16, dataProvider = "Search_100Percent_AttendanceReport_Records")
	public void tcVerifyStudent_For100_PercentAttendanceReportInGrid(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_For100_PercentAttendanceReportInGrid Test===========");

			percent_100_attendancereport.verifyStudent_For100_PercentAttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_For100_PercentAttendanceReportInGrid Test===========");
			getScreenShot("tcVerifyStudent_For100_PercentAttendanceReportInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_For100_PercentAttendanceReportInGrid");
		}
	}

	@Test(priority = 17, dataProvider = "Search_100Percent_AttendanceReport_Records")
	public void tcSelectStudentFor_100PercentAttendanceReport(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentFor_100PercentAttendanceReport Test===========");

			percent_100_attendancereport.selectStudentFor_100PercentAttendanceReport(admissionNum);

			log.info("============= Finished tcSelectStudentFor_100PercentAttendanceReport Test===========");
			getScreenShot("tcSelectStudentFor_100PercentAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentFor_100PercentAttendanceReport");
		}
	}


	@Test(priority = 18)
	public void tcClickOn_CancelButton_ToClearFilledData_All() {

		try {
			log.info("============= Strting tcClickOn_CancelButton_ToClearFilledData_All Test===========");

			percent_100_attendancereport.clickOn_CancelButton_ToClearFilledData();
			log.info("============= Finished tcClickOn_CancelButton_ToClearFilledData_All Test===========");
			getScreenShot("tcClickOn_CancelButton_ToClearFilledData_All");
		} catch (Exception e) {
			getScreenShot("tcClickOn_CancelButton_ToClearFilledData_All");
		}
	}

	@Test(priority =19, dataProvider = "Reports_100Percent_AttendanceReport_All_AndIndividual")
	public void tcFill100Percent_AttendanceReportForm_All_AfterCancel(String academicYear, String Class_100, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill100Percent_AttendanceReportForm_All_AfterCancel Test===========");

			percent_100_attendancereport.fill100Percent_AttendanceReportForm_All(academicYear, Class_100, section);

			log.info("============= Finished tcFill100Percent_AttendanceReportForm_All_AfterCancel Test===========");
			getScreenShot("tcFill100Percent_AttendanceReportForm_All_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill100Percent_AttendanceReportForm_All_AfterCancel");
		}
	}

	@Test(priority = 20)
	public void tcClickOnReport_TogetRecords_All_AfterCancel() {

		try {
			log.info("============= Strting tcClickOnReport_TogetRecords_All_AfterCancel Test===========");

			percent_100_attendancereport.clickOnReport_TogetRecords();

			log.info("============= Finished tcClickOnReport_TogetRecords_All_AfterCancel Test===========");
			getScreenShot("tcClickOnReport_TogetRecords_All_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_TogetRecords_All_AfterCancel");
		}
	}
	@Test(priority = 21, dataProvider = "Search_100Percent_AttendanceReport_Records")
	public void tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid_AfterCancel(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid_AfterCancel Test===========");

			percent_100_attendancereport.searchStudentToGenerateReport_From100_PercentAttendanceReportGrid(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid_AfterCancel Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid_AfterCancel");
		}
	}

	@Test(priority = 22, dataProvider = "Search_100Percent_AttendanceReport_Records")
	public void tcVerifyStudent_For100_PercentAttendanceReportInGrid_AfterCancel(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_For100_PercentAttendanceReportInGrid_AfterCancel Test===========");

			percent_100_attendancereport.verifyStudent_For100_PercentAttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_For100_PercentAttendanceReportInGrid_AfterCancel Test===========");
			getScreenShot("tcVerifyStudent_For100_PercentAttendanceReportInGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_For100_PercentAttendanceReportInGrid_AfterCancel");
		}
	}

	@Test(priority = 23, dataProvider = "Search_100Percent_AttendanceReport_Records")
	public void tcSelectStudentFor_100PercentAttendanceReport_AfterCancel(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentFor_100PercentAttendanceReport_AfterCancel Test===========");

			percent_100_attendancereport.selectStudentFor_100PercentAttendanceReport(admissionNum);

			log.info("============= Finished tcSelectStudentFor_100PercentAttendanceReport_AfterCancel Test===========");
			getScreenShot("tcSelectStudentFor_100PercentAttendanceReport_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentFor_100PercentAttendanceReport_AfterCancel");
		}
	}

	@Test(priority = 24)
	public void tcExportReport_ToDownloadExcelReport_All() {

		try {
			log.info("============= Strting tcExportReport_ToDownloadExcelReport_All Test===========");

			percent_100_attendancereport.exportReport_ToDownloadExcelReport();

			log.info("============= Finished tcExportReport_ToDownloadExcelReport_All Test===========");
			getScreenShot("tcExportReport_ToDownloadExcelReport_All");
		} catch (Exception e) {
			getScreenShot("tcExportReport_ToDownloadExcelReport_All");
		}
	}

	@Test(priority = 25)
	public void tcClickOnPrint_All() {

		try {
			log.info("============= Strting tcClickOnPrint_All Test===========");

			percent_100_attendancereport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_All Test===========");
			getScreenShot("tcClickOnPrint_All");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_All");
		}
	}

	@Test(priority =26, dataProvider = "Reports_100Percent_AttendanceReport_All_AndIndividual")
	public void tcFill100Percent_AttendanceReportForm_Individual(String academicYear, String Class_100, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill100Percent_AttendanceReportForm_Individual Test===========");

			percent_100_attendancereport.fill100Percent_AttendanceReportForm_Individual(academicYear, Class_100, section);

			log.info("============= Finished tcFill100Percent_AttendanceReportForm_Individual Test===========");
			getScreenShot("tcFill100Percent_AttendanceReportForm_Individual");
		} catch (Exception e) {
			getScreenShot("tcFill100Percent_AttendanceReportForm_Individual");
		}
	}

	@Test(priority = 27)
	public void tcClickOnReport_TogetRecords_Individual() {

		try {
			log.info("============= Strting tcClickOnReport_TogetRecords_Individual Test===========");

			percent_100_attendancereport.clickOnReport_TogetRecords();

			log.info("============= Finished tcClickOnReport_TogetRecords_Individual Test===========");
			getScreenShot("tcClickOnReport_TogetRecords_Individual");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_TogetRecords_Individual");
		}
	}
	@Test(priority = 28, dataProvider = "Search_100Percent_AttendanceReport_Records")
	public void tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid__Individual(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid__Individual Test===========");

			percent_100_attendancereport.searchStudentToGenerateReport_From100_PercentAttendanceReportGrid(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid__Individual Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid__Individual");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_From100_PercentAttendanceReportGrid__Individual");
		}
	}

	@Test(priority = 29, dataProvider = "Search_100Percent_AttendanceReport_Records")
	public void tcVerifyStudent_For100_PercentAttendanceReportInGrid_Individual(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_For100_PercentAttendanceReportInGrid_Individual Test===========");

			percent_100_attendancereport.verifyStudent_For100_PercentAttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_For100_PercentAttendanceReportInGrid_Individual Test===========");
			getScreenShot("tcVerifyStudent_For100_PercentAttendanceReportInGrid_Individual");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_For100_PercentAttendanceReportInGrid_Individual");
		}
	}

	@Test(priority = 30, dataProvider = "Search_100Percent_AttendanceReport_Records")
	public void tcSelectStudentFor_100PercentAttendanceReport_Individual(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentFor_100PercentAttendanceReport_Individual Test===========");

			percent_100_attendancereport.selectStudentFor_100PercentAttendanceReport(admissionNum);

			log.info("============= Finished tcSelectStudentFor_100PercentAttendanceReport_Individual Test===========");
			getScreenShot("tcSelectStudentFor_100PercentAttendanceReport_Individual");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentFor_100PercentAttendanceReport_Individual");
		}
	}

	@Test(priority = 31)
	public void tcExportReport_ToDownloadExcelReport__Individual() {

		try {
			log.info("============= Strting tcExportReport_ToDownloadExcelReport__Individual Test===========");

			percent_100_attendancereport.exportReport_ToDownloadExcelReport();

			log.info("============= Finished tcExportReport_ToDownloadExcelReport__Individual Test===========");
			getScreenShot("tcExportReport_ToDownloadExcelReport__Individual");
		} catch (Exception e) {
			getScreenShot("tcExportReport_ToDownloadExcelReport__Individual");
		}
	}

	@Test(priority = 32)
	public void tcClickOnPrint_Individual() {

		try {
			log.info("============= Strting tcClickOnPrint_Individual Test===========");

			percent_100_attendancereport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_Individual Test===========");
			getScreenShot("tcClickOnPrint_Individual");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_Individual");
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
