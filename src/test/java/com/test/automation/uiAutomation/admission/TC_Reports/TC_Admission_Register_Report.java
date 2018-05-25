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

import com.test.automation.uiAutomation.Admission.Reports.Admission_Register_Report;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Admission_Register_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Admission_Register_Report.class.getName());

	Admission_Register_Report admissionregisterreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_AdmissionRegisterReport")
	public String[][] getTestData() {
		String[][] testRecordsActDeactivate = getData("AdmissionReports.xlsx", "AdmissionRegisterReport");
		return testRecordsActDeactivate;
	}

	@DataProvider(name = "Search_AdmissionRegisterReport_Present")
	public String[][] getDeactivateSearchData() {
		String[][] testRecordsPresentSearch = getData("AdmissionReports.xlsx", "AdmRegisterReportSearch_Present");
		return testRecordsPresentSearch;
	}

	@DataProvider(name = "Search_AdmissionRegisterReport_Left")
	public String[][] getTestActivateSearchData() {
		String[][] testRecordsLeftSearch = getData("AdmissionReports.xlsx", "AdmRegisterReportSearch_Left");
		return testRecordsLeftSearch;
	}

	@DataProvider(name = "Search_AdmissionRegisterReport_Deactive")
	public String[][] getTestDeactiveSearchData() {
		String[][] testRecordsDeactiveSearch = getData("AdmissionReports.xlsx", "AdmRegisterReportSearch_Deactiv");
		return testRecordsDeactiveSearch;
	}

	@DataProvider(name = "Search_AdmissionRegisterReport_NewAdmission")
	public String[][] getTestNewAdmissionSearchData() {
		String[][] testRecordsNewAdmissionSearch = getData("AdmissionReports.xlsx", "AdmRegisterReprtSearch_NewAdm");
		return testRecordsNewAdmissionSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		admissionregisterreport = new Admission_Register_Report(driver);
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

			boolean status = admissionregisterreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Reports_AdmissionRegisterReport_BGHS() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_Reports_AdmissionRegisterReport_BGHS Test===========");

			admissionregisterreport.navigateToAdmission_Reports_AdmissionRegisterReport_BGHS();

			log.info(
					"============= Finished tcNavigateToAdmission_Reports_AdmissionRegisterReport_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Reports_AdmissionRegisterReport_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Reports_AdmissionRegisterReport_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmissionReports_AdmissionRegisterReport_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyAdmissionReports_AdmissionRegisterReport_BGHSPage Test===========");

			boolean status = admissionregisterreport.verifyAdmissionReports_AdmissionRegisterReport_BGHSPage();
			Assert.assertEquals(status, true);
			log.info(
					"============= Finished tcVerifyAdmissionReports_AdmissionRegisterReport_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmissionReports_AdmissionRegisterReport_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmissionReports_AdmissionRegisterReport_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_AdmissionRegisterReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_AdmissionRegisterReportForm Test===========");

			admissionregisterreport.submitBlank_AdmissionRegisterReportForm();

			log.info("============= Finished tcSubmitBlank_AdmissionRegisterReportForm Test===========");
			getScreenShot("tcSubmitBlank_AdmissionRegisterReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_AdmissionRegisterReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_AdmissionRegisterReport")
	public void tcSelectAcademicYearForAdmissionRegister(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYearForAdmissionRegister Test===========");

			admissionregisterreport.selectAcademicYearForAdmissionRegister(academicYear);

			log.info("============= Finished tcSelectAcademicYearForAdmissionRegister Test===========");
			getScreenShot("tcSelectAcademicYearForAdmissionRegister");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearForAdmissionRegister");
		}
	}

	@Test(priority = 7)
	public void tcSelect_All_RadioButton() {

		try {
			log.info("============= Strting tcSelect_All_RadioButton Test===========");

			admissionregisterreport.select_All_RadioButton();

			log.info("============= Finished tcSelect_All_RadioButton Test===========");
			getScreenShot("tcSelect_All_RadioButton");
		} catch (Exception e) {
			getScreenShot("tcSelect_All_RadioButton");
		}
	}

	@Test(priority = 8)
	public void tcSelectAll_ClassCheckBox() {

		try {
			log.info("============= Strting tcSelectAll_ClassCheckBox Test===========");

			admissionregisterreport.selectAll_ClassCheckBox();

			log.info("============= Finished tcSelectAll_ClassCheckBox Test===========");
			getScreenShot("tcSelectAll_ClassCheckBox");
		} catch (Exception e) {
			getScreenShot("tcSelectAll_ClassCheckBox");
		}
	}

	@Test(priority = 9)
	public void tcSelectAll_StudentdetailsCheckBox() {

		try {
			log.info("============= Strting tcSelectAll_StudentdetailsCheckBox Test===========");

			admissionregisterreport.selectAll_StudentdetailsCheckBox();

			log.info("============= Finished tcSelectAll_StudentdetailsCheckBox Test===========");
			getScreenShot("tcSelectAll_StudentdetailsCheckBox");
		} catch (Exception e) {
			getScreenShot("tcSelectAll_StudentdetailsCheckBox");
		}
	}

	@Test(priority = 10)
	public void tcClickOnReport() {

		try {
			log.info("============= Strting tcClickOnReport Test===========");

			admissionregisterreport.clickOnReport();

			log.info("============= Finished tcClickOnReport Test===========");
			getScreenShot("tcClickOnReport");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeAdmissionRegisterReport() {

		try {
			log.info("============= Strting tcMinimizeAdmissionRegisterReport Test===========");

			admissionregisterreport.minimizeAdmissionRegisterReport();

			log.info("============= Finished tcMinimizeAdmissionRegisterReport Test===========");
			getScreenShot("tcMinimizeAdmissionRegisterReport");
		} catch (Exception e) {
			getScreenShot("tcMinimizeAdmissionRegisterReport");
		}
	}

	@Test(priority = 12)
	public void tcMinimizeAdmissionRegisterReportStudentList() {

		try {
			log.info("============= Strting tcMinimizeAdmissionRegisterReportStudentList Test===========");

			admissionregisterreport.minimizeAdmissionRegisterReportStudentList();

			log.info("============= Finished tcMinimizeAdmissionRegisterReportStudentList Test===========");
			getScreenShot("tcMinimizeAdmissionRegisterReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeAdmissionRegisterReportStudentList");
		}
	}

	@Test(priority = 13)
	public void tcMaximizeAdmissionRegisterReportStudentList() {

		try {
			log.info("============= Strting tcMaximizeAdmissionRegisterReportStudentList Test===========");

			admissionregisterreport.maximizeAdmissionRegisterReportStudentList();

			log.info("============= Finished tcMaximizeAdmissionRegisterReportStudentList Test===========");
			getScreenShot("tcMaximizeAdmissionRegisterReportStudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeAdmissionRegisterReportStudentList");
		}
	}

	@Test(priority = 14)
	public void tcMaximizeAdmissionRegisterReport() {

		try {
			log.info("============= Strting tcMaximizeAdmissionRegisterReport Test===========");

			admissionregisterreport.maximizeAdmissionRegisterReport();

			log.info("============= Finished tcMaximizeAdmissionRegisterReport Test===========");
			getScreenShot("tcMaximizeAdmissionRegisterReport");
		} catch (Exception e) {
			getScreenShot("tcMaximizeAdmissionRegisterReport");
		}
	}

	@Test(priority = 15)
	public void tcClickOnCancel() {

		try {
			log.info("============= Strting tcClickOnCancel Test===========");

			admissionregisterreport.clickOnCancel();

			log.info("============= Finished tcClickOnCancel Test===========");
			getScreenShot("tcClickOnCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancel");
		}
	}

	@Test(priority = 16, dataProvider = "Reports_AdmissionRegisterReport")
	public void tcSelectAcademicYearForAdmissionRegister_PresentStudent(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYearForAdmissionRegister_PresentStudent Test===========");

			admissionregisterreport.selectAcademicYearForAdmissionRegister(academicYear);

			log.info("============= Finished tcSelectAcademicYearForAdmissionRegister_PresentStudent Test===========");
			getScreenShot("tcSelectAcademicYearForAdmissionRegister_PresentStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearForAdmissionRegister_PresentStudent");
		}
	}

	@Test(priority = 17)
	public void tcSelect_Present_RadioButton() {

		try {
			log.info("============= Strting tcSelect_Present_RadioButton Test===========");

			admissionregisterreport.select_Present_RadioButton();

			log.info("============= Finished tcSelect_Present_RadioButton Test===========");
			getScreenShot("tcSelect_Present_RadioButton");
		} catch (Exception e) {
			getScreenShot("tcSelect_Present_RadioButton");
		}
	}

	@Test(priority = 18)
	public void tcSelectClass_ForAdmissionRegisterReport() {

		try {
			log.info("============= Strting tcSelectClass_ForAdmissionRegisterReport Test===========");

			admissionregisterreport.selectClass_ForAdmissionRegisterReport();

			log.info("============= Finished tcSelectClass_ForAdmissionRegisterReport Test===========");
			getScreenShot("tcSelectClass_ForAdmissionRegisterReport");
		} catch (Exception e) {
			getScreenShot("tcSelectClass_ForAdmissionRegisterReport");
		}
	}

	@Test(priority = 19)
	public void tcSelectStudentDetailsData() {

		try {
			log.info("============= Strting tcSelectStudentDetailsData Test===========");

			admissionregisterreport.selectStudentDetailsData();

			log.info("============= Finished tcSelectStudentDetailsData Test===========");
			getScreenShot("tcSelectStudentDetailsData");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentDetailsData");
		}
	}

	@Test(priority = 20)
	public void tcClickOnReport_ForPresent() {

		try {
			log.info("============= Strting tcClickOnReport_ForPresent Test===========");

			admissionregisterreport.clickOnReport();

			log.info("============= Finished tcClickOnReport_ForPresent Test===========");
			getScreenShot("tcClickOnReport_ForPresent");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_ForPresent");
		}
	}

	@Test(priority = 21, dataProvider = "Search_AdmissionRegisterReport_Present")
	public void tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_PresentStudent(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_PresentStudent Test===========");

			admissionregisterreport.searchWithAdmissionNumber_AdmissionRegisterReportStudentList(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_PresentStudent Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_PresentStudent");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_PresentStudent");
		}
	}

	@Test(priority = 22, dataProvider = "Search_AdmissionRegisterReport_Present")
	public void tcVerifyStudent_ForAdmissionRegisterReportInGrid_PresentStudent(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForAdmissionRegisterReportInGrid_PresentStudent Test===========");

			admissionregisterreport.verifyStudent_ForAdmissionRegisterReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForAdmissionRegisterReportInGrid_PresentStudent Test===========");
			getScreenShot("tcVerifyStudent_ForAdmissionRegisterReportInGrid_PresentStudent");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForAdmissionRegisterReportInGrid_PresentStudent");
		}
	}

	@Test(priority = 23, dataProvider = "Search_AdmissionRegisterReport_Present")
	public void tcSelectStudentForAdmissionRegisterReport_PresentStudent(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForAdmissionRegisterReport_PresentStudent Test===========");

			admissionregisterreport.selectStudentForAdmissionRegisterReport(admissionNum);

			log.info("============= Finished tcSelectStudentForAdmissionRegisterReport_PresentStudent Test===========");
			getScreenShot("tcSelectStudentForAdmissionRegisterReport_PresentStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForAdmissionRegisterReport_PresentStudent");
		}
	}

	@Test(priority = 24)
	public void tcClickOnExportToExcel_ForPresent() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ForPresent Test===========");

			admissionregisterreport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_ForPresent Test===========");
			getScreenShot("tcClickOnExportToExcel_ForPresent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ForPresent");
		}
	}

	@Test(priority = 25)
	public void tcClickOnPrint_ForPresent() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPresent Test===========");

			admissionregisterreport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_ForPresent Test===========");
			getScreenShot("tcClickOnPrint_ForPresent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPresent");
		}
	}

	@Test(priority = 26)
	public void tcClickOnCancel_ForLeftStudent() {

		try {
			log.info("============= Strting tcClickOnCancel_ForLeftStudent Test===========");

			admissionregisterreport.clickOnCancel();

			log.info("============= Finished tcClickOnCancel_ForLeftStudent Test===========");
			getScreenShot("tcClickOnCancel_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancel_ForLeftStudent");
		}
	}

	@Test(priority = 27, dataProvider = "Reports_AdmissionRegisterReport")
	public void tcSelectAcademicYearForAdmissionRegister_LeftStudent(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYearForAdmissionRegister_LeftStudent Test===========");

			admissionregisterreport.selectAcademicYearForAdmissionRegister(academicYear);

			log.info("============= Finished tcSelectAcademicYearForAdmissionRegister_LeftStudent Test===========");
			getScreenShot("tcSelectAcademicYearForAdmissionRegister_LeftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearForAdmissionRegister_LeftStudent");
		}
	}

	@Test(priority = 28)
	public void tcSelect_Left_RadioButton() {

		try {
			log.info("============= Strting tcSelect_Left_RadioButton Test===========");

			admissionregisterreport.select_Left_RadioButton();

			log.info("============= Finished tcSelect_Left_RadioButton Test===========");
			getScreenShot("tcSelect_Left_RadioButton");
		} catch (Exception e) {
			getScreenShot("tcSelect_Left_RadioButton");
		}
	}

	@Test(priority = 29)
	public void tcSelectClass_ForAdmissionRegisterReport_LeftStudent() {

		try {
			log.info("============= Strting tcSelectClass_ForAdmissionRegisterReport_LeftStudent Test===========");

			admissionregisterreport.selectClass_ForAdmissionRegisterReport();

			log.info("============= Finished tcSelectClass_ForAdmissionRegisterReport_LeftStudent Test===========");
			getScreenShot("tcSelectClass_ForAdmissionRegisterReport_LeftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectClass_ForAdmissionRegisterReport_LeftStudent");
		}
	}

	@Test(priority = 30)
	public void tcSelectStudentDetailsData_LeftStudent() {

		try {
			log.info("============= Strting tcSelectStudentDetailsData_LeftStudent Test===========");

			admissionregisterreport.selectStudentDetailsData();

			log.info("============= Finished tcSelectStudentDetailsData_LeftStudent Test===========");
			getScreenShot("tcSelectStudentDetailsData_LeftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentDetailsData_LeftStudent");
		}
	}

	@Test(priority = 31)
	public void tcClickOnReport_LeftStudent() {

		try {
			log.info("============= Strting tcClickOnReport_LeftStudent Test===========");

			admissionregisterreport.clickOnReport();

			log.info("============= Finished tcClickOnReport_LeftStudent Test===========");
			getScreenShot("tcClickOnReport_LeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_LeftStudent");
		}
	}

	@Test(priority = 32, dataProvider = "Search_AdmissionRegisterReport_Left")
	public void tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_LeftStudent(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_LeftStudent Test===========");

			admissionregisterreport.searchWithAdmissionNumber_AdmissionRegisterReportStudentList(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_LeftStudent Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_LeftStudent");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_LeftStudent");
		}
	}

	@Test(priority = 33, dataProvider = "Search_AdmissionRegisterReport_Left")
	public void tcVerifyStudent_ForAdmissionRegisterReportInGrid_LeftStudent(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForAdmissionRegisterReportInGrid_LeftStudent Test===========");

			admissionregisterreport.verifyStudent_ForAdmissionRegisterReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForAdmissionRegisterReportInGrid_LeftStudent Test===========");
			getScreenShot("tcVerifyStudent_ForAdmissionRegisterReportInGrid_LeftStudent");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForAdmissionRegisterReportInGrid_LeftStudent");
		}
	}

	@Test(priority = 34, dataProvider = "Search_AdmissionRegisterReport_Left")
	public void tcSelectStudentForAdmissionRegisterReport_LeftStudent(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForAdmissionRegisterReport_LeftStudent Test===========");

			admissionregisterreport.selectStudentForAdmissionRegisterReport(admissionNum);

			log.info("============= Finished tcSelectStudentForAdmissionRegisterReport_LeftStudent Test===========");
			getScreenShot("tcSelectStudentForAdmissionRegisterReport_LeftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForAdmissionRegisterReport_LeftStudent");
		}
	}

	@Test(priority = 35)
	public void tcClickOnExportToExcel_LeftStudent() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_LeftStudent Test===========");

			admissionregisterreport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_LeftStudent Test===========");
			getScreenShot("tcClickOnExportToExcel_LeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_LeftStudent");
		}
	}

	@Test(priority = 36)
	public void tcClickOnPrint_LeftStudent() {

		try {
			log.info("============= Strting tcClickOnPrint_LeftStudent Test===========");

			admissionregisterreport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_LeftStudent Test===========");
			getScreenShot("tcClickOnPrint_LeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_LeftStudent");
		}
	}

	@Test(priority = 37)
	public void tcClickOnCancel_ForDeactiveStudent() {

		try {
			log.info("============= Strting tcClickOnCancel_ForDeactiveStudent Test===========");

			admissionregisterreport.clickOnCancel();

			log.info("============= Finished tcClickOnCancel_ForDeactiveStudent Test===========");
			getScreenShot("tcClickOnCancel_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancel_ForDeactiveStudent");
		}
	}

	@Test(priority = 38, dataProvider = "Reports_AdmissionRegisterReport")
	public void tcSelectAcademicYearForAdmissionRegister_DeactiveStudent(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYearForAdmissionRegister_DeactiveStudent Test===========");

			admissionregisterreport.selectAcademicYearForAdmissionRegister(academicYear);

			log.info("============= Finished tcSelectAcademicYearForAdmissionRegister_DeactiveStudent Test===========");
			getScreenShot("tcSelectAcademicYearForAdmissionRegister_DeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearForAdmissionRegister_DeactiveStudent");
		}
	}

	@Test(priority = 39)
	public void tcSelect__Deactive_RadioButton() {

		try {
			log.info("============= Strting tcSelect__Deactive_RadioButton Test===========");

			admissionregisterreport.select_DeActive_RadioButton();

			log.info("============= Finished tcSelect__Deactive_RadioButton Test===========");
			getScreenShot("tcSelect__Deactive_RadioButton");
		} catch (Exception e) {
			getScreenShot("tcSelect__Deactive_RadioButton");
		}
	}

	@Test(priority = 40)
	public void tcSelectClass_ForAdmissionRegisterReport_DeactiveStudent() {

		try {
			log.info("============= Strting tcSelectClass_ForAdmissionRegisterReport_DeactiveStudent Test===========");

			admissionregisterreport.selectClass_ForAdmissionRegisterReport();

			log.info("============= Finished tcSelectClass_ForAdmissionRegisterReport_DeactiveStudent Test===========");
			getScreenShot("tcSelectClass_ForAdmissionRegisterReport_DeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectClass_ForAdmissionRegisterReport_DeactiveStudent");
		}
	}

	@Test(priority = 41)
	public void tcSelectStudentDetailsData_DeactiveStudent() {

		try {
			log.info("============= Strting tcSelectStudentDetailsData_DeactiveStudent Test===========");

			admissionregisterreport.selectStudentDetailsData();

			log.info("============= Finished tcSelectStudentDetailsData_DeactiveStudent Test===========");
			getScreenShot("tcSelectStudentDetailsData_DeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentDetailsData_DeactiveStudent");
		}
	}

	@Test(priority = 42)
	public void tcClickOnReport_DeactiveStudent() {

		try {
			log.info("============= Strting tcClickOnReport_DeactiveStudent Test===========");

			admissionregisterreport.clickOnReport();

			log.info("============= Finished tcClickOnReport_DeactiveStudent Test===========");
			getScreenShot("tcClickOnReport_DeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_DeactiveStudent");
		}
	}

	@Test(priority = 43, dataProvider = "Search_AdmissionRegisterReport_Deactive")
	public void tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_DeactiveStudent(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_DeactiveStudent Test===========");

			admissionregisterreport.searchWithAdmissionNumber_AdmissionRegisterReportStudentList(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_DeactiveStudent Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_DeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_DeactiveStudent");
		}
	}

	@Test(priority = 44, dataProvider = "Search_AdmissionRegisterReport_Deactive")
	public void tcVerifyStudent_ForAdmissionRegisterReportInGrid_DeactiveStudent(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForAdmissionRegisterReportInGrid_DeactiveStudent Test===========");

			admissionregisterreport.verifyStudent_ForAdmissionRegisterReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForAdmissionRegisterReportInGrid_DeactiveStudent Test===========");
			getScreenShot("tcVerifyStudent_ForAdmissionRegisterReportInGrid_DeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForAdmissionRegisterReportInGrid_DeactiveStudent");
		}
	}

	@Test(priority = 45, dataProvider = "Search_AdmissionRegisterReport_Deactive")
	public void tcSelectStudentForAdmissionRegisterReport_DeactiveStudent(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForAdmissionRegisterReport_DeactiveStudent Test===========");

			admissionregisterreport.selectStudentForAdmissionRegisterReport(admissionNum);

			log.info(
					"============= Finished tcSelectStudentForAdmissionRegisterReport_DeactiveStudent Test===========");
			getScreenShot("tcSelectStudentForAdmissionRegisterReport_DeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForAdmissionRegisterReport_DeactiveStudent");
		}
	}

	@Test(priority = 46)
	public void tcClickOnExportToExcel_DeactiveStudent() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_DeactiveStudent Test===========");

			admissionregisterreport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_DeactiveStudent Test===========");
			getScreenShot("tcClickOnExportToExcel_DeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_DeactiveStudent");
		}
	}

	@Test(priority = 47)
	public void tcClickOnPrint_DeactiveStudent() {

		try {
			log.info("============= Strting tcClickOnPrint_DeactiveStudent Test===========");

			admissionregisterreport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_DeactiveStudent Test===========");
			getScreenShot("tcClickOnPrint_DeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_DeactiveStudent");
		}
	}

	@Test(priority = 48)
	public void tcClickOnCancel_ForNewAdmission() {

		try {
			log.info("============= Strting tcClickOnCancel_ForNewAdmission Test===========");

			admissionregisterreport.clickOnCancel();

			log.info("============= Finished tcClickOnCancel_ForNewAdmission Test===========");
			getScreenShot("tcClickOnCancel_ForNewAdmission");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancel_ForNewAdmission");
		}
	}

	@Test(priority = 49, dataProvider = "Reports_AdmissionRegisterReport")
	public void tcSelectAcademicYearForAdmissionRegister_NewAdmission(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYearForAdmissionRegister_NewAdmission Test===========");

			admissionregisterreport.selectAcademicYearForAdmissionRegister(academicYear);

			log.info("============= Finished tcSelectAcademicYearForAdmissionRegister_NewAdmission Test===========");
			getScreenShot("tcSelectAcademicYearForAdmissionRegister_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearForAdmissionRegister_NewAdmission");
		}
	}

	@Test(priority = 50)
	public void tcSelect__NewAdmission_RadioButton() {

		try {
			log.info("============= Strting tcSelect__NewAdmission_RadioButton Test===========");

			admissionregisterreport.select_NewAdmission_RadioButton();

			log.info("============= Finished tcSelect__NewAdmission_RadioButton Test===========");
			getScreenShot("tcSelect__NewAdmission_RadioButton");
		} catch (Exception e) {
			getScreenShot("tcSelect__NewAdmission_RadioButton");
		}
	}

	@Test(priority = 51)
	public void tcSelectClass_ForAdmissionRegisterReport_NewAdmission() {

		try {
			log.info("============= Strting tcSelectClass_ForAdmissionRegisterReport_NewAdmission Test===========");

			admissionregisterreport.selectClass_ForAdmissionRegisterReport();

			log.info("============= Finished tcSelectClass_ForAdmissionRegisterReport_NewAdmission Test===========");
			getScreenShot("tcSelectClass_ForAdmissionRegisterReport_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcSelectClass_ForAdmissionRegisterReport_NewAdmission");
		}
	}

	@Test(priority = 52)
	public void tcSelectStudentDetailsData_NewAdmission() {

		try {
			log.info("============= Strting tcSelectStudentDetailsData_NewAdmission Test===========");

			admissionregisterreport.selectStudentDetailsData();

			log.info("============= Finished tcSelectStudentDetailsData_NewAdmission Test===========");
			getScreenShot("tcSelectStudentDetailsData_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentDetailsData_NewAdmission");
		}
	}

	@Test(priority = 53)
	public void tcClickOnReport_NewAdmission() {

		try {
			log.info("============= Strting tcClickOnReport_NewAdmission Test===========");

			admissionregisterreport.clickOnReport();

			log.info("============= Finished tcClickOnReport_NewAdmission Test===========");
			getScreenShot("tcClickOnReport_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcClickOnReport_NewAdmission");
		}
	}

	@Test(priority = 54, dataProvider = "Search_AdmissionRegisterReport_NewAdmission")
	public void tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_NewAdmission(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_NewAdmission Test===========");

			admissionregisterreport.searchWithAdmissionNumber_AdmissionRegisterReportStudentList(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_NewAdmission Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_AdmissionRegisterReportStudentList_NewAdmission");
		}
	}

	@Test(priority = 55, dataProvider = "Search_AdmissionRegisterReport_NewAdmission")
	public void tcVerifyStudent_ForAdmissionRegisterReportInGrid_NewAdmission(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForAdmissionRegisterReportInGrid_NewAdmission Test===========");

			admissionregisterreport.verifyStudent_ForAdmissionRegisterReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForAdmissionRegisterReportInGrid_NewAdmission Test===========");
			getScreenShot("tcVerifyStudent_ForAdmissionRegisterReportInGrid_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForAdmissionRegisterReportInGrid_NewAdmission");
		}
	}

	@Test(priority = 56, dataProvider = "Search_AdmissionRegisterReport_NewAdmission")
	public void tcSelectStudentForAdmissionRegisterReport_NewAdmission(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForAdmissionRegisterReport_NewAdmission Test===========");

			admissionregisterreport.selectStudentForAdmissionRegisterReport(admissionNum);

			log.info("============= Finished tcSelectStudentForAdmissionRegisterReport_NewAdmission Test===========");
			getScreenShot("tcSelectStudentForAdmissionRegisterReport_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForAdmissionRegisterReport_NewAdmission");
		}
	}

	@Test(priority = 57)
	public void tcClickOnExportToExcel_NewAdmission() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_NewAdmission Test===========");

			admissionregisterreport.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_NewAdmission Test===========");
			getScreenShot("tcClickOnExportToExcel_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_NewAdmission");
		}
	}

	@Test(priority = 58)
	public void tcClickOnPrint_NewAdmission() {

		try {
			log.info("============= Strting tcClickOnPrint_NewAdmission Test===========");

			admissionregisterreport.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_NewAdmission Test===========");
			getScreenShot("tcClickOnPrint_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_NewAdmission");
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
