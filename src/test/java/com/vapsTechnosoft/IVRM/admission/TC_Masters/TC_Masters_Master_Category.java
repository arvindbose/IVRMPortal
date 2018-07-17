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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Master_Category;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Category extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Masters_Master_Category.class.getName());

	Masters_Master_Category mastercategory;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterCategoryData")
	public String[][] getTestData() {
		String[][] testRecordsCategoryDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterCategoryInfoData");
		return testRecordsCategoryDetails;
	}

	@DataProvider(name = "MasterCategorySearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByCategoryNameData");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		mastercategory = new Masters_Master_Category(driver);
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
	public void tcNavigateToAdmission_Masters_MasterCategory_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterCategory_BGHS Test===========");

			mastercategory.navigateToAdmission_Masters_MasterCategory_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterCategory_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterCategory_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterCategory_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterCategory_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterCategory_BGHSPage Test===========");

			boolean status = mastercategory.verifyMasters_MasterCategory_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterCategory_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterCategory_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_Category_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterCategoryForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterCategoryForm Test===========");

			mastercategory.submitBlankMasterCategoryForm();

			log.info("============= Finished tcSubmitBlankMasterCategoryForm Test===========");
			getScreenShot("tcSubmitBlankMasterCategoryForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterCategoryForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersMasterCategoryData")
	public void tcEnterMasterCategoryFormData(String categoryName, String selectInstitution, String addressLine1,
			String addressLine2,String addressLine3,String addressLine4, String selectType, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterCategoryFormData Test===========");

			mastercategory.enterMasterCategoryFormData(categoryName, selectInstitution, addressLine1, addressLine2, addressLine3, addressLine4, selectType);

			log.info("============= Finished tcEnterMasterCategoryFormData Test===========");
			getScreenShot("tcEnterMasterCategoryFormData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterCategoryFormData");
		}
	}

	@Test(priority = 7)
	public void tcClearCategoryInfoData() {

		try {
			log.info("============= Strting tcClearCategoryInfoData Test===========");

			mastercategory.clearCategoryInfoData();

			log.info("============= Finished tcClearCategoryInfoData Test===========");
			getScreenShot("tcClearCategoryInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearCategoryInfoData");
		}
	}
	@Test(priority = 8)
	public void tcMinimizeMasterCategory() {

		try {
			log.info("============= Strting tcMinimizeMasterCategory Test===========");

			mastercategory.minimizeMasterCategory();

			log.info("============= Finished tcMinimizeMasterCategory Test===========");
			getScreenShot("tcMinimizeMasterCategory");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterCategory");
		}
	}
	@Test(priority = 9)
	public void tcSortByCategoryName() {

		try {
			log.info("============= Strting tcSortByCategoryName Test===========");
			getScreenShot("tcSortByCategoryName_BeforeSorting");

			mastercategory.sortByCategoryName();

			log.info("============= Finished tcSortByCategoryName Test===========");
			getScreenShot("tcSortByCategoryName");
		} catch (Exception e) {
			getScreenShot("tcSortByCategoryName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterCategory() {

		try {
			log.info("============= Strting tcMaximizeMasterCategory Test===========");

			mastercategory.maximizeMasterCategory();

			log.info("============= Finished tcMaximizeMasterCategory Test===========");
			getScreenShot("tcMaximizeMasterCategory");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterCategory");
		}
	}


	
	@Test(priority = 11)
	public void tcMinimizeMasterCategoryList() {

		try {
			log.info("============= Strting tcMinimizeMasterCategoryList Test===========");

			mastercategory.minimizeMasterCategoryList();

			log.info("============= Finished tcMinimizeMasterCategoryList Test===========");
			getScreenShot("tcMinimizeMasterCategoryList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterCategoryList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeMasterCategoryList() {

		try {
			log.info("============= Strting tcMaximizeMasterCategoryList Test===========");

			mastercategory.maximizeMasterCategoryList();

			log.info("============= Finished tcMaximizeMasterCategoryList Test===========");
			getScreenShot("tcMaximizeMasterCategoryList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterCategoryList");
		}
	}
	
	
	@Test(priority = 13, dataProvider = "MastersMasterCategoryData")
	public void tcEnterMasterCategoryFormData_AfterClear(String categoryName, String selectInstitution, String addressLine1,
			String addressLine2,String addressLine3,String addressLine4, String selectType, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterCategoryFormData_AfterClear Test===========");

			mastercategory.enterMasterCategoryFormData(categoryName, selectInstitution, addressLine1, addressLine2, addressLine3, addressLine4, selectType);

			log.info("============= Finished tcEnterMasterCategoryFormData_AfterClear Test===========");
			getScreenShot("tcEnterMasterCategoryFormData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterCategoryFormData_AfterClear");
		}
	}
	
	@Test(priority = 14)
	public void tcSubmitFilledMasterCategoryForm() {

		try {
			log.info("============= Strting tcSubmitFilledMasterCategoryForm Test===========");

			mastercategory.submitFilledMasterCategoryForm();

			log.info("============= Finished tcSubmitFilledMasterCategoryForm Test===========");
			getScreenShot("tcSubmitFilledMasterCategoryForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterCategoryForm");
		}
	}

	@Test(priority = 15)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			mastercategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}
	
	
	

	@Test(priority = 16, dataProvider = "MasterCategorySearchData")
	public void tcSearchWithCategoryNameInTheGrid(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCategoryNameInTheGrid Test===========");

			mastercategory.searchWithCategoryNameInTheGrid(categoryName);

			log.info("============= Finished tcSearchWithCategoryNameInTheGrid Test===========");
			getScreenShot("tcSearchWithCategoryNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCategoryNameInTheGrid");
		}
	}

	@Test(priority = 17, dataProvider = "MasterCategorySearchData")
	public void tcVerifyCategoryNameInTheGrid(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyCategoryNameInTheGrid Test===========");

			mastercategory.verifyCategoryNameInTheGrid(categoryName);

			log.info("============= Finished tcVerifyCategoryNameInTheGrid Test===========");
			getScreenShot("tcVerifyCategoryNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyCategoryNameInTheGrid");
		}
	}

	@Test(priority = 18, dataProvider = "MasterCategorySearchData")
	public void tcEditMasterCategory(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterCategory Test===========");

			mastercategory.editMasterCategory(categoryName);
			log.info("============= Finished tcEditMasterCategory Test===========");
			getScreenShot("tcEditMasterCategory");
		} catch (Exception e) {
			getScreenShot("tcEditMasterCategory");
		}
	}

	@Test(priority = 19)
	public void tcSubmitFilledMasterCategoryForm_Edit() {

		try {
			log.info("============= Strting tcSubmitFilledMasterCategoryForm_Edit Test===========");

			mastercategory.submitFilledMasterCategoryForm();

			log.info("============= Finished tcSubmitFilledMasterCategoryForm_Edit Test===========");
			getScreenShot("tcSubmitFilledMasterCategoryForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcSubmitFilledMasterCategoryForm_Edit");
		}
	}

	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			mastercategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}
	
	//
	
	@Test(priority = 21, dataProvider = "MasterCategorySearchData")
	public void tcSearchWithCategoryNameInTheGrid_ForDeactivate(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCategoryNameInTheGrid_ForDeactivate Test===========");

			mastercategory.searchWithCategoryNameInTheGrid(categoryName);

			log.info("============= Finished tcSearchWithCategoryNameInTheGrid_ForDeactivate Test===========");
			getScreenShot("tcSearchWithCategoryNameInTheGrid_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCategoryNameInTheGrid_ForDeactivate");
		}
	}

	@Test(priority = 22, dataProvider = "MasterCategorySearchData")
	public void tcDeactivateMasterCategory(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterCategory Test===========");

			mastercategory.deactivateMasterCategory(categoryName);

			log.info("============= Finished tcDeactivateMasterCategory Test===========");
			getScreenShot("tcDeactivateMasterCategory");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterCategory");
		}
	}

	@Test(priority = 23)
	public void tcClickOnCancelButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_deactivate Test===========");

			mastercategory.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_deactivate");
		}
	}

	@Test(priority = 24)
	public void tcClickOnOkSuccessButton_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivateCancel Test===========");

			mastercategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 25, dataProvider = "MasterCategorySearchData")
	public void tcSearchWithCategoryNameInTheGrid_ForDeactivate_AfterCancel(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCategoryNameInTheGrid_ForDeactivate_AfterCancel Test===========");

			mastercategory.searchWithCategoryNameInTheGrid(categoryName);

			log.info("============= Finished tcSearchWithCategoryNameInTheGrid_ForDeactivate_AfterCancel Test===========");
			getScreenShot("tcSearchWithCategoryNameInTheGrid_ForDeactivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCategoryNameInTheGrid_ForDeactivate_AfterCancel");
		}
	}

	@Test(priority = 26, dataProvider = "MasterCategorySearchData")
	public void tcDeactivateMasterCategory_AfterCancel(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterCategory_AfterCancel Test===========");

			mastercategory.deactivateMasterCategory(categoryName);

			log.info("============= Finished tcDeactivateMasterCategory_AfterCancel Test===========");
			getScreenShot("tcDeactivateMasterCategory_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterCategory_AfterCancel");
		}
	}

	@Test(priority = 27)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			mastercategory.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}

	@Test(priority = 28)
	public void tcClickOnOkSuccessButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivate Test===========");

			mastercategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}
	
	@Test(priority = 29, dataProvider = "MasterCategorySearchData")
	public void tcSearchWithCategoryNameInTheGrid_ForActivate(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCategoryNameInTheGrid_ForActivate Test===========");

			mastercategory.searchWithCategoryNameInTheGrid(categoryName);

			log.info("============= Finished tcSearchWithCategoryNameInTheGrid_ForActivate Test===========");
			getScreenShot("tcSearchWithCategoryNameInTheGrid_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCategoryNameInTheGrid_ForActivate");
		}
	}

	@Test(priority = 30, dataProvider = "MasterCategorySearchData")
	public void tcActivateMasterCategory(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterCategory Test===========");

			mastercategory.activateMasterCategory(categoryName);

			log.info("============= Finished tcActivateMasterCategory Test===========");
			getScreenShot("tcActivateMasterCategory");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterCategory");
		}
	}

	@Test(priority = 31)
	public void tcClickOnCancelButton_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_activate Test===========");

			mastercategory.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_activate Test===========");
			getScreenShot("tcClickOnCancelButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_activate");
		}
	}

	@Test(priority = 32)
	public void tcClickOnOkSuccessButton_activateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activateCancel Test===========");

			mastercategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 33, dataProvider = "MasterCategorySearchData")
	public void tcSearchWithCategoryNameInTheGrid_ForActivate_AfterCancel(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCategoryNameInTheGrid_ForActivate_AfterCancel Test===========");

			mastercategory.searchWithCategoryNameInTheGrid(categoryName);

			log.info("============= Finished tcSearchWithCategoryNameInTheGrid_ForActivate_AfterCancel Test===========");
			getScreenShot("tcSearchWithCategoryNameInTheGrid_ForActivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCategoryNameInTheGrid_ForActivate_AfterCancel");
		}
	}

	@Test(priority = 34, dataProvider = "MasterCategorySearchData")
	public void tcActivateMasterCategory_AfterCancel(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterCategory_AfterCancel Test===========");

			mastercategory.activateMasterCategory(categoryName);
			log.info("============= Finished tcActivateMasterCategory_AfterCancel Test===========");
			getScreenShot("tcActivateMasterCategory_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterCategory_AfterCancel");
		}
	}

	@Test(priority = 35)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			mastercategory.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}

	@Test(priority = 36)
	public void tcClickOnOkSuccessButton_activate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activate Test===========");

			mastercategory.clickOnOkSuccessButton();

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
