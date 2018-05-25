/**
 * 
 */
package com.test.automation.uiAutomation.admission.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Admission.Masters.Masters_Master_Class;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Class extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_Master_Class.class.getName());

	Masters_Master_Class masterclass;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterClassData")
	public String[][] getTestData() {
		String[][] testRecordsClassDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterClassData");
		return testRecordsClassDetails;
	}

	@DataProvider(name = "MasterClassMaxAgeData")
	public String[][] getTestMaxAgeData() {
		String[][] testRecordsMaxAge = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterClassMaxAgeData");
		return testRecordsMaxAge;
	}

	@DataProvider(name = "MasterClassMinAgeData")
	public String[][] getTestMinAgeData() {
		String[][] testRecordsMinAge = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterClassMinAgeData");
		return testRecordsMinAge;
	}

	@DataProvider(name = "MasterClassSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterClassSearchData");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		masterclass = new Masters_Master_Class(driver);
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

			boolean status = masterclass.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterClass_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterClass_BGHS Test===========");

			masterclass.navigateToAdmission_Masters_MasterClass_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterClass_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterClass_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterClass_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterClass_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterClass_BGHSPage Test===========");

			boolean status = masterclass.verifyMasters_MasterClass_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterClass_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterClass_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterClass_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterClassForm() {

		try {
			log.info("============= Starting tcSubmitBlankMasterClassForm Test===========");

			masterclass.submitBlankMasterClassForm();

			log.info("============= Finished tcSubmitBlankMasterClassForm Test===========");
			getScreenShot("tcSubmitBlankMasterClassForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterClassForm");
		}
	}
	
	@Test(priority = 6, dataProvider = "MastersMasterClassData")
	public void tcEnterMasterClassRequiredFormData(String className, String classOrder, String classCode,
			String classCapacity, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterClassRequiredFormData Test===========");

			masterclass.enterMasterClassRequiredFormData(className, classOrder, classCode, classCapacity);

			log.info("============= Finished tcEnterMasterClassRequiredFormData Test===========");
			getScreenShot("tcEnterMasterClassRequiredFormData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterClassRequiredFormData");
		}
	}

	@Test(priority = 7, dataProvider = "MasterClassMaxAgeData")
	public void tcSelectMaximumAgeForClass(String maxAgeYear, String maxAgeMonth, String maxAgeDay, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectMaximumAgeForClass Test===========");

			masterclass.selectMaximumAgeForClass(maxAgeYear, maxAgeMonth, maxAgeDay);

			log.info("============= Finished tcSelectMaximumAgeForClass Test===========");
			getScreenShot("tcSelectMaximumAgeForClass");
		} catch (Exception e) {
			getScreenShot("tcSelectMaximumAgeForClass");
		}
	}

	@Test(priority = 8, dataProvider = "MasterClassMinAgeData")
	public void tcSelectMinimumAgeForClass(String minAgeYear, String minAgeMonth, String minAgeDay, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectMinimumAgeForClass Test===========");

			masterclass.selectMinimumAgeForClass(minAgeYear, minAgeMonth, minAgeDay);

			log.info("============= Finished tcSelectMinimumAgeForClass Test===========");
			getScreenShot("tcSelectMinimumAgeForClass");
		} catch (Exception e) {
			getScreenShot("tcSelectMinimumAgeForClass");
		}
	}

	@Test(priority = 9)
	public void tcClickOnClearButton() {

		try {
			log.info("============= Strting tcClickOnClearButton Test===========");

			masterclass.clickOnClearButton();

			log.info("============= Finished tcClickOnClearButton Test===========");
			getScreenShot("tcClickOnClearButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnClearButton");
		}
	}

	@Test(priority = 10)
	public void tcMinimizeMasterClass() {

		try {
			log.info("============= Strting tcMinimizeMasterClass Test===========");

			masterclass.minimizeMasterClass();

			log.info("============= Finished tcMinimizeMasterClass Test===========");
			getScreenShot("tcMinimizeMasterClass");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterClass");
		}
	}
	
	@Test(priority = 11)
	public void tcSortByClasName() {

		try {
			log.info("============= Strting tcSortByClasName Test===========");
			getScreenShot("tcSortByClasName_BeforeSorting");

			masterclass.sortByClasName();

			log.info("============= Finished tcSortByClasName Test===========");
			getScreenShot("tcSortByClasName");
		} catch (Exception e) {
			getScreenShot("tcSortByClasName");
		}
	}
	

	@Test(priority = 12)
	public void tcMaximizeMasterClass() {

		try {
			log.info("============= Strting tcMaximizeMasterClass Test===========");

			masterclass.maximizeMasterClass();

			log.info("============= Finished tcMaximizeMasterClass Test===========");
			getScreenShot("tcMaximizeMasterClass");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterClass");
		}
	}

	@Test(priority = 13)
	public void tcMinimizeMasterClassList() {

		try {
			log.info("============= Strting tcMinimizeMasterClassList Test===========");

			masterclass.minimizeMasterClassList();

			log.info("============= Finished tcMinimizeMasterClassList Test===========");
			getScreenShot("tcMinimizeMasterClassList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterClassList");
		}
	}

	@Test(priority = 14)
	public void tcMaximizeMasterClassList() {

		try {
			log.info("============= Strting tcMaximizeMasterClassList Test===========");

			masterclass.maximizeMasterClassList();

			log.info("============= Finished tcMaximizeMasterClassList Test===========");
			getScreenShot("tcMaximizeMasterClassList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterClassList");
		}
	}

	//

	@Test(priority = 15, dataProvider = "MastersMasterClassData")
	public void tcEnterMasterClassRequiredFormData_AfterClear(String className, String classOrder, String classCode,
			String classCapacity, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterClassRequiredFormData_AfterClear Test===========");

			masterclass.enterMasterClassRequiredFormData(className, classOrder, classCode, classCapacity);

			log.info("============= Finished tcEnterMasterClassRequiredFormData_AfterClear Test===========");
			getScreenShot("tcEnterMasterClassRequiredFormData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterClassRequiredFormData_AfterClear");
		}
	}

	@Test(priority = 16, dataProvider = "MasterClassMaxAgeData")
	public void tcSelectMaximumAgeForClass_AfterClear(String maxAgeYear, String maxAgeMonth, String maxAgeDay,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectMaximumAgeForClass_AfterClear Test===========");

			masterclass.selectMaximumAgeForClass(maxAgeYear, maxAgeMonth, maxAgeDay);

			log.info("============= Finished tcSelectMaximumAgeForClass_AfterClear Test===========");
			getScreenShot("tcSelectMaximumAgeForClass_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectMaximumAgeForClass_AfterClear");
		}
	}

	@Test(priority = 17, dataProvider = "MasterClassMinAgeData")
	public void tcSelectMinimumAgeForClass_AfterClear(String minAgeYear, String minAgeMonth, String minAgeDay,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectMinimumAgeForClass_AfterClear Test===========");

			masterclass.selectMinimumAgeForClass(minAgeYear, minAgeMonth, minAgeDay);

			log.info("============= Finished tcSelectMinimumAgeForClass_AfterClear Test===========");
			getScreenShot("tcSelectMinimumAgeForClass_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectMinimumAgeForClass_AfterClear");
		}
	}

	@Test(priority = 18)
	public void tcClickOnSaveButton() {

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			masterclass.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 19)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			masterclass.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	@Test(priority = 20, dataProvider = "MasterClassSearchData")
	public void tcSearchWithClassName(String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassName Test===========");

			masterclass.searchWithClassName(className);

			log.info("============= Finished tcSearchWithClassName Test===========");
			getScreenShot("tcSearchWithClassName");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassName");
		}
	}

	@Test(priority = 21)
	public void tcClickOnOkSuccessButton_search() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_search Test===========");

			masterclass.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_search Test===========");
			getScreenShot("tcClickOnOkSuccessButton_search");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_search");
		}
	}

	@Test(priority = 22)
	public void tcClickSearchResetButton() {

		try {
			log.info("============= Strting tcClickSearchResetButton Test===========");

			masterclass.clickSearchResetButton();

			log.info("============= Finished tcClickSearchResetButton Test===========");
			getScreenShot("tcClickSearchResetButton");
		} catch (Exception e) {
			getScreenShot("tcClickSearchResetButton");
		}
	}

	@Test(priority = 23, dataProvider = "MasterClassSearchData")
	public void tcSearchWithClassName_ForEdit(String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassName_ForEdit Test===========");

			masterclass.searchWithClassName(className);

			log.info("============= Finished tcSearchWithClassName_ForEdit Test===========");
			getScreenShot("tcSearchWithClassName_ForEdit");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassName_ForEdit");
		}
	}

	@Test(priority = 24)
	public void tcClickOnOkSuccessButton_Searchedit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Searchedit Test===========");

			masterclass.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Searchedit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Searchedit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Searchedit");
		}
	}

	@Test(priority = 25, dataProvider = "MasterClassSearchData")
	public void tcEditMasterClass(String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterClass Test===========");

			masterclass.editMasterClass(className);

			log.info("============= Finished tcEditMasterClass Test===========");
			getScreenShot("tcEditMasterClass");
		} catch (Exception e) {
			getScreenShot("tcEditMasterClass");
		}
	}

	@Test(priority = 26)
	public void tcClickOnSaveButton_edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_edit Test===========");

			masterclass.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_edit Test===========");
			getScreenShot("tcClickOnSaveButton_edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_edit");
		}
	}

	@Test(priority = 27)
	public void tcClickOnOkSuccessButton_edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_edit Test===========");

			masterclass.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_edit");
		}
	}

	@Test(priority = 28, dataProvider = "MasterClassSearchData")
	public void tcSearchWithClassName_ForDeactivate(String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassName_ForDeactivate Test===========");

			masterclass.searchWithClassName(className);

			log.info("============= Finished tcSearchWithClassName_ForDeactivate Test===========");
			getScreenShot("tcSearchWithClassName_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassName_ForDeactivate");
		}
	}

	@Test(priority = 29)
	public void tcClickOnOkSuccessButton_SearchDeactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_SearchDeactivate Test===========");

			masterclass.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_SearchDeactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_SearchDeactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_SearchDeactivate");
		}
	}

	@Test(priority = 30, dataProvider = "MasterClassSearchData")
	public void tcDeactivateMasterClass(String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterClass Test===========");

			masterclass.deactivateMasterClass(className);

			log.info("============= Finished tcDeactivateMasterClass Test===========");
			getScreenShot("tcDeactivateMasterClass");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterClass");
		}
	}

	@Test(priority = 31)
	public void tcClickOnCancelButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_deactivate Test===========");

			masterclass.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_deactivate");
		}
	}

	@Test(priority = 32)
	public void tcClickOnOkSuccessButton_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivateCancel Test===========");

			masterclass.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 33, dataProvider = "MasterClassSearchData")
	public void tcDeactivateMasterClass_AfterCancel(String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivateMasterClass_AfterCancel Test===========");

			masterclass.deactivateMasterClass(className);

			log.info("============= Finished tcDeactivateMasterClass_AfterCancel Test===========");
			getScreenShot("tcDeactivateMasterClass_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivateMasterClass_AfterCancel");
		}
	}

	@Test(priority = 34)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			masterclass.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}

	@Test(priority = 35)
	public void tcClickOnOkSuccessButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivate Test===========");

			masterclass.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}

	@Test(priority = 36, dataProvider = "MasterClassSearchData")
	public void tcSearchWithClassName_ForActivate(String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithClassName_ForActivate Test===========");

			masterclass.searchWithClassName(className);

			log.info("============= Finished tcSearchWithClassName_ForActivate Test===========");
			getScreenShot("tcSearchWithClassName_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchWithClassName_ForActivate");
		}
	}

	@Test(priority = 37)
	public void tcClickOnOkSuccessButton_SearchActivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_SearchActivate Test===========");

			masterclass.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_SearchActivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_SearchActivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_SearchActivate");
		}
	} //

	@Test(priority = 38, dataProvider = "MasterClassSearchData")
	public void tcActivateMasterClass(String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterClass Test===========");

			masterclass.activateMasterClass(className);

			log.info("============= Finished tcActivateMasterClass Test===========");
			getScreenShot("tcActivateMasterClass");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterClass");
		}
	}

	@Test(priority = 39)
	public void tcClickOnCancelButton_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_activate Test===========");

			masterclass.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_activate Test===========");
			getScreenShot("tcClickOnCancelButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_activate");
		}
	}

	@Test(priority = 40)
	public void tcClickOnOkSuccessButton_activateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activateCancel Test===========");

			masterclass.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 41, dataProvider = "MasterClassSearchData")
	public void tcActivateMasterClass_AfterCancel(String className, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivateMasterClass_AfterCancel Test===========");

			masterclass.activateMasterClass(className);
			log.info("============= Finished tcActivateMasterClass_AfterCancel Test===========");
			getScreenShot("tcActivateMasterClass_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivateMasterClass_AfterCancel");
		}
	}

	@Test(priority = 42)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			masterclass.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}

	@Test(priority = 43)
	public void tcClickOnOkSuccessButton_activate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activate Test===========");

			masterclass.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_activate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activate");
		}
	}

	@Test(priority = 44)
	public void tcClickOnSetOrder() {

		try {
			log.info("============= Strting tcClickOnSetOrder Test===========");

			masterclass.clickOnSetOrder();

			log.info("============= Finished tcClickOnSetOrder Test===========");
			getScreenShot("tcClickOnSetOrder");
		} catch (Exception e) {
			getScreenShot("tcClickOnSetOrder");
		}
	}

	@Test(priority = 45)
	public void tcSetClassOrder() {

		try {
			log.info("============= Strting tcSetClassOrder Test===========");

			masterclass.setClassOrder();

			log.info("============= Finished tcSetClassOrder Test===========");
			getScreenShot("tcSetClassOrder");
		} catch (Exception e) {
			getScreenShot("tcSetClassOrder");
		}
	}

	
	@Test(priority = 46)
	public void tcCloseSetClassOrderPopUpWindow() {

		try {
			log.info("============= Strting tcCloseSetClassOrderPopUpWindow Test===========");

			masterclass.closeSetClassOrderPopUpWindow();

			log.info("============= Finished tcCloseSetClassOrderPopUpWindow Test===========");
			getScreenShot("tcCloseSetClassOrderPopUpWindow");
		} catch (Exception e) {
			getScreenShot("tcCloseSetClassOrderPopUpWindow");
		}
	}

	@Test(priority = 47)
	public void tcClickOnSetOrder_AfterClose() {

		try {
			log.info("============= Strting tcClickOnSetOrder Test===========");

			masterclass.clickOnSetOrder();

			log.info("============= Finished tcClickOnSetOrder Test===========");
			getScreenShot("tcClickOnSetOrder");
		} catch (Exception e) {
			getScreenShot("tcClickOnSetOrder");
		}
	}

	@Test(priority = 48)
	public void tcSetClassOrder_AfterClose() {

		try {
			log.info("============= Strting tcSetClassOrder_AfterClose Test===========");

			masterclass.setClassOrder();

			log.info("============= Finished tcSetClassOrder_AfterClose Test===========");
			getScreenShot("tcSetClassOrder_AfterClose");
		} catch (Exception e) {
			getScreenShot("tcSetClassOrder_AfterClose");
		}
	}

	@Test(priority = 49)
	public void tcSaveSetClassOrderPopUpWindow() {

		try {
			log.info("============= Strting tcSaveSetClassOrderPopUpWindow Test===========");

			masterclass.saveSetClassOrderPopUpWindow();

			log.info("============= Finished tcSaveSetClassOrderPopUpWindow Test===========");
			getScreenShot("tcSaveSetClassOrderPopUpWindow");
		} catch (Exception e) {
			getScreenShot("tcSaveSetClassOrderPopUpWindow");
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
