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

import com.vapsTechnosoft.IVRM.Fee.Reports.Yearly_Fee_Defaulter_Report;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Yearly_Fee_Defaulter_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Yearly_Fee_Defaulter_Report.class.getName());

	Yearly_Fee_Defaulter_Report yearlyfeedefaulterreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public String[][] getTestWithoutStudentData() {
		String[][] testRecordsYearlyFeeDefaulter = getData("FeeReportsData.xlsx", "YearlyFeeDefaulter_WithoutClass");
		return testRecordsYearlyFeeDefaulter;
	}

	@DataProvider(name = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public String[][] getTestWithStudentData() {
		String[][] testRecordsYearlyFeeDefaulterWithStudent = getData("FeeReportsData.xlsx",
				"YearlyFeeDefaulter_WithClass");
		return testRecordsYearlyFeeDefaulterWithStudent;
	}

	@DataProvider(name = "Search_YearlyFeeDefaulterReportData")
	public String[][] getTestSearchData() {
		String[][] testRecordsYearlyFeeDefaulterSearch = getData("FeeReportsData.xlsx", "Search_YearlyFeeDefaulter");
		return testRecordsYearlyFeeDefaulterSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		yearlyfeedefaulterreport = new Yearly_Fee_Defaulter_Report(driver);
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

			boolean status = yearlyfeedefaulterreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFee_Reports_YearlyFeeDefaulterReport() {

		try {
			log.info("============= Strting tcNavigateToFee_Reports_YearlyFeeDefaulterReport Test===========");

			yearlyfeedefaulterreport.navigateToFee_Reports_YearlyFeeDefaulterReport();

			log.info("============= Finished tcNavigateToFee_Reports_YearlyFeeDefaulterReport Test===========");
			getScreenShot("tcNavigateToFee_Reports_YearlyFeeDefaulterReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFee_Reports_YearlyFeeDefaulterReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeReports_YearlyFeeDefaulterReport_Page() {

		try {
			log.info("============= Strting tcVerifyFeeReports_YearlyFeeDefaulterReport_Page Test===========");

			boolean status = yearlyfeedefaulterreport.verifyFeeReports_YearlyFeeDefaulterReport_Page();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeReports_YearlyFeeDefaulterReport_Page Test===========");
			getScreenShot("tcVerifyFeeReports_YearlyFeeDefaulterReport_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeReports_YearlyFeeDefaulterReport_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_YearlyFeeDefaulterReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_YearlyFeeDefaulterReportForm Test===========");

			yearlyfeedefaulterreport.submitBlank_YearlyFeeDefaulterReportForm();

			log.info("============= Finished tcSubmitBlank_YearlyFeeDefaulterReportForm Test===========");
			getScreenShot("tcSubmitBlank_YearlyFeeDefaulterReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_YearlyFeeDefaulterReportForm");
		}
	}

	/*
	 * 
	 */
	@Test(priority = 6, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent");
		}
	}

	@Test(priority = 7)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise");
		}
	}

	@Test(priority = 8)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_FeeDefaulterReport_Form() {

		try {
			log.info("============= Strting tcMinimize_FeeDefaulterReport_Form Test===========");

			yearlyfeedefaulterreport.min_Max_FeeDefaulterReport_Form();

			log.info("============= Finished tcMinimize_FeeDefaulterReport_Form Test===========");
			getScreenShot("tcMinimize_FeeDefaulterReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeDefaulterReport_Form");
		}
	}

	@Test(priority = 10)
	public void tcSortRecordsByGroupName() {

		try {
			log.info("============= Strting tcSortRecordsByGroupName Test===========");
			getScreenShot("BeforeSorting_tcSortRecordsByGroupName");

			yearlyfeedefaulterreport.sortRecordsByGroupName();

			log.info("============= Finished tcSortRecordsByGroupName Test===========");
			getScreenShot("tcSortRecordsByGroupName");
		} catch (Exception e) {
			getScreenShot("tcSortRecordsByGroupName");
		}
	}

	@Test(priority = 11, dataProvider = "Search_YearlyFeeDefaulterReportData")
	public void tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid(String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid Test===========");

			yearlyfeedefaulterreport.searchWithGroupName_InYearlyFeeDefaulterReportGrid(groupName);

			log.info("============= Finished tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid Test===========");
			getScreenShot("tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_FeeDefaulterReport_Grid() {

		try {
			log.info("============= Strting tcMinimize_FeeDefaulterReport_Grid Test===========");

			yearlyfeedefaulterreport.min_Max_FeeDefaulterReport_Grid();

			log.info("============= Finished tcMinimize_FeeDefaulterReport_Grid Test===========");
			getScreenShot("tcMinimize_FeeDefaulterReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeDefaulterReport_Grid");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_FeeDefaulterReport_Grid() {

		try {
			log.info("============= Strting tcMaximize_FeeDefaulterReport_Grid Test===========");

			yearlyfeedefaulterreport.min_Max_FeeDefaulterReport_Grid();

			log.info("============= Finished tcMaximize_FeeDefaulterReport_Grid Test===========");
			getScreenShot("tcMaximize_FeeDefaulterReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeDefaulterReport_Grid");
		}
	}

	@Test(priority = 14)
	public void tcMaximize_FeeDefaulterReport_Form() {

		try {
			log.info("============= Strting tcMaximize_FeeDefaulterReport_Form Test===========");

			yearlyfeedefaulterreport.min_Max_FeeDefaulterReport_Form();

			log.info("============= Finished tcMaximize_FeeDefaulterReport_Form Test===========");
			getScreenShot("tcMaximize_FeeDefaulterReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeDefaulterReport_Form");
		}
	}

	@Test(priority = 15)
	public void tcClickCancelButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickCancelButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		}
	}

	/*
	 * Fee Group Wise, Active Student(Yearly Wise), Without Student
	 */
	@Test(priority = 16, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterCancel(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterCancel Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterCancel Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_AfterCancel");
		}
	}

	@Test(priority = 17)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Active_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Active_AfterCancel Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Active_AfterCancel Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Active_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Active_AfterCancel");
		}
	}

	@Test(priority = 18)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_Active_AfterCancel() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_Active_AfterCancel Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_Active_AfterCancel Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Active_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Active_AfterCancel");
		}
	}

	@Test(priority = 19)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

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

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active");
		}
	}

	@Test(priority = 21)
	public void tcClickCancelButton_YearlyWise_FeeGroupWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_YearlyWise_FeeGroupWise_ForDeactiveStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeGroupWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeGroupWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeGroupWise_ForDeactiveStudent");
		}
	}

	/*
	 * Fee group wise, Deactive Student(Yearly Wise), Without Student
	 */
	@Test(priority = 22, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 23)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Deactive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Deactive Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Deactive");
		}
	}

	@Test(priority = 24)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_Deactive() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_Deactive Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_Deactive Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Deactive");
		}
	}

	@Test(priority = 25)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Deactive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Deactive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Deactive");
		}
	}

	@Test(priority = 26)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Deactive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Deactive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Deactive");
		}
	}

	@Test(priority = 27)
	public void tcClickCancelButton_YearlyWise_FeeGroupWise_ForLeftStudent() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_YearlyWise_FeeGroupWise_ForLeftStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeGroupWise_ForLeftStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeGroupWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeGroupWise_ForLeftStudent");
		}
	}

	/*
	 * Fee group wise, Left Student(Yearly Wise), Without Student
	 */
	@Test(priority = 28, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent");
		}
	}

	@Test(priority = 29)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Left Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Left Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Left");
		}
	}

	@Test(priority = 30)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_Left() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_Left Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_Left Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Left");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Left");
		}
	}

	@Test(priority = 31)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left");
		}
	}

	@Test(priority = 32)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left");
		}
	}

	@Test(priority = 33)
	public void tcClickCancelButton_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass");
		}
	}

	/*
	 * Fee Group Wise, Active Student(Yearly Wise), With Class
	 */
	@Test(priority = 34, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass(
							academicYear, select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent_SelectClass");
		}
	}

	@Test(priority = 35)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Active_StudentSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Active_StudentSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Active_StudentSelection Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Active_StudentSelection");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Active_StudentSelection");
		}
	}

	@Test(priority = 36)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_Active_StudentSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_Active_StudentSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_Active_StudentSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Active_StudentSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Active_StudentSelection");
		}
	}

	@Test(priority = 37)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Active_ClassSelection");
		}
	}

	@Test(priority = 38)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active_StudentSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active_StudentSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active_StudentSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active_StudentSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Active_StudentSelection");
		}
	}

	@Test(priority = 39)
	public void tcClickCancelButton_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass");
		}
	}

	/*
	 * Fee Group Wise, Deactive Student(Yearly Wise), With Class
	 */
	@Test(priority = 40, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass(
							academicYear, select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForDeactiveStudent_SelectClass");
		}
	}

	@Test(priority = 41)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Deactive_StudentSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Deactive_StudentSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Deactive_StudentSelection Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Deactive_StudentSelection");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Deactive_StudentSelection");
		}
	}

	@Test(priority = 42)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_Deactive_StudentSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_Deactive_StudentSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_Deactive_StudentSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Deactive_StudentSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Deactive_StudentSelection");
		}
	}

	@Test(priority = 43)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Deactive_StudentSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Deactive_StudentSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Deactive_StudentSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Deactive_StudentSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Deactive_StudentSelection");
		}
	}

	@Test(priority = 44)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Deactive_StudentSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Deactive_StudentSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Deactive_StudentSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Deactive_StudentSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Deactive_StudentSelection");
		}
	}

	@Test(priority = 45)
	public void tcClickCancelButton_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass");
		}
	}

	/*
	 * Fee Group Wise, Left Student(Yearly Wise), With Student
	 */
	@Test(priority = 46, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass(academicYear,
							select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForLeftStudent_SelectClass");
		}
	}

	@Test(priority = 47)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeGroupWise_Left_ClassSelection");
		}
	}

	@Test(priority = 48)
	public void tcSelectRecordToGenerateReport_YearlyGroupWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyGroupWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeGroupWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyGroupWise_Left_ClassSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyGroupWise_Left_ClassSelection");
		}
	}

	@Test(priority = 49)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyGroupWise_Left_ClassSelection");
		}
	}

	@Test(priority = 50)
	public void tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyGroupWise_Left_ClassSelection");
		}
	}

	@Test(priority = 51)
	public void tcClickCancelButton_YearlyWise_FeeHeadWise_ForActiveStudent() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_YearlyWise_FeeHeadWise_ForActiveStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeHeadWise_ForActiveStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForActiveStudent");
		}
	}

	/*
	 * Fee Head Wise, Active Student(Yearly Wise), Without Student
	 */
	@Test(priority = 52, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent");
		}
	}

	@Test(priority = 53)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Active Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Active Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Active");
		}
	}

	@Test(priority = 54)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_Active() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_Active Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_Active Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Active");
		}
	}

	@Test(priority = 55)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active");
		}
	}

	@Test(priority = 56)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active");
		}
	}

	@Test(priority = 57)
	public void tcClickCancelButton_YearlyWise_FeeHeadWise_ForDeactiveStudent() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_YearlyWise_FeeHeadWise_ForDeactiveStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeHeadWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForDeactiveStudent");
		}
	}

	/*
	 * Fee Head wise, Deactive Student(Yearly Wise), Without Student
	 */
	@Test(priority = 58, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 59)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Deactive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Deactive Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Deactive");
		}
	}

	@Test(priority = 60)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_Deactive() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_Deactive Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_Deactive Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Deactive");
		}
	}

	@Test(priority = 61)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Deactive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Deactive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Deactive");
		}
	}

	@Test(priority = 62)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Deactive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Deactive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Deactive");
		}
	}

	@Test(priority = 63)
	public void tcClickCancelButton_YearlyWise_FeeHeadWise_ForLeftStudent() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_FeeHeadWise_ForLeftStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeHeadWise_ForLeftStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForLeftStudent");
		}
	}

	/*
	 * Fee Head wise, Left Student(Yearly Wise), Without Student
	 */
	@Test(priority = 64, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent");
		}
	}

	@Test(priority = 65)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Left Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Left Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Left");
		}
	}

	@Test(priority = 66)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_Left() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_Left Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_Left Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Left");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Left");
		}
	}

	@Test(priority = 67)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left");
		}
	}

	@Test(priority = 68)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left");
		}
	}

	@Test(priority = 69)
	public void tcClickCancelButton_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass");
		}
	}

	/*
	 * Fee Head Wise, Active Student(Yearly Wise), With Student
	 */
	@Test(priority = 70, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass(academicYear,
							select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForActiveStudent_SelectClass");
		}
	}

	@Test(priority = 71)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Active_ClassSelection Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Active_ClassSelection");
		}
	}

	@Test(priority = 72)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_Active_ClassSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Active_ClassSelection");
		}
	}

	@Test(priority = 73)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Active_ClassSelection");
		}
	}

	@Test(priority = 74)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active_ClassSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Active_ClassSelection");
		}
	}

	@Test(priority = 75)
	public void tcClickCancelButton_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass");
		}
	}

	/*
	 * Fee Head Wise, Deactive Student(Yearly Wise), With Class
	 */
	@Test(priority = 76, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass(
							academicYear, select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForDeactiveStudent_SelectClass");
		}
	}

	@Test(priority = 77)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Deactive_ClassSelection Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Deactive_ClassSelection");
		}
	}

	@Test(priority = 78)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_Deactive_ClassSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Deactive_ClassSelection");
		}
	}

	@Test(priority = 79)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Deactive_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Deactive_ClassSelection");
		}
	}

	@Test(priority = 80)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Deactive_ClassSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Deactive_ClassSelection");
		}
	}

	@Test(priority = 81)
	public void tcClickCancelButton_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass() {

		try {
			log.info(
					"============= Strting tcClickCancelButton_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass");
		}
	}

	/*
	 * Fee Head Wise, Left Student(Yearly Wise), With Class
	 */
	@Test(priority = 82, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass(academicYear,
							select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeHeadWise_ForLeftStudent_SelectClass");
		}
	}

	@Test(priority = 83)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyFeeHeadWise_Left_ClassSelection");
		}
	}

	@Test(priority = 84)
	public void tcSelectRecordToGenerateReport_YearlyHeadWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyHeadWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_FeeHeadWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyHeadWise_Left_ClassSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyHeadWise_Left_ClassSelection");
		}
	}

	@Test(priority = 85)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyHeadWise_Left_ClassSelection");
		}
	}

	@Test(priority = 86)
	public void tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyHeadWise_Left_ClassSelection");
		}
	}

	@Test(priority = 87)
	public void tcClickCancelButton_YearlyWise_ClassWise_ForActiveStudent() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_ClassWise_ForActiveStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_ClassWise_ForActiveStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForActiveStudent");
		}
	}

	/*
	 * Class Wise, Active Student(Yearly Wise), Without class
	 */
	@Test(priority = 88, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent");
		}
	}

	@Test(priority = 89)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Active Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Active Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Active");
		}
	}

	@Test(priority = 90)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_Active() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_Active Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_ClassWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_Active Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Active");
		}
	}

	@Test(priority = 91)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active");
		}
	}

	@Test(priority = 92)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active");
		}
	}
	@Test(priority = 93)
	public void tcClickCancelButton_YearlyWise_ClassWise_ForDeactiveStudent() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_ClassWise_ForDeactiveStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_ClassWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForDeactiveStudent");
		}
	}

	/*
	 * Fee Class wise, Deactive Student(Yearly Wise), Without Class
	 */
	@Test(priority = 94, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 95)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Deactive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Deactive Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Deactive");
		}
	}

	@Test(priority = 96)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_Deactive() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_Deactive Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_ClassWise();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_Deactive Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Deactive");
		}
	}

	@Test(priority = 97)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Deactive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Deactive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Deactive");
		}
	}

	@Test(priority = 98)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_Deactive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_Deactive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Deactive");
		}
	}
	@Test(priority = 99)
	public void tcClickCancelButton_YearlyWise_ClassWise_ForLeftStudent() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_ClassWise_ForLeftStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_ClassWise_ForLeftStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForLeftStudent");
		}
	}

	/*
	 * Fee Class wise, Left Student(Yearly Wise), Without Class
	 */
	@Test(priority = 100, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent");
		}
	}

	@Test(priority = 101)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Left Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Left Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Left");
		}
	}

	@Test(priority = 102)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_Left() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_Left Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_ClassWise();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_Left Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Left");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Left");
		}
	}

	@Test(priority = 103)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left");
		}
	}

	@Test(priority = 104)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left");
		}
	}
	@Test(priority = 105)
	public void tcClickCancelButton_YearlyWise_ClassWise_ForActiveStudent_SelectClass() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_ClassWise_ForActiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_ClassWise_ForActiveStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForActiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForActiveStudent_SelectClass");
		}
	}

	/*
	 * Fee Class Wise, Active Student(Yearly Wise), With Class
	 */
	@Test(priority = 106, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent_SelectClass(academicYear,
							select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForActiveStudent_SelectClass");
		}
	}

	@Test(priority = 107)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Active_ClassSelection Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Active_ClassSelection");
		}
	}

	@Test(priority = 108)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_ClassWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_Active_ClassSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Active_ClassSelection");
		}
	}

	@Test(priority = 109)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Active_ClassSelection");
		}
	}

	@Test(priority = 110)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active_ClassSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Active_ClassSelection");
		}
	}
	@Test(priority = 111)
	public void tcClickCancelButton_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass");
		}
	}


	/*
	 * Fee Class Wise, Deactive Student(Yearly Wise), With Class
	 */
	@Test(priority = 112, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass(academicYear,
							select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForDeactiveStudent_SelectClass");
		}
	}

	@Test(priority = 113)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Deactive_ClassSelection Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Deactive_ClassSelection");
		}
	}

	@Test(priority = 114)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_ClassWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_Deactive_ClassSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Deactive_ClassSelection");
		}
	}

	@Test(priority = 115)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Deactive_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Deactive_ClassSelection");
		}
	}

	@Test(priority = 116)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_Deactive_ClassSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Deactive_ClassSelection");
		}
	}
	@Test(priority = 117)
	public void tcClickCancelButton_YearlyWise_ClassWise_ForLeftStudent_SelectClas() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_ClassWise_ForLeftStudent_SelectClas Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_ClassWise_ForLeftStudent_SelectClas Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForLeftStudent_SelectClas");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_ClassWise_ForLeftStudent_SelectClas");
		}
	}


	/*
	 * Fee Class Wise, Left Student(Yearly Wise), With Class
	 */
	@Test(priority = 118, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent_SelectClass(String academicYear,
			String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.fill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent_SelectClass(
					academicYear, select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_ClassWise_ForLeftStudent_SelectClass");
		}
	}

	@Test(priority = 119)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyClassWise_Left_ClassSelection");
		}
	}

	@Test(priority = 120)
	public void tcSelectRecordToGenerateReport_YearlyClassWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyClassWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_ClassWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyClassWise_Left_ClassSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyClassWise_Left_ClassSelection");
		}
	}

	@Test(priority = 121)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyClassWise_Left_ClassSelection");
		}
	}

	@Test(priority = 122)
	public void tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyClassWise_Left_ClassSelection");
		}
	}
	@Test(priority = 123)
	public void tcClickCancelButton_YearlyWise_StudentWise_ForActiveStudent() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_StudentWise_ForActiveStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_StudentWise_ForActiveStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForActiveStudent");
		}
	}

	/*
	 * Student Wise
	 */
	/*
	 * Student Wise, Active Student(Yearly Wise), Without Class
	 */
	@Test(priority = 124, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent(
			String academicYear, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent");
		}
	}

	@Test(priority = 125)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Active() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Active Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Active Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Active");
		}
	}

	@Test(priority = 126)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_Active() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_Active Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_StudentWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_Active Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Active");
		}
	}

	@Test(priority = 127)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active");
		}
	}

	@Test(priority = 128)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active");
		}
	}
	@Test(priority = 129)
	public void tcClickCancelButton_YearlyWise_StudentWise_ForDeactiveStudent() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_StudentWise_ForDeactiveStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_StudentWise_ForDeactiveStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForDeactiveStudent");
		}
	}

	/*
	 * Fee Student wise, Deactive Student(Yearly Wise), Without Class
	 */
	@Test(priority = 130, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent");
		}
	}

	@Test(priority = 131)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Deactive() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Deactive Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Deactive");
		}
	}

	@Test(priority = 132)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_Deactive() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_Deactive Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_StudentWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_Deactive Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Deactive");
		}
	}

	@Test(priority = 133)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Deactive() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Deactive Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Deactive");
		}
	}

	@Test(priority = 134)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Deactive() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Deactive Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Deactive Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Deactive");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Deactive");
		}
	}
	@Test(priority = 135)
	public void tcClickCancelButton_YearlyWise_StudentWise_ForLeftStudent() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_StudentWise_ForLeftStudent Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_StudentWise_ForLeftStudent Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForLeftStudent");
		}
	}

	/*
	 * Fee Student wise, Left Student(Yearly Wise), Without Class
	 */
	@Test(priority = 136, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithoutStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent(academicYear);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent");
		}
	}

	@Test(priority = 137)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Left() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Left Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Left Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Left");
		}
	}

	@Test(priority = 138)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_Left() {

		try {
			log.info("============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_Left Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_StudentWise();

			log.info("============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_Left Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Left");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Left");
		}
	}

	@Test(priority = 139)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left");
		}
	}

	@Test(priority = 140)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left() {

		try {
			log.info("============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info("============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left");
		}
	}
	@Test(priority = 141)
	public void tcClickCancelButton_YearlyWise_StudentWise_ForActiveStudent_SelectClass() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_StudentWise_ForActiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_StudentWise_ForActiveStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForActiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForActiveStudent_SelectClass");
		}
	}

	/*
	 * Fee Student Wise, Active Student(Yearly Wise), With Class
	 */
	@Test(priority = 142, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent_SelectClass(academicYear,
							select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForActiveStudent_SelectClass");
		}
	}

	@Test(priority = 143)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Active_ClassSelection Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Active_ClassSelection");
		}
	}

	@Test(priority = 144)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_StudentWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_Active_ClassSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Active_ClassSelection");
		}
	}

	@Test(priority = 145)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Active_ClassSelection");
		}
	}

	@Test(priority = 146)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active_ClassSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Active_ClassSelection");
		}
	}
	@Test(priority = 147)
	public void tcClickCancelButton_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass");
		}
	}

	/*
	 * Fee Student Wise, Deactive Student(Yearly Wise), With Class
	 */
	@Test(priority = 148, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass(
							academicYear, select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForDeactiveStudent_SelectClass");
		}
	}

	@Test(priority = 149)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Deactive_ClassSelection Test===========");
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot(
					"tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Deactive_ClassSelection");
		}
	}

	@Test(priority = 150)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_StudentWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_Deactive_ClassSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Deactive_ClassSelection");
		}
	}

	@Test(priority = 151)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Deactive_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Deactive_ClassSelection");
		}
	}

	@Test(priority = 152)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Deactive_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Deactive_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Deactive_ClassSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Deactive_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Deactive_ClassSelection");
		}
	}
	@Test(priority = 153)
	public void tcClickCancelButton_YearlyWise_StudentWise_ForLeftStudent_SelectClass() {

		try {
			log.info("============= Strting tcClickCancelButton_YearlyWise_StudentWise_ForLeftStudent_SelectClass Test===========");

			yearlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickCancelButton_YearlyWise_StudentWise_ForLeftStudent_SelectClass Test===========");
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForLeftStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_YearlyWise_StudentWise_ForLeftStudent_SelectClass");
		}
	}


	/*
	 * Fee Student Wise, Left Student(Yearly Wise), With Class
	 */
	@Test(priority = 154, dataProvider = "Reports_YearlyFeeDefaulterReportData_WithStudent")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent_SelectClass(
			String academicYear, String select_class, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent_SelectClass Test===========");

			yearlyfeedefaulterreport
					.fill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent_SelectClass(academicYear,
							select_class, section);

			log.info(
					"============= Finished tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent_SelectClass Test===========");
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent_SelectClass");
		} catch (Exception e) {
			getScreenShot("tcFill_YearlyFeeDefaulterReportForm_YearlyWise_StudentWise_ForLeftStudent_SelectClass");
		}
	}

	@Test(priority = 155)
	public void tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

			log.info(
					"============= Finished tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickReport_ToGenerate_YearlyFeeDefaulterReport_YearlyStudentWise_Left_ClassSelection");
		}
	}

	@Test(priority = 156)
	public void tcSelectRecordToGenerateReport_YearlyStudentWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcSelectRecordToGenerateReport_YearlyStudentWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.selectRecordToGenerateReport_StudentWise();

			log.info(
					"============= Finished tcSelectRecordToGenerateReport_YearlyStudentWise_Left_ClassSelection Test===========");
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcSelectRecordToGenerateReport_YearlyStudentWise_Left_ClassSelection");
		}
	}

	@Test(priority = 157)
	public void tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnExportToExcel_ToDownLoadExcelReport();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownLoadExcelReport_YearlyStudentWise_Left_ClassSelection");
		}
	}

	@Test(priority = 158)
	public void tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left_ClassSelection() {

		try {
			log.info(
					"============= Strting tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left_ClassSelection Test===========");

			yearlyfeedefaulterreport.clickOnPrint_ForPrintPreview();

			log.info(
					"============= Finished tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left_ClassSelection Test===========");
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left_ClassSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ForPrintPreview_YearlyStudentWise_Left_ClassSelection");
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
