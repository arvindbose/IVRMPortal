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

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Government_Bond;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_Masters_Government_Bond extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Masters_Government_Bond.class.getName());

	Masters_Government_Bond governmentbond;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersGovernment_BondData")
	public String[][] getTestData() {
		String[][] testRecordsCasteCategoryDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_GovernmentBondInfoData");
		return testRecordsCasteCategoryDetails;
	}

	@DataProvider(name = "Government_BondSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByBondName");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		governmentbond = new Masters_Government_Bond(driver);
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

			boolean status = governmentbond.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_GovernmentBond_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_GovernmentBond_BGHS Test===========");

			governmentbond.navigateToAdmission_Masters_GovernmentBond_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_GovernmentBond_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_GovernmentBond_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_GovernmentBond_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_GovernmentBond_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_GovernmentBond_BGHSPage Test===========");

			boolean status = governmentbond.verifyMasters_GovernmentBond_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_GovernmentBond_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_GovernmentBond_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_GovernmentBond_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankGovernmentBondForm() {

		try {
			log.info("============= Strting tcSubmitBlankGovernmentBondForm Test===========");

			governmentbond.submitBlankGovernmentBondForm();

			log.info("============= Finished tcSubmitBlankGovernmentBondForm Test===========");
			getScreenShot("tcSubmitBlankGovernmentBondForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankGovernmentBondForm");
		}
	}

	@Test(priority = 6, dataProvider = "MastersGovernment_BondData")
	public void tcEnterMasterGovernmentBondDetailsData(String bondName, String bondDescription,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterGovernmentBondDetailsData Test===========");

			governmentbond.enterMasterGovernmentBondDetailsData(bondName, bondDescription);

			log.info("============= Finished tcEnterMasterGovernmentBondDetailsData Test===========");
			getScreenShot("tcEnterMasterGovernmentBondDetailsData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterGovernmentBondDetailsData");
		}
	}

	//
	@Test(priority = 7)
	public void tcClearGovernmentBondInfoData() {

		try {
			log.info("============= Strting tcClearGovernmentBondInfoData Test===========");

			governmentbond.clearGovernmentBondInfoData();

			log.info("============= Finished tcClearGovernmentBondInfoData Test===========");
			getScreenShot("tcClearGovernmentBondInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearGovernmentBondInfoData");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeMasterGovernmentBond() {

		try {
			log.info("============= Strting tcMinimizeMasterGovernmentBond Test===========");

			governmentbond.minimizeMasterGovernmentBond();

			log.info("============= Finished tcMinimizeMasterGovernmentBond Test===========");
			getScreenShot("tcMinimizeMasterGovernmentBond");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterGovernmentBond");
		}
	}

	@Test(priority = 9)
	public void tcSortByBondName() {

		try {
			log.info("============= Strting tcSortByBondName Test===========");
			getScreenShot("tcSortByBondName_BeforeSorting");

			governmentbond.sortByBondName();

			log.info("============= Finished tcSortByBondName Test===========");
			getScreenShot("tcSortByBondName");
		} catch (Exception e) {
			getScreenShot("tcSortByBondName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterGovernmentBond() {

		try {
			log.info("============= Strting tcMaximizeMasterGovernmentBond Test===========");

			governmentbond.maximizeMasterGovernmentBond();

			log.info("============= Finished tcMaximizeMasterGovernmentBond Test===========");
			getScreenShot("tcMaximizeMasterGovernmentBond");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterGovernmentBond");
		}
	}
	

	@Test(priority = 11)
	public void tcMinimizeGovernmentBondList() {

		try {
			log.info("============= Strting tcMinimizeGovernmentBondList Test===========");

			governmentbond.minimizeGovernmentBondList();

			log.info("============= Finished tcMinimizeGovernmentBondList Test===========");
			getScreenShot("tcMinimizeGovernmentBondList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeGovernmentBondList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeGovernmentBondList() {

		try {
			log.info("============= Strting tcMaximizeGovernmentBondList Test===========");

			governmentbond.maximizeGovernmentBondList();

			log.info("============= Finished tcMaximizeGovernmentBondList Test===========");
			getScreenShot("tcMaximizeGovernmentBondList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeGovernmentBondList");
		}
	}

	@Test(priority = 13, dataProvider = "MastersGovernment_BondData")
	public void tcEnterMasterGovernmentBondDetailsData_AfterClear(String bondName,
			String bondDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterGovernmentBondDetailsData_AfterClear Test===========");

			governmentbond.enterMasterGovernmentBondDetailsData(bondName, bondDescription);

			log.info("============= Finished tcEnterMasterGovernmentBondDetailsData_AfterClear Test===========");
			getScreenShot("tcEnterMasterGovernmentBondDetailsData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterGovernmentBondDetailsData_AfterClear");
		}
	}

	@Test(priority = 14)
	public void tcSaveGovernmentBondInfoData() {

		try {
			log.info("============= Strting tcSaveGovernmentBondInfoData Test===========");

			governmentbond.saveGovernmentBondInfoData();

			log.info("============= Finished tcSaveGovernmentBondInfoData Test===========");
			getScreenShot("tcSaveGovernmentBondInfoData");
		} catch (Exception e) {
			getScreenShot("tcSaveGovernmentBondInfoData");
		}
	}

	@Test(priority = 15)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			governmentbond.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}

	@Test(priority = 16, dataProvider = "Government_BondSearchData")
	public void tcSearchWithGovernmentBondNameInTheGrid(String bondName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithGovernmentBondNameInTheGrid Test===========");

			governmentbond.searchWithGovernmentBondNameInTheGrid(bondName);

			log.info("============= Finished tcSearchWithGovernmentBondNameInTheGrid Test===========");
			getScreenShot("tcSearchWithGovernmentBondNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithGovernmentBondNameInTheGrid");
		}
	}

	@Test(priority = 17, dataProvider = "Government_BondSearchData")
	public void tcVerifyBondNameInTheGrid(String bondName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyBondNameInTheGrid Test===========");

			governmentbond.verifyBondNameInTheGrid(bondName);

			log.info("============= Finished tcVerifyBondNameInTheGrid Test===========");
			getScreenShot("tcVerifyBondNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyBondNameInTheGrid");
		}
	}

	@Test(priority = 18, dataProvider = "Government_BondSearchData")
	public void tcEditGovernmentBond(String bondName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditGovernmentBond Test===========");

			governmentbond.editGovernmentBond(bondName);

			log.info("============= Finished tcEditGovernmentBond Test===========");
			getScreenShot("tcEditGovernmentBond");
		} catch (Exception e) {
			getScreenShot("tcEditGovernmentBond");
		}
	}

	@Test(priority = 19)
	public void tcSaveGovernmentBondInfoData_Edit() {

		try {
			log.info("============= Strting tcSaveGovernmentBondInfoData_Edit Test===========");

			governmentbond.saveGovernmentBondInfoData();

			log.info("============= Finished tcSaveGovernmentBondInfoData_Edit Test===========");
			getScreenShot("tcSaveGovernmentBondInfoData_Edit");
		} catch (Exception e) {
			getScreenShot("tcSaveGovernmentBondInfoData_Edit");
		}
	}

	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			governmentbond.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	@Test(priority = 21, dataProvider = "Government_BondSearchData")
	public void tcSearchWithGovernmentBondNameInTheGrid_delete(String bondName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithGovernmentBondNameInTheGrid_delete Test===========");

			governmentbond.searchWithGovernmentBondNameInTheGrid(bondName);

			log.info("============= Finished tcSearchWithGovernmentBondNameInTheGrid_delete Test===========");
			getScreenShot("tcSearchWithGovernmentBondNameInTheGrid_delete");
		} catch (Exception e) {
			getScreenShot("tcSearchWithGovernmentBondNameInTheGrid_delete");
		}
	}

	@Test(priority = 22, dataProvider = "Government_BondSearchData")
	public void tcDeleteGovernmentBond(String bondName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteGovernmentBond Test===========");

			governmentbond.deleteGovernmentBond(bondName);

			log.info("============= Finished tcDeleteGovernmentBond Test===========");
			getScreenShot("tcDeleteGovernmentBond");
		} catch (Exception e) {
			getScreenShot("tcDeleteGovernmentBond");
		}
	}

	@Test(priority = 23)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			governmentbond.clickOnCancelButton();

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

			governmentbond.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_cancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		}
	}

	@Test(priority = 25, dataProvider = "Government_BondSearchData")
	public void tcDeleteGovernmentBond_AfterCancel(String bondName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteGovernmentBond_AfterCancel Test===========");

			governmentbond.deleteGovernmentBond(bondName);

			log.info("============= Finished tcDeleteGovernmentBond_AfterCancel Test===========");
			getScreenShot("tcDeleteGovernmentBond_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteGovernmentBond_AfterCancel");
		}
	}

	@Test(priority = 26)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			governmentbond.yesDeleteOrDeactivateOrActivateIt();

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

			governmentbond.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}

	@Test(priority = 28, dataProvider = "MastersGovernment_BondData")
	public void tcEnterMasterGovernmentBondDetailsData_AfterDelete(String bondName,
			String bondDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterGovernmentBondDetailsData_AfterDelete Test===========");

			governmentbond.enterMasterGovernmentBondDetailsData(bondName, bondDescription);

			log.info("============= Finished tcEnterMasterGovernmentBondDetailsData_AfterDelete Test===========");
			getScreenShot("tcEnterMasterGovernmentBondDetailsData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterGovernmentBondDetailsData_AfterDelete");
		}
	}

	@Test(priority = 29)
	public void tcSaveGovernmentBondInfoData_AfterDelete() {

		try {
			log.info("============= Strting tcSaveGovernmentBondInfoData_AfterDelete Test===========");

			governmentbond.saveGovernmentBondInfoData();

			log.info("============= Finished tcSaveGovernmentBondInfoData_AfterDelete Test===========");
			getScreenShot("tcSaveGovernmentBondInfoData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSaveGovernmentBondInfoData_AfterDelete");
		}
	}

	@Test(priority = 30)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			governmentbond.clickOnOkSuccessButton();

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
