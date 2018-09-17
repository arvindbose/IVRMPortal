/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.TC_ExamMapping;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vapsTechnosoft.IVRM.Exam.ExamMapping.Exam_Subject_Wizard;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Exam_Subject_Wizard extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Exam_Subject_Wizard.class.getName());

	Exam_Subject_Wizard examsubwizard;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "ExamSubjectWizard_FormData_GardeDisplay")
	public String[][] getTestData_GardeDisplay() {
		String[][] testRecordsExamSubForm_GardeDisplay = getData("ExamMapping.xlsx", "ExamSubjectWizard_GradeDisplay");
		return testRecordsExamSubForm_GardeDisplay;
	}

	@DataProvider(name = "ExamSubjectWizard_FormData_MarksDispaly")
	public String[][] getTestData_MarksDispaly() {
		String[][] testRecordsExamSubForm_MarksDispaly = getData("ExamMapping.xlsx", "ExamSubjectWizard_MarksDisplay");
		return testRecordsExamSubForm_MarksDispaly;
	}

	@DataProvider(name = "ExamSubjectWizard_FormData_SubExamAndSubject")
	public String[][] getTestData() {
		String[][] testRecordsExamSubForm_SubExamAndSubject = getData("ExamMapping.xlsx",
				"ExamSubjectWizard_SubExamSubj");
		return testRecordsExamSubForm_SubExamAndSubject;
	}

	@DataProvider(name = "MarksEntry_ExamSubjectWizardData")
	public String[][] getTestMarks() {
		String[][] testRecordsMarks = getData("ExamMapping.xlsx", "MarksEntry_ExamSubjectWizard");
		return testRecordsMarks;
	}

	@DataProvider(name = "MarksEntry_ExamSubjectWizard_subExam_sub1")
	public String[][] getTestMarkssubExam_sub1() {
		String[][] testRecordsMarkssubExam_sub1 = getData("ExamMapping.xlsx", "SubExamWindow_MarksEntry_Sub1");
		return testRecordsMarkssubExam_sub1;
	}

	@DataProvider(name = "MarksEntry_ExamSubjectWizard_subExam_sub2")
	public String[][] getTestMarkssubExam_sub2() {
		String[][] testRecordsMarkssubExam_sub2 = getData("ExamMapping.xlsx", "SubExamWindow_MarksEntry_Sub2");
		return testRecordsMarkssubExam_sub2;
	}

	@DataProvider(name = "MarksEntry_ExamSubjectWizard_subSubject_sub1")
	public String[][] getTestMarkssubSubject_sub1() {
		String[][] testRecordsMarkssubSubject_sub1 = getData("ExamMapping.xlsx", "SubSubjectWin_MarksEntry_Sub1");
		return testRecordsMarkssubSubject_sub1;
	}

	@DataProvider(name = "FilterRecords_ExamSubjectWizardOutputGrid")
	public String[][] getTestFilterRecords() {
		String[][] testRecordsFilterRecords = getData("ExamMapping.xlsx", "FilterRecords_ExamSubjectWizard");
		return testRecordsFilterRecords;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		examsubwizard = new Exam_Subject_Wizard(driver);
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

			boolean status = examsubwizard.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToExamMapping_ExamSubjectWizard() {

		try {
			log.info("============= Strting tcNavigateToExamMapping_ExamSubjectWizard Test===========");

			examsubwizard.navigateToExamMapping_ExamSubjectWizard();

			log.info("============= Finished tcNavigateToExamMapping_ExamSubjectWizard Test===========");
			getScreenShot("tcNavigateToExamMapping_ExamSubjectWizard");
		} catch (Exception e) {
			getScreenShot("tcNavigateToExamMapping_ExamSubjectWizard");
		}
	}

	@Test(priority = 4)
	public void tcVerifyExamSubjectWizard_Page() {

		try {
			log.info("============= Strting tcVerifyExamSubjectWizard_Page Test===========");

			boolean status = examsubwizard.verifyExamSubjectWizardPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyExamSubjectWizard_Page Test===========");
			getScreenShot("tcVerifyExamSubjectWizard_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyExamSubjectWizard_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_ExamSubjectWizardForm() {

		try {
			log.info("============= Strting tcSubmitBlank_ExamSubjectWizardForm Test===========");

			examsubwizard.submitBlank_ExamSubjectWizardForm();

			log.info("============= Finished tcSubmitBlank_ExamSubjectWizardForm Test===========");
			getScreenShot("tcSubmitBlank_ExamSubjectWizardForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_ExamSubjectWizardForm");
		}
	}

	@Test(priority = 6, dataProvider = "ExamSubjectWizard_FormData_MarksDispaly")
	public void tcFill_ExamSubjectWizard_Form(String academicYear, String grade, String category, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_ExamSubjectWizard_Form Test===========");

			examsubwizard.fill_ExamSubjectWizard_Form(academicYear, grade, category);

			log.info("============= Finished tcFill_ExamSubjectWizard_Form Test===========");
			getScreenShot("tcFill_ExamSubjectWizard_Form");
		} catch (Exception e) {
			getScreenShot("tcFill_ExamSubjectWizard_Form");
		}
	}

	@Test(priority = 7, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1 Test===========");

			examsubwizard.enterSubjectWiseMarks_ForMarksDisplay_Subject1(MaxMarks_Sub1, MinMarks_Sub1,
					MaxEntryMarks_Sub1);

			log.info("============= Finished tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1 Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1");
		}
	}

	@Test(priority = 8, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2 Test===========");

			examsubwizard.enterSubjectWiseMarks_ForMarksDisplay_Subject2(MaxMarks_Sub1, MinMarks_Sub1,
					MaxEntryMarks_Sub1);

			log.info("============= Finished tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2 Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2");
		}
	}

	@Test(priority = 9, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3 Test===========");

			examsubwizard.enterSubjectWiseMarks_ForMarksDisplay_Subject3(MaxMarks_Sub1, MinMarks_Sub1,
					MaxEntryMarks_Sub1);

			log.info("============= Finished tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3 Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3");
		}
	}

	@Test(priority = 10)
	public void tcClickOnCancelButton_ToClearFilledExamSubjectWizardForm() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearFilledExamSubjectWizardForm Test===========");

			examsubwizard.clickOnCancelButton_ToClearFilledExamSubjectWizardForm();

			log.info("============= Finished tcClickOnCancelButton_ToClearFilledExamSubjectWizardForm Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledExamSubjectWizardForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledExamSubjectWizardForm");
		}
	}

	@Test(priority = 11, dataProvider = "ExamSubjectWizard_FormData_MarksDispaly")
	public void tcFill_ExamSubjectWizard_Form_AfterCancel(String academicYear, String grade, String category,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_ExamSubjectWizard_Form_AfterCancel Test===========");

			examsubwizard.fill_ExamSubjectWizard_Form(academicYear, grade, category);

			log.info("============= Finished tcFill_ExamSubjectWizard_Form_AfterCancel Test===========");
			getScreenShot("tcFill_ExamSubjectWizard_Form_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_ExamSubjectWizard_Form_AfterCancel");
		}
	}

	@Test(priority = 12, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1_AfterCancel(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1_AfterCancel Test===========");

			examsubwizard.enterSubjectWiseMarks_ForMarksDisplay_Subject1(MaxMarks_Sub1, MinMarks_Sub1,
					MaxEntryMarks_Sub1);

			log.info(
					"============= Finished tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1_AfterCancel Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1_AfterCancel");
		}
	}

	@Test(priority = 13, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2_AfterCancel(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2_AfterCancel Test===========");

			examsubwizard.enterSubjectWiseMarks_ForMarksDisplay_Subject2(MaxMarks_Sub1, MinMarks_Sub1,
					MaxEntryMarks_Sub1);

			log.info(
					"============= Finished tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2_AfterCancel Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2_AfterCancel");
		}
	}

	@Test(priority = 14, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3_AfterCancel(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3_AfterCancel Test===========");

			examsubwizard.enterSubjectWiseMarks_ForMarksDisplay_Subject3(MaxMarks_Sub1, MinMarks_Sub1,
					MaxEntryMarks_Sub1);

			log.info(
					"============= Finished tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3_AfterCancel Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3_AfterCancel");
		}
	}

/*	@Test(priority = 15)
	public void tcClickOnSetOrder() {

		try {
			log.info("============= Strting tcClickOnSetOrder Test===========");

			examsubwizard.clickOnSetOrder();

			log.info("============= Finished tcClickOnSetOrder Test===========");
			getScreenShot("tcClickOnSetOrder");
		} catch (Exception e) {
			getScreenShot("tcClickOnSetOrder");
		}
	}

	@Test(priority = 16)
	public void tcDragAndDropToSetSubjectOrder() {

		try {
			log.info("============= Strting tcDragAndDropToSetSubjectOrder Test===========");

			examsubwizard.dragAndDropToSetSubjectOrder();

			log.info("============= Finished tcDragAndDropToSetSubjectOrder Test===========");
			getScreenShot("tcDragAndDropToSetSubjectOrder");
		} catch (Exception e) {
			getScreenShot("tcDragAndDropToSetSubjectOrder");
		}
	}

	@Test(priority = 17)
	public void tcClickOnSave_ToSetOrder() {

		try {
			log.info("============= Strting tcClickOnSave_ToSetOrder Test===========");

			examsubwizard.clickOnSave_ToSetOrder();

			log.info("============= Finished tcClickOnSave_ToSetOrder Test===========");
			getScreenShot("tcClickOnSave_ToSetOrder");
		} catch (Exception e) {
			getScreenShot("tcClickOnSave_ToSetOrder");
		}
	}

	@Test(priority = 18)
	public void tcClickOnClose_ToCloseSetOrderwindow() {

		try {
			log.info("============= Strting tcClickOnClose_ToCloseSetOrderwindow Test===========");

			examsubwizard.clickOnClose_ToCloseSetOrderwindow();

			log.info("============= Finished tcClickOnClose_ToCloseSetOrderwindow Test===========");
			getScreenShot("tcClickOnClose_ToCloseSetOrderwindow");
		} catch (Exception e) {
			getScreenShot("tcClickOnClose_ToCloseSetOrderwindow");
		}
	}*/

//	@Test(priority = 19)
//	public void tcClickOnSaveButton_ToSubmitExamSubjectWizardForm() {
//
//		try {
//			log.info("============= Strting tcClickOnSaveButton_ToSubmitExamSubjectWizardForm Test===========");
//
//			examsubwizard.clickOnSaveButton_ToSubmitExamSubjectWizardForm();
//
//			log.info("============= Finished tcClickOnSaveButton_ToSubmitExamSubjectWizardForm Test===========");
//			getScreenShot("tcClickOnSaveButton_ToSubmitExamSubjectWizardForm");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSaveButton_ToSubmitExamSubjectWizardForm");
//		}
//	}

//	@Test(priority = 20)
//	public void tcClickOnSuccessOkBtn_ToSaveMarksDisplay() {
//
//		try {
//			log.info("============= Strting tcClickOnSuccessOkBtn_ToSaveMarksDisplay Test===========");
//
//			examsubwizard.clickOnSuccessOkBtn();
//
//			log.info("============= Finished tcClickOnSuccessOkBtn_ToSaveMarksDisplay Test===========");
//			getScreenShot("tcClickOnSuccessOkBtn_ToSaveMarksDisplay");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSuccessOkBtn_ToSaveMarksDisplay");
//		}
//	}

	//

	@Test(priority = 21, dataProvider = "ExamSubjectWizard_FormData_SubExamAndSubject")
	public void tcFill_ExamSubjectWizard_Form_SubExam_And_SubjectApplicable(String academicYear, String grade,
			String category, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_ExamSubjectWizard_Form_SubExam_And_SubjectApplicable Test===========");

			examsubwizard.fill_ExamSubjectWizard_Form_SubExam_And_SubjectApplicable(academicYear, grade, category);

			log.info(
					"============= Finished tcFill_ExamSubjectWizard_Form_SubExam_And_SubjectApplicable Test===========");
			getScreenShot("tcFill_ExamSubjectWizard_Form_SubExam_And_SubjectApplicable");
		} catch (Exception e) {
			getScreenShot("tcFill_ExamSubjectWizard_Form_SubExam_And_SubjectApplicable");
		}
	}

	@Test(priority = 22, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1_SubExam_And_SubjectApplicable(String MaxMarks_Sub1,
			String MinMarks_Sub1, String MaxEntryMarks_Sub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1_SubExam_And_SubjectApplicable Test===========");

			examsubwizard.enterSubjectWiseMarks_ForMarksDisplay_Subject1(MaxMarks_Sub1, MinMarks_Sub1,
					MaxEntryMarks_Sub1);

			log.info(
					"============= Finished tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1_SubExam_And_SubjectApplicable Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1_SubExam_And_SubjectApplicable");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject1_SubExam_And_SubjectApplicable");
		}
	}

	@Test(priority = 23, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2_SubExam_And_SubjectApplicable(String MaxMarks_Sub1,
			String MinMarks_Sub1, String MaxEntryMarks_Sub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2_SubExam_And_SubjectApplicable Test===========");

			examsubwizard.enterSubjectWiseMarks_ForMarksDisplay_Subject2(MaxMarks_Sub1, MinMarks_Sub1,
					MaxEntryMarks_Sub1);

			log.info(
					"============= Finished tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2_SubExam_And_SubjectApplicable Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2_SubExam_And_SubjectApplicable");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject2_SubExam_And_SubjectApplicable");
		}
	}

	@Test(priority = 24, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3_SubExam_And_SubjectApplicable(String MaxMarks_Sub1,
			String MinMarks_Sub1, String MaxEntryMarks_Sub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3_SubExam_And_SubjectApplicable Test===========");

			examsubwizard.enterSubjectWiseMarks_ForMarksDisplay_Subject3(MaxMarks_Sub1, MinMarks_Sub1,
					MaxEntryMarks_Sub1);

			log.info(
					"============= Finished tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3_SubExam_And_SubjectApplicable Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3_SubExam_And_SubjectApplicable");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForMarksDisplay_Subject3_SubExam_And_SubjectApplicable");
		}
	}

	@Test(priority = 25)
	public void tcLaunchSubExamSubjectMappingwindow_Sub1() {

		try {
			log.info("============= Strting tcLaunchSubExamSubjectMappingwindow_Sub1 Test===========");

			examsubwizard.launchSubExamSubjectMappingwindow_Sub1();

			log.info("============= Finished tcLaunchSubExamSubjectMappingwindow_Sub1 Test===========");
			getScreenShot("tcLaunchSubExamSubjectMappingwindow_Sub1");
		} catch (Exception e) {
			getScreenShot("tcLaunchSubExamSubjectMappingwindow_Sub1");
		}
	}

	@Test(priority = 26, dataProvider = "MarksEntry_ExamSubjectWizard_subExam_sub1")
	public void tcEnterDataForSubExamMapping_Sub1(String maxMarks_subExamSub1, String minMarks_subExamSub1,
			String grade_subExamSub1, String exemptedPercentage_subExamSub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubExamMapping_Sub1 Test===========");

			examsubwizard.enterDataForSubExamMapping_Sub1(maxMarks_subExamSub1, minMarks_subExamSub1, grade_subExamSub1,
					exemptedPercentage_subExamSub1);

			log.info("============= Finished tcEnterDataForSubExamMapping_Sub1 Test===========");
			getScreenShot("tcEnterDataForSubExamMapping_Sub1");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubExamMapping_Sub1");
		}
	}

	@Test(priority = 27, dataProvider = "MarksEntry_ExamSubjectWizard_subExam_sub2")
	public void tcEnterDataForSubExamMapping_Sub2(String maxMarks_subExamSub2, String minMarks_subExamSub2,
			String grade_subExamSub2, String exemptedPercentage_subExamSub2, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubExamMapping_Sub2 Test===========");

			examsubwizard.enterDataForSubExamMapping_Sub2(maxMarks_subExamSub2, minMarks_subExamSub2, grade_subExamSub2,
					exemptedPercentage_subExamSub2);

			log.info("============= Finished tcEnterDataForSubExamMapping_Sub2 Test===========");
			getScreenShot("tcEnterDataForSubExamMapping_Sub2");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubExamMapping_Sub2");
		}
	}

	@Test(priority = 28)
	public void tcClickOnCancel_ToClearFilled_SubExamData() {

		try {
			log.info("============= Strting tcClickOnCancel_ToClearFilled_SubExamData Test===========");

			examsubwizard.clickOnCancel_ToClearFilled_SubExamData();

			log.info("============= Finished tcClickOnCancel_ToClearFilled_SubExamData Test===========");
			getScreenShot("tcClickOnCancel_ToClearFilled_SubExamData");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancel_ToClearFilled_SubExamData");
		}
	}

	@Test(priority = 29)
	public void tcClickOnClose_TocloseWindow_SubExamData() {

		try {
			log.info("============= Strting tcClickOnClose_TocloseWindow_SubExamData Test===========");

			examsubwizard.clickOnClose_TocloseWindow_SubExamData();

			log.info("============= Finished tcClickOnClose_TocloseWindow_SubExamData Test===========");
			getScreenShot("tcClickOnClose_TocloseWindow_SubExamData");
		} catch (Exception e) {
			getScreenShot("tcClickOnClose_TocloseWindow_SubExamData");
		}
	}

	@Test(priority = 30)
	public void tcLaunchSubExamSubjectMappingwindow_Sub1_AfterClearAndClose() {

		try {
			log.info(
					"============= Strting tcLaunchSubExamSubjectMappingwindow_Sub1_AfterClearAndClose Test===========");

			examsubwizard.launchSubExamSubjectMappingwindow_Sub1();

			log.info(
					"============= Finished tcLaunchSubExamSubjectMappingwindow_Sub1_AfterClearAndClose Test===========");
			getScreenShot("tcLaunchSubExamSubjectMappingwindow_Sub1_AfterClearAndClose");
		} catch (Exception e) {
			getScreenShot("tcLaunchSubExamSubjectMappingwindow_Sub1_AfterClearAndClose");
		}
	}

	@Test(priority = 31, dataProvider = "MarksEntry_ExamSubjectWizard_subExam_sub1")
	public void tcEnterDataForSubExamMapping_Sub1_AfterClearAndClose(String maxMarks_subExamSub1,
			String minMarks_subExamSub1, String grade_subExamSub1, String exemptedPercentage_subExamSub1,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubExamMapping_Sub1_AfterClearAndClose Test===========");

			examsubwizard.enterDataForSubExamMapping_Sub1(maxMarks_subExamSub1, minMarks_subExamSub1, grade_subExamSub1,
					exemptedPercentage_subExamSub1);

			log.info("============= Finished tcEnterDataForSubExamMapping_Sub1_AfterClearAndClose Test===========");
			getScreenShot("tcEnterDataForSubExamMapping_Sub1_AfterClearAndClose");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubExamMapping_Sub1_AfterClearAndClose");
		}
	}

	@Test(priority = 32, dataProvider = "MarksEntry_ExamSubjectWizard_subExam_sub2")
	public void tcEnterDataForSubExamMapping_Sub2_AfterClearAndClose(String maxMarks_subExamSub2,
			String minMarks_subExamSub2, String grade_subExamSub2, String exemptedPercentage_subExamSub2,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubExamMapping_Sub2_AfterClearAndClose Test===========");

			examsubwizard.enterDataForSubExamMapping_Sub2(maxMarks_subExamSub2, minMarks_subExamSub2, grade_subExamSub2,
					exemptedPercentage_subExamSub2);

			log.info("============= Finished tcEnterDataForSubExamMapping_Sub2_AfterClearAndClose Test===========");
			getScreenShot("tcEnterDataForSubExamMapping_Sub2_AfterClearAndClose");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubExamMapping_Sub2_AfterClearAndClose");
		}
	}

	@Test(priority = 33)
	public void tcClickOnAddAndClose_ToSubmitSubExamMapping() {

		try {
			log.info("============= Strting tcClickOnAddAndClose_ToSubmitSubExamMapping Test===========");

			examsubwizard.clickOnAddAndClose_ToSubmitSubExamMapping();

			log.info("============= Finished tcClickOnAddAndClose_ToSubmitSubExamMapping Test===========");
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubExamMapping");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubExamMapping");
		}
	}

	@Test(priority = 34)
	public void tcChangeInSelection_SubExamMapped_Sub1() {

		try {
			log.info("============= Strting tcChangeInSelection_SubExamMapped_Sub1 Test===========");

			examsubwizard.changeInSelectionAndDeleteSubExamMapped_Sub1();

			log.info("============= Finished tcChangeInSelection_SubExamMapped_Sub1 Test===========");
			getScreenShot("tcChangeInSelection_SubExamMapped_Sub1");
		} catch (Exception e) {
			getScreenShot("tcChangeInSelection_SubExamMapped_Sub1");
		}
	}

	@Test(priority = 35)
	public void tcClickOnChangeSelection_ToChangeSubExamMappedSubject_Sub1() {

		try {
			log.info(
					"============= Strting tcClickOnChangeSelection_ToChangeSubExamMappedSubject_Sub1 Test===========");

			examsubwizard.clickOnChangeSelection_ToChangeSubExamMappedSubject();

			log.info(
					"============= Finished tcClickOnChangeSelection_ToChangeSubExamMappedSubject_Sub1 Test===========");
			getScreenShot("tcClickOnChangeSelection_ToChangeSubExamMappedSubject_Sub1");
		} catch (Exception e) {
			getScreenShot("tcClickOnChangeSelection_ToChangeSubExamMappedSubject_Sub1");
		}
	}

	@Test(priority = 36)
	public void tcClickOnOkButtonToUpdateChangeSelection_SubExam_Sub1() {

		try {
			log.info("============= Strting tcClickOnOkButtonToUpdateChangeSelection_SubExam_Sub1 Test===========");

			examsubwizard.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkButtonToUpdateChangeSelection_SubExam_Sub1 Test===========");
			getScreenShot("tcClickOnOkButtonToUpdateChangeSelection_SubExam_Sub1");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButtonToUpdateChangeSelection_SubExam_Sub1");
		}
	}

	@Test(priority = 37)
	public void tcClickOnAddAndClose_ToSubmitSubExamMapping_ChangeSelection() {

		try {
			log.info(
					"============= Strting tcClickOnAddAndClose_ToSubmitSubExamMapping_ChangeSelection Test===========");

			examsubwizard.clickOnAddAndClose_ToSubmitSubExamMapping();

			log.info(
					"============= Finished tcClickOnAddAndClose_ToSubmitSubExamMapping_ChangeSelection Test===========");
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubExamMapping_ChangeSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubExamMapping_ChangeSelection");
		}
	}

	@Test(priority = 38)
	public void tcClickOnCheckBox_ToDeleteSubExamMapped_Sub1() {

		try {
			log.info("============= Strting tcClickOnCheckBox_ToDeleteSubExamMapped_Sub1 Test===========");

			examsubwizard.changeInSelectionAndDeleteSubExamMapped_Sub1();

			log.info("============= Finished tcClickOnCheckBox_ToDeleteSubExamMapped_Sub1 Test===========");
			getScreenShot("tcClickOnCheckBox_ToDeleteSubExamMapped_Sub1");
		} catch (Exception e) {
			getScreenShot("tcClickOnCheckBox_ToDeleteSubExamMapped_Sub1");
		}
	}

	@Test(priority = 39)
	public void tcClickOnDeleteSelection_ToDeleteSubExamMappedSubject_Sub1() {

		try {
			log.info(
					"============= Strting tcClickOnDeleteSelection_ToDeleteSubExamMappedSubject_Sub1 Test===========");

			examsubwizard.clickOnDeleteSelection_ToDeleteSubExamMappedSubject();

			log.info(
					"============= Finished tcClickOnDeleteSelection_ToDeleteSubExamMappedSubject_Sub1 Test===========");
			getScreenShot("tcClickOnDeleteSelection_ToDeleteSubExamMappedSubject_Sub1");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeleteSelection_ToDeleteSubExamMappedSubject_Sub1");
		}
	}

	@Test(priority = 40)
	public void tcClickOnOkButtonToDeleteSelection_SubExam_Sub1() {

		try {
			log.info("============= Strting tcClickOnOkButtonToDeleteSelection_SubExam_Sub1 Test===========");

			examsubwizard.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkButtonToDeleteSelection_SubExam_Sub1 Test===========");
			getScreenShot("tcClickOnOkButtonToDeleteSelection_SubExam_Sub1");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButtonToDeleteSelection_SubExam_Sub1");
		}
	}

	@Test(priority = 41)
	public void tcLaunchSubExamSubjectMappingwindow_Sub1_AfterDelete() {

		try {
			log.info("============= Strting tcLaunchSubExamSubjectMappingwindow_Sub1_AfterDelete Test===========");

			examsubwizard.launchSubExamSubjectMappingwindow_Sub1();

			log.info("============= Finished tcLaunchSubExamSubjectMappingwindow_Sub1_AfterDelete Test===========");
			getScreenShot("tcLaunchSubExamSubjectMappingwindow_Sub1_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcLaunchSubExamSubjectMappingwindow_Sub1_AfterDelete");
		}
	}

	@Test(priority = 42, dataProvider = "MarksEntry_ExamSubjectWizard_subExam_sub1")
	public void tcEnterDataForSubExamMapping_Sub1_AfterDelete(String maxMarks_subExamSub1, String minMarks_subExamSub1,
			String grade_subExamSub1, String exemptedPercentage_subExamSub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubExamMapping_Sub1_AfterDelete Test===========");

			examsubwizard.enterDataForSubExamMapping_Sub1(maxMarks_subExamSub1, minMarks_subExamSub1, grade_subExamSub1,
					exemptedPercentage_subExamSub1);

			log.info("============= Finished tcEnterDataForSubExamMapping_Sub1_AfterDelete Test===========");
			getScreenShot("tcEnterDataForSubExamMapping_Sub1_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubExamMapping_Sub1_AfterDelete");
		}
	}

	@Test(priority = 43, dataProvider = "MarksEntry_ExamSubjectWizard_subExam_sub2")
	public void tcEnterDataForSubExamMapping_Sub2_AfterDelete(String maxMarks_subExamSub2, String minMarks_subExamSub2,
			String grade_subExamSub2, String exemptedPercentage_subExamSub2, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubExamMapping_Sub2_AfterDelete Test===========");

			examsubwizard.enterDataForSubExamMapping_Sub2(maxMarks_subExamSub2, minMarks_subExamSub2, grade_subExamSub2,
					exemptedPercentage_subExamSub2);

			log.info("============= Finished tcEnterDataForSubExamMapping_Sub2_AfterDelete Test===========");
			getScreenShot("tcEnterDataForSubExamMapping_Sub2_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubExamMapping_Sub2_AfterDelete");
		}
	}

	@Test(priority = 44)
	public void tcClickOnAddAndClose_ToSubmitSubExamMapping_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnAddAndClose_ToSubmitSubExamMapping_AfterDelete Test===========");

			examsubwizard.clickOnAddAndClose_ToSubmitSubExamMapping();

			log.info("============= Finished tcClickOnAddAndClose_ToSubmitSubExamMapping_AfterDelete Test===========");
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubExamMapping_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubExamMapping_AfterDelete");
		}
	}
	// 2nd Subject sub Exam

	@Test(priority = 45)
	public void tcLaunchSubExamSubjectMappingwindow_Sub2() {

		try {
			log.info("============= Strting tcLaunchSubExamSubjectMappingwindow_Sub2 Test===========");

			examsubwizard.launchSubExamSubjectMappingwindow_Sub2();

			log.info("============= Finished tcLaunchSubExamSubjectMappingwindow_Sub2 Test===========");
			getScreenShot("tcLaunchSubExamSubjectMappingwindow_Sub2");
		} catch (Exception e) {
			getScreenShot("tcLaunchSubExamSubjectMappingwindow_Sub2");
		}
	}

	@Test(priority = 46, dataProvider = "MarksEntry_ExamSubjectWizard_subExam_sub1")
	public void tcEnterDataForSubExamMapping_Sub1_Subject2Main(String maxMarks_subExamSub1, String minMarks_subExamSub1,
			String grade_subExamSub1, String exemptedPercentage_subExamSub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubExamMapping_Sub1_Subject2Main Test===========");

			examsubwizard.enterDataForSubExamMapping_Sub1(maxMarks_subExamSub1, minMarks_subExamSub1, grade_subExamSub1,
					exemptedPercentage_subExamSub1);

			log.info("============= Finished tcEnterDataForSubExamMapping_Sub1_Subject2Main Test===========");
			getScreenShot("tcEnterDataForSubExamMapping_Sub1_Subject2Main");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubExamMapping_Sub1_Subject2Main");
		}
	}

	@Test(priority = 47, dataProvider = "MarksEntry_ExamSubjectWizard_subExam_sub2")
	public void tcEnterDataForSubExamMapping_Sub2_Subject2Main(String maxMarks_subExamSub2, String minMarks_subExamSub2,
			String grade_subExamSub2, String exemptedPercentage_subExamSub2, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubExamMapping_Sub2_Subject2Main Test===========");

			examsubwizard.enterDataForSubExamMapping_Sub2(maxMarks_subExamSub2, minMarks_subExamSub2, grade_subExamSub2,
					exemptedPercentage_subExamSub2);

			log.info("============= Finished tcEnterDataForSubExamMapping_Sub2_Subject2Main Test===========");
			getScreenShot("tcEnterDataForSubExamMapping_Sub2_Subject2Main");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubExamMapping_Sub2_Subject2Main");
		}
	}

	@Test(priority = 48)
	public void tcClickOnAddAndClose_ToSubmitSubExamMapping_Subject2Main() {

		try {
			log.info("============= Strting tcClickOnAddAndClose_ToSubmitSubExamMapping_Subject2Main Test===========");

			examsubwizard.clickOnAddAndClose_ToSubmitSubExamMapping();

			log.info("============= Finished tcClickOnAddAndClose_ToSubmitSubExamMapping_Subject2Main Test===========");
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubExamMapping_Subject2Main");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubExamMapping_Subject2Main");
		}
	}

	// 3rd Subject sub Exam

	@Test(priority = 49)
	public void tcLaunchSubExamSubjectMappingwindow_Sub3() {

		try {
			log.info("============= Strting tcLaunchSubExamSubjectMappingwindow_Sub3 Test===========");

			examsubwizard.launchSubExamSubjectMappingwindow_Sub3();

			log.info("============= Finished tcLaunchSubExamSubjectMappingwindow_Sub3 Test===========");
			getScreenShot("tcLaunchSubExamSubjectMappingwindow_Sub3");
		} catch (Exception e) {
			getScreenShot("tcLaunchSubExamSubjectMappingwindow_Sub3");
		}
	}

	@Test(priority = 50, dataProvider = "MarksEntry_ExamSubjectWizard_subExam_sub1")
	public void tcEnterDataForSubExamMapping_Sub1_Subject3Main(String maxMarks_subExamSub1, String minMarks_subExamSub1,
			String grade_subExamSub1, String exemptedPercentage_subExamSub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubExamMapping_Sub1_Subject3Main Test===========");

			examsubwizard.enterDataForSubExamMapping_Sub1(maxMarks_subExamSub1, minMarks_subExamSub1, grade_subExamSub1,
					exemptedPercentage_subExamSub1);

			log.info("============= Finished tcEnterDataForSubExamMapping_Sub1_Subject3Main Test===========");
			getScreenShot("tcEnterDataForSubExamMapping_Sub1_Subject3Main");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubExamMapping_Sub1_Subject3Main");
		}
	}

	@Test(priority = 51, dataProvider = "MarksEntry_ExamSubjectWizard_subExam_sub2")
	public void tcEnterDataForSubExamMapping_Sub2_Subject3Main(String maxMarks_subExamSub2, String minMarks_subExamSub2,
			String grade_subExamSub2, String exemptedPercentage_subExamSub2, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubExamMapping_Sub2_Subject3Main Test===========");

			examsubwizard.enterDataForSubExamMapping_Sub2(maxMarks_subExamSub2, minMarks_subExamSub2, grade_subExamSub2,
					exemptedPercentage_subExamSub2);

			log.info("============= Finished tcEnterDataForSubExamMapping_Sub2_Subject3Main Test===========");
			getScreenShot("tcEnterDataForSubExamMapping_Sub2_Subject3Main");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubExamMapping_Sub2_Subject3Main");
		}
	}

	@Test(priority = 52)
	public void tcClickOnAddAndClose_ToSubmitSubExamMapping_Subject3Main() {

		try {
			log.info("============= Strting tcClickOnAddAndClose_ToSubmitSubExamMapping_Subject3Main Test===========");

			examsubwizard.clickOnAddAndClose_ToSubmitSubExamMapping();

			log.info("============= Finished tcClickOnAddAndClose_ToSubmitSubExamMapping_Subject3Main Test===========");
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubExamMapping_Subject3Main");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubExamMapping_Subject3Main");
		}
	}

	// Sub Subject

	@Test(priority = 53)
	public void tcLaunchSubSubject_SubjectMappingwindow_Sub1() {

		try {
			log.info("============= Strting tcLaunchSubSubject_SubjectMappingwindow_Sub1 Test===========");

			examsubwizard.launchSubSubject_SubjectMappingwindow_Sub1();

			log.info("============= Finished tcLaunchSubSubject_SubjectMappingwindow_Sub1 Test===========");
			getScreenShot("tcLaunchSubSubject_SubjectMappingwindow_Sub1");
		} catch (Exception e) {
			getScreenShot("tcLaunchSubSubject_SubjectMappingwindow_Sub1");
		}
	}

	@Test(priority = 54, dataProvider = "MarksEntry_ExamSubjectWizard_subSubject_sub1")
	public void tcEnterDataForSubSubjectMapping_Sub1(String maxMarks_subSubjectSub1, String minMarks_subSubjectSub1,
			String grade_subSubjectSub1, String exemptedPercentage_subSubjectSub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubSubjectMapping_Sub1 Test===========");

			examsubwizard.enterDataForSubSubjectMapping_Sub1(maxMarks_subSubjectSub1, minMarks_subSubjectSub1,
					grade_subSubjectSub1, exemptedPercentage_subSubjectSub1);

			log.info("============= Finished tcEnterDataForSubSubjectMapping_Sub1 Test===========");
			getScreenShot("tcEnterDataForSubSubjectMapping_Sub1");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubSubjectMapping_Sub1");
		}
	}

	@Test(priority = 55)
	public void tcClickOnCancel_ToClearFilled_SubSubjectData() {

		try {
			log.info("============= Strting tcClickOnCancel_ToClearFilled_SubSubjectData Test===========");

			examsubwizard.clickOnCancel_ToClearFilled_SubSubjectData();

			log.info("============= Finished tcClickOnCancel_ToClearFilled_SubSubjectData Test===========");
			getScreenShot("tcClickOnCancel_ToClearFilled_SubSubjectData");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancel_ToClearFilled_SubSubjectData");
		}
	}

	@Test(priority = 56)
	public void tcClickOnClose_TocloseWindow_SubSubjectData() {

		try {
			log.info("============= Strting tcClickOnClose_TocloseWindow_SubSubjectData Test===========");

			examsubwizard.clickOnClose_TocloseWindow_SubSubjectData();

			log.info("============= Finished tcClickOnClose_TocloseWindow_SubSubjectData Test===========");
			getScreenShot("tcClickOnClose_TocloseWindow_SubSubjectData");
		} catch (Exception e) {
			getScreenShot("tcClickOnClose_TocloseWindow_SubSubjectData");
		}
	}

	@Test(priority = 57)
	public void tcLaunchSubSubject_SubjectMappingwindow_Sub1_AfterClearAndClose() {

		try {
			log.info(
					"============= Strting tcLaunchSubSubject_SubjectMappingwindow_Sub1_AfterClearAndClose Test===========");

			examsubwizard.launchSubSubject_SubjectMappingwindow_Sub1();

			log.info(
					"============= Finished tcLaunchSubSubject_SubjectMappingwindow_Sub1_AfterClearAndClose Test===========");
			getScreenShot("tcLaunchSubSubject_SubjectMappingwindow_Sub1_AfterClearAndClose");
		} catch (Exception e) {
			getScreenShot("tcLaunchSubSubject_SubjectMappingwindow_Sub1_AfterClearAndClose");
		}
	}

	@Test(priority = 58, dataProvider = "MarksEntry_ExamSubjectWizard_subSubject_sub1")
	public void tcEnterDataForSubSubjectMapping_Sub1_AfterClearAndClose(String maxMarks_subSubjectSub1,
			String minMarks_subSubjectSub1, String grade_subSubjectSub1, String exemptedPercentage_subSubjectSub1,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubSubjectMapping_Sub1_AfterClearAndClose Test===========");

			examsubwizard.enterDataForSubSubjectMapping_Sub1(maxMarks_subSubjectSub1, minMarks_subSubjectSub1,
					grade_subSubjectSub1, exemptedPercentage_subSubjectSub1);

			log.info("============= Finished tcEnterDataForSubSubjectMapping_Sub1_AfterClearAndClose Test===========");
			getScreenShot("tcEnterDataForSubSubjectMapping_Sub1_AfterClearAndClose");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubSubjectMapping_Sub1_AfterClearAndClose");
		}
	}

	@Test(priority = 59)
	public void tcClickOnAddAndClose_ToSubmitSubSubjectMapping() {

		try {
			log.info("============= Strting tcClickOnAddAndClose_ToSubmitSubSubjectMapping Test===========");

			examsubwizard.clickOnAddAndClose_ToSubmitSubSubjectMapping();

			log.info("============= Finished tcClickOnAddAndClose_ToSubmitSubSubjectMapping Test===========");
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubSubjectMapping");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubSubjectMapping");
		}
	}

	@Test(priority = 60)
	public void tcChangeInSelectionAndDeleteSubSubjectMapped_Sub1() {

		try {
			log.info("============= Strting tcChangeInSelectionAndDeleteSubSubjectMapped_Sub1 Test===========");

			examsubwizard.changeInSelectionAndDeleteSubSubjectMapped_Sub1();

			log.info("============= Finished tcChangeInSelectionAndDeleteSubSubjectMapped_Sub1 Test===========");
			getScreenShot("tcChangeInSelectionAndDeleteSubSubjectMapped_Sub1");
		} catch (Exception e) {
			getScreenShot("tcChangeInSelectionAndDeleteSubSubjectMapped_Sub1");
		}
	}

	@Test(priority = 61)
	public void tcClickOnChangeSelection_ToChangeSubSubjectMappedSubject_Sub1() {

		try {
			log.info(
					"============= Strting tcClickOnChangeSelection_ToChangeSubSubjectMappedSubject_Sub1 Test===========");

			examsubwizard.clickOnChangeSelection_ToChangeSubSubjectMappedSubject();

			log.info(
					"============= Finished tcClickOnChangeSelection_ToChangeSubSubjectMappedSubject_Sub1 Test===========");
			getScreenShot("tcClickOnChangeSelection_ToChangeSubSubjectMappedSubject_Sub1");
		} catch (Exception e) {
			getScreenShot("tcClickOnChangeSelection_ToChangeSubSubjectMappedSubject_Sub1");
		}
	}

	@Test(priority = 62)
	public void tcClickOnOkButtonToUpdateChangeSelection_SubSubject_Sub1() {

		try {
			log.info("============= Strting tcClickOnOkButtonToUpdateChangeSelection_SubSubject_Sub1 Test===========");

			examsubwizard.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkButtonToUpdateChangeSelection_SubSubject_Sub1 Test===========");
			getScreenShot("tcClickOnOkButtonToUpdateChangeSelection_SubSubject_Sub1");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButtonToUpdateChangeSelection_SubSubject_Sub1");
		}
	}

	@Test(priority = 63)
	public void tcClickOnAddAndClose_ToSubmitSubSubjectMapping_ChangeSelection() {

		try {
			log.info(
					"============= Strting tcClickOnAddAndClose_ToSubmitSubSubjectMapping_ChangeSelection Test===========");

			examsubwizard.clickOnAddAndClose_ToSubmitSubSubjectMapping();

			log.info(
					"============= Finished tcClickOnAddAndClose_ToSubmitSubSubjectMapping_ChangeSelection Test===========");
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubSubjectMapping_ChangeSelection");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubSubjectMapping_ChangeSelection");
		}
	}

	@Test(priority = 64)
	public void tcClickOnCheckBox_ToDeleteSubSubjectMapped_Sub1() {

		try {
			log.info("============= Strting tcClickOnCheckBox_ToDeleteSubSubjectMapped_Sub1 Test===========");

			examsubwizard.changeInSelectionAndDeleteSubSubjectMapped_Sub1();

			log.info("============= Finished tcClickOnCheckBox_ToDeleteSubSubjectMapped_Sub1 Test===========");
			getScreenShot("tcClickOnCheckBox_ToDeleteSubSubjectMapped_Sub1");
		} catch (Exception e) {
			getScreenShot("tcClickOnCheckBox_ToDeleteSubSubjectMapped_Sub1");
		}
	}

	@Test(priority = 65)
	public void tcClickOnDeleteSelection_ToDeleteSubSubjectMappedSubject_Sub1() {

		try {
			log.info(
					"============= Strting tcClickOnDeleteSelection_ToDeleteSubSubjectMappedSubject_Sub1 Test===========");

			examsubwizard.clickOnDeleteSelection_ToDeleteSubSubjectMappedSubject();

			log.info(
					"============= Finished tcClickOnDeleteSelection_ToDeleteSubSubjectMappedSubject_Sub1 Test===========");
			getScreenShot("tcClickOnDeleteSelection_ToDeleteSubSubjectMappedSubject_Sub1");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeleteSelection_ToDeleteSubSubjectMappedSubject_Sub1");
		}
	}

	@Test(priority = 66)
	public void tcClickOnOkButtonToDeleteSelection_SubSubject_Sub1() {

		try {
			log.info("============= Strting tcClickOnOkButtonToDeleteSelection_SubSubject_Sub1 Test===========");

			examsubwizard.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkButtonToDeleteSelection_SubSubject_Sub1 Test===========");
			getScreenShot("tcClickOnOkButtonToDeleteSelection_SubSubject_Sub1");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButtonToDeleteSelection_SubSubject_Sub1");
		}
	}

	@Test(priority = 67)
	public void tcLaunchSubSubject_SubjectMappingwindow_Sub1_AfterDelete() {

		try {
			log.info("============= Strting tcLaunchSubSubject_SubjectMappingwindow_Sub1_AfterDelete Test===========");

			examsubwizard.launchSubSubject_SubjectMappingwindow_Sub1();

			log.info("============= Finished tcLaunchSubSubject_SubjectMappingwindow_Sub1_AfterDelete Test===========");
			getScreenShot("tcLaunchSubSubject_SubjectMappingwindow_Sub1_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcLaunchSubSubject_SubjectMappingwindow_Sub1_AfterDelete");
		}
	}

	@Test(priority = 68, dataProvider = "MarksEntry_ExamSubjectWizard_subSubject_sub1")
	public void tcEnterDataForSubSubjectMapping_Sub1_AfterDelete(String maxMarks_subSubjectSub1,
			String minMarks_subSubjectSub1, String grade_subSubjectSub1, String exemptedPercentage_subSubjectSub1,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubSubjectMapping_Sub1_AfterDelete Test===========");

			examsubwizard.enterDataForSubSubjectMapping_Sub1(maxMarks_subSubjectSub1, minMarks_subSubjectSub1,
					grade_subSubjectSub1, exemptedPercentage_subSubjectSub1);

			log.info("============= Finished tcEnterDataForSubSubjectMapping_Sub1_AfterDelete Test===========");
			getScreenShot("tcEnterDataForSubSubjectMapping_Sub1_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubSubjectMapping_Sub1_AfterDelete");
		}
	}

	@Test(priority = 69)
	public void tcClickOnAddAndClose_ToSubmitSubSubjectMapping_AfterDelete() {

		try {
			log.info(
					"============= Strting tcClickOnAddAndClose_ToSubmitSubSubjectMapping_AfterDelete Test===========");

			examsubwizard.clickOnAddAndClose_ToSubmitSubSubjectMapping();

			log.info(
					"============= Finished tcClickOnAddAndClose_ToSubmitSubSubjectMapping_AfterDelete Test===========");
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubSubjectMapping_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubSubjectMapping_AfterDelete");
		}
	}
	// 2nd Subject sub Exam

	@Test(priority = 70)
	public void tcLaunchSubSubject_SubjectMappingwindow_Sub2() {

		try {
			log.info("============= Strting tcLaunchSubSubject_SubjectMappingwindow_Sub2 Test===========");

			examsubwizard.launchSubSubject_SubjectMappingwindow_Sub2();

			log.info("============= Finished tcLaunchSubSubject_SubjectMappingwindow_Sub2 Test===========");
			getScreenShot("tcLaunchSubSubject_SubjectMappingwindow_Sub2");
		} catch (Exception e) {
			getScreenShot("tcLaunchSubSubject_SubjectMappingwindow_Sub2");
		}
	}

	@Test(priority = 71, dataProvider = "MarksEntry_ExamSubjectWizard_subSubject_sub1")
	public void tcEnterDataForSubSubjectMapping_Sub1_Subject2Main(String maxMarks_subSubjectSub1,
			String minMarks_subSubjectSub1, String grade_subSubjectSub1, String exemptedPercentage_subSubjectSub1,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubSubjectMapping_Sub1_Subject2Main Test===========");

			examsubwizard.enterDataForSubSubjectMapping_Sub1(maxMarks_subSubjectSub1, minMarks_subSubjectSub1,
					grade_subSubjectSub1, exemptedPercentage_subSubjectSub1);

			log.info("============= Finished tcEnterDataForSubSubjectMapping_Sub1_Subject2Main Test===========");
			getScreenShot("tcEnterDataForSubSubjectMapping_Sub1_Subject2Main");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubSubjectMapping_Sub1_Subject2Main");
		}
	}

	@Test(priority = 72)
	public void tcClickOnAddAndClose_ToSubmitSubSubjectMapping_Subject2Main() {

		try {
			log.info(
					"============= Strting tcClickOnAddAndClose_ToSubmitSubSubjectMapping_Subject2Main Test===========");

			examsubwizard.clickOnAddAndClose_ToSubmitSubSubjectMapping();

			log.info(
					"============= Finished tcClickOnAddAndClose_ToSubmitSubSubjectMapping_Subject2Main Test===========");
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubSubjectMapping_Subject2Main");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubSubjectMapping_Subject2Main");
		}
	}

	// 3rd Subject sub Exam

	@Test(priority = 73)
	public void tcLaunchSubSubject_SubjectMappingwindow_Sub3() {

		try {
			log.info("============= Strting tcLaunchSubSubject_SubjectMappingwindow_Sub3 Test===========");

			examsubwizard.launchSubSubject_SubjectMappingwindow_Sub3();

			log.info("============= Finished tcLaunchSubSubject_SubjectMappingwindow_Sub3 Test===========");
			getScreenShot("tcLaunchSubSubject_SubjectMappingwindow_Sub3");
		} catch (Exception e) {
			getScreenShot("tcLaunchSubSubject_SubjectMappingwindow_Sub3");
		}
	}

	@Test(priority = 74, dataProvider = "MarksEntry_ExamSubjectWizard_subSubject_sub1")
	public void tcEnterDataForSubSubjectMapping_Sub1_Subject3Main(String maxMarks_subSubjectSub1,
			String minMarks_subSubjectSub1, String grade_subSubjectSub1, String exemptedPercentage_subSubjectSub1,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterDataForSubSubjectMapping_Sub1_Subject3Main Test===========");

			examsubwizard.enterDataForSubSubjectMapping_Sub1(maxMarks_subSubjectSub1, minMarks_subSubjectSub1,
					grade_subSubjectSub1, exemptedPercentage_subSubjectSub1);

			log.info("============= Finished tcEnterDataForSubSubjectMapping_Sub1_Subject3Main Test===========");
			getScreenShot("tcEnterDataForSubSubjectMapping_Sub1_Subject3Main");
		} catch (Exception e) {
			getScreenShot("tcEnterDataForSubSubjectMapping_Sub1_Subject3Main");
		}
	}

	@Test(priority = 75)
	public void tcClickOnAddAndClose_ToSubmitSubSubjectMapping_Subject3Main() {

		try {
			log.info(
					"============= Strting tcClickOnAddAndClose_ToSubmitSubSubjectMapping_Subject3Main Test===========");

			examsubwizard.clickOnAddAndClose_ToSubmitSubSubjectMapping();

			log.info(
					"============= Finished tcClickOnAddAndClose_ToSubmitSubSubjectMapping_Subject3Main Test===========");
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubSubjectMapping_Subject3Main");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddAndClose_ToSubmitSubSubjectMapping_Subject3Main");
		}
	}

//	@Test(priority = 76)
//	public void tcClickOnSaveButton_ToSubmitExamSubjectWizardForm_SubExamSubSubjectMapping() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSaveButton_ToSubmitExamSubjectWizardForm_SubExamSubSubjectMapping Test===========");
//
//			examsubwizard.clickOnSaveButton_ToSubmitExamSubjectWizardForm();
//
//			log.info(
//					"============= Finished tcClickOnSaveButton_ToSubmitExamSubjectWizardForm_SubExamSubSubjectMapping Test===========");
//			getScreenShot("tcClickOnSaveButton_ToSubmitExamSubjectWizardForm_SubExamSubSubjectMapping");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSaveButton_ToSubmitExamSubjectWizardForm_SubExamSubSubjectMapping");
//		}
//	}
//
//	@Test(priority = 77)
//	public void tcClickOnSuccessOkBtn_ToSaveSubExamAndSubject() {
//
//		try {
//			log.info("============= Strting tcClickOnSuccessOkBtn_ToSaveSubExamAndSubject Test===========");
//
//			examsubwizard.clickOnSuccessOkBtn();
//
//			log.info("============= Finished tcClickOnSuccessOkBtn_ToSaveSubExamAndSubject Test===========");
//			getScreenShot("tcClickOnSuccessOkBtn_ToSaveSubExamAndSubject");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSuccessOkBtn_ToSaveSubExamAndSubject");
//		}
//	}

	// Grade display selection

	@Test(priority = 78, dataProvider = "ExamSubjectWizard_FormData_GardeDisplay")
	public void tcFill_ExamSubjectWizard_Form_GradeDisplay(String academicYear, String grade, String category,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_ExamSubjectWizard_Form_GradeDisplay Test===========");

			examsubwizard.fill_ExamSubjectWizard_Form(academicYear, grade, category);

			log.info("============= Finished tcFill_ExamSubjectWizard_Form_GradeDisplay Test===========");
			getScreenShot("tcFill_ExamSubjectWizard_Form_GradeDisplay");
		} catch (Exception e) {
			getScreenShot("tcFill_ExamSubjectWizard_Form_GradeDisplay");
		}
	}

	@Test(priority = 79, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForGradeDisplay_Subject1(String MaxMarks_Sub1, String MinMarks_Sub1,
			String MaxEntryMarks_Sub1, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterSubjectWiseMarks_ForGradeDisplay_Subject1 Test===========");

			examsubwizard.enterSubjectWiseMarks_ForGradeDisplay_Subject1(MaxMarks_Sub1, MinMarks_Sub1,
					MaxEntryMarks_Sub1);

			log.info("============= Finished tcEnterSubjectWiseMarks_ForGradeDisplay_Subject1 Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForGradeDisplay_Subject1");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForGradeDisplay_Subject1");
		}
	}

	@Test(priority = 80, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForGradeDisplay_Subject2(String MaxMarks_Sub2, String MinMarks_Sub2,
			String MaxEntryMarks_Sub2, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterSubjectWiseMarks_ForGradeDisplay_Subject2 Test===========");

			examsubwizard.enterSubjectWiseMarks_ForGradeDisplay_Subject2(MaxMarks_Sub2, MinMarks_Sub2,
					MaxEntryMarks_Sub2);

			log.info("============= Finished tcEnterSubjectWiseMarks_ForGradeDisplay_Subject2 Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForGradeDisplay_Subject2");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForGradeDisplay_Subject2");
		}
	}

	@Test(priority = 81, dataProvider = "MarksEntry_ExamSubjectWizardData")
	public void tcEnterSubjectWiseMarks_ForGradeDisplay_Subject3(String MaxMarks_Sub3, String MinMarks_Sub3,
			String MaxEntryMarks_Sub3, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterSubjectWiseMarks_ForGradeDisplay_Subject3 Test===========");

			examsubwizard.enterSubjectWiseMarks_ForGradeDisplay_Subject3(MaxMarks_Sub3, MinMarks_Sub3,
					MaxEntryMarks_Sub3);

			log.info("============= Finished tcEnterSubjectWiseMarks_ForGradeDisplay_Subject3 Test===========");
			getScreenShot("tcEnterSubjectWiseMarks_ForGradeDisplay_Subject3");
		} catch (Exception e) {
			getScreenShot("tcEnterSubjectWiseMarks_ForGradeDisplay_Subject3");
		}
	}

//	@Test(priority = 82)
//	public void tcClickOnSaveButton_ToSubmitExamSubjectWizardForm_GradeDisplay() {
//
//		try {
//			log.info(
//					"============= Strting tcClickOnSaveButton_ToSubmitExamSubjectWizardForm_GradeDisplay	 Test===========");
//
//			examsubwizard.clickOnSaveButton_ToSubmitExamSubjectWizardForm();
//
//			log.info(
//					"============= Finished tcClickOnSaveButton_ToSubmitExamSubjectWizardForm_GradeDisplay Test===========");
//			getScreenShot("tcClickOnSaveButton_ToSubmitExamSubjectWizardForm_GradeDisplay");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSaveButton_ToSubmitExamSubjectWizardForm_GradeDisplay");
//		}
//	}
//
//	@Test(priority = 83)
//	public void tcClickOnSuccessOkBtn_ToSaveGradeDisplay() {
//
//		try {
//			log.info("============= Strting tcClickOnSuccessOkBtn_ToSaveGradeDisplay Test===========");
//
//			examsubwizard.clickOnSuccessOkBtn();
//
//			log.info("============= Finished tcClickOnSuccessOkBtn_ToSaveGradeDisplay Test===========");
//			getScreenShot("tcClickOnSuccessOkBtn_ToSaveGradeDisplay");
//		} catch (Exception e) {
//			getScreenShot("tcClickOnSuccessOkBtn_ToSaveGradeDisplay");
//		}
//	}

	@Test(priority = 84)
	public void tcMinimize_ExamSubjectWizard_Form() {

		try {
			log.info("============= Strting tcMinimize_ExamSubjectWizard_Form Test===========");

			examsubwizard.min_Max_ExamSubjectWizard();

			log.info("============= Finished tcMinimize_ExamSubjectWizard_Form Test===========");
			getScreenShot("tcMinimize_ExamSubjectWizard_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_ExamSubjectWizard_Form");
		}
	}

	@Test(priority = 85)
	public void tcMinimize_ExamSubjectWizard_GridView() {

		try {
			log.info("============= Strting tcMinimize_ExamSubjectWizard_GridView Test===========");

			examsubwizard.min_Max_ExamSubjectWizard_GridView();
			log.info("============= Finished tcMinimize_ExamSubjectWizard_GridView Test===========");
			getScreenShot("tcMinimize_ExamSubjectWizard_GridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_ExamSubjectWizard_GridView");
		}
	}

	@Test(priority = 86)
	public void tcMaximize_ExamSubjectWizard_GridView() {

		try {
			log.info("============= Strting tcMaximize_ExamSubjectWizard_GridView Test===========");

			examsubwizard.min_Max_ExamSubjectWizard_GridView();

			log.info("============= Finished tcMaximize_ExamSubjectWizard_GridView Test===========");
			getScreenShot("tcMaximize_ExamSubjectWizard_GridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_ExamSubjectWizard_GridView");
		}
	}

	@Test(priority = 87)
	public void tcSortWithAcademicYearInGridView() {

		try {
			log.info("============= Strting tcSortWithAcademicYearInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithAcademicYearInGridView");
			examsubwizard.sortWithAcademicYearInGridView();

			log.info("============= Finished tcSortWithAcademicYearInGridView Test===========");
			getScreenShot("tcSortWithAcademicYearInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithAcademicYearInGridView");
		}
	}

	@Test(priority = 88)
	public void tcSortWithCategoryNameInGridView() {

		try {
			log.info("============= Strting tcSortWithCategoryNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithCategoryNameInGridView");
			examsubwizard.sortWithCategoryNameInGridView();

			log.info("============= Finished tcSortWithCategoryNameInGridView Test===========");
			getScreenShot("tcSortWithCategoryNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithCategoryNameInGridView");
		}
	}

	@Test(priority = 89)
	public void tcSortWithExamNameInGridView() {

		try {
			log.info("============= Strting tcSortWithExamNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithExamNameInGridView");
			examsubwizard.sortWithExamNameInGridView();

			log.info("============= Finished tcSortWithExamNameInGridView Test===========");
			getScreenShot("tcSortWithExamNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithExamNameInGridView");
		}
	}

	@Test(priority = 90)
	public void tcSortWithGradeNameInGridView() {

		try {
			log.info("============= Strting tcSortWithGradeNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithGradeNameInGridView");
			examsubwizard.sortWithGradeNameInGridView();

			log.info("============= Finished tcSortWithGradeNameInGridView Test===========");
			getScreenShot("tcSortWithGradeNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithGradeNameInGridView");
		}
	}

	@Test(priority = 91, dataProvider = "FilterRecords_ExamSubjectWizardOutputGrid")
	public void tcFilterRecordsBasedOn_AcademicYear(String academicYear, String categoryName, String gradeName,
			String examName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_AcademicYear Test===========");

			examsubwizard.filterRecordsBasedOn_AcademicYear(academicYear, categoryName, gradeName, examName);

			log.info("============= Finished tcFilterRecordsBasedOn_AcademicYear Test===========");
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear");
		}
	}

	@Test(priority = 92)
	public void tcClearFilledDataForFilter_AcademicYear() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_AcademicYear Test===========");

			examsubwizard.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_AcademicYear Test===========");
			getScreenShot("tcClearFilledDataForFilter_AcademicYear");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_AcademicYear");
		}
	}

	@Test(priority = 93, dataProvider = "FilterRecords_ExamSubjectWizardOutputGrid")
	public void tcFilterRecordsBasedOn_CategoryName(String academicYear, String categoryName, String gradeName,
			String examName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_CategoryName Test===========");

			examsubwizard.filterRecordsBasedOn_CategoryName(academicYear, categoryName, gradeName, examName);

			log.info("============= Finished tcFilterRecordsBasedOn_CategoryName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_CategoryName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_CategoryName");
		}
	}

	@Test(priority = 94)
	public void tcClearFilledDataForFilter_CategoryName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_CategoryName Test===========");

			examsubwizard.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_CategoryName Test===========");
			getScreenShot("tcClearFilledDataForFilter_CategoryName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_CategoryName");
		}
	}

	@Test(priority = 95, dataProvider = "FilterRecords_ExamSubjectWizardOutputGrid")
	public void tcFilterRecordsBasedOn_ExamName(String academicYear, String categoryName, String gradeName,
			String examName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_ExamName Test===========");

			examsubwizard.filterRecordsBasedOn_ExamName(academicYear, categoryName, gradeName, examName);

			log.info("============= Finished tcFilterRecordsBasedOn_ExamName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_ExamName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_ExamName");
		}
	}

	@Test(priority = 96)
	public void tcClearFilledDataForFilter_ExamName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_ExamName Test===========");

			examsubwizard.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_ExamName Test===========");
			getScreenShot("tcClearFilledDataForFilter_ExamName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_ExamName");
		}
	}

	@Test(priority = 97, dataProvider = "FilterRecords_ExamSubjectWizardOutputGrid")
	public void tcFilterRecordsBasedOn_GradeName(String academicYear, String categoryName, String gradeName,
			String examName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_GradeName Test===========");

			examsubwizard.filterRecordsBasedOn_GradeName(academicYear, categoryName, gradeName, examName);

			log.info("============= Finished tcFilterRecordsBasedOn_GradeName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GradeName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GradeName");
		}
	}

	@Test(priority = 98)
	public void tcClearFilledDataForFilter_GradeName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_GradeName Test===========");

			examsubwizard.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_GradeName Test===========");
			getScreenShot("tcClearFilledDataForFilter_GradeName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_GradeName");
		}
	}
	//

	/**
	 * View, Edit and activate/deactivate
	 * 
	 */
	@Test(priority = 99)
	public void tcClickOnViewIcon_ToSeeExamAndSubjectMapped() {

		try {
			log.info("============= Strting tcClickOnViewIcon_ToSeeExamAndSubjectMapped Test===========");

			examsubwizard.clickOnViewIcon_ToSeeExamAndSubjectMapped();
			log.info("============= Finished tcClickOnViewIcon_ToSeeExamAndSubjectMapped Test===========");
			getScreenShot("tcClickOnViewIcon_ToSeeExamAndSubjectMapped");
		} catch (Exception e) {
			getScreenShot("tcClickOnViewIcon_ToSeeExamAndSubjectMapped");
		}
	}

	@Test(priority = 100)
	public void tcCloseViewPopUpWindows() {

		try {
			log.info("============= Strting tcCloseViewPopUpWindows Test===========");

			examsubwizard.closeViewPopUpWindows();
			log.info("============= Finished tcCloseViewPopUpWindows Test===========");
			getScreenShot("tcCloseViewPopUpWindows");
		} catch (Exception e) {
			getScreenShot("tcCloseViewPopUpWindows");
		}
	}

	@Test(priority = 101)
	public void tcClickOnDeActivationIcon_ToDeactivateExamSubjectWizard() {

		try {
			log.info("============= Strting tcClickOnDeActivationIcon_ToDeactivateExamSubjectWizard Test===========");

			examsubwizard.clickOnDeActivationIcon_ToDeactivateExamSubjectWizard();

			log.info("============= Finished tcClickOnDeActivationIcon_ToDeactivateExamSubjectWizard Test===========");
			getScreenShot("tcClickOnDeActivationIcon_ToDeactivateExamSubjectWizard");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeActivationIcon_ToDeactivateExamSubjectWizard");
		}
	}

	@Test(priority = 102)
	public void tcCancel_DeactivatePopUp() {

		try {
			log.info("============= Strting tcCancel_DeactivatePopUp Test===========");

			examsubwizard.cancel_DeactivateOrActivatePopUp();

			log.info("============= Finished tcCancel_DeactivatePopUp Test===========");
			getScreenShot("tcCancel_DeactivatePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_DeactivatePopUp");
		}
	}

	@Test(priority = 103)
	public void tcClickOnSuccessOkBtn_CancelDeactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelDeactivate Test===========");

			examsubwizard.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelDeactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		}
	}

	@Test(priority = 104, dataProvider = "FilterRecords_ExamSubjectWizardOutputGrid")
	public void tcFilterRecordsBasedOn_GradeName_ToDeactivateRecords_AfterCancel(String academicYear,
			String categoryName, String gradeName, String examName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFilterRecordsBasedOn_GradeName_ToDeactivateRecords_AfterCancel Test===========");

			examsubwizard.filterRecordsBasedOn_CategoryName(academicYear, categoryName, gradeName, examName);

			log.info(
					"============= Finished tcFilterRecordsBasedOn_GradeName_ToDeactivateRecords_AfterCancel Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ToDeactivateRecords_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ToDeactivateRecords_AfterCancel");
		}
	}

	@Test(priority = 105)
	public void tcClickOnDeActivationIcon_ToDeactivateExamSubjectWizard_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnDeActivationIcon_ToDeactivateExamSubjectWizard_AfterCancel Test===========");

			examsubwizard.clickOnDeActivationIcon_ToDeactivateExamSubjectWizard();

			log.info(
					"============= Finished tcClickOnDeActivationIcon_ToDeactivateExamSubjectWizard_AfterCancel Test===========");
			getScreenShot("tcClickOnDeActivationIcon_ToDeactivateExamSubjectWizard_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeActivationIcon_ToDeactivateExamSubjectWizard_AfterCancel");
		}
	}

	@Test(priority = 106)
	public void tcConfirmationForDeactivate() {

		try {
			log.info("============= Strting tcConfirmationForDeactivate Test===========");

			examsubwizard.confirmationForDeactivateAndActivate();

			log.info("============= Finished tcConfirmationForDeactivate Test===========");
			getScreenShot("tcConfirmationForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForDeactivate");
		}
	}

	@Test(priority = 107)
	public void tcClickOnSuccessOkBtn_Deactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Deactivate Test===========");

			examsubwizard.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Deactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		}
	}

	@Test(priority = 108, dataProvider = "FilterRecords_ExamSubjectWizardOutputGrid")
	public void tcFilterRecordsBasedOn_GradeName_ToActivateRecords(String academicYear, String categoryName,
			String gradeName, String examName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_GradeName_ToActivateRecords Test===========");

			examsubwizard.filterRecordsBasedOn_CategoryName(academicYear, categoryName, gradeName, examName);

			log.info("============= Finished tcFilterRecordsBasedOn_GradeName_ToActivateRecords Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ToActivateRecords");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ToActivateRecords");
		}
	}

	@Test(priority = 109)
	public void tcClickOnActivationIcon_ToActivateExamSubjectWizard() {

		try {
			log.info("============= Strting tcClickOnActivationIcon_ToActivateExamSubjectWizard Test===========");

			examsubwizard.clickOnActivationIcon_ToActivateExamSubjectWizard();

			log.info("============= Finished tcClickOnActivationIcon_ToActivateExamSubjectWizard Test===========");
			getScreenShot("tcClickOnActivationIcon_ToActivateExamSubjectWizard");
		} catch (Exception e) {
			getScreenShot("tcClickOnActivationIcon_ToActivateExamSubjectWizard");
		}
	}

	@Test(priority = 110)
	public void tcCancel_ActivatePopUp() {

		try {
			log.info("============= Strting tcCancel_ActivatePopUp Test===========");

			examsubwizard.cancel_DeactivateOrActivatePopUp();

			log.info("============= Finished tcCancel_ActivatePopUp Test===========");
			getScreenShot("tcCancel_ActivatePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_ActivatePopUp");
		}
	}

	@Test(priority = 111)
	public void tcClickOnSuccessOkBtn_CancelActivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelActivate Test===========");

			examsubwizard.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelActivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		}
	}

	@Test(priority = 112, dataProvider = "FilterRecords_ExamSubjectWizardOutputGrid")
	public void tcFilterRecordsBasedOn_GradeName_ToActivateRecords_AfterCancel(String academicYear, String categoryName,
			String gradeName, String examName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFilterRecordsBasedOn_GradeName_ToActivateRecords_AfterCancel Test===========");

			examsubwizard.filterRecordsBasedOn_CategoryName(academicYear, categoryName, gradeName, examName);

			log.info(
					"============= Finished tcFilterRecordsBasedOn_GradeName_ToActivateRecords_AfterCancel Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ToActivateRecords_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ToActivateRecords_AfterCancel");
		}
	}

	@Test(priority = 113)
	public void tcClickOnActivationIcon_ToActivateExamSubjectWizard_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnActivationIcon_ToActivateExamSubjectWizard_AfterCancel Test===========");

			examsubwizard.clickOnActivationIcon_ToActivateExamSubjectWizard();

			log.info(
					"============= Finished tcClickOnActivationIcon_ToActivateExamSubjectWizard_AfterCancel Test===========");
			getScreenShot("tcClickOnActivationIcon_ToActivateExamSubjectWizard_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnActivationIcon_ToActivateExamSubjectWizard_AfterCancel");
		}
	}

	@Test(priority = 114)
	public void tcConfirmationForActivate() {

		try {
			log.info("============= Strting tcConfirmationForActivate Test===========");

			examsubwizard.confirmationForDeactivateAndActivate();

			log.info("============= Finished tcConfirmationForActivate Test===========");
			getScreenShot("tcConfirmationForActivate");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForActivate");
		}
	}

	@Test(priority = 115)
	public void tcClickOnSuccessOkBtn_Activate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Activate Test===========");

			examsubwizard.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Activate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Activate");
		}
	}

	@Test(priority = 116)
	public void tcMaximize_ExamSubjectWizard_Form() {

		try {
			log.info("============= Strting tcMaximize_ExamSubjectWizard_Form Test===========");

			examsubwizard.min_Max_ExamSubjectWizard();

			log.info("============= Finished tcMaximize_ExamSubjectWizard_Form Test===========");
			getScreenShot("tcMaximize_ExamSubjectWizard_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_ExamSubjectWizard_Form");
		}
	}

	@Test(priority = 117, dataProvider = "FilterRecords_ExamSubjectWizardOutputGrid")
	public void tcFilterRecordsBasedOn_GradeName_ToEditRecords(String academicYear, String categoryName,
			String gradeName, String examName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_GradeName_ToEditRecords Test===========");

			examsubwizard.filterRecordsBasedOn_CategoryName(academicYear, categoryName, gradeName, examName);

			log.info("============= Finished tcFilterRecordsBasedOn_GradeName_ToEditRecords Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ToEditRecords");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GradeName_ToEditRecords");
		}
	}

	@Test(priority = 118)
	public void tcClickOnEditIcon_ToUpdateExamSubjectWizard() {

		try {
			log.info("============= Strting tcClickOnEditIcon_ToUpdateExamSubjectWizard Test===========");

			examsubwizard.clickOnEditIcon_ToUpdateExamSubjectWizard();
			log.info("============= Finished tcClickOnEditIcon_ToUpdateExamSubjectWizard Test===========");
			getScreenShot("tcClickOnEditIcon_ToUpdateExamSubjectWizard");
		} catch (Exception e) {
			getScreenShot("tcClickOnEditIcon_ToUpdateExamSubjectWizard");
		}
	}

	@Test(priority = 119)
	public void tclickOnSaveButton_ToSubmitExamSubjectWizardForm_Edit() {

		try {
			log.info("============= Strting tclickOnSaveButton_ToSubmitExamSubjectWizardForm_Edit Test===========");

			examsubwizard.clickOnSaveButton_ToSubmitExamSubjectWizardForm();
			log.info("============= Finished tclickOnSaveButton_ToSubmitExamSubjectWizardForm_Edit Test===========");

			getScreenShot("tclickOnSaveButton_ToSubmitExamSubjectWizardForm_Edit");

		} catch (Exception e) {
			getScreenShot("tclickOnSaveButton_ToSubmitExamSubjectWizardForm_Edit");
		}
	}

	@Test(priority = 120)
	public void tcClickOnSuccessOkBtn_ForConfirmation_Edit() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ForConfirmation_Edit Test===========");

			examsubwizard.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ForConfirmation_Edit Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit");
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
