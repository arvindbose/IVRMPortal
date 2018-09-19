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

import com.vapsTechnosoft.IVRM.Fee.Reports.Fee_DueDates_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Fee_DueDates_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Fee_DueDates_Report.class.getName());

	Fee_DueDates_Report feeduedatesreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_FeeDueDatesData")
	public String[][] getTestWrittenData() {
		String[][] testRecordsFeeDueDates = getData("FeeReportsData.xlsx", "FeeDueDates_Report");
		return testRecordsFeeDueDates;
	}

	@DataProvider(name = "Search_FeeDueDatesReport")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearchDetails = getData("FeeReportsData.xlsx", "Search_FeeDueDatesReport");
		return testRecordsSearchDetails;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeduedatesreport = new Fee_DueDates_Report(driver);
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

			boolean status = feeduedatesreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFee_Reports_FeeDueDatesReport() {

		try {
			log.info("============= Strting tcNavigateToFee_Reports_FeeDueDatesReport Test===========");

			feeduedatesreport.navigateToFee_Reports_FeeDueDatesReport();

			log.info("============= Finished tcNavigateToFee_Reports_FeeDueDatesReport Test===========");
			getScreenShot("tcNavigateToFee_Reports_FeeDueDatesReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFee_Reports_FeeDueDatesReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeReports_FeeDueDatesReport_Page() {

		try {
			log.info("============= Strting tcVerifyFeeReports_FeeDueDatesReport_Page Test===========");

			boolean status = feeduedatesreport.verifyFeeReports_FeeDueDatesReport_Page();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeReports_FeeDueDatesReport_Page Test===========");
			getScreenShot("tcVerifyFeeReports_FeeDueDatesReport_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeReports_FeeDueDatesReport_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_FeeDueDatesReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_FeeDueDatesReportForm Test===========");

			feeduedatesreport.submitBlank_FeeDueDatesReportForm();

			log.info("============= Finished tcSubmitBlank_FeeDueDatesReportForm Test===========");
			getScreenShot("tcSubmitBlank_FeeDueDatesReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_FeeDueDatesReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_FeeDueDatesData")
	public void tcFill_FeeDueDatesReportForm(String academicYear, String classCategory, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeDueDatesReportForm Test===========");

			feeduedatesreport.fill_FeeDueDatesReportForm(academicYear, classCategory);

			log.info("============= Finished tcFill_FeeDueDatesReportForm Test===========");
			getScreenShot("tcFill_FeeDueDatesReportForm");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeDueDatesReportForm");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_FeeDueDatesReport() {

		try {
			log.info("============= Strting tcClickReport_ToGenerate_FeeDueDatesReport Test===========");

			feeduedatesreport.clickReport_ToGenerate_FeeDueDatesReport();

			log.info("============= Finished tcClickReport_ToGenerate_FeeDueDatesReport Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeDueDatesReport");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeDueDatesReport");
		}
	}

	@Test(priority = 8)
	public void tcSelectRecordToDownLoadAndPrintPreview() {

		try {
			log.info("============= Strting tcSelectRecordToDownLoadAndPrintPreview Test===========");

			feeduedatesreport.selectRecordToDownLoadAndPrintPreview();

			log.info("============= Finished tcSelectRecordToDownLoadAndPrintPreview Test===========");
			getScreenShot("tcSelectRecordToDownLoadAndPrintPreview");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToDownLoadAndPrintPreview");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_FeeDueDatesReport_Form() {

		try {
			log.info("============= Strting tcMinimize_FeeDueDatesReport_Form Test===========");

			feeduedatesreport.min_Max_FeeDueDatesReport_Form();

			log.info("============= Finished tcMinimize_FeeDueDatesReport_Form Test===========");
			getScreenShot("tcMinimize_FeeDueDatesReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeDueDatesReport_Form");
		}
	}

	@Test(priority = 10)
	public void tcSortRecordsByFeeHeadName() {

		try {
			log.info("============= Strting tcSortRecordsByFeeHeadName Test===========");
			getScreenShot("BeforeSorting_tcSortRecordsByFeeHeadName");

			feeduedatesreport.sortRecordsByFeeHeadName();

			log.info("============= Finished tcSortRecordsByFeeHeadName Test===========");
			getScreenShot("tcSortRecordsByFeeHeadName");
		} catch (Exception e) {
			getScreenShot("tcSortRecordsByFeeHeadName");
		}
	}

	@Test(priority = 11, dataProvider = "Search_FeeDueDatesReport")
	public void tcSearchWithFeeHeadName_InFeeDueDatesReportGrid(String feeHeadName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithFeeHeadName_InFeeDueDatesReportGrid Test===========");

			feeduedatesreport.searchWithFeeHeadName_InFeeDueDatesReportGrid(feeHeadName);

			log.info("============= Finished tcSearchWithFeeHeadName_InFeeDueDatesReportGrid Test===========");
			getScreenShot("tcSearchWithFeeHeadName_InFeeDueDatesReportGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithFeeHeadName_InFeeDueDatesReportGrid");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_FeeDueDatesReport_Grid() {

		try {
			log.info("============= Strting tcMinimize_FeeDueDatesReport_Grid Test===========");

			feeduedatesreport.min_Max_FeeDueDatesReport_Grid();
			log.info("============= Finished tcMinimize_FeeDueDatesReport_Grid Test===========");
			getScreenShot("tcMinimize_FeeDueDatesReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeDueDatesReport_Grid");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_FeeDueDatesReport_Grid() {

		try {
			log.info("============= Strting tcMaximize_FeeDueDatesReport_Grid Test===========");

			feeduedatesreport.min_Max_FeeDueDatesReport_Grid();

			log.info("============= Finished tcMaximize_FeeDueDatesReport_Grid Test===========");
			getScreenShot("tcMaximize_FeeDueDatesReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeDueDatesReport_Grid");
		}
	}

	@Test(priority = 14)
	public void tcMaximize_FeeDueDatesReport_Form() {

		try {
			log.info("============= Strting tcMaximize_FeeDueDatesReport_Form Test===========");

			feeduedatesreport.min_Max_FeeDueDatesReport_Form();

			log.info("============= Finished tcMaximize_FeeDueDatesReport_Form Test===========");
			getScreenShot("tcMaximize_FeeDueDatesReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeDueDatesReport_Form");
		}
	}

	@Test(priority = 15)
	public void tcClickCancelButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm Test===========");

			feeduedatesreport.clickCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickCancelButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		}
	}

	@Test(priority = 16, dataProvider = "Reports_FeeDueDatesData")
	public void tcFill_FeeDueDatesReportForm_AfterClearingFilledData(String academicYear, String classCategory,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeDueDatesReportForm_AfterClearingFilledData Test===========");

			feeduedatesreport.fill_FeeDueDatesReportForm(academicYear, classCategory);

			log.info("============= Finished tcFill_FeeDueDatesReportForm_AfterClearingFilledData Test===========");
			getScreenShot("tcFill_FeeDueDatesReportForm_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeDueDatesReportForm_AfterClearingFilledData");
		}
	}

	@Test(priority = 17)
	public void tcClickReport_ToGenerate_FeeDueDatesReport_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeDueDatesReport_AfterClearingFilledData Test===========");

			feeduedatesreport.clickReport_ToGenerate_FeeDueDatesReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeDueDatesReport_AfterClearingFilledData Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeDueDatesReport_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeDueDatesReport_AfterClearingFilledData");
		}
	}

	@Test(priority = 18)
	public void tcSelectRecordToDownLoadAndPrintPreview_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcSelectRecordToDownLoadAndPrintPreview_AfterClearingFilledData Test===========");

			feeduedatesreport.selectRecordToDownLoadAndPrintPreview();

			log.info(
					"============= Finished tcSelectRecordToDownLoadAndPrintPreview_AfterClearingFilledData Test===========");
			getScreenShot("tcSelectRecordToDownLoadAndPrintPreview_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToDownLoadAndPrintPreview_AfterClearingFilledData");
		}
	}

	@Test(priority = 19)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport Test===========");

			feeduedatesreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport");
		}
	}

	@Test(priority = 20)
	public void tcClickOnPrint_ForPrintPreview() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview Test===========");

			feeduedatesreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview");
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
