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

import com.vapsTechnosoft.IVRM.Fee.Reports.Fee_ITReceipt_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Fee_ITReceipt_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Fee_ITReceipt_Report.class.getName());

	Fee_ITReceipt_Report feeitreceiptreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_FeeITReceiptTestData")
	public String[][] getTestWrittenData() {
		String[][] testRecordsFeeITReceipt = getData("FeeReportsData.xlsx", "FeeItReceiptReportData");
		return testRecordsFeeITReceipt;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeitreceiptreport = new Fee_ITReceipt_Report(driver);
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

			boolean status = feeitreceiptreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFee_Reports_FeeITReceiptReport() {

		try {
			log.info("============= Strting tcNavigateToFee_Reports_FeeITReceiptReport Test===========");

			feeitreceiptreport.navigateToFee_Reports_FeeITReceiptReport();

			log.info("============= Finished tcNavigateToFee_Reports_FeeITReceiptReport Test===========");
			getScreenShot("tcNavigateToFee_Reports_FeeITReceiptReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFee_Reports_FeeITReceiptReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeReports_FeeITReceiptReport_Page() {

		try {
			log.info("============= Strting tcVerifyFeeReports_FeeITReceiptReport_Page Test===========");

			boolean status = feeitreceiptreport.verifyFeeReports_FeeITReceiptReport_Page();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeReports_FeeITReceiptReport_Page Test===========");
			getScreenShot("tcVerifyFeeReports_FeeITReceiptReport_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeReports_FeeITReceiptReport_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_FeeITReceiptReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_FeeITReceiptReportForm Test===========");

			feeitreceiptreport.submitBlank_FeeITReceiptReportForm();

			log.info("============= Finished tcSubmitBlank_FeeITReceiptReportForm Test===========");
			getScreenShot("tcSubmitBlank_FeeITReceiptReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_FeeITReceiptReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_FeeITReceiptTestData")
	public void tcFill_FeeITReceiptReportForm(String academicYear, String class_It, String section_it,
			String student_Name, String receipt_No, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeITReceiptReportForm Test===========");

			feeitreceiptreport.fill_FeeITReceiptReportForm(academicYear, class_It, section_it, student_Name,
					receipt_No);

			log.info("============= Finished tcFill_FeeITReceiptReportForm Test===========");
			getScreenShot("tcFill_FeeITReceiptReportForm");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeITReceiptReportForm");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_FeeITReceiptReport() {

		try {
			log.info("============= Strting tcClickReport_ToGenerate_FeeITReceiptReport Test===========");

			feeitreceiptreport.clickReport_ToGenerate_FeeITReceiptReport();

			log.info("============= Finished tcClickReport_ToGenerate_FeeITReceiptReport Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeITReceiptReport");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeITReceiptReport");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_FeeITReceiptReport_Form() {

		try {
			log.info("============= Strting tcMinimize_FeeITReceiptReport_Form Test===========");

			feeitreceiptreport.min_Max_FeeITReceiptReport_Form();
			log.info("============= Finished tcMinimize_FeeITReceiptReport_Form Test===========");
			getScreenShot("tcMinimize_FeeITReceiptReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeITReceiptReport_Form");
		}
	}

	@Test(priority = 9)
	public void tcMaximize_FeeITReceiptReport_Form() {

		try {
			log.info("============= Strting tcMaximize_FeeITReceiptReport_Form Test===========");

			feeitreceiptreport.min_Max_FeeITReceiptReport_Form();

			log.info("============= Finished tcMaximize_FeeITReceiptReport_Form Test===========");
			getScreenShot("tcMaximize_FeeITReceiptReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeITReceiptReport_Form");
		}
	}

	@Test(priority = 10)
	public void tcClickClearButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickClearButton_ToClearFilledForm Test===========");

			feeitreceiptreport.clickClearButton_ToClearFilledForm();

			log.info("============= Finished tcClickClearButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickClearButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickClearButton_ToClearFilledForm");
		}
	}

	@Test(priority = 11, dataProvider = "Reports_FeeITReceiptTestData")
	public void tcFill_FeeITReceiptReportForm_AfterClearingFilledData(String academicYear, String class_It,
			String section_it, String student_Name, String receipt_No, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeITReceiptReportForm_AfterClearingFilledData Test===========");

			feeitreceiptreport.fill_FeeITReceiptReportForm(academicYear, class_It, section_it, student_Name,
					receipt_No);

			log.info("============= Finished tcFill_FeeITReceiptReportForm_AfterClearingFilledData Test===========");
			getScreenShot("tcFill_FeeITReceiptReportForm_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeITReceiptReportForm_AfterClearingFilledData");
		}
	}

	@Test(priority = 12)
	public void tcClickReport_ToGenerate_FeeITReceiptReport_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeITReceiptReport_AfterClearingFilledData Test===========");

			feeitreceiptreport.clickReport_ToGenerate_FeeITReceiptReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeITReceiptReport_AfterClearingFilledData Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeITReceiptReport_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeITReceiptReport_AfterClearingFilledData");
		}
	}

	@Test(priority = 13)
	public void tcClickOnPrint_ForPrintPreview() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview Test===========");

			feeitreceiptreport.clickOnPrint_ForPrintPreview();

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
