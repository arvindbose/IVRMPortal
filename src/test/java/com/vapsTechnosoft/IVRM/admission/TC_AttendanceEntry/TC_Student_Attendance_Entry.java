/**
 * 
 */
package com.vapsTechnosoft.IVRM.admission.TC_AttendanceEntry;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Admission.AttendanceEntry.Student_Attendance_Entry;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Vaps 
 * Login with Staff login credentials UserName: Priya Password:
 *         Password@123
 */
public class TC_Student_Attendance_Entry extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Student_Attendance_Entry.class.getName());

	Student_Attendance_Entry studentAttendanceEntry;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData_Staff")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("AdmissionReports.xlsx", "IVRM_StaffLogin_Data");
		return testRecordsLogin;
	}

	@DataProvider(name = "AttendanceEntry_StudentAttendanceEntryData_DailyOnce")
	public String[][] getTestDailyOnceData() {
		String[][] testRecordsAttendanceEntry = getData("Admission_AttendanceEntry.xlsx", "AttendanceEntryDailyOnce");
		return testRecordsAttendanceEntry;
	}

	@DataProvider(name = "Search_StudentAttendanceEntryData_DailyOnce")
	public String[][] getTestSearchDailyOnceData() {
		String[][] testRecordsSearchDailyOnce = getData("Admission_AttendanceEntry.xlsx", "Search_DailyOnceEntry");
		return testRecordsSearchDailyOnce;
	}
	@DataProvider(name = "AttendanceEntry_StudentAttendanceEntryData_DailyTwice")
	public String[][] getTestDailyTwiceData() {
		String[][] testRecordsAttendanceEntryDailyTwice = getData("Admission_AttendanceEntry.xlsx", "AttendanceEntryDailyTwice");
		return testRecordsAttendanceEntryDailyTwice;
	}

	@DataProvider(name = "Search_StudentAttendanceEntryData_DailyTwice")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearchDailyTwice = getData("Admission_AttendanceEntry.xlsx", "Search_DailyTwiceEntry");
		return testRecordsSearchDailyTwice;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		studentAttendanceEntry = new Student_Attendance_Entry(driver);
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

			boolean status = studentAttendanceEntry.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_AttendanceEntry_StudentAttendanceEntry_BGHS() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_AttendanceEntry_StudentAttendanceEntry_BGHS Test===========");

			studentAttendanceEntry.navigateToAdmission_AttendanceEntry_StudentAttendanceEntry_BGHS();

			log.info(
					"============= Finished tcNavigateToAdmission_AttendanceEntry_StudentAttendanceEntry_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_AttendanceEntry_StudentAttendanceEntry_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_AttendanceEntry_StudentAttendanceEntry_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAttendanceEntry_StudentAttendanceEntry_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyAttendanceEntry_StudentAttendanceEntry_BGHSPage Test===========");

			boolean status = studentAttendanceEntry.verifyAttendanceEntry_StudentAttendanceEntry_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAttendanceEntry_StudentAttendanceEntry_BGHSPage Test===========");
			getScreenShot("tcVerifyAttendanceEntry_StudentAttendanceEntry_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAttendanceEntry_StudentAttendanceEntry_BGHSPage");
		}
	}
	@Test(priority = 5, dataProvider = "AttendanceEntry_StudentAttendanceEntryData_DailyOnce")
	public void tcFillWith_AttendanceEntry_Data(String academicYr, String class_Entry, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillWith_AttendanceEntry_Data Test===========");

			studentAttendanceEntry.fillWith_AttendanceEntry_Data(academicYr, class_Entry, section);

			log.info("============= Finished tcFillWith_AttendanceEntry_Data Test===========");
			getScreenShot("tcFillWith_AttendanceEntry_Data");
		} catch (Exception e) {
			getScreenShot("tcFillWith_AttendanceEntry_Data");
		}
	}
	@Test(priority = 6, dataProvider = "AttendanceEntry_StudentAttendanceEntryData_DailyOnce")
	public void tcFillwith_DailyOnce_EntryData(String academicYr, String class_Entry, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillwith_DailyOnce_EntryData Test===========");

			studentAttendanceEntry.fillwith_DailyOnce_EntryData(academicYr, class_Entry, section);

			log.info("============= Finished tcFillwith_DailyOnce_EntryData Test===========");
			getScreenShot("tcFillwith_DailyOnce_EntryData");
		} catch (Exception e) {
			getScreenShot("tcFillwith_DailyOnce_EntryData");
		}
	}
	@Test(priority = 7)
	public void tcValidation_MessageForMarksEntry() {

		try {
			log.info("============= Strting tcValidation_MessageForMarksEntry Test===========");

			studentAttendanceEntry.validation_MessageForMarksEntry();

			log.info("============= Finished tcValidation_MessageForMarksEntry Test===========");
			getScreenShot("tcValidation_MessageForMarksEntry");
		} catch (Exception e) {
			getScreenShot("tcValidation_MessageForMarksEntry");
		}
	}
	
	@Test(priority = 8)
	public void tcMnimizeAttendanceEntry() {

		try {
			log.info("============= Strting tcMnimizeAttendanceEntry Test===========");

			studentAttendanceEntry.minimizeAttendanceEntry();

			log.info("============= Finished tcMnimizeAttendanceEntry Test===========");
			getScreenShot("tcMnimizeAttendanceEntry");
		} catch (Exception e) {
			getScreenShot("tcMnimizeAttendanceEntry");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_DailyOnce() {

		try {
			log.info("============= Strting tcMinimize_DailyOnce Test===========");

			studentAttendanceEntry.minimize_DailyOnce();

			log.info("============= Finished tcMinimize_DailyOnce Test===========");
			getScreenShot("tcMinimize_DailyOnce");
		} catch (Exception e) {
			getScreenShot("tcMinimize_DailyOnce");
		}
	}
	@Test(priority = 10)
	public void tcMinimize_StudentDetails() {

		try {
			log.info("============= Strting tcMinimize_StudentDetails Test===========");

			studentAttendanceEntry.minimize_StudentDetails();

			log.info("============= Finished tcMinimize_StudentDetails Test===========");
			getScreenShot("tcMinimize_StudentDetails");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentDetails");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_StudentDetails() {

		try {
			log.info("============= Strting tcMaximize_StudentDetails Test===========");

			studentAttendanceEntry.maximize_StudentDetails();

			log.info("============= Finished tcMaximize_StudentDetails Test===========");
			getScreenShot("tcMaximize_StudentDetails");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentDetails");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_DailyOnce() {

		try {
			log.info("============= Strting tcMaximize_DailyOnce Test===========");

			studentAttendanceEntry.maximize_DailyOnce();

			log.info("============= Finished tcMaximize_DailyOnce Test===========");
			getScreenShot("tcMaximize_DailyOnce");
		} catch (Exception e) {
			getScreenShot("tcMaximize_DailyOnce");
		}
	}
	@Test(priority = 13)
	public void tcMaximizeAttendanceEntry() {

		try {
			log.info("============= Strting tcMaximizeAttendanceEntry Test===========");

			studentAttendanceEntry.maximizeAttendanceEntry();

			log.info("============= Finished tcMaximizeAttendanceEntry Test===========");
			getScreenShot("tcMaximizeAttendanceEntry");
		} catch (Exception e) {
			getScreenShot("tcMaximize_DailyOnce");
		}
	}
	@Test(priority = 14)
	public void tcCancelFilled_StudentAttendanceEntryForm() {

		try {
			log.info("============= Strting tcCancelFilled_StudentAttendanceEntryForm Test===========");

			studentAttendanceEntry.cancelFilled_StudentAttendanceEntryForm();

			log.info("============= Finished tcCancelFilled_StudentAttendanceEntryForm Test===========");
			getScreenShot("tcCancelFilled_StudentAttendanceEntryForm");
		} catch (Exception e) {
			getScreenShot("tcCancelFilled_StudentAttendanceEntryForm");
		}
	}
	@Test(priority = 15, dataProvider = "AttendanceEntry_StudentAttendanceEntryData_DailyOnce")
	public void tcFillWith_AttendanceEntry_Data_AfterCancel(String academicYr, String class_Entry, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillWith_AttendanceEntry_Data Test===========");

			studentAttendanceEntry.fillWith_AttendanceEntry_Data(academicYr, class_Entry, section);

			log.info("============= Finished tcFillWith_AttendanceEntry_Data Test===========");
			getScreenShot("tcFillWith_AttendanceEntry_Data");
		} catch (Exception e) {
			getScreenShot("tcFillWith_AttendanceEntry_Data");
		}
	}
	@Test(priority = 16, dataProvider = "AttendanceEntry_StudentAttendanceEntryData_DailyOnce")
	public void tcFillwith_DailyOnce_EntryData_AfterCancel(String academicYr, String class_Entry, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillwith_DailyOnce_EntryData Test===========");

			studentAttendanceEntry.fillwith_DailyOnce_EntryData(academicYr, class_Entry, section);

			log.info("============= Finished tcFillwith_DailyOnce_EntryData Test===========");
			getScreenShot("tcFillwith_DailyOnce_EntryData");
		} catch (Exception e) {
			getScreenShot("tcFillwith_DailyOnce_EntryData");
		}
	}
	@Test(priority = 17)
	public void tcValidation_MessageForMarksEntry_AfterClear() {

		try {
			log.info("============= Strting tcValidation_MessageForMarksEntry_AfterClear Test===========");

			studentAttendanceEntry.validation_MessageForMarksEntry();

			log.info("============= Finished tcValidation_MessageForMarksEntry_AfterClear Test===========");
			getScreenShot("tcValidation_MessageForMarksEntry_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcValidation_MessageForMarksEntry_AfterClear");
		}
	}
	@Test(priority = 18, dataProvider = "Search_StudentAttendanceEntryData_DailyOnce")
	public void tcSearchWithRegistrationNumberInThe_StudentDetailsListGrid(String registrationNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithRegistrationNumberInThe_StudentDetailsListGrid Test===========");

			studentAttendanceEntry.searchWithRegistrationNumberInThe_StudentDetailsListGrid(registrationNum);

			log.info("============= Finished tcSearchWithRegistrationNumberInThe_StudentDetailsListGrid Test===========");
			getScreenShot("tcSearchWithRegistrationNumberInThe_StudentDetailsListGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithRegistrationNumberInThe_StudentDetailsListGrid");
		}
	}
	@Test(priority = 19, dataProvider = "Search_StudentAttendanceEntryData_DailyOnce")
	public void tcVerifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid(String registrationNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid Test===========");

			studentAttendanceEntry.verifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid(registrationNum);

			log.info("============= Finished tcVerifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid Test===========");
			getScreenShot("tcVerifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid");
		}
	}
	@Test(priority = 20, dataProvider = "Search_StudentAttendanceEntryData_DailyOnce")
	public void tcSelectStudent_ForAttendanceEntry_FromStudentDetailsList(String registrationNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudent_ForAttendanceEntry_FromStudentDetailsList Test===========");

			studentAttendanceEntry.selectStudent_ForAttendanceEntry_FromStudentDetailsList(registrationNum);

			log.info("============= Finished tcSelectStudent_ForAttendanceEntry_FromStudentDetailsList Test===========");
			getScreenShot("tcSelectStudent_ForAttendanceEntry_FromStudentDetailsList");
		} catch (Exception e) {
			getScreenShot("tcSelectStudent_ForAttendanceEntry_FromStudentDetailsList");
		}
	}
	@Test(priority = 21)
	public void tcSaveFilled_StudentAttendanceEntryForm() {

		try {
			log.info("============= Strting tcSaveFilled_StudentAttendanceEntryForm Test===========");

			studentAttendanceEntry.saveFilled_StudentAttendanceEntryForm();

			log.info("============= Finished tcSaveFilled_StudentAttendanceEntryForm Test===========");
			getScreenShot("tcSaveFilled_StudentAttendanceEntryForm");
		} catch (Exception e) {
			getScreenShot("tcSaveFilled_StudentAttendanceEntryForm");
		}
	}
	@Test(priority = 22)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			studentAttendanceEntry.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}
	@Test(priority = 23)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			studentAttendanceEntry.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}
	
	
	@Test(priority = 24, dataProvider = "AttendanceEntry_StudentAttendanceEntryData_DailyTwice")
	public void tcFillWith_AttendanceEntry_Data_DailyTwice(String academicYr, String class_Entry, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillWith_AttendanceEntry_Data_DailyTwice Test===========");

			studentAttendanceEntry.fillWith_AttendanceEntry_Data(academicYr, class_Entry, section);

			log.info("============= Finished tcFillWith_AttendanceEntry_Data_DailyTwice Test===========");
			getScreenShot("tcFillWith_AttendanceEntry_Data_DailyTwice");
		} catch (Exception e) {
			getScreenShot("tcFillWith_AttendanceEntry_Data_DailyTwice");
		}
	}
	@Test(priority = 25, dataProvider = "AttendanceEntry_StudentAttendanceEntryData_DailyTwice")
	public void tcFillwith_DailyTwice_AttendanceEntryData(String academicYr, String class_Entry, String section, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillwith_DailyTwice_AttendanceEntryData Test===========");

			studentAttendanceEntry.fillwith_DailyTwice_AttendanceEntryData(academicYr, class_Entry, section);

			log.info("============= Finished tcFillwith_DailyTwice_AttendanceEntryData Test===========");
			getScreenShot("tcFillwith_DailyTwice_AttendanceEntryData");
		} catch (Exception e) {
			getScreenShot("tcFillwith_DailyTwice_AttendanceEntryData");
		}
	}
	@Test(priority = 26)
	public void tcValidation_MessageForMarksEntry_DailyTwice() {

		try {
			log.info("============= Strting tcValidation_MessageForMarksEntry_DailyTwice Test===========");

			studentAttendanceEntry.validation_MessageForMarksEntry();

			log.info("============= Finished tcValidation_MessageForMarksEntry_DailyTwice Test===========");
			getScreenShot("tcValidation_MessageForMarksEntry_DailyTwice");
		} catch (Exception e) {
			getScreenShot("tcValidation_MessageForMarksEntry_DailyTwice");
		}
	}
	
	@Test(priority = 27, dataProvider = "Search_StudentAttendanceEntryData_DailyTwice")
	public void tcSearchWithRegistrationNumberInThe_StudentDetailsListGrid_DailyTwice(String registrationNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithRegistrationNumberInThe_StudentDetailsListGrid_DailyTwice Test===========");

			studentAttendanceEntry.searchWithRegistrationNumberInThe_StudentDetailsListGrid_DailyTwice(registrationNum);

			log.info("============= Finished tcSearchWithRegistrationNumberInThe_StudentDetailsListGrid_DailyTwice Test===========");
			getScreenShot("tcSearchWithRegistrationNumberInThe_StudentDetailsListGrid_DailyTwice");
		} catch (Exception e) {
			getScreenShot("tcSearchWithRegistrationNumberInThe_StudentDetailsListGrid_DailyTwice");
		}
	}
	@Test(priority = 28, dataProvider = "Search_StudentAttendanceEntryData_DailyTwice")
	public void tcVerifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid_DailyTwice(String registrationNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid_DailyTwice Test===========");

			studentAttendanceEntry.verifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid_DailyTwice(registrationNum);

			log.info("============= Finished tcVerifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid_DailyTwice Test===========");
			getScreenShot("tcVerifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid_DailyTwice");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentIn_StudentAttendanceEntry_StudentDetailsListGrid_DailyTwice");
		}
	}
	@Test(priority = 29, dataProvider = "Search_StudentAttendanceEntryData_DailyTwice")
	public void tcSelectStudent_ForAttendanceEntry_FromStudentDetailsList_DailyTwice(String registrationNum, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectStudent_ForAttendanceEntry_FromStudentDetailsList_DailyTwice Test===========");

			studentAttendanceEntry.selectStudent_ForAttendanceEntry_FromStudentDetailsList_DailyTwice(registrationNum);

			log.info("============= Finished tcSelectStudent_ForAttendanceEntry_FromStudentDetailsList_DailyTwice Test===========");
			getScreenShot("tcSelectStudent_ForAttendanceEntry_FromStudentDetailsList_DailyTwice");
		} catch (Exception e) {
			getScreenShot("tcSelectStudent_ForAttendanceEntry_FromStudentDetailsList_DailyTwice");
		}
	}
	@Test(priority = 30)
	public void tcSaveFilled_StudentAttendanceEntryForm_DailyTwice() {

		try {
			log.info("============= Strting tcSaveFilled_StudentAttendanceEntryForm_DailyTwice Test===========");

			studentAttendanceEntry.saveFilled_StudentAttendanceEntryForm();

			log.info("============= Finished tcSaveFilled_StudentAttendanceEntryForm_DailyTwice Test===========");
			getScreenShot("tcSaveFilled_StudentAttendanceEntryForm_DailyTwice");
		} catch (Exception e) {
			getScreenShot("tcSaveFilled_StudentAttendanceEntryForm_DailyTwice");
		}
	}
	
	@Test(priority = 31)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_Twice() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_Twice Test===========");

			studentAttendanceEntry.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_Twice Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_Twice");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_Twice");
		}
	}
	@Test(priority = 32)
	public void tcClickOnOkSuccessButton_DailyTwice() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_DailyTwice Test===========");

			studentAttendanceEntry.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_DailyTwice Test===========");
			getScreenShot("tcClickOnOkSuccessButton_DailyTwice");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_DailyTwice");
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
