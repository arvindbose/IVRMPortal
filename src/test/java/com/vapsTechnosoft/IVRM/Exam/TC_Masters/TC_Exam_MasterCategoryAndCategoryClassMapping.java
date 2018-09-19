/**
 * 
 */
package com.vapsTechnosoft.IVRM.Exam.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.vapsTechnosoft.IVRM.Exam.Masters.Exam_MasterCategoryAndCategoryClassMapping;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class TC_Exam_MasterCategoryAndCategoryClassMapping extends TestBase {
	public static final Logger log = Logger.getLogger(TC_Exam_MasterCategoryAndCategoryClassMapping.class.getName());

	Exam_MasterCategoryAndCategoryClassMapping mastercategory;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "ExamMasterCategory_Form")
	public String[][] getTestData() {
		String[][] testRecordsCategory = getData("ExamMasters.xlsx", "ExamMasterCategory_FormData");
		return testRecordsCategory;
	}

	@DataProvider(name = "ExamCategoryClassMapping_FormData")
	public String[][] getTestDataCategoryClass() {
		String[][] testRecordsCategoryClassMap = getData("ExamMasters.xlsx", "CategoryClassMapping_FormDat");
		return testRecordsCategoryClassMap;
	}

	@DataProvider(name = "CategoryClassMapping_2ndData_ClassSection")
	public String[][] getTestSearchData() {
		String[][] testRecords2ndData = getData("ExamMasters.xlsx", "CategoryClassMapping_2ndData");
		return testRecords2ndData;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		mastercategory = new Exam_MasterCategoryAndCategoryClassMapping(driver);
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

			boolean status = mastercategory.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToExamMasters_ExamMasterCategory() {

		try {
			log.info("============= Strting tcNavigateToExamMasters_ExamMasterCategory Test===========");

			mastercategory.navigateToExamMasters_ExamMasterCategory();

			log.info("============= Finished tcNavigateToExamMasters_ExamMasterCategory Test===========");
			getScreenShot("tcNavigateToExamMasters_ExamMasterCategory");
		} catch (Exception e) {
			getScreenShot("tcNavigateToExamMasters_ExamMasterCategory");
		}
	}

	@Test(priority = 4)
	public void tcVerifyExamMasterCategory_Page() {

		try {
			log.info("============= Strting tcVerifyExamMasterCategory_Page Test===========");

			boolean status = mastercategory.verifyExamMasterCategoryPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyExamMasterCategory_Page Test===========");
			getScreenShot("tcVerifyExamMasterCategory_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyExamMasterCategory_Page");
		}
	}

	@Test(priority = 5)
	public void tcClickOnSaveButton_ToSubmitBlank_MasterCategoryForm() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitBlank_MasterCategoryForm Test===========");

			mastercategory.clickOnSaveButton_ToSubmitMasterCategory();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitBlank_MasterCategoryForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitBlank_MasterCategoryForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitBlank_MasterCategoryForm");
		}
	}

	@Test(priority = 6, dataProvider = "ExamMasterCategory_Form")
	public void tcFill_Exam_MasterCategory_Form(String categoryName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_Exam_MasterCategory_Form Test===========");

			mastercategory.fill_Exam_MasterCategory_Form(categoryName);

			log.info("============= Finished tcFill_Exam_MasterCategory_Form Test===========");
			getScreenShot("tcFill_Exam_MasterCategory_Form");
		} catch (Exception e) {
			getScreenShot("tcFill_Exam_MasterCategory_Form");
		}
	}

	@Test(priority = 7)
	public void tcMinimize_MasterCategory_GridView() {

		try {
			log.info("============= Strting tcMinimize_MasterCategory_GridView Test===========");

			mastercategory.min_Max_MasterCategory_GridView();

			log.info("============= Finished tcMinimize_MasterCategory_GridView Test===========");
			getScreenShot("tcMinimize_MasterCategory_GridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterCategory_GridView");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_MasterCategoryForm() {

		try {
			log.info("============= Strting tcMinimize_MasterCategoryForm Test===========");

			mastercategory.min_Max_MasterCategoryForm();
			log.info("============= Finished tcMinimize_MasterCategoryForm Test===========");
			getScreenShot("tcMinimize_MasterCategoryForm");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterCategoryForm");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_CategoryDashBoard() {

		try {
			log.info("============= Strting tcMinimize_CategoryDashBoard Test===========");

			mastercategory.min_Max_CategoryDashBoard();

			log.info("============= Finished tcMinimize_CategoryDashBoard Test===========");
			getScreenShot("tcMinimize_CategoryDashBoard");
		} catch (Exception e) {
			getScreenShot("tcMinimize_CategoryDashBoard");
		}
	}

	@Test(priority = 10)
	public void tcMaximize_CategoryDashBoard() {

		try {
			log.info("============= Strting tcMaximize_CategoryDashBoard Test===========");

			mastercategory.min_Max_CategoryDashBoard();

			log.info("============= Finished tcMaximize_CategoryDashBoard Test===========");
			getScreenShot("tcMaximize_CategoryDashBoard");
		} catch (Exception e) {
			getScreenShot("tcMaximize_CategoryDashBoard");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_MasterCategoryForm() {

		try {
			log.info("============= Strting tcMaximize_MasterCategoryForm Test===========");

			mastercategory.min_Max_MasterCategoryForm();

			log.info("============= Finished tcMaximize_MasterCategoryForm Test===========");
			getScreenShot("tcMaximize_MasterCategoryForm");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterCategoryForm");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_MasterCategory_GridView() {

		try {
			log.info("============= Strting tcMaximize_MasterCategory_GridView Test===========");

			mastercategory.min_Max_MasterCategory_GridView();

			log.info("============= Finished tcMaximize_MasterCategory_GridView Test===========");
			getScreenShot("tcMaximize_MasterCategory_GridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterCategory_GridView");
		}
	}

	@Test(priority = 13)
	public void tcClickOnCancelButton_ToClearMasterCategoryFilledData() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearMasterCategoryFilledData Test===========");

			mastercategory.clickOnCancelButton_ToClearMasterCategoryFilledData();

			log.info("============= Finished tcClickOnCancelButton_ToClearMasterCategoryFilledData Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearMasterCategoryFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearMasterCategoryFilledData");
		}
	}

	@Test(priority = 14, dataProvider = "ExamMasterCategory_Form")
	public void tcFill_Exam_MasterCategory_Form_AfterCancel(String categoryName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_Exam_MasterCategory_Form_AfterCancel Test===========");

			mastercategory.fill_Exam_MasterCategory_Form(categoryName);

			log.info("============= Finished tcFill_Exam_MasterCategory_Form_AfterCancel Test===========");
			getScreenShot("tcFill_Exam_MasterCategory_Form_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_Exam_MasterCategory_Form_AfterCancel");
		}
	}

	@Test(priority = 15)
	public void tcClickOnSaveButton_ToSubmitMasterCategory() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitMasterCategory Test===========");

			mastercategory.clickOnSaveButton_ToSubmitMasterCategory();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitMasterCategory Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitMasterCategory");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitMasterCategory");
		}
	}

	@Test(priority = 16)
	public void tcClickOnSuccessOkBtn_ForConfirmation_MasterCategory() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ForConfirmation_MasterCategory Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ForConfirmation_MasterCategory Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_MasterCategory");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_MasterCategory");
		}
	}

	@Test(priority = 17)
	public void tcSortByCategoryName_MasterCategory() {

		try {
			log.info("============= Strting tcSortByCategoryName_MasterCategory Test===========");
			getScreenShot("BeforeSorting_tcSortByCategoryName_MasterCategory");
			mastercategory.sortByCategoryName_MasterCategory();

			log.info("============= Finished tcSortByCategoryName_MasterCategory Test===========");
			getScreenShot("tcSortByCategoryName_MasterCategory");
		} catch (Exception e) {
			getScreenShot("tcSortByCategoryName_MasterCategory");
		}
	}

	@Test(priority = 18, dataProvider = "ExamMasterCategory_Form")
	public void tcFilterRecordWithCategoryName_MasterCategory(String categoryName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordWithCategoryName_MasterCategory Test===========");

			mastercategory.filterRecordWithCategoryName(categoryName);

			log.info("============= Finished tcFilterRecordWithCategoryName_MasterCategory Test===========");
			getScreenShot("tcFilterRecordWithCategoryName_MasterCategory");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordWithCategoryName_MasterCategory");
		}
	}

	@Test(priority = 19)
	public void tcEditMasterCategory() {

		try {
			log.info("============= Strting tcEditMasterCategory Test===========");

			mastercategory.editMasterCategory();

			log.info("============= Finished tcEditMasterCategory Test===========");
			getScreenShot("tcEditMasterCategory");
		} catch (Exception e) {
			getScreenShot("tcEditMasterCategory");
		}
	}

	@Test(priority = 20)
	public void tcClickOnSaveButton_ToSubmitMasterCategory_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitMasterCategory_Edit Test===========");

			mastercategory.clickOnSaveButton_ToSubmitMasterCategory();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitMasterCategory_Edit Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitMasterCategory_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitMasterCategory_Edit");
		}
	}

	@Test(priority = 21)
	public void tcClickOnSuccessOkBtn_ForConfirmation_MasterCategory_Edit() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ForConfirmation_MasterCategory_Edit Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info(
					"============= Finished tcClickOnSuccessOkBtn_ForConfirmation_MasterCategory_Edit Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_MasterCategory_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_MasterCategory_Edit");
		}
	}

	@Test(priority = 22, dataProvider = "ExamMasterCategory_Form")
	public void tcFilterRecordWithCategoryName_MasterCategory_ForDeactivate(String categoryName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcFilterRecordWithCategoryName_MasterCategory_ForDeactivate Test===========");

			mastercategory.filterRecordWithCategoryName(categoryName);

			log.info(
					"============= Finished tcFilterRecordWithCategoryName_MasterCategory_ForDeactivate Test===========");
			getScreenShot("tcFilterRecordWithCategoryName_MasterCategory_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordWithCategoryName_MasterCategory_ForDeactivate");
		}
	}

	@Test(priority = 23)
	public void tcDeactivateRecords_MasterCategoryGrid() {

		try {
			log.info("============= Strting tcDeactivateRecords_MasterCategoryGrid Test===========");

			mastercategory.deactivateRecords_MasterCategoryGrid();

			log.info("============= Finished tcDeactivateRecords_MasterCategoryGrid Test===========");
			getScreenShot("tcDeactivateRecords_MasterCategoryGrid");
		} catch (Exception e) {
			getScreenShot("tcDeactivateRecords_MasterCategoryGrid");
		}
	}

	@Test(priority = 24)
	public void tcCancel_DeactivatePopUp_MasterCategory() {

		try {
			log.info("============= Strting tcCancel_DeactivatePopUp_MasterCategory Test===========");

			mastercategory.cancelDeactivationAndActivationOfRecord();

			log.info("============= Finished tcCancel_DeactivatePopUp_MasterCategory Test===========");
			getScreenShot("tcCancel_DeactivatePopUp_MasterCategory");
		} catch (Exception e) {
			getScreenShot("tcCancel_DeactivatePopUp_MasterCategory");
		}
	}

	@Test(priority = 25)
	public void tcClickOnSuccessOkBtn_CancelDeactivate_MasterCategory() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelDeactivate_MasterCategory Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelDeactivate_MasterCategory Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate_MasterCategory");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate_MasterCategory");
		}
	}

	@Test(priority = 26)
	public void tcDeactivateRecords_MasterCategoryGrid_AfterCancel() {

		try {
			log.info("============= Strting tcDeactivateRecords_MasterCategoryGrid_AfterCancel Test===========");

			mastercategory.deactivateRecords_MasterCategoryGrid();

			log.info("============= Finished tcDeactivateRecords_MasterCategoryGrid_AfterCancel Test===========");
			getScreenShot("tcDeactivateRecords_MasterCategoryGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateRecords_MasterCategoryGrid_AfterCancel");
		}
	}

	@Test(priority = 27)
	public void tcYesDeactivateRecords_MasterCategory() {

		try {
			log.info("============= Strting tcYesDeactivateRecords_MasterCategory Test===========");

			mastercategory.yesDeactivateOrActivateRecords();

			log.info("============= Finished tcYesDeactivateRecords_MasterCategory Test===========");
			getScreenShot("tcYesDeactivateRecords_MasterCategory");
		} catch (Exception e) {
			getScreenShot("tcYesDeactivateRecords_MasterCategory");
		}
	}

	@Test(priority = 28)
	public void tcClickOnSuccessOkBtn_Deactivate_MasterCategory() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Deactivate_MasterCategory Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Deactivate_MasterCategory Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate_MasterCategory");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate_MasterCategory");
		}
	}

	@Test(priority = 29, dataProvider = "ExamMasterCategory_Form")
	public void tcFilterRecordWithCategoryName_MasterCategory_ForActivate(String categoryName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordWithCategoryName_MasterCategory_ForActivate Test===========");

			mastercategory.filterRecordWithCategoryName(categoryName);

			log.info(
					"============= Finished tcFilterRecordWithCategoryName_MasterCategory_ForActivate Test===========");
			getScreenShot("tcFilterRecordWithCategoryName_MasterCategory_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordWithCategoryName_MasterCategory_ForActivate");
		}
	}

	@Test(priority = 30)
	public void tcActivateRecords_MasterCategoryGrid() {

		try {
			log.info("============= Strting tcActivateRecords_MasterCategoryGrid Test===========");

			mastercategory.activateRecords_MasterCategoryGrid();

			log.info("============= Finished tcActivateRecords_MasterCategoryGrid Test===========");
			getScreenShot("tcActivateRecords_MasterCategoryGrid");
		} catch (Exception e) {
			getScreenShot("tcActivateRecords_MasterCategoryGrid");
		}
	}

	@Test(priority = 31)
	public void tcCancel_ActivatePopUp() {

		try {
			log.info("============= Strting tcCancel_ActivatePopUp Test===========");

			mastercategory.cancelDeactivationAndActivationOfRecord();

			log.info("============= Finished tcCancel_ActivatePopUp Test===========");
			getScreenShot("tcCancel_ActivatePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_ActivatePopUp");
		}
	}

	@Test(priority = 32)
	public void tcClickOnSuccessOkBtn_CancelActivate_MasterCategory() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelActivate_MasterCategory Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelActivate_MasterCategory Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate_MasterCategory");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate_MasterCategory");
		}
	}

	@Test(priority = 33)
	public void tcActivateRecords_MasterCategoryGrid_AfterCancel() {

		try {
			log.info("============= Strting tcActivateRecords_MasterCategoryGrid_AfterCancel Test===========");

			mastercategory.activateRecords_MasterCategoryGrid();

			log.info("============= Finished tcActivateRecords_MasterCategoryGrid_AfterCancel Test===========");
			getScreenShot("tcActivateRecords_MasterCategoryGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateRecords_MasterCategoryGrid_AfterCancel");
		}
	}

	@Test(priority = 34)
	public void tcYesActivateRecords_MasterCategory() {

		try {
			log.info("============= Strting tcYesActivateRecords_MasterCategory Test===========");

			mastercategory.yesDeactivateOrActivateRecords();

			log.info("============= Finished tcYesActivateRecords_MasterCategory Test===========");
			getScreenShot("tcYesActivateRecords_MasterCategory");
		} catch (Exception e) {
			getScreenShot("tcYesActivateRecords_MasterCategory");
		}
	}

	@Test(priority = 35)
	public void tcClickOnSuccessOkBtn_Activate_MasterCategory() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Activate_MasterCategory Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Activate_MasterCategory Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Activate_MasterCategory");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Activate_MasterCategory");
		}
	}

	/**
	 * CATEGORY CLASS MAPPING
	 */

	@Test(priority = 36)
	public void tcNavigateToCategoryClassMapping() {

		try {
			log.info("============= Strting tcNavigateToCategoryClassMapping Test===========");

			mastercategory.navigateToCategoryClassMapping();

			log.info("============= Finished tcNavigateToCategoryClassMapping Test===========");
			getScreenShot("tcNavigateToCategoryClassMapping");
		} catch (Exception e) {
			getScreenShot("tcNavigateToCategoryClassMapping");
		}
	}

	@Test(priority = 37)
	public void tcClickOnAddToSubmit_CategoryClassMappingForm_Blank() {

		try {
			log.info("============= Strting tcClickOnAddToSubmit_CategoryClassMappingForm_Blank Test===========");

			mastercategory.clickOnAddToSubmit_CategoryClassMappingForm();

			log.info("============= Finished tcClickOnAddToSubmit_CategoryClassMappingForm_Blank Test===========");
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_Blank");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_Blank");
		}
	}

	@Test(priority = 38, dataProvider = "ExamCategoryClassMapping_FormData")
	public void tcFill_CategoryClassMapping_Form(String academicYear, String Category, String class_ccm,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_CategoryClassMapping_Form Test===========");

			mastercategory.fill_CategoryClassMapping_Form(academicYear, Category, class_ccm);

			log.info("============= Finished tcFill_CategoryClassMapping_Form Test===========");
			getScreenShot("tcFill_CategoryClassMapping_Form");
		} catch (Exception e) {
			getScreenShot("tcFill_CategoryClassMapping_Form");
		}
	}

	@Test(priority = 39)
	public void tcClickOnClearButton_ToClearFilledForm_CategoryClassMapping() {

		try {
			log.info(
					"============= Strting tcClickOnClearButton_ToClearFilledForm_CategoryClassMapping Test===========");

			mastercategory.clickOnClearButton_ToClearFilledForm();

			log.info(
					"============= Finished tcClickOnClearButton_ToClearFilledForm_CategoryClassMapping Test===========");
			getScreenShot("tcClickOnClearButton_ToClearFilledForm_CategoryClassMapping");
		} catch (Exception e) {
			getScreenShot("tcClickOnClearButton_ToClearFilledForm_CategoryClassMapping");
		}
	}

	@Test(priority = 40, dataProvider = "ExamCategoryClassMapping_FormData")
	public void tcFill_CategoryClassMapping_Form_AfterClear(String academicYear, String Category, String class_ccm,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_CategoryClassMapping_Form_AfterClear Test===========");

			mastercategory.fill_CategoryClassMapping_Form(academicYear, Category, class_ccm);

			log.info("============= Finished tcFill_CategoryClassMapping_Form_AfterClear Test===========");
			getScreenShot("tcFill_CategoryClassMapping_Form_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcFill_CategoryClassMapping_Form_AfterClear");
		}
	}

	@Test(priority = 41)
	public void tcClickOnAddToSubmit_CategoryClassMappingForm_filled() {

		try {
			log.info("============= Strting tcClickOnAddToSubmit_CategoryClassMappingForm_filled Test===========");

			mastercategory.clickOnAddToSubmit_CategoryClassMappingForm();

			log.info("============= Finished tcClickOnAddToSubmit_CategoryClassMappingForm_filled Test===========");
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_filled");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_filled");
		}
	}

	@Test(priority = 42, dataProvider = "CategoryClassMapping_2ndData_ClassSection")
	public void tcSelectClassAndSection_ForSecondCategoryClassMapping(String academicYear, String Category,
			String class_ccm, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectClassAndSection_ForSecondCategoryClassMapping Test===========");

			mastercategory.selectClassAndSection_ForSecondCategoryClassMapping(academicYear, Category, class_ccm);

			log.info("============= Finished tcSelectClassAndSection_ForSecondCategoryClassMapping Test===========");
			getScreenShot("tcSelectClassAndSection_ForSecondCategoryClassMapping");
		} catch (Exception e) {
			getScreenShot("tcSelectClassAndSection_ForSecondCategoryClassMapping");
		}
	}

	@Test(priority = 43)
	public void tcClickOnAddToSubmit_CategoryClassMappingForm_ToAddSecondRecord() {

		try {
			log.info(
					"============= Strting tcClickOnAddToSubmit_CategoryClassMappingForm_ToAddSecondRecord Test===========");

			mastercategory.clickOnAddToSubmit_CategoryClassMappingForm();

			log.info(
					"============= Finished tcClickOnAddToSubmit_CategoryClassMappingForm_ToAddSecondRecord Test===========");
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_ToAddSecondRecord");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_ToAddSecondRecord");
		}
	}

	@Test(priority = 44)
	public void tcClickOnCancelToClear_CategoryClassMappingForm_AND_DetailsSection() {

		try {
			log.info(
					"============= Strting tcClickOnCancelToClear_CategoryClassMappingForm_AND_DetailsSection Test===========");

			mastercategory.clickOnCancelToClear_CategoryClassMappingForm_AND_DetailsSection();

			log.info(
					"============= Finished tcClickOnCancelToClear_CategoryClassMappingForm_AND_DetailsSection Test===========");
			getScreenShot("tcClickOnCancelToClear_CategoryClassMappingForm_AND_DetailsSection");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelToClear_CategoryClassMappingForm_AND_DetailsSection");
		}
	}

	@Test(priority = 45, dataProvider = "ExamCategoryClassMapping_FormData")
	public void tcFill_CategoryClassMapping_Form_AfterCancel(String academicYear, String Category, String class_ccm,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_CategoryClassMapping_Form_AfterCancel Test===========");

			mastercategory.fill_CategoryClassMapping_Form(academicYear, Category, class_ccm);

			log.info("============= Finished tcFill_CategoryClassMapping_Form_AfterCancel Test===========");
			getScreenShot("tcFill_CategoryClassMapping_Form_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_CategoryClassMapping_Form_AfterCancel");
		}
	}

	@Test(priority = 46)
	public void tcClickOnAddToSubmit_CategoryClassMappingForm_filled_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnAddToSubmit_CategoryClassMappingForm_filled_AfterCancel Test===========");

			mastercategory.clickOnAddToSubmit_CategoryClassMappingForm();

			log.info(
					"============= Finished tcClickOnAddToSubmit_CategoryClassMappingForm_filled_AfterCancel Test===========");
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_filled_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_filled_AfterCancel");
		}
	}

	@Test(priority = 47, dataProvider = "CategoryClassMapping_2ndData_ClassSection")
	public void tcSelectClassAndSection_ForSecondCategoryClassMapping_AfterCancel(String academicYear, String Category,
			String class_ccm, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectClassAndSection_ForSecondCategoryClassMapping_AfterCancel Test===========");

			mastercategory.selectClassAndSection_ForSecondCategoryClassMapping(academicYear, Category, class_ccm);

			log.info(
					"============= Finished tcSelectClassAndSection_ForSecondCategoryClassMapping_AfterCancel Test===========");
			getScreenShot("tcSelectClassAndSection_ForSecondCategoryClassMapping_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectClassAndSection_ForSecondCategoryClassMapping_AfterCancel");
		}
	}

	@Test(priority = 48)
	public void tcClickOnAddToSubmit_CategoryClassMappingForm_ToAddSecondRecord_AfterCancel() {

		try {
			log.info(
					"============= Strting tcClickOnAddToSubmit_CategoryClassMappingForm_ToAddSecondRecord_AfterCancel Test===========");

			mastercategory.clickOnAddToSubmit_CategoryClassMappingForm();

			log.info(
					"============= Finished tcClickOnAddToSubmit_CategoryClassMappingForm_ToAddSecondRecord_AfterCancel Test===========");
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_ToAddSecondRecord_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_ToAddSecondRecord_AfterCancel");
		}
	}

	@Test(priority = 49)
	public void tcEditRecordsAndUpdateSection_InDetailsSection() {

		try {
			log.info("============= Strting tcEditRecordsAndUpdateSection_InDetailsSection Test===========");

			mastercategory.editRecordsAndUpdateSection_InDetailsSection();

			log.info("============= Finished tcEditRecordsAndUpdateSection_InDetailsSection Test===========");
			getScreenShot("tcEditRecordsAndUpdateSection_InDetailsSection");
		} catch (Exception e) {
			getScreenShot("tcEditRecordsAndUpdateSection_InDetailsSection");
		}
	}

	@Test(priority = 50)
	public void tcClickOnAddToSubmit_CategoryClassMappingForm_EditDetailsSection() {

		try {
			log.info(
					"============= Strting tcClickOnAddToSubmit_CategoryClassMappingForm_EditDetailsSection Test===========");

			mastercategory.clickOnAddToSubmit_CategoryClassMappingForm();

			log.info(
					"============= Finished tcClickOnAddToSubmit_CategoryClassMappingForm_EditDetailsSection Test===========");
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_EditDetailsSection");
		} catch (Exception e) {
			getScreenShot("tcClickOnAddToSubmit_CategoryClassMappingForm_EditDetailsSection");
		}
	}

	@Test(priority = 51)
	public void tcDeleteRecordsFromDetailsSelection_CategoryClassMapping() {

		try {
			log.info("============= Strting tcDeleteRecordsFromDetailsSelection_CategoryClassMapping Test===========");

			mastercategory.deleteRecordsFromDetailsSelection();

			log.info("============= Finished tcDeleteRecordsFromDetailsSelection_CategoryClassMapping Test===========");
			getScreenShot("tcDeleteRecordsFromDetailsSelection_CategoryClassMapping");
		} catch (Exception e) {
			getScreenShot("tcDeleteRecordsFromDetailsSelection_CategoryClassMapping");
		}
	}

	@Test(priority = 52)
	public void tcClickOnSaveToSubmit_CategoryClassMappingForm() {

		try {
			log.info("============= Strting tcClickOnSaveToSubmit_CategoryClassMappingForm Test===========");

			mastercategory.clickOnSaveToSubmit_CategoryClassMappingForm();

			log.info("============= Finished tcClickOnSaveToSubmit_CategoryClassMappingForm Test===========");
			getScreenShot("tcClickOnSaveToSubmit_CategoryClassMappingForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveToSubmit_CategoryClassMappingForm");
		}
	}

	@Test(priority = 53)
	public void tcClickOnSuccessOkBtn_ForConfirmation_CategoryClassMapping() {

		try {
			log.info(
					"============= Strting tcClickOnSuccessOkBtn_ForConfirmation_CategoryClassMapping Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info(
					"============= Finished tcClickOnSuccessOkBtn_ForConfirmation_CategoryClassMapping Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_CategoryClassMapping");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_CategoryClassMapping");
		}
	}

	// GRID SORT,FILTER, VIEW(DEACTIVATE, ACTIVATE, CLOSE), EDIT

	@Test(priority = 54)
	public void tcSortWithAcademicYearInGridView() {

		try {
			log.info("============= Strting tcSortWithAcademicYearInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithAcademicYearInGridView");
			mastercategory.sortWithAcademicYearInGridView();

			log.info("============= Finished tcSortWithAcademicYearInGridView Test===========");
			getScreenShot("tcSortWithAcademicYearInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithAcademicYearInGridView");
		}
	}

	@Test(priority = 55)
	public void tcSortWithCategoryNameInGridView() {

		try {
			log.info("============= Strting tcSortWithCategoryNameInGridView Test===========");
			getScreenShot("_BeforeSorting_tcSortWithCategoryNameInGridView");
			mastercategory.sortWithCategoryNameInGridView();

			log.info("============= Finished tcSortWithCategoryNameInGridView Test===========");
			getScreenShot("tcSortWithCategoryNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithCategoryNameInGridView");
		}
	}

	@Test(priority = 56)
	public void tcSortWithClassNameInGridView() {

		try {
			log.info("============= Strting tcSortWithClassNameInGridView Test===========");
			getScreenShot("BeforeSorting_tcSortWithClassNameInGridView");
			mastercategory.sortWithClassNameInGridView();

			log.info("============= Finished tcSortWithClassNameInGridView Test===========");
			getScreenShot("tcSortWithClassNameInGridView");
		} catch (Exception e) {
			getScreenShot("tcSortWithClassNameInGridView");
		}
	}

	@Test(priority = 57, dataProvider = "ExamCategoryClassMapping_FormData")
	public void tcFilterRecordsBasedOn_AcademicYear(String academicYear, String categoryName, String className,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_AcademicYear Test===========");

			mastercategory.filterRecordsBasedOn_AcademicYear(academicYear, categoryName, className);

			log.info("============= Finished tcFilterRecordsBasedOn_AcademicYear Test===========");
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_AcademicYear");
		}
	}

	@Test(priority = 58)
	public void tcClearFilledDataForFilter_AcademicYear() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_AcademicYear Test===========");

			mastercategory.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_AcademicYear Test===========");
			getScreenShot("tcClearFilledDataForFilter_AcademicYear");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_AcademicYear");
		}
	}

	@Test(priority = 59, dataProvider = "ExamCategoryClassMapping_FormData")
	public void tcFilterRecordsBasedOn_CategoryName(String academicYear, String categoryName, String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_EmployeeName Test===========");

			mastercategory.filterRecordsBasedOn_CategoryName(academicYear, categoryName, className);

			log.info("============= Finished tcFilterRecordsBasedOn_EmployeeName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_EmployeeName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_EmployeeName");
		}
	}

	@Test(priority = 60)
	public void tcClearFilledDataForFilter_EmployeeName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_EmployeeName Test===========");

			mastercategory.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_EmployeeName Test===========");
			getScreenShot("tcClearFilledDataForFilter_EmployeeName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_EmployeeName");
		}
	}

	@Test(priority = 61, dataProvider = "ExamCategoryClassMapping_FormData")
	public void tcFilterRecordsBasedOn_ClassName(String academicYear, String categoryName, String className,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_ClassName Test===========");

			mastercategory.filterRecordsBasedOn_ClassName(academicYear, categoryName, className);

			log.info("============= Finished tcFilterRecordsBasedOn_ClassName Test===========");
			getScreenShot("tcFilterRecordsBasedOn_ClassName");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_ClassName");
		}
	}

	@Test(priority = 62)
	public void tcClearFilledDataForFilter_ClassName() {

		try {
			log.info("============= Strting tcClearFilledDataForFilter_ClassName Test===========");

			mastercategory.clearFilledDataForFilter();

			log.info("============= Finished tcClearFilledDataForFilter_ClassName Test===========");
			getScreenShot("tcClearFilledDataForFilter_ClassName");
		} catch (Exception e) {
			getScreenShot("tcClearFilledDataForFilter_ClassName");
		}
	}

	/**
	 * View, Edit and activate/deactivate
	 * 
	 */
	@Test(priority = 63, dataProvider = "ExamCategoryClassMapping_FormData")
	public void tcFilterRecordsBasedOn_CategoryName_ViewRecords(String academicYear, String categoryName, String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFilterRecordsBasedOn_CategoryName_ViewRecords Test===========");

			mastercategory.filterRecordsBasedOn_CategoryName(academicYear, categoryName, className);

			log.info("============= Finished tcFilterRecordsBasedOn_CategoryName_ViewRecords Test===========");
			getScreenShot("tcFilterRecordsBasedOn_CategoryName_ViewRecords");
		} catch (Exception e) {
			getScreenShot("tcFilterRecordsBasedOn_CategoryName_ViewRecords");
		}
	}
	
	@Test(priority = 64)
	public void tcClickOnViewIcon_ToSeeCategoryClassMappingDetailsAndActivationOrDeactivation() {

		try {
			log.info(
					"============= Strting tcClickOnViewIcon_ToSeeCategoryClassMappingDetailsAndActivationOrDeactivation Test===========");

			mastercategory.clickOnViewIcon_ToSeeCategoryClassMappingDetailsAndActivationOrDeactivation();
			log.info(
					"============= Finished tcClickOnViewIcon_ToSeeCategoryClassMappingDetailsAndActivationOrDeactivation Test===========");
			getScreenShot("tcClickOnViewIcon_ToSeeCategoryClassMappingDetailsAndActivationOrDeactivation");
		} catch (Exception e) {
			getScreenShot("tcClickOnViewIcon_ToSeeCategoryClassMappingDetailsAndActivationOrDeactivation");
		}
	}

	@Test(priority = 65)
	public void tcDeactivateRecords_ViewWindow() {

		try {
			log.info("============= Strting tcDeactivateRecords_ViewWindow Test===========");

			mastercategory.deactivateRecords_ViewWindow();

			log.info("============= Finished tcDeactivateRecords_ViewWindow Test===========");
			getScreenShot("tcDeactivateRecords_ViewWindow");
		} catch (Exception e) {
			getScreenShot("tcDeactivateRecords_ViewWindow");
		}
	}

	@Test(priority = 66)
	public void tcCancel_DeactivatePopUp() {

		try {
			log.info("============= Strting tcCancel_DeactivatePopUp Test===========");

			mastercategory.cancelDeactivationAndActivationOfRecord();

			log.info("============= Finished tcCancel_DeactivatePopUp Test===========");
			getScreenShot("tcCancel_DeactivatePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_DeactivatePopUp");
		}
	}

	@Test(priority = 67)
	public void tcClickOnSuccessOkBtn_CancelDeactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelDeactivate Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelDeactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelDeactivate");
		}
	}

	@Test(priority = 68)
	public void tcDeactivateRecords_ViewWindow_AfterCancel() {

		try {
			log.info("============= Strting tcDeactivateRecords_ViewWindow_AfterCancel Test===========");

			mastercategory.deactivateRecords_ViewWindow();

			log.info("============= Finished tcDeactivateRecords_ViewWindow_AfterCancel Test===========");
			getScreenShot("tcDeactivateRecords_ViewWindow_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateRecords_ViewWindow_AfterCancel");
		}
	}

	@Test(priority = 69)
	public void tcYesDeactivateCategoryClassMappingRecord() {

		try {
			log.info("============= Strting tcYesDeactivateCategoryClassMappingRecord Test===========");

			mastercategory.yesDeactivateOrActivateRecords();

			log.info("============= Finished tcYesDeactivateCategoryClassMappingRecord Test===========");
			getScreenShot("tcYesDeactivateCategoryClassMappingRecord");
		} catch (Exception e) {
			getScreenShot("tcYesDeactivateCategoryClassMappingRecord");
		}
	}

	@Test(priority = 70)
	public void tcClickOnSuccessOkBtn_Deactivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Deactivate Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Deactivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Deactivate");
		}
	}

	@Test(priority = 71)
	public void tcActivateRecords_ViewWindow() {

		try {
			log.info("============= Strting tcActivateRecords_ViewWindow Test===========");

			mastercategory.activateRecords_ViewWindow();

			log.info("============= Finished tcActivateRecords_ViewWindow Test===========");
			getScreenShot("tcActivateRecords_ViewWindow");
		} catch (Exception e) {
			getScreenShot("tcActivateRecords_ViewWindow");
		}
	}

	@Test(priority = 72)
	public void tcCancel_ActivatePopUp_viewWindow() {

		try {
			log.info("============= Strting tcCancel_ActivatePopUp_viewWindow Test===========");

			mastercategory.cancelDeactivationAndActivationOfRecord();

			log.info("============= Finished tcCancel_ActivatePopUp_viewWindow Test===========");
			getScreenShot("tcCancel_ActivatePopUp_viewWindow");
		} catch (Exception e) {
			getScreenShot("tcCancel_ActivatePopUp_viewWindow");
		}
	}

	@Test(priority = 73)
	public void tcClickOnSuccessOkBtn_CancelActivate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CancelActivate Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CancelActivate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CancelActivate");
		}
	}

	@Test(priority = 74)
	public void tcActivateRecords_ViewWindow_AfterCancel() {

		try {
			log.info("============= Strting tcActivateRecords_ViewWindow_AfterCancel Test===========");

			mastercategory.activateRecords_ViewWindow();

			log.info("============= Finished tcActivateRecords_ViewWindow_AfterCancel Test===========");
			getScreenShot("tcActivateRecords_ViewWindow_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateRecords_ViewWindow_AfterCancel");
		}
	}

	@Test(priority = 75)
	public void tcYesActivateCategoryClassMappingRecord() {

		try {
			log.info("============= Strting tcYesActivateCategoryClassMappingRecord Test===========");

			mastercategory.yesDeactivateOrActivateRecords();

			log.info("============= Finished tcYesActivateCategoryClassMappingRecord Test===========");
			getScreenShot("tcYesActivateCategoryClassMappingRecord");
		} catch (Exception e) {
			getScreenShot("tcYesActivateCategoryClassMappingRecord");
		}
	}

	@Test(priority = 76)
	public void tcClickOnSuccessOkBtn_Activate() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Activate Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Activate Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Activate");
		}
	}

	@Test(priority = 77)
	public void tcCloseViewWindow_CategoryClassMapping() {

		try {
			log.info("============= Strting tcCloseViewWindow_CategoryClassMapping Test===========");

			mastercategory.closeViewWindow_CategoryClassMapping();
			log.info("============= Finished tcCloseViewWindow_CategoryClassMapping Test===========");
			getScreenShot("tcCloseViewWindow_CategoryClassMapping");
		} catch (Exception e) {
			getScreenShot("tcCloseViewWindow_CategoryClassMapping");
		}
	}

	@Test(priority = 78)
	public void tcClickOnEditIcon_ToUpdateCategoryClassMapping() {

		try {
			log.info("============= Strting tcClickOnEditIcon_ToUpdateCategoryClassMapping Test===========");

			mastercategory.clickOnEditIcon_ToUpdateCategoryClassMapping();
			log.info("============= Finished tcClickOnEditIcon_ToUpdateCategoryClassMapping Test===========");
			getScreenShot("tcClickOnEditIcon_ToUpdateCategoryClassMapping");
		} catch (Exception e) {
			getScreenShot("tcClickOnEditIcon_ToUpdateCategoryClassMapping");
		}
	}

	@Test(priority = 79)
	public void tcClickOnSaveToSubmit_CategoryClassMappingForm_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveToSubmit_CategoryClassMappingForm_Edit Test===========");

			mastercategory.clickOnSaveToSubmit_CategoryClassMappingForm();
			log.info("============= Finished tcClickOnSaveToSubmit_CategoryClassMappingForm_Edit Test===========");

			getScreenShot("tcClickOnSaveToSubmit_CategoryClassMappingForm_Edit");

		} catch (Exception e) {
			getScreenShot("tcClickOnSaveToSubmit_CategoryClassMappingForm_Edit");
		}
	}

	@Test(priority = 80)
	public void tcClickOnSuccessOkBtn_ForConfirmation_Edit_CCMappingGrid() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_ForConfirmation_Edit_CCMappingGrid Test===========");

			mastercategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_ForConfirmation_Edit_CCMappingGrid Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit_CCMappingGrid");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_ForConfirmation_Edit_CCMappingGrid");
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
