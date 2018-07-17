/**
 * 
 */
package com.vapsTechnosoft.IVRM.TC_BGHS_PreAdmission;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.BGHS_PreAdmission.PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS extends TestBase {

	public static final Logger log = Logger
			.getLogger(TC_PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS.class.getName());

	PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS oralTestSchedule;
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
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);
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
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

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
	public void tcNavigateToOralTestSchedule_BGHS() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcNavigateToOralTestSchedule_BGHS Test===========");

			oralTestSchedule.navigateToOralTestSchedule_BGHS();

			log.info("============= Finished tcNavigateToOralTestSchedule_BGHS Test===========");
			getScreenShot("tcNavigateToOralTestSchedule_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToOralTestSchedule_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyInterviewSchedule_BGHSPage() {

		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

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
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);
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
	public void tcResetMinimizeAndMaximize() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcResetMinimizeAndMaximize Test===========");

			oralTestSchedule.resetMinimizeAndMaximize();

			log.info("============= Finished tcResetMinimizeAndMaximize Test===========");
			getScreenShot("tcResetMinimizeAndMaximize");
		} catch (Exception e) {
			getScreenShot("tcResetMinimizeAndMaximize");
		}
	}
	@Test(priority = 7, dataProvider = "BGHSOralTestScheduleData")
	public void tcOralTestScheduleInfoAfterReset(String scheduleName, String scheduleDate, String remarks, String supervisor,
			String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr, String ToSchTimeMin,
			String minutes, String nosOfStudents, String runMode) {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);
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
	
	@Test(priority = 8)
	public void tcClickOnSaveButton() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			oralTestSchedule.clickOnSaveButton();
			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}
	@Test(priority = 9)
	public void tcPopUpValidationOnSuccess() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcPopUpValidationOnSuccess Test===========");

			oralTestSchedule.popUpValidationOnSuccess();
			log.info("============= Finished tcPopUpValidationOnSuccess Test===========");
			getScreenShot("tcPopUpValidationOnSuccess");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccess");
		}
	}
	
	@Test(priority = 10)
	public void tcValidationOf12HourTimeFormatScheduleList() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcValidationOf12HourTimeFormatScheduleList Test===========");

			oralTestSchedule.validationOf12HourTimeFormatScheduleList();
			log.info("============= Finished tcValidationOf12HourTimeFormatScheduleList Test===========");
			getScreenShot("tcValidationOf12HourTimeFormatScheduleList");
		} catch (Exception e) {
			getScreenShot("tcValidationOf12HourTimeFormatScheduleList");
		}
	}
	
	@Test(priority = 11)
	public void tcValidationOf24HourTimeFormatScheduleList() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcValidationOf24HourTimeFormatScheduleList Test===========");

			oralTestSchedule.validationOf24HourTimeFormatScheduleList();
			log.info("============= Finished tcValidationOf24HourTimeFormatScheduleList Test===========");
			getScreenShot("tcValidationOf24HourTimeFormatScheduleList");
		} catch (Exception e) {
			getScreenShot("tcValidationOf24HourTimeFormatScheduleList");
		}
	}
	
	@Test(priority = 12)
	public void tcSortingUsingColumnHeader() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcSortingUsingColumnHeader Test===========");

			oralTestSchedule.sortingUsingColumnHeader();
			log.info("============= Finished tcSortingUsingColumnHeader Test===========");
			getScreenShot("tcSortingUsingColumnHeader");
		} catch (Exception e) {
			getScreenShot("tcSortingUsingColumnHeader");
		}
	}
	
	
	@Test(priority = 13, dataProvider = "SearchByScheduleNameData")
	public void tcSearchWithScheduleNameInScheduleList(String scheduleName, String runMode) {

		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);
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
	
	@Test(priority = 14, dataProvider = "SearchByScheduleNameData")
	public void tcVerifyscheduleNameInOralTestScheduleListGrid(String scheduleName, String runMode) {

		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);
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
	@Test(priority = 15, dataProvider = "SearchByScheduleNameData")
	public void tcDeleteScheduledOralTest(String scheduleName, String runMode) {

		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);
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
	
	@Test(priority = 16)
	public void tcCancellationOfDelete() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcCancellationOfDelete Test===========");

			oralTestSchedule.cancellationOfDelete();
			log.info("============= Finished tcCancellationOfDelete Test===========");
			getScreenShot("tcCancellationOfDelete");
		} catch (Exception e) {
			getScreenShot("tcCancellationOfDelete");
		}
	}
	
	@Test(priority = 17)
	public void tcPopUpValidationOnSuccessDeleteCancel() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcPopUpValidationOnSuccessDeleteCancel Test===========");

			oralTestSchedule.popUpValidationOnSuccess();
			log.info("============= Finished tcPopUpValidationOnSuccessDeleteCancel Test===========");
			getScreenShot("tcPopUpValidationOnSuccessDeleteCancel");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccessDeleteCancel");
		}
	}
	@Test(priority = 18, dataProvider = "SearchByScheduleNameData")
	public void tcDeleteScheduledOralTestForYesDeleteIT(String scheduleName, String runMode) {

		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);
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
	@Test(priority = 19)
	public void tcYesDeleteItButtonClick() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcCancellationOfDelete Test===========");

			oralTestSchedule.yesDeleteItButtonClick();
			log.info("============= Finished tcYesDeleteItButtonClick Test===========");
			getScreenShot("tcYesDeleteItButtonClick");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteItButtonClick");
		}
	}
	@Test(priority = 20)
	public void tcPopUpValidationOnSuccessDeleteYes() {
		oralTestSchedule = new PreAdmission_OralTest_Schedule_AutoSelect12Hr_BGHS(driver);

		try {
			log.info("============= Strting tcPopUpValidationOnSuccessDeleteYes Test===========");

			oralTestSchedule.popUpValidationOnSuccess();
			log.info("============= Finished tcPopUpValidationOnSuccessDeleteYes Test===========");
			getScreenShot("tcPopUpValidationOnSuccessDeleteYes");
		} catch (Exception e) {
			getScreenShot("tcPopUpValidationOnSuccessDeleteYes");
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
