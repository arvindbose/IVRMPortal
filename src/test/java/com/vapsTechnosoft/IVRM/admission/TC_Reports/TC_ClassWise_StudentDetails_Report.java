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

import com.vapsTechnosoft.IVRM.Admission.Reports.ClassWise_StudentDetails_Report;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_ClassWise_StudentDetails_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_ClassWise_StudentDetails_Report.class.getName());

	ClassWise_StudentDetails_Report classwisestudentdetails;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_ClassWiseStudentDetails")
	public String[][] getTestData() {
		String[][] testRecords = getData("AdmissionReports.xlsx", "ClassWiseStudentDetails_Data");
		return testRecords;
	}

	@DataProvider(name = "Search_ClassWiseStudentDetails")
	public String[][] getSearchData() {
		String[][] testRecordsSearch = getData("AdmissionReports.xlsx", "Search_CWSD_AdmNo");
		return testRecordsSearch;
	}

	@DataProvider(name = "Reports_ClassWiseStudentDetails_Promoted")
	public String[][] getTestPromotedData() {
		String[][] testRecordsPromoted = getData("AdmissionReports.xlsx", "ClassWiseDetails_Promoted");
		return testRecordsPromoted;
	}

	@DataProvider(name = "Search_ClassWiseStudentDetails_Promoted")
	public String[][] getSearchTotalData() {
		String[][] testRecordsPromotedSearch = getData("AdmissionReports.xlsx", "Search_CWSD_AdmNo_Promoted");
		return testRecordsPromotedSearch;
	}

	@DataProvider(name = "Reports_ClassWiseStudentDetails_YearLoss")
	public String[][] getTestYearLossData() {
		String[][] testRecordsYearLoss = getData("AdmissionReports.xlsx", "ClassWiseDetails_YearLoss");
		return testRecordsYearLoss;
	}

	@DataProvider(name = "Search_ClassWiseStudentDetails_YearLoss")
	public String[][] getSearchYearLossData() {
		String[][] testRecordsYearLossSearch = getData("AdmissionReports.xlsx", "Search_CWSD_AdmNo_YearLoss");
		return testRecordsYearLossSearch;
	}

	@DataProvider(name = "Reports_ClassWiseStudentDetails_Deactivated")
	public String[][] getTestDeactivatedData() {
		String[][] testRecordsDeactivated = getData("AdmissionReports.xlsx", "ClassWiseDetails_Deactivated");
		return testRecordsDeactivated;
	}

	@DataProvider(name = "Search_ClassWiseStudentDetails_Deactivated")
	public String[][] getSearchDeactivatedData() {
		String[][] testRecordsDeactivatedSearch = getData("AdmissionReports.xlsx", "Search_CWSD_AdmNo_Deactivated");
		return testRecordsDeactivatedSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		classwisestudentdetails = new ClassWise_StudentDetails_Report(driver);
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

			boolean status = classwisestudentdetails.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Reports_ClassWiseDetailsReport() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Reports_ClassWiseDetailsReport Test===========");

			classwisestudentdetails.navigateToAdmission_Reports_ClassWiseDetailsReport();

			log.info("============= Finished tcNavigateToAdmission_Reports_ClassWiseDetailsReport Test===========");
			getScreenShot("tcNavigateToAdmission_Reports_ClassWiseDetailsReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Reports_ClassWiseDetailsReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmissionReports_ClassWiseDetailsReport_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyAdmissionReports_ClassWiseDetailsReport_BGHSPage Test===========");

			boolean status = classwisestudentdetails.verifyAdmissionReports_ClassWiseDetailsReport_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAdmissionReports_ClassWiseDetailsReport_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmissionReports_ClassWiseDetailsReport_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmissionReports_ClassWiseDetailsReport_BGHSPage ");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_ClassWiseDetailsReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_ClassWiseDetailsReportForm Test===========");

			classwisestudentdetails.submitBlank_ClassWiseDetailsReportForm();

			log.info("============= Finished tcSubmitBlank_ClassWiseDetailsReportForm Test===========");
			getScreenShot("tcSubmitBlank_ClassWiseDetailsReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_ClassWiseDetailsReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_ClassWiseStudentDetails")
	public void tcFillClassWiseDetailsReport_Form_ForNewAdmission(String academicYear, String Class_CWD, String Section,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillClassWiseDetailsReport_Form_ForNewAdmission Test===========");

			classwisestudentdetails.fillClassWiseDetailsReport_Form_ForNewAdmission(academicYear, Class_CWD, Section);

			log.info("============= Finished tcFillClassWiseDetailsReport_Form_ForNewAdmission Test===========");
			getScreenShot("tcFillClassWiseDetailsReport_Form_ForNewAdmission");
		} catch (Exception e) {
			getScreenShot("tcFillClassWiseDetailsReport_Form_ForNewAdmission");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_ClassWiseStudentDetailsReport() {

		try {
			log.info("============= Strting tcClickReport_ToGenerate_ClassWiseStudentDetailsReport Test===========");

			classwisestudentdetails.clickReport_ToGenerate_ClassWiseStudentDetailsReport();

			log.info("============= Finished tcClickReport_ToGenerate_ClassWiseStudentDetailsReport Test===========");
			getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport");
		}
	}

	@Test(priority = 8)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport Test===========");

			classwisestudentdetails.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport");
		}
	}

	@Test(priority = 9)
	public void tcClickOnOkButton_ToHandleExportToExcelPopUp() {

		try {
			log.info("============= Strting tcClickOnOkButton_ToHandleExportToExcelPopUp Test===========");

			classwisestudentdetails.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkButton_ToHandleExportToExcelPopUp Test===========");
			getScreenShot("tcClickOnOkButton_ToHandleExportToExcelPopUp");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButton_ToHandleExportToExcelPopUp");
		}
	}

	@Test(priority = 10)
	public void tcClickOnPrint_ForPrintPreview_WithoutSelectingRecord() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_WithoutSelectingRecord Test===========");

			classwisestudentdetails.clickOnPrintButton();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_WithoutSelectingRecord Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_WithoutSelectingRecord");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_WithoutSelectingRecord");
		}
	}

	@Test(priority = 11)
	public void tcClickOnOkButton_ToHandlePrintPreviewPopUp() {

		try {
			log.info("============= Strting tcClickOnOkButton_ToHandlePrintPreviewPopUp Test===========");

			classwisestudentdetails.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkButton_ToHandlePrintPreviewPopUp Test===========");
			getScreenShot("tcClickOnOkButton_ToHandlePrintPreviewPopUp");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButton_ToHandlePrintPreviewPopUp");
		}
	}

	@Test(priority = 12, dataProvider = "Search_ClassWiseStudentDetails")
	public void tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid Test===========");

			classwisestudentdetails.searchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid");
		}
	}

	@Test(priority = 13, dataProvider = "Search_ClassWiseStudentDetails")
	public void tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid Test===========");

			classwisestudentdetails.verifyStudent_ForClassWiseStudentDetailsReportInGrid(admissionNum);

			log.info("============= Finished tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid Test===========");
			getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid");
		}
	}

	@Test(priority = 14, dataProvider = "Search_ClassWiseStudentDetails")
	public void tcSelectStudentForClassWiseStudentDetailsReport(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForClassWiseStudentDetailsReport Test===========");

			classwisestudentdetails.selectStudentForClassWiseStudentDetailsReport(admissionNum);

			log.info("============= Finished tcSelectStudentForClassWiseStudentDetailsReport Test===========");
			getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport");
		}
	}

	@Test(priority = 15)
	public void tcMinimizeClassWiseStudentDetailsReportForm() {

		try {
			log.info("============= Strting tcMinimizeClassWiseStudentDetailsReportForm Test===========");

			classwisestudentdetails.min_Max_ClassWiseStudentDetailsReport_Form();

			log.info("============= Finished tcMinimizeClassWiseStudentDetailsReportForm Test===========");
			getScreenShot("tcMinimizeClassWiseStudentDetailsReportForm");
		} catch (Exception e) {
			getScreenShot("tcMinimizeClassWiseStudentDetailsReportForm");
		}
	}

	@Test(priority = 16)
	public void tcMinimizeClassWiseStudentDetailsReportGrid() {

		try {
			log.info("============= Strting tcMinimizeClassWiseStudentDetailsReportGrid Test===========");

			classwisestudentdetails.min_Max_ClassWiseStudentDetailsReport_Grid();

			log.info("============= Finished tcMinimizeClassWiseStudentDetailsReportGrid Test===========");
			getScreenShot("tcMinimizeClassWiseStudentDetailsReportGrid");
		} catch (Exception e) {
			getScreenShot("tcMinimizeClassWiseStudentDetailsReportGrid");
		}
	}

	@Test(priority = 17)
	public void tcMaximizeClassWiseStudentDetailsReportGrid() {

		try {
			log.info("============= Strting tcMaximizeClassWiseStudentDetailsReportGrid Test===========");

			classwisestudentdetails.min_Max_ClassWiseStudentDetailsReport_Grid();

			log.info("============= Finished tcMaximizeClassWiseStudentDetailsReportGrid Test===========");
			getScreenShot("tcMaximizeClassWiseStudentDetailsReportGrid");
		} catch (Exception e) {
			getScreenShot("tcMaximizeClassWiseStudentDetailsReportGrid");
		}
	}

	@Test(priority = 18)
	public void tcMaximizeClassWiseStudentDetailsReportForm() {

		try {
			log.info("============= Strting tcMaximizeClassWiseStudentDetailsReportForm Test===========");

			classwisestudentdetails.min_Max_ClassWiseStudentDetailsReport_Form();

			log.info("============= Finished tcMaximizeClassWiseStudentDetailsReportForm Test===========");
			getScreenShot("tcMaximizeClassWiseStudentDetailsReportForm");
		} catch (Exception e) {
			getScreenShot("tcMaximizeClassWiseStudentDetailsReportForm");
		}
	}

	@Test(priority = 19)
	public void tcClickCancelButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm Test===========");

			classwisestudentdetails.clickCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickCancelButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		}
	}

	@Test(priority = 20, dataProvider = "Reports_ClassWiseStudentDetails")
	public void tcFillClassWiseDetailsReport_Form_ForNewAdmission_AfterCancel(String academicYear, String Class_CWD,
			String Section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillClassWiseDetailsReport_Form_ForNewAdmission_AfterCancel Test===========");

			classwisestudentdetails.fillClassWiseDetailsReport_Form_ForNewAdmission(academicYear, Class_CWD, Section);

			log.info(
					"============= Finished tcFillClassWiseDetailsReport_Form_ForNewAdmission_AfterCancel Test===========");
			getScreenShot("tcFillClassWiseDetailsReport_Form_ForNewAdmission_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFillClassWiseDetailsReport_Form_ForNewAdmission_AfterCancel");
		}
	}

	@Test(priority = 21)
	public void tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_AfterCancel Test===========");

			classwisestudentdetails.clickReport_ToGenerate_ClassWiseStudentDetailsReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_AfterCancel Test===========");
			getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_AfterCancel");
		}
	}

	@Test(priority = 22, dataProvider = "Search_ClassWiseStudentDetails")
	public void tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_NewAdmission(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_NewAdmission Test===========");

			classwisestudentdetails.searchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_NewAdmission Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_NewAdmission");
		}
	}

	@Test(priority = 23, dataProvider = "Search_ClassWiseStudentDetails")
	public void tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_NewAdmission(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_NewAdmission Test===========");

			classwisestudentdetails.verifyStudent_ForClassWiseStudentDetailsReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_NewAdmission Test===========");
			getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_NewAdmission");
		}
	}

	@Test(priority = 24, dataProvider = "Search_ClassWiseStudentDetails")
	public void tcSelectStudentForClassWiseStudentDetailsReport_NewAdmission(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectStudentForClassWiseStudentDetailsReport_NewAdmission Test===========");

			classwisestudentdetails.selectStudentForClassWiseStudentDetailsReport(admissionNum);

			log.info(
					"============= Finished tcSelectStudentForClassWiseStudentDetailsReport_NewAdmission Test===========");
			getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport_NewAdmission");
		}
	}

	@Test(priority = 25)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_NewAdmission() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_NewAdmission Test===========");

			classwisestudentdetails.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_NewAdmission Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_NewAdmission");
		}
	}

	@Test(priority = 26)
	public void tcClickOnPrint_ForPrintPreview_NewAdmission() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_NewAdmission Test===========");

			classwisestudentdetails.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_NewAdmission Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_NewAdmission");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_NewAdmission");
		}
	}

	@Test(priority = 27)
	public void tcClickCancelButton_ToClearFilledForm_ForTotalStudentAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ForTotalStudentAction Test===========");

			classwisestudentdetails.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ForTotalStudentAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForTotalStudentAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForTotalStudentAction");
		}
	}

	@Test(priority = 28, dataProvider = "Reports_ClassWiseStudentDetails")
	public void tcFillClassWiseDetailsReport_Form_ForTotalStudents(String academicYear, String Class_CWD,
			String Section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillClassWiseDetailsReport_Form_ForTotalStudents Test===========");

			classwisestudentdetails.fillClassWiseDetailsReport_Form_ForTotalStudent(academicYear, Class_CWD, Section);

			log.info("============= Finished tcFillClassWiseDetailsReport_Form_ForTotalStudents Test===========");
			getScreenShot("tcFillClassWiseDetailsReport_Form_ForTotalStudents");
		} catch (Exception e) {
			getScreenShot("tcFillClassWiseDetailsReport_Form_ForTotalStudents");
		}
	}

	@Test(priority = 29)
	public void tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_TotalStudents() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_TotalStudents Test===========");

			classwisestudentdetails.clickReport_ToGenerate_ClassWiseStudentDetailsReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_TotalStudents Test===========");
			getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_TotalStudents");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_TotalStudents");
		}
	}

	@Test(priority = 30, dataProvider = "Search_ClassWiseStudentDetails")
	public void tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_TotalStudents(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_TotalStudents Test===========");

			classwisestudentdetails.searchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_TotalStudents Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_TotalStudents");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_TotalStudents");
		}
	}

	@Test(priority = 31, dataProvider = "Search_ClassWiseStudentDetails")
	public void tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_TotalStudents(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_TotalStudents Test===========");

			classwisestudentdetails.verifyStudent_ForClassWiseStudentDetailsReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_TotalStudents Test===========");
			getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_TotalStudents");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_TotalStudents");
		}
	}

	@Test(priority = 32, dataProvider = "Search_ClassWiseStudentDetails")
	public void tcSelectStudentForClassWiseStudentDetailsReport_TotalStudents(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectStudentForClassWiseStudentDetailsReport_TotalStudents Test===========");

			classwisestudentdetails.selectStudentForClassWiseStudentDetailsReport(admissionNum);

			log.info(
					"============= Finished tcSelectStudentForClassWiseStudentDetailsReport_TotalStudents Test===========");
			getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport_TotalStudents");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport_TotalStudents");
		}
	}

	@Test(priority = 33)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_TotalStudents() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_TotalStudents Test===========");

			classwisestudentdetails.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_TotalStudents Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_TotalStudents");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_TotalStudents");
		}
	}

	@Test(priority = 34)
	public void tcClickOnPrint_ForPrintPreview_TotalStudents() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_TotalStudents Test===========");

			classwisestudentdetails.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_TotalStudents Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_TotalStudents");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_TotalStudents");
		}
	}
	// @Test(priority = 35)
	// public void tcClickCancelButton_ToClearFilledForm_ForPromotedAction() {
	//
	// try {
	// log.info("============= Strting
	// tcClickCancelButton_ToClearFilledForm_ForPromotedAction
	// Test===========");
	//
	// classwisestudentdetails.clickCancelButton_ToClearFilledForm();
	//
	// log.info("============= Finished
	// tcClickCancelButton_ToClearFilledForm_ForPromotedAction
	// Test===========");
	// getScreenShot("tcClickCancelButton_ToClearFilledForm_ForPromotedAction");
	// } catch (Exception e) {
	// getScreenShot("tcClickCancelButton_ToClearFilledForm_ForPromotedAction");
	// }
	// }
	// @Test(priority = 36, dataProvider =
	// "Reports_ClassWiseStudentDetails_Promoted")
	// public void tcFillClassWiseDetailsReport_Form_ForPromoted(String
	// academicYear, String Class_CWD, String Section, String runMode) {
	// if (runMode.equalsIgnoreCase("n")) {
	// throw new SkipException("user marked this record as no run");
	// }
	// try {
	// log.info("============= Strting
	// tcFillClassWiseDetailsReport_Form_ForPromoted Test===========");
	//
	// classwisestudentdetails.fillClassWiseDetailsReport_Form_ForPromoted(academicYear,
	// Class_CWD, Section);
	//
	// log.info("============= Finished
	// tcFillClassWiseDetailsReport_Form_ForPromoted Test===========");
	// getScreenShot("tcFillClassWiseDetailsReport_Form_ForPromoted");
	// } catch (Exception e) {
	// getScreenShot("tcFillClassWiseDetailsReport_Form_ForPromoted");
	// }
	// }
	//
	// @Test(priority = 37)
	// public void
	// tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_Promoted() {
	//
	// try {
	// log.info("============= Strting
	// tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_Promoted
	// Test===========");
	//
	// classwisestudentdetails.clickReport_ToGenerate_ClassWiseStudentDetailsReport();
	//
	// log.info("============= Finished
	// tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_Promoted
	// Test===========");
	// getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_Promoted");
	// } catch (Exception e) {
	// getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_Promoted");
	// }
	// }
	// @Test(priority = 38, dataProvider =
	// "Search_ClassWiseStudentDetails_Promoted")
	// public void
	// tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_Promoted(String
	// admissionNum, String runMode) {
	// if (runMode.equalsIgnoreCase("n")) {
	// throw new SkipException("user marked this record as no run");
	// }
	// try {
	// log.info("============= Strting
	// tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_Promoted
	// Test===========");
	//
	// classwisestudentdetails.searchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid(admissionNum);
	//
	// log.info("============= Finished
	// tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_Promoted
	// Test===========");
	// getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_Promoted");
	// } catch (Exception e) {
	// getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_Promoted");
	// }
	// }
	//
	// @Test(priority = 39, dataProvider =
	// "Search_ClassWiseStudentDetails_Promoted")
	// public void
	// tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_Promoted(String
	// admissionNum, String runMode) {
	// if (runMode.equalsIgnoreCase("n")) {
	// throw new SkipException("user marked this record as no run");
	// }
	// try {
	// log.info("============= Strting
	// tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_Promoted
	// Test===========");
	//
	// classwisestudentdetails.verifyStudent_ForClassWiseStudentDetailsReportInGrid(admissionNum);
	//
	// log.info("============= Finished
	// tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_Promoted
	// Test===========");
	// getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_Promoted");
	// } catch (Exception e) {
	// getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_Promoted");
	// }
	// }
	// @Test(priority = 40, dataProvider =
	// "Search_ClassWiseStudentDetails_Promoted")
	// public void
	// tcSelectStudentForClassWiseStudentDetailsReport_Promoted(String
	// admissionNum, String runMode) {
	// if (runMode.equalsIgnoreCase("n")) {
	// throw new SkipException("user marked this record as no run");
	// }
	// try {
	// log.info("============= Strting
	// tcSelectStudentForClassWiseStudentDetailsReport_Promoted
	// Test===========");
	//
	// classwisestudentdetails.selectStudentForClassWiseStudentDetailsReport(admissionNum);
	//
	// log.info("============= Finished
	// tcSelectStudentForClassWiseStudentDetailsReport_Promoted
	// Test===========");
	// getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport_Promoted");
	// } catch (Exception e) {
	// getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport_Promoted");
	// }
	// }
	//
	// @Test(priority = 41)
	// public void tcClickOnExportToExcel_ToDownLoadExcelReport_Promoted() {
	//
	// try {
	// log.info("============= Strting
	// tcClickOnExportToExcel_ToDownLoadExcelReport_Promoted Test===========");
	//
	// classwisestudentdetails.clickOnExportToExcel_ToDownLoadExcelReport();
	//
	// log.info("============= Finished
	// tcClickOnExportToExcel_ToDownLoadExcelReport_Promoted Test===========");
	// getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Promoted");
	// } catch (Exception e) {
	// getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Promoted");
	// }
	// }
	// @Test(priority = 42)
	// public void tcClickOnPrint_ForPrintPreview_Promoted() {
	//
	// try {
	// log.info("============= Strting tcClickOnPrint_ForPrintPreview_Promoted
	// Test===========");
	//
	// classwisestudentdetails.clickOnPrint_ForPrintPreview();
	//
	// log.info("============= Finished tcClickOnPrint_ForPrintPreview_Promoted
	// Test===========");
	// getScreenShot("tcClickOnPrint_ForPrintPreview_Promoted");
	// } catch (Exception e) {
	// getScreenShot("tcClickOnPrint_ForPrintPreview_Promoted");
	// }
	// }

	@Test(priority = 43)
	public void tcClickCancelButton_ToClearFilledForm_ForYearLossAction() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm_ForYearLossAction Test===========");

			classwisestudentdetails.clickCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickCancelButton_ToClearFilledForm_ForYearLossAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForYearLossAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForYearLossAction");
		}
	}

	@Test(priority = 44, dataProvider = "Reports_ClassWiseStudentDetails_YearLoss")
	public void tcFillClassWiseDetailsReport_Form_YearLoss(String academicYear, String Class_CWD, String Section,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillClassWiseDetailsReport_Form_YearLoss Test===========");

			classwisestudentdetails.fillClassWiseDetailsReport_Form_ForYearLoss(academicYear, Class_CWD, Section);

			log.info("============= Finished tcFillClassWiseDetailsReport_Form_YearLoss Test===========");
			getScreenShot("tcFillClassWiseDetailsReport_Form_YearLoss");
		} catch (Exception e) {
			getScreenShot("tcFillClassWiseDetailsReport_Form_YearLoss");
		}
	}

	@Test(priority = 45)
	public void tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_YearLoss() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_YearLoss Test===========");

			classwisestudentdetails.clickReport_ToGenerate_ClassWiseStudentDetailsReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_YearLoss Test===========");
			getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_YearLoss");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_YearLoss");
		}
	}

	@Test(priority = 46, dataProvider = "Search_ClassWiseStudentDetails_YearLoss")
	public void tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_YearLoss(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_YearLoss Test===========");

			classwisestudentdetails.searchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_YearLoss Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_YearLoss");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_YearLoss");
		}
	}

	@Test(priority = 47, dataProvider = "Search_ClassWiseStudentDetails_YearLoss")
	public void tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_YearLoss(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_YearLoss Test===========");

			classwisestudentdetails.verifyStudent_ForClassWiseStudentDetailsReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_YearLoss Test===========");
			getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_YearLoss");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_YearLoss");
		}
	}

	@Test(priority = 48, dataProvider = "Search_ClassWiseStudentDetails_YearLoss")
	public void tcSelectStudentForClassWiseStudentDetailsReport_YearLoss(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudentForClassWiseStudentDetailsReport_YearLoss Test===========");

			classwisestudentdetails.selectStudentForClassWiseStudentDetailsReport(admissionNum);

			log.info("============= Finished tcSelectStudentForClassWiseStudentDetailsReport_YearLoss Test===========");
			getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport_YearLoss");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport_YearLoss");
		}
	}

	@Test(priority = 49)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearLoss() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearLoss Test===========");

			classwisestudentdetails.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearLoss Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearLoss");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearLoss");
		}
	}

	@Test(priority = 50)
	public void tcClickOnPrint_ForPrintPreview_YearLoss() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearLoss Test===========");

			classwisestudentdetails.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearLoss Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearLoss");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearLoss");
		}
	}

	@Test(priority = 51)
	public void tcClickCancelButton_ToClearFilledForm_ForDeactivatedAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ForDeactivatedAction Test===========");

			classwisestudentdetails.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ForDeactivatedAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForDeactivatedAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForDeactivatedAction");
		}
	}

	@Test(priority = 52, dataProvider = "Reports_ClassWiseStudentDetails_Deactivated")
	public void tcFillClassWiseDetailsReport_Form_Deactivated(String academicYear, String Class_CWD, String Section,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillClassWiseDetailsReport_Form_Deactivated Test===========");

			classwisestudentdetails.fillClassWiseDetailsReport_Form_ForDeactivated(academicYear, Class_CWD, Section);

			log.info("============= Finished tcFillClassWiseDetailsReport_Form_Deactivated Test===========");
			getScreenShot("tcFillClassWiseDetailsReport_Form_Deactivated");
		} catch (Exception e) {
			getScreenShot("tcFillClassWiseDetailsReport_Form_Deactivated");
		}
	}

	@Test(priority = 53)
	public void tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_Deactivated() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_Deactivated Test===========");

			classwisestudentdetails.clickReport_ToGenerate_ClassWiseStudentDetailsReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_Deactivated Test===========");
			getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_Deactivated");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_ClassWiseStudentDetailsReport_Deactivated");
		}
	}

	@Test(priority = 54, dataProvider = "Search_ClassWiseStudentDetails_Deactivated")
	public void tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_Deactivated(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_Deactivated Test===========");

			classwisestudentdetails.searchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid(admissionNum);

			log.info(
					"============= Finished tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_Deactivated Test===========");
			getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_Deactivated");
		} catch (Exception e) {
			getScreenShot("tcSearchWithAdmissionNumber_InClassWiseStudentDetailsReportGrid_Deactivated");
		}
	}

	@Test(priority = 55, dataProvider = "Search_ClassWiseStudentDetails_Deactivated")
	public void tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_Deactivated(String admissionNum,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_Deactivated Test===========");

			classwisestudentdetails.verifyStudent_ForClassWiseStudentDetailsReportInGrid(admissionNum);

			log.info(
					"============= Finished tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_Deactivated Test===========");
			getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_Deactivated");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudent_ForClassWiseStudentDetailsReportInGrid_Deactivated");
		}
	}

	@Test(priority = 56, dataProvider = "Search_ClassWiseStudentDetails_Deactivated")
	public void tcSelectStudentForClassWiseStudentDetailsReport_Deactivated(String admissionNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectStudentForClassWiseStudentDetailsReport_Deactivated Test===========");

			classwisestudentdetails.selectStudentForClassWiseStudentDetailsReport(admissionNum);

			log.info(
					"============= Finished tcSelectStudentForClassWiseStudentDetailsReport_Deactivated Test===========");
			getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport_Deactivated");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForClassWiseStudentDetailsReport_Deactivated");
		}
	}

	@Test(priority = 57)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Deactivated() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Deactivated Test===========");

			classwisestudentdetails.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Deactivated Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Deactivated");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Deactivated");
		}
	}

	@Test(priority = 58)
	public void tcClickOnPrint_ForPrintPreview_Deactivated() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_Deactivated Test===========");

			classwisestudentdetails.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_Deactivated Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_Deactivated");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_Deactivated");
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
