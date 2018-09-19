/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.TC_Reports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Fee.Reports.Fee_Student_Concession_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class TC_Fee_Student_Concession_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Fee_Student_Concession_Report.class.getName());

	Fee_Student_Concession_Report feestudentconcession;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_FeeStudentConcession_All_Data")
	public String[][] getTestWrittenData() {
		String[][] testRecordsClassWiseAttendance = getData("FeeReportsData.xlsx", "FeeStuConcession_AllData");
		return testRecordsClassWiseAttendance;
	}

	@DataProvider(name = "Reports_FeeStudentConcession_Individual_Data")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearchDetails = getData("FeeReportsData.xlsx", "FeeStuConcession_IndividualData");
		return testRecordsSearchDetails;
	}

	@DataProvider(name = "Search_FeeStuConcessionRecord")
	public String[][] getTestValidationData() {
		String[][] testRecordsValidationDetails = getData("FeeReportsData.xlsx", "Search_FeeStuConcession");
		return testRecordsValidationDetails;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feestudentconcession = new Fee_Student_Concession_Report(driver);
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

			boolean status = feestudentconcession.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFee_Reports_FeeStudentConcessionReport() {

		try {
			log.info("============= Strting tcNavigateToFee_Reports_FeeStudentConcessionReport Test===========");

			feestudentconcession.navigateToFee_Reports_FeeStudentConcessionReport();

			log.info("============= Finished tcNavigateToFee_Reports_FeeStudentConcessionReport Test===========");
			getScreenShot("tcNavigateToFee_Reports_FeeStudentConcessionReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFee_Reports_FeeStudentConcessionReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeReports_FeeStudentConcessionReport_Page() {

		try {
			log.info("============= Strting tcVerifyFeeReports_FeeStudentConcessionReport_Page Test===========");

			boolean status = feestudentconcession.verifyFeeReports_FeeStudentConcessionReport_Page();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeReports_FeeStudentConcessionReport_Page Test===========");
			getScreenShot("tcVerifyFeeReports_FeeStudentConcessionReport_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeReports_FeeStudentConcessionReport_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_FeeStudentConcessionReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_FeeStudentConcessionReportForm Test===========");

			feestudentconcession.submitBlank_FeeStudentConcessionReportForm();

			log.info("============= Finished tcSubmitBlank_FeeStudentConcessionReportForm Test===========");
			getScreenShot("tcSubmitBlank_FeeStudentConcessionReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_FeeStudentConcessionReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_FeeStudentConcession_All_Data")
	public void tcFill_FeeStudentConcessionReportForm_rdBtnAll(String academicYear, String concession_Type,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeStudentConcessionReportForm_rdBtnAll Test===========");

			feestudentconcession.fill_FeeStudentConcessionReportForm_rdBtnAll(academicYear, concession_Type);

			log.info("============= Finished tcFill_FeeStudentConcessionReportForm_rdBtnAll Test===========");
			getScreenShot("tcFill_FeeStudentConcessionReportForm_rdBtnAll");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeStudentConcessionReportForm_rdBtnAll");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_FeeStudentConcessionReport_All() {

		try {
			log.info("============= Strting tcClickReport_ToGenerate_FeeStudentConcessionReport_All Test===========");

			feestudentconcession.clickReport_ToGenerate_FeeStudentConcessionReport();

			log.info("============= Finished tcClickReport_ToGenerate_FeeStudentConcessionReport_All Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeStudentConcessionReport_All");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeStudentConcessionReport_All");
		}
	}

	@Test(priority = 8)
	public void tcSelectRecordToGenerateReport_FeeStudentConcession_All() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_FeeStudentConcession_All Test===========");

			feestudentconcession.selectRecordToGenerateReport();

			log.info("============= Finished tcSelectRecordToGenerateReport_FeeStudentConcession_All Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_FeeStudentConcession_All");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_FeeStudentConcession_All");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_FeeStudentConcessionReport_Form() {

		try {
			log.info("============= Strting tcMinimize_FeeStudentConcessionReport_Form Test===========");

			feestudentconcession.min_Max_FeeStudentConcessionReport_Form();

			log.info("============= Finished tcMinimize_FeeStudentConcessionReport_Form Test===========");
			getScreenShot("tcMinimize_FeeStudentConcessionReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeStudentConcessionReport_Form");
		}
	}

	@Test(priority = 10)
	public void tcSortRecordsByStudentName() {

		try {
			log.info("============= Strting tcSortRecordsByStudentName Test===========");
			getScreenShot("BeforeSorting_tcSortRecordsByStudentName");

			feestudentconcession.sortRecordsByStudentName();

			log.info("============= Finished tcSortRecordsByStudentName Test===========");
			getScreenShot("tcSortRecordsByStudentName");
		} catch (Exception e) {
			getScreenShot("tcSortRecordsByStudentName");
		}
	}

	@Test(priority = 11)
	public void tcMinimize_ReportGridView_Grid() {

		try {
			log.info("============= Strting tcMinimize_ReportGridView_Grid Test===========");

			feestudentconcession.min_Max_ReportGridView_Grid();

			log.info("============= Finished tcMinimize_ReportGridView_Grid Test===========");
			getScreenShot("tcMinimize_ReportGridView_Grid");
		} catch (Exception e) {
			getScreenShot("tcMinimize_ReportGridView_Grid");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_ReportGridView_Grid() {

		try {
			log.info("============= Strting tcMaximize_ReportGridView_Grid Test===========");

			feestudentconcession.min_Max_ReportGridView_Grid();

			log.info("============= Finished tcMaximize_ReportGridView_Grid Test===========");
			getScreenShot("tcMaximize_ReportGridView_Grid");
		} catch (Exception e) {
			getScreenShot("tcMaximize_ReportGridView_Grid");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_FeeStudentConcessionReport_Form() {

		try {
			log.info("============= Strting tcMaximize_FeeStudentConcessionReport_Form Test===========");

			feestudentconcession.min_Max_FeeStudentConcessionReport_Form();

			log.info("============= Finished tcMaximize_FeeStudentConcessionReport_Form Test===========");
			getScreenShot("tcMaximize_FeeStudentConcessionReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeStudentConcessionReport_Form");
		}
	}

	@Test(priority = 14, dataProvider = "Search_FeeStuConcessionRecord")
	public void tcSearchWithStudentName_InFeeStudentConcessionReportGridView(String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithStudentName_InFeeStudentConcessionReportGridView Test===========");

			feestudentconcession.searchWithStudentName_InFeeStudentConcessionReportGridView(studentName);

			log.info(
					"============= Finished tcSearchWithStudentName_InFeeStudentConcessionReportGridView Test===========");
			getScreenShot("tcSearchWithStudentName_InFeeStudentConcessionReportGridView");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStudentName_InFeeStudentConcessionReportGridView");
		}
	}

	@Test(priority = 15)
	public void tcClickCancelButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm Test===========");

			feestudentconcession.clickCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickCancelButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		}
	}

	@Test(priority = 16, dataProvider = "Reports_FeeStudentConcession_All_Data")
	public void tcFill_FeeStudentConcessionReportForm_rdBtnAll_AfterClearing(String academicYear,
			String concession_Type, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_FeeStudentConcessionReportForm_rdBtnAll_AfterClearing Test===========");

			feestudentconcession.fill_FeeStudentConcessionReportForm_rdBtnAll(academicYear, concession_Type);

			log.info(
					"============= Finished tcFill_FeeStudentConcessionReportForm_rdBtnAll_AfterClearing Test===========");
			getScreenShot("tcFill_FeeStudentConcessionReportForm_rdBtnAll_AfterClearing");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeStudentConcessionReportForm_rdBtnAll_AfterClearing");
		}
	}

	@Test(priority = 17)
	public void tcClickReport_ToGenerate_FeeStudentConcessionReport_All_AfterClearing() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeStudentConcessionReport_All_AfterClearing Test===========");

			feestudentconcession.clickReport_ToGenerate_FeeStudentConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeStudentConcessionReport_All_AfterClearing Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeStudentConcessionReport_All_AfterClearing");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeStudentConcessionReport_All_AfterClearing");
		}
	}

	@Test(priority = 18)
	public void tcSelectRecordToGenerateReport_FeeStudentConcession_All_AfterClearing() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_FeeStudentConcession_All_AfterClearing Test===========");

			feestudentconcession.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_FeeStudentConcession_All_AfterClearing Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_FeeStudentConcession_All_AfterClearing");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_FeeStudentConcession_All_AfterClearing");
		}
	}

	@Test(priority = 19)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_FeeStudentConcession_All() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_FeeStudentConcession_All Test===========");

			feestudentconcession.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_FeeStudentConcession_All Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_FeeStudentConcession_All");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_FeeStudentConcession_All");
		}
	}

	@Test(priority = 20)
	public void tcClickOnPrint_ForPrintPreview_FeeStudentConcession_All() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_FeeStudentConcession_All Test===========");

			feestudentconcession.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_FeeStudentConcession_All Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_FeeStudentConcession_All");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_FeeStudentConcession_All");
		}
	}

	@Test(priority = 21, dataProvider = "Reports_FeeStudentConcession_Individual_Data")
	public void tcFill_FeeStudentConcessionReportForm_rdBtnIndividual(String academicYear, String concession_Type,
			String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeStudentConcessionReportForm_rdBtnIndividual Test===========");

			feestudentconcession.fill_FeeStudentConcessionReportForm_rdBtnIndividual(academicYear, concession_Type,
					select_class, section);

			log.info("============= Finished tcFill_FeeStudentConcessionReportForm_rdBtnIndividual Test===========");
			getScreenShot("tcFill_FeeStudentConcessionReportForm_rdBtnIndividual");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeStudentConcessionReportForm_rdBtnIndividual");
		}
	}

	@Test(priority = 22)
	public void tcClickReport_ToGenerate_FeeStudentConcessionReport_Individual() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeStudentConcessionReport_Individual Test===========");

			feestudentconcession.clickReport_ToGenerate_FeeStudentConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeStudentConcessionReport_Individual Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeStudentConcessionReport_Individual");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeStudentConcessionReport_Individual");
		}
	}

	@Test(priority = 23)
	public void tcSelectRecordToGenerateReport_FeeStudentConcession_Individual() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_FeeStudentConcession_Individual Test===========");

			feestudentconcession.selectRecordToGenerateReport();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_FeeStudentConcession_Individual Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_FeeStudentConcession_Individual");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_FeeStudentConcession_Individual");
		}
	}

	@Test(priority = 24)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_FeeStudentConcession_Individual() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_FeeStudentConcession_Individual Test===========");

			feestudentconcession.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_FeeStudentConcession_Individual Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_FeeStudentConcession_Individual");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_FeeStudentConcession_Individual");
		}
	}

	@Test(priority = 25)
	public void tcClickOnPrint_ForPrintPreview_FeeStudentConcession_Individual() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_FeeStudentConcession_Individual Test===========");

			feestudentconcession.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_FeeStudentConcession_Individual Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_FeeStudentConcession_Individual");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_FeeStudentConcession_Individual");
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
