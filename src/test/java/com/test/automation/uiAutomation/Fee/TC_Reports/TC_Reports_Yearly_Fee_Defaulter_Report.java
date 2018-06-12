/**
 * 
 */
package com.test.automation.uiAutomation.Fee.TC_Reports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Fee.Reports.Reports_Yearly_Fee_Defaulter_Report;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Reports_Yearly_Fee_Defaulter_Report extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Reports_Yearly_Fee_Defaulter_Report.class.getName());

	Reports_Yearly_Fee_Defaulter_Report yarlyfeedefaulterreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData_Staff")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("AdmissionReports.xlsx", "IVRM_StaffLogin_Data");
		return testRecordsLogin;
	}

	@DataProvider(name = "Reports_ClassWiseAttendanceReportData")
	public String[][] getTestWrittenData() {
		String[][] testRecordsClassWiseAttendance = getData("AdmissionReports.xlsx", "ClassWiseAttendanceReportData");
		return testRecordsClassWiseAttendance;
	}

	@DataProvider(name = "Search_ClassWiseAttendanceReportData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearchDetails = getData("AdmissionReports.xlsx", "Search_ClasswiseAttendance");
		return testRecordsSearchDetails;
	}

	@DataProvider(name = "ValidationData_ClassWiseAttendanceReportData")
	public String[][] getTestValidationData() {
		String[][] testRecordsValidationDetails = getData("AdmissionReports.xlsx", "ValidationData_ClassWiseAttend");
		return testRecordsValidationDetails;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		yarlyfeedefaulterreport = new Reports_Yearly_Fee_Defaulter_Report(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData_Staff")
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

			boolean status = yarlyfeedefaulterreport.verifyHomeButton();
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

			yarlyfeedefaulterreport.navigateToFee_Reports_YearlyFeeDefaulterReport();

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

			boolean status = yarlyfeedefaulterreport.verifyFeeReports_YearlyFeeDefaulterReport_Page();
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

			yarlyfeedefaulterreport.submitBlank_YearlyFeeDefaulterReportForm();

			log.info("============= Finished tcSubmitBlank_YearlyFeeDefaulterReportForm Test===========");
			getScreenShot("tcSubmitBlank_YearlyFeeDefaulterReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_YearlyFeeDefaulterReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "Reports_ClassWiseAttendanceReportData")
	public void tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_YearlyFeeDefaulterReportForm_YearlyWise_FeeGroupWise_ForActiveStudent Test===========");

			yarlyfeedefaulterreport
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

			yarlyfeedefaulterreport.clickReport_ToGenerate_YearlyFeeDefaulterReport();

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

			yarlyfeedefaulterreport.selectRecordToGenerateReport();

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

			yarlyfeedefaulterreport.min_Max_FeeDefaulterReport_Form();

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

			yarlyfeedefaulterreport.sortRecordsByGroupName();

			log.info("============= Finished tcSortRecordsByGroupName Test===========");
			getScreenShot("tcSortRecordsByGroupName");
		} catch (Exception e) {
			getScreenShot("tcSortRecordsByGroupName");
		}
	}

	@Test(priority = 11)
	public void tcMinimize_FeeDefaulterReport_Grid() {

		try {
			log.info("============= Strting tcMinimize_FeeDefaulterReport_Grid Test===========");

			yarlyfeedefaulterreport.min_Max_FeeDefaulterReport_Grid();

			log.info("============= Finished tcMinimize_FeeDefaulterReport_Grid Test===========");
			getScreenShot("tcMinimize_FeeDefaulterReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeDefaulterReport_Grid");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_FeeDefaulterReport_Grid() {

		try {
			log.info("============= Strting tcMaximize_FeeDefaulterReport_Grid Test===========");

			yarlyfeedefaulterreport.min_Max_FeeDefaulterReport_Grid();

			log.info("============= Finished tcMaximize_FeeDefaulterReport_Grid Test===========");
			getScreenShot("tcMaximize_FeeDefaulterReport_Grid");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeDefaulterReport_Grid");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_FeeDefaulterReport_Form() {

		try {
			log.info("============= Strting tcMaximize_FeeDefaulterReport_Form Test===========");

			yarlyfeedefaulterreport.min_Max_FeeDefaulterReport_Form();

			log.info("============= Finished tcMaximize_FeeDefaulterReport_Form Test===========");
			getScreenShot("tcMaximize_FeeDefaulterReport_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeDefaulterReport_Form");
		}
	}

	@Test(priority = 14, dataProvider = "Reports_ClassWiseAttendanceReportData")
	public void tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid(String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid Test===========");

			yarlyfeedefaulterreport.searchWithGroupName_InYearlyFeeDefaulterReportGrid(groupName);

			log.info("============= Finished tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid Test===========");
			getScreenShot("tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithGroupName_InYearlyFeeDefaulterReportGrid");
		}
	}

	@Test(priority = 15)
	public void tcClickCancelButton_ToClearFilledForm() {

		try {
			log.info("============= Strting tcClickCancelButton_ToClearFilledForm Test===========");

			yarlyfeedefaulterreport.clickCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickCancelButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickCancelButton_ToClearFilledForm");
		}
	}

}
