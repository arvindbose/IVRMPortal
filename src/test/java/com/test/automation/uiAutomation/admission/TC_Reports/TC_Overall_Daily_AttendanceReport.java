/**
 * 
 */
package com.test.automation.uiAutomation.admission.TC_Reports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Admission.Reports.Overall_Daily_AttendanceReport;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *Login with Staff login credentials UserName: Priya 
 * 	Password: Password@123
 */
public class TC_Overall_Daily_AttendanceReport extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Overall_Daily_AttendanceReport.class.getName());

	Overall_Daily_AttendanceReport overalldialyattendance;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData_Staff")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("AdmissionReports.xlsx", "IVRM_StaffLogin_Data");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_OverallAttendanceReportData")
	public String[][] getTestWrittenData() {
		String[][] testRecordsOverallAttendanceReport = getData("AdmissionReports.xlsx",
				"OverallAttendanceReportData");
		return testRecordsOverallAttendanceReport;
	}

	@DataProvider(name = "Search_OverallAttendanceReportRecords")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearchDetails = getData("AdmissionReports.xlsx", "Search_RecordOverallDailyAttend");
		return testRecordsSearchDetails;
	}
	@DataProvider(name = "Search_OverallAttendance_PopUP_Absentees")
	public String[][] getTestValidationData() {
		String[][] testRecordsValidationDetails = getData("AdmissionReports.xlsx", "search_overall_absentees");
		return testRecordsValidationDetails;
	}
	
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		overalldialyattendance = new Overall_Daily_AttendanceReport(driver);
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

			boolean status = overalldialyattendance.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Reports_OverallDailyAttendanceReport_BGHS() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_Reports_OverallDailyAttendanceReport_BGHS Test===========");

			overalldialyattendance.navigateToAdmission_Reports_OverallDailyAttendanceReport_BGHS();

			log.info(
					"============= Finished tcNavigateToAdmission_Reports_OverallDailyAttendanceReport_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Reports_OverallDailyAttendanceReport_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Reports_OverallDailyAttendanceReport_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmission_Reports_OverallDailyAttendanceReport_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyAdmission_Reports_OverallDailyAttendanceReport_BGHSPage Test===========");

			boolean status = overalldialyattendance.verifyAdmission_Reports_OverallDailyAttendanceReport_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAdmission_Reports_OverallDailyAttendanceReport_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmission_Reports_OverallDailyAttendanceReport_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmission_Reports_OverallDailyAttendanceReport_BGHSPage");
		}
	}

	@Test(priority = 5, dataProvider = "Reports_OverallAttendanceReportData")
	public void tcFillOverallDailyAttendanceReportForm(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillClassWiseDailyAttendanceReportForm Test===========");

			overalldialyattendance.fillOverallDailyAttendanceReportForm(academicYear);

			log.info("============= Finished tcFillClassWiseDailyAttendanceReportForm Test===========");
			getScreenShot("tcFillClassWiseDailyAttendanceReportForm");
		} catch (Exception e) {
			getScreenShot("tcFillClassWiseDailyAttendanceReportForm");
		}
	}
	@Test(priority = 6)
	public void tcClickOn_ReportButton_ToGenerateReport() {

		try {
			log.info("============= Strting tcClickOn_ReportButton_ToGenerateReport Test===========");

			overalldialyattendance.clickOn_ReportButton_ToGenerateReport();

			log.info("============= Finished tcClickOn_ReportButton_ToGenerateReport Test===========");
			getScreenShot("tcClickOn_ReportButton_ToGenerateReport");
		} catch (Exception e) {
			getScreenShot("tcClickOn_ReportButton_ToGenerateReport");
		}
	}

	
	@Test(priority = 7)
	public void tcExportReport_WithoutSelectingRecords() {

		try {
			log.info("============= Strting tcExportReport_WithoutSelectingRecords Test===========");

			overalldialyattendance.exportReport_WithoutSelectingRecords();

			log.info("============= Finished tcExportReport_WithoutSelectingRecords Test===========");
			getScreenShot("tcExportReport_WithoutSelectingRecords");
		} catch (Exception e) {
			getScreenShot("tcExportReport_WithoutSelectingRecords");
		}
	}
	

	@Test(priority = 8)
	public void tcClickOnOkSuccessButton_ForWithoutSelectedRecordsPopUp() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_ForWithoutSelectedRecordsPopUp Test===========");

			overalldialyattendance.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_ForWithoutSelectedRecordsPopUp Test===========");
			getScreenShot("tcClickOnOkSuccessButton_ForWithoutSelectedRecordsPopUp");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_ForWithoutSelectedRecordsPopUp");
		}
	}
	@Test(priority = 9)
	public void tcMinimize_OverAllDailyAttendanceReport() {

		try {
			log.info("============= Strting tcMinimize_OverAllDailyAttendanceReport Test===========");

			overalldialyattendance.minimize_OverAllDailyAttendanceReport();

			log.info("============= Finished tcMinimize_OverAllDailyAttendanceReport Test===========");
			getScreenShot("tcMinimize_OverAllDailyAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcMinimize_OverAllDailyAttendanceReport");
		}
	}
	@Test(priority = 10)
	public void tcMinimize_OverAllDailyAttendanceReportStudentList() {

		try {
			log.info("============= Strting tcMinimize_OverAllDailyAttendanceReportStudentList Test===========");

			overalldialyattendance.minimize_OverAllDailyAttendanceReportStudentList();

			log.info("============= Finished tcMinimize_OverAllDailyAttendanceReportStudentList Test===========");
			getScreenShot("tcMinimize_OverAllDailyAttendanceReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimize_OverAllDailyAttendanceReportStudentList");
		}
	}
	@Test(priority = 11)
	public void tcMaximize_OverAllDailyAttendanceReportStudentList() {

		try {
			log.info("============= Strting tcMaximize_OverAllDailyAttendanceReportStudentList Test===========");

			overalldialyattendance.maximize_OverAllDailyAttendanceReportStudentList();

			log.info("============= Finished tcMaximize_OverAllDailyAttendanceReportStudentList Test===========");
			getScreenShot("tcMaximize_OverAllDailyAttendanceReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximize_OverAllDailyAttendanceReportStudentList");
		}
	}
	@Test(priority = 12)
	public void tcMaximize_OverAllDailyAttendanceReport() {

		try {
			log.info("============= Strting tcMaximize_OverAllDailyAttendanceReport Test===========");

			overalldialyattendance.maximize_OverAllDailyAttendanceReport();

			log.info("============= Finished tcMaximize_OverAllDailyAttendanceReport Test===========");
			getScreenShot("tcMaximize_OverAllDailyAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcMaximize_OverAllDailyAttendanceReport");
		}
	}
	@Test(priority = 13)
	public void tcClickOn_CancelButton_ToClearFilledData() {

		try {
			log.info("============= Strting tcClickOn_CancelButton_ToClearFilledData Test===========");

			overalldialyattendance.clickOn_CancelButton_ToClearFilledData();

			log.info("============= Finished tcClickOn_CancelButton_ToClearFilledData Test===========");
			getScreenShot("tcClickOn_CancelButton_ToClearFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickOn_CancelButton_ToClearFilledData");
		}
	}
	@Test(priority = 14, dataProvider = "Reports_OverallAttendanceReportData")
	public void tcFillOverallDailyAttendanceReportForm_AfterCancel(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillOverallDailyAttendanceReportForm_AfterCancel Test===========");

			overalldialyattendance.fillOverallDailyAttendanceReportForm(academicYear);

			log.info("============= Finished tcFillOverallDailyAttendanceReportForm_AfterCancel Test===========");
			getScreenShot("tcFillOverallDailyAttendanceReportForm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFillOverallDailyAttendanceReportForm_AfterCancel");
		}
	}
	@Test(priority = 15)
	public void tcClickOn_ReportButton_ToGenerateReport_AfterCancel() {

		try {
			log.info("============= Strting tcClickOn_ReportButton_ToGenerateReport_AfterCancel Test===========");

			overalldialyattendance.clickOn_ReportButton_ToGenerateReport();

			log.info("============= Finished tcClickOn_ReportButton_ToGenerateReport_AfterCancel Test===========");
			getScreenShot("tcClickOn_ReportButton_ToGenerateReport_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOn_ReportButton_ToGenerateReport_AfterCancel");
		}
	}
	@Test(priority = 16, dataProvider = "Search_OverallAttendanceReportRecords")
	public void tcSearch_ClassSectionToGenerateOverAllDailyAttendanceReport(String class_section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearch_ClassSectionToGenerateOverAllDailyAttendanceReport Test===========");

			overalldialyattendance.search_ClassSectionToGenerateOverAllDailyAttendanceReport(class_section);

			log.info("============= Finished tcSearch_ClassSectionToGenerateOverAllDailyAttendanceReport Test===========");
			getScreenShot("tcSearch_ClassSectionToGenerateOverAllDailyAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcSearch_ClassSectionToGenerateOverAllDailyAttendanceReport");
		}
	}
	@Test(priority = 17, dataProvider = "Search_OverallAttendanceReportRecords")
	public void tcSelectRecord_AndClickToview_ToGetAbsenteesAndTeacherDetails(String class_section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectRecord_AndClickToview_ToGetAbsenteesAndTeacherDetails Test===========");

			overalldialyattendance.selectRecord_AndClickToview_ToGetAbsenteesAndTeacherDetails(class_section);

			log.info("============= Finished tcSelectRecord_AndClickToview_ToGetAbsenteesAndTeacherDetails Test===========");
			getScreenShot("tcSelectRecord_AndClickToview_ToGetAbsenteesAndTeacherDetails");
		} catch (Exception e) {
			getScreenShot("tcSelectRecord_AndClickToview_ToGetAbsenteesAndTeacherDetails");
		}
	}
	@Test(priority = 18, dataProvider = "Search_OverallAttendance_PopUP_Absentees")
	public void tcSearch_Absentees_ToGenerateOverAllDailyAttendanceReport(String absentees_Name, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearch_Absentees_ToGenerateOverAllDailyAttendanceReport Test===========");

			overalldialyattendance.search_Absentees_ToGenerateOverAllDailyAttendanceReport(absentees_Name);

			log.info("============= Finished tcSearch_Absentees_ToGenerateOverAllDailyAttendanceReport Test===========");
			getScreenShot("tcSearch_Absentees_ToGenerateOverAllDailyAttendanceReport");
		} catch (Exception e) {
			getScreenShot("tcSearch_Absentees_ToGenerateOverAllDailyAttendanceReport");
		}
	}
	@Test(priority = 19, dataProvider = "Search_OverallAttendance_PopUP_Absentees")
	public void tcVerifySearchedRecords_OverallDialyAttendanceReportGrid_PopUp(String absentees_Name, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifySearchedRecords_OverallDialyAttendanceReportGrid_PopUp Test===========");

			overalldialyattendance.verifySearchedRecords_OverallDialyAttendanceReportGrid_PopUp(absentees_Name);

			log.info("============= Finished tcVerifySearchedRecords_OverallDialyAttendanceReportGrid_PopUp Test===========");
			getScreenShot("tcVerifySearchedRecords_OverallDialyAttendanceReportGrid_PopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySearchedRecords_OverallDialyAttendanceReportGrid_PopUp");
		}
	}
	@Test(priority = 20, dataProvider = "Search_OverallAttendance_PopUP_Absentees")
	public void tcSelectRecord_Absentees_ToExportAsExcelReport_PopUp(String absentees_Name, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectRecord_Absentees_ToExportAsExcelReport_PopUp Test===========");

			overalldialyattendance.selectRecord_Absentees_ToExportAsExcelReport(absentees_Name);
			log.info("============= Finished tcSelectRecord_Absentees_ToExportAsExcelReport_PopUp Test===========");
			getScreenShot("tcSelectRecord_Absentees_ToExportAsExcelReport_PopUp");
		} catch (Exception e) {
			getScreenShot("tcSelectRecord_Absentees_ToExportAsExcelReport_PopUp");
		}
	}
	@Test(priority = 21)
	public void tcExportReport_BySelectingAbsenteesName() {

		try {
			log.info("============= Strting tcExportReport_BySelectingAbsenteesName Test===========");

			overalldialyattendance.exportReport_BySelectingAbsenteesName();

			log.info("============= Finished tcExportReport_BySelectingAbsenteesName Test===========");
			getScreenShot("tcExportReport_BySelectingAbsenteesName");
		} catch (Exception e) {
			getScreenShot("tcExportReport_BySelectingAbsenteesName");
		}
	}
	@Test(priority = 22)
	public void tcClickOnCloseButton_ToCloseAbsenteesPopUp() {

		try {
			log.info("============= Strting tcClickOnCloseButton_ToCloseAbsenteesPopUp Test===========");

			overalldialyattendance.clickOnCloseButton_ToCloseAbsenteesPopUp();

			log.info("============= Finished tcClickOnCloseButton_ToCloseAbsenteesPopUp Test===========");
			getScreenShot("tcClickOnCloseButton_ToCloseAbsenteesPopUp");
		} catch (Exception e) {
			getScreenShot("tcClickOnCloseButton_ToCloseAbsenteesPopUp");
		}
	}
	
	@Test(priority = 23, dataProvider = "Search_OverallAttendanceReportRecords")
	public void tcSelectRecord_ToGenerateSelected_ClassReport(String class_section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectRecord_ToGenerateSelected_ClassReport Test===========");

			overalldialyattendance.selectRecord_ToGenerateSelected_ClassReport(class_section);

			log.info("============= Finished tcSelectRecord_ToGenerateSelected_ClassReport Test===========");
			getScreenShot("tcSelectRecord_ToGenerateSelected_ClassReport");
		} catch (Exception e) {
			getScreenShot("tcSelectRecord_ToGenerateSelected_ClassReport");
		}
	}
	
	@Test(priority = 24)
	public void tcClickOn_ExportButton_ToGenerateExcelReport() {

		try {
			log.info("============= Strting tcClickOn_ExportButton_ToGenerateExcelReport Test===========");

			overalldialyattendance.clickOn_ExportButton_ToGenerateExcelReport();

			log.info("============= Finished tcClickOn_ExportButton_ToGenerateExcelReport Test===========");
			getScreenShot("tcClickOn_ExportButton_ToGenerateExcelReport");
		} catch (Exception e) {
			getScreenShot("tcClickOn_ExportButton_ToGenerateExcelReport");
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
