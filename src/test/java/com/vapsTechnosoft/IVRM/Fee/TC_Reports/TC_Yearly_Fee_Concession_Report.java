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

import com.vapsTechnosoft.IVRM.Fee.Reports.Yearly_Fee_Concession_Report;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Yearly_Fee_Concession_Report extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Yearly_Fee_Concession_Report.class.getName());

	Yearly_Fee_Concession_Report yarlyfeeconcessionreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_YearlyFeeConcessionReportData")
	public String[][] getTestWrittenData() {
		String[][] testRecordsYearlyFeeConcession = getData("FeeReportsData.xlsx", "YearlyFeeConcession_Report");
		return testRecordsYearlyFeeConcession;
	}

	@DataProvider(name = "Search_YearlyFeeConcessionReport")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearchDetails = getData("FeeReportsData.xlsx", "Search_YearlyFeeConcession");
		return testRecordsSearchDetails;
	}


	@BeforeClass
	public void setUp() throws IOException {
		init();
		yarlyfeeconcessionreport = new Yearly_Fee_Concession_Report(driver);
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

			boolean status = yarlyfeeconcessionreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFee_Reports_YearlyFeeConcessionReport() {

		try {
			log.info("============= Strting tcNavigateToFee_Reports_YearlyFeeConcessionReport Test===========");

			yarlyfeeconcessionreport.navigateToFee_Reports_YearlyFeeConcessionReport();

			log.info("============= Finished tcNavigateToFee_Reports_YearlyFeeConcessionReport Test===========");
			getScreenShot("tcNavigateToFee_Reports_YearlyFeeConcessionReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFee_Reports_YearlyFeeConcessionReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeReports_YearlyFeeConcessionReport_Page() {

		try {
			log.info("============= Strting tcVerifyFeeReports_YearlyFeeConcessionReport_Page Test===========");

			boolean status = yarlyfeeconcessionreport.verifyFeeReports_YearlyFeeConcessionReport_Page();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeReports_YearlyFeeConcessionReport_Page Test===========");
			getScreenShot("tcVerifyFeeReports_YearlyFeeConcessionReport_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeReports_YearlyFeeConcessionReport_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_YearlyFeeConcessionReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_YearlyFeeConcessionReportForm Test===========");

			yarlyfeeconcessionreport.submitBlank_YearlyFeeConcessionReportForm();

			log.info("============= Finished tcSubmitBlank_YearlyFeeConcessionReportForm Test===========");
			getScreenShot("tcSubmitBlank_YearlyFeeConcessionReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_YearlyFeeConcessionReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise");
		}
	}

	@Test(priority = 8)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_YearlyFeeConcessionReport_Form() {

		try {
			log.info("============= Strting tcMinimize_YearlyFeeConcessionReport_Form Test===========");

			yarlyfeeconcessionreport.min_Max_YearlyFeeConcessionReport_Form();

			log.info("============= Finished tcMinimize_YearlyFeeConcessionReport_Form Test===========");
			getScreenShot("tcMinimize_YearlyFeeConcessionReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_YearlyFeeConcessionReport_Form");
		}
	}

	@Test(priority = 10)
	public void tcSortRecordsByGroupName() {

		try {
			log.info("============= Strting tcSortRecordsByGroupName Test===========");
			getScreenShot("BeforeSorting_tcSortRecordsByGroupName");

			yarlyfeeconcessionreport.sortRecordsByGroupName();

			log.info("============= Finished tcSortRecordsByGroupName Test===========");
			getScreenShot("tcSortRecordsByGroupName");
		} catch (Exception e) {
			getScreenShot("tcSortRecordsByGroupName");
		}
	}
	
	@Test(priority = 11, dataProvider = "Search_YearlyFeeConcessionReport")
	public void tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid(String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid Test===========");

			yarlyfeeconcessionreport.searchWithGroupName_InYearlyFeeDefaulterReportGrid(groupName);

			log.info("============= Finished tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid Test===========");
			getScreenShot("tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_YearlyFeeConcessionReport_Grid() {

		try {
			log.info("============= Strting tcMinimize_YearlyFeeConcessionReport_Grid Test===========");

			yarlyfeeconcessionreport.min_Max_YearlyFeeConcessionReport_Grid();

			log.info("============= Finished tcMinimize_YearlyFeeConcessionReport_Grid Test===========");
			getScreenShot("tcMinimize_YearlyFeeConcessionReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMinimize_YearlyFeeConcessionReport_Grid");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_YearlyFeeConcessionReport_Grid() {

		try {
			log.info("============= Strting tcMaximize_YearlyFeeConcessionReport_Grid Test===========");

			yarlyfeeconcessionreport.min_Max_YearlyFeeConcessionReport_Grid();

			log.info("============= Finished tcMaximize_YearlyFeeConcessionReport_Grid Test===========");
			getScreenShot("tcMaximize_YearlyFeeConcessionReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMaximize_YearlyFeeConcessionReport_Grid");
		}
	}

	@Test(priority = 14)
	public void tcMaximize_YearlyFeeConcessionReport_Form() {

		try {
			log.info("============= Strting tcMaximize_YearlyFeeConcessionReport_Form Test===========");

			yarlyfeeconcessionreport.min_Max_YearlyFeeConcessionReport_Form();

			log.info("============= Finished tcMaximize_YearlyFeeConcessionReport_Form Test===========");
			getScreenShot("tcMaximize_YearlyFeeConcessionReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_YearlyFeeConcessionReport_Form");
		}
	}

	@Test(priority = 15)
	public void tcClickClearButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm");
		}
	}

	/*Yearly Wise > Group wise > Active Student
	 * 
	 * Fee Group Wise
	 */
	@Test(priority = 16, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterClearingFilledData(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterClearingFilledData Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterClearingFilledData Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterClearingFilledData");
		}
	}

	@Test(priority = 17)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_AfterClearingFilledData Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_AfterClearingFilledData Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_AfterClearingFilledData");
		}
	}

	@Test(priority = 18)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_AfterClearingFilledData Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_AfterClearingFilledData Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_AfterClearingFilledData");
		}
	}

	@Test(priority = 19)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active");
		}
	}

	@Test(priority = 20)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active");
		}
	}
	@Test(priority = 21)
	public void tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForActiveStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForActiveStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForActiveStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForActiveStudent");
		}
	}

	/*Yearly Wise > Head wise > Active Student
	 * 
	 * Fee Head Wise
	 */
	@Test(priority = 22, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent Test===========");

			yarlyfeeconcessionreport.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActiveStudent");
		}
	}

	@Test(priority = 23)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_Active Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_Active Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_Active");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_Active");
		}
	}

	@Test(priority = 24)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_Active() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_Active Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_Active Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Active");
		}
	}

	@Test(priority = 25)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active");
		}
	}

	@Test(priority = 26)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active");
		}
	}
	@Test(priority = 27)
	public void tcClickClearButton_ToClearFilledForm_ClassWise_ForActiveStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_ClassWise_ForActiveStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_ClassWise_ForActiveStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_ClassWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_ClassWise_ForActiveStudent");
		}
	}
	/*Yearly Wise > Class wise > Active Student
	 * 
	 * Fee Class Wise
	 */
	@Test(priority = 28, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActiveStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActiveStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActiveStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActiveStudent");
		}
	}

	@Test(priority = 29)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_Active Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_Active Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_Active");
		}
	}

	@Test(priority = 30)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_Active() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_Active Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_ClassWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_Active Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Active");
		}
	}

	@Test(priority = 31)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active");
		}
	}

	@Test(priority = 32)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active");
		}
	}
	@Test(priority = 33)
	public void tcClickClearButton_ToClearFilledForm_StudentWise_ForActiveStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_StudentWise_ForActiveStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_StudentWise_ForActiveStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_StudentWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_StudentWise_ForActiveStudent");
		}
	}
	/*Yearly Wise > Student wise > Active Student
	 * 
	 * Fee Student Wise
	 */
	@Test(priority = 34, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActiveStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActiveStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActiveStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActiveStudent");
		}
	}

	@Test(priority = 35)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_Active Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_Active Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_Active");
		}
	}

	@Test(priority = 36)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_Active() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_Active Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_StudentWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_Active Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Active");
		}
	}

	@Test(priority = 37)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active");
		}
	}

	@Test(priority = 38)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active");
		}
	}
	@Test(priority = 39)
	public void tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForDeactiveStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForDeactiveStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForDeactiveStudent");
		}
	}
	/*Yearly Wise > Group wise > DeActive Student
	 * 
	 * Fee Group Wise
	 */
	@Test(priority = 40, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForDeActiveStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForDeActiveStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForDeActiveStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForDeActiveStudent");
		}
	}

	@Test(priority = 41)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_DeActive Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_DeActive");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_DeActive");
		}
	}

	@Test(priority = 42)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_DeActive() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_DeActive Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_DeActive Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_DeActive");
		}
	}

	@Test(priority = 43)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_DeActive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_DeActive");
		}
	}

	@Test(priority = 44)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_DeActive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_DeActive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_DeActive");
		}
	}
	@Test(priority = 45)
	public void tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForDeactiveStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForDeactiveStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForDeactiveStudent");
		}
	}

	/*Yearly Wise > Head wise > DeActive Student
	 * 
	 * Fee Head Wise
	 */
	@Test(priority = 46, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForDeActiveStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForDeActiveStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForDeActiveStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForDeActiveStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForDeActiveStudent");
		}
	}

	@Test(priority = 47)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_DeActive Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_DeActive");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_DeActive");
		}
	}

	@Test(priority = 48)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_DeActive() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_DeActive Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_DeActive Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_DeActive");
		}
	}

	@Test(priority = 49)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_DeActive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_DeActive");
		}
	}

	@Test(priority = 50)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_DeActive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_DeActive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_DeActive");
		}
	}
	@Test(priority = 51)
	public void tcClickClearButton_ToClearFilledForm_ClassWise_ForDeactiveStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_ClassWise_ForDeactiveStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_ClassWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_ClassWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_ClassWise_ForDeactiveStudent");
		}
	}
	/*Yearly Wise > Class wise > DeActive Student
	 * 
	 * Fee Class Wise
	 */
	@Test(priority = 52, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForDeActiveStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForDeActiveStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForDeActiveStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForDeActiveStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForDeActiveStudent");
		}
	}

	@Test(priority = 53)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_DeActive Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_DeActive");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_DeActive");
		}
	}

	@Test(priority = 54)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_DeActive() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_DeActive Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_ClassWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_DeActive Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_DeActive");
		}
	}

	@Test(priority = 55)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_DeActive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_DeActive");
		}
	}

	@Test(priority = 56)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_DeActive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_DeActive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_DeActive");
		}
	}
	@Test(priority = 57)
	public void tcClickClearButton_ToClearFilledForm_StudentWise_ForDeactiveStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_StudentWise_ForDeactiveStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_StudentWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_StudentWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_StudentWise_ForDeactiveStudent");
		}
	}
	/*Yearly Wise > Student wise > DeActive Student
	 * 
	 * Fee Student Wise
	 */
	@Test(priority = 58, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForDeActiveStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForDeActiveStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForDeActiveStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForDeActiveStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForDeActiveStudent");
		}
	}

	@Test(priority = 59)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_DeActive Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_DeActive");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_DeActive");
		}
	}

	@Test(priority = 60)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_DeActive() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_DeActive Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_StudentWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_DeActive Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_DeActive");
		}
	}

	@Test(priority = 61)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_DeActive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_DeActive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_DeActive");
		}
	}

	@Test(priority = 62)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_DeActive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_DeActive Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_DeActive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_DeActive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_DeActive");
		}
	}
	@Test(priority = 63)
	public void tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForLeftStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForLeftStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForLeftStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForLeftStudent");
		}
	}
	
	/*Yearly Wise > Group wise > Left Student
	 * 
	 * Fee Group Wise
	 */
	@Test(priority = 64, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForLeftStudent");
		}
	}

	@Test(priority = 65)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_Left Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_Left Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_Left");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_Left");
		}
	}

	@Test(priority = 66)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_Left() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_Left Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_Left Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Left");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Left");
		}
	}

	@Test(priority = 67)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left");
		}
	}

	@Test(priority = 68)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left");
		}
	}
	@Test(priority = 69)
	public void tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForLeftStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForLeftStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForLeftStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForLeftStudent");
		}
	}
	/*Yearly Wise > Head wise > Left Student
	 * 
	 * Fee Head Wise
	 */
	@Test(priority = 70, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForLeftStudent");
		}
	}

	@Test(priority = 71)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_Left Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_Left Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_Left");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_Left");
		}
	}

	@Test(priority = 72)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_Left() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_Left Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_Left Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Left");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Left");
		}
	}

	@Test(priority = 73)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left");
		}
	}

	@Test(priority = 74)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left");
		}
	}
	@Test(priority = 75)
	public void tcClickClearButton_ToClearFilledForm_ClassWise_ForLeftStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_ClassWise_ForLeftStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_ClassWise_ForLeftStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_ClassWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_ClassWise_ForLeftStudent");
		}
	}
	/*Yearly Wise > Class wise > Left Student
	 * 
	 * Fee Class Wise
	 */
	@Test(priority = 76, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForLeftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForLeftStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForLeftStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForLeftStudent");
		}
	}

	@Test(priority = 77)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_Left Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_Left Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_Left");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_Left");
		}
	}

	@Test(priority = 78)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_Left() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_Left Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_ClassWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_Left Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Left");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Left");
		}
	}

	@Test(priority = 79)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left");
		}
	}

	@Test(priority = 80)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left");
		}
	}
	@Test(priority = 81)
	public void tcClickClearButton_ToClearFilledForm_StudentWise_ForLeftStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_StudentWise_ForLeftStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_StudentWise_ForLeftStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_StudentWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_StudentWise_ForLeftStudent");
		}
	}
	/*Yearly Wise > Student wise > Left Student
	 * 
	 * Fee Student Wise
	 */
	@Test(priority = 82, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForLeftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForLeftStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForLeftStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForLeftStudent");
		}
	}

	@Test(priority = 83)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_Left Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_Left Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_Left");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_Left");
		}
	}

	@Test(priority = 84)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_Left() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_Left Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_StudentWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_Left Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Left");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Left");
		}
	}

	@Test(priority = 85)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left");
		}
	}

	@Test(priority = 86)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left");
		}
	}
	@Test(priority = 87)
	public void tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForActive_Deactive_leftStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeGroupWise_ForActive_Deactive_leftStudent");
		}
	}
	/*
	 * Yearly Wise > Group Wise > All Active, Deactive and Left Selected
	 * 
	 * For Fee Group Wise
	 */
	@Test(priority = 88, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 89)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 90)
	public void tcSelectRecordToGenerateReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 91)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeGroupWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 92)
	public void tcClickOnPrint_ForPrintPreview_YearlyFeeGroupWise_ForActive_Deactive_leftStudent() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyFeeGroupWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyFeeGroupWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyFeeGroupWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyFeeGroupWise_ForActive_Deactive_leftStudent");
		}
	}
	@Test(priority = 93)
	public void tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForActive_Deactive_leftStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeHeadWise_ForActive_Deactive_leftStudent");
		}
	}
	/*
	 * Yearly Wise > Head Wise > All Active, Deactive and Left Selected
	 * 
	 * For Fee Head Wise
	 */
	@Test(priority = 94, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 95)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 96)
	public void tcSelectRecordToGenerateReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 97)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 98)
	public void tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_ForActive_Deactive_leftStudent() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_ForActive_Deactive_leftStudent");
		}
	}
	@Test(priority = 99)
	public void tcClickClearButton_ToClearFilledForm_ClassWise_ForActive_Deactive_leftStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_ClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_ClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_ClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_ClassWise_ForActive_Deactive_leftStudent");
		}
	}
	/*
	 * Yearly Wise > Class Wise > All Active, Deactive and Left Selected
	 * 
	 * For Class Wise
	 */
	@Test(priority = 100, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 101)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 102)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_ClassWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 103)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 104)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_ForActive_Deactive_leftStudent() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_ForActive_Deactive_leftStudent");
		}
	}
	@Test(priority = 105)
	public void tcClickClearButton_ToClearFilledForm_StudentWise_ForActive_Deactive_leftStudent() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_StudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_StudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_StudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_StudentWise_ForActive_Deactive_leftStudent");
		}
	}
	/*
	 * Yearly Wise > Student Wise > All Active, Deactive and Left Selected
	 * 
	 * For Student Wise
	 */
	@Test(priority = 106, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 107)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 108)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_StudentWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 109)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_ForActive_Deactive_leftStudent() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_ForActive_Deactive_leftStudent");
		}
	}

	@Test(priority = 110)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_ForActive_Deactive_leftStudent() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_ForActive_Deactive_leftStudent Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_ForActive_Deactive_leftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_ForActive_Deactive_leftStudent");
		}
	}
	@Test(priority = 111)
	public void tcClickClearButton_ToClearFilledForm_FeeGroupWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_FeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_FeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}
	/*
	 * Yearly Wise > Group Wise > Without Selecting Active, Deactive and Left
	 * 
	 * For Fee Group Wise
	 */
	@Test(priority = 112, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 113)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 114)
	public void tcSelectRecordToGenerateReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeGroupWise();
			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 115)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 116)
	public void tcClickOnPrint_ForPrintPreview_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyFeeGroupWise_WithoutActive_Deactive_Left_Student");
		}
	}
	@Test(priority = 117)
	public void tcClickClearButton_ToClearFilledForm_FeeHeadWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_FeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_FeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_FeeHeadWise_WithoutActive_Deactive_Left_Student");
		}
	}
	/*
	 * Yearly Wise > Head Wise > Without Selecting Active, Deactive and Left
	 * 
	 * For Fee Head Wise
	 */
	@Test(priority = 118, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_FeeHeadWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 119)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 120)
	public void tcSelectRecordToGenerateReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 121)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 122)
	public void tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyFeeHeadWise_WithoutActive_Deactive_Left_Student");
		}
	}
	@Test(priority = 123)
	public void tcClickClearButton_ToClearFilledForm_ClassWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_ClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_ClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_ClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_ClassWise_WithoutActive_Deactive_Left_Student");
		}
	}
	/*
	 * Yearly Wise > Class Wise > Without Selecting Active, Deactive and Left
	 * 
	 * For Class Wise
	 */
	@Test(priority = 124, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_ClassWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 125)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 126)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_ClassWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 127)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 128)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_WithoutActive_Deactive_Left_Student");
		}
	}
	@Test(priority = 129)
	public void tcClickClearButton_ToClearFilledForm_StudentWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm_StudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm_StudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm_StudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm_StudentWise_WithoutActive_Deactive_Left_Student");
		}
	}
	/*
	 * Yearly Wise > Student Wise > Without Selecting Active, Deactive and Left
	 * 
	 * For Student Wise
	 */
	@Test(priority = 130, dataProvider = "Reports_YearlyFeeConcessionReportData")
	public void tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport
					.fill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcFill_YearlyFeeConcessionReportForm_YearlyWise_StudentWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 131)
	public void tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickReport_ToGenerate_YearlyFeeConcessionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeConcessionReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 132)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.selectRecordToGenerateReport_StudentWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 133)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		}
	}

	@Test(priority = 134)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_WithoutActive_Deactive_Left_Student() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");

			yarlyfeeconcessionreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_WithoutActive_Deactive_Left_Student Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_WithoutActive_Deactive_Left_Student");
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
