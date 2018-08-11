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
import com.vapsTechnosoft.IVRM.Exam.ExamMapping.Exam_StudentMapping;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author Arvind
 *
 */
public class TC_Exam_StudentMapping extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Exam_StudentMapping.class.getName());

	Exam_StudentMapping studentmapping;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "ExamStudentMapping_FormData")
	public String[][] getTestData() {
		String[][] testRecords = getData("ExamMapping.xlsx", "ExamStudentMappingData");
		return testRecords;
	}

	@DataProvider(name = "Filter_StudentMapping_StudentList")
	public String[][] getTestSearchData() {
		String[][] testRecordsFilter = getData("ExamMapping.xlsx", "Search_StudentMapping");
		return testRecordsFilter;
	}


	@BeforeClass
	public void setUp() throws IOException {
		init();
		studentmapping = new Exam_StudentMapping(driver);
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

			boolean status = studentmapping.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToExamMapping_ExamStudentMapping() {

		try {
			log.info("============= Strting tcNavigateToExamMapping_ExamStudentMapping Test===========");

			studentmapping.navigateToExamMapping_ExamStudentMapping();

			log.info("============= Finished tcNavigateToExamMapping_ExamStudentMapping Test===========");
			getScreenShot("tcNavigateToExamMapping_ExamStudentMapping");
		} catch (Exception e) {
			getScreenShot("tcNavigateToExamMapping_ExamStudentMapping");
		}
	}

	@Test(priority = 4)
	public void tcVerifyExamStudentMapping_Page() {

		try {
			log.info("============= Strting tcVerifyExamStudentMapping_Page Test===========");

			boolean status = studentmapping.verifyExamStudentMappingPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyExamStudentMapping_Page Test===========");
			getScreenShot("tcVerifyExamStudentMapping_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyExamStudentMapping_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_StudentMappingForm() {

		try {
			log.info("============= Strting tcSubmitBlank_StudentMappingForm Test===========");

			studentmapping.clickOnSearchButton_ToSubmitBlankForm();

			log.info("============= Finished tcSubmitBlank_StudentMappingForm Test===========");
			getScreenShot("tcSubmitBlank_StudentMappingForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_StudentMappingForm");
		}
	}

	@Test(priority = 6, dataProvider = "ExamStudentMapping_FormData")
	public void tcFill_StudentMapping_Form(String academicYear, String examCategory,String subjecGroup, String class_sm,
			String section_sm,String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_StudentMapping_Form Test===========");

			studentmapping.fill_StudentMapping_Form(academicYear, examCategory, subjecGroup, class_sm, section_sm);

			log.info("============= Finished tcFill_StudentMapping_Form Test===========");
			getScreenShot("tcFill_StudentMapping_Form");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentMapping_Form");
		}
	}
	@Test(priority = 7)
	public void tcSubmitFilled_StudentMappingForm() {

		try {
			log.info("============= Strting tcSubmitFilled_StudentMappingForm Test===========");

			studentmapping.clickOnSearchButton_ToSubmitBlankForm();

			log.info("============= Finished tcSubmitFilled_StudentMappingForm Test===========");
			getScreenShot("tcSubmitFilled_StudentMappingForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilled_StudentMappingForm");
		}
	}
	@Test(priority = 8)
	public void tcDeSelectStudentForMapping_ifAnyRecordSelectedPreviously() {

		try {
			log.info("============= Strting tcDeSelectStudentForMapping_ifAnyRecordSelectedPreviously Test===========");

			studentmapping.deSelectStudentForMapping();

			log.info("============= Finished tcDeSelectStudentForMapping_ifAnyRecordSelectedPreviously Test===========");
			getScreenShot("tcDeSelectStudentForMapping_ifAnyRecordSelectedPreviously");
		} catch (Exception e) {
			getScreenShot("tcDeSelectStudentForMapping_ifAnyRecordSelectedPreviously");
		}
	}
	@Test(priority = 9)
	public void tcClickOnSaveButton_WithoutSelectingAnyRecords() {

		try {
			log.info("============= Strting tcClickOnSaveButton_WithoutSelectingAnyRecords Test===========");

			studentmapping.clickOnSaveButton_WithoutSelecting();

			log.info("============= Finished tcClickOnSaveButton_WithoutSelectingAnyRecords Test===========");
			getScreenShot("tcClickOnSaveButton_WithoutSelectingAnyRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_WithoutSelectingAnyRecords");
		}
	}
	@Test(priority = 10)
	public void tcClickOnSuccessOkBtn_ToHandleRecordNotSelectedPopUp() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ToHandleRecordNotSelectedPopUp Test===========");

			studentmapping.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ToHandleRecordNotSelectedPopUp Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ToHandleRecordNotSelectedPopUp");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ToHandleRecordNotSelectedPopUp");
		}
	}
	@Test(priority = 11)
	public void tcSort_StudentList() {

		try {
			log.info("============= Strting tcSort_StudentList Test===========");
			getScreenShot("BeforeSorting_tcSort_StudentList");
			studentmapping.sort_StudentList();

			log.info("============= Finished tcSort_StudentList Test===========");
			getScreenShot("tcSort_StudentList");
		} catch (Exception e) {
			getScreenShot("tcSort_StudentList");
		}
	}
	@Test(priority = 12)
	public void tcSort_AdmissionNumber() {

		try {
			log.info("============= Strting tcSort_AdmissionNumber Test===========");
			getScreenShot("BeforeSorting_tcSort_AdmissionNumber");
			studentmapping.sort_AdmissionNumber();

			log.info("============= Finished tcSort_AdmissionNumber Test===========");
			getScreenShot("tcSort_AdmissionNumber");
		} catch (Exception e) {
			getScreenShot("tcSort_AdmissionNumber");
		}
	}
	@Test(priority = 13)
	public void tcSort_RollNumber() {

		try {
			log.info("============= Strting tcSort_RollNumber Test===========");
			getScreenShot("BeforeSorting_tcSort_RollNumber");
			studentmapping.sort_RollNumber();

			log.info("============= Finished tcSort_RollNumber Test===========");
			getScreenShot("tcSort_RollNumber");
		} catch (Exception e) {
			getScreenShot("tcSort_RollNumber");
		}
	}

	@Test(priority = 14, dataProvider = "Filter_StudentMapping_StudentList")
	public void tcSearch_ToFilterStudentFromList(String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearch_ToFilterStudentFromList Test===========");

			studentmapping.Search_ToFilterStudentFromList(studentName);

			log.info("============= Finished tcSearch_ToFilterStudentFromList Test===========");
			getScreenShot("tcSearch_ToFilterStudentFromList");
		} catch (Exception e) {
			getScreenShot("tcSearch_ToFilterStudentFromList");
		}
	}
	@Test(priority = 15)
	public void tcClickOnCancelButton_ToClearSelectedRecords() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearSelectedRecords Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearSelectedRecords");
			studentmapping.clickOnCancelButton_ToClearSelectedRecords();

			log.info("============= Finished tcClickOnCancelButton_ToClearSelectedRecords Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearSelectedRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearSelectedRecords");
		}
	}
	@Test(priority = 16, dataProvider = "ExamStudentMapping_FormData")
	public void tcFill_StudentMapping_Form_AfterCancel(String academicYear, String examCategory,String subjecGroup, String class_sm,
			String section_sm,String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_StudentMapping_Form_AfterCancel Test===========");

			studentmapping.fill_StudentMapping_Form(academicYear, examCategory, subjecGroup, class_sm, section_sm);

			log.info("============= Finished tcFill_StudentMapping_Form_AfterCancel Test===========");
			getScreenShot("tcFill_StudentMapping_Form_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_StudentMapping_Form_AfterCancel");
		}
	}
	@Test(priority = 17)
	public void tcClickOnSearchButton_ToGetStudentSubjectList() {

		try {
			log.info("============= Strting tcClickOnSearchButton_ToGetStudentSubjectList Test===========");

			studentmapping.clickOnSearchButton_ToGetStudentSubjectList();

			log.info("============= Finished tcClickOnSearchButton_ToGetStudentSubjectList Test===========");
			getScreenShot("tcClickOnSearchButton_ToGetStudentSubjectList");
		} catch (Exception e) {
			getScreenShot("tcClickOnSearchButton_ToGetStudentSubjectList");
		}
	}
	@Test(priority = 18)
	public void tcDeSelectStudentForMapping_ifAnyRecordSelectedPreviously_AfterCancel() {

		try {
			log.info("============= Strting tcDeSelectStudentForMapping_ifAnyRecordSelectedPreviously_AfterCancel Test===========");

			studentmapping.deSelectStudentForMapping();

			log.info("============= Finished tcDeSelectStudentForMapping_ifAnyRecordSelectedPreviously_AfterCancel Test===========");
			getScreenShot("tcDeSelectStudentForMapping_ifAnyRecordSelectedPreviously_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeSelectStudentForMapping_ifAnyRecordSelectedPreviously_AfterCancel");
		}
	}
	@Test(priority = 19)
	public void tcSelectStudentForMapping() {

		try {
			log.info("============= Strting tcSelectStudentForMapping Test===========");

			studentmapping.selectStudentForMapping();

			log.info("============= Finished tcSelectStudentForMapping Test===========");
			getScreenShot("tcSelectStudentForMapping");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForMapping");
		}
	}
	@Test(priority = 20)
	public void tcSelectSubjectForMapping_Sub1() {

		try {
			log.info("============= Strting tcSelectSubjectForMapping_Sub1 Test===========");

			studentmapping.selectSubjectForMapping_Sub1();

			log.info("============= Finished tcSelectSubjectForMapping_Sub1 Test===========");
			getScreenShot("tcSelectSubjectForMapping_Sub1");
		} catch (Exception e) {
			getScreenShot("tcSelectSubjectForMapping_Sub1");
		}
	}
	@Test(priority = 21)
	public void tcSelectSubjectForMapping_Sub2() {

		try {
			log.info("============= Strting tcSelectSubjectForMapping_Sub2 Test===========");

			studentmapping.selectSubjectForMapping_Sub2();

			log.info("============= Finished tcSelectSubjectForMapping_Sub2 Test===========");
			getScreenShot("tcSelectSubjectForMapping_Sub2");
		} catch (Exception e) {
			getScreenShot("tcSelectSubjectForMapping_Sub2");
		}
	}
	@Test(priority = 22)
	public void tcSelectSubjectForMapping_Sub3() {

		try {
			log.info("============= Strting tcSelectSubjectForMapping_Sub3 Test===========");

			studentmapping.selectSubjectForMapping_Sub3();

			log.info("============= Finished tcSelectSubjectForMapping_Sub3 Test===========");
			getScreenShot("tcSelectSubjectForMapping_Sub3");
		} catch (Exception e) {
			getScreenShot("tcSelectSubjectForMapping_Sub3");
		}
	}
	@Test(priority = 23)
	public void tcClickOnSaveButton_ToSubmitSelectedRecords() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitSelectedRecords Test===========");

			studentmapping.clickOnSaveButton_ToSubmitSelectedRecords();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitSelectedRecords Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitSelectedRecords");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitSelectedRecords");
		}
	}
	@Test(priority = 24)
	public void tcClickOnSuccessOkBtn_FinalSubmit() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_FinalSubmit Test===========");

			studentmapping.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_FinalSubmit Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_FinalSubmit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_FinalSubmit");
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
