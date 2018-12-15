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

import com.vapsTechnosoft.IVRM.Admission.Reports.Student_Attendance_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 * 
 *         Login with Staff credentials UserName: Priya, Password: password@123
 *
 */
public class TC_Student_Attendance_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Student_Attendance_Report.class.getName());

	Student_Attendance_Report studentAttendanceReport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData_Staff")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin_Staff = getData("AdmissionReports.xlsx", "IVRM_StaffLogin_Data");
		return testRecordsLogin_Staff;
	}

	@DataProvider(name = "Reports_StudentAttendanceReport_AllMonthly")
	public String[][] getTestData() {
		String[][] testRecords = getData("AdmissionReports.xlsx", "StuAttendanceReport_MonthAll");
		return testRecords;
	}

	@DataProvider(name = "Search_StudentAttendanceReport")
	public String[][] getSearchData() {
		String[][] testRecordsSearch = getData("AdmissionReports.xlsx", "Search_StuAttendanceReport");
		return testRecordsSearch;
	}

	@DataProvider(name = "Reports_StudentAttendanceReport_AllBetween")
	public String[][] getTestALLBetweenData() {
		String[][] testRecordsALLBetween = getData("AdmissionReports.xlsx", "StuAttendanceReport_AllBetween");
		return testRecordsALLBetween;
	}

	@DataProvider(name = "Search_StudentAttendanceReport_AllBetween")
	public String[][] getTestDeactiveSearchData() {
		String[][] testRecordsAllBetweenSearch = getData("AdmissionReports.xlsx", "Search_StuAttendanceRepBetween");
		return testRecordsAllBetweenSearch;
	}

	@DataProvider(name = "Reports_StudentAttendanceReport_IndividualMonthly")
	public String[][] getTestIndividualMonthlyData() {
		String[][] testRecordsIndividualMonthly = getData("AdmissionReports.xlsx", "StuAttendReport_IndiviMonthly");
		return testRecordsIndividualMonthly;
	}
	@DataProvider(name = "Reports_StudentAttendanceReport_IndividualBetweenDay")
	public String[][] getTestIndividualBetweenDayData() {
		String[][] testRecordsIndividualBetweenDay = getData("AdmissionReports.xlsx", "StuAttendReport_IndiviB-WDay");
		return testRecordsIndividualBetweenDay;
	}
	@BeforeClass
	public void setUp() throws IOException {
		init();
		studentAttendanceReport = new Student_Attendance_Report(driver);
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

			boolean status = studentAttendanceReport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Reports_StudentAttendanceReport_BGHS() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_Reports_StudentAttendanceReport_BGHS Test===========");

			studentAttendanceReport.navigateToAdmission_Reports_StudentAttendanceReport_BGHS();

			log.info(
					"============= Finished tcNavigateToAdmission_Reports_StudentAttendanceReport_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Reports_StudentAttendanceReport_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Reports_StudentAttendanceReport_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmission_Reports_StudentAttendanceReport_BGHSPage() {

		try {
			log.info(
					"============= Strting tcVerifyAdmission_Reports_StudentAttendanceReport_BGHSPage Test===========");

			boolean status = studentAttendanceReport.verifyAdmission_Reports_StudentAttendanceReport_BGHSPage();
			Assert.assertEquals(status, true);
			log.info(
					"============= Finished tcVerifyAdmission_Reports_StudentAttendanceReport_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmission_Reports_StudentAttendanceReport_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmission_Reports_StudentAttendanceReport_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_StudentAttendanceReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_StudentAttendanceReportForm Test===========");

			studentAttendanceReport.submitBlank_StudentAttendanceReportForm();

			log.info("============= Finished tcSubmitBlank_StudentAttendanceReportForm Test===========");
			getScreenShot("tcSubmitBlank_StudentAttendanceReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_StudentAttendanceReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_StudentAttendanceReport_AllMonthly")
	public void tcFillWithStudentAttendanceReportDetailsFor_All_Monthly(String academicYr, String rep_class,
			String section, String month, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillWithStudentAttendanceReportDetailsFor_All_Monthly Test===========");

			studentAttendanceReport.fillWithStudentAttendanceReportDetailsFor_All_Monthly(academicYr, rep_class,
					section, month);

			log.info("============= Finished tcFillWithStudentAttendanceReportDetailsFor_All_Monthly Test===========");
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_All_Monthly");
		} catch (Exception e) {
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_All_Monthly");
		}
	}

	@Test(priority = 7)
	public void tcClickOnReport() {

		try {
			log.info("============= Strting tcClickOnReport Test===========");

			studentAttendanceReport.clickOnReport();

			log.info("============= Finished tcClickOnReport Test===========");
			getScreenShot("tcClickOnReport");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport");
		}
	}

	@Test(priority = 8, dataProvider = "Search_StudentAttendanceReport")
	public void tcSearchStudentToGenerateReport(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport Test===========");

			studentAttendanceReport.searchStudentToGenerateReport(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport Test===========");
			getScreenShot("tcSearchStudentToGenerateReport");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport");
		}
	}

	@Test(priority = 9, dataProvider = "Search_StudentAttendanceReport")
	public void tcVerifyStudent_ForStudentAttendanceReportInGrid(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudent_ForStudentAttendanceReportInGrid Test===========");

			studentAttendanceReport.verifyStudent_ForStudentAttendanceReportInGrid(admissionNum);

			log.info("============= Finished tcVerifyStudent_ForStudentAttendanceReportInGrid Test===========");
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid");
		}
	}

	@Test(priority = 10, dataProvider = "Search_StudentAttendanceReport")
	public void tcSelectStudentForStudentAttendanceReport(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForStudentAttendanceReport Test===========");

			studentAttendanceReport.selectStudentForStudentAttendanceReport(admissionNum);

			log.info("============= Finished tcSelectStudentForStudentAttendanceReport Test===========");
			getScreenShot("tcSelectStudentForStudentAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForStudentAttendanceReport");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeStudentAttendanceReport() {

		try {
			log.info("============= Strting tcMinimizeStudentAttendanceReport Test===========");

			studentAttendanceReport.minimizeStudentAttendanceReport();
			log.info("============= Finished tcMinimizeStudentAttendanceReport Test===========");
			getScreenShot("tcMinimizeStudentAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcMinimizeStudentAttendanceReport");
		}
	}

	@Test(priority = 12)
	public void tcMinimizeStudentAttendanceReportStudentList() {

		try {
			log.info("============= Strting tcMinimizeStudentAttendanceReportStudentList Test===========");

			studentAttendanceReport.minimizeStudentAttendanceReportStudentList();
			log.info("============= Finished tcMinimizeStudentAttendanceReportStudentList Test===========");
			getScreenShot("tcMinimizeStudentAttendanceReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeStudentAttendanceReportStudentList");
		}
	}

	@Test(priority = 13)
	public void tcMaximizeStudentAttendanceReportStudentList() {

		try {
			log.info("============= Strting tcMaximizeStudentAttendanceReportStudentList Test===========");

			studentAttendanceReport.maximizeStudentAttendanceReportStudentList();
			log.info("============= Finished tcMaximizeStudentAttendanceReportStudentList Test===========");
			getScreenShot("tcMaximizeStudentAttendanceReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeStudentAttendanceReportStudentList");
		}
	}

	@Test(priority = 14)
	public void tcMaximizeStudentAttendanceReport() {

		try {
			log.info("============= Strting tcMaximizeStudentAttendanceReport Test===========");

			studentAttendanceReport.maximizeStudentAttendanceReport();
			log.info("============= Finished tcMaximizeStudentAttendanceReport Test===========");
			getScreenShot("tcMaximizeStudentAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcMaximizeStudentAttendanceReport");
		}
	}

	@Test(priority = 15)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			studentAttendanceReport.clickOnCancelButton();
			log.info("============= Finished tcClickOnCancelButton Test===========");
			getScreenShot("tcClickOnCancelButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton");
		}
	}

	@Test(priority = 16, dataProvider = "Reports_StudentAttendanceReport_AllMonthly")
	public void tcFillWithStudentAttendanceReportDetailsFor_All_Monthly_AfterCancel(String academicYr, String rep_class,
			String section, String month, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillWithStudentAttendanceReportDetailsFor_All_Monthly_AfterCancel Test===========");

			studentAttendanceReport.fillWithStudentAttendanceReportDetailsFor_All_Monthly(academicYr, rep_class,
					section, month);

			log.info(
					"============= Finished tcFillWithStudentAttendanceReportDetailsFor_All_Monthly_AfterCancel Test===========");
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_All_Monthly_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_All_Monthly_AfterCancel");
		}
	}

	@Test(priority = 17)
	public void tcClickOnReport_AfterCancel() {

		try {
			log.info("============= Strting tcClickOnReport_AfterCancel Test===========");

			studentAttendanceReport.clickOnReport();

			log.info("============= Finished tcClickOnReport_AfterCancel Test===========");
			getScreenShot("tcClickOnReport_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_AfterCancel");
		}
	}

	@Test(priority = 18, dataProvider = "Search_StudentAttendanceReport")
	public void tcSearchStudentToGenerateReport_AfterCancel(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_AfterCancel Test===========");

			studentAttendanceReport.searchStudentToGenerateReport(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_AfterCancel Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_AfterCancel");
		}
	}

	@Test(priority = 19, dataProvider = "Search_StudentAttendanceReport")
	public void tcVerifyStudent_ForStudentAttendanceReportInGrid_AfterCancel(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForStudentAttendanceReportInGrid_AfterCancel Test===========");

			studentAttendanceReport.verifyStudent_ForStudentAttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForStudentAttendanceReportInGrid_AfterCancel Test===========");
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid_AfterCancel");
		}
	}

	@Test(priority = 20, dataProvider = "Search_StudentAttendanceReport")
	public void tcSelectStudentForStudentAttendanceReport_AfterCancel(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForStudentAttendanceReport_AfterCancel Test===========");

			studentAttendanceReport.selectStudentForStudentAttendanceReport(admissionNum);

			log.info("============= Finished tcSelectStudentForStudentAttendanceReport_AfterCancel Test===========");
			getScreenShot("tcSelectStudentForStudentAttendanceReport_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForStudentAttendanceReport_AfterCancel");
		}
	}

	@Test(priority = 21)
	public void tcClickOnExportToExcel_AllMonthly() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_AllMonthly Test===========");

			studentAttendanceReport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_AllMonthly Test===========");
			getScreenShot("tcClickOnExportToExcel_AllMonthly");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_AllMonthly");
		}
	}

	@Test(priority = 22)
	public void tcClickOnPrint_AllMonthly() {

		try {
			log.info("============= Strting tcClickOnPrint_AllMonthly Test===========");

			studentAttendanceReport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_AllMonthly Test===========");
			getScreenShot("tcClickOnPrint_AllMonthly");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_AllMonthly");
		}
	}

	@Test(priority = 23, dataProvider = "Reports_StudentAttendanceReport_AllMonthly")
	public void tcFillWithStudentAttendanceReportDetailsFor_All_Monthly_MonthDayWise(String academicYr,
			String rep_class, String section, String month, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillWithStudentAttendanceReportDetailsFor_All_Monthly_MonthDayWise Test===========");

			studentAttendanceReport.fillWithStudentAttendanceReportDetailsFor_All_Monthly(academicYr, rep_class,
					section, month);

			log.info(
					"============= Finished tcFillWithStudentAttendanceReportDetailsFor_All_Monthly_MonthDayWise Test===========");
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_All_Monthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_All_Monthly_MonthDayWise");
		}
	}

	@Test(priority = 24)
	public void tcSelect_MonthDateWise_CheckBox() {

		try {
			log.info("============= Strting tcSelect_MonthDateWise_CheckBox Test===========");

			studentAttendanceReport.select_MonthDateWise_CheckBox();

			log.info("============= Finished tcSelect_MonthDateWise_CheckBox Test===========");
			getScreenShot("tcSelect_MonthDateWise_CheckBox");
		} catch (Exception e) {
			getScreenShot("tcSelect_MonthDateWise_CheckBox");
		}
	}

	@Test(priority = 25)
	public void tcClickOnReport_ForMonthDayWise() {

		try {
			log.info("============= Strting tcClickOnReport_ForMonthDayWise Test===========");

			studentAttendanceReport.clickOnReport();

			log.info("============= Finished tcClickOnReport_ForMonthDayWise Test===========");
			getScreenShot("tcClickOnReport_ForMonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_ForMonthDayWise");
		}
	}

	@Test(priority = 26, dataProvider = "Search_StudentAttendanceReport")
	public void tcSearchStudentToGenerateReport_MonthDayWise(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_MonthDayWise Test===========");

			studentAttendanceReport.searchStudentToGenerateReport_MonthDayWise(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_MonthDayWise Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_MonthDayWise");
		}
	}

	@Test(priority = 27, dataProvider = "Search_StudentAttendanceReport")
	public void tcVerifyStudent_ForStudentAttendanceReportInGrid_MonthDayWise(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForStudentAttendanceReportInGrid_MonthDayWise Test===========");

			studentAttendanceReport.verifyStudent_ForStudentAttendanceReportInGrid_MonthDayWise(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForStudentAttendanceReportInGrid_MonthDayWise Test===========");
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid_MonthDayWise");
		}
	}

	@Test(priority = 28, dataProvider = "Search_StudentAttendanceReport")
	public void tcSelectStudentForStudentAttendanceReport_MonthDayWise(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForStudentAttendanceReport_MonthDayWise Test===========");

			studentAttendanceReport.selectStudentForStudentAttendanceReport_MonthDayWise(admissionNum);

			log.info("============= Finished tcSelectStudentForStudentAttendanceReport_MonthDayWise Test===========");
			getScreenShot("tcSelectStudentForStudentAttendanceReport_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForStudentAttendanceReport_MonthDayWise");
		}
	}

	@Test(priority = 29)
	public void tcClickOnExportToExcel_AllMonthly_MonthDayWise() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_AllMonthly_MonthDayWise Test===========");

			studentAttendanceReport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_AllMonthly_MonthDayWise Test===========");
			getScreenShot("tcClickOnExportToExcel_AllMonthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_AllMonthly_MonthDayWise");
		}
	}

	@Test(priority = 30)
	public void tcClickOnPrint_AllMonthly_MonthDayWise() {

		try {
			log.info("============= Strting tcClickOnPrint_AllMonthly_MonthDayWise Test===========");

			studentAttendanceReport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_AllMonthly_MonthDayWise Test===========");
			getScreenShot("tcClickOnPrint_AllMonthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_AllMonthly_MonthDayWise");
		}
	}

	@Test(priority = 31)
	public void tcClickOnCancelButton_AfterAll_Monthly() {

		try {
			log.info("============= Strting tcClickOnCancelButton_AfterAll_Monthly Test===========");

			studentAttendanceReport.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_AfterAll_Monthly Test===========");
			getScreenShot("tcClickOnCancelButton_AfterAll_Monthly");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_AfterAll_Monthly");
		}
	}

	@Test(priority = 32, dataProvider = "Reports_StudentAttendanceReport_AllBetween")
	public void tcFillWithStudentAttendanceReportDetailsFor_All_BetweenDate(String academicYr, String rep_class,
			String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillWithStudentAttendanceReportDetailsFor_All_BetweenDate Test===========");

			studentAttendanceReport.fillWithStudentAttendanceReportDetailsFor_All_BetweenDate(academicYr, rep_class,
					section);

			log.info(
					"============= Finished tcFillWithStudentAttendanceReportDetailsFor_All_BetweenDate Test===========");
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_All_BetweenDate");
		} catch (Exception e) {
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_All_BetweenDate");
		}
	}

	@Test(priority = 33)
	public void tcClickOnReport_ForAllBetweenDate() {

		try {
			log.info("============= Strting tcClickOnReport_ForAllBetweenDate Test===========");

			studentAttendanceReport.clickOnReport();

			log.info("============= Finished tcClickOnReport_ForAllBetweenDate Test===========");
			getScreenShot("tcClickOnReport_ForAllBetweenDate");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_ForAllBetweenDate");
		}
	}

	@Test(priority = 34, dataProvider = "Search_StudentAttendanceReport_AllBetween")
	public void tcSearchStudentToGenerateReport_AllBetweenDate(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_AllBetweenDate Test===========");

			studentAttendanceReport.searchStudentToGenerateReport(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_AllBetweenDate Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_AllBetweenDate");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_AllBetweenDate");
		}
	}

	@Test(priority = 35, dataProvider = "Search_StudentAttendanceReport_AllBetween")
	public void tcVerifyStudent_ForStudentAttendanceReportInGrid__AllBetweenDate(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForStudentAttendanceReportInGrid__AllBetweenDate Test===========");

			studentAttendanceReport.verifyStudent_ForStudentAttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForStudentAttendanceReportInGrid__AllBetweenDate Test===========");
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid__AllBetweenDate");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid__AllBetweenDate");
		}
	}

	@Test(priority = 36, dataProvider = "Search_StudentAttendanceReport_AllBetween")
	public void tcSelectStudentForStudentAttendanceReport_AllBetweenDate(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForStudentAttendanceReport_AllBetweenDate Test===========");

			studentAttendanceReport.selectStudentForStudentAttendanceReport(admissionNum);

			log.info("============= Finished tcSelectStudentForStudentAttendanceReport_AllBetweenDate Test===========");
			getScreenShot("tcSelectStudentForStudentAttendanceReport_AllBetweenDate");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForStudentAttendanceReport_AllBetweenDate");
		}
	}

	@Test(priority = 37)
	public void tcClickOnExportToExcel_AllBetweenDate() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_AllBetweenDate Test===========");

			studentAttendanceReport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_AllBetweenDate Test===========");
			getScreenShot("tcClickOnExportToExcel_AllBetweenDate");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_AllBetweenDate");
		}
	}

	@Test(priority = 38)
	public void tcClickOnPrint_AllBetweenDate() {

		try {
			log.info("============= Strting tcClickOnPrint_AllBetweenDate Test===========");

			studentAttendanceReport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_AllBetweenDate Test===========");
			getScreenShot("tcClickOnPrint_AllBetweenDate");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_AllBetweenDate");
		}
	}

	@Test(priority = 39)
	public void tcClickOnCancelButton_AfterAll_BetweenDate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_AfterAll_BetweenDate Test===========");

			studentAttendanceReport.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_AfterAll_BetweenDate Test===========");
			getScreenShot("tcClickOnCancelButton_AfterAll_BetweenDate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_AfterAll_BetweenDate");
		}
	}

	@Test(priority = 40, dataProvider = "Reports_StudentAttendanceReport_AllBetween")
	public void tcFillWithStudentAttendanceReportDetailsFor_All_Daily(String academicYr, String rep_class,
			String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillWithStudentAttendanceReportDetailsFor_All_Daily Test===========");

			studentAttendanceReport.fillWithStudentAttendanceReportDetailsFor_All_Daily(academicYr, rep_class, section);

			log.info("============= Finished tcFillWithStudentAttendanceReportDetailsFor_All_Daily Test===========");
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_All_Daily");
		} catch (Exception e) {
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_All_Daily");
		}
	}

	@Test(priority = 41)
	public void tcClickOnReport_ForAllDaily() {

		try {
			log.info("============= Strting tcClickOnReport_ForAllDaily Test===========");

			studentAttendanceReport.clickOnReport();

			log.info("============= Finished tcClickOnReport_ForAllDaily Test===========");
			getScreenShot("tcClickOnReport_ForAllDaily");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_ForAllDaily");
		}
	}

	@Test(priority = 42, dataProvider = "Search_StudentAttendanceReport")
	public void tcSearchStudentToGenerateReport_AllDaily(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_AllDaily Test===========");

			studentAttendanceReport.searchStudentToGenerateReport(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_AllDaily Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_AllDaily");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_AllDaily");
		}
	}

	@Test(priority = 43, dataProvider = "Search_StudentAttendanceReport")
	public void tcVerifyStudent_ForStudentAttendanceReportInGrid__AllDaily(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForStudentAttendanceReportInGrid__AllDaily Test===========");

			studentAttendanceReport.verifyStudent_ForStudentAttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForStudentAttendanceReportInGrid__AllDaily Test===========");
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid__AllDaily");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid__AllDaily");
		}
	}

	@Test(priority = 44, dataProvider = "Search_StudentAttendanceReport")
	public void tcSelectStudentForStudentAttendanceReport_AllDaily(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForStudentAttendanceReport_AllDaily Test===========");

			studentAttendanceReport.selectStudentForStudentAttendanceReport(admissionNum);

			log.info("============= Finished tcSelectStudentForStudentAttendanceReport_AllDaily Test===========");
			getScreenShot("tcSelectStudentForStudentAttendanceReport_AllDaily");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForStudentAttendanceReport_AllDaily");
		}
	}

	@Test(priority = 45)
	public void tcClickOnExportToExcel_AllDaily() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_AllDaily Test===========");

			studentAttendanceReport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_AllDaily Test===========");
			getScreenShot("tcClickOnExportToExcel_AllDaily");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_AllDaily");
		}
	}

	@Test(priority = 46)
	public void tcClickOnPrint_AllDaily() {

		try {
			log.info("============= Strting tcClickOnPrint_AllDaily Test===========");

			studentAttendanceReport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_AllDaily Test===========");
			getScreenShot("tcClickOnPrint_AllDaily");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_AllDaily");
		}
	}

	@Test(priority = 47)
	public void tcClickOnCancelButton_ForIndividual_Monthly() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ForIndividual_Monthly Test===========");

			studentAttendanceReport.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_ForIndividual_Monthly Test===========");
			getScreenShot("tcClickOnCancelButton_ForIndividual_Monthly");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ForIndividual_Monthly");
		}
	}

	@Test(priority = 48, dataProvider = "Reports_StudentAttendanceReport_IndividualMonthly")
	public void tcFillWithStudentAttendanceReportDetailsFor_Individual_Monthly(String academicYr, String rep_class,
			String section, String studentName, String month, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillWithStudentAttendanceReportDetailsFor_Individual_Monthly Test===========");

			studentAttendanceReport.fillWithStudentAttendanceReportDetailsFor_Individual_Monthly(academicYr, rep_class,
					section, studentName, month);

			log.info(
					"============= Finished tcFillWithStudentAttendanceReportDetailsFor_Individual_Monthly Test===========");
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_Individual_Monthly");
		} catch (Exception e) {
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_Individual_Monthly");
		}
	}

	@Test(priority = 49)
	public void tcClickOnReport_ForIndividual_Monthly() {

		try {
			log.info("============= Strting tcClickOnReport_ForIndividual_Monthly Test===========");

			studentAttendanceReport.clickOnReport();

			log.info("============= Finished tcClickOnReport_ForIndividual_Monthly Test===========");
			getScreenShot("tcClickOnReport_ForIndividual_Monthly");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_ForIndividual_Monthly");
		}
	}

	@Test(priority = 50, dataProvider = "Search_StudentAttendanceReport")
	public void tcSearchStudentToGenerateReport_Individual_Monthly(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_Individual_Monthly Test===========");

			studentAttendanceReport.searchStudentToGenerateReport(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_Individual_Monthly Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_Individual_Monthly");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_Individual_Monthly");
		}
	}

	@Test(priority = 51, dataProvider = "Search_StudentAttendanceReport")
	public void tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_Monthly(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_Monthly Test===========");

			studentAttendanceReport.verifyStudent_ForStudentAttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_Monthly Test===========");
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_Monthly");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_Monthly");
		}
	}

	@Test(priority = 52, dataProvider = "Search_StudentAttendanceReport")
	public void tcSelectStudentForStudentAttendanceReport_Individual_Monthly(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectStudentForStudentAttendanceReport_Individual_Monthly Test===========");

			studentAttendanceReport.selectStudentForStudentAttendanceReport(admissionNum);

			log.info(
					"============= Finished tcSelectStudentForStudentAttendanceReport_Individual_Monthly Test===========");
			getScreenShot("tcSelectStudentForStudentAttendanceReport_Individual_Monthly");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForStudentAttendanceReport_Individual_Monthly");
		}
	}

	@Test(priority = 53)
	public void tcClickOnExportToExcel_Individual_Monthly() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_Individual_Monthly Test===========");

			studentAttendanceReport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_Individual_Monthly Test===========");
			getScreenShot("tcClickOnExportToExcel_Individual_Monthly");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_Individual_Monthly");
		}
	}

	@Test(priority = 54)
	public void tcClickOnPrint_Individual_Monthly() {

		try {
			log.info("============= Strting tcClickOnPrint_Individual_Monthly Test===========");

			studentAttendanceReport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_Individual_Monthly Test===========");
			getScreenShot("tcClickOnPrint_Individual_Monthly");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_Individual_Monthly");
		}
	}

	@Test(priority = 55)
	public void tcClickOnCancelButton_ForIndividual_MonthDayWise() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ForIndividual_MonthDayWise Test===========");

			studentAttendanceReport.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_ForIndividual_MonthDayWise Test===========");
			getScreenShot("tcClickOnCancelButton_ForIndividual_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ForIndividual_MonthDayWise");
		}
	}

	@Test(priority = 56, dataProvider = "Reports_StudentAttendanceReport_IndividualMonthly")
	public void tcFillWithStudentAttendanceReportDetailsFor_Individual_Monthly_MonthDayWise(String academicYr,
			String rep_class, String section, String studentName, String month, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillWithStudentAttendanceReportDetailsFor_Individual_Monthly_MonthDayWise Test===========");

			studentAttendanceReport.fillWithStudentAttendanceReportDetailsFor_Individual_Monthly(academicYr, rep_class,
					section, studentName, month);
			log.info(
					"============= Finished tcFillWithStudentAttendanceReportDetailsFor_Individual_Monthly_MonthDayWise Test===========");
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_Individual_Monthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_Individual_Monthly_MonthDayWise");
		}
	}

	@Test(priority = 57)
	public void tcSelect_Individual_Monthly_MonthDayWise_CheckBox() {

		try {
			log.info("============= Strting tcSelect_Individual_Monthly_MonthDayWise_CheckBox Test===========");

			studentAttendanceReport.select_MonthDateWise_CheckBox();

			log.info("============= Finished tcSelect_Individual_Monthly_MonthDayWise_CheckBox Test===========");
			getScreenShot("tcSelect_Individual_Monthly_MonthDayWise_CheckBox");
		} catch (Exception e) {
			getScreenShot("tcSelect_Individual_Monthly_MonthDayWise_CheckBox");
		}
	}

	@Test(priority = 58)
	public void tcClickOnReport_Individual_Monthly_MonthDayWise() {

		try {
			log.info("============= Strting tcClickOnReport_Individual_Monthly_MonthDayWise Test===========");

			studentAttendanceReport.clickOnReport();

			log.info("============= Finished tcClickOnReport_Individual_Monthly_MonthDayWise Test===========");
			getScreenShot("tcClickOnReport_Individual_Monthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_Individual_Monthly_MonthDayWise");
		}
	}

	@Test(priority = 59, dataProvider = "Search_StudentAttendanceReport")
	public void tcSearchStudentToGenerateReport_Individual_Monthly_MonthDayWise(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchStudentToGenerateReport_Individual_Monthly_MonthDayWise Test===========");

			studentAttendanceReport.searchStudentToGenerateReport_MonthDayWise(admissionNum);

			log.info(
					"============= Finished tcSearchStudentToGenerateReport_Individual_Monthly_MonthDayWise Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_Individual_Monthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_Individual_Monthly_MonthDayWise");
		}
	}

	@Test(priority = 60, dataProvider = "Search_StudentAttendanceReport")
	public void tcVerifyStudent_ForStudentAttendanceReportInGrid_Individual_Monthly_MonthDayWise(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForStudentAttendanceReportInGrid_Individual_Monthly_MonthDayWise Test===========");

			studentAttendanceReport.verifyStudent_ForStudentAttendanceReportInGrid_MonthDayWise(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForStudentAttendanceReportInGrid_Individual_Monthly_MonthDayWise Test===========");
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid_Individual_Monthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid_Individual_Monthly_MonthDayWise");
		}
	}

	@Test(priority = 61, dataProvider = "Search_StudentAttendanceReport")
	public void tcSelectStudentForStudentAttendanceReport_Individual_Monthly_MonthDayWise(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectStudentForStudentAttendanceReport_Individual_Monthly_MonthDayWise Test===========");

			studentAttendanceReport.selectStudentForStudentAttendanceReport_MonthDayWise(admissionNum);

			log.info(
					"============= Finished tcSelectStudentForStudentAttendanceReport_Individual_Monthly_MonthDayWise Test===========");
			getScreenShot("tcSelectStudentForStudentAttendanceReport_Individual_Monthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForStudentAttendanceReport_Individual_Monthly_MonthDayWise");
		}
	}

	@Test(priority = 62)
	public void tcClickOnExportToExcel_Individual_Monthly_MonthDayWise() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_Individual_Monthly_MonthDayWise Test===========");

			studentAttendanceReport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_Individual_Monthly_MonthDayWise Test===========");
			getScreenShot("tcClickOnExportToExcel_Individual_Monthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_Individual_Monthly_MonthDayWise");
		}
	}

	@Test(priority = 63)
	public void tcClickOnPrint_Individual_Monthly_MonthDayWise() {

		try {
			log.info("============= Strting tcClickOnPrint_Individual_Monthly_MonthDayWise Test===========");

			studentAttendanceReport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_Individual_Monthly_MonthDayWise Test===========");
			getScreenShot("tcClickOnPrint_Individual_Monthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_Individual_Monthly_MonthDayWise");
		}
	}

	@Test(priority = 64)
	public void tcClickOnCancelButton_AfterIndividual_Monthly_MonthDayWise() {

		try {
			log.info(
					"============= Strting tcClickOnCancelButton_AfterIndividual_Monthly_MonthDayWise Test===========");

			studentAttendanceReport.clickOnCancelButton();

			log.info(
					"============= Finished tcClickOnCancelButton_AfterIndividual_Monthly_MonthDayWise Test===========");
			getScreenShot("tcClickOnCancelButton_AfterIndividual_Monthly_MonthDayWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_AfterIndividual_Monthly_MonthDayWise");
		}
	}

	@Test(priority = 65, dataProvider = "Reports_StudentAttendanceReport_IndividualBetweenDay")
	public void tcFillWithStudentAttendanceReportDetailsFor_Individual_BetweenDate(String academicYr, String rep_class,
			String section, String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillWithStudentAttendanceReportDetailsFor_Individual_BetweenDate Test===========");

			studentAttendanceReport.fillWithStudentAttendanceReportDetailsFor_Individual_BetweenDate(academicYr,
					rep_class, section, studentName);

			log.info(
					"============= Finished tcFillWithStudentAttendanceReportDetailsFor_Individual_BetweenDate Test===========");
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_Individual_BetweenDate");
		} catch (Exception e) {
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_Individual_BetweenDate");
		}
	}

	@Test(priority = 66)
	public void tcClickOnReport_ForIndividual_BetweenDate() {

		try {
			log.info("============= Strting tcClickOnReport_ForIndividual_BetweenDate Test===========");

			studentAttendanceReport.clickOnReport();

			log.info("============= Finished tcClickOnReport_ForIndividual_BetweenDate Test===========");
			getScreenShot("tcClickOnReport_ForIndividual_BetweenDate");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_ForIndividual_BetweenDate");
		}
	}

	@Test(priority = 67, dataProvider = "Search_StudentAttendanceReport")
	public void tcSearchStudentToGenerateReport_Individual_BetweenDate(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_Individual_BetweenDate Test===========");

			studentAttendanceReport.searchStudentToGenerateReport(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_Individual_BetweenDate Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_Individual_BetweenDate");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_Individual_BetweenDate");
		}
	}

	@Test(priority = 68, dataProvider = "Search_StudentAttendanceReport")
	public void tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_BetweenDate(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_BetweenDate Test===========");

			studentAttendanceReport.verifyStudent_ForStudentAttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_BetweenDate Test===========");
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_BetweenDate");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_BetweenDate");
		}
	}

	@Test(priority = 69, dataProvider = "Search_StudentAttendanceReport")
	public void tcSelectStudentForStudentAttendanceReport_Individual_BetweenDate(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectStudentForStudentAttendanceReport_Individual_BetweenDate Test===========");

			studentAttendanceReport.selectStudentForStudentAttendanceReport(admissionNum);

			log.info(
					"============= Finished tcSelectStudentForStudentAttendanceReport_Individual_BetweenDate Test===========");
			getScreenShot("tcSelectStudentForStudentAttendanceReport_Individual_BetweenDate");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForStudentAttendanceReport_Individual_BetweenDate");
		}
	}

	@Test(priority = 70)
	public void tcClickOnExportToExcel_Individual_BetweenDate() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_Individual_BetweenDate Test===========");

			studentAttendanceReport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_Individual_BetweenDate Test===========");
			getScreenShot("tcClickOnExportToExcel_Individual_BetweenDate");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_Individual_BetweenDate");
		}
	}

	@Test(priority = 71)
	public void tcClickOnPrint_Individual_BetweenDate() {

		try {
			log.info("============= Strting tcClickOnPrint_Individual_BetweenDate Test===========");

			studentAttendanceReport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_Individual_BetweenDate Test===========");
			getScreenShot("tcClickOnPrint_Individual_BetweenDate");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_Individual_BetweenDate");
		}
	}
	@Test(priority = 72)
	public void tcClickOnCancelButton_AfterIndividual_BetweenDate() {

		try {
			log.info(
					"============= Strting tcClickOnCancelButton_AfterIndividual_BetweenDate Test===========");

			studentAttendanceReport.clickOnCancelButton();

			log.info(
					"============= Finished tcClickOnCancelButton_AfterIndividual_BetweenDate Test===========");
			getScreenShot("tcClickOnCancelButton_AfterIndividual_BetweenDate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_AfterIndividual_BetweenDate");
		}
	}

	@Test(priority = 73, dataProvider = "Reports_StudentAttendanceReport_IndividualBetweenDay")
	public void tcFillWithStudentAttendanceReportDetailsFor_Individual_Daily(String academicYr, String rep_class,
			String section, String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillWithStudentAttendanceReportDetailsFor_Individual_Daily Test===========");

			studentAttendanceReport.fillWithStudentAttendanceReportDetailsFor_Individual_Daily(academicYr, rep_class, section, studentName);

			log.info(
					"============= Finished tcFillWithStudentAttendanceReportDetailsFor_Individual_Daily Test===========");
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_Individual_Daily");
		} catch (Exception e) {
			getScreenShot("tcFillWithStudentAttendanceReportDetailsFor_Individual_Daily");
		}
	}

	@Test(priority = 74)
	public void tcClickOnReport_ForIndividual_Daily() {

		try {
			log.info("============= Strting tcClickOnReport_ForIndividual_Daily Test===========");

			studentAttendanceReport.clickOnReport();

			log.info("============= Finished tcClickOnReport_ForIndividual_Daily Test===========");
			getScreenShot("tcClickOnReport_ForIndividual_Daily");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_ForIndividual_Daily");
		}
	}

	@Test(priority = 75, dataProvider = "Search_StudentAttendanceReport")
	public void tcSearchStudentToGenerateReport_Individual_Daily(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentToGenerateReport_Individual_Daily Test===========");

			studentAttendanceReport.searchStudentToGenerateReport(admissionNum);

			log.info("============= Finished tcSearchStudentToGenerateReport_Individual_Daily Test===========");
			getScreenShot("tcSearchStudentToGenerateReport_Individual_Daily");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentToGenerateReport_Individual_Daily");
		}
	}

	@Test(priority = 76, dataProvider = "Search_StudentAttendanceReport")
	public void tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_Daily(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_Daily Test===========");

			studentAttendanceReport.verifyStudent_ForStudentAttendanceReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_Daily Test===========");
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_Daily");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForStudentAttendanceReportInGrid__Individual_Daily");
		}
	}

	@Test(priority = 77, dataProvider = "Search_StudentAttendanceReport")
	public void tcSelectStudentForStudentAttendanceReport_Individual_Daily(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectStudentForStudentAttendanceReport_Individual_Daily Test===========");

			studentAttendanceReport.selectStudentForStudentAttendanceReport(admissionNum);

			log.info(
					"============= Finished tcSelectStudentForStudentAttendanceReport_Individual_Daily Test===========");
			getScreenShot("tcSelectStudentForStudentAttendanceReport_Individual_Daily");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForStudentAttendanceReport_Individual_Daily");
		}
	}

	@Test(priority = 78)
	public void tcClickOnExportToExcel_Individual_Daily() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_Individual_Daily Test===========");

			studentAttendanceReport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_Individual_Daily Test===========");
			getScreenShot("tcClickOnExportToExcel_Individual_Daily");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_Individual_Daily");
		}
	}

	@Test(priority = 79)
	public void tcClickOnPrint_Individual_Daily() {

		try {
			log.info("============= Strting tcClickOnPrint_Individual_Daily Test===========");

			studentAttendanceReport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_Individual_Daily Test===========");
			getScreenShot("tcClickOnPrint_Individual_Daily");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_Individual_Daily");
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
