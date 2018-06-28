/**
 * 
 */
package com.test.automation.uiAutomation.Fee.TC_Reports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Fee.Reports.Fee_MonthEnd_Report;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author Arvind
 *
 */
public class TC_Fee_MonthEnd_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Fee_MonthEnd_Report.class.getName());

	Fee_MonthEnd_Report feemonthendreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_FeeMonthEndData")
	public String[][] getTestWrittenData() {
		String[][] testRecordsFeeMonthEnd = getData("FeeReportsData.xlsx", "FeeMonthEnd_Report");
		return testRecordsFeeMonthEnd;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feemonthendreport = new Fee_MonthEnd_Report(driver);
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

			boolean status = feemonthendreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFee_Reports_FeeMonthEndReport() {

		try {
			log.info("============= Strting tcNavigateToFee_Reports_FeeMonthEndReport Test===========");

			feemonthendreport.navigateToFee_Reports_FeeMonthEndReport();

			log.info("============= Finished tcNavigateToFee_Reports_FeeMonthEndReport Test===========");
			getScreenShot("tcNavigateToFee_Reports_FeeMonthEndReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFee_Reports_FeeMonthEndReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeReports_FeeMonthEndReport_Page() {

		try {
			log.info("============= Strting tcVerifyFeeReports_FeeMonthEndReport_Page Test===========");

			boolean status = feemonthendreport.verifyFeeReports_FeeMonthEndReport_Page();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeReports_FeeMonthEndReport_Page Test===========");
			getScreenShot("tcVerifyFeeReports_FeeMonthEndReport_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeReports_FeeMonthEndReport_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_FeeMonthEndReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_FeeMonthEndReportForm Test===========");

			feemonthendreport.submitBlank_FeeMonthEndReportForm();

			log.info("============= Finished tcSubmitBlank_FeeMonthEndReportForm Test===========");
			getScreenShot("tcSubmitBlank_FeeMonthEndReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_FeeMonthEndReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_FeeDueDatesData")
	public void tcFill_FeeMonthEndReportForm(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeMonthEndReportForm Test===========");

			feemonthendreport.fill_FeeMonthEndReportForm(academicYear);

			log.info("============= Finished tcFill_FeeMonthEndReportForm Test===========");
			getScreenShot("tcFill_FeeMonthEndReportForm");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMonthEndReportForm");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_FeeMonthEndReport() {

		try {
			log.info("============= Strting tcClickReport_ToGenerate_FeeMonthEndReport Test===========");

			feemonthendreport.clickReport_ToGenerate_FeeMonthEndReport();

			log.info("============= Finished tcClickReport_ToGenerate_FeeMonthEndReport Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeMonthEndReport");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeMonthEndReport");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_FeeMonthEndReport_Grid() {

		try {
			log.info("============= Strting tcMinimize_FeeMonthEndReport_Grid Test===========");

			feemonthendreport.min_Max_FeeMonthEndReport_Grid();

			log.info("============= Finished tcMinimize_FeeMonthEndReport_Grid Test===========");
			getScreenShot("tcMinimize_FeeMonthEndReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeMonthEndReport_Grid");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_FeeMonthEndReport_Form() {

		try {
			log.info("============= Strting tcMinimize_FeeMonthEndReport_Form Test===========");

			feemonthendreport.min_Max_FeeMonthEndReport_Form();
			log.info("============= Finished tcMinimize_FeeMonthEndReport_Form Test===========");
			getScreenShot("tcMinimize_FeeMonthEndReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeMonthEndReport_Form");
		}
	}

	@Test(priority = 10)
	public void tcMaximize_FeeMonthEndReport_Grid() {

		try {
			log.info("============= Strting tcMaximize_FeeMonthEndReport_Grid Test===========");

			feemonthendreport.min_Max_FeeMonthEndReport_Grid();

			log.info("============= Finished tcMaximize_FeeMonthEndReport_Grid Test===========");
			getScreenShot("tcMaximize_FeeMonthEndReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeMonthEndReport_Grid");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_FeeMonthEndReport_Form() {

		try {
			log.info("============= Strting tcMaximize_FeeMonthEndReport_Form Test===========");

			feemonthendreport.min_Max_FeeMonthEndReport_Form();

			log.info("============= Finished tcMaximize_FeeMonthEndReport_Form Test===========");
			getScreenShot("tcMaximize_FeeMonthEndReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeMonthEndReport_Form");
		}
	}

	@Test(priority = 12)
	public void tcClickClearButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm Test===========");

			feemonthendreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm");
		}
	}

	@Test(priority = 13, dataProvider = "Reports_FeeDueDatesData")
	public void tcFill_FeeMonthEndReportForm_AfterClearingFilledData(String academicYear, String classCategory,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeMonthEndReportForm_AfterClearingFilledData Test===========");

			feemonthendreport.fill_FeeMonthEndReportForm(academicYear);

			log.info("============= Finished tcFill_FeeMonthEndReportForm_AfterClearingFilledData Test===========");
			getScreenShot("tcFill_FeeMonthEndReportForm_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMonthEndReportForm_AfterClearingFilledData");
		}
	}

	@Test(priority = 14)
	public void tcClickReport_ToGenerate_FeeMonthEndReport_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeMonthEndReport_AfterClearingFilledData Test===========");

			feemonthendreport.clickReport_ToGenerate_FeeMonthEndReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeMonthEndReport_AfterClearingFilledData Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeMonthEndReport_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeMonthEndReport_AfterClearingFilledData");
		}
	}

	@Test(priority = 15)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport Test===========");

			feemonthendreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport");
		}
	}

	@Test(priority = 16)
	public void tcClickOnPrint_ForPrintPreview() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview Test===========");

			feemonthendreport.clickOnPrint_ForPrintPreview();

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
