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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Master_Period;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Period extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Masters_Master_Period.class.getName());

	Masters_Master_Period masterperiod;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterPeriodData")
	public String[][] getTestData() {
		String[][] testRecordsPeriodDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterPeriodInfoData");
		return testRecordsPeriodDetails;
	}

	@DataProvider(name = "MasterPeriodSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByCategoryData");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		masterperiod = new Masters_Master_Period(driver);
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

			boolean status = masterperiod.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterPeriod_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterPeriod_BGHS Test===========");

			masterperiod.navigateToAdmission_Masters_MasterPeriod_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterPeriod_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterPeriod_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterPeriod_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterPeriod_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterPeriod_BGHSPage Test===========");

			boolean status = masterperiod.verifyMasters_MasterPeriod_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterPeriod_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterPeriod_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterPeriod_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterPeriodForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterPeriodForm Test===========");

			masterperiod.submitBlankMasterPeriodForm();

			log.info("============= Finished tcSubmitBlankMasterPeriodForm Test===========");
			getScreenShot("tcSubmitBlankMasterPeriodForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterPeriodForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersMasterPeriodData")
	public void tcEnterMasterPeriodData(String periodName, String periodOrder, String runMode) {

		if (runMode.equalsIgnoreCase("SHalf")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterPeriodData Test===========");

			masterperiod.enterMasterPeriodData(periodName, periodOrder);

			log.info("============= Finished tcEnterMasterPeriodData Test===========");
			getScreenShot("tcEnterMasterPeriodData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterPeriodData");
		}
	}

	@Test(priority = 7)
	public void tcSelectIstHalfPeriodRadioButton() {

		try {
			log.info("============= Strting tcSelectIstHalfPeriodRadioButton Test===========");

			masterperiod.selectIstHalfPeriodRadioButton();

			log.info("============= Finished tcSelectIstHalfPeriodRadioButton Test===========");
			getScreenShot("tcSelectIstHalfPeriodRadioButton");
		} catch (Exception e) {
			getScreenShot("tcSelectIstHalfPeriodRadioButton");
		}
	}

	//
	@Test(priority = 8)
	public void tcClearPeriodInfoData() {

		try {
			log.info("============= Strting tcClearPeriodInfoData Test===========");

			masterperiod.clearPeriodInfoData();

			log.info("============= Finished tcClearPeriodInfoData Test===========");
			getScreenShot("tcClearPeriodInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearPeriodInfoData");
		}
	}

	@Test(priority = 9)
	public void tcMinimizeMasterPeriod() {

		try {
			log.info("============= Strting tcMinimizeMasterPeriod Test===========");

			masterperiod.minimizeMasterPeriod();

			log.info("============= Finished tcMinimizeMasterPeriod Test===========");
			getScreenShot("tcMinimizeMasterPeriod");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterPeriod");
		}
	}

	@Test(priority = 10)
	public void tcSortByCategoryName() {

		try {
			log.info("============= Strting tcSortByCategoryName Test===========");
			getScreenShot("tcSortByCategoryName_BeforeSorting");

			masterperiod.sortByCategoryName();

			log.info("============= Finished tcSortByCategoryName Test===========");
			getScreenShot("tcSortByCategoryName");
		} catch (Exception e) {
			getScreenShot("tcSortByCategoryName");
		}
	}

	@Test(priority = 11)
	public void tcMaximizeMasterPeriod() {

		try {
			log.info("============= Strting tcMaximizeMasterPeriod Test===========");

			masterperiod.maximizeMasterPeriod();

			log.info("============= Finished tcMaximizeMasterPeriod Test===========");
			getScreenShot("tcMaximizeMasterPeriod");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterPeriod");
		}
	}

	@Test(priority = 12)
	public void tcMinimizeMasterPeriodList() {

		try {
			log.info("============= Strting tcMinimizeMasterPeriodList Test===========");

			masterperiod.minimizeMasterPeriodList();

			log.info("============= Finished tcMinimizeMasterPeriodList Test===========");
			getScreenShot("tcMinimizeMasterPeriodList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterPeriodList");
		}
	}

	@Test(priority = 13)
	public void tcMaximizeMasterPeriodList() {

		try {
			log.info("============= Strting tcMaximizeMasterPeriodList Test===========");

			masterperiod.maximizeMasterPeriodList();

			log.info("============= Finished tcMaximizeMasterPeriodList Test===========");
			getScreenShot("tcMaximizeMasterPeriodList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterPeriodList");
		}
	}

	@Test(priority = 14, dataProvider = "MastersMasterPeriodData")
	public void tcEnterMasterPeriodData_AfterClear(String periodName, String periodOrder, String runMode) {

		if (runMode.equalsIgnoreCase("SHalf")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterPeriodData_AfterClear Test===========");

			masterperiod.enterMasterPeriodData(periodName, periodOrder);

			log.info("============= Finished tcEnterMasterPeriodData_AfterClear Test===========");
			getScreenShot("tcEnterMasterPeriodData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterPeriodData_AfterClear");
		}
	}

	@Test(priority = 15)
	public void tcSelectIstHalfPeriodRadioButton_AfterClear() {

		try {
			log.info("============= Strting tcSelectIstHalfPeriodRadioButton_AfterClear Test===========");

			masterperiod.selectIstHalfPeriodRadioButton();

			log.info("============= Finished tcSelectIstHalfPeriodRadioButton_AfterClear Test===========");
			getScreenShot("tcSelectIstHalfPeriodRadioButton_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcSelectIstHalfPeriodRadioButton_AfterClear");
		}
	}

	@Test(priority = 16)
	public void tcSavePeriodInfoData() {

		try {
			log.info("============= Strting tcSaveBoardInfoData Test===========");

			masterperiod.savePeriodInfoData();

			log.info("============= Finished tcSaveBoardInfoData Test===========");
			getScreenShot("tcSaveBoardInfoData");
		} catch (Exception e) {
			getScreenShot("tcSaveBoardInfoData");
		}
	}

	@Test(priority = 17)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			masterperiod.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	@Test(priority = 18, dataProvider = "MastersMasterPeriodData")
	public void tcEnterMasterPeriodData_2ndHalfPeriod(String periodName, String periodOrder, String runMode) {

		if (runMode.equalsIgnoreCase("FHalf")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterPeriodData_AfterClear Test===========");

			masterperiod.enterMasterPeriodData(periodName, periodOrder);

			log.info("============= Finished tcEnterMasterPeriodData_AfterClear Test===========");
			getScreenShot("tcEnterMasterPeriodData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterPeriodData_AfterClear");
		}
	}

	@Test(priority = 19)
	public void tcSelectIIndHalfPeriodRadioButton_2ndHalfPeriod() {

		try {
			log.info("============= Strting tcSelectIIndHalfPeriodRadioButton_2ndHalfPeriod Test===========");

			masterperiod.selectIIndHalfPeriodRadioButton();

			log.info("============= Finished tcSelectIIndHalfPeriodRadioButton_2ndHalfPeriod Test===========");
			getScreenShot("tcSelectIIndHalfPeriodRadioButton_2ndHalfPeriod");
		} catch (Exception e) {
			getScreenShot("tcSelectIIndHalfPeriodRadioButton_2ndHalfPeriod");
		}
	}

	@Test(priority = 20)
	public void tcSavePeriodInfoData_2ndHalfPeriod() {

		try {
			log.info("============= Strting tcSavePeriodInfoData_2ndHalfPeriod Test===========");

			masterperiod.savePeriodInfoData();

			log.info("============= Finished tcSavePeriodInfoData_2ndHalfPeriod Test===========");
			getScreenShot("tcSavePeriodInfoData_2ndHalfPeriod");
		} catch (Exception e) {
			getScreenShot("tcSavePeriodInfoData_2ndHalfPeriod");
		}
	}

	@Test(priority = 21)
	public void tcClickOnOkSuccessButton_2ndHalfPeriod() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_2ndHalfPeriod Test===========");

			masterperiod.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_2ndHalfPeriod Test===========");
			getScreenShot("tcClickOnOkSuccessButton_2ndHalfPeriod");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_2ndHalfPeriod");
		}
	}

	@Test(priority = 22, dataProvider = "MasterPeriodSearchData")
	public void tcSearchWithCategoryNameInTheGrid(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCategoryNameInTheGrid Test===========");

			masterperiod.searchWithCategoryNameInTheGrid(categoryName);

			log.info("============= Finished tcSearchWithCategoryNameInTheGrid Test===========");
			getScreenShot("tcSearchWithCategoryNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCategoryNameInTheGrid");
		}
	}

	@Test(priority = 23, dataProvider = "MasterPeriodSearchData")
	public void tcVerifyCategoryNameInTheGrid(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyCategoryNameInTheGrid Test===========");

			masterperiod.verifyCategoryNameInTheGrid(categoryName);

			log.info("============= Finished tcVerifyCategoryNameInTheGrid Test===========");
			getScreenShot("tcVerifyCategoryNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyCategoryNameInTheGrid");
		}
	}

	@Test(priority = 24, dataProvider = "MasterPeriodSearchData")
	public void tcEditMasterPeriod(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterPeriod Test===========");

			masterperiod.editMasterPeriod(categoryName);

			log.info("============= Finished tcEditMasterPeriod Test===========");
			getScreenShot("tcEditMasterPeriod");
		} catch (Exception e) {
			getScreenShot("tcEditMasterPeriod");
		}
	}

	@Test(priority = 25)
	public void tcSavePeriodInfoData_Edit() {

		try {
			log.info("============= Strting tcSavePeriodInfoData_Edit Test===========");

			masterperiod.savePeriodInfoData();

			log.info("============= Finished tcSavePeriodInfoData_Edit Test===========");
			getScreenShot("tcSavePeriodInfoData_Edit");
		} catch (Exception e) {
			getScreenShot("tcSavePeriodInfoData_Edit");
		}
	}

	@Test(priority = 26)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			masterperiod.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	@Test(priority = 27, dataProvider = "MasterPeriodSearchData")
	public void tcSearchWithCategoryNameInTheGrid_delete(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCategoryNameInTheGrid_delete Test===========");

			masterperiod.searchWithCategoryNameInTheGrid(categoryName);

			log.info("============= Finished tcSearchWithCategoryNameInTheGrid_delete Test===========");
			getScreenShot("tcSearchWithCategoryNameInTheGrid_delete");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCategoryNameInTheGrid_delete");
		}
	}

	@Test(priority = 28, dataProvider = "MasterPeriodSearchData")
	public void tcDeleteMasterPeriod(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterPeriod Test===========");

			masterperiod.deleteMasterPeriod(categoryName);

			log.info("============= Finished tcDeleteMasterPeriod Test===========");
			getScreenShot("tcDeleteMasterPeriod");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterPeriod");
		}
	}

	@Test(priority = 29)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			masterperiod.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton Test===========");
			getScreenShot("tcClickOnCancelButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton");
		}
	}

	@Test(priority = 30)
	public void tcClickOnOkSuccessButton_cancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_cancel Test===========");

			masterperiod.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_cancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		}
	}

	@Test(priority = 31, dataProvider = "MasterPeriodSearchData")
	public void tcSearchWithCategoryNameInTheGrid_AfterDeleteCancel(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithCategoryNameInTheGrid_AfterDeleteCancel Test===========");

			masterperiod.searchWithCategoryNameInTheGrid(categoryName);

			log.info("============= Finished tcSearchWithCategoryNameInTheGrid_AfterDeleteCancel Test===========");
			getScreenShot("tcSearchWithCategoryNameInTheGrid_AfterDeleteCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithCategoryNameInTheGrid_AfterDeleteCancel");
		}
	}

	@Test(priority = 32, dataProvider = "MasterPeriodSearchData")
	public void tcDeleteMasterPeriod_AfterCancel(String categoryName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterPeriod_AfterCancel Test===========");

			masterperiod.deleteMasterPeriod(categoryName);

			log.info("============= Finished tcDeleteMasterPeriod_AfterCancel Test===========");
			getScreenShot("tcDeleteMasterPeriod_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterPeriod_AfterCancel");
		}
	}

	@Test(priority = 33)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			masterperiod.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}

	@Test(priority = 34)
	public void tcClickOnOkSuccessButton_delete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_delete Test===========");

			masterperiod.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}

	@Test(priority = 35, dataProvider = "MastersMasterPeriodData")
	public void tcEnterMasterPeriodData_AfterDelete(String periodName, String periodOrder, String runMode) {

		if (runMode.equalsIgnoreCase("SHalf")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterPeriodData_AfterDelete Test===========");

			masterperiod.enterMasterPeriodData(periodName, periodOrder);

			log.info("============= Finished tcEnterMasterPeriodData_AfterDelete Test===========");
			getScreenShot("tcEnterMasterPeriodData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterPeriodData_AfterDelete");
		}
	}

	@Test(priority = 36)
	public void tcSelectIIndHalfPeriodRadioButton_2ndHalfPeriod_AfterDelete() {

		try {
			log.info(
					"============= Strting tcSelectIIndHalfPeriodRadioButton_2ndHalfPeriod_AfterDelete Test===========");

			masterperiod.selectIIndHalfPeriodRadioButton();

			log.info(
					"============= Finished tcSelectIIndHalfPeriodRadioButton_2ndHalfPeriod_AfterDelete Test===========");
			getScreenShot("tcSelectIIndHalfPeriodRadioButton_2ndHalfPeriod_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSelectIIndHalfPeriodRadioButton_2ndHalfPeriod_AfterDelete");
		}
	}

	@Test(priority = 37)
	public void tcSavePeriodInfoData_AfterDelete() {

		try {
			log.info("============= Strting tcSavePeriodInfoData_AfterDelete Test===========");

			masterperiod.savePeriodInfoData();

			log.info("============= Finished tcSavePeriodInfoData_AfterDelete Test===========");
			getScreenShot("tcSavePeriodInfoData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSavePeriodInfoData_AfterDelete");
		}
	}

	@Test(priority = 38)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			masterperiod.clickOnOkSuccessButton();

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
