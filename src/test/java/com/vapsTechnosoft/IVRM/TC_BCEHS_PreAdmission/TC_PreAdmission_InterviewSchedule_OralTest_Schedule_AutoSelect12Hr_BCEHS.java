/**
 * 
 */
package com.vapsTechnosoft.IVRM.TC_BCEHS_PreAdmission;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.BCEHS_PreAdmission.PreAdmission_InterviewSchedule_OralTest_Schedule_AutoSelect12Hr_BCEHS;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_PreAdmission_InterviewSchedule_OralTest_Schedule_AutoSelect12Hr_BCEHS extends TestBase {

	public static final Logger log = Logger
			.getLogger(TC_PreAdmission_InterviewSchedule_OralTest_Schedule_AutoSelect12Hr_BCEHS.class.getName());

	PreAdmission_InterviewSchedule_OralTest_Schedule_AutoSelect12Hr_BCEHS oralTestSchedule;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "BGHSOralTestScheduleData")
	public String[][] getTestData() {
		String[][] testRecordsStuDetails = getData("BGHS_PreAdmissionData.xlsx", "BGHS_OralTestScheduleData");
		return testRecordsStuDetails;
	}

	@DataProvider(name = "SearchByScheduleNameData")
	public String[][] getTestDataSch() {
		String[][] testRecordsSch = getData("BGHS_PreAdmissionData.xlsx", "BGHS_ScheduleNameData");
		return testRecordsSch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		oralTestSchedule = new PreAdmission_InterviewSchedule_OralTest_Schedule_AutoSelect12Hr_BCEHS(driver);
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

			boolean status = oralTestSchedule.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateTo_InterviewSchedule_OralTestSchedule_BGHS() {

		try {
			log.info("============= Strting tcNavigateTo_InterviewSchedule_OralTestSchedule_BGHS Test===========");

			oralTestSchedule.navigateTo_InterviewSchedule_OralTestSchedule_BGHS();

			log.info("============= Finished tcNavigateTo_InterviewSchedule_OralTestSchedule_BGHS Test===========");
			getScreenShot("tcNavigateTo_InterviewSchedule_OralTestSchedule_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateTo_InterviewSchedule_OralTestSchedule_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyInterviewSchedule_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyInterviewSchedule_BGHSPage Test===========");

			boolean status = oralTestSchedule.verifyInterviewSchedule_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyInterviewSchedule_BGHSPage Test===========");
			getScreenShot("tcVerifyInterviewSchedule_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyInterviewSchedule_BGHSPage");
		}
	}

	@Test(priority = 5, dataProvider = "BGHSOralTestScheduleData")
	public void tcOralTestScheduleInfo(String scheduleName, String scheduleDate, String remarks, String supervisor,
			String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr, String ToSchTimeMin,
			String minutes, String nosOfStudents, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcOralTestScheduleInfo Test===========");

			oralTestSchedule.oralTestScheduleInfo(scheduleName, scheduleDate, remarks, supervisor, skill, FromSchTimeHr,
					FromSchTimeMin, ToSchTimeHr, ToSchTimeMin, minutes, nosOfStudents);
			log.info("============= Finished tcOralTestScheduleInfo Test===========");
			getScreenShot("tcOralTestScheduleInfo");
		} catch (Exception e) {
			getScreenShot("tcOralTestScheduleInfo");
		}
	}

	@Test(priority = 6)
	public void tcResetFilledOralTestScheduleForm() {

		try {
			log.info("============= Strting tcResetFilledOralTestScheduleForm Test===========");

			oralTestSchedule.resetFilledOralTestScheduleForm();

			log.info("============= Finished tcResetFilledOralTestScheduleForm Test===========");
			getScreenShot("tcResetFilledOralTestScheduleForm");
		} catch (Exception e) {
			getScreenShot("tcResetFilledOralTestScheduleForm");
		}
	}
	@Test(priority = 7)
	public void tcMinimizeOralTestSchedule() {

		try {
			log.info("============= Strting tcMinimizeOralTestSchedule Test===========");

			oralTestSchedule.minimizeOralTestSchedule();

			log.info("============= Finished tcMinimizeOralTestSchedule Test===========");
			getScreenShot("tcMinimizeOralTestSchedule");
		} catch (Exception e) {
			getScreenShot("tcMinimizeOralTestSchedule");
		}
	}
	
	@Test(priority = 8)
	public void tcMinimizeStudnetList() {

		try {
			log.info("============= Strting tcMinimizeStudnetList Test===========");

			oralTestSchedule.minimizeStudnetList();

			log.info("============= Finished tcMinimizeStudnetList Test===========");
			getScreenShot("tcMinimizeStudnetList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeStudnetList");
		}
	}
	
	@Test(priority = 9)
	public void tcSortingUsingColumnHeader() {

		try {
			log.info("============= Strting tcSortingUsingColumnHeader Test===========");
			getScreenShot("tcSortingUsingColumnHeader_Before Sorting");
			oralTestSchedule.sortingUsingColumnHeader();
			log.info("============= Finished tcSortingUsingColumnHeader Test===========");
			getScreenShot("tcSortingUsingColumnHeader");
		} catch (Exception e) {
			getScreenShot("tcSortingUsingColumnHeader");
		}
	}
	
	@Test(priority = 10)
	public void tcMinimizeOralTestScheduleList() {

		try {
			log.info("============= Strting tcMinimizeOralTestScheduleList Test===========");

			oralTestSchedule.minimizeOralTestScheduleList();

			log.info("============= Finished tcMinimizeOralTestScheduleList Test===========");
			getScreenShot("tcMinimizeOralTestScheduleList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeOralTestScheduleList");
		}
	}
	
	@Test(priority = 11)
	public void tcMaximizeOralTestSchedule() {

		try {
			log.info("============= Strting tcMaximizeOralTestSchedule Test===========");

			oralTestSchedule.maximizeOralTestSchedule();

			log.info("============= Finished tcMaximizeOralTestSchedule Test===========");
			getScreenShot("tcMaximizeOralTestSchedule");
		} catch (Exception e) {
			getScreenShot("tcMaximizeOralTestSchedule");
		}
	}
	
	@Test(priority = 12)
	public void tcMaximizeStudentList() {

		try {
			log.info("============= Strting tcMaximizeStudentList Test===========");

			oralTestSchedule.maximizeStudentList();

			log.info("============= Finished tcMaximizeStudentList Test===========");
			getScreenShot("tcMaximizeStudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeStudentList");
		}
	}
	
	
	@Test(priority = 13)
	public void tcMaximizeOralTestScheduleList() {

		try {
			log.info("============= Strting tcMaximizeOralTestScheduleList Test===========");

			oralTestSchedule.maximizeOralTestScheduleList();
			log.info("============= Finished tcMaximizeOralTestScheduleList Test===========");
			getScreenShot("tcMaximizeOralTestScheduleList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeOralTestScheduleList");
		}
	}

	
	@Test(priority = 14, dataProvider = "BGHSOralTestScheduleData")
	public void tcOralTestScheduleInfo_AfterReset(String scheduleName, String scheduleDate, String remarks,
			String supervisor, String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr,
			String ToSchTimeMin, String minutes, String nosOfStudents, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcOralTestScheduleInfoAfterReset Test===========");

			oralTestSchedule.oralTestScheduleInfo(scheduleName, scheduleDate, remarks, supervisor, skill, FromSchTimeHr,
					FromSchTimeMin, ToSchTimeHr, ToSchTimeMin, minutes, nosOfStudents);
			log.info("============= Finished tcOralTestScheduleInfoAfterReset Test===========");
			getScreenShot("tcOralTestScheduleInfoAfterReset");
		} catch (Exception e) {
			getScreenShot("tcOralTestScheduleInfoAfterReset");
		}
	}

	@Test(priority = 15)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			oralTestSchedule.clickOnCancelButton();
			log.info("============= Finished tcClickOnCancelButton Test===========");
			getScreenShot("tcClickOnCancelButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton");
		}
	}

	@Test(priority = 16, dataProvider = "BGHSOralTestScheduleData")
	public void tcOralTestScheduleInfo_AfterCancel(String scheduleName, String scheduleDate, String remarks,
			String supervisor, String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr,
			String ToSchTimeMin, String minutes, String nosOfStudents, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcOralTestScheduleInfo_AfterCancel Test===========");

			oralTestSchedule.oralTestScheduleInfo(scheduleName, scheduleDate, remarks, supervisor, skill, FromSchTimeHr,
					FromSchTimeMin, ToSchTimeHr, ToSchTimeMin, minutes, nosOfStudents);
			log.info("============= Finished tcOralTestScheduleInfo_AfterCancel Test===========");
			getScreenShot("tcOralTestScheduleInfo_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcOralTestScheduleInfo_AfterCancel");
		}
	}
	
	@Test(priority = 17)
	public void tcClickOnSaveButton() {

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			oralTestSchedule.clickOnSaveButton();
			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}
	
	@Test(priority = 18)
	public void tcPopUpValidationOnSuccess() {

		try {
			log.info("============= Strting tcPopUpValidationOnSuccess Test===========");

			oralTestSchedule.popUpValidationOnSuccess();
			log.info("============= Finished tcPopUpValidationOnSuccess Test===========");
			getScreenShot("tcPopUpValidationOnSuccess");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccess");
		}
	}

	@Test(priority = 19)
	public void tcValidationOf12HourTimeFormatScheduleList() {

		try {
			log.info("============= Strting tcValidationOf12HourTimeFormatScheduleList Test===========");

			oralTestSchedule.validationOf12HourTimeFormatScheduleList();
			log.info("============= Finished tcValidationOf12HourTimeFormatScheduleList Test===========");
			getScreenShot("tcValidationOf12HourTimeFormatScheduleList");
		} catch (Exception e) {
			getScreenShot("tcValidationOf12HourTimeFormatScheduleList");
		}
	}

	@Test(priority = 20)
	public void tcValidationOf24HourTimeFormatScheduleList() {

		try {
			log.info("============= Strting tcValidationOf24HourTimeFormatScheduleList Test===========");

			oralTestSchedule.validationOf24HourTimeFormatScheduleList();
			log.info("============= Finished tcValidationOf24HourTimeFormatScheduleList Test===========");
			getScreenShot("tcValidationOf24HourTimeFormatScheduleList");
		} catch (Exception e) {
			getScreenShot("tcValidationOf24HourTimeFormatScheduleList");
		}
	}

	

	@Test(priority = 21, dataProvider = "SearchByScheduleNameData")
	public void tcSearchWithScheduleNameInScheduleList(String scheduleName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithScheduleNameInScheduleList Test===========");

			oralTestSchedule.searchWithScheduleNameInScheduleList(scheduleName);
			log.info("============= Finished tcSearchWithScheduleNameInScheduleList Test===========");
			getScreenShot("tcSearchWithScheduleNameInScheduleList");
		} catch (Exception e) {
			getScreenShot("tcSearchWithScheduleNameInScheduleList");

		}
	}

	@Test(priority = 22, dataProvider = "SearchByScheduleNameData")
	public void tcVerifyscheduleNameInOralTestScheduleListGrid(String scheduleName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyscheduleNameInOralTestScheduleListGrid Test===========");

			oralTestSchedule.verifyscheduleNameInOralTestScheduleListGrid(scheduleName);
			log.info("============= Finished tcVerifyscheduleNameInOralTestScheduleListGrid Test===========");
			getScreenShot("tcVerifyscheduleNameInOralTestScheduleListGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyscheduleNameInOralTestScheduleListGrid");

		}
	}

	@Test(priority = 23, dataProvider = "SearchByScheduleNameData")
	public void tcDeleteScheduledOralTest(String scheduleName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteScheduledOralTest Test===========");

			oralTestSchedule.deleteScheduledOralTest(scheduleName);
			log.info("============= Finished tcDeleteScheduledOralTest Test===========");
			getScreenShot("tcDeleteScheduledOralTest");
		} catch (Exception e) {
			getScreenShot("tcDeleteScheduledOralTest");

		}
	}

	@Test(priority = 24)
	public void tcCancellationOfDelete() {

		try {
			log.info("============= Strting tcCancellationOfDelete Test===========");

			oralTestSchedule.cancellationOfDelete();
			log.info("============= Finished tcCancellationOfDelete Test===========");
			getScreenShot("tcCancellationOfDelete");
		} catch (Exception e) {
			getScreenShot("tcCancellationOfDelete");
		}
	}

	@Test(priority = 25)
	public void tcPopUpValidationOnSuccessDeleteCancel() {

		try {
			log.info("============= Strting tcPopUpValidationOnSuccessDeleteCancel Test===========");

			oralTestSchedule.popUpValidationOnSuccess();
			log.info("============= Finished tcPopUpValidationOnSuccessDeleteCancel Test===========");
			getScreenShot("tcPopUpValidationOnSuccessDeleteCancel");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccessDeleteCancel");
		}
	}

	@Test(priority = 26, dataProvider = "SearchByScheduleNameData")
	public void tcDeleteScheduledOralTestForYesDeleteIT(String scheduleName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteScheduledOralTestForYesDeleteIT Test===========");

			oralTestSchedule.deleteScheduledOralTest(scheduleName);
			log.info("============= Finished tcDeleteScheduledOralTestForYesDeleteIT Test===========");
			getScreenShot("tcDeleteScheduledOralTestForYesDeleteIT");
		} catch (Exception e) {
			getScreenShot("tcDeleteScheduledOralTestForYesDeleteIT");

		}
	}

	@Test(priority = 27)
	public void tcYesDeleteItButtonClick() {

		try {
			log.info("============= Strting tcCancellationOfDelete Test===========");

			oralTestSchedule.yesDeleteItButtonClick();
			log.info("============= Finished tcYesDeleteItButtonClick Test===========");
			getScreenShot("tcYesDeleteItButtonClick");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteItButtonClick");
		}
	}

	@Test(priority = 28)
	public void tcPopUpValidationOnSuccessDeleteYes() {

		try {
			log.info("============= Strting tcPopUpValidationOnSuccessDeleteYes Test===========");

			oralTestSchedule.popUpValidationOnSuccess();
			log.info("============= Finished tcPopUpValidationOnSuccessDeleteYes Test===========");
			getScreenShot("tcPopUpValidationOnSuccessDeleteYes");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccessDeleteYes");
		}
	}
	
	@Test(priority = 29, dataProvider = "BGHSOralTestScheduleData")
	public void tcOralTestScheduleInfo_AfterDelete(String scheduleName, String scheduleDate, String remarks,
			String supervisor, String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr,
			String ToSchTimeMin, String minutes, String nosOfStudents, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcOralTestScheduleInfo_AfterDelete Test===========");

			oralTestSchedule.oralTestScheduleInfo(scheduleName, scheduleDate, remarks, supervisor, skill, FromSchTimeHr,
					FromSchTimeMin, ToSchTimeHr, ToSchTimeMin, minutes, nosOfStudents);
			log.info("============= Finished tcOralTestScheduleInfo_AfterDelete Test===========");
			getScreenShot("tcOralTestScheduleInfo_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcOralTestScheduleInfo_AfterDelete");
		}
	}
	
	@Test(priority = 30)
	public void tcClickOnSaveButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnSaveButton_AfterDelete Test===========");

			oralTestSchedule.clickOnSaveButton();
			log.info("============= Finished tcClickOnSaveButton_AfterDelete Test===========");
			getScreenShot("tcClickOnSaveButton_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_AfterDelete");
		}
	}
	
	@Test(priority = 31)
	public void tcPopUpValidationOnSuccess_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnSaveButton_AfterDelete Test===========");

			oralTestSchedule.popUpValidationOnSuccess();
			log.info("============= Finished tcClickOnSaveButton_AfterDelete Test===========");
			getScreenShot("tcClickOnSaveButton_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_AfterDelete");
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
