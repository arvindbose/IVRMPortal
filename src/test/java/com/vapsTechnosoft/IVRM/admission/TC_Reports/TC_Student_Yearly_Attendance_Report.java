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

import com.vapsTechnosoft.IVRM.Admission.Reports.Student_Yearly_Attendance_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *Login with Staff login credentials UserName: Priya Password:
 *         Password@123
 */
public class TC_Student_Yearly_Attendance_Report extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Student_Yearly_Attendance_Report.class.getName());

	Student_Yearly_Attendance_Report studentyearly_attendancereport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData_Staff")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin_Staff = getData("AdmissionReports.xlsx", "IVRM_StaffLogin_Data");
		return testRecordsLogin_Staff;
	}

	@DataProvider(name = "Reports_StudentYearly_AttendanceReport_All_AndIndividual")
	public String[][] getTestData() {
		String[][] testRecords = getData("AdmissionReports.xlsx", "StudentYearly_AttendanceData");
		return testRecords;
	}

	@DataProvider(name = "Search_StudentYearly_AttendanceReport_Records")
	public String[][] getSearchData() {
		String[][] testRecordsSearch = getData("AdmissionReports.xlsx", "Search_StudentYearly_Attendance");
		return testRecordsSearch;
	}

	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		studentyearly_attendancereport = new Student_Yearly_Attendance_Report(driver);
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

			boolean status = studentyearly_attendancereport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Reports_StudentYearly_AttendanceReport_BGHS() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_Reports_StudentYearly_AttendanceReport_BGHS Test===========");

			studentyearly_attendancereport.navigateToAdmission_Reports_StudentYearly_AttendanceReport_BGHS();

			log.info(
					"============= Finished tcNavigateToAdmission_Reports_StudentYearly_AttendanceReport_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Reports_StudentYearly_AttendanceReport_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Reports_StudentYearly_AttendanceReport_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmission_Reports_StudentYearly_AttendanceReport_BGHSPage() {

		try {
			log.info(
					"============= Strting tcVerifyAdmission_Reports_StudentYearly_AttendanceReport_BGHSPage Test===========");

			boolean status = studentyearly_attendancereport.verifyAdmission_Reports_StudentYearly_AttendanceReport_BGHSPage();
			Assert.assertEquals(status, true);
			log.info(
					"============= Finished tcVerifyAdmission_Reports_StudentYearly_AttendanceReport_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmission_Reports_StudentYearly_AttendanceReport_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmission_Reports_StudentYearly_AttendanceReport_BGHSPage");
		}
	}


	@Test(priority =5, dataProvider = "Reports_StudentYearly_AttendanceReport_All_AndIndividual")
	public void tcFillStudentYearly_AttendanceReportForm(String academicYear, String Class_Yearly, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillStudentYearly_AttendanceReportForm_Individual Test===========");

			studentyearly_attendancereport.fillStudentYearly_AttendanceReportForm(academicYear, Class_Yearly, section);

			log.info("============= Finished tcFillStudentYearly_AttendanceReportForm_Individual Test===========");
			getScreenShot("tcFillStudentYearly_AttendanceReportForm_Individual");
		} catch (Exception e) {
			getScreenShot("tcFillStudentYearly_AttendanceReportForm_Individual");
		}
	}
	@Test(priority = 6)
	public void tcClickOnReport_TogetRecords_All() {

		try {
			log.info("============= Strting tcClickOnReport_TogetRecords_All Test===========");

			studentyearly_attendancereport.clickOnReport_TogetRecords();

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

			studentyearly_attendancereport.exportReport_ToDownloadExcelReport();

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

			studentyearly_attendancereport.clickOnOkSuccessButton();

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

			studentyearly_attendancereport.clickOnPrint_WithoutSelectingRecords();

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

			studentyearly_attendancereport.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp Test===========");
			getScreenShot("tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_ToPrintPreviewReportErrorPopUp");
		}
	}
	@Test(priority = 11)
	public void tcMinimize_StudentYearly_AttendanceReport() {

		try {
			log.info("============= Strting tcMinimize_StudentYearly_AttendanceReport Test===========");

			studentyearly_attendancereport.minimize_StudentYearly_AttendanceReport();
			log.info("============= Finished tcMinimize_StudentYearly_AttendanceReport Test===========");
			getScreenShot("tcMinimize_StudentYearly_AttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentYearly_AttendanceReport");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_StudentYearly_AttendanceReportStudentList() {

		try {
			log.info("============= Strting tcMinimize_StudentYearly_AttendanceReportStudentList Test===========");

			studentyearly_attendancereport.minimize_StudentYearly_AttendanceReportStudentList();
			log.info("============= Finished tcMinimize_StudentYearly_AttendanceReportStudentList Test===========");
			getScreenShot("tcMinimize_StudentYearly_AttendanceReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentYearly_AttendanceReportStudentList");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_StudentYearly_AttendanceReportStudentList() {

		try {
			log.info("============= Strting tcMaximize_StudentYearly_AttendanceReportStudentList Test===========");

			studentyearly_attendancereport.maximize_StudentYearly_AttendanceReportStudentList();
			log.info("============= Finished tcMaximize_StudentYearly_AttendanceReportStudentList Test===========");
			getScreenShot("tcMaximize_StudentYearly_AttendanceReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentYearly_AttendanceReportStudentList");
		}
	}

	@Test(priority = 14)
	public void tcMaximize_StudentYearly_AttendanceReport() {

		try {
			log.info("============= Strting tcMaximize_StudentYearly_AttendanceReport Test===========");

			studentyearly_attendancereport.maximize_StudentYearly_AttendanceReport();
			log.info("============= Finished tcMaximize_StudentYearly_AttendanceReport Test===========");
			getScreenShot("tcMaximize_StudentYearly_AttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentYearly_AttendanceReport");
		}
	}
	@Test(priority = 15, dataProvider = "Search_StudentYearly_AttendanceReport_Records")
	public void tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid Test===========");

			studentyearly_attendancereport.searchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid");
		}
	}

	@Test(priority = 16, dataProvider = "Search_StudentYearly_AttendanceReport_Records")
	public void tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid Test===========");

			studentyearly_attendancereport.verifyStudent_ForStudentYearly_AttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid Test===========");
			getScreenShot("tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid");
		}
	}

	@Test(priority = 17, dataProvider = "Search_StudentYearly_AttendanceReport_Records")
	public void tcSelectStudentFor_StudentYearly_AttendanceReport(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentFor_StudentYearly_AttendanceReport Test===========");

			studentyearly_attendancereport.selectStudentFor_StudentYearly_AttendanceReport(admissionNum);

			log.info("============= Finished tcSelectStudentFor_StudentYearly_AttendanceReport Test===========");
			getScreenShot("tcSelectStudentFor_StudentYearly_AttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentFor_StudentYearly_AttendanceReport");
		}
	}


	@Test(priority = 18)
	public void tcClickOn_CancelButton_ToClearFilledData_All() {

		try {
			log.info("============= Strting tcClickOn_CancelButton_ToClearFilledData_All Test===========");

			studentyearly_attendancereport.clickOn_CancelButton_ToClearFilledData();
			log.info("============= Finished tcClickOn_CancelButton_ToClearFilledData_All Test===========");
			getScreenShot("tcClickOn_CancelButton_ToClearFilledData_All");
		} catch (Exception e) {
			getScreenShot("tcClickOn_CancelButton_ToClearFilledData_All");
		}
	}
//
//	@Test(priority =19, dataProvider = "Reports_StudentYearly_AttendanceReport_All_AndIndividual")
//	public void tcFillStudentYearly_AttendanceReportForm_All_AfterCancel(String academicYear, String Class_Yearly, String section, String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info("============= Strting tcFillStudentYearly_AttendanceReportForm_All_AfterCancel Test===========");
//
//			studentyearly_attendancereport.fillStudentYearly_AttendanceReportForm_All(academicYear, Class_Yearly, section);
//
//			log.info("============= Finished tcFillStudentYearly_AttendanceReportForm_All_AfterCancel Test===========");
//			getScreenShot("tcFillStudentYearly_AttendanceReportForm_All_AfterCancel");
//		} catch (Exception e) {
//			getScreenShot("tcFillStudentYearly_AttendanceReportForm_All_AfterCancel");
//		}
//	}
//
//	@Test(priority = 20)
//	public void tcClickOnReport_TogetRecords_All_AfterCancel() {
//
//		try {
//			log.info("============= Strting tcClickOnReport_TogetRecords_All_AfterCancel Test===========");
//
//			studentyearly_attendancereport.clickOnReport_TogetRecords();
//
//			log.info("============= Finished tcClickOnReport_TogetRecords_All_AfterCancel Test===========");
//			getScreenShot("tcClickOnReport_TogetRecords_All_AfterCancel");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnReport_TogetRecords_All_AfterCancel");
//		}
//	}
//	@Test(priority = 21, dataProvider = "Search_StudentYearly_AttendanceReport_Records")
//	public void tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid_AfterCancel(String admissionNum, String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info("============= Strting tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid_AfterCancel Test===========");
//
//			studentyearly_attendancereport.searchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid(admissionNum);
//
//			log.info("============= Finished tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid_AfterCancel Test===========");
//			getScreenShot("tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid_AfterCancel");
//		} catch (Exception e) {
//			getScreenShot("tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid_AfterCancel");
//		}
//	}
//
//	@Test(priority = 22, dataProvider = "Search_StudentYearly_AttendanceReport_Records")
//	public void tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid_AfterCancel(String admissionNum, String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid_AfterCancel Test===========");
//
//			studentyearly_attendancereport.verifyStudent_ForStudentYearly_AttendanceReportInGrid(admissionNum);
//
//			log.info(
//					"============= Finished tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid_AfterCancel Test===========");
//			getScreenShot("tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid_AfterCancel");
//		} catch (Exception e) {
//			getScreenShot("tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid_AfterCancel");
//		}
//	}
//
//	@Test(priority = 23, dataProvider = "Search_StudentYearly_AttendanceReport_Records")
//	public void tcSelectStudentFor_StudentYearly_AttendanceReport_AfterCancel(String admissionNum, String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info("============= Strting tcSelectStudentFor_StudentYearly_AttendanceReport_AfterCancel Test===========");
//
//			studentyearly_attendancereport.selectStudentFor_StudentYearly_AttendanceReport(admissionNum);
//
//			log.info("============= Finished tcSelectStudentFor_StudentYearly_AttendanceReport_AfterCancel Test===========");
//			getScreenShot("tcSelectStudentFor_StudentYearly_AttendanceReport_AfterCancel");
//		} catch (Exception e) {
//			getScreenShot("tcSelectStudentFor_StudentYearly_AttendanceReport_AfterCancel");
//		}
//	}
//
//	@Test(priority = 24)
//	public void tcExportReport_ToDownloadExcelReport_All() {
//
//		try {
//			log.info("============= Strting tcExportReport_ToDownloadExcelReport_All Test===========");
//
//			studentyearly_attendancereport.exportReport_ToDownloadExcelReport();
//
//			log.info("============= Finished tcExportReport_ToDownloadExcelReport_All Test===========");
//			getScreenShot("tcExportReport_ToDownloadExcelReport_All");
//		} catch (Exception e) {
//			getScreenShot("tcExportReport_ToDownloadExcelReport_All");
//		}
//	}
//
//	@Test(priority = 25)
//	public void tcClickOnPrint_All() {
//
//		try {
//			log.info("============= Strting tcClickOnPrint_All Test===========");
//
//			studentyearly_attendancereport.clickOnPrint();
//
//			log.info("============= Finished tcClickOnPrint_All Test===========");
//			getScreenShot("tcClickOnPrint_All");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnPrint_All");
//		}
//	}

	@Test(priority =26, dataProvider = "Reports_StudentYearly_AttendanceReport_All_AndIndividual")
	public void tcFillStudentYearly_AttendanceReportForm_AfterCancel(String academicYear, String Class_Yearly, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillStudentYearly_AttendanceReportForm_AfterCancel Test===========");

			studentyearly_attendancereport.fillStudentYearly_AttendanceReportForm(academicYear, Class_Yearly, section);

			log.info("============= Finished tcFillStudentYearly_AttendanceReportForm_AfterCancel Test===========");
			getScreenShot("tcFillStudentYearly_AttendanceReportForm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFillStudentYearly_AttendanceReportForm_AfterCancel");
		}
	}
	@Test(priority = 27)
	public void tcClickOnReport_TogetRecords() {

		try {
			log.info("============= Strting tcClickOnReport_TogetRecords_Individual Test===========");

			studentyearly_attendancereport.clickOnReport_TogetRecords();

			log.info("============= Finished tcClickOnReport_TogetRecords_Individual Test===========");
			getScreenShot("tcClickOnReport_TogetRecords_Individual");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_TogetRecords_Individual");
		}
	}
	@Test(priority = 28, dataProvider = "Search_StudentYearly_AttendanceReport_Records")
	public void tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid_Individual(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid_Individual Test===========");

			studentyearly_attendancereport.searchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid_Individual Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid_Individual");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_FromStudentYearly_AttendanceReportGrid_Individual");
		}
	}

	@Test(priority = 29, dataProvider = "Search_StudentYearly_AttendanceReport_Records")
	public void tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid_Individual(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid_Individual Test===========");

			studentyearly_attendancereport.verifyStudent_ForStudentYearly_AttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid_Individual Test===========");
			getScreenShot("tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid_Individual");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentYearly_AttendanceReportInGrid_Individual");
		}
	}

	@Test(priority = 30, dataProvider = "Search_StudentYearly_AttendanceReport_Records")
	public void tcSelectStudentFor_StudentYearly_AttendanceReport_Individual(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentFor_StudentYearly_AttendanceReport_Individual Test===========");

			studentyearly_attendancereport.selectStudentFor_StudentYearly_AttendanceReport(admissionNum);

			log.info("============= Finished tcSelectStudentFor_StudentYearly_AttendanceReport_Individual Test===========");
			getScreenShot("tcSelectStudentFor_StudentYearly_AttendanceReport_Individual");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentFor_StudentYearly_AttendanceReport_Individual");
		}
	}

	@Test(priority = 31)
	public void tcExportReport_ToDownloadExcelReport__Individual() {

		try {
			log.info("============= Strting tcExportReport_ToDownloadExcelReport__Individual Test===========");

			studentyearly_attendancereport.exportReport_ToDownloadExcelReport();

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

			studentyearly_attendancereport.clickOnPrint();

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
