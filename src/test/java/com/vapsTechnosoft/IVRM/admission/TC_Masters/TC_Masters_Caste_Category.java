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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Caste_Category;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Caste_Category extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_Caste_Category.class.getName());

	Masters_Caste_Category mastercastecategory;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersCasteCategoryData")
	public String[][] getTestData() {
		String[][] testRecordsCasteCategoryDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_CasteCategoryInfoData");
		return testRecordsCasteCategoryDetails;
	}

	@DataProvider(name = "CasteCategorySearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByCasteCategoryName");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		mastercastecategory = new Masters_Caste_Category(driver);
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

			boolean status = mastercastecategory.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_CasteCategory_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_CasteCategory_BGHS Test===========");

			mastercastecategory.navigateToAdmission_Masters_CasteCategory_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_CasteCategory_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_CasteCategory_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_CasteCategory_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_CasteCategory_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_CasteCategory_BGHSPage Test===========");

			boolean status = mastercastecategory.verifyMasters_CasteCategory_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_CasteCategory_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_CasteCategory_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_CasteCategory_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterCasteCategoryForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterCasteCategoryForm Test===========");

			mastercastecategory.submitBlankMasterCasteCategoryForm();

			log.info("============= Finished tcSubmitBlankMasterCasteCategoryForm Test===========");
			getScreenShot("tcSubmitBlankMasterCasteCategoryForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterCasteCategoryForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersCasteCategoryData")
	public void tcEnterMasterCasteCategoryDetailsData(String casteCategoryName, String casteCategoryDescription,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterCasteCategoryDetailsData Test===========");

			mastercastecategory.enterMasterCasteCategoryDetailsData(casteCategoryName, casteCategoryDescription);

			log.info("============= Finished tcEnterMasterCasteCategoryDetailsData Test===========");
			getScreenShot("tcEnterMasterCasteCategoryDetailsData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterCasteCategoryDetailsData");
		}
	}

	//
	@Test(priority = 7)
	public void tcClearCasteCategoryInfoData() {

		try {
			log.info("============= Strting tcClearCasteCategoryInfoData Test===========");

			mastercastecategory.clearCasteCategoryInfoData();

			log.info("============= Finished tcClearCasteCategoryInfoData Test===========");
			getScreenShot("tcClearCasteCategoryInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearCasteCategoryInfoData");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeMasterCasteCategory() {

		try {
			log.info("============= Strting tcMinimizeMasterCasteCategory Test===========");

			mastercastecategory.minimizeMasterCasteCategory();

			log.info("============= Finished tcMinimizeMasterCasteCategory Test===========");
			getScreenShot("tcMinimizeMasterCasteCategory");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterCasteCategory");
		}
	}

	@Test(priority = 9)
	public void tcSortByCasteCategoryName() {

		try {
			log.info("============= Strting tcSortByCasteCategoryName Test===========");
			getScreenShot("tcSortByCasteCategoryName_BeforeSorting");

			mastercastecategory.sortByCasteCategoryName();

			log.info("============= Finished tcSortByCasteCategoryName Test===========");
			getScreenShot("tcSortByCasteCategoryName");
		} catch (Exception e) {
			getScreenShot("tcSortByCasteCategoryName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterCasteCategory() {

		try {
			log.info("============= Strting tcMaximizeMasterCasteCategory Test===========");

			mastercastecategory.maximizeMasterCasteCategory();

			log.info("============= Finished tcMaximizeMasterCasteCategory Test===========");
			getScreenShot("tcMaximizeMasterCasteCategory");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterCasteCategory");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeCasteCategoryList() {

		try {
			log.info("============= Strting tcMinimizeCasteCategoryList Test===========");

			mastercastecategory.minimizeCasteCategoryList();

			log.info("============= Finished tcMinimizeCasteCategoryList Test===========");
			getScreenShot("tcMinimizeCasteCategoryList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeCasteCategoryList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeCasteCategoryList() {

		try {
			log.info("============= Strting tcMaximizeCasteCategoryList Test===========");

			mastercastecategory.maximizeCasteCategoryList();

			log.info("============= Finished tcMaximizeCasteCategoryList Test===========");
			getScreenShot("tcMaximizeCasteCategoryList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeCasteCategoryList");
		}
	}

	@Test(priority = 13, dataProvider = "MastersCasteCategoryData")
	public void tcEnterMasterCasteCategoryDetailsData_AfterClear(String casteCategoryName,
			String casteCategoryDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterCasteCategoryDetailsData_AfterClear Test===========");

			mastercastecategory.enterMasterCasteCategoryDetailsData(casteCategoryName, casteCategoryDescription);

			log.info("============= Finished tcEnterMasterCasteCategoryDetailsData_AfterClear Test===========");
			getScreenShot("tcEnterMasterCasteCategoryDetailsData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterCasteCategoryDetailsData_AfterClear");
		}
	}

	@Test(priority = 14)
	public void tcSaveCasteCategoryInfoData() {

		try {
			log.info("============= Strting tcSaveCasteCategoryInfoData Test===========");

			mastercastecategory.saveCasteCategoryInfoData();

			log.info("============= Finished tcSaveCasteCategoryInfoData Test===========");
			getScreenShot("tcSaveCasteCategoryInfoData");
		} catch (Exception e) {
			getScreenShot("tcSaveCasteCategoryInfoData");
		}
	}

	@Test(priority = 15)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			mastercastecategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	@Test(priority = 16, dataProvider = "CasteCategorySearchData")
	public void tcSearchWithCasteCategoryNameInTheGrid(String casteCategoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCasteCategoryNameInTheGrid Test===========");

			mastercastecategory.searchWithCasteCategoryNameInTheGrid(casteCategoryName);

			log.info("============= Finished tcSearchWithCasteCategoryNameInTheGrid Test===========");
			getScreenShot("tcSearchWithCasteCategoryNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCasteCategoryNameInTheGrid");
		}
	}

	@Test(priority = 17, dataProvider = "CasteCategorySearchData")
	public void tcVerifyCasteCategoryNameInTheGrid(String casteCategoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyCasteCategoryNameInTheGrid Test===========");

			mastercastecategory.verifyCasteCategoryNameInTheGrid(casteCategoryName);

			log.info("============= Finished tcVerifyCasteCategoryNameInTheGrid Test===========");
			getScreenShot("tcVerifyCasteCategoryNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyCasteCategoryNameInTheGrid");
		}
	}

	@Test(priority = 18, dataProvider = "CasteCategorySearchData")
	public void tcEditMasterCasteCategory(String casteCategoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterCasteCategory Test===========");

			mastercastecategory.editMasterCasteCategory(casteCategoryName);

			log.info("============= Finished tcEditMasterCasteCategory Test===========");
			getScreenShot("tcEditMasterCasteCategory");
		} catch (Exception e) {
			getScreenShot("tcEditMasterCasteCategory");
		}
	}

	@Test(priority = 19)
	public void tcSaveCasteCategoryInfoData_Edit() {

		try {
			log.info("============= Strting tcSaveCasteCategoryInfoData_Edit Test===========");

			mastercastecategory.saveCasteCategoryInfoData();

			log.info("============= Finished tcSaveCasteCategoryInfoData_Edit Test===========");
			getScreenShot("tcSaveCasteCategoryInfoData_Edit");
		} catch (Exception e) {
			getScreenShot("tcSaveCasteCategoryInfoData_Edit");
		}
	}

	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			mastercastecategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	@Test(priority = 21, dataProvider = "CasteCategorySearchData")
	public void tcSearchWithCasteCategoryNameInTheGrid_delete(String casteCategoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCasteCategoryNameInTheGrid_delete Test===========");

			mastercastecategory.searchWithCasteCategoryNameInTheGrid(casteCategoryName);

			log.info("============= Finished tcSearchWithCasteCategoryNameInTheGrid_delete Test===========");
			getScreenShot("tcSearchWithCasteCategoryNameInTheGrid_delete");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCasteCategoryNameInTheGrid_delete");
		}
	}

	@Test(priority = 22, dataProvider = "CasteCategorySearchData")
	public void tcDeleteMasterCasteCategory(String casteCategoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterCasteCategory Test===========");

			mastercastecategory.deleteMasterCasteCategory(casteCategoryName);

			log.info("============= Finished tcDeleteMasterCasteCategory Test===========");
			getScreenShot("tcDeleteMasterCasteCategory");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterCasteCategory");
		}
	}

	@Test(priority = 23)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			mastercastecategory.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton Test===========");
			getScreenShot("tcClickOnCancelButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton");
		}
	}

	@Test(priority = 24)
	public void tcClickOnOkSuccessButton_cancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_cancel Test===========");

			mastercastecategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_cancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		}
	}

	@Test(priority = 25, dataProvider = "CasteCategorySearchData")
	public void tcDeleteMasterCasteCategory_AfterCancel(String casteCategoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterCasteCategory_AfterCancel Test===========");

			mastercastecategory.deleteMasterCasteCategory(casteCategoryName);

			log.info("============= Finished tcDeleteMasterCasteCategory_AfterCancel Test===========");
			getScreenShot("tcDeleteMasterCasteCategory_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterCasteCategory_AfterCancel");
		}
	}

	@Test(priority = 26)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			mastercastecategory.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}

	@Test(priority = 27)
	public void tcClickOnOkSuccessButton_delete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_delete Test===========");

			mastercastecategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}

	@Test(priority = 28, dataProvider = "MastersCasteCategoryData")
	public void tcEnterMasterCasteCategoryDetailsData_AfterDelete(String casteCategoryName,
			String casteCategoryDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterCasteCategoryDetailsData_AfterDelete Test===========");

			mastercastecategory.enterMasterCasteCategoryDetailsData(casteCategoryName, casteCategoryDescription);

			log.info("============= Finished tcEnterMasterCasteCategoryDetailsData_AfterDelete Test===========");
			getScreenShot("tcEnterMasterCasteCategoryDetailsData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterCasteCategoryDetailsData_AfterDelete");
		}
	}

	@Test(priority = 29)
	public void tcSaveCasteCategoryInfoData_AfterDelete() {

		try {
			log.info("============= Strting tcSaveCasteCategoryInfoData_AfterDelete Test===========");

			mastercastecategory.saveCasteCategoryInfoData();

			log.info("============= Finished tcSaveCasteCategoryInfoData_AfterDelete Test===========");
			getScreenShot("tcSaveCasteCategoryInfoData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSaveCasteCategoryInfoData_AfterDelete");
		}
	}

	@Test(priority = 30)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			mastercastecategory.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_AfterDelete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_AfterDelete");
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
