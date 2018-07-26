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

import com.vapsTechnosoft.IVRM.Exam.ExamMapping.Exam_CategorySubjectMapping;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Exam_CategorySubjectMapping extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Exam_CategorySubjectMapping.class.getName());

	Exam_CategorySubjectMapping categorysubjectmapping;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "CategorySubjectMappingData_Form")
	public String[][] getTestData() {
		String[][] testRecordsCategorySubject = getData("ExamMapping.xlsx", "CategorySubjectMappingData");
		return testRecordsCategorySubject;
	}

	@DataProvider(name = "Filter_CategorySubMapping_GridView")
	public String[][] getTestSearchData() {
		String[][] testRecordsFilter = getData("ExamMapping.xlsx", "CategorySubMapping_GridView");
		return testRecordsFilter;
	}


	@BeforeClass
	public void setUp() throws IOException {
		init();
		categorysubjectmapping = new Exam_CategorySubjectMapping(driver);
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

			boolean status = categorysubjectmapping.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToExamMapping_CategorySubjectMapping() {

		try {
			log.info("============= Strting tcNavigateToExamMapping_CategorySubjectMapping Test===========");

			categorysubjectmapping.navigateToExamMapping_CategorySubjectMapping();

			log.info("============= Finished tcNavigateToExamMapping_CategorySubjectMapping Test===========");
			getScreenShot("tcNavigateToExamMapping_CategorySubjectMapping");
		} catch (Exception e) {
			getScreenShot("tcNavigateToExamMapping_CategorySubjectMapping");
		}
	}

	@Test(priority = 4)
	public void tcVerifyExamCategorySubjectMapping_Page() {

		try {
			log.info("============= Strting tcVerifyExamCategorySubjectMapping_Page Test===========");

			boolean status = categorysubjectmapping.verifyExamCategorySubjectMappingPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyExamCategorySubjectMapping_Page Test===========");
			getScreenShot("tcVerifyExamCategorySubjectMapping_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyExamCategorySubjectMapping_Page");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlank_CategorySubjectMappingForm() {

		try {
			log.info("============= Strting tcSubmitBlank_CategorySubjectMappingForm Test===========");

			categorysubjectmapping.submitBlank_CategorySubjectMappingForm();

			log.info("============= Finished tcSubmitBlank_CategorySubjectMappingForm Test===========");
			getScreenShot("tcSubmitBlank_CategorySubjectMappingForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlank_CategorySubjectMappingForm");
		}
	}

	@Test(priority = 6, dataProvider = "CategorySubjectMappingData_Form")
	public void tcFill_CategorySubjectMapping_Form(String academicYear, String category, String subjectGroup,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_CategorySubjectMapping_Form Test===========");

			categorysubjectmapping.fill_CategorySubjectMapping_Form(academicYear, category, subjectGroup);

			log.info("============= Finished tcFill_CategorySubjectMapping_Form Test===========");
			getScreenShot("tcFill_CategorySubjectMapping_Form");
		} catch (Exception e) {
			getScreenShot("tcFill_CategorySubjectMapping_Form");
		}
	}

	@Test(priority = 7)
	public void tcMinimize_CategorySubjectMapping_Form() {

		try {
			log.info("============= Strting tcMinimize_CategorySubjectMapping_Form Test===========");

			categorysubjectmapping.min_Max_CategorySubjectMapping();

			log.info("============= Finished tcMinimize_CategorySubjectMapping_Form Test===========");
			getScreenShot("tcMinimize_CategorySubjectMapping_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_CategorySubjectMapping_Form");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_CategorySubjectMapping_GridView() {

		try {
			log.info("============= Strting tcMinimize_CategorySubjectMapping_GridView Test===========");

			categorysubjectmapping.min_Max_CategorySubjectMapping_GridView();
			log.info("============= Finished tcMinimize_CategorySubjectMapping_GridView Test===========");
			getScreenShot("tcMinimize_CategorySubjectMapping_GridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_CategorySubjectMapping_GridView");
		}
	}

	@Test(priority = 9)
	public void tcMaximize_CategorySubjectMapping_GridView() {

		try {
			log.info("============= Strting tcMaximize_CategorySubjectMapping_GridView Test===========");

			categorysubjectmapping.min_Max_CategorySubjectMapping_GridView();

			log.info("============= Finished tcMaximize_CategorySubjectMapping_GridView Test===========");
			getScreenShot("tcMaximize_CategorySubjectMapping_GridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_CategorySubjectMapping_GridView");
		}
	}

	@Test(priority = 10)
	public void tcMaximize_CategorySubjectMapping_Form() {

		try {
			log.info("============= Strting tcMaximize_CategorySubjectMapping_Form Test===========");

			categorysubjectmapping.min_Max_CategorySubjectMapping();

			log.info("============= Finished tcMaximize_CategorySubjectMapping_Form Test===========");
			getScreenShot("tcMaximize_CategorySubjectMapping_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_CategorySubjectMapping_Form");
		}
	}

	@Test(priority = 11)
	public void tcClickOnCancelButton_ToClearFilledCategorySubjectMappingForm() {

		try {
			log.info(
					"============= Strting tcClickOnCancelButton_ToClearFilledCategorySubjectMappingForm Test===========");

			categorysubjectmapping.clickOnCancelButton_ToClearFilledCategorySubjectMappingForm();

			log.info(
					"============= Finished tcClickOnCancelButton_ToClearFilledCategorySubjectMappingForm Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledCategorySubjectMappingForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledCategorySubjectMappingForm");
		}
	}

	@Test(priority = 12, dataProvider = "CategorySubjectMappingData_Form")
	public void tcFill_CategorySubjectMapping_Form_AfterClearingFilledData(String academicYear, String category,
			String subjectGroup, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFill_CategorySubjectMapping_Form_AfterClearingFilledData Test===========");

			categorysubjectmapping.fill_CategorySubjectMapping_Form(academicYear, category, subjectGroup);

			log.info(
					"============= Finished tcFill_CategorySubjectMapping_Form_AfterClearingFilledData Test===========");
			getScreenShot("tcFill_CategorySubjectMapping_Form_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcFill_CategorySubjectMapping_Form_AfterClearingFilledData");
		}
	}

	@Test(priority = 13)
	public void tcClickOnSaveButton_ToSubmitCategorySubjectMappingForm() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitCategorySubjectMappingForm Test===========");

			categorysubjectmapping.clickOnSaveButton_ToSubmitCategorySubjectMappingForm();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitCategorySubjectMappingForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitCategorySubjectMappingForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitCategorySubjectMappingForm");
		}
	}

	@Test(priority = 14)
	public void tcClickOnSuccessOkBtn_ForConfirmation() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ForConfirmation Test===========");

			categorysubjectmapping.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ForConfirmation Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation");
		}
	}

	@Test(priority = 15, dataProvider = "Filter_CategorySubMapping_GridView")
	public void tcFilterRecordsBasedOn_AcademicYear(String academicYear, String categoryName, String groupName,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_AcademicYear Test===========");

			categorysubjectmapping.filterRecordsBasedOn_AcademicYear(academicYear, categoryName, groupName);

			log.info("============= Finished tcFilterRecordsBasedOn_AcademicYear Test===========");
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear");
		}
	}

	@Test(priority = 16)
	public void tcClearFilledDataForFilter_AcademicYear() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_AcademicYear Test===========");

			categorysubjectmapping.clearFilledDataForFilter();
			log.info("============= Finished tcClearFilledDataForFilter_AcademicYear Test===========");
			getScreenShot("tcClearFilledDataForFilter_AcademicYear");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_AcademicYear");
		}
	}

	@Test(priority = 17, dataProvider = "Filter_CategorySubMapping_GridView")
	public void tcFilterRecordsBasedOn_CategoryName(String academicYear, String categoryName, String groupName,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_CategoryName Test===========");

			categorysubjectmapping.filterRecordsBasedOn_CategoryName(academicYear, categoryName, groupName);

			log.info("============= Finished tcFilterRecordsBasedOn_CategoryName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_CategoryName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_CategoryName");
		}
	}

	@Test(priority = 18)
	public void tcClearFilledDataForFilter_CategoryName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_CategoryName Test===========");

			categorysubjectmapping.clearFilledDataForFilter();
			log.info("============= Finished tcClearFilledDataForFilter_CategoryName Test===========");
			getScreenShot("tcClearFilledDataForFilter_CategoryName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_CategoryName");
		}
	}

	@Test(priority = 19, dataProvider = "Filter_CategorySubMapping_GridView")
	public void tcFilterRecordsBasedOn_GroupName(String academicYear, String categoryName, String groupName,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_GroupName Test===========");

			categorysubjectmapping.filterRecordsBasedOn_GroupName(academicYear, categoryName, groupName);

			log.info("============= Finished tcFilterRecordsBasedOn_GroupName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_GroupName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_GroupName");
		}
	}

	@Test(priority = 20)
	public void tcClearFilledDataForFilter_GroupName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_GroupName Test===========");

			categorysubjectmapping.clearFilledDataForFilter();
			log.info("============= Finished tcClearFilledDataForFilter_GroupName Test===========");
			getScreenShot("tcClearFilledDataForFilter_GroupName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_GroupName");
		}
	}

	@Test(priority = 21)
	public void tcClickOnViewIcon_ToSeeTheMappedSubjectAndSubjectCode() {

		try {
			log.info("============= Strting tcClickOnViewIcon_ToSeeTheMappedSubjectAndSubjectCode Test===========");

			categorysubjectmapping.clickOnViewIcon_ToSeeTheMappedSubjectAndSubjectCode();
			log.info("============= Finished tcClickOnViewIcon_ToSeeTheMappedSubjectAndSubjectCode Test===========");
			getScreenShot("tcClickOnViewIcon_ToSeeTheMappedSubjectAndSubjectCode");
		} catch (Exception e) {
			getScreenShot("tcClickOnViewIcon_ToSeeTheMappedSubjectAndSubjectCode");
		}
	}

	@Test(priority = 22)
	public void tcCloseViewPopUpWindows() {

		try {
			log.info("============= Strting tcCloseViewPopUpWindows Test===========");

			categorysubjectmapping.closeViewPopUpWindows();
			log.info("============= Finished tcCloseViewPopUpWindows Test===========");
			getScreenShot("tcCloseViewPopUpWindows");
		} catch (Exception e) {
			getScreenShot("tcCloseViewPopUpWindows");
		}
	}

	@Test(priority = 23, dataProvider = "Filter_CategorySubMapping_GridView")
	public void tcFilterRecordsBasedOn_AcademicYear_ToEditRecords(String academicYear, String categoryName,
			String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_AcademicYear_ToEditRecords Test===========");

			categorysubjectmapping.filterRecordsBasedOn_AcademicYear(academicYear, categoryName, groupName);

			log.info("============= Finished tcFilterRecordsBasedOn_AcademicYear_ToEditRecords Test===========");
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear_ToEditRecords");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear_ToEditRecords");
		}
	}

	@Test(priority = 24)
	public void tcClickOnEditIcon_ToUpdateCategorySubjectMapping() {

		try {
			log.info("============= Strting tcClickOnEditIcon_ToUpdateCategorySubjectMapping Test===========");

			categorysubjectmapping.clickOnEditIcon_ToUpdateCategorySubjectMapping();
			log.info("============= Finished tcClickOnEditIcon_ToUpdateCategorySubjectMapping Test===========");
			getScreenShot("tcClickOnEditIcon_ToUpdateCategorySubjectMapping");
		} catch (Exception e) {
			getScreenShot("tcClickOnEditIcon_ToUpdateCategorySubjectMapping");
		}
	}

	@Test(priority = 25)
	public void tcClickOnSaveButton_ToSubmitCategorySubjectMappingForm_Edit() {

		try {
			log.info(
					"============= Strting tcClickOnSaveButton_ToSubmitCategorySubjectMappingForm_Edit Test===========");

			categorysubjectmapping.clickOnSaveButton_ToSubmitCategorySubjectMappingForm();
			log.info(
					"============= Finished tcClickOnSaveButton_ToSubmitCategorySubjectMappingForm_Edit Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitCategorySubjectMappingForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitCategorySubjectMappingForm_Edit");
		}
	}

	@Test(priority = 26)
	public void tcClickOnSuccessOkBtn_ForConfirmation_Edit() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ForConfirmation_Edit Test===========");

			categorysubjectmapping.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ForConfirmation_Edit Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit");
		}
	}

	@Test(priority = 27, dataProvider = "Filter_CategorySubMapping_GridView")
	public void tcFilterRecordsBasedOn_AcademicYear_ToDeactivateRecords(String academicYear, String categoryName,
			String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_AcademicYear_ToDeactivateRecords Test===========");

			categorysubjectmapping.filterRecordsBasedOn_AcademicYear(academicYear, categoryName, groupName);

			log.info("============= Finished tcFilterRecordsBasedOn_AcademicYear_ToDeactivateRecords Test===========");
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear_ToDeactivateRecords");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear_ToDeactivateRecords");
		}
	}

	@Test(priority = 28)
	public void tcClickOnDeActivationIcon_ToDeactivateCategorySubjectMapping() {

		try {
			log.info(
					"============= Strting tcClickOnDeActivationIcon_ToDeactivateCategorySubjectMapping Test===========");

			categorysubjectmapping.clickOnDeActivationIcon_ToDeactivateCategorySubjectMapping();

			log.info(
					"============= Finished tcClickOnDeActivationIcon_ToDeactivateCategorySubjectMapping Test===========");
			getScreenShot("tcClickOnDeActivationIcon_ToDeactivateCategorySubjectMapping");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeActivationIcon_ToDeactivateCategorySubjectMapping");
		}
	}

	@Test(priority = 29)
	public void tcCancel_DeactivatePopUp() {

		try {
			log.info("============= Strting tcCancel_DeactivatePopUp Test===========");

			categorysubjectmapping.cancel_DeactivateOrActivatePopUp();

			log.info("============= Finished tcCancel_DeactivatePopUp Test===========");
			getScreenShot("tcCancel_DeactivatePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_DeactivatePopUp");
		}
	}

	@Test(priority = 30)
	public void tcClickOnSuccessOkBtn_CancelDeactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelDeactivate Test===========");

			categorysubjectmapping.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelDeactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		}
	}

	@Test(priority = 31, dataProvider = "Filter_CategorySubMapping_GridView")
	public void tcFilterRecordsBasedOn_AcademicYear_ToDeactivateRecords_AfterCancel(String academicYear,
			String categoryName, String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFilterRecordsBasedOn_AcademicYear_ToDeactivateRecords_AfterCancel Test===========");

			categorysubjectmapping.filterRecordsBasedOn_AcademicYear(academicYear, categoryName, groupName);

			log.info(
					"============= Finished tcFilterRecordsBasedOn_AcademicYear_ToDeactivateRecords_AfterCancel Test===========");
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear_ToDeactivateRecords_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear_ToDeactivateRecords_AfterCancel");
		}
	}

	@Test(priority = 32)
	public void tcClickOnDeActivationIcon_ToDeactivateCategorySubjectMapping_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnDeActivationIcon_ToDeactivateCategorySubjectMapping_AfterCancel Test===========");

			categorysubjectmapping.clickOnDeActivationIcon_ToDeactivateCategorySubjectMapping();

			log.info(
					"============= Finished tcClickOnDeActivationIcon_ToDeactivateCategorySubjectMapping_AfterCancel Test===========");
			getScreenShot("tcClickOnDeActivationIcon_ToDeactivateCategorySubjectMapping_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeActivationIcon_ToDeactivateCategorySubjectMapping_AfterCancel");
		}
	}

	@Test(priority = 33)
	public void tcConfirmationForDeactivate() {

		try {
			log.info("============= Strting tcConfirmationForDeactivate Test===========");

			categorysubjectmapping.confirmationForDeactivateAndActivate();

			log.info("============= Finished tcConfirmationForDeactivate Test===========");
			getScreenShot("tcConfirmationForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForDeactivate");
		}
	}

	@Test(priority = 34)
	public void tcClickOnSuccessOkBtn_Deactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Deactivate Test===========");

			categorysubjectmapping.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Deactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		}
	}

	@Test(priority = 35, dataProvider = "Filter_CategorySubMapping_GridView")
	public void tcFilterRecordsBasedOn_AcademicYear_ToActivateRecords(String academicYear, String categoryName,
			String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_AcademicYear_ToActivateRecords Test===========");

			categorysubjectmapping.filterRecordsBasedOn_AcademicYear(academicYear, categoryName, groupName);

			log.info("============= Finished tcFilterRecordsBasedOn_AcademicYear_ToActivateRecords Test===========");
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear_ToActivateRecords");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear_ToActivateRecords");
		}
	}

	@Test(priority = 36)
	public void tcClickOnActivationIcon_ToActivateCategorySubjectMapping() {

		try {
			log.info("============= Strting tcClickOnActivationIcon_ToActivateCategorySubjectMapping Test===========");

			categorysubjectmapping.clickOnActivationIcon_ToActivateCategorySubjectMapping();

			log.info(
					"============= Finished tcClickOnDeActivationIcon_ToActivateCategorySubjectMapping Test===========");
			getScreenShot("tcClickOnActivationIcon_ToActivateCategorySubjectMapping");
		} catch (Exception e) {
			getScreenShot("tcClickOnActivationIcon_ToActivateCategorySubjectMapping");
		}
	}

	@Test(priority = 37)
	public void tcCancel_ActivatePopUp() {

		try {
			log.info("============= Strting tcCancel_ActivatePopUp Test===========");

			categorysubjectmapping.cancel_DeactivateOrActivatePopUp();

			log.info("============= Finished tcCancel_ActivatePopUp Test===========");
			getScreenShot("tcCancel_ActivatePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_ActivatePopUp");
		}
	}

	@Test(priority = 38)
	public void tcClickOnSuccessOkBtn_CancelActivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelActivate Test===========");

			categorysubjectmapping.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelActivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		}
	}

	@Test(priority = 39, dataProvider = "Filter_CategorySubMapping_GridView")
	public void tcFilterRecordsBasedOn_AcademicYear_ToActivateRecords_AfterCancel(String academicYear,
			String categoryName, String groupName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFilterRecordsBasedOn_AcademicYear_ToActivateRecords_AfterCancel Test===========");

			categorysubjectmapping.filterRecordsBasedOn_AcademicYear(academicYear, categoryName, groupName);

			log.info(
					"============= Finished tcFilterRecordsBasedOn_AcademicYear_ToActivateRecords_AfterCancel Test===========");
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear_ToActivateRecords_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear_ToActivateRecords_AfterCancel");
		}
	}

	@Test(priority = 40)
	public void tcClickOnActivationIcon_ToActivateCategorySubjectMapping_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnActivationIcon_ToActivateCategorySubjectMapping_AfterCancel Test===========");

			categorysubjectmapping.clickOnActivationIcon_ToActivateCategorySubjectMapping();

			log.info(
					"============= Finished tcClickOnActivationIcon_ToActivateCategorySubjectMapping_AfterCancel Test===========");
			getScreenShot("tcClickOnActivationIcon_ToActivateCategorySubjectMapping_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnActivationIcon_ToActivateCategorySubjectMapping_AfterCancel");
		}
	}

	@Test(priority = 41)
	public void tcConfirmationForActivate() {

		try {
			log.info("============= Strting tcConfirmationForActivate Test===========");

			categorysubjectmapping.confirmationForDeactivateAndActivate();

			log.info("============= Finished tcConfirmationForActivate Test===========");
			getScreenShot("tcConfirmationForActivate");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForActivate");
		}
	}

	@Test(priority = 42)
	public void tcClickOnSuccessOkBtn_Activate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Activate Test===========");

			categorysubjectmapping.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Activate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Activate");
		}
	}

	@Test(priority = 43)
	public void tcSortWithAcademicYearInGridView() {

		try {
			log.info("============= Strting tcSortWithAcademicYearInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithAcademicYearInGridView");
			categorysubjectmapping.sortWithAcademicYearInGridView();

			log.info("============= Finished tcSortWithAcademicYearInGridView Test===========");
			getScreenShot("tcSortWithAcademicYearInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithAcademicYearInGridView");
		}
	}

	@Test(priority = 44)
	public void tcSortWithCategoryNameInGridView() {

		try {
			log.info("============= Strting tcSortWithCategoryNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithCategoryNameInGridView");
			categorysubjectmapping.sortWithCategoryNameInGridView();

			log.info("============= Finished tcSortWithCategoryNameInGridView Test===========");
			getScreenShot("tcSortWithCategoryNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithCategoryNameInGridView");
		}
	}

	@Test(priority = 45)
	public void tcSortWithGroupNameInGridView() {

		try {
			log.info("============= Strting tcSortWithGroupNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithGroupNameInGridView");
			categorysubjectmapping.sortWithGroupNameInGridView();

			log.info("============= Finished tcSortWithGroupNameInGridView Test===========");
			getScreenShot("tcSortWithGroupNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithGroupNameInGridView");
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
