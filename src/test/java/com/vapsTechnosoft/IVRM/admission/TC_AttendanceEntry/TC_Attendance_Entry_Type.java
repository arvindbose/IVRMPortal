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

import com.vapsTechnosoft.IVRM.Admission.AttendanceEntry.Attendance_Entry_Type;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Attendance_Entry_Type extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Attendance_Entry_Type.class.getName());

	Attendance_Entry_Type attendanceEntryType;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "AttendanceEntryTypeData")
	public String[][] getTestAttendanceEntryData() {
		String[][] testRecordsAttendanceEntryType = getData("Admission_AttendanceEntry.xlsx",
				"AttendanceEntryTypeData");
		return testRecordsAttendanceEntryType;
	}

	@DataProvider(name = "AttendanceEntryType_Search")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearchDetails = getData("Admission_AttendanceEntry.xlsx", "Search_AttendanceEntryType");
		return testRecordsSearchDetails;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		attendanceEntryType = new Attendance_Entry_Type(driver);
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

			boolean status = attendanceEntryType.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_AttendanceEntry_AttendanceEntryType_BGHS() {

		try {
			log.info(
					"============= Strting tcNavigateToAdmission_AttendanceEntry_AttendanceEntryType_BGHS Test===========");

			attendanceEntryType.navigateToAdmission_AttendanceEntry_AttendanceEntryType_BGHS();

			log.info(
					"============= Finished tcNavigateToAdmission_AttendanceEntry_AttendanceEntryType_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_AttendanceEntry_AttendanceEntryType_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_AttendanceEntry_AttendanceEntryType_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyAttendanceEntry_AttendanceEntryType_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyAttendanceEntry_AttendanceEntryType_BGHSPage Test===========");

			boolean status = attendanceEntryType.verifyAttendanceEntry_AttendanceEntryType_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAttendanceEntry_AttendanceEntryType_BGHSPage Test===========");
			getScreenShot("tcVerifyAttendanceEntry_AttendanceEntryType_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAttendanceEntry_AttendanceEntryType_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankAttendanceEntryTypeForm() {

		try {
			log.info("============= Strting tcSubmitBlankAttendanceEntryTypeForm Test===========");

			attendanceEntryType.submitBlankAttendanceEntryTypeForm();

			log.info("============= Finished tcSubmitBlankAttendanceEntryTypeForm Test===========");
			getScreenShot("tcSubmitBlankAttendanceEntryTypeForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankAttendanceEntryTypeForm");
		}
	}

	@Test(priority = 6, dataProvider = "AttendanceEntryTypeData")
	public void tcFillAttendanceEntryTypeForm(String academicYear, String class_Search, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelect_PreAdmissionFlag_WrittenForm Test===========");

			attendanceEntryType.fillAttendanceEntryTypeForm(academicYear, class_Search);

			log.info("============= Finished tcSelect_PreAdmissionFlag_WrittenForm Test===========");
			getScreenShot("tcSelect_PreAdmissionFlag_WrittenForm");
		} catch (Exception e) {
			getScreenShot("tcSelect_PreAdmissionFlag_WrittenForm");
		}
	}

	@Test(priority = 7)
	public void tcSelect_DailyOnce_RadioButton() {

		try {
			log.info("============= Strting tcSelect_DailyOnce_RadioButton Test===========");

			attendanceEntryType.select_DailyOnce_RadioButton();

			log.info("============= Finished tcSelect_DailyOnce_RadioButton Test===========");
			getScreenShot("tcSelect_DailyOnce_RadioButton");
		} catch (Exception e) {
			getScreenShot("tcSelect_DailyOnce_RadioButton");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeAttendanceEntryType() {

		try {
			log.info("============= Strting tcMinimizeAttendanceEntryType Test===========");

			attendanceEntryType.minimizeAttendanceEntryType();

			log.info("============= Finished tcMinimizeAttendanceEntryType Test===========");
			getScreenShot("tcMinimizeAttendanceEntryType");
		} catch (Exception e) {
			getScreenShot("tcMinimizeAttendanceEntryType");
		}
	}

	@Test(priority = 9)
	public void tcMinimizeAttendanceEntryTypeList() {

		try {
			log.info("============= Strting tcMinimizeAttendanceEntryTypeList Test===========");

			attendanceEntryType.minimizeAttendanceEntryTypeList();

			log.info("============= Finished tcMinimizeAttendanceEntryTypeList Test===========");
			getScreenShot("tcMinimizeAttendanceEntryTypeList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeAttendanceEntryTypeList");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeAttendanceEntryType() {

		try {
			log.info("============= Strting tcMaximizeAttendanceEntryType Test===========");

			attendanceEntryType.maximizeAttendanceEntryType();

			log.info("============= Finished tcMaximizeAttendanceEntryType Test===========");
			getScreenShot("tcMaximizeAttendanceEntryType");
		} catch (Exception e) {
			getScreenShot("tcMaximizeAttendanceEntryType");
		}
	}

	@Test(priority = 11)
	public void tcMaximizeAttendanceEntryTypeList() {

		try {
			log.info("============= Strting tcMaximizeAttendanceEntryTypeList Test===========");

			attendanceEntryType.maximizeAttendanceEntryTypeList();

			log.info("============= Finished tcMaximizeAttendanceEntryTypeList Test===========");
			getScreenShot("tcMaximizeAttendanceEntryTypeList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeAttendanceEntryTypeList");
		}
	}

	@Test(priority = 12)
	public void tcClearFilledAttendanceEntryTypeForm() {

		try {
			log.info("============= Strting tcClearFilledAttendanceEntryTypeForm Test===========");

			attendanceEntryType.clearFilledAttendanceEntryTypeForm();

			log.info("============= Finished tcClearFilledAttendanceEntryTypeForm Test===========");
			getScreenShot("tcClearFilledAttendanceEntryTypeForm");
		} catch (Exception e) {
			getScreenShot("tcClearFilledAttendanceEntryTypeForm");
		}
	}

	@Test(priority = 13, dataProvider = "AttendanceEntryTypeData")
	public void tcFillAttendanceEntryTypeForm_AfterClear(String academicYear, String class_Search, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillAttendanceEntryTypeForm_AfterClear Test===========");

			attendanceEntryType.fillAttendanceEntryTypeForm(academicYear, class_Search);

			log.info("============= Finished tcFillAttendanceEntryTypeForm_AfterClear Test===========");
			getScreenShot("tcFillAttendanceEntryTypeForm_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcFillAttendanceEntryTypeForm_AfterClear");
		}
	}

	@Test(priority = 14)
	public void tcSelect_DailyOnce_RadioButton_AfterClear() {

		try {
			log.info("============= Strting tcSelect_DailyOnce_RadioButton_AfterClear Test===========");

			attendanceEntryType.select_DailyOnce_RadioButton();

			log.info("============= Finished tcSelect_DailyOnce_RadioButton_AfterClear Test===========");
			getScreenShot("tcSelect_DailyOnce_RadioButton_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelect_DailyOnce_RadioButton_AfterClear");
		}
	}

	@Test(priority = 15)
	public void tcSaveFilledAttendanceEntryTypeForm() {

		try {
			log.info("============= Strting tcSaveFilledAttendanceEntryTypeForm Test===========");

			attendanceEntryType.saveFilledAttendanceEntryTypeForm();

			log.info("============= Finished tcSaveFilledAttendanceEntryTypeForm Test===========");
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm");
		} catch (Exception e) {
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm");
		}
	}

	@Test(priority = 16)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			attendanceEntryType.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}

	@Test(priority = 17)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			attendanceEntryType.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	@Test(priority = 18, dataProvider = "AttendanceEntryType_Search")
	public void tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid(String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid Test===========");

			attendanceEntryType.searchWithClassNameInThe_AttendanceEntryTypeListGrid(className);

			log.info("============= Finished tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid Test===========");
			getScreenShot("tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid");
		}
	}

	@Test(priority = 19, dataProvider = "AttendanceEntryType_Search")
	public void tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid(String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid Test===========");

			attendanceEntryType.verifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid(className);

			log.info(
					"============= Finished tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid Test===========");
			getScreenShot("tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid");
		}
	}

	@Test(priority = 20, dataProvider = "AttendanceEntryType_Search")
	public void tcEditAttendanceEntryType(String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditAttendanceEntryType Test===========");

			attendanceEntryType.editAttendanceEntryType(className);

			log.info("============= Finished tcEditAttendanceEntryType Test===========");
			getScreenShot("tcEditAttendanceEntryType");
		} catch (Exception e) {
			getScreenShot("tcEditAttendanceEntryType");
		}
	}

	@Test(priority = 21)
	public void tcSaveFilledAttendanceEntryTypeForm_Edit() {

		try {
			log.info("============= Strting tcSaveFilledAttendanceEntryTypeForm_Edit Test===========");

			attendanceEntryType.saveFilledAttendanceEntryTypeForm();

			log.info("============= Finished tcSaveFilledAttendanceEntryTypeForm_Edit Test===========");
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm_Edit");
		}
	}

	@Test(priority = 22)
	public void tcPopWindowMessage_SubmitSuccessfully_Edit_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");

			attendanceEntryType.popWindowMessage_SubmitSuccessfully_Edit();

			log.info("============= Finished tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation");
		}
	}

	@Test(priority = 23)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			attendanceEntryType.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	@Test(priority = 24, dataProvider = "AttendanceEntryTypeData")
	public void tcFillAttendanceEntryTypeForm_DailyTwice(String academicYear, String class_Search, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillAttendanceEntryTypeForm_DailyTwice Test===========");

			attendanceEntryType.fillAttendanceEntryTypeForm(academicYear, class_Search);

			log.info("============= Finished tcFillAttendanceEntryTypeForm_DailyTwice Test===========");
			getScreenShot("tcFillAttendanceEntryTypeForm_DailyTwice");
		} catch (Exception e) {
			getScreenShot("tcFillAttendanceEntryTypeForm_DailyTwice");
		}
	}

	@Test(priority = 25)
	public void tcSelect_DailyTwice_RadioButton_AfterClear() {

		try {
			log.info("============= Starting tcSelect_DailyTwice_RadioButton_AfterClear Test===========");

			attendanceEntryType.select_DailyTwice_RadioButton();

			log.info("============= Finished tcSelect_DailyTwice_RadioButton_AfterClear Test===========");
			getScreenShot("tcSelect_DailyTwice_RadioButton_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelect_DailyTwice_RadioButton_AfterClear");
		}
	}

	@Test(priority = 26)
	public void tcSaveFilledAttendanceEntryTypeForm_ForDailyTwice() {

		try {
			log.info("============= Strting tcSaveFilledAttendanceEntryTypeForm_ForDailyTwice Test===========");

			attendanceEntryType.saveFilledAttendanceEntryTypeForm();

			log.info("============= Finished tcSaveFilledAttendanceEntryTypeForm_ForDailyTwice Test===========");
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm_ForDailyTwice");
		} catch (Exception e) {
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm_ForDailyTwice");
		}
	}

	@Test(priority = 27)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_ForDailyTwice() {

		try {
			log.info(
					"============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_ForDailyTwice Test===========");

			attendanceEntryType.popWindowMessage_SubmitSuccessfully();

			log.info(
					"============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_ForDailyTwice Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_ForDailyTwice");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_ForDailyTwice");
		}
	}

	@Test(priority = 28)
	public void tcClickOnOkSuccessButton_ForDailyTwice() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_ForDailyTwice Test===========");

			attendanceEntryType.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_ForDailyTwice Test===========");
			getScreenShot("tcClickOnOkSuccessButton_ForDailyTwice");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_ForDailyTwice");
		}
	}

	@Test(priority = 29, dataProvider = "AttendanceEntryType_Search")
	public void tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid_ForDailyTwice(String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid_ForDailyTwice Test===========");

			attendanceEntryType.searchWithClassNameInThe_AttendanceEntryTypeListGrid(className);

			log.info(
					"============= Finished tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid_ForDailyTwice Test===========");
			getScreenShot("tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid_ForDailyTwice");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid_ForDailyTwice");
		}
	}

	@Test(priority = 30, dataProvider = "AttendanceEntryType_Search")
	public void tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid_ForDailyTwice(String className,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid_ForDailyTwice Test===========");

			attendanceEntryType.verifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid(className);

			log.info(
					"============= Finished tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid_ForDailyTwice Test===========");
			getScreenShot("tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid_ForDailyTwice");
		} catch (Exception e) {
			getScreenShot("tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid_ForDailyTwice");
		}
	}

	@Test(priority = 31, dataProvider = "AttendanceEntryType_Search")
	public void tcEditAttendanceEntryType_ForDailyTwice(String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEditAttendanceEntryType_ForDailyTwice Test===========");

			attendanceEntryType.editAttendanceEntryType(className);

			log.info("============= Finished tcEditAttendanceEntryType_ForDailyTwice Test===========");
			getScreenShot("tcEditAttendanceEntryType_ForDailyTwice");
		} catch (Exception e) {
			getScreenShot("tcEditAttendanceEntryType_ForDailyTwice");
		}
	}

	@Test(priority = 32)
	public void tcSaveFilledAttendanceEntryTypeForm_Edit_ForDailyTwice() {

		try {
			log.info("============= Strting tcSaveFilledAttendanceEntryTypeForm_Edit_ForDailyTwice Test===========");

			attendanceEntryType.saveFilledAttendanceEntryTypeForm();

			log.info("============= Finished tcSaveFilledAttendanceEntryTypeForm_Edit_ForDailyTwice Test===========");
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm_Edit_ForDailyTwice");
		} catch (Exception e) {
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm_Edit_ForDailyTwice");
		}
	}

	@Test(priority = 33)
	public void tcPopWindowMessage_SubmitSuccessfully_Edit_Validation_ForDailyTwice() {

		try {
			log.info(
					"============= Strting tcPopWindowMessage_SubmitSuccessfully_Edit_Validation_ForDailyTwice Test===========");

			attendanceEntryType.popWindowMessage_SubmitSuccessfully_Edit();

			log.info(
					"============= Finished tcPopWindowMessage_SubmitSuccessfully_Edit_Validation_ForDailyTwice Test===========");
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation_ForDailyTwice");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation_ForDailyTwice");
		}
	}

	@Test(priority = 34)
	public void tcClickOnOkSuccessButton_Edit_ForDailyTwice() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit_ForDailyTwice Test===========");

			attendanceEntryType.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit_ForDailyTwice Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit_ForDailyTwice");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit_ForDailyTwice");
		}
	}

	@Test(priority = 35, dataProvider = "AttendanceEntryTypeData")
	public void tcFillAttendanceEntryTypeForm_Monthly(String academicYear, String class_Search, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcFillAttendanceEntryTypeForm_Monthly Test===========");

			attendanceEntryType.fillAttendanceEntryTypeForm(academicYear, class_Search);

			log.info("============= Finished tcFillAttendanceEntryTypeForm_Monthly Test===========");
			getScreenShot("tcFillAttendanceEntryTypeForm_Monthly");
		} catch (Exception e) {
			getScreenShot("tcFillAttendanceEntryTypeForm_Monthly");
		}
	}

	@Test(priority = 36)
	public void tcSelect_Monthly_RadioButton_AfterClear() {

		try {
			log.info("============= Starting tcSelect_Monthly_RadioButton_AfterClear Test===========");

			attendanceEntryType.select_Monthly_RadioButton();

			log.info("============= Finished tcSelect_Monthly_RadioButton_AfterClear Test===========");
			getScreenShot("tcSelect_Monthly_RadioButton_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelect_Monthly_RadioButton_AfterClear");
		}
	}

	@Test(priority = 37)
	public void tcSaveFilledAttendanceEntryTypeForm_Monthly() {

		try {
			log.info("============= Strting tcSaveFilledAttendanceEntryTypeForm_Monthly Test===========");

			attendanceEntryType.saveFilledAttendanceEntryTypeForm();

			log.info("============= Finished tcSaveFilledAttendanceEntryTypeForm_Monthly Test===========");
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm_Monthly");
		} catch (Exception e) {
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm_Monthly");
		}
	}

	@Test(priority = 38)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_Monthly() {

		try {
			log.info(
					"============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_Monthly Test===========");

			attendanceEntryType.popWindowMessage_SubmitSuccessfully();

			log.info(
					"============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_Monthly Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_Monthly");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_Monthly");
		}
	}

	@Test(priority = 39)
	public void tcClickOnOkSuccessButton_Monthly() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Monthly Test===========");

			attendanceEntryType.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Monthly Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Monthly");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Monthly");
		}
	}

	@Test(priority = 40, dataProvider = "AttendanceEntryType_Search")
	public void tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid_Monthly(String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid_Monthly Test===========");

			attendanceEntryType.searchWithClassNameInThe_AttendanceEntryTypeListGrid(className);

			log.info(
					"============= Finished tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid_Monthly Test===========");
			getScreenShot("tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid_Monthly");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassNameInThe_AttendanceEntryTypeListGrid_Monthly");
		}
	}

	@Test(priority = 41, dataProvider = "AttendanceEntryType_Search")
	public void tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid_Monthly(String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid_Monthly Test===========");

			attendanceEntryType.verifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid(className);

			log.info(
					"============= Finished tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid_Monthly Test===========");
			getScreenShot("tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid_Monthly");
		} catch (Exception e) {
			getScreenShot("tcVerifyAttendanceEntryTypeIn_AttendanceEntryTypeListGrid_Monthly");
		}
	}

	@Test(priority = 42, dataProvider = "AttendanceEntryType_Search")
	public void tcEditAttendanceEntryType_Monthly(String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Starting tcEditAttendanceEntryType_Monthly Test===========");

			attendanceEntryType.editAttendanceEntryType(className);

			log.info("============= Finished tcEditAttendanceEntryType_Monthly Test===========");
			getScreenShot("tcEditAttendanceEntryType_Monthly");
		} catch (Exception e) {
			getScreenShot("tcEditAttendanceEntryType_Monthly");
		}
	}

	@Test(priority = 43)
	public void tcSaveFilledAttendanceEntryTypeForm_Edit_Monthly() {

		try {
			log.info("============= Strting tcSaveFilledAttendanceEntryTypeForm_Edit_Monthly Test===========");

			attendanceEntryType.saveFilledAttendanceEntryTypeForm();

			log.info("============= Finished tcSaveFilledAttendanceEntryTypeForm_Edit_Monthly Test===========");
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm_Edit_Monthly");
		} catch (Exception e) {
			getScreenShot("tcSaveFilledAttendanceEntryTypeForm_Edit_Monthly");
		}
	}

	@Test(priority = 44)
	public void tcPopWindowMessage_SubmitSuccessfully_Edit_Validation_Monthly() {

		try {
			log.info(
					"============= Strting tcPopWindowMessage_SubmitSuccessfully_Edit_Validation_Monthly Test===========");

			attendanceEntryType.popWindowMessage_SubmitSuccessfully_Edit();

			log.info(
					"============= Finished tcPopWindowMessage_SubmitSuccessfully_Edit_Validation_Monthly Test===========");
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation_Monthly");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation_Monthly");
		}
	}

	@Test(priority = 45)
	public void tcClickOnOkSuccessButton_Edit_Monthly() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit_Monthly Test===========");

			attendanceEntryType.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit_Monthly Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit_Monthly");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit_Monthly");
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
