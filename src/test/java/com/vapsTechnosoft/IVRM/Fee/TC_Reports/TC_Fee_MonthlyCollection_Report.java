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

import com.vapsTechnosoft.IVRM.Fee.Reports.Fee_MonthlyCollection_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class TC_Fee_MonthlyCollection_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Fee_MonthlyCollection_Report.class.getName());

	Fee_MonthlyCollection_Report feemonthlycollectionreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_FeeMonthlyCollection_AdmNo")
	public String[][] getTestAdmNoData() {
		String[][] testRecordsMonthlyCollection = getData("FeeReportsData.xlsx", "Fee_MonthlyCollectionData_AdmNo");
		return testRecordsMonthlyCollection;
	}
	@DataProvider(name = "Reports_FeeMonthlyCollection_Name")
	public String[][] getTestNameData() {
		String[][] testRecordsMonthlyCollection_Name = getData("FeeReportsData.xlsx", "Fee_MonthlyCollectionData_Name");
		return testRecordsMonthlyCollection_Name;
	}
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		feemonthlycollectionreport = new Fee_MonthlyCollection_Report(driver);
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

			boolean status = feemonthlycollectionreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFee_Reports_FeeMonthlyCollectionReport() {

		try {
			log.info("============= Strting tcNavigateToFee_Reports_FeeMonthlyCollectionReport Test===========");

			feemonthlycollectionreport.navigateToFee_Reports_FeeMonthlyCollectionReport();

			log.info("============= Finished tcNavigateToFee_Reports_FeeMonthlyCollectionReport Test===========");
			getScreenShot("tcNavigateToFee_Reports_FeeMonthlyCollectionReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFee_Reports_FeeMonthlyCollectionReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeReports_FeeMonthlyCollectionReport_Page() {

		try {
			log.info("============= Strting tcVerifyFeeReports_FeeMonthlyCollectionReport_Page Test===========");

			boolean status = feemonthlycollectionreport.verifyFeeReports_FeeMonthlyCollectionReport_Page();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeReports_FeeMonthlyCollectionReport_Page Test===========");
			getScreenShot("tcVerifyFeeReports_FeeMonthlyCollectionReport_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeReports_FeeMonthlyCollectionReport_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_FeeMonthlyCollectionReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_FeeMonthlyCollectionReportForm Test===========");

			feemonthlycollectionreport.submitBlank_FeeMonthlyCollectionReportForm();

			log.info("============= Finished tcSubmitBlank_FeeMonthlyCollectionReportForm Test===========");
			getScreenShot("tcSubmitBlank_FeeMonthlyCollectionReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_FeeMonthlyCollectionReportForm");
		}
	}

	/*
	 * 
	 */
	@Test(priority = 6)
	public void tcFill_FeeMonthlyCollectionReportForm_All_ForActiveStudent() {
		try {
			log.info(
					"============= Strting tcFill_FeeMonthlyCollectionReportForm_All_ForActiveStudent Test===========");

			feemonthlycollectionreport.fill_FeeMonthlyCollectionReportForm_All_ForActiveStudent();

			log.info(
					"============= Finished tcFill_FeeMonthlyCollectionReportForm_All_ForActiveStudent Test===========");
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_All_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_All_ForActiveStudent");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Active Test===========");

			feemonthlycollectionreport.clickReport_ToGenerate_FeeMonthlyCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Active Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Active");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Active");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_FeeMonthlyCollectionReport_Form() {

		try {
			log.info("============= Strting tcMinimize_FeeMonthlyCollectionReport_Form Test===========");

			feemonthlycollectionreport.min_Max_FeeMonthlyCollectionReport_Form();

			log.info("============= Finished tcMinimize_FeeMonthlyCollectionReport_Form Test===========");
			getScreenShot("tcMinimize_FeeMonthlyCollectionReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeMonthlyCollectionReport_Form");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_FeeMonthlyCollectionReport_Grid() {

		try {
			log.info("============= Strting tcMinimize_FeeMonthlyCollectionReport_Grid Test===========");

			feemonthlycollectionreport.min_Max_FeeMonthlyCollectionReport_Grid();

			log.info("============= Finished tcMinimize_FeeMonthlyCollectionReport_Grid Test===========");
			getScreenShot("tcMinimize_FeeMonthlyCollectionReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeMonthlyCollectionReport_Grid");
		}
	}

	@Test(priority = 10)
	public void tcMaximize_FeeMonthlyCollectionReport_Grid() {

		try {
			log.info("============= Strting tcMaximize_FeeMonthlyCollectionReport_Grid Test===========");

			feemonthlycollectionreport.min_Max_FeeMonthlyCollectionReport_Grid();

			log.info("============= Finished tcMaximize_FeeMonthlyCollectionReport_Grid Test===========");
			getScreenShot("tcMaximize_FeeMonthlyCollectionReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeMonthlyCollectionReport_Grid");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_FeeMonthlyCollectionReport_Form() {

		try {
			log.info("============= Strting tcMaximize_FeeMonthlyCollectionReport_Form Test===========");

			feemonthlycollectionreport.min_Max_FeeMonthlyCollectionReport_Form();

			log.info("============= Finished tcMaximize_FeeMonthlyCollectionReport_Form Test===========");
			getScreenShot("tcMaximize_FeeMonthlyCollectionReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeMonthlyCollectionReport_Form");
		}
	}

	@Test(priority = 12)
	public void tcClickCancelButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm Test===========");

			feemonthlycollectionreport.clickCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickCancelButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		}
	}

	/*
	 * All, Active
	 */
	@Test(priority = 13)
	public void tcFill_FeeMonthlyCollectionReportForm_All_ForActiveStudent_AfterClearingFilledData() {
		try {
			log.info(
					"============= Strting tcFill_FeeMonthlyCollectionReportForm_All_ForActiveStudent_AfterClearingFilledData Test===========");

			feemonthlycollectionreport.fill_FeeMonthlyCollectionReportForm_All_ForActiveStudent();

			log.info(
					"============= Finished tcFill_FeeMonthlyCollectionReportForm_All_ForActiveStudent_AfterClearingFilledData Test===========");
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_All_ForActiveStudent_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_All_ForActiveStudent_AfterClearingFilledData");
		}
	}

	@Test(priority = 14)
	public void tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Active_AfterClearingFilledData() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Active_AfterClearingFilledData Test===========");

			feemonthlycollectionreport.clickReport_ToGenerate_FeeMonthlyCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Active_AfterClearingFilledData Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Active_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Active_AfterClearingFilledData");
		}
	}

	@Test(priority = 15)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_All_Active() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_All_Active Test===========");

			feemonthlycollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_All_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_All_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_All_Active");
		}
	}

	@Test(priority = 16)
	public void tcClickOnExportToPDF_ToDownLoadPDFReport_All_Active() {

		try {
			log.info("============= Strting tcClickOnExportToPDF_ToDownLoadPDFReport_All_Active Test===========");

			feemonthlycollectionreport.clickOnExportToPDF_ToDownLoadPDFReport();

			log.info("============= Finished tcClickOnExportToPDF_ToDownLoadPDFReport_All_Active Test===========");
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_All_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_All_Active");
		}
	}

	@Test(priority = 17)
	public void tcClickCancelButton_ToClearFilledForm_ForAllLeftReport() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm_ForAllLeftReport Test===========");

			feemonthlycollectionreport.clickCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickCancelButton_ToClearFilledForm_ForAllLeftReport Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForAllLeftReport");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForAllLeftReport");
		}
	}

	/*
	 * All, Left
	 */
	@Test(priority = 18)
	public void tcFill_FeeMonthlyCollectionReportForm_All_ForLeftStudent() {
		try {
			log.info("============= Strting tcFill_FeeMonthlyCollectionReportForm_All_ForLeftStudent Test===========");

			feemonthlycollectionreport.fill_FeeMonthlyCollectionReportForm_All_ForLeftStudent();

			log.info("============= Finished tcFill_FeeMonthlyCollectionReportForm_All_ForLeftStudent Test===========");
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_All_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_All_ForLeftStudent");
		}
	}

	@Test(priority = 19)
	public void tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Left Test===========");

			feemonthlycollectionreport.clickReport_ToGenerate_FeeMonthlyCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Left Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Left");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_All_Left");
		}
	}

	@Test(priority = 20)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_All_Left() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_All_Left Test===========");

			feemonthlycollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_All_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_All_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_All_Left");
		}
	}

	@Test(priority = 21)
	public void tcClickOnExportToPDF_ToDownLoadPDFReport_All_Left() {

		try {
			log.info("============= Strting tcClickOnExportToPDF_ToDownLoadPDFReport_All_Left Test===========");

			feemonthlycollectionreport.clickOnExportToPDF_ToDownLoadPDFReport();

			log.info("============= Finished tcClickOnExportToPDF_ToDownLoadPDFReport_All_Left Test===========");
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_All_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_All_Left");
		}
	}

	@Test(priority = 22)
	public void tcClickCancelButton_ToClearFilledForm_ForIndividualActiveAdmNoReport() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ForIndividualActiveAdmNoReport Test===========");

			feemonthlycollectionreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ForIndividualActiveAdmNoReport Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForIndividualActiveAdmNoReport");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForIndividualActiveAdmNoReport");
		}
	}

	/*
	 * Individual, Active, Adm No
	 */
	@Test(priority = 23,dataProvider = "Reports_FeeMonthlyCollection_AdmNo")
	public void tcFill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForActiveStudent(String studentName,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}

		try {
			log.info(
					"============= Strting tcFill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForActiveStudent Test===========");

			feemonthlycollectionreport
					.fill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForActiveStudent(studentName);

			log.info(
					"============= Finished tcFill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForActiveStudent Test===========");
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForActiveStudent");
		}
	}

	@Test(priority = 24)
	public void tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Active Test===========");

			feemonthlycollectionreport.clickReport_ToGenerate_FeeMonthlyCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Active Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Active");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Active");
		}
	}

	@Test(priority = 25)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_AdmNo_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_AdmNo_Active Test===========");

			feemonthlycollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_AdmNo_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_AdmNo_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_AdmNo_Active");
		}
	}

	@Test(priority = 26)
	public void tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_AdmNo_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_AdmNo_Active Test===========");

			feemonthlycollectionreport.clickOnExportToPDF_ToDownLoadPDFReport();

			log.info(
					"============= Finished tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_AdmNo_Active Test===========");
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_AdmNo_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_AdmNo_Active");
		}
	}

	@Test(priority = 27)
	public void tcClickCancelButton_ToClearFilledForm_ForIndividualLeftAdmNoReport() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ForIndividualLeftAdmNoReport Test===========");

			feemonthlycollectionreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ForIndividualLeftAdmNoReport Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForIndividualLeftAdmNoReport");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForIndividualLeftAdmNoReport");
		}
	}

	/*
	 * Individual, Left, Adm No
	 */
	@Test(priority = 28,dataProvider = "Reports_FeeMonthlyCollection_AdmNo")
	public void tcFill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForLeftStudent(String studentName,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}

		try {
			log.info(
					"============= Strting tcFill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForLeftStudent Test===========");

			feemonthlycollectionreport.fill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForLeftStudent(studentName);

			log.info(
					"============= Finished tcFill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForLeftStudent Test===========");
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_Individual_AdmNo_ForLeftStudent");
		}
	}

	@Test(priority = 29)
	public void tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Left Test===========");

			feemonthlycollectionreport.clickReport_ToGenerate_FeeMonthlyCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Left Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Left");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Left");
		}
	}

	@Test(priority = 30)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_AdmNo_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_AdmNo_Left Test===========");

			feemonthlycollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_AdmNo_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_AdmNo_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_AdmNo_Left");
		}
	}

	@Test(priority = 31)
	public void tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_AdmNo_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_AdmNo_Left Test===========");

			feemonthlycollectionreport.clickOnExportToPDF_ToDownLoadPDFReport();

			log.info(
					"============= Finished tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_AdmNo_Left Test===========");
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_AdmNo_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_AdmNo_Left");
		}
	}

	@Test(priority = 32)
	public void tcClickCancelButton_ToClearFilledForm_ForIndividualActiveNameReport() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ForIndividualActiveNameReport Test===========");

			feemonthlycollectionreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ForIndividualActiveNameReport Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForIndividualActiveNameReport");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForIndividualActiveNameReport");
		}
	}

	/*
	 * Individual, Active, Name
	 */
	@Test(priority = 33,dataProvider = "Reports_FeeMonthlyCollection_Name")
	public void tcFill_FeeMonthlyCollectionReportForm_Individual_Name_ForActiveStudent(String studentName,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}

		try {
			log.info(
					"============= Strting tcFill_FeeMonthlyCollectionReportForm_Individual_Name_ForActiveStudent Test===========");

			feemonthlycollectionreport
					.fill_FeeMonthlyCollectionReportForm_Individual_Name_ForActiveStudent(studentName);

			log.info(
					"============= Finished tcFill_FeeMonthlyCollectionReportForm_Individual_Name_ForActiveStudent Test===========");
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_Individual_Name_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_Individual_Name_ForActiveStudent");
		}
	}

	@Test(priority = 34)
	public void tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_Name_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_Name_Active Test===========");

			feemonthlycollectionreport.clickReport_ToGenerate_FeeMonthlyCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_Name_Active Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_AdmNo_Active");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_Name_Active");
		}
	}

	@Test(priority = 35)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Name_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Name_Active Test===========");

			feemonthlycollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Name_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Name_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Name_Active");
		}
	}

	@Test(priority = 36)
	public void tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_Name_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_Name_Active Test===========");

			feemonthlycollectionreport.clickOnExportToPDF_ToDownLoadPDFReport();

			log.info(
					"============= Finished tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_Name_Active Test===========");
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_Name_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_Name_Active");
		}
	}

	@Test(priority = 37)
	public void tcClickCancelButton_ToClearFilledForm_ForIndividualLeftNameReport() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ForIndividualLeftNameReport Test===========");

			feemonthlycollectionreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ForIndividualLeftNameReport Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForIndividualLeftNameReport");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ForIndividualLeftNameReport");
		}
	}

	/*
	 * Individual, Left, Name
	 */
	@Test(priority = 38,dataProvider = "Reports_FeeMonthlyCollection_Name")
	public void tcFill_FeeMonthlyCollectionReportForm_Individual_Name_ForLeftStudent(String studentName,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}

		try {
			log.info(
					"============= Strting tcFill_FeeMonthlyCollectionReportForm_Individual_Name_ForLeftStudent Test===========");

			feemonthlycollectionreport.fill_FeeMonthlyCollectionReportForm_Individual_Name_ForLeftStudent(studentName);

			log.info(
					"============= Finished tcFill_FeeMonthlyCollectionReportForm_Individual_Name_ForLeftStudent Test===========");
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_Individual_Name_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMonthlyCollectionReportForm_Individual_Name_ForLeftStudent");
		}
	}

	@Test(priority = 39)
	public void tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_Name_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_Name_Left Test===========");

			feemonthlycollectionreport.clickReport_ToGenerate_FeeMonthlyCollectionReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_Name_Left Test===========");
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_Name_Left");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_FeeMonthlyCollectionReport_Individual_Name_Left");
		}
	}

	@Test(priority = 40)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Name_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Name_Left Test===========");

			feemonthlycollectionreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Name_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Name_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Name_Left");
		}
	}

	@Test(priority = 41)
	public void tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_Name_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_Name_Left Test===========");

			feemonthlycollectionreport.clickOnExportToPDF_ToDownLoadPDFReport();

			log.info(
					"============= Finished tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_Name_Left Test===========");
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_Name_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToPDF_ToDownLoadPDFReport_Individual_Name_Left");
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
