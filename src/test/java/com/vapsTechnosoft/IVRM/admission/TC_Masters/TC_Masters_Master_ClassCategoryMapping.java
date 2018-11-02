/**
 * 
 */
package com.vapsTechnosoft.IVRM.admission.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Master_ClassCategoryMapping;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_ClassCategoryMapping extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Masters_Master_ClassCategoryMapping.class.getName());

	Masters_Master_ClassCategoryMapping masterclasscategory;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterClassCategoryData")
	public String[][] getTestData() {
		String[][] testRecordsCategoryDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterClassCategoryData");
		return testRecordsCategoryDetails;
	}

	@DataProvider(name = "MasterClassCategorySearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByClassCategoryData");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		masterclasscategory = new Masters_Master_ClassCategoryMapping(driver);
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

			boolean status = masterclasscategory.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterClassCategoryMapping_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterClassCategoryMapping_BGHS Test===========");

			masterclasscategory.navigateToAdmission_Masters_MasterClassCategoryMapping_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterClassCategoryMapping_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterClassCategoryMapping_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterClassCategoryMapping_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterClassCategoryMap_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterClassCategoryMap_BGHSPage Test===========");

			boolean status = masterclasscategory.verifyMasters_MasterClassCategoryMap_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterClassCategoryMap_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterClassCategoryMap_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterClassCategoryMap_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterClassCategoryMapForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterClassCategoryMapForm Test===========");

			masterclasscategory.submitBlankMasterClassCategoryMapForm();

			log.info("============= Finished tcSubmitBlankMasterClassCategoryMapForm Test===========");
			getScreenShot("tcSubmitBlankMasterClassCategoryMapForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterClassCategoryMapForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersMasterClassCategoryData")
	public void tcEnterMasterClassCategoryMappingFormData(String academicYear, String category, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterClassCategoryMappingFormData Test===========");

			masterclasscategory.enterMasterClassCategoryMappingFormData(academicYear, category);

			log.info("============= Finished tcEnterMasterClassCategoryMappingFormData Test===========");
			getScreenShot("tcEnterMasterClassCategoryMappingFormData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterClassCategoryMappingFormData");
		}
	}

	

	@Test(priority = 7)
	public void tcClearMasterClassCategoryMappingInfoData() {

		try {
			log.info("============= Strting tcClearMasterClassCategoryMappingInfoData Test===========");

			masterclasscategory.clearMasterClassCategoryMappingInfoData();

			log.info("============= Finished tcClearMasterClassCategoryMappingInfoData Test===========");
			getScreenShot("tcClearMasterClassCategoryMappingInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearMasterClassCategoryMappingInfoData");
		}
	}
	@Test(priority = 8)
	public void tcMinimizeMasterClassCategory() {

		try {
			log.info("============= Strting tcMinimizeMasterClassCategory Test===========");

			masterclasscategory.minimizeMasterClassCategory();

			log.info("============= Finished tcMinimizeMasterClassCategory Test===========");
			getScreenShot("tcMinimizeMasterClassCategory");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterClassCategory");
		}
	}
	@Test(priority = 9)
	public void tcSortByClassCategoryName() {

		try {
			log.info("============= Strting tcSortByClassCategoryName Test===========");
			getScreenShot("tcSortByClassCategoryName_BeforeSorting");

			masterclasscategory.sortByClassCategoryName();

			log.info("============= Finished tcSortByClassCategoryName Test===========");
			getScreenShot("tcSortByClassCategoryName");
		} catch (Exception e) {
			getScreenShot("tcSortByClassCategoryName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterClassCategory() {

		try {
			log.info("============= Strting tcMaximizeMasterClassCategory Test===========");

			masterclasscategory.maximizeMasterClassCategory();

			log.info("============= Finished tcMaximizeMasterClassCategory Test===========");
			getScreenShot("tcMaximizeMasterClassCategory");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterClassCategory");
		}
	}


	
	@Test(priority = 11)
	public void tcMinimizeMasterClassCategoryList() {

		try {
			log.info("============= Strting tcMinimizeMasterClassCategoryList Test===========");

			masterclasscategory.minimizeMasterClassCategoryList();

			log.info("============= Finished tcMinimizeMasterClassCategoryList Test===========");
			getScreenShot("tcMinimizeMasterClassCategoryList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterClassCategoryList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeMasterClassCategoryList() {

		try {
			log.info("============= Strting tcMaximizeMasterClassCategoryList Test===========");

			masterclasscategory.maximizeMasterClassCategoryList();

			log.info("============= Finished tcMaximizeMasterClassCategoryList Test===========");
			getScreenShot("tcMaximizeMasterClassCategoryList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterClassCategoryList");
		}
	}
	
	@Test(priority = 13, dataProvider = "MastersMasterClassCategoryData")
	public void tcEnterMasterClassCategoryMappingFormData_AfterClear(String academicYear, String category, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterClassCategoryMappingFormData_AfterClear Test===========");

			masterclasscategory.enterMasterClassCategoryMappingFormData(academicYear, category);

			log.info("============= Finished tcEnterMasterClassCategoryMappingFormData_AfterClear Test===========");
			getScreenShot("tcEnterMasterClassCategoryMappingFormData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterClassCategoryMappingFormData_AfterClear");
		}
	}

	@Test(priority = 14)
	public void tcSubmitFilledMasterClassCategoryMapForm() {

		try {
			log.info("============= Strting tcSubmitFilledMasterClassCategoryMapForm Test===========");

			masterclasscategory.submitFilledMasterClassCategoryMapForm();

			log.info("============= Finished tcSubmitFilledMasterClassCategoryMapForm Test===========");
			getScreenShot("tcSubmitFilledMasterClassCategoryMapForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterClassCategoryMapForm");
		}
	}
	@Test(priority = 15)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			masterclasscategory.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}
	@Test(priority = 16)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			masterclasscategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}
	
	@Test(priority = 17, dataProvider = "MasterClassCategorySearchData")
	public void tcSearchWithClassCategoryNameInTheGrid(String categoryName,String selectFilter, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassCategoryNameInTheGrid Test===========");

			masterclasscategory.searchWithClassCategoryNameInTheGrid(categoryName, selectFilter);

			log.info("============= Finished tcSearchWithClassCategoryNameInTheGrid Test===========");
			getScreenShot("tcSearchWithClassCategoryNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassCategoryNameInTheGrid");
		}
	}

	@Test(priority = 18, dataProvider = "MasterClassCategorySearchData")
	public void tcVerifyClassCategoryNameInTheGrid(String categoryName,String selectFilter, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyClassCategoryNameInTheGrid Test===========");

			masterclasscategory.verifyClassCategoryNameInTheGrid(categoryName, selectFilter);

			log.info("============= Finished tcVerifyClassCategoryNameInTheGrid Test===========");
			getScreenShot("tcVerifyClassCategoryNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyClassCategoryNameInTheGrid");
		}
	}
	@Test(priority = 19, dataProvider = "MasterClassCategorySearchData")
	public void tcEditMasterClassCategory(String categoryName,String selectFilter, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterClassCategory Test===========");

			masterclasscategory.editMasterClassCategory(categoryName, selectFilter);
			log.info("============= Finished tcEditMasterClassCategory Test===========");
			getScreenShot("tcEditMasterClassCategory");
		} catch (Exception e) {
			getScreenShot("tcEditMasterClassCategory");
		}
	}

	@Test(priority = 20)
	public void tcSubmitFilledMasterClassCategoryMapForm_Edit() {

		try {
			log.info("============= Strting tcSubmitFilledMasterClassCategoryMapForm_Edit Test===========");

			masterclasscategory.submitFilledMasterClassCategoryMapForm();

			log.info("============= Finished tcSubmitFilledMasterClassCategoryMapForm_Edit Test===========");
			getScreenShot("tcSubmitFilledMasterClassCategoryMapForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterClassCategoryMapForm_Edit");
		}
	}
	@Test(priority = 21)
	public void tcPopWindowMessage_SubmitSuccessfully_Edit_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");

			masterclasscategory.popWindowMessage_SubmitSuccessfully_Edit();

			log.info("============= Finished tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation");
		}
	}
	@Test(priority = 22)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			masterclasscategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}
	
	@Test(priority = 23, dataProvider = "MasterClassCategorySearchData")
	public void tcSearchWithClassCategoryNameInTheGrid_ForDeactivate(String categoryName,String selectFilter, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassCategoryNameInTheGrid_ForDeactivate Test===========");

			masterclasscategory.searchWithClassCategoryNameInTheGrid(categoryName, selectFilter);

			log.info("============= Finished tcSearchWithClassCategoryNameInTheGrid_ForDeactivate Test===========");
			getScreenShot("tcSearchWithClassCategoryNameInTheGrid_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassCategoryNameInTheGrid_ForDeactivate");
		}
	}

	@Test(priority = 24, dataProvider = "MasterClassCategorySearchData")
	public void tcDeactivateMasterClassCategory(String categoryName, String selectFilter,String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterClassCategory Test===========");

			masterclasscategory.deactivateMasterClassCategory(categoryName, selectFilter);

			log.info("============= Finished tcDeactivateMasterClassCategory Test===========");
			getScreenShot("tcDeactivateMasterClassCategory");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterClassCategory");
		}
	}

	@Test(priority = 25)
	public void tcClickOnCancelButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_deactivate Test===========");

			masterclasscategory.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_deactivate");
		}
	}

	@Test(priority = 26)
	public void tcClickOnOkSuccessButton_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivateCancel Test===========");

			masterclasscategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 27, dataProvider = "MasterClassCategorySearchData")
	public void tcSearchWithClassCategoryNameInTheGrid_ForDeactivate_AfterCancel(String categoryName,String selectFilter, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassCategoryNameInTheGrid_ForDeactivate_AfterCancel Test===========");

			masterclasscategory.searchWithClassCategoryNameInTheGrid(categoryName, selectFilter);

			log.info("============= Finished tcSearchWithClassCategoryNameInTheGrid_ForDeactivate_AfterCancel Test===========");
			getScreenShot("tcSearchWithClassCategoryNameInTheGrid_ForDeactivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassCategoryNameInTheGrid_ForDeactivate_AfterCancel");
		}
	}

	@Test(priority = 28, dataProvider = "MasterClassCategorySearchData")
	public void tcDeactivateMasterClassCategory_AfterCancel(String categoryName,String selectFilter, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterClassCategory_AfterCancel Test===========");

			masterclasscategory.deactivateMasterClassCategory(categoryName, selectFilter);

			log.info("============= Finished tcDeactivateMasterClassCategory_AfterCancel Test===========");
			getScreenShot("tcDeactivateMasterClassCategory_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterClassCategory_AfterCancel");
		}
	}

	@Test(priority = 29)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			masterclasscategory.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}
	@Test(priority = 30)
	public void tcPopWindowMessage_DeactivatedSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_DeactivatedSuccessfully_Validation Test===========");

			masterclasscategory.popWindowMessage_DeactivatedSuccessfully();

			log.info("============= Finished tcPopWindowMessage_DeactivatedSuccessfully_Validation Test===========");
			getScreenShot("tcPopWindowMessage_DeactivatedSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_DeactivatedSuccessfully_Validation");
		}
	}

	@Test(priority = 31)
	public void tcClickOnOkSuccessButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivate Test===========");

			masterclasscategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}
	
	@Test(priority = 32, dataProvider = "MasterClassCategorySearchData")
	public void tcSearchWithClassCategoryNameInTheGrid_ForActivate(String categoryName,String selectFilter,String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassCategoryNameInTheGrid_ForActivate Test===========");

			masterclasscategory.searchWithClassCategoryNameInTheGrid(categoryName, selectFilter);

			log.info("============= Finished tcSearchWithClassCategoryNameInTheGrid_ForActivate Test===========");
			getScreenShot("tcSearchWithClassCategoryNameInTheGrid_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassCategoryNameInTheGrid_ForActivate");
		}
	}

	@Test(priority = 33, dataProvider = "MasterClassCategorySearchData")
	public void tcActivateMasterClassCategory(String categoryName,String selectFilter, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterClassCategory Test===========");

			masterclasscategory.activateMasterClassCategory(categoryName, selectFilter);

			log.info("============= Finished tcActivateMasterClassCategory Test===========");
			getScreenShot("tcActivateMasterClassCategory");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterClassCategory");
		}
	}

	@Test(priority = 34)
	public void tcClickOnCancelButton_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_activate Test===========");

			masterclasscategory.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_activate Test===========");
			getScreenShot("tcClickOnCancelButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_activate");
		}
	}

	@Test(priority = 35)
	public void tcClickOnOkSuccessButton_activateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activateCancel Test===========");

			masterclasscategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 36, dataProvider = "MasterClassCategorySearchData")
	public void tcSearchWithClassCategoryNameInTheGrid_ForActivate_AfterCancel(String categoryName,String selectFilter, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassCategoryNameInTheGrid_ForActivate_AfterCancel Test===========");

			masterclasscategory.searchWithClassCategoryNameInTheGrid(categoryName, selectFilter);

			log.info("============= Finished tcSearchWithClassCategoryNameInTheGrid_ForActivate_AfterCancel Test===========");
			getScreenShot("tcSearchWithClassCategoryNameInTheGrid_ForActivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassCategoryNameInTheGrid_ForActivate_AfterCancel");
		}
	}

	@Test(priority = 37, dataProvider = "MasterClassCategorySearchData")
	public void tcActivateMasterClassCategory_AfterCancel(String categoryName,String selectFilter, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterClassCategory_AfterCancel Test===========");

			masterclasscategory.activateMasterClassCategory(categoryName, selectFilter);
			log.info("============= Finished tcActivateMasterClassCategory_AfterCancel Test===========");
			getScreenShot("tcActivateMasterClassCategory_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterClassCategory_AfterCancel");
		}
	}

	@Test(priority = 38)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			masterclasscategory.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}
	@Test(priority = 39)
	public void tcPopWindowMessage_ActivatedSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_ActivatedSuccessfully_Validation Test===========");

			masterclasscategory.popWindowMessage_ActivatedSuccessfully();

			log.info("============= Finished tcPopWindowMessage_ActivatedSuccessfully_Validation Test===========");
			getScreenShot("tcPopWindowMessage_ActivatedSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_ActivatedSuccessfully_Validation");
		}
	}

	@Test(priority = 40)
	public void tcClickOnOkSuccessButton_activate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activate Test===========");

			masterclasscategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activate");
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
