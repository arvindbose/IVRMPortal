/**
 * 
 */
package com.vapsTechnosoft.IVRM.TCpreAdmission.TC_Reports;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.preAdmission.Reports.PreAdmission_StudentCountReport;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author arvind
 *
 */
public class TC_PreAdmission_StudentCountReport extends TestBase {
	public static final Logger log = Logger.getLogger(TC_PreAdmission_StudentCountReport.class.getName());

	PreAdmission_StudentCountReport studentcountreport;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "YearWise_StudentCount_Form")
	public String[][] getTestData() {
		String[][] testRecordsYearWise = getData("BGHS_PreAdmissionData.xlsx", "YearWiseStudentCountData");
		return testRecordsYearWise;
	}

	@DataProvider(name = "search_YearBetween_RegisteredUser")
	public String[][] getTestRegisteredUser() {
		String[][] testRecordsRegisteredUser = getData("BGHS_PreAdmissionData.xlsx", "Search_UserNameYearBetween");
		return testRecordsRegisteredUser;
	}
	@DataProvider(name = "search_YearBetween_RegisteredandfilledApplicationform")
	public String[][] getTestDataCategoryClass() {
		String[][] testRecordsCategoryClassMap = getData("BGHS_PreAdmissionData.xlsx", "Search_regFilledApplForm");
		return testRecordsCategoryClassMap;
	}
	@DataProvider(name = "CategoryClassMapping_2ndData_ClassSection")
	public String[][] getTestSearchData() {
		String[][] testRecords2ndData = getData("ExamMasters.xlsx", "CategoryClassMapping_2ndData");
		return testRecords2ndData;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		studentcountreport = new PreAdmission_StudentCountReport(driver);
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

			boolean status = studentcountreport.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToPreAdmission_StudentCountReport() {

		try {
			log.info("============= Strting tcNavigateToPreAdmission_StudentCountReport Test===========");

			studentcountreport.navigateToPreAdmission_StudentCountReport();

			log.info("============= Finished tcNavigateToPreAdmission_StudentCountReport Test===========");
			getScreenShot("tcNavigateToPreAdmission_StudentCountReport");
		} catch (Exception e) {
			getScreenShot("tcNavigateToPreAdmission_StudentCountReport");
		}
	}

	@Test(priority = 4)
	public void tcVerifyPreAdmission_StudentCountReportPage() {

		try {
			log.info("============= Strting tcVerifyPreAdmission_StudentCountReportPage Test===========");

			boolean status = studentcountreport.verifyPreAdmission_StudentCountReportPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyPreAdmission_StudentCountReportPage Test===========");
			getScreenShot("tcVerifyPreAdmission_StudentCountReportPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyPreAdmission_StudentCountReportPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_PreadmissionStudentCountReportForm() {

		try {
			log.info("============= Strting tcSubmitBlank_PreadmissionStudentCountReportForm Test===========");

			studentcountreport.submitBlank_PreadmissionStudentCountReportForm();

			log.info("============= Finished tcSubmitBlank_PreadmissionStudentCountReportForm Test===========");
			getScreenShot("tcSubmitBlank_PreadmissionStudentCountReportForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_PreadmissionStudentCountReportForm");
		}
	}

	@Test(priority = 6, dataProvider = "YearWise_StudentCount_Form")
	public void tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList Test===========");

			studentcountreport.fill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList(academicYear);

			log.info(
					"============= Finished tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList Test===========");
			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList");
		} catch (Exception e) {
			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList");
		}
	}

	@Test(priority = 7)
	public void tcClickOnSearchTo_GetRecords_YearWise_RegisteredList() {

		try {
			log.info("============= Strting tcClickOnSearchTo_GetRecords_YearWise_RegisteredList Test===========");

			studentcountreport.clickOnSearchTo_GetRecords();

			log.info("============= Finished tcClickOnSearchTo_GetRecords_YearWise_RegisteredList Test===========");
			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegisteredList");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegisteredList");
		}
	}

	@Test(priority = 8)
	public void tcClickOnExportToExcel_withoutSelectingRecord_YearWise_RegisteredList() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_withoutSelectingRecord_YearWise_RegisteredList Test===========");

			studentcountreport.clickOnExportToExcel();

			log.info(
					"============= Finished tcClickOnExportToExcel_withoutSelectingRecord_YearWise_RegisteredList Test===========");
			getScreenShot("tcClickOnExportToExcel_withoutSelectingRecord_YearWise_RegisteredList");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_withoutSelectingRecord_YearWise_RegisteredList");
		}
	}

	@Test(priority = 9)
	public void tcClickOnSuccessOkBtn_YearWise_RegisteredList_ExportToExcel_WithoutRecord() {

		try {
			log.info(
					"============= Strting tcClickOnSuccessOkBtn_YearWise_RegisteredList_ExportToExcel_WithoutRecord Test===========");

			studentcountreport.clickOnSuccessOkBtn();

			log.info(
					"============= Finished tcClickOnSuccessOkBtn_YearWise_RegisteredList_ExportToExcel_WithoutRecord Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_YearWise_RegisteredList_ExportToExcel_WithoutRecord");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_YearWise_RegisteredList_ExportToExcel_WithoutRecord");
		}
	}

	@Test(priority = 10)
	public void tcGenerateReportForAllUser_ClickHeaderCheckBox() {

		try {
			log.info("============= Strting tcGenerateReportForAllUser_ClickHeaderCheckBox Test===========");

			studentcountreport.generateReportForAllUser_ClickHeaderCheckBox();

			log.info("============= Finished tcGenerateReportForAllUser_ClickHeaderCheckBox Test===========");
			getScreenShot("tcGenerateReportForAllUser_ClickHeaderCheckBox");
		} catch (Exception e) {
			getScreenShot("tcGenerateReportForAllUser_ClickHeaderCheckBox");
		}
	}

	@Test(priority = 11)
	public void tcMinimize_DetailsSection() {

		try {
			log.info("============= Strting tcMinimize_DetailsSection Test===========");

			studentcountreport.min_Max_DetailsSection();

			log.info("============= Finished tcMinimize_DetailsSection Test===========");
			getScreenShot("tcMinimize_DetailsSection");
		} catch (Exception e) {
			getScreenShot("tcMinimize_DetailsSection");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_StudentCountReportForm() {

		try {
			log.info("============= Strting tcMinimize_StudentCountReportForm Test===========");

			studentcountreport.min_Max_StudentCountReportForm();
			log.info("============= Finished tcMinimize_StudentCountReportForm Test===========");
			getScreenShot("tcMinimize_StudentCountReportForm");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentCountReportForm");
		}
	}

	@Test(priority = 13)
	public void tcMinimize_StudentCountReportGrid() {

		try {
			log.info("============= Strting tcMinimize_StudentCountReportGrid Test===========");

			studentcountreport.min_Max_StudentCountReportGrid();
			log.info("============= Finished tcMinimize_StudentCountReportGrid Test===========");
			getScreenShot("tcMinimize_StudentCountReportGrid");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentCountReportGrid");
		}
	}

	@Test(priority = 14)
	public void tcMaximize_StudentCountReportGrid() {

		try {
			log.info("============= Strting tcMaximize_StudentCountReportGrid Test===========");

			studentcountreport.min_Max_StudentCountReportGrid();
			log.info("============= Finished tcMaximize_StudentCountReportGrid Test===========");
			getScreenShot("tcMaximize_StudentCountReportGrid");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentCountReportGrid");
		}
	}

	@Test(priority = 15)
	public void tcMaximize_StudentCountReportForm() {

		try {
			log.info("============= Strting tcMaximize_StudentCountReportForm Test===========");

			studentcountreport.min_Max_StudentCountReportForm();

			log.info("============= Finished tcMaximize_StudentCountReportForm Test===========");
			getScreenShot("tcMaximize_StudentCountReportForm");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentCountReportForm");
		}
	}

	@Test(priority = 16)
	public void tcMaximize_DetailsSection() {

		try {
			log.info("============= Strting tcMaximize_DetailsSection Test===========");

			studentcountreport.min_Max_DetailsSection();

			log.info("============= Finished tcMaximize_DetailsSection Test===========");
			getScreenShot("tcMaximize_DetailsSection");
		} catch (Exception e) {
			getScreenShot("tcMaximize_DetailsSection");
		}
	}

	@Test(priority = 17)
	public void tcClickOnCancelTo_ClearFilledData_StudentCountReport() {

		try {
			log.info("============= Strting tcClickOnCancelTo_ClearFilledData_StudentCountReport Test===========");

			studentcountreport.clickOnCancelTo_ClearFilledData_StudentCountReport();

			log.info("============= Finished tcClickOnCancelTo_ClearFilledData_StudentCountReport Test===========");
			getScreenShot("tcClickOnCancelTo_ClearFilledData_StudentCountReport");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelTo_ClearFilledData_StudentCountReport");
		}
	}

	@Test(priority = 18, dataProvider = "YearWise_StudentCount_Form")
	public void tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList_AfterCancel(String academicYear,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList_AfterCancel Test===========");

			studentcountreport.fill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList(academicYear);

			log.info(
					"============= Finished tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList_AfterCancel Test===========");
			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredList_AfterCancel");
		}
	}

	@Test(priority = 19)
	public void tcClickOnSearchTo_GetRecords_YearWise_RegisteredList_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnSearchTo_GetRecords_YearWise_RegisteredList_AfterCancel Test===========");

			studentcountreport.clickOnSearchTo_GetRecords();

			log.info(
					"============= Finished tcClickOnSearchTo_GetRecords_YearWise_RegisteredList_AfterCancel Test===========");
			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegisteredList_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegisteredList_AfterCancel");
		}
	}

	@Test(priority = 20, dataProvider = "search_YearBetween_RegisteredUser")
	public void tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredList(String userName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcClickOnSearchTo_GetRecords_YearWise_RegisteredList_AfterCancel Test===========");

			studentcountreport.searchWithUserName_InStudentCountReport(userName);

			log.info(
					"============= Finished tcClickOnSearchTo_GetRecords_YearWise_RegisteredList_AfterCancel Test===========");
			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegisteredList_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegisteredList_AfterCancel");
		}
	}

	@Test(priority = 21)
	public void tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredList() {

		try {
			log.info(
					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredList Test===========");

			studentcountreport.selectSpecificUser_InStudentCountReport();

			log.info(
					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredList Test===========");
			getScreenShot("tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredList");
		} catch (Exception e) {
			getScreenShot("tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredList");
		}
	}

	@Test(priority = 22)
	public void tcClickOnExportToExcel_ToDownload_YearWise_RegisteredList() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ToDownload_YearWise_RegisteredList Test===========");

			studentcountreport.clickOnExportToExcel();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownload_YearWise_RegisteredList Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_RegisteredList");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_RegisteredList");
		}
	}

	// YearWise Registered but not filled Application form

//	@Test(priority = 23, dataProvider = "YearWise_StudentCount_Form")
//	public void tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredbutnotfilledApplicationform(
//			String academicYear, String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredbutnotfilledApplicationform Test===========");
//
//			studentcountreport.fill_PreAdmission_StudentCountReportForm_YearWise_RegisteredbutnotfilledApplicationform(
//					academicYear);
//
//			log.info(
//					"============= Finished tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredbutnotfilledApplicationform Test===========");
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredbutnotfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredbutnotfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 24)
//	public void tcClickOnSearchTo_GetRecords_YearWise_RegisteredbutnotfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSearchTo_GetRecords_YearWise_RegisteredbutnotfilledApplicationform Test===========");
//
//			studentcountreport.clickOnSearchTo_GetRecords();
//
//			log.info(
//					"============= Finished tcClickOnSearchTo_GetRecords_YearWise_RegisteredbutnotfilledApplicationform Test===========");
//			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegisteredbutnotfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegisteredbutnotfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 25, dataProvider = "WithoutElective")
//	public void tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredbutnotfilledApplicationform(
//			String userName, String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredbutnotfilledApplicationform Test===========");
//
//			studentcountreport.searchWithUserName_InStudentCountReport(userName);
//
//			log.info(
//					"============= Finished tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredbutnotfilledApplicationform Test===========");
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredbutnotfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredbutnotfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 26)
//	public void tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredbutnotfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredbutnotfilledApplicationform Test===========");
//
//			studentcountreport.selectSpecificUser_InStudentCountReport();
//
//			log.info(
//					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredbutnotfilledApplicationform Test===========");
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredbutnotfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredbutnotfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 27)
//	public void tcClickOnExportToExcel_ToDownload_YearWise_RegisteredbutnotfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnExportToExcel_ToDownload_YearWise_RegisteredbutnotfilledApplicationform Test===========");
//
//			studentcountreport.clickOnExportToExcel();
//
//			log.info(
//					"============= Finished tcClickOnExportToExcel_ToDownload_YearWise_RegisteredbutnotfilledApplicationform Test===========");
//			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_RegisteredbutnotfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_RegisteredbutnotfilledApplicationform");
//		}
//	}

	// YearWise Registered and filled Application form

//	@Test(priority = 28, dataProvider = "YearWise_StudentCount_Form")
//	public void tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredandfilledApplicationform(
//			String academicYear, String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredandfilledApplicationform Test===========");
//
//			studentcountreport
//					.fill_PreAdmission_StudentCountReportForm_YearWise_RegisteredandfilledApplicationform(academicYear);
//
//			log.info(
//					"============= Finished tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredandfilledApplicationform Test===========");
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredandfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegisteredandfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 29)
//	public void tcClickOnSearchTo_GetRecords_YearWise_RegisteredandfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSearchTo_GetRecords_YearWise_RegisteredandfilledApplicationform Test===========");
//
//			studentcountreport.clickOnSearchTo_GetRecords();
//
//			log.info(
//					"============= Finished tcClickOnSearchTo_GetRecords_YearWise_RegisteredandfilledApplicationform Test===========");
//			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegisteredandfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegisteredandfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 30, dataProvider = "WithoutElective")
//	public void tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredandfilledApplicationform(String userName,
//			String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredandfilledApplicationform Test===========");
//
//			studentcountreport.searchWithUserName_InStudentCountReport(userName);
//
//			log.info(
//					"============= Finished tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredandfilledApplicationform Test===========");
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredandfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_YearWise_RegisteredandfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 31)
//	public void tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredandfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredandfilledApplicationform Test===========");
//
//			studentcountreport.selectSpecificUser_InStudentCountReport();
//
//			log.info(
//					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredandfilledApplicationform Test===========");
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredandfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegisteredandfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 32)
//	public void tcClickOnExportToExcel_ToDownload_YearWise_RegisteredandfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnExportToExcel_ToDownload_YearWise_RegisteredandfilledApplicationform Test===========");
//
//			studentcountreport.clickOnExportToExcel();
//
//			log.info(
//					"============= Finished tcClickOnExportToExcel_ToDownload_YearWise_RegisteredandfilledApplicationform Test===========");
//			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_RegisteredandfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_RegisteredandfilledApplicationform");
//		}
//	}

	// YearWise Registration payment Done List

//	@Test(priority = 33, dataProvider = "YearWise_StudentCount_Form")
//	public void tcFill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentDoneList(String academicYear,
//			String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcFill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentDoneList Test===========");
//
//			studentcountreport
//					.fill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentDoneList(academicYear);
//
//			log.info(
//					"============= Finished tcFill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentDoneList Test===========");
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentDoneList");
//		}
//	}
//
//	@Test(priority = 34)
//	public void tcClickOnSearchTo_GetRecords_YearWise_RegistrationpaymentDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSearchTo_GetRecords_YearWise_RegistrationpaymentDoneList Test===========");
//
//			studentcountreport.clickOnSearchTo_GetRecords();
//
//			log.info(
//					"============= Finished tcClickOnSearchTo_GetRecords_YearWise_RegistrationpaymentDoneList Test===========");
//			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegistrationpaymentDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegistrationpaymentDoneList");
//		}
//	}
//
//	@Test(priority = 35, dataProvider = "WithoutElective")
//	public void tcSearchWithUserName_InStudentCountReport_YearWise_RegistrationpaymentDoneList(String userName,
//			String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcSearchWithUserName_InStudentCountReport_YearWise_RegistrationpaymentDoneList Test===========");
//
//			studentcountreport.searchWithUserName_InStudentCountReport(userName);
//
//			log.info(
//					"============= Finished tcSearchWithUserName_InStudentCountReport_YearWise_RegistrationpaymentDoneList Test===========");
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_YearWise_RegistrationpaymentDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_YearWise_RegistrationpaymentDoneList");
//		}
//	}
//
//	@Test(priority = 36)
//	public void tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegistrationpaymentDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegistrationpaymentDoneList Test===========");
//
//			studentcountreport.selectSpecificUser_InStudentCountReport();
//
//			log.info(
//					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegistrationpaymentDoneList Test===========");
//			getScreenShot("tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegistrationpaymentDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegistrationpaymentDoneList");
//		}
//	}
//
//	@Test(priority = 37)
//	public void tcClickOnExportToExcel_ToDownload_YearWise_RegistrationpaymentDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnExportToExcel_ToDownload_YearWise_RegistrationpaymentDoneList Test===========");
//
//			studentcountreport.clickOnExportToExcel();
//
//			log.info(
//					"============= Finished tcClickOnExportToExcel_ToDownload_YearWise_RegistrationpaymentDoneList Test===========");
//			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_RegistrationpaymentDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_RegistrationpaymentDoneList");
//		}
//	}

	// YearWise Registration payment Not Done List

//	@Test(priority = 38, dataProvider = "YearWise_StudentCount_Form")
//	public void tcFill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentNotDoneList(String academicYear,
//			String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcFill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentNotDoneList Test===========");
//
//			studentcountreport
//					.fill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentNotDoneList(academicYear);
//
//			log.info(
//					"============= Finished tcFill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentNotDoneList Test===========");
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentNotDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_RegistrationpaymentNotDoneList");
//		}
//	}
//
//	@Test(priority = 39)
//	public void tcClickOnSearchTo_GetRecords_YearWise_RegistrationpaymentNotDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSearchTo_GetRecords_YearWise_RegistrationpaymentNotDoneList Test===========");
//
//			studentcountreport.clickOnSearchTo_GetRecords();
//
//			log.info(
//					"============= Finished tcClickOnSearchTo_GetRecords_YearWise_RegistrationpaymentNotDoneList Test===========");
//			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegistrationpaymentNotDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_RegistrationpaymentNotDoneList");
//		}
//	}
//
//	@Test(priority = 40, dataProvider = "WithoutElective")
//	public void tcSearchWithUserName_InStudentCountReport_YearWise_RegistrationpaymentNotDoneList(String userName,
//			String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcSearchWithUserName_InStudentCountReport_YearWise_RegistrationpaymentNotDoneList Test===========");
//
//			studentcountreport.searchWithUserName_InStudentCountReport(userName);
//
//			log.info(
//					"============= Finished tcSearchWithUserName_InStudentCountReport_YearWise_RegistrationpaymentNotDoneList Test===========");
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_YearWise_RegistrationpaymentNotDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_YearWise_RegistrationpaymentNotDoneList");
//		}
//	}
//
//	@Test(priority = 41)
//	public void tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegistrationpaymentNotDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegistrationpaymentNotDoneList Test===========");
//
//			studentcountreport.selectSpecificUser_InStudentCountReport();
//
//			log.info(
//					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegistrationpaymentNotDoneList Test===========");
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegistrationpaymentNotDoneList");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_RegistrationpaymentNotDoneList");
//		}
//	}
//
//	@Test(priority = 42)
//	public void tcClickOnExportToExcel_ToDownload_YearWise_RegistrationpaymentNotDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnExportToExcel_ToDownload_YearWise_RegistrationpaymentNotDoneList Test===========");
//
//			studentcountreport.clickOnExportToExcel();
//
//			log.info(
//					"============= Finished tcClickOnExportToExcel_ToDownload_YearWise_RegistrationpaymentNotDoneList Test===========");
//			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_RegistrationpaymentNotDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_RegistrationpaymentNotDoneList");
//		}
//	}

	// YearWise Transfer student(Admission Confirm)

//	@Test(priority = 43, dataProvider = "YearWise_StudentCount_Form")
//	public void tcFill_PreAdmission_StudentCountReportForm_YearWise_TransferstudentAdmissionConfirm(String academicYear,
//			String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcFill_PreAdmission_StudentCountReportForm_YearWise_TransferstudentAdmissionConfirm Test===========");
//
//			studentcountreport
//					.fill_PreAdmission_StudentCountReportForm_YearWise_TransferstudentAdmissionConfirm(academicYear);
//
//			log.info(
//					"============= Finished tcFill_PreAdmission_StudentCountReportForm_YearWise_TransferstudentAdmissionConfirm Test===========");
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_TransferstudentAdmissionConfirm");
//		} catch (Exception e) {
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_YearWise_TransferstudentAdmissionConfirm");
//		}
//	}
//
//	@Test(priority = 44)
//	public void tcClickOnSearchTo_GetRecords_YearWise_TransferstudentAdmissionConfirm() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSearchTo_GetRecords_YearWise_TransferstudentAdmissionConfirm Test===========");
//
//			studentcountreport.clickOnSearchTo_GetRecords();
//
//			log.info(
//					"============= Finished tcClickOnSearchTo_GetRecords_YearWise_TransferstudentAdmissionConfirm Test===========");
//			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_TransferstudentAdmissionConfirm");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSearchTo_GetRecords_YearWise_TransferstudentAdmissionConfirm");
//		}
//	}
//
//	@Test(priority = 45, dataProvider = "WithoutElective")
//	public void tcSearchWithUserName_InStudentCountReport_YearWise_TransferstudentAdmissionConfirm(String userName,
//			String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcSearchWithUserName_InStudentCountReport_YearWise_TransferstudentAdmissionConfirm Test===========");
//
//			studentcountreport.searchWithUserName_InStudentCountReport(userName);
//
//			log.info(
//					"============= Finished tcSearchWithUserName_InStudentCountReport_YearWise_TransferstudentAdmissionConfirm Test===========");
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_YearWise_TransferstudentAdmissionConfirm");
//		} catch (Exception e) {
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_YearWise_TransferstudentAdmissionConfirm");
//		}
//	}
//
//	@Test(priority = 46)
//	public void tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_TransferstudentAdmissionConfirm() {
//
//		try {
//			log.info(
//					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_TransferstudentAdmissionConfirm Test===========");
//
//			studentcountreport.selectSpecificUser_InStudentCountReport();
//
//			log.info(
//					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_TransferstudentAdmissionConfirm Test===========");
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_TransferstudentAdmissionConfirm");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_YearWise_TransferstudentAdmissionConfirm");
//		}
//	}
//
//	@Test(priority = 47)
//	public void tcClickOnExportToExcel_ToDownload_YearWise_TransferstudentAdmissionConfirm() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnExportToExcel_ToDownload_YearWise_TransferstudentAdmissionConfirm Test===========");
//
//			studentcountreport.clickOnExportToExcel();
//
//			log.info(
//					"============= Finished tcClickOnExportToExcel_ToDownload_YearWise_TransferstudentAdmissionConfirm Test===========");
//			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_TransferstudentAdmissionConfirm");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnExportToExcel_ToDownload_YearWise_TransferstudentAdmissionConfirm");
//		}
//	}

	// BETWEEN DATE

	@Test(priority = 48)
	public void tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredList() {

		try {
			log.info(
					"============= Strting tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredList Test===========");

			studentcountreport.fill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredList();

			log.info(
					"============= Finished tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredList Test===========");
			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredList");
		} catch (Exception e) {
			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredList");
		}
	}

	@Test(priority = 49)
	public void tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredList() {

		try {
			log.info("============= Strting tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredList Test===========");

			studentcountreport.clickOnSearchTo_GetRecords();

			log.info("============= Finished tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredList Test===========");
			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredList");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredList");
		}
	}

	@Test(priority = 50, dataProvider = "search_YearBetween_RegisteredUser")
	public void tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredList(String userName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredList_AfterCancel Test===========");

			studentcountreport.searchWithUserName_InStudentCountReport(userName);

			log.info(
					"============= Finished tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredList_AfterCancel Test===========");
			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredList_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredList_AfterCancel");
		}
	}

	@Test(priority = 51)
	public void tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredList() {

		try {
			log.info(
					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredList Test===========");

			studentcountreport.selectSpecificUser_InStudentCountReport();

			log.info(
					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredList Test===========");
			getScreenShot("tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredList");
		} catch (Exception e) {
			getScreenShot("tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredList");
		}
	}

	@Test(priority = 52)
	public void tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredList() {

		try {
			log.info(
					"============= Strting tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredList Test===========");

			studentcountreport.clickOnExportToExcel();

			log.info(
					"============= Finished tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredList Test===========");
			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredList");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredList");
		}
	}

	// BetweenDate Registered but not filled Application form

//	@Test(priority = 53)
//	public void tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredbutnotfilledApplicationform() {
//		
//		try {
//			log.info(
//					"============= Strting tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredbutnotfilledApplicationform Test===========");
//
//			studentcountreport
//					.fill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredbutnotfilledApplicationform();
//
//			log.info(
//					"============= Finished tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredbutnotfilledApplicationform Test===========");
//			getScreenShot(
//					"tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredbutnotfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredbutnotfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 54)
//	public void tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredbutnotfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredbutnotfilledApplicationform Test===========");
//
//			studentcountreport.clickOnSearchTo_GetRecords();
//
//			log.info(
//					"============= Finished tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredbutnotfilledApplicationform Test===========");
//			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredbutnotfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredbutnotfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 55, dataProvider = "WithoutElective")
//	public void tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredbutnotfilledApplicationform(
//			String userName, String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredbutnotfilledApplicationform Test===========");
//
//			studentcountreport.searchWithUserName_InStudentCountReport(userName);
//
//			log.info(
//					"============= Finished tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredbutnotfilledApplicationform Test===========");
//			getScreenShot(
//					"tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredbutnotfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredbutnotfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 56)
//	public void tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredbutnotfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredbutnotfilledApplicationform Test===========");
//
//			studentcountreport.selectSpecificUser_InStudentCountReport();
//
//			log.info(
//					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredbutnotfilledApplicationform Test===========");
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredbutnotfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredbutnotfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 57)
//	public void tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredbutnotfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredbutnotfilledApplicationform Test===========");
//
//			studentcountreport.clickOnExportToExcel();
//
//			log.info(
//					"============= Finished tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredbutnotfilledApplicationform Test===========");
//			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredbutnotfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredbutnotfilledApplicationform");
//		}
//	}

	// BetweenDate Registered and filled Application form

//	@Test(priority = 58)
//	public void tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredandfilledApplicationform() {
//		
//		try {
//			log.info(
//					"============= Strting tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredandfilledApplicationform Test===========");
//
//			studentcountreport
//					.fill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredandfilledApplicationform();
//
//			log.info(
//					"============= Finished tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredandfilledApplicationform Test===========");
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredandfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegisteredandfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 59)
//	public void tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredandfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredandfilledApplicationform Test===========");
//
//			studentcountreport.clickOnSearchTo_GetRecords();
//
//			log.info(
//					"============= Finished tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredandfilledApplicationform Test===========");
//			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredandfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegisteredandfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 60, dataProvider = "WithoutElective")
//	public void tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredandfilledApplicationform(
//			String userName, String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredandfilledApplicationform Test===========");
//
//			studentcountreport.searchWithUserName_InStudentCountReport(userName);
//
//			log.info(
//					"============= Finished tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredandfilledApplicationform Test===========");
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredandfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_BetweenDate_RegisteredandfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 61)
//	public void tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredandfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredandfilledApplicationform Test===========");
//
//			studentcountreport.selectSpecificUser_InStudentCountReport();
//
//			log.info(
//					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredandfilledApplicationform Test===========");
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredandfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegisteredandfilledApplicationform");
//		}
//	}
//
//	@Test(priority = 62)
//	public void tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredandfilledApplicationform() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredandfilledApplicationform Test===========");
//
//			studentcountreport.clickOnExportToExcel();
//
//			log.info(
//					"============= Finished tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredandfilledApplicationform Test===========");
//			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredandfilledApplicationform");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_RegisteredandfilledApplicationform");
//		}
//	}

	// BetweenDate Registration payment Done List

//	@Test(priority = 63)
//	public void tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentDoneList() {
//		
//		try {
//			log.info(
//					"============= Strting tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentDoneList Test===========");
//
//			studentcountreport.fill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentDoneList();
//
//			log.info(
//					"============= Finished tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentDoneList Test===========");
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentDoneList");
//		}
//	}
//
//	@Test(priority = 64)
//	public void tcClickOnSearchTo_GetRecords_BetweenDate_RegistrationpaymentDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSearchTo_GetRecords_BetweenDate_RegistrationpaymentDoneList Test===========");
//
//			studentcountreport.clickOnSearchTo_GetRecords();
//
//			log.info(
//					"============= Finished tcClickOnSearchTo_GetRecords_BetweenDate_RegistrationpaymentDoneList Test===========");
//			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegistrationpaymentDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegistrationpaymentDoneList");
//		}
//	}
//
//	@Test(priority = 65, dataProvider = "WithoutElective")
//	public void tcSearchWithUserName_InStudentCountReport_BetweenDate_RegistrationpaymentDoneList(String userName,
//			String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcSearchWithUserName_InStudentCountReport_BetweenDate_RegistrationpaymentDoneList Test===========");
//
//			studentcountreport.searchWithUserName_InStudentCountReport(userName);
//
//			log.info(
//					"============= Finished tcSearchWithUserName_InStudentCountReport_BetweenDate_RegistrationpaymentDoneList Test===========");
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_BetweenDate_RegistrationpaymentDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_BetweenDate_RegistrationpaymentDoneList");
//		}
//	}
//
//	@Test(priority = 66)
//	public void tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegistrationpaymentDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegistrationpaymentDoneList Test===========");
//
//			studentcountreport.selectSpecificUser_InStudentCountReport();
//
//			log.info(
//					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegistrationpaymentDoneList Test===========");
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegistrationpaymentDoneList");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegistrationpaymentDoneList");
//		}
//	}
//
//	@Test(priority = 67)
//	public void tcClickOnExportToExcel_ToDownload_BetweenDate_RegistrationpaymentDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnExportToExcel_ToDownload_BetweenDate_RegistrationpaymentDoneList Test===========");
//
//			studentcountreport.clickOnExportToExcel();
//
//			log.info(
//					"============= Finished tcClickOnExportToExcel_ToDownload_BetweenDate_RegistrationpaymentDoneList Test===========");
//			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_RegistrationpaymentDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_RegistrationpaymentDoneList");
//		}
//	}

	// BetweenDate Registration payment Not Done List

//	@Test(priority = 68)
//	public void tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentNotDoneList() {
//	
//		try {
//			log.info(
//					"============= Strting tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentNotDoneList Test===========");
//
//			studentcountreport.fill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentNotDoneList();
//
//			log.info(
//					"============= Finished tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentNotDoneList Test===========");
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentNotDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_BetweenDate_RegistrationpaymentNotDoneList");
//		}
//	}
//
//	@Test(priority = 69)
//	public void tcClickOnSearchTo_GetRecords_BetweenDate_RegistrationpaymentNotDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSearchTo_GetRecords_BetweenDate_RegistrationpaymentNotDoneList Test===========");
//
//			studentcountreport.clickOnSearchTo_GetRecords();
//
//			log.info(
//					"============= Finished tcClickOnSearchTo_GetRecords_BetweenDate_RegistrationpaymentNotDoneList Test===========");
//			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegistrationpaymentNotDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_RegistrationpaymentNotDoneList");
//		}
//	}
//
//	@Test(priority = 70, dataProvider = "WithoutElective")
//	public void tcSearchWithUserName_InStudentCountReport_BetweenDate_RegistrationpaymentNotDoneList(String userName,
//			String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcSearchWithUserName_InStudentCountReport_BetweenDate_RegistrationpaymentNotDoneList Test===========");
//
//			studentcountreport.searchWithUserName_InStudentCountReport(userName);
//
//			log.info(
//					"============= Finished tcSearchWithUserName_InStudentCountReport_BetweenDate_RegistrationpaymentNotDoneList Test===========");
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_BetweenDate_RegistrationpaymentNotDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_BetweenDate_RegistrationpaymentNotDoneList");
//		}
//	}
//
//	@Test(priority = 71)
//	public void tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegistrationpaymentNotDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegistrationpaymentNotDoneList Test===========");
//
//			studentcountreport.selectSpecificUser_InStudentCountReport();
//
//			log.info(
//					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegistrationpaymentNotDoneList Test===========");
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegistrationpaymentNotDoneList");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_RegistrationpaymentNotDoneList");
//		}
//	}
//
//	@Test(priority = 72)
//	public void tcClickOnExportToExcel_ToDownload_BetweenDate_RegistrationpaymentNotDoneList() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnExportToExcel_ToDownload_BetweenDate_RegistrationpaymentNotDoneList Test===========");
//
//			studentcountreport.clickOnExportToExcel();
//
//			log.info(
//					"============= Finished tcClickOnExportToExcel_ToDownload_BetweenDate_RegistrationpaymentNotDoneList Test===========");
//			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_RegistrationpaymentNotDoneList");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_RegistrationpaymentNotDoneList");
//		}
//	}

	// BetweenDate Transfer student(Admission Confirm)

//	@Test(priority = 73)
//	public void tcFill_PreAdmission_StudentCountReportForm_BetweenDate_TransferstudentAdmissionConfirm() {
//		
//		try {
//			log.info(
//					"============= Strting tcFill_PreAdmission_StudentCountReportForm_BetweenDate_TransferstudentAdmissionConfirm Test===========");
//
//			studentcountreport.fill_PreAdmission_StudentCountReportForm_BetweenDate_TransferstudentAdmissionConfirm();
//
//			log.info(
//					"============= Finished tcFill_PreAdmission_StudentCountReportForm_BetweenDate_TransferstudentAdmissionConfirm Test===========");
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_BetweenDate_TransferstudentAdmissionConfirm");
//		} catch (Exception e) {
//			getScreenShot("tcFill_PreAdmission_StudentCountReportForm_BetweenDate_TransferstudentAdmissionConfirm");
//		}
//	}
//
//	@Test(priority = 74)
//	public void tcClickOnSearchTo_GetRecords_BetweenDate_TransferstudentAdmissionConfirm() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSearchTo_GetRecords_BetweenDate_TransferstudentAdmissionConfirm Test===========");
//
//			studentcountreport.clickOnSearchTo_GetRecords();
//
//			log.info(
//					"============= Finished tcClickOnSearchTo_GetRecords_BetweenDate_TransferstudentAdmissionConfirm Test===========");
//			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_TransferstudentAdmissionConfirm");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSearchTo_GetRecords_BetweenDate_TransferstudentAdmissionConfirm");
//		}
//	}
//
//	@Test(priority = 75, dataProvider = "WithoutElective")
//	public void tcSearchWithUserName_InStudentCountReport_BetweenDate_TransferstudentAdmissionConfirm(String userName,
//			String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info(
//					"============= Strting tcSearchWithUserName_InStudentCountReport_BetweenDate_TransferstudentAdmissionConfirm Test===========");
//
//			studentcountreport.searchWithUserName_InStudentCountReport(userName);
//
//			log.info(
//					"============= Finished tcSearchWithUserName_InStudentCountReport_BetweenDate_TransferstudentAdmissionConfirm Test===========");
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_BetweenDate_TransferstudentAdmissionConfirm");
//		} catch (Exception e) {
//			getScreenShot("tcSearchWithUserName_InStudentCountReport_BetweenDate_TransferstudentAdmissionConfirm");
//		}
//	}
//
//	@Test(priority = 76)
//	public void tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_TransferstudentAdmissionConfirm() {
//
//		try {
//			log.info(
//					"============= Strting tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_TransferstudentAdmissionConfirm Test===========");
//
//			studentcountreport.selectSpecificUser_InStudentCountReport();
//
//			log.info(
//					"============= Finished tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_TransferstudentAdmissionConfirm Test===========");
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_TransferstudentAdmissionConfirm");
//		} catch (Exception e) {
//			getScreenShot(
//					"tcSelectSpecificUser_InStudentCountReportToDownload_BetweenDate_TransferstudentAdmissionConfirm");
//		}
//	}
//
//	@Test(priority = 77)
//	public void tcClickOnExportToExcel_ToDownload_BetweenDate_TransferstudentAdmissionConfirm() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnExportToExcel_ToDownload_BetweenDate_TransferstudentAdmissionConfirm Test===========");
//
//			studentcountreport.clickOnExportToExcel();
//
//			log.info(
//					"============= Finished tcClickOnExportToExcel_ToDownload_BetweenDate_TransferstudentAdmissionConfirm Test===========");
//			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_TransferstudentAdmissionConfirm");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnExportToExcel_ToDownload_BetweenDate_TransferstudentAdmissionConfirm");
//		}
//	}
	

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
