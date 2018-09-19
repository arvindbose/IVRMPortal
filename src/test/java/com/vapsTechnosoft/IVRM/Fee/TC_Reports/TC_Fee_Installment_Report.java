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

import com.vapsTechnosoft.IVRM.Fee.Reports.Fee_Installment_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Fee_Installment_Report extends	TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Fee_Installment_Report.class.getName());

	Fee_Installment_Report feeinstallmentreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_FeeInstallment_CategoryWise")
	public String[][] getTestAdmNoData() {
		String[][] testRecordsFeeInstallment = getData("FeeReportsData.xlsx", "FeeInstallment_CategoryWise");
		return testRecordsFeeInstallment;
	}
	@DataProvider(name = "Reports_FeeInstallment_ClassWise")
	public String[][] getTestNameData() {
		String[][] testRecordsFeeInstallment_ClassWise = getData("FeeReportsData.xlsx", "FeeInstallment_ClassWise");
		return testRecordsFeeInstallment_ClassWise;
	}
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeinstallmentreport = new Fee_Installment_Report(driver);
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

			boolean status = feeinstallmentreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFee_Reports_FeeInstallmentReport() {

		try {
			log.info("============= Strting tcNavigateToFee_Reports_FeeInstallmentReport Test===========");

			feeinstallmentreport.navigateToFee_Reports_FeeInstallmentReport();

			log.info("============= Finished tcNavigateToFee_Reports_FeeInstallmentReport Test===========");
			getScreenShot("tcNavigateToFee_Reports_FeeInstallmentReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFee_Reports_FeeInstallmentReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeReports_FeeInstallmentReport_Page() {

		try {
			log.info("============= Strting tcVerifyFeeReports_FeeInstallmentReport_Page Test===========");

			boolean status = feeinstallmentreport.verifyFeeReports_FeeInstallmentReport_Page();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeReports_FeeInstallmentReport_Page Test===========");
			getScreenShot("tcVerifyFeeReports_FeeInstallmentReport_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeReports_FeeInstallmentReport_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_FeeInstallmentReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_FeeInstallmentReportForm Test===========");

			feeinstallmentreport.submitBlank_FeeInstallmentReportForm();

			log.info("============= Finished tcSubmitBlank_FeeInstallmentReportForm Test===========");
			getScreenShot("tcSubmitBlank_FeeInstallmentReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_FeeInstallmentReportForm");
		}
	}

	/*
	 * 
	 */
	@Test(priority = 6, dataProvider = "Reports_FeeInstallment_CategoryWise")
	public void tcFill_FeeInstallmentReportForm_ForCategoryWise(String academicYear, String category, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_FeeInstallmentReportForm_ForCategoryWise Test===========");

			feeinstallmentreport.fill_FeeInstallmentReportForm_ForCategoryWise(academicYear, category);

			log.info(
					"============= Finished tcFill_FeeInstallmentReportForm_ForCategoryWise Test===========");
			getScreenShot("tcFill_FeeInstallmentReportForm_ForCategoryWise");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeInstallmentReportForm_ForCategoryWise");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_FeeInstallmentReport() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeInstallmentReport Test===========");

			feeinstallmentreport.clickReport_ToGenerate_FeeInstallmentReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeInstallmentReport Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeInstallmentReport");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeInstallmentReport");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_FeeInstallmentReport_Form() {

		try {
			log.info("============= Strting tcMinimize_FeeInstallmentReport_Form Test===========");

			feeinstallmentreport.min_Max_FeeInstallmentReport_Form();

			log.info("============= Finished tcMinimize_FeeInstallmentReport_Form Test===========");
			getScreenShot("tcMinimize_FeeInstallmentReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeInstallmentReport_Form");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_FeeInstallmentReport_Grid() {

		try {
			log.info("============= Strting tcMinimize_FeeInstallmentReport_Grid Test===========");

			feeinstallmentreport.min_Max_FeeInstallmentReport_Grid();

			log.info("============= Finished tcMinimize_FeeInstallmentReport_Grid Test===========");
			getScreenShot("tcMinimize_FeeInstallmentReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeInstallmentReport_Grid");
		}
	}

	@Test(priority = 10)
	public void tcMaximize_FeeInstallmentReport_Grid() {

		try {
			log.info("============= Strting tcMaximize_FeeInstallmentReport_Grid Test===========");

			feeinstallmentreport.min_Max_FeeInstallmentReport_Grid();

			log.info("============= Finished tcMaximize_FeeInstallmentReport_Grid Test===========");
			getScreenShot("tcMaximize_FeeInstallmentReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeInstallmentReport_Grid");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_FeeInstallmentReport_Form() {

		try {
			log.info("============= Strting tcMaximize_FeeInstallmentReport_Form Test===========");

			feeinstallmentreport.min_Max_FeeInstallmentReport_Form();

			log.info("============= Finished tcMaximize_FeeInstallmentReport_Form Test===========");
			getScreenShot("tcMaximize_FeeInstallmentReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeInstallmentReport_Form");
		}
	}

	@Test(priority = 12)
	public void tcClickCancelButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm Test===========");

			feeinstallmentreport.clickCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickCancelButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		}
	}

	/*
	 * Category Wise Fee Installment Report
	 */
	@Test(priority = 13, dataProvider = "Reports_FeeInstallment_CategoryWise")
	public void tcFill_FeeInstallmentReportForm_ForCategoryWise_AfterClearingFilledData(String academicYear, String category, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}	try {
			log.info(
					"============= Strting tcFill_FeeInstallmentReportForm_ForCategoryWise_AfterClearingFilledData Test===========");

			feeinstallmentreport.fill_FeeInstallmentReportForm_ForCategoryWise(academicYear, category);

			log.info(
					"============= Finished tcFill_FeeInstallmentReportForm_ForCategoryWise_AfterClearingFilledData Test===========");
			getScreenShot("tcFill_FeeInstallmentReportForm_ForCategoryWise_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeInstallmentReportForm_ForCategoryWise_AfterClearingFilledData");
		}
	}

	@Test(priority = 14)
	public void tcClickReport_ToGenerate_FeeInstallmentReport_ForCategoryWise_Active_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeInstallmentReport_ForCategoryWise_Active_AfterClearingFilledData Test===========");

			feeinstallmentreport.clickReport_ToGenerate_FeeInstallmentReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeInstallmentReport_ForCategoryWise_Active_AfterClearingFilledData Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeInstallmentReport_ForCategoryWise_Active_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeInstallmentReport_ForCategoryWise_Active_AfterClearingFilledData");
		}
	}

	@Test(priority = 15)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_ForCategoryWise() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_ForCategoryWise Test===========");

			feeinstallmentreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_ForCategoryWise Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_ForCategoryWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_ForCategoryWise");
		}
	}

	@Test(priority = 16)
	public void tcClickOnExportToPDF_ToDownLoadPDFReport_ForCategoryWise() {

		try {
			log.info("============= Strting tcClickOnExportToPDF_ToDownLoadPDFReport_ForCategoryWise Test===========");

			feeinstallmentreport.clickOnExportToPDF_ToDownLoadPDFReport();

			log.info("============= Finished tcClickOnExportToPDF_ToDownLoadPDFReport_ForCategoryWise Test===========");
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_ForCategoryWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_ForCategoryWise");
		}
	}
	/*
	 * Class Wise Fee Installment Report
	 */
	@Test(priority = 17, dataProvider = "Reports_FeeInstallment_ClassWise")
	public void tcFill_FeeInstallmentReportForm_ForClassWise(String academicYear, String class_Inst, String section_Inst, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}	try {
			log.info(
					"============= Strting tcFill_FeeInstallmentReportForm_ForClassWise Test===========");

			feeinstallmentreport.fill_FeeInstallmentReportForm_ForClassWise(academicYear, class_Inst, section_Inst);

			log.info(
					"============= Finished tcFill_FeeInstallmentReportForm_ForClassWise Test===========");
			getScreenShot("tcFill_FeeInstallmentReportForm_ForClassWise");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeInstallmentReportForm_ForClassWise");
		}
	}

	@Test(priority = 18)
	public void tcClickReport_ToGenerate_FeeInstallmentReport_ForClassWise() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeInstallmentReport_ForClassWise Test===========");

			feeinstallmentreport.clickReport_ToGenerate_FeeInstallmentReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeInstallmentReport_ForClassWise Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeInstallmentReport_ForClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeInstallmentReport_ForClassWise");
		}
	}

	@Test(priority = 19)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_ForClassWise() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_ForClassWise Test===========");

			feeinstallmentreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_ForClassWise Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_ForClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_ForClassWise");
		}
	}

	@Test(priority = 20)
	public void tcClickOnExportToPDF_ToDownLoadPDFReport_ForClassWise() {

		try {
			log.info("============= Strting tcClickOnExportToPDF_ToDownLoadPDFReport_ForClassWise Test===========");

			feeinstallmentreport.clickOnExportToPDF_ToDownLoadPDFReport();

			log.info("============= Finished tcClickOnExportToPDF_ToDownLoadPDFReport_ForClassWise Test===========");
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_ForClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_ForClassWise");
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
