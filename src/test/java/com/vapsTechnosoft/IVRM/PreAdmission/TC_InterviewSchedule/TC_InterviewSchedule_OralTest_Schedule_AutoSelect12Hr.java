/**
 * 
 */
package com.vapsTechnosoft.IVRM.PreAdmission.TC_InterviewSchedule;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.Staging_PreAdmission.PreAdmission_OralTest_Schedule_AutoSelect12Hr_Staging;
import com.vapsTechnosoft.IVRM.preAdmission.InterviewSchedule.InterviewSchedule_OralTest_Schedule_AutoSelect12Hr;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_InterviewSchedule_OralTest_Schedule_AutoSelect12Hr extends TestBase {

	public static final Logger log = Logger
			.getLogger(TC_InterviewSchedule_OralTest_Schedule_AutoSelect12Hr.class.getName());

	InterviewSchedule_OralTest_Schedule_AutoSelect12Hr oralTestSchedule;
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
		oralTestSchedule = new InterviewSchedule_OralTest_Schedule_AutoSelect12Hr(driver);
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
	public void tcNavigateToOralTestSchedule_BGHS() {
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

			oralTestSchedule.oralTestScheduleInfo(scheduleName, scheduleDate, remarks, supervisor, skill,
					FromSchTimeHr, FromSchTimeMin, ToSchTimeHr, ToSchTimeMin, minutes, nosOfStudents);
			log.info("============= Finished tcOralTestScheduleInfo Test===========");
			getScreenShot("tcOralTestScheduleInfo");
		} catch (Exception e) {
			getScreenShot("tcOralTestScheduleInfo");
		}
	}
	
	@Test(priority = 6)
	public void tcValidateSelectedStuFromStuList_withSelectedStuToCart() {

		try {
			log.info("============= Strting tcValidateSelectedStuFromStuList_withSelectedStuToCart Test===========");

			oralTestSchedule.validateSelectedStuFromStuList_withSelectedStuToCart();

			log.info("============= Finished tcValidateSelectedStuFromStuList_withSelectedStuToCart Test===========");
			getScreenShot("tcValidateSelectedStuFromStuList_withSelectedStuToCart");
		} catch (Exception e) {
			getScreenShot("tcValidateSelectedStuFromStuList_withSelectedStuToCart");
		}
	}
	
	@Test(priority = 7)
	public void tcMinimize_OralTestSchedule() {

		try {
			log.info("============= Strting tcMinimize_OralTestSchedule Test===========");

			oralTestSchedule.min_Max_OralTestSchedule();

			log.info("============= Finished tcMinimize_OralTestSchedule Test===========");
			getScreenShot("tcMinimize_OralTestSchedule");
		} catch (Exception e) {
			getScreenShot("tcMinimize_OralTestSchedule");
		}
	}
	@Test(priority = 8)
	public void tcSortWithStudentNameInStudentList() {

		try {
			log.info("============= Strting tcSortWithStudentNameInStudentList Test===========");
			getScreenShot("BeforeSorting_tcSortWithStudentNameInStudentList");
			oralTestSchedule.sortWithStudentNameInStudentList();

			log.info("============= Finished tcSortWithStudentNameInStudentList Test===========");
			getScreenShot("tcSortWithStudentNameInStudentList");
		} catch (Exception e) {
			getScreenShot("tcSortWithStudentNameInStudentList");
		}
	}
	@Test(priority = 9)
	public void tcSortWithRegistrationNumberInStudentList() {

		try {
			log.info("============= Strting tcSortWithRegistrationNumberInStudentList Test===========");
			getScreenShot("BeforeSorting_tcSortWithRegistrationNumberInStudentList");
			oralTestSchedule.sortWithRegistrationNumberInStudentList();

			log.info("============= Finished tcSortWithRegistrationNumberInStudentList Test===========");
			getScreenShot("tcSortWithRegistrationNumberInStudentList");
		} catch (Exception e) {
			getScreenShot("tcSortWithRegistrationNumberInStudentList");
		}
	}
	@Test(priority = 10)
	public void tcSortWithGenderInStudentList() {

		try {
			log.info("============= Strting tcSortWithGenderInStudentList Test===========");
			getScreenShot("BeforeSorting_tcSortWithGenderInStudentList");
			oralTestSchedule.sortWithGenderInStudentList();

			log.info("============= Finished tcSortWithGenderInStudentList Test===========");
			getScreenShot("tcSortWithGenderInStudentList");
		} catch (Exception e) {
			getScreenShot("tcSortWithGenderInStudentList");
		}
	}
	@Test(priority = 11)
	public void tcMinimize_StudentList() {

		try {
			log.info("============= Strting tcMinimize_StudentList Test===========");

			oralTestSchedule.min_Max_StudentList();

			log.info("============= Finished tcMinimize_StudentList Test===========");
			getScreenShot("tcMinimize_StudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentList");
		}
	}
	@Test(priority = 12)
	public void tcMinimize_SelectedStudentToCart() {

		try {
			log.info("============= Strting tcMinimize_SelectedStudentToCart Test===========");

			oralTestSchedule.min_Max_SelectedStudentToCart();

			log.info("============= Finished tcMinimize_SelectedStudentToCart Test===========");
			getScreenShot("tcMinimize_SelectedStudentToCart");
		} catch (Exception e) {
			getScreenShot("tcMinimize_SelectedStudentToCart");
		}
	}
	@Test(priority = 13)
	public void tcSortWithScheduleNameInScheduleList() {

		try {
			log.info("============= Strting tcSortWithScheduleNameInScheduleList Test===========");
			getScreenShot("BeforeSorting_tcSortWithScheduleNameInScheduleList");
			oralTestSchedule.sortWithScheduleNameInScheduleList();

			log.info("============= Finished tcSortWithScheduleNameInScheduleList Test===========");
			getScreenShot("tcSortWithScheduleNameInScheduleList");
		} catch (Exception e) {
			getScreenShot("tcSortWithScheduleNameInScheduleList");
		}
	}
	@Test(priority = 14)
	public void tcSortWithScheduleDateInScheduleList() {

		try {
			log.info("============= Strting tcSortWithScheduleDateInScheduleList Test===========");
			getScreenShot("BeforeSorting_tcSortWithScheduleDateInScheduleList");
			oralTestSchedule.sortWithScheduleDateInScheduleList();

			log.info("============= Finished tcSortWithScheduleDateInScheduleList Test===========");
			getScreenShot("tcSortWithScheduleDateInScheduleList");
		} catch (Exception e) {
			getScreenShot("tcSortWithScheduleDateInScheduleList");
		}
	}
	@Test(priority = 15)
	public void tcMinimize_OralTestScheduleList_GridView() {

		try {
			log.info("============= Strting tcMinimize_OralTestScheduleList_GridView Test===========");

			oralTestSchedule.min_Max_OralTestScheduleList_GridView();

			log.info("============= Finished tcMinimize_OralTestScheduleList_GridView Test===========");
			getScreenShot("tcMinimize_OralTestScheduleList_GridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_OralTestScheduleList_GridView");
		}
	}
	@Test(priority = 16)
	public void tcMaximize_OralTestScheduleList_GridView() {

		try {
			log.info("============= Strting tcMaximize_OralTestScheduleList_GridView Test===========");

			oralTestSchedule.min_Max_OralTestScheduleList_GridView();

			log.info("============= Finished tcMaximize_OralTestScheduleList_GridView Test===========");
			getScreenShot("tcMaximize_OralTestScheduleList_GridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_OralTestScheduleList_GridView");
		}
	}
	@Test(priority = 17)
	public void tcMaximize_SelectedStudentToCart() {

		try {
			log.info("============= Strting tcMaximize_SelectedStudentToCart Test===========");

			oralTestSchedule.min_Max_SelectedStudentToCart();

			log.info("============= Finished tcMaximize_SelectedStudentToCart Test===========");
			getScreenShot("tcMaximize_SelectedStudentToCart");
		} catch (Exception e) {
			getScreenShot("tcMaximize_SelectedStudentToCart");
		}
	}
	@Test(priority = 18)
	public void tcMaximize_StudentList() {

		try {
			log.info("============= Strting tcMaximize_StudentList Test===========");

			oralTestSchedule.min_Max_StudentList();

			log.info("============= Finished tcMaximize_StudentList Test===========");
			getScreenShot("tcMaximize_StudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentList");
		}
	}
	@Test(priority = 19)
	public void tcMaximize_OralTestSchedule() {

		try {
			log.info("============= Strting tcMaximize_OralTestSchedule Test===========");

			oralTestSchedule.min_Max_OralTestSchedule();

			log.info("============= Finished tcMaximize_OralTestSchedule Test===========");
			getScreenShot("tcMaximize_OralTestSchedule");
		} catch (Exception e) {
			getScreenShot("tcMaximize_OralTestSchedule");
		}
	}
	
	@Test(priority = 20)
	public void tcClickOnResetButton_ToClearFilledData() {

		try {
			log.info("============= Strting tcClickOnResetButton_ToClearFilledData Test===========");

			oralTestSchedule.clickOnResetButton_ToClearFilledData();

			log.info("============= Finished tcClickOnResetButton_ToClearFilledData Test===========");
			getScreenShot("tcClickOnResetButton_ToClearFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickOnResetButton_ToClearFilledData");
		}
	}

	@Test(priority = 21, dataProvider = "BGHSOralTestScheduleData")
	public void tcOralTestScheduleInfo_AfterReset(String scheduleName, String scheduleDate, String remarks,
			String supervisor, String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr,
			String ToSchTimeMin, String minutes, String nosOfStudents, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcOralTestScheduleInfo_AfterReset Test===========");

			oralTestSchedule.oralTestScheduleInfo(scheduleName, scheduleDate, remarks, supervisor, skill,
					FromSchTimeHr, FromSchTimeMin, ToSchTimeHr, ToSchTimeMin, minutes, nosOfStudents);
			log.info("============= Finished tcOralTestScheduleInfo_AfterReset Test===========");
			getScreenShot("tcOralTestScheduleInfo_AfterReset");
		} catch (Exception e) {
			getScreenShot("tcOralTestScheduleInfo_AfterReset");
		}
	}
	@Test(priority = 22)
	public void tcValidateSelectedStuFromStuList_withSelectedStuToCart_AfterReset() {

		try {
			log.info("============= Strting tcValidateSelectedStuFromStuList_withSelectedStuToCart_AfterReset Test===========");

			oralTestSchedule.validateSelectedStuFromStuList_withSelectedStuToCart();

			log.info("============= Finished tcValidateSelectedStuFromStuList_withSelectedStuToCart_AfterReset Test===========");
			getScreenShot("tcValidateSelectedStuFromStuList_withSelectedStuToCart_AfterReset");
		} catch (Exception e) {
			getScreenShot("tcValidateSelectedStuFromStuList_withSelectedStuToCart_AfterReset");
		}
	}

	@Test(priority = 23)
	public void tcClickOnSaveButton_ToSubmitOralTestSchedule() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitOralTestSchedule Test===========");

			oralTestSchedule.clickOnSaveButton();
			log.info("============= Finished tcClickOnSaveButton_ToSubmitOralTestSchedule Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitOralTestSchedule");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitOralTestSchedule");
		}
	}

	@Test(priority = 24)
	public void tcClickOnSuccessOkBtn_AutoSelectOralTestSchedule() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_AutoSelectOralTestSchedule Test===========");

			oralTestSchedule.clickOnSuccessOkBtn();
			log.info("============= Finished tcClickOnSuccessOkBtn_AutoSelectOralTestSchedule Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_AutoSelectOralTestSchedule");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_AutoSelectOralTestSchedule");
		}
	}

	@Test(priority = 25)
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

	@Test(priority = 26)
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

	

	@Test(priority = 27, dataProvider = "SearchByScheduleNameData")
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

	@Test(priority = 28, dataProvider = "SearchByScheduleNameData")
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

	@Test(priority = 29, dataProvider = "SearchByScheduleNameData")
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

	@Test(priority = 30)
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

	@Test(priority = 31)
	public void tcClickOnSuccessOkBtn_DeleteCancel() {
		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_DeleteCancel Test===========");

			oralTestSchedule.clickOnSuccessOkBtn();
			log.info("============= Finished tcClickOnSuccessOkBtn_DeleteCancel Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_DeleteCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_DeleteCancel");
		}
	}

	@Test(priority = 32, dataProvider = "SearchByScheduleNameData")
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

	@Test(priority = 33)
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

	@Test(priority = 34)
	public void tcClickOnSuccessOkBtn_DeleteYes() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_DeleteYes Test===========");

			oralTestSchedule.clickOnSuccessOkBtn();
			log.info("============= Finished tcClickOnSuccessOkBtn_DeleteYes Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_DeleteYes");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_DeleteYes");
		}
	}

	@Test(priority = 35, dataProvider = "BGHSOralTestScheduleData")
	public void tcOralTestScheduleInfo_AfterDelete(String scheduleName, String scheduleDate, String remarks,
			String supervisor, String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr,
			String ToSchTimeMin, String minutes, String nosOfStudents, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcOralTestScheduleInfo_AfterDelete Test===========");

			oralTestSchedule.oralTestScheduleInfo(scheduleName, scheduleDate, remarks, supervisor, skill,
					FromSchTimeHr, FromSchTimeMin, ToSchTimeHr, ToSchTimeMin, minutes, nosOfStudents);
			log.info("============= Finished tcOralTestScheduleInfo_AfterDelete Test===========");
			getScreenShot("tcOralTestScheduleInfo_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcOralTestScheduleInfo_AfterDelete");
		}
	}
	@Test(priority = 36)
	public void tcValidateSelectedStuFromStuList_withSelectedStuToCart_AfterDelete() {

		try {
			log.info("============= Strting tcValidateSelectedStuFromStuList_withSelectedStuToCart_AfterDelete Test===========");

			oralTestSchedule.validateSelectedStuFromStuList_withSelectedStuToCart();

			log.info("============= Finished tcValidateSelectedStuFromStuList_withSelectedStuToCart_AfterDelete Test===========");
			getScreenShot("tcValidateSelectedStuFromStuList_withSelectedStuToCart_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcValidateSelectedStuFromStuList_withSelectedStuToCart_AfterDelete");
		}
	}

	@Test(priority = 37)
	public void tcClickOnSaveButton_ToSubmitOralTestSchedule_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitOralTestSchedule_AfterDelete Test===========");

			oralTestSchedule.clickOnSaveButton();
			log.info("============= Finished tcClickOnSaveButton_ToSubmitOralTestSchedule_AfterDelete Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitOralTestSchedule_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitOralTestSchedule_AfterDelete");
		}
	}

	@Test(priority = 38)
	public void tcClickOnSuccessOkBtn_AutoSelectOralTestSchedule_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_AutoSelectOralTestSchedule_AfterDelete Test===========");

			oralTestSchedule.clickOnSuccessOkBtn();
			log.info("============= Finished tcClickOnSuccessOkBtn_AutoSelectOralTestSchedule_AfterDelete Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_AutoSelectOralTestSchedule_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_AutoSelectOralTestSchedule_AfterDelete");
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
