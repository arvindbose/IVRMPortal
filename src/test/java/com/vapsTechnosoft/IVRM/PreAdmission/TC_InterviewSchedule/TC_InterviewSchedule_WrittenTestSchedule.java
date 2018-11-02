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
import com.vapsTechnosoft.IVRM.preAdmission.InterviewSchedule.InterviewSchedule_WrittenTestSchedule;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class TC_InterviewSchedule_WrittenTestSchedule extends TestBase {

	public static final Logger log = Logger.getLogger(TC_InterviewSchedule_WrittenTestSchedule.class.getName());

	InterviewSchedule_WrittenTestSchedule writtentestschedule;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "WrittenTestFormData_PreAdmission")
	public String[][] getTestData() {
		String[][] testRecordsStuDetails = getData("BGHS_PreAdmissionData.xlsx", "WrittenTestFormData");
		return testRecordsStuDetails;
	}

	@DataProvider(name = "Search_WrittenTestScheduleName")
	public String[][] getTestDataSch() {
		String[][] testRecordsSch = getData("BGHS_PreAdmissionData.xlsx", "search_ScheduleNameData");
		return testRecordsSch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		writtentestschedule = new InterviewSchedule_WrittenTestSchedule(driver);
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

			boolean status = writtentestschedule.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToInterViewSchedule_writtenTestSchedule() {
		try {
			log.info("============= Strting tcNavigateToInterViewSchedule_writtenTestSchedule Test===========");

			writtentestschedule.navigateToInterViewSchedule_writtenTestSchedule();

			log.info("============= Finished tcNavigateToInterViewSchedule_writtenTestSchedule Test===========");
			getScreenShot("tcNavigateToInterViewSchedule_writtenTestSchedule");
		} catch (Exception e) {
			getScreenShot("tcNavigateToInterViewSchedule_writtenTestSchedule");
		}
	}

	@Test(priority = 4)
	public void tcVerifyInterviewSchedule_WrittenTestSchedulePage() {

		try {
			log.info("============= Strting tcVerifyInterviewSchedule_WrittenTestSchedulePage Test===========");

			boolean status = writtentestschedule.verifyInterviewSchedule_WrittenTestSchedulePage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyInterviewSchedule_WrittenTestSchedulePage Test===========");
			getScreenShot("tcVerifyInterviewSchedule_WrittenTestSchedulePage");
		} catch (Exception e) {
			getScreenShot("tcVerifyInterviewSchedule_WrittenTestSchedulePage");
		}
	}

	@Test(priority = 5, dataProvider = "WrittenTestFormData_PreAdmission")
	public void tcFill_WrittenTestSchedule_Form(String scheduleName, String remarks, String supervisor, String skill,
			String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr, String ToSchTimeMin, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_WrittenTestScheduleForm Test===========");

			writtentestschedule.fill_WrittenTestSchedule_Form(scheduleName, remarks, supervisor, skill, FromSchTimeHr, FromSchTimeMin, ToSchTimeHr, ToSchTimeMin);
			log.info("============= Finished tcFill_WrittenTestScheduleForm Test===========");
			getScreenShot("tcFill_WrittenTestScheduleForm");
		} catch (Exception e) {
			getScreenShot("tcFill_WrittenTestScheduleForm");
		}
	}

	@Test(priority = 6)
	public void tcSelectStudentFromStudentList_ToScheduleWrittenTest() {

		try {
			log.info("============= Strting tcSelectStudentFromStudentList_ToScheduleWrittenTest Test===========");

			writtentestschedule.selectStudentFromStudentList_ToScheduleWrittenTest();

			log.info("============= Finished tcSelectStudentFromStudentList_ToScheduleWrittenTest Test===========");
			getScreenShot("tcSelectStudentFromStudentList_ToScheduleWrittenTest");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentFromStudentList_ToScheduleWrittenTest");
		}
	}

	@Test(priority = 7)
	public void tcMinimize_WrittenTestScheduleForm() {

		try {
			log.info("============= Strting tcMinimize_WrittenTestScheduleForm Test===========");

			writtentestschedule.min_Max_WrittenTestScheduleForm();

			log.info("============= Finished tcMinimize_WrittenTestScheduleForm Test===========");
			getScreenShot("tcMinimize_WrittenTestScheduleForm");
		} catch (Exception e) {
			getScreenShot("tcMinimize_WrittenTestScheduleForm");
		}
	}

	@Test(priority = 8)
	public void tcSortWithStudentName_InStudentList() {

		try {
			log.info("============= Strting tcSortWithStudentName_InStudentList Test===========");
			getScreenShot("BeforeSorting_tcSortWithStudentName_InStudentList");
			writtentestschedule.sortWithStudentName_InStudentList();

			log.info("============= Finished tcSortWithStudentName_InStudentList Test===========");
			getScreenShot("tcSortWithStudentName_InStudentList");
		} catch (Exception e) {
			getScreenShot("tcSortWithStudentName_InStudentList");
		}
	}

	@Test(priority = 9)
	public void tcSortWithRegistrationNumber_InStudentList() {

		try {
			log.info("============= Strting tcSortWithRegistrationNumber_InStudentList Test===========");
			getScreenShot("BeforeSorting_tcSortWithRegistrationNumber_InStudentList");
			writtentestschedule.sortWithRegistrationNumber_InStudentList();

			log.info("============= Finished tcSortWithRegistrationNumber_InStudentList Test===========");
			getScreenShot("tcSortWithRegistrationNumber_InStudentList");
		} catch (Exception e) {
			getScreenShot("tcSortWithRegistrationNumber_InStudentList");
		}
	}

	@Test(priority = 10)
	public void tcSortWithClass_InStudentList() {

		try {
			log.info("============= Strting tcSortWithClass_InStudentList Test===========");
			getScreenShot("BeforeSorting_tcSortWithClass_InStudentList");
			writtentestschedule.sortWithClass_InStudentList();

			log.info("============= Finished tcSortWithClass_InStudentList Test===========");
			getScreenShot("tcSortWithClass_InStudentList");
		} catch (Exception e) {
			getScreenShot("tcSortWithClass_InStudentList");
		}
	}

	@Test(priority = 11)
	public void tcSortWithGender_InStudentList() {

		try {
			log.info("============= Strting tcSortWithGender_InStudentList Test===========");
			getScreenShot("BeforeSorting_tcSortWithGender_InStudentList");
			writtentestschedule.sortWithGender_InStudentList();

			log.info("============= Finished tcSortWithGender_InStudentList Test===========");
			getScreenShot("tcSortWithGender_InStudentList");
		} catch (Exception e) {
			getScreenShot("tcSortWithGender_InStudentList");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_StudentList() {

		try {
			log.info("============= Strting tcMinimize_StudentList Test===========");

			writtentestschedule.min_Max_StudentList();

			log.info("============= Finished tcMinimize_StudentList Test===========");
			getScreenShot("tcMinimize_StudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentList");
		}
	}

	@Test(priority = 13)
	public void tcMinimize_SelectedStudentToCart() {

		try {
			log.info("============= Strting tcMinimize_SelectedStudentToCart Test===========");

			writtentestschedule.min_Max_SelectedStudentToCart();

			log.info("============= Finished tcMinimize_SelectedStudentToCart Test===========");
			getScreenShot("tcMinimize_SelectedStudentToCart");
		} catch (Exception e) {
			getScreenShot("tcMinimize_SelectedStudentToCart");
		}
	}

	@Test(priority = 14)
	public void tcSortWithScheduleName_InScheduleList() {

		try {
			log.info("============= Strting tcSortWithScheduleName_InScheduleList Test===========");
			getScreenShot("BeforeSorting_tcSortWithScheduleName_InScheduleList");
			writtentestschedule.sortWithScheduleName_InScheduleList();

			log.info("============= Finished tcSortWithScheduleName_InScheduleList Test===========");
			getScreenShot("tcSortWithScheduleName_InScheduleList");
		} catch (Exception e) {
			getScreenShot("tcSortWithScheduleName_InScheduleList");
		}
	}

	@Test(priority = 15)
	public void tcSortWithScheduleDate_InScheduleList() {

		try {
			log.info("============= Strting tcSortWithScheduleDate_InScheduleList Test===========");
			getScreenShot("BeforeSorting_tcSortWithScheduleDate_InScheduleList");
			writtentestschedule.sortWithScheduleDate_InScheduleList();

			log.info("============= Finished tcSortWithScheduleDate_InScheduleList Test===========");
			getScreenShot("tcSortWithScheduleDate_InScheduleList");
		} catch (Exception e) {
			getScreenShot("tcSortWithScheduleDate_InScheduleList");
		}
	}

	@Test(priority = 16)
	public void tcMinimize_WrittenTestScheduleList_GridView() {

		try {
			log.info("============= Strting tcMinimize_WrittenTestScheduleList_GridView Test===========");

			writtentestschedule.min_Max_WrittenTestScheduleListGrid();

			log.info("============= Finished tcMinimize_WrittenTestScheduleList_GridView Test===========");
			getScreenShot("tcMinimize_WrittenTestScheduleList_GridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_WrittenTestScheduleList_GridView");
		}
	}

	@Test(priority = 17)
	public void tcMaximize_WrittenTestScheduleList_GridView() {

		try {
			log.info("============= Strting tcMaximize_WrittenTestScheduleList_GridView Test===========");

			writtentestschedule.min_Max_WrittenTestScheduleListGrid();

			log.info("============= Finished tcMaximize_WrittenTestScheduleList_GridView Test===========");
			getScreenShot("tcMaximize_WrittenTestScheduleList_GridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_WrittenTestScheduleList_GridView");
		}
	}

	@Test(priority = 18)
	public void tcMaximize_SelectedStudentToCart() {

		try {
			log.info("============= Strting tcMaximize_SelectedStudentToCart Test===========");

			writtentestschedule.min_Max_SelectedStudentToCart();

			log.info("============= Finished tcMaximize_SelectedStudentToCart Test===========");
			getScreenShot("tcMaximize_SelectedStudentToCart");
		} catch (Exception e) {
			getScreenShot("tcMaximize_SelectedStudentToCart");
		}
	}

	@Test(priority = 19)
	public void tcMaximize_StudentList() {

		try {
			log.info("============= Strting tcMaximize_StudentList Test===========");

			writtentestschedule.min_Max_StudentList();

			log.info("============= Finished tcMaximize_StudentList Test===========");
			getScreenShot("tcMaximize_StudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentList");
		}
	}

	@Test(priority = 20)
	public void tcMaximize_WrittenTestScheduleForm() {

		try {
			log.info("============= Strting tcMaximize_WrittenTestScheduleForm Test===========");

			writtentestschedule.min_Max_WrittenTestScheduleForm();

			log.info("============= Finished tcMaximize_WrittenTestScheduleForm Test===========");
			getScreenShot("tcMaximize_WrittenTestScheduleForm");
		} catch (Exception e) {
			getScreenShot("tcMaximize_WrittenTestScheduleForm");
		}
	}

	@Test(priority = 21)
	public void tcClickOnCancelButton_ToClearFilledWrittenTest() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearFilledWrittenTest Test===========");

			writtentestschedule.clickOnCancelButton_ToClearFilledWrittenTest();

			log.info("============= Finished tcClickOnCancelButton_ToClearFilledWrittenTest Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledWrittenTest");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledWrittenTest");
		}
	}

	@Test(priority = 22, dataProvider = "WrittenTestFormData_PreAdmission")
	public void tcFill_WrittenTestScheduleForm_AfterCancel(String scheduleName, String remarks, String supervisor,
			String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr, String ToSchTimeMin,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_WrittenTestScheduleForm_AfterCancel Test===========");

			writtentestschedule.fill_WrittenTestSchedule_Form(scheduleName, remarks, supervisor, skill, FromSchTimeHr, FromSchTimeMin, ToSchTimeHr, ToSchTimeMin);
			log.info("============= Finished tcFill_WrittenTestScheduleForm_AfterCancel Test===========");
			getScreenShot("tcFill_WrittenTestScheduleForm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_WrittenTestScheduleForm_AfterCancel");
		}
	}

	@Test(priority = 23)
	public void tcSelectStudentFromStudentList_ToScheduleWrittenTest_AfterCancel() {

		try {
			log.info(
					"============= Strting tcSelectStudentFromStudentList_ToScheduleWrittenTest_AfterCancel Test===========");

			writtentestschedule.selectStudentFromStudentList_ToScheduleWrittenTest();

			log.info(
					"============= Finished tcSelectStudentFromStudentList_ToScheduleWrittenTest_AfterCancel Test===========");
			getScreenShot("tcSelectStudentFromStudentList_ToScheduleWrittenTest_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentFromStudentList_ToScheduleWrittenTest_AfterCancel");
		}
	}

	@Test(priority = 24)
	public void tcDelete2ndStudentFrom_SelectedStudentToCart() {

		try {
			log.info("============= Strting tcDelete2ndStudentFrom_SelectedStudentToCart Test===========");

			writtentestschedule.delete2ndStudentFrom_SelectedStudentToCart();

			log.info("============= Finished tcDelete2ndStudentFrom_SelectedStudentToCart Test===========");
			getScreenShot("tcDelete2ndStudentFrom_SelectedStudentToCart");
		} catch (Exception e) {
			getScreenShot("tcDelete2ndStudentFrom_SelectedStudentToCart");
		}
	}

	@Test(priority = 25)
	public void tcClickOnSaveButton_ToSubmitWrittenTest() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitWrittenTest Test===========");

			writtentestschedule.clickOnSaveButton_ToSubmitWrittenTest();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitWrittenTest Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitWrittenTest");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitWrittenTest");
		}
	}
	@Test(priority = 26)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			writtentestschedule.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}
	@Test(priority = 27)
	public void tcClickOnSuccessOkBtn_ConfirmWrittenTestSchedule() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ConfirmWrittenTestSchedule Test===========");

			writtentestschedule.clickOnSuccessOkBtn();
			log.info("============= Finished tcClickOnSuccessOkBtn_ConfirmWrittenTestSchedule Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmWrittenTestSchedule");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmWrittenTestSchedule");
		}
	}

	@Test(priority = 28, dataProvider = "Search_WrittenTestScheduleName")
	public void tcSearchWithScheduleName_InwrittenTestScheduleList(String scheduleName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithScheduleName_InwrittenTestScheduleList Test===========");

			writtentestschedule.searchWithScheduleName_InwrittenTestScheduleList(scheduleName);
			log.info("============= Finished tcSearchWithScheduleName_InwrittenTestScheduleList Test===========");
			getScreenShot("tcSearchWithScheduleName_InwrittenTestScheduleList");
		} catch (Exception e) {
			getScreenShot("tcSearchWithScheduleName_InwrittenTestScheduleList");
		}
	}

	@Test(priority = 29)
	public void tcEdit_WrittenTestSchedule() {

		try {
			log.info("============= Strting tcEdit_WrittenTestSchedule Test===========");

			writtentestschedule.edit_WrittenTestSchedule();
			log.info("============= Finished tcEdit_WrittenTestSchedule Test===========");
			getScreenShot("tcEdit_WrittenTestSchedule");
		} catch (Exception e) {
			getScreenShot("tcEdit_WrittenTestSchedule");
		}
	}

	@Test(priority = 30)
	public void tcDeleteStudentFrom_SelectedStudent_Edit() {

		try {
			log.info("============= Strting tcDeleteStudentFrom_SelectedStudent_Edit Test===========");

			writtentestschedule.deleteStudentFrom_SelectedStudent_Edit();
			log.info("============= Finished tcDeleteStudentFrom_SelectedStudent_Edit Test===========");
			getScreenShot("tcDeleteStudentFrom_SelectedStudent_Edit");
		} catch (Exception e) {
			getScreenShot("tcDeleteStudentFrom_SelectedStudent_Edit");
		}
	}

	@Test(priority = 31)
	public void tcConfirmDelete_Cancel_SelectedStudent_Edit() {

		try {
			log.info("============= Strting tcConfirmDelete_Cancel_SelectedStudent_Edit Test===========");

			writtentestschedule.confirmDelete_Cancel();
			log.info("============= Finished tcConfirmDelete_Cancel_SelectedStudent_Edit Test===========");
			getScreenShot("tcConfirmDelete_Cancel_SelectedStudent_Edit");
		} catch (Exception e) {
			getScreenShot("tcConfirmDelete_Cancel_SelectedStudent_Edit");
		}
	}

	@Test(priority = 32)
	public void tcClickOnSuccessOkBtn_ConfirmCancelDelete() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ConfirmCancelDelete Test===========");

			writtentestschedule.clickOnSuccessOkBtn();
			log.info("============= Finished tcClickOnSuccessOkBtn_ConfirmCancelDelete Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmCancelDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmCancelDelete");
		}
	}

	@Test(priority = 33)
	public void tcDeleteStudentFrom_SelectedStudent_Edit_AfterConfirmCancel() {

		try {
			log.info(
					"============= Strting tcDeleteStudentFrom_SelectedStudent_Edit_AfterConfirmCancel Test===========");

			writtentestschedule.deleteStudentFrom_SelectedStudent_Edit();
			log.info(
					"============= Finished tcDeleteStudentFrom_SelectedStudent_Edit_AfterConfirmCancel Test===========");
			getScreenShot("tcDeleteStudentFrom_SelectedStudent_Edit_AfterConfirmCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteStudentFrom_SelectedStudent_Edit_AfterConfirmCancel");
		}
	}

	@Test(priority = 34)
	public void tcConfirmDelete_YesDeleteIt_SelectedStudent_Edit() {

		try {
			log.info("============= Strting tcConfirmDelete_YesDeleteIt_SelectedStudent_Edit Test===========");

			writtentestschedule.confirmDelete_YesDeleteIt();
			log.info("============= Finished tcConfirmDelete_YesDeleteIt_SelectedStudent_Edit Test===========");
			getScreenShot("tcConfirmDelete_YesDeleteIt_SelectedStudent_Edit");
		} catch (Exception e) {
			getScreenShot("tcConfirmDelete_YesDeleteIt_SelectedStudent_Edit");
		}
	}

	@Test(priority = 35)
	public void tcClickOnSuccessOkBtn_ConfirmYesDeleteIt() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ConfirmYesDeleteIt Test===========");

			writtentestschedule.clickOnSuccessOkBtn();
			log.info("============= Finished tcClickOnSuccessOkBtn_ConfirmYesDeleteIt Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmYesDeleteIt");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmYesDeleteIt");
		}
	}

	@Test(priority = 36)
	public void tcDelete_ScheduleWrittenTest_FromScheduleListGrid() {

		try {
			log.info("============= Strting tcDelete_ScheduleWrittenTest_FromScheduleListGrid Test===========");

			writtentestschedule.delete_ScheduleWrittenTest_FromScheduleListGrid();
			log.info("============= Finished tcDelete_ScheduleWrittenTest_FromScheduleListGrid Test===========");
			getScreenShot("tcDelete_ScheduleWrittenTest_FromScheduleListGrid");
		} catch (Exception e) {
			getScreenShot("tcDelete_ScheduleWrittenTest_FromScheduleListGrid");
		}
	}

	@Test(priority = 37)
	public void tcConfirmDelete_Cancel_ScheduleList() {

		try {
			log.info("============= Strting tcConfirmDelete_Cancel_ScheduleList Test===========");

			writtentestschedule.confirmDelete_Cancel();
			log.info("============= Finished tcConfirmDelete_Cancel_ScheduleList Test===========");
			getScreenShot("tcConfirmDelete_Cancel_ScheduleList");
		} catch (Exception e) {
			getScreenShot("tcConfirmDelete_Cancel_ScheduleList");
		}
	}

	@Test(priority = 38)
	public void tcClickOnSuccessOkBtn_ConfirmCancelDelete_ScheduleList() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ConfirmCancelDelete_ScheduleList Test===========");

			writtentestschedule.clickOnSuccessOkBtn();
			log.info("============= Finished tcClickOnSuccessOkBtn_ConfirmCancelDelete_ScheduleList Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmCancelDelete_ScheduleList");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmCancelDelete_ScheduleList");
		}
	}

	@Test(priority = 39)
	public void tcDelete_ScheduleWrittenTest_FromScheduleListGrid_AfterCancel() {

		try {
			log.info(
					"============= Strting tcDelete_ScheduleWrittenTest_FromScheduleListGrid_AfterCancel Test===========");

			writtentestschedule.delete_ScheduleWrittenTest_FromScheduleListGrid();
			log.info(
					"============= Finished tcDelete_ScheduleWrittenTest_FromScheduleListGrid_AfterCancel Test===========");
			getScreenShot("tcDelete_ScheduleWrittenTest_FromScheduleListGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDelete_ScheduleWrittenTest_FromScheduleListGrid_AfterCancel");
		}
	}

	@Test(priority = 40)
	public void tcConfirmDelete_YesDeleteIt_ScheduleList() {

		try {
			log.info("============= Strting tcConfirmDelete_YesDeleteIt_ScheduleList Test===========");

			writtentestschedule.confirmDelete_YesDeleteIt_Grid();
			log.info("============= Finished tcConfirmDelete_YesDeleteIt_ScheduleList Test===========");
			getScreenShot("tcConfirmDelete_YesDeleteIt_ScheduleList");
		} catch (Exception e) {
			getScreenShot("tcConfirmDelete_YesDeleteIt_ScheduleList");
		}
	}

	@Test(priority = 41)
	public void tcClickOnSuccessOkBtn_ConfirmDelete_YesDeleteIt_ScheduleList() {

		try {
			log.info(
					"============= Strting tcClickOnSuccessOkBtn_ConfirmDelete_YesDeleteIt_ScheduleList Test===========");

			writtentestschedule.clickOnSuccessOkBtn();
			log.info(
					"============= Finished tcClickOnSuccessOkBtn_ConfirmDelete_YesDeleteIt_ScheduleList Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmDelete_YesDeleteIt_ScheduleList");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ConfirmDelete_YesDeleteIt_ScheduleList");
		}
	}

	@Test(priority = 42, dataProvider = "WrittenTestFormData_PreAdmission")
	public void tcFill_WrittenTestScheduleForm_AfterDelete(String scheduleName, String remarks, String supervisor,
			String skill, String FromSchTimeHr, String FromSchTimeMin, String ToSchTimeHr, String ToSchTimeMin,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_WrittenTestScheduleForm_AfterDelete Test===========");

			writtentestschedule.fill_WrittenTestSchedule_Form(scheduleName, remarks, supervisor, skill, FromSchTimeHr, FromSchTimeMin, ToSchTimeHr, ToSchTimeMin);
			log.info("============= Finished tcFill_WrittenTestScheduleForm_AfterDelete Test===========");
			getScreenShot("tcFill_WrittenTestScheduleForm_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcFill_WrittenTestScheduleForm_AfterDelete");
		}
	}

	@Test(priority = 43)
	public void tcSelectStudentFromStudentList_ToScheduleWrittenTest_AfterDelete() {

		try {
			log.info(
					"============= Strting tcSelectStudentFromStudentList_ToScheduleWrittenTest_AfterDelete Test===========");

			writtentestschedule.selectStudentFromStudentList_ToScheduleWrittenTest();

			log.info(
					"============= Finished tcSelectStudentFromStudentList_ToScheduleWrittenTest_AfterDelete Test===========");
			getScreenShot("tcSelectStudentFromStudentList_ToScheduleWrittenTest_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentFromStudentList_ToScheduleWrittenTest_AfterDelete");
		}
	}
	@Test(priority = 44)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete Test===========");

			writtentestschedule.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete");
		}
	}
	@Test(priority = 45)
	public void tcClickOnSaveButton_ToSubmitWrittenTest_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitWrittenTest Test===========");

			writtentestschedule.clickOnSaveButton_ToSubmitWrittenTest();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitWrittenTest Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitWrittenTest");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitWrittenTest");
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
