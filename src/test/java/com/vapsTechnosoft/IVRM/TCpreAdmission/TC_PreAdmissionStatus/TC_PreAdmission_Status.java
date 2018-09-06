/**
 * 
 */
package com.vapsTechnosoft.IVRM.TCpreAdmission.TC_PreAdmissionStatus;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vapsTechnosoft.IVRM.preAdmission.PreAdmissionStatus.PreAdmission_Status;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author Arvind
 *
 */
public class TC_PreAdmission_Status extends TestBase{

	public static final Logger log = Logger.getLogger(TC_PreAdmission_Status.class.getName());

	PreAdmission_Status statusPreAdm;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "PreAdmissionStatus_Application")
	public String[][] getTestDataApp() {
		String[][] testRecordsApp = getData("BGHS_PreAdmissionData.xlsx", "Application_StatusData");
		return testRecordsApp;
	}

	@DataProvider(name = "PreAdmissionStatus_Admission")
	public String[][] getTestDataAdm() {
		String[][] testRecordsAdm = getData("BGHS_PreAdmissionData.xlsx", "Admission_StatusData");
		return testRecordsAdm;
	}

	
	@DataProvider(name = "Application_UpdateStatusAll")
	public String[][] getTestDataStatusAll() {
		String[][] testRecordsStatusAll = getData("BGHS_PreAdmissionData.xlsx", "UpdateStatusAll");
		return testRecordsStatusAll;
	}

	@DataProvider(name = "Search_StudentName_ApplicationStatus")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_PreAdmissionData.xlsx", "Search_Student_Application");
		return testRecordsSearch;
	}
	@DataProvider(name = "Search_StudentName_AdmissionStatus")
	public String[][] getTestSearchDataAdm() {
		String[][] testRecordsSearchAdm = getData("BGHS_PreAdmissionData.xlsx", "Search_Student_Admission");
		return testRecordsSearchAdm;
	}
	@DataProvider(name = "Remarks_forStatus")
	public String[][] getTestRemarksData() {
		String[][] testRecordsRemarks = getData("BGHS_PreAdmissionData.xlsx", "StatusRemarks_appStatus");
		return testRecordsRemarks;
	}
	@DataProvider(name = "Email_And_SMS_Datils")
	public String[][] getTestEamilSmS() {
		String[][] testRecordsRemarks = getData("BGHS_PreAdmissionData.xlsx", "Status_EmailSmSDetails");
		return testRecordsRemarks;
	}
	
	
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		statusPreAdm = new PreAdmission_Status(driver);
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

			boolean status = statusPreAdm.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToPreAdmission_Status() {

		try {
			log.info("============= Strting tcNavigateToPreAdmission_Status Test===========");

			statusPreAdm.navigateToPreAdmission_Status();

			log.info("============= Finished tcNavigateToPreAdmission_Status Test===========");
			getScreenShot("tcNavigateToPreAdmission_Status");
		} catch (Exception e) {
			getScreenShot("tcNavigateToPreAdmission_Status");
		}
	}

	@Test(priority = 4)
	public void tcVerifyPreAdmission_StatusPage() {

		try {
			log.info("============= Strting tcVerifyPreAdmission_StatusPage Test===========");

			boolean status = statusPreAdm.verifyPreAdmission_StatusPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyPreAdmission_StatusPage Test===========");
			getScreenShot("tcVerifyPreAdmission_StatusPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyPreAdmission_StatusPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_PreadmissionStatusForm() {

		try {
			log.info("============= Strting tcSubmitBlank_PreadmissionStatusForm Test===========");

			statusPreAdm.submitBlank_PreadmissionStatusForm();

			log.info("============= Finished tcSubmitBlank_PreadmissionStatusForm Test===========");
			getScreenShot("tcSubmitBlank_PreadmissionStatusForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_PreadmissionStatusForm");
		}
	}

	@Test(priority = 6, dataProvider = "PreAdmissionStatus_Application")
	public void tcFillPreAdmissionStatusForm_ApplicationStatus(String academicYear, String class_status, String status, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillPreAdmissionStatusForm_ApplicationStatus Test===========");

			statusPreAdm.fillPreAdmissionStatusForm_ApplicationStatus(academicYear, class_status, status);

			log.info("============= Finished tcFillPreAdmissionStatusForm_ApplicationStatus Test===========");
			getScreenShot("tcFillPreAdmissionStatusForm_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcFillPreAdmissionStatusForm_ApplicationStatus");
		}
	}
	@Test(priority = 7)
	public void tcClickOnSearchTo_GetRecords_ApplicationStatus() {

		try {
			log.info("============= Strting tcClickOnSearchTo_GetRecords_ApplicationStatus Test===========");

			statusPreAdm.clickOnSearchTo_GetRecords();

			log.info("============= Finished tcClickOnSearchTo_GetRecords_ApplicationStatus Test===========");
			getScreenShot("tcClickOnSearchTo_GetRecords_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchTo_GetRecords_ApplicationStatus");
		}
	}
	@Test(priority = 8)
	public void tcClickOnPrint_withoutSelectingRecord_ApplicationStatus() {

		try {
			log.info("============= Strting tcClickOnPrint_withoutSelectingRecord_ApplicationStatus Test===========");

			statusPreAdm.clickOnPrint_withoutSelectingRecord();

			log.info("============= Finished tcClickOnPrint_withoutSelectingRecord_ApplicationStatus Test===========");
			getScreenShot("tcClickOnPrint_withoutSelectingRecord_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_withoutSelectingRecord_ApplicationStatus");
		}
	}
	@Test(priority = 9)
	public void tcClickOnSuccessOkBtn_ApplicationStatus_Print_WithoutRecord() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ApplicationStatus_Print_WithoutRecord Test===========");

			statusPreAdm.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ApplicationStatus_Print_WithoutRecord Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ApplicationStatus_Print_WithoutRecord");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ApplicationStatus_Print_WithoutRecord");
		}
	}
	@Test(priority = 10)
	public void tcClickOnExportToExcel_withoutSelectingRecord_ApplicationStatus() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_withoutSelectingRecord_ApplicationStatus Test===========");

			statusPreAdm.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_withoutSelectingRecord_ApplicationStatus Test===========");
			getScreenShot("tcClickOnExportToExcel_withoutSelectingRecord_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_withoutSelectingRecord_ApplicationStatus");
		}
	}
	@Test(priority = 11)
	public void tcClickOnSuccessOkBtn_ApplicationStatus_ExportToExcel_WithoutRecord() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ApplicationStatus_ExportToExcel_WithoutRecord Test===========");

			statusPreAdm.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ApplicationStatus_ExportToExcel_WithoutRecord Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ApplicationStatus_ExportToExcel_WithoutRecord");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ApplicationStatus_ExportToExcel_WithoutRecord");
		}
	}
	@Test(priority = 12, dataProvider = "Application_UpdateStatusAll")
	public void tcUpdate_StatusforAllStudent_ApplicationStatus(String status_All, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcUpdate_StatusforAllStudent_ApplicationStatus Test===========");

			statusPreAdm.update_StatusforAllStudent(status_All);

			log.info("============= Finished tcUpdate_StatusforAllStudent_ApplicationStatus Test===========");
			getScreenShot("tcUpdate_StatusforAllStudent_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcUpdate_StatusforAllStudent_ApplicationStatus");
		}
	}
	
	@Test(priority = 13)
	public void tcGenerateReportForAllStudent_ClickHeaderCheckBox() {

		try {
			log.info("============= Strting tcGenerateReportForAllStudent_ClickHeaderCheckBox Test===========");

			statusPreAdm.generateReportForAllStudent_ClickHeaderCheckBox();

			log.info("============= Finished tcGenerateReportForAllStudent_ClickHeaderCheckBox Test===========");
			getScreenShot("tcGenerateReportForAllStudent_ClickHeaderCheckBox");
		} catch (Exception e) {
			getScreenShot("tcGenerateReportForAllStudent_ClickHeaderCheckBox");
		}
	}
	@Test(priority = 14)
	public void tcSortWithStudentNameInStatusDetails() {

		try {
			log.info("============= Strting tcSortWithStudentNameInStatusDetails Test===========");
			getScreenShot("BeforeSorting_tcSortWithStudentNameInStatusDetails");
			statusPreAdm.sortWithStudentNameInStatusDetails();

			log.info("============= Finished tcSortWithStudentNameInStatusDetails Test===========");
			getScreenShot("tcSortWithStudentNameInStatusDetails");
		} catch (Exception e) {
			getScreenShot("tcSortWithStudentNameInStatusDetails");
		}
	}
	@Test(priority = 15)
	public void tcSortWithRegistrationNumberInStatusDetails() {

		try {
			log.info("============= Strting tcSortWithRegistrationNumberInStatusDetails Test===========");
			getScreenShot("BeforeSorting_tcSortWithRegistrationNumberInStatusDetails");
			statusPreAdm.sortWithRegistrationNumberInStatusDetails();

			log.info("============= Finished tcSortWithRegistrationNumberInStatusDetails Test===========");
			getScreenShot("tcSortWithRegistrationNumberInStatusDetails");
		} catch (Exception e) {
			getScreenShot("tcSortWithRegistrationNumberInStatusDetails");
		}
	}
	@Test(priority = 16)
	public void tcSortWithGenderSexInStatusDetails() {

		try {
			log.info("============= Strting tcSortWithGenderSexInStatusDetails Test===========");
			getScreenShot("BeforeSorting_tcSortWithGenderSexInStatusDetails");
			statusPreAdm.sortWithGenderSexInStatusDetails();

			log.info("============= Finished tcSortWithGenderSexInStatusDetails Test===========");
			getScreenShot("tcSortWithGenderSexInStatusDetails");
		} catch (Exception e) {
			getScreenShot("tcSortWithGenderSexInStatusDetails");
		}
	}
	@Test(priority = 17)
	public void tcClickOnCancelTo_ClearFilledData_Status() {

		try {
			log.info("============= Strting tcClickOnCancelTo_ClearFilledData_Status Test===========");
			
			statusPreAdm.clickOnCancelTo_ClearFilledData_Status();

			log.info("============= Finished tcClickOnCancelTo_ClearFilledData_Status Test===========");
			getScreenShot("tcClickOnCancelTo_ClearFilledData_Status");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelTo_ClearFilledData_Status");
		}
	}

	@Test(priority = 18, dataProvider = "PreAdmissionStatus_Application")
	public void tcFillPreAdmissionStatusForm_ApplicationStatus_AfterCancel(String academicYear, String class_status, String status, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillPreAdmissionStatusForm_ApplicationStatus_AfterCancel Test===========");

			statusPreAdm.fillPreAdmissionStatusForm_ApplicationStatus(academicYear, class_status, status);

			log.info("============= Finished tcFillPreAdmissionStatusForm_ApplicationStatus_AfterCancel Test===========");
			getScreenShot("tcFillPreAdmissionStatusForm_ApplicationStatus_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFillPreAdmissionStatusForm_ApplicationStatus_AfterCancel");
		}
	}
	@Test(priority = 19)
	public void tcClickOnSearchTo_GetRecords_ApplicationStatus_AfterCancel() {

		try {
			log.info("============= Strting tcClickOnSearchTo_GetRecords_ApplicationStatus_AfterCancel Test===========");

			statusPreAdm.clickOnSearchTo_GetRecords();

			log.info("============= Finished tcClickOnSearchTo_GetRecords_ApplicationStatus_AfterCancel Test===========");
			getScreenShot("tcClickOnSearchTo_GetRecords_ApplicationStatus_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchTo_GetRecords_ApplicationStatus_AfterCancel");
		}
	}
	@Test(priority = 20, dataProvider = "Search_StudentName_ApplicationStatus")
	public void tcSearchForStudent_InStatusDetails(String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchForStudent_InStatusDetails Test===========");

			statusPreAdm.searchForStudent_InStatusDetails(studentName);

			log.info("============= Finished tcSearchForStudent_InStatusDetails Test===========");
			getScreenShot("tcSearchForStudent_InStatusDetails");
		} catch (Exception e) {
			getScreenShot("tcSearchForStudent_InStatusDetails");
		}
	}
	@Test(priority = 21, dataProvider = "Remarks_forStatus")
	public void tcSelectSpecificStudentStatusReport_InStatusDetails(String remarks, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectSpecificStudentStatusReport_InStatusDetails Test===========");

			statusPreAdm.selectSpecificStudentStatusReport(remarks);

			log.info("============= Finished tcSelectSpecificStudentStatusReport_InStatusDetails Test===========");
			getScreenShot("tcSelectSpecificStudentStatusReport_InStatusDetails");
		} catch (Exception e) {
			getScreenShot("tcSelectSpecificStudentStatusReport_InStatusDetails");
		}
	}
	@Test(priority = 22)
	public void tcClickOnExportToExcel_ApplicationStatus() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_ApplicationStatus Test===========");

			statusPreAdm.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_ApplicationStatus Test===========");
			getScreenShot("tcClickOnExportToExcel_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_ApplicationStatus");
		}
	}
	@Test(priority = 23)
	public void tcClickOnPrint_ApplicationStatus() {

		try {
			log.info("============= Strting tcClickOnPrint_ApplicationStatus Test===========");

			statusPreAdm.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_ApplicationStatus Test===========");
			getScreenShot("tcClickOnPrint_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_ApplicationStatus");
		}
	}
	@Test(priority = 24)
	public void tcCheckEmailAndSms_ApplicationStatus() {

		try {
			log.info("============= Strting tcCheckEmailAndSms_ApplicationStatus Test===========");

			statusPreAdm.checkEmailAndSms();

			log.info("============= Finished tcCheckEmailAndSms_ApplicationStatus Test===========");
			getScreenShot("tcCheckEmailAndSms_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcCheckEmailAndSms_ApplicationStatus");
		}
	}
	@Test(priority = 25, dataProvider = "Email_And_SMS_Datils")
	public void tcFillEmailAndSmsDetails_ApplicationStatus(String emailSubject, String emailHeader, String emailMessage, String emailFooter,
			String smsContent, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillEmailAndSmsDetails_ApplicationStatus Test===========");

			statusPreAdm.fillEmailAndSmsDetails(emailSubject, emailHeader, emailMessage, emailFooter, smsContent);

			log.info("============= Finished tcFillEmailAndSmsDetails_ApplicationStatus Test===========");
			getScreenShot("tcFillEmailAndSmsDetails_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcFillEmailAndSmsDetails_ApplicationStatus");
		}
	}
	@Test(priority = 26)
	public void tcUpdateStatusSend_EmailAndSms_ApplicationStatus() {

		try {
			log.info("============= Strting tcUpdateStatusSend_EmailAndSms_ApplicationStatus Test===========");

			statusPreAdm.updateStatusSend_EmailAndSms();

			log.info("============= Finished tcUpdateStatusSend_EmailAndSms_ApplicationStatus Test===========");
			getScreenShot("tcUpdateStatusSend_EmailAndSms_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcUpdateStatusSend_EmailAndSms_ApplicationStatus");
		}
	}
	@Test(priority = 27)
	public void tcConfirm_UpdateStatusSend_EmailAndSms_ApplicationStatus() {

		try {
			log.info("============= Strting tcConfirm_UpdateStatusSend_EmailAndSms_ApplicationStatus Test===========");

			statusPreAdm.confirm_UpdateStatusSend_EmailAndSms();

			log.info("============= Finished tcConfirm_UpdateStatusSend_EmailAndSms_ApplicationStatus Test===========");
			getScreenShot("tcConfirm_UpdateStatusSend_EmailAndSms_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcConfirm_UpdateStatusSend_EmailAndSms_ApplicationStatus");
		}
	}
	@Test(priority = 28)
	public void tcConfirm_UpdateStatus_Cancel_ApplicationStatus() {

		try {
			log.info("============= Strting tcConfirm_UpdateStatus_Cancel_ApplicationStatus Test===========");

			statusPreAdm.confirm_UpdateStatus_Cancel();

			log.info("============= Finished tcConfirm_UpdateStatus_Cancel_ApplicationStatus Test===========");
			getScreenShot("tcConfirm_UpdateStatus_Cancel_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcConfirm_UpdateStatus_Cancel_ApplicationStatus");
		}
	}
	
	@Test(priority = 29)
	public void tcUpdateStatusSend_EmailAndSms_ApplicationStatus_AfterCancelPopUp() {

		try {
			log.info("============= Strting tcUpdateStatusSend_EmailAndSms_ApplicationStatus_AfterCancelPopUp Test===========");

			statusPreAdm.updateStatusSend_EmailAndSms();

			log.info("============= Finished tcUpdateStatusSend_EmailAndSms_ApplicationStatus_AfterCancelPopUp Test===========");
			getScreenShot("tcUpdateStatusSend_EmailAndSms_ApplicationStatus_AfterCancelPopUp");
		} catch (Exception e) {
			getScreenShot("tcUpdateStatusSend_EmailAndSms_ApplicationStatus_AfterCancelPopUp");
		}
	}
	@Test(priority = 30)
	public void tcConfirm_UpdateStatusSend_EmailAndSms_ApplicationStatus_AfterCancelPopUp() {

		try {
			log.info("============= Strting tcConfirm_UpdateStatusSend_EmailAndSms_ApplicationStatus_AfterCancelPopUp Test===========");

			statusPreAdm.confirm_UpdateStatusSend_EmailAndSms();

			log.info("============= Finished tcConfirm_UpdateStatusSend_EmailAndSms_ApplicationStatus_AfterCancelPopUp Test===========");
			getScreenShot("tcConfirm_UpdateStatusSend_EmailAndSms_ApplicationStatus_AfterCancelPopUp");
		} catch (Exception e) {
			getScreenShot("tcConfirm_UpdateStatusSend_EmailAndSms_ApplicationStatus_AfterCancelPopUp");
		}
	}
	@Test(priority = 31)
	public void tcConfirm_UpdateStatus_Yes_ApplicationStatus() {

		try {
			log.info("============= Strting tcConfirm_UpdateStatus_Yes_ApplicationStatus Test===========");

			statusPreAdm.confirm_UpdateStatus_Yes();

			log.info("============= Finished tcConfirm_UpdateStatus_Yes_ApplicationStatus Test===========");
			getScreenShot("tcConfirm_UpdateStatus_Yes_ApplicationStatus");
		} catch (Exception e) {
			getScreenShot("tcConfirm_UpdateStatus_Yes_ApplicationStatus");
		}
	}	
	@Test(priority = 32)
	public void tcClickOnSuccessOkBtn_ApplicationStatus_UpdateStatus() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ApplicationStatus_UpdateStatus Test===========");

			statusPreAdm.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ApplicationStatus_UpdateStatus Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ApplicationStatus_UpdateStatus");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ApplicationStatus_UpdateStatus");
		}
	}
	
	/**
	 * 
	 * ADMISSION STATUS
	 * 
	 */
	@Test(priority = 33, dataProvider = "PreAdmissionStatus_Admission")
	public void tcFillPreAdmissionStatusForm_AdmissionStatus(String academicYear, String class_status, String status, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillPreAdmissionStatusForm_AdmissionStatus Test===========");

			statusPreAdm.fillPreAdmissionStatusForm_AdmissionStatus(academicYear, class_status, status);

			log.info("============= Finished tcFillPreAdmissionStatusForm_AdmissionStatus Test===========");
			getScreenShot("tcFillPreAdmissionStatusForm_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcFillPreAdmissionStatusForm_AdmissionStatus");
		}
	}
	@Test(priority = 34)
	public void tcClickOnSearchTo_GetRecords_AdmissionStatus() {

		try {
			log.info("============= Strting tcClickOnSearchTo_GetRecords_AdmissionStatus Test===========");

			statusPreAdm.clickOnSearchTo_GetRecords();

			log.info("============= Finished tcClickOnSearchTo_GetRecords_AdmissionStatus Test===========");
			getScreenShot("tcClickOnSearchTo_GetRecords_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchTo_GetRecords_AdmissionStatus");
		}
	}
	@Test(priority = 35, dataProvider = "Search_StudentName_AdmissionStatus")
	public void tcSearchForStudent_InStatusDetails_AdmissionStatus(String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchForStudent_InStatusDetails_AdmissionStatus Test===========");

			statusPreAdm.searchForStudent_InStatusDetails(studentName);

			log.info("============= Finished tcSearchForStudent_InStatusDetails_AdmissionStatus Test===========");
			getScreenShot("tcSearchForStudent_InStatusDetails_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcSearchForStudent_InStatusDetails_AdmissionStatus");
		}
	}
	@Test(priority = 36, dataProvider = "Remarks_forStatus")
	public void tcSelectSpecificStudentStatusReport_InStatusDetails_AdmissionStatus(String remarks, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectSpecificStudentStatusReport_InStatusDetails_AdmissionStatus Test===========");

			statusPreAdm.selectSpecificStudentStatusReport(remarks);

			log.info("============= Finished tcSelectSpecificStudentStatusReport_InStatusDetails_AdmissionStatus Test===========");
			getScreenShot("tcSelectSpecificStudentStatusReport_InStatusDetails_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcSelectSpecificStudentStatusReport_InStatusDetails_AdmissionStatus");
		}
	}
	@Test(priority = 37)
	public void tcClickOnExportToExcel_AdmissionStatus() {

		try {
			log.info("============= Strting tcClickOnExportToExcel_AdmissionStatus Test===========");

			statusPreAdm.clickOnExportToExcel();

			log.info("============= Finished tcClickOnExportToExcel_AdmissionStatus Test===========");
			getScreenShot("tcClickOnExportToExcel_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcClickOnExportToExcel_AdmissionStatus");
		}
	}
	@Test(priority = 38)
	public void tcClickOnPrint_AdmissionStatus() {

		try {
			log.info("============= Strting tcClickOnPrint_AdmissionStatus Test===========");

			statusPreAdm.clickOnPrint();

			log.info("============= Finished tcClickOnPrint_AdmissionStatus Test===========");
			getScreenShot("tcClickOnPrint_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrint_AdmissionStatus");
		}
	}
	@Test(priority = 39)
	public void tcCheckEmailAndSms_AdmissionStatus() {

		try {
			log.info("============= Strting tcCheckEmailAndSms_AdmissionStatus Test===========");

			statusPreAdm.checkEmailAndSms();

			log.info("============= Finished tcCheckEmailAndSms_AdmissionStatus Test===========");
			getScreenShot("tcCheckEmailAndSms_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcCheckEmailAndSms_AdmissionStatus");
		}
	}
	@Test(priority = 40, dataProvider = "Email_And_SMS_Datils")
	public void tcFillEmailAndSmsDetails_AdmissionStatus(String emailSubject, String emailHeader, String emailMessage, String emailFooter,
			String smsContent, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillEmailAndSmsDetails_AdmissionStatus Test===========");

			statusPreAdm.fillEmailAndSmsDetails(emailSubject, emailHeader, emailMessage, emailFooter, smsContent);

			log.info("============= Finished tcFillEmailAndSmsDetails_AdmissionStatus Test===========");
			getScreenShot("tcFillEmailAndSmsDetails_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcFillEmailAndSmsDetails_AdmissionStatus");
		}
	}
	@Test(priority = 41)
	public void tcUpdateStatusSend_EmailAndSms_AdmissionStatus() {

		try {
			log.info("============= Strting tcUpdateStatusSend_EmailAndSms_AdmissionStatus Test===========");

			statusPreAdm.updateStatusSend_EmailAndSms();

			log.info("============= Finished tcUpdateStatusSend_EmailAndSms_AdmissionStatus Test===========");
			getScreenShot("tcUpdateStatusSend_EmailAndSms_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcUpdateStatusSend_EmailAndSms_AdmissionStatus");
		}
	}
	@Test(priority = 42)
	public void tcConfirm_UpdateStatusSend_EmailAndSms_AdmissionStatus() {

		try {
			log.info("============= Strting tcConfirm_UpdateStatusSend_EmailAndSms_AdmissionStatus Test===========");

			statusPreAdm.confirm_UpdateStatusSend_EmailAndSms();

			log.info("============= Finished tcConfirm_UpdateStatusSend_EmailAndSms_AdmissionStatus Test===========");
			getScreenShot("tcConfirm_UpdateStatusSend_EmailAndSms_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcConfirm_UpdateStatusSend_EmailAndSms_AdmissionStatus");
		}
	}
	@Test(priority = 43)
	public void tcConfirm_UpdateStatus_Cancel_AdmissionStatus() {

		try {
			log.info("============= Strting tcConfirm_UpdateStatus_Cancel_AdmissionStatus Test===========");

			statusPreAdm.confirm_UpdateStatus_Cancel();

			log.info("============= Finished tcConfirm_UpdateStatus_Cancel_AdmissionStatus Test===========");
			getScreenShot("tcConfirm_UpdateStatus_Cancel_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcConfirm_UpdateStatus_Cancel_AdmissionStatus");
		}
	}
	
	@Test(priority = 44)
	public void tcUpdateStatusSend_EmailAndSms_AdmissionStatus_AfterCancelPopUp() {

		try {
			log.info("============= Strting tcUpdateStatusSend_EmailAndSms_AdmissionStatus_AfterCancelPopUp Test===========");

			statusPreAdm.updateStatusSend_EmailAndSms();

			log.info("============= Finished tcUpdateStatusSend_EmailAndSms_AdmissionStatus_AfterCancelPopUp Test===========");
			getScreenShot("tcUpdateStatusSend_EmailAndSms_AdmissionStatus_AfterCancelPopUp");
		} catch (Exception e) {
			getScreenShot("tcUpdateStatusSend_EmailAndSms_AdmissionStatus_AfterCancelPopUp");
		}
	}
	@Test(priority = 45)
	public void tcConfirm_UpdateStatusSend_EmailAndSms_AdmissionStatus_AfterCancelPopUp() {

		try {
			log.info("============= Strting tcConfirm_UpdateStatusSend_EmailAndSms_AdmissionStatus_AfterCancelPopUp Test===========");

			statusPreAdm.confirm_UpdateStatusSend_EmailAndSms();

			log.info("============= Finished tcConfirm_UpdateStatusSend_EmailAndSms_AdmissionStatus_AfterCancelPopUp Test===========");
			getScreenShot("tcConfirm_UpdateStatusSend_EmailAndSms_AdmissionStatus_AfterCancelPopUp");
		} catch (Exception e) {
			getScreenShot("tcConfirm_UpdateStatusSend_EmailAndSms_AdmissionStatus_AfterCancelPopUp");
		}
	}
	@Test(priority = 46)
	public void tcConfirm_UpdateStatus_Yes_AdmissionStatus() {

		try {
			log.info("============= Strting tcConfirm_UpdateStatus_Yes_AdmissionStatus Test===========");

			statusPreAdm.confirm_UpdateStatus_Yes();

			log.info("============= Finished tcConfirm_UpdateStatus_Yes_AdmissionStatus Test===========");
			getScreenShot("tcConfirm_UpdateStatus_Yes_AdmissionStatus");
		} catch (Exception e) {
			getScreenShot("tcConfirm_UpdateStatus_Yes_AdmissionStatus");
		}
	}	
	@Test(priority = 47)
	public void tcClickOnSuccessOkBtn_AdmissionStatus_UpdateStatus() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_AdmissionStatus_UpdateStatus Test===========");

			statusPreAdm.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_AdmissionStatus_UpdateStatus Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_AdmissionStatus_UpdateStatus");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_AdmissionStatus_UpdateStatus");
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
