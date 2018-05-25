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

import com.test.automation.uiAutomation.Admission.Reports.Total_Strength;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Total_Strength extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Total_Strength.class.getName());

	Total_Strength totalstrengthreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_TotalStrengthReport_All")
	public String[][] getTestData() {
		String[][] testRecordsAll = getData("AdmissionReports.xlsx", "TotalStrength_AllData");
		return testRecordsAll;
	}

	@DataProvider(name = "Reports_TotalStrengthReport_Individual")
	public String[][] getIndividualData() {
		String[][] testRecordsIndividual = getData("AdmissionReports.xlsx", "TotalStrength_IndividualData");
		return testRecordsIndividual;
	}

	@DataProvider(name = "Search_TotalStrengthReport")
	public String[][] getSearchData() {
		String[][] testRecordsSearch = getData("AdmissionReports.xlsx", "Search_TotalStrength");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		totalstrengthreport = new Total_Strength(driver);
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

			boolean status = totalstrengthreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Reports_TotalStrength() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Reports_TotalStrength Test===========");

			totalstrengthreport.navigateToAdmission_Reports_TotalStrength();

			log.info("============= Finished tcNavigateToAdmission_Reports_TotalStrength Test===========");
			getScreenShot("tcNavigateToAdmission_Reports_TotalStrength");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Reports_TotalStrength");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAdmissionReports_TotalStrengthReport_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyAdmissionReports_TotalStrengthReport_BGHSPage Test===========");

			boolean status = totalstrengthreport.verifyAdmissionReports_TotalStrengthReport_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAdmissionReports_TotalStrengthReport_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmissionReports_TotalStrengthReport_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmissionReports_TotalStrengthReport_BGHSPage ");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_TotalStrengthReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_TotalStrengthReportForm Test===========");

			totalstrengthreport.submitBlank_TotalStrengthReportForm();

			log.info("============= Finished tcSubmitBlank_TotalStrengthReportForm Test===========");
			getScreenShot("tcSubmitBlank_TotalStrengthReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_TotalStrengthReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_TotalStrengthReport_All")
	public void tcFillTotalStrengthReport_Form_ForALL_Present(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillTotalStrengthReport_Form_ForALL_Present Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForALL_Present(academicYear);

			log.info("============= Finished tcFillTotalStrengthReport_Form_ForALL_Present Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Present");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Present");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_TotalStrengthReport_WithTC() {

		try {
			log.info("============= Strting tcClickReport_ToGenerate_TotalStrengthReport_WithTC Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info("============= Finished tcClickReport_ToGenerate_TotalStrengthReport_WithTC Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_WithTC");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_WithTC");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeTotalStrengthReportForm() {

		try {
			log.info("============= Strting tcMinimizeTotalStrengthReportForm Test===========");

			totalstrengthreport.min_Max_TotalStrenghtReport_Form();

			log.info("============= Finished tcMinimizeTotalStrengthReportForm Test===========");
			getScreenShot("tcMinimizeTotalStrengthReportForm");
		} catch (Exception e) {
			getScreenShot("tcMinimizeTotalStrengthReportForm");
		}
	}

	@Test(priority = 9)
	public void tcMinimizeTotalStrengthReportGrid() {

		try {
			log.info("============= Strting tcMinimizeTotalStrengthReportGrid Test===========");

			totalstrengthreport.min_Max_TotalStrenghtReport_Grid();

			log.info("============= Finished tcMinimizeTotalStrengthReportGrid Test===========");
			getScreenShot("tcMinimizeTotalStrengthReportGrid");
		} catch (Exception e) {
			getScreenShot("tcMinimizeTotalStrengthReportGrid");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeTotalStrengthReportGrid() {

		try {
			log.info("============= Strting tcMaximizeTotalStrengthReportGrid Test===========");

			totalstrengthreport.min_Max_TotalStrenghtReport_Grid();

			log.info("============= Finished tcMaximizeTotalStrengthReportGrid Test===========");
			getScreenShot("tcMaximizeTotalStrengthReportGrid");
		} catch (Exception e) {
			getScreenShot("tcMaximizeTotalStrengthReportGrid");
		}
	}

	@Test(priority = 11)
	public void tcMaximizeTotalStrengthReportForm() {

		try {
			log.info("============= Strting tcMaximizeTotalStrengthReportForm Test===========");

			totalstrengthreport.min_Max_TotalStrenghtReport_Form();

			log.info("============= Finished tcMaximizeTotalStrengthReportForm Test===========");
			getScreenShot("tcMaximizeTotalStrengthReportForm");
		} catch (Exception e) {
			getScreenShot("tcMaximizeTotalStrengthReportForm");
		}
	}

	@Test(priority = 12)
	public void tcClickCancelButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickCancelButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		}
	}

	@Test(priority = 13, dataProvider = "Reports_TotalStrengthReport_All")
	public void tcFillTotalStrengthReport_Form_ForALL_Present_AfterCancel(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillTotalStrengthReport_Form_ForALL_Present_AfterCancel Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForALL_Present(academicYear);

			log.info(
					"============= Finished tcFillTotalStrengthReport_Form_ForALL_Present_AfterCancel Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Present_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Present_AfterCancel");
		}
	}

	@Test(priority = 14)
	public void tcClickReport_ToGenerate_TotalStrengthReport_AllPresent_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_AllPresent_AfterCancel Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_AllPresent_AfterCancel Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_AllPresent_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_AllPresent_AfterCancel");
		}
	}

	@Test(priority = 15, dataProvider = "Search_TotalStrengthReport")
	public void tcSearchWithClassName_InTotalStrengthReportGrid(String Class_Name, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassName_InTotalStrengthReportGrid Test===========");

			totalstrengthreport.searchWithClassName_InTotalStrengthReportGrid(Class_Name);

			log.info("============= Finished tcSearchWithClassName_InTotalStrengthReportGrid Test===========");
			getScreenShot("tcSearchWithClassName_InTotalStrengthReportGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassName_InTotalStrengthReportGrid");
		}
	}

	@Test(priority = 16)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_AllPresent() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_AllPresent Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_AllPresent Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_AllPresent");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_AllPresent");
		}
	}

	@Test(priority = 17)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_AllWithTCAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_AllWithTCAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_AllWithTCAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_AllWithTCAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_AllWithTCAction");
		}
	}

	@Test(priority = 18, dataProvider = "Reports_TotalStrengthReport_All")
	public void tcFillTotalStrengthReport_Form_ForALL_Present_WithTC(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillTotalStrengthReport_Form_ForALL_Present_WithTC Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForALL_Present_WithTC(academicYear);

			log.info("============= Finished tcFillTotalStrengthReport_Form_ForALL_Present_WithTC Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Present_WithTC");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Present_WithTC");
		}
	}

	@Test(priority = 19)
	public void tcClickReport_ToGenerate_TotalStrengthReport_AllWithTC() {

		try {
			log.info("============= Strting tcClickReport_ToGenerate_TotalStrengthReport_AllWithTC Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info("============= Finished tcClickReport_ToGenerate_TotalStrengthReport_AllWithTC Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_AllWithTC");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_AllWithTC");
		}
	}

	@Test(priority = 20)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_AllWithTC() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_AllWithTC Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_AllWithTC Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_AllWithTC");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_AllWithTC");
		}
	}

	@Test(priority = 21)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_AllWithDeactive() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_AllWithDeactive Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_AllWithDeactive Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_AllWithDeactive");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_AllWithDeactive");
		}
	}

	@Test(priority = 22, dataProvider = "Reports_TotalStrengthReport_All")
	public void tcFillTotalStrengthReport_Form_ForALL_Present_WithDeactive(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillTotalStrengthReport_Form_ForALL_Present_WithDeactive Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForALL_Present_WithDeactive(academicYear);

			log.info(
					"============= Finished tcFillTotalStrengthReport_Form_ForALL_Present_WithDeactive Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Present_WithDeactive");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Present_WithDeactive");
		}
	}

	@Test(priority = 23)
	public void tcClickReport_ToGenerate_TotalStrengthReport_AllWithDeactive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_AllWithDeactive Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_AllWithDeactive Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_AllWithDeactive");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_AllWithDeactive");
		}
	}

	@Test(priority = 24)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_AllWithDeactive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_AllWithDeactive Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_AllWithDeactive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_AllWithDeactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_AllWithDeactive");
		}
	}

	@Test(priority = 25)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_AllWith_TC_AND_Deactive() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_AllWith_TC_AND_Deactive Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_AllWith_TC_AND_Deactive Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_AllWith_TC_AND_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_AllWith_TC_AND_Deactive");
		}
	}

	@Test(priority = 26, dataProvider = "Reports_TotalStrengthReport_All")
	public void tcFillTotalStrengthReport_Form_ForALL_Present_With_TC_AND_Deactive(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillTotalStrengthReport_Form_ForALL_Present_With_TC_AND_Deactive Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForALL_Present_WithTCAndDeactive(academicYear);

			log.info(
					"============= Finished tcFillTotalStrengthReport_Form_ForALL_Present_With_TC_AND_Deactive Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Present_With_TC_AND_Deactive");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Present_With_TC_AND_Deactive");
		}
	}

	@Test(priority = 27)
	public void tcClickReport_ToGenerate_TotalStrengthReport_AllWith_TC_AND_Deactive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_AllWith_TC_AND_Deactive Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_AllWith_TC_AND_Deactive Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_AllWith_TC_AND_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_AllWith_TC_AND_Deactive");
		}
	}

	@Test(priority = 28)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_AllWith_TC_AND_Deactive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_AllWith_TC_AND_Deactive Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_AllWith_TC_AND_Deactive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_AllWith_TC_AND_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_AllWith_TC_AND_Deactive");
		}
	}

	@Test(priority = 29)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_AllLeftAction() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm_ToPerformLeftAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerformLeftAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerformLeftAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerformLeftAction");
		}
	}

	@Test(priority = 30, dataProvider = "Reports_TotalStrengthReport_All")
	public void tcFillTotalStrengthReport_Form_ForALL_Left(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillTotalStrengthReport_Form_ForALL_Left Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForALL_Left(academicYear);

			log.info("============= Finished tcFillTotalStrengthReport_Form_ForALL_Left Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Left");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Left");
		}
	}

	@Test(priority = 31)
	public void tcClickReport_ToGenerate_TotalStrengthReport_AllLeft() {

		try {
			log.info("============= Strting tcClickReport_ToGenerate_TotalStrengthReport_AllLeft Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info("============= Finished tcClickReport_ToGenerate_TotalStrengthReport_AllLeft Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_AllLeft");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_AllLeft");
		}
	}

	@Test(priority = 32)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_AllLeft() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_AllLeft Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info("============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_AllLeft Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_AllLeft");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_AllLeft");
		}
	}

	@Test(priority = 33)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_AllDeactiveAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_AllDeactiveAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_AllDeactiveAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_AllDeactiveAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_AllDeactiveAction");
		}
	}

	@Test(priority = 34, dataProvider = "Reports_TotalStrengthReport_All")
	public void tcFillTotalStrengthReport_Form_ForALL_Deactive(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillTotalStrengthReport_Form_ForALL_Deactive Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForALL_Deactive(academicYear);

			log.info("============= Finished tcFillTotalStrengthReport_Form_ForALL_Deactive Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Deactive");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_Deactive");
		}
	}

	@Test(priority = 35)
	public void tcClickReport_ToGenerate_TotalStrengthReport_All_Deactive() {

		try {
			log.info("============= Strting tcClickReport_ToGenerate_TotalStrengthReport_All_Deactive Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_All_Deactive Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_All_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_All_Deactive");
		}
	}

	@Test(priority = 36)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_All_Deactive() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_All_Deactive Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_All_Deactive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_All_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_All_Deactive");
		}
	}

	@Test(priority = 37)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_AllOverAllTotalAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_AllOverAllTotalAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_AllOverAllTotalAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_AllOverAllTotalAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_AllOverAllTotalAction");
		}
	}

	@Test(priority = 38, dataProvider = "Reports_TotalStrengthReport_All")
	public void tcFillTotalStrengthReport_Form_ForALL_OverAllTotal(String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillTotalStrengthReport_Form_ForALL_OverAllTotal Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForALL_OverAllTotal(academicYear);

			log.info("============= Finished tcFillTotalStrengthReport_Form_ForALL_OverAllTotal Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_OverAllTotal");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForALL_OverAllTotal");
		}
	}

	@Test(priority = 39)
	public void tcClickReport_ToGenerate_TotalStrengthReport_All_OverAllTotal() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_All_OverAllTotal Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_All_OverAllTotal Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_All_OverAllTotal");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_All_OverAllTotal");
		}
	}

	@Test(priority = 40)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_All_OverAllTotal() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_All_OverAllTotal Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_All_OverAllTotal Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_All_OverAllTotal");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_All_OverAllTotal");
		}
	}

	@Test(priority = 41)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresentAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresentAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresentAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresentAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresentAction");
		}
	}

	@Test(priority = 42, dataProvider = "Reports_TotalStrengthReport_Individual")
	public void tcFillTotalStrengthReport_Form_ForIndividual_Present(String academicYear, String class_Ts,
			String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillTotalStrengthReport_Form_ForIndividual_Present Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForIndividual_Present(academicYear, class_Ts, section);

			log.info("============= Finished tcFillTotalStrengthReport_Form_ForIndividual_Present Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Present");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Present");
		}
	}

	@Test(priority = 43)
	public void tcClickReport_ToGenerate_TotalStrengthReport_Individual_Present() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_Individual_Present Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_Individual_Present Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_Present");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_Present");
		}
	}

	@Test(priority = 44)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Present() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Present Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Present Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Present");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Present");
		}
	}

	@Test(priority = 45)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WitcTCAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WitcTCAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WitcTCAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WitcTCAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WitcTCAction");
		}
	}

	@Test(priority = 46, dataProvider = "Reports_TotalStrengthReport_Individual")
	public void tcFillTotalStrengthReport_Form_ForIndividual_Present_WithTC(String academicYear, String class_Ts,
			String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillTotalStrengthReport_Form_ForIndividual_Present_WithTC Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForIndividual_Present_WithTC(academicYear, class_Ts,
					section);

			log.info(
					"============= Finished tcFillTotalStrengthReport_Form_ForIndividual_Present_WithTC Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Present_WithTC");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Present_WithTC");
		}
	}

	@Test(priority = 47)
	public void tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithTC() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithTC Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithTC Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithTC");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithTC");
		}
	}

	@Test(priority = 48)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithTC() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithTC Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithTC Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithTC");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithTC");
		}
	}

	@Test(priority = 49)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WithDeactiveAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WithDeactiveAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WithDeactiveAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WithDeactiveAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WithDeactiveAction");
		}
	}

	@Test(priority = 50, dataProvider = "Reports_TotalStrengthReport_Individual")
	public void tcFillTotalStrengthReport_Form_ForIndividual_Present_WithDeactive(String academicYear, String class_Ts,
			String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillTotalStrengthReport_Form_ForIndividual_Present_WithDeactive Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForIndividual_Present_WithDeactive(academicYear, class_Ts,
					section);

			log.info(
					"============= Finished tcFillTotalStrengthReport_Form_ForIndividual_Present_WithDeactive Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Present_WithDeactive");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Present_WithDeactive");
		}
	}

	@Test(priority = 51)
	public void tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithDeactive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithDeactive Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithDeactive Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithDeactive");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithDeactive");
		}
	}

	@Test(priority = 52)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithDeactive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithDeactive Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithDeactive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithDeactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithDeactive");
		}
	}

	@Test(priority = 53)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WithTC_AND_DeactiveAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WithTC_AND_DeactiveAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WithTC_AND_DeactiveAction Test===========");
			getScreenShot(
					"tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WithTC_AND_DeactiveAction");
		} catch (Exception e) {
			getScreenShot(
					"tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualPresent_WithTC_AND_DeactiveAction");
		}
	}

	@Test(priority = 54, dataProvider = "Reports_TotalStrengthReport_Individual")
	public void tcFillTotalStrengthReport_Form_ForIndividual_Present_WithTC_AND_Deactive(String academicYear,
			String class_Ts, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFillTotalStrengthReport_Form_ForIndividual_Present_WithTC_AND_Deactive Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForIndividual_Present_WithTC_AND_Deactive(academicYear,
					class_Ts, section);

			log.info(
					"============= Finished tcFillTotalStrengthReport_Form_ForIndividual_Present_WithTC_AND_Deactive Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Present_WithTC_AND_Deactive");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Present_WithTC_AND_Deactive");
		}
	}

	@Test(priority = 55)
	public void tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithTC_AND_Deactive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithTC_AND_Deactive Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithTC_AND_Deactive Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithTC_AND_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_PresentWithTC_AND_Deactive");
		}
	}

	@Test(priority = 56)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithTC_AND_Deactive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithTC_AND_Deactive Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithTC_AND_Deactive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithTC_AND_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_PresentWithTC_AND_Deactive");
		}
	}

	@Test(priority = 57)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualLeftAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualLeftAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualLeftAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualLeftAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualLeftAction");
		}
	}

	@Test(priority = 58, dataProvider = "Reports_TotalStrengthReport_Individual")
	public void tcFillTotalStrengthReport_Form_ForIndividual_Left(String academicYear, String class_Ts, String section,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillTotalStrengthReport_Form_ForIndividual_Left Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForIndividual_Left(academicYear, class_Ts, section);

			log.info("============= Finished tcFillTotalStrengthReport_Form_ForIndividual_Left Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Left");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Left");
		}
	}

	@Test(priority = 59)
	public void tcClickReport_ToGenerate_TotalStrengthReport_Individual_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_Individual_Left Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_Individual_Left Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_Left");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_Left");
		}
	}

	@Test(priority = 60)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Left Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Left");
		}
	}

	@Test(priority = 61)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualDeactiveAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualDeactiveAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualDeactiveAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualDeactiveAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualDeactiveAction");
		}
	}

	@Test(priority = 62, dataProvider = "Reports_TotalStrengthReport_Individual")
	public void tcFillTotalStrengthReport_Form_ForIndividual_Deactive(String academicYear, String class_Ts,
			String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillTotalStrengthReport_Form_ForIndividual_Deactive Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForIndividual_Deactive(academicYear, class_Ts, section);

			log.info("============= Finished tcFillTotalStrengthReport_Form_ForIndividual_Deactive Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Deactive");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_Deactive");
		}
	}

	@Test(priority = 63)
	public void tcClickReport_ToGenerate_TotalStrengthReport_Individual_Deactive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_Individual_Deactive Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_Individual_Deactive Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_Deactive");
		}
	}

	@Test(priority = 64)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Deactive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Deactive Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Deactive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_Deactive");
		}
	}

	@Test(priority = 65)
	public void tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualOverAllTotalAction() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualOverAllTotalAction Test===========");

			totalstrengthreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualOverAllTotalAction Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualOverAllTotalAction");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm_ToPerform_IndividualOverAllTotalAction ");
		}
	}

	@Test(priority = 66, dataProvider = "Reports_TotalStrengthReport_Individual")
	public void tcFillTotalStrengthReport_Form_ForIndividual_OverAllTotal(String academicYear, String class_Ts,
			String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillTotalStrengthReport_Form_ForIndividual_OverAllTotal Test===========");

			totalstrengthreport.fillTotalStrengthReport_Form_ForIndividual_OverAllTotal(academicYear, class_Ts,
					section);

			log.info(
					"============= Finished tcFillTotalStrengthReport_Form_ForIndividual_OverAllTotal Test===========");
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_OverAllTotal");
		} catch (Exception e) {
			getScreenShot("tcFillTotalStrengthReport_Form_ForIndividual_OverAllTotal");
		}
	}

	@Test(priority = 67)
	public void tcClickReport_ToGenerate_TotalStrengthReport_Individual_OverAllTotal() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_TotalStrengthReport_Individual_OverAllTotal Test===========");

			totalstrengthreport.clickReport_ToGenerate_TotalStrengthReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_TotalStrengthReport_Individual_OverAllTotal Test===========");
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_OverAllTotal");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_TotalStrengthReport_Individual_OverAllTotal");
		}
	}

	@Test(priority = 68)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_OverAllTotal() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_OverAllTotal Test===========");

			totalstrengthreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_OverAllTotal Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_OverAllTotal");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_Individual_OverAllTotal");
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
