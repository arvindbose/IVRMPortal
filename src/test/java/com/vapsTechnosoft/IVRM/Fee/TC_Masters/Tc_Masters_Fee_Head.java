/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Fee_Head;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_Head extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Head.class.getName());

	Masters_Fee_Head feehead;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "FeeHeadTestData")
	public String[][] getTestDataFeeHead() {
		String[][] testRecordsFeeHead = getData("FeeModueData.xlsx", "FeeHeadData");
		return testRecordsFeeHead;
	}

	@DataProvider(name = "Search_FeeHeadTestData")
	public String[][] getTestDataFeeGroup() {
		String[][] testRecordsSearchFeeHead = getData("FeeModueData.xlsx", "Search_FeeHeadData");
		return testRecordsSearchFeeHead;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feehead = new Masters_Fee_Head(driver);
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

			feehead.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateToMasters_FeeHead() {

		try {
			log.info("============= Strting tcNevigateToMasters_FeeHead Test===========");

			feehead.nevigateToMasters_FeeHead();

			log.info("============= Finished tcNevigateToMasters_FeeHead Test===========");
			getScreenShot("tcNevigateToMasters_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcNevigateToMasters_FeeHead");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeHeadPage() {

		try {
			log.info("============= Strting tcVerifyFeeHeadPage Test===========");

			boolean status = feehead.verifyFeeHeadPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeHeadPage Test===========");
			getScreenShot("tcVerifyFeeHeadPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeHeadPage");
		}
	}

	@Test(priority = 5)
	public void tcClickOnSaveButton_ToSubmitBlankForm() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitBlankForm Test===========");

			feehead.clickOnSaveButton_FeeHead();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitBlankForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		}
	}

	@Test(priority = 6, dataProvider = "FeeHeadTestData")
	public void tcFill_FeeHead_Form(String feeHeadName, String feeHeadType, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeHead_Form Test===========");

			feehead.fill_FeeHead_Form(feeHeadName, feeHeadType);

			log.info("============= Finished tcFill_FeeHead_Form Test===========");
			getScreenShot("tcFill_FeeHead_Form");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeHead_Form");
		}
	}

	@Test(priority = 7)
	public void tcSelect_SpecialFeeHead_CheckBox() {

		try {
			log.info("============= Strting tcSelect_SpecialFeeHead_CheckBox Test===========");

			feehead.select_SpecialFeeHead_CheckBox();

			log.info("============= Finished tcSelect_SpecialFeeHead_CheckBox Test===========");
			getScreenShot("tcSelect_SpecialFeeHead_CheckBox");
		} catch (Exception e) {
			getScreenShot("tcSelect_SpecialFeeHead_CheckBox");
		}
	}

	@Test(priority = 8)
	public void tcSelect_Refundable_CheckBox() {

		try {
			log.info("============= Strting tcSelect_Refundable_CheckBox Test===========");

			feehead.select_Refundable_CheckBox();

			log.info("============= Finished tcSelect_Refundable_CheckBox Test===========");
			getScreenShot("tcSelect_Refundable_CheckBox");
		} catch (Exception e) {
			getScreenShot("tcSelect_Refundable_CheckBox");
		}
	}

	@Test(priority = 9)
	public void tcSelect_PDAExpense_CheckBox() {

		try {
			log.info("============= Strting tcSelect_PDAExpense_CheckBox Test===========");

			feehead.select_PDAExpense_CheckBox();

			log.info("============= Finished tcSelect_PDAExpense_CheckBox Test===========");
			getScreenShot("tcSelect_PDAExpense_CheckBox");
		} catch (Exception e) {
			getScreenShot("tcSelect_PDAExpense_CheckBox");
		}
	}

	@Test(priority = 10)
	public void tcMinimizeAndMaximize_FeeHead() {

		try {
			log.info("============= Strting tcMinimizeAndMaximize_FeeHead Test===========");

			feehead.minimizeAndMaximize_FeeHead();

			log.info("============= Finished tcMinimizeAndMaximize_FeeHead Test===========");
			getScreenShot("tcMinimizeAndMaximize_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcMinimizeAndMaximize_FeeHead");
		}
	}

	@Test(priority = 11)
	public void tcSortByFeeHeadName() {

		try {
			log.info("============= Strting tcSortByFeeHeadName Test===========");
			getScreenShot("tcSortByFeeHeadName_BeforeSorting");

			feehead.sortByFeeHeadName();

			log.info("============= Finished tcSortByFeeHeadName Test===========");
			getScreenShot("tcSortByFeeHeadName");
		} catch (Exception e) {
			getScreenShot("tcSortByFeeHeadName");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_FeeMasterHeadGridView() {

		try {
			log.info("============= Strting tcMinimize_FeeMasterHeadGridView Test===========");

			feehead.minimizeAndMaximize_FeeMasterHeadGridView();

			log.info("============= Finished tcMinimize_FeeMasterHeadGridView Test===========");
			getScreenShot("tcMinimize_FeeMasterHeadGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeMasterHeadGridView");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_FeeMasterHeadGridView() {

		try {
			log.info("============= Strting tcMaximize_FeeMasterHeadGridView Test===========");

			feehead.minimizeAndMaximize_FeeMasterHeadGridView();

			log.info("============= Finished tcMaximize_FeeMasterHeadGridView Test===========");
			getScreenShot("tcMaximize_FeeMasterHeadGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeMasterHeadGridView");
		}
	}

	@Test(priority = 14)
	public void tcMaximize_FeeHead() {

		try {
			log.info("============= Strting tcMaximize_FeeHead Test===========");

			feehead.minimizeAndMaximize_FeeHead();

			log.info("============= Finished tcMaximize_FeeHead Test===========");
			getScreenShot("tcMaximize_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeHead");
		}
	}

	@Test(priority = 15)
	public void tcClickOnCancelButton_FeeHead() {
		try {
			log.info("============= Strting tcClickOnCancelButton_FeeHead Test===========");

			feehead.clickOnCancelButton_FeeHead();

			log.info("============= Finished tcClickOnCancelButton_FeeHead Test===========");
			getScreenShot("tcClickOnCancelButton_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_FeeHead");
		}
	}

	@Test(priority = 16, dataProvider = "FeeHeadTestData")
	public void tcFill_FeeHead_Form_AfterCancel(String feeHeadName, String feeHeadType, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeHead_Form_AfterCancel Test===========");

			feehead.fill_FeeHead_Form(feeHeadName, feeHeadType);

			log.info("============= Finished tcFill_FeeHead_Form_AfterCancel Test===========");
			getScreenShot("tcFill_FeeHead_Form_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeHead_Form_AfterCancel");
		}
	}

	@Test(priority = 17)
	public void tcSelect_SpecialFeeHead_CheckBox_AfterCancel() {

		try {
			log.info("============= Strting tcSelect_SpecialFeeHead_CheckBox_AfterCancel Test===========");

			feehead.select_SpecialFeeHead_CheckBox();

			log.info("============= Finished tcSelect_SpecialFeeHead_CheckBox_AfterCancel Test===========");
			getScreenShot("tcSelect_SpecialFeeHead_CheckBox_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelect_SpecialFeeHead_CheckBox_AfterCancel");
		}
	}

	@Test(priority = 18)
	public void tcSelect_Refundable_CheckBox_AfterCancel() {

		try {
			log.info("============= Strting tcSelect_Refundable_CheckBox_AfterCancel Test===========");

			feehead.select_Refundable_CheckBox();

			log.info("============= Finished tcSelect_Refundable_CheckBox_AfterCancel Test===========");
			getScreenShot("tcSelect_Refundable_CheckBox_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelect_Refundable_CheckBox_AfterCancel");
		}
	}

	@Test(priority = 19)
	public void tcSelect_PDAExpense_CheckBox_AfterCancel() {

		try {
			log.info("============= Strting tcSelect_PDAExpense_CheckBox_AfterCancel Test===========");

			feehead.select_PDAExpense_CheckBox();

			log.info("============= Finished tcSelect_PDAExpense_CheckBox_AfterCancel Test===========");
			getScreenShot("tcSelect_PDAExpense_CheckBox_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelect_PDAExpense_CheckBox_AfterCancel");
		}
	}

	@Test(priority = 20)
	public void tcClickOnSaveButton_FeeHead() {

		try {
			log.info("============= Strting tcClickOnSaveButton_FeeHead Test===========");

			feehead.clickOnSaveButton_FeeHead();

			log.info("============= Finished tcClickOnSaveButton_FeeHead Test===========");
			getScreenShot("tcClickOnSaveButton_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_FeeHead");
		}
	}

	@Test(priority = 21)
	public void tcClickOnSuccessOkBtn() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			feehead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	@Test(priority = 22, dataProvider = "Search_FeeHeadTestData")
	public void tcSearchBy_FeeHead_NameInGrid(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeHead_NameInGrid Test===========");

			feehead.searchBy_FeeHead_NameInGrid(feeHead);

			log.info("============= Finished tcSearchBy_FeeHead_NameInGrid Test===========");
			getScreenShot("tcSearchBy_FeeHead_NameInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeHead_NameInGrid");
		}
	}

	@Test(priority = 23, dataProvider = "Search_FeeHeadTestData")
	public void tcVerifyFeeHead_UpdatedInGrid(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyFeeHead_UpdatedInGrid Test===========");

			feehead.verifyFeeHead_UpdatedInGrid(feeHead);

			log.info("============= Finished tcVerifyFeeHead_UpdatedInGrid Test===========");
			getScreenShot("tcVerifyFeeHead_UpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeHead_UpdatedInGrid");
		}
	}

	@Test(priority = 24, dataProvider = "Search_FeeHeadTestData")
	public void tcEdit_FeeHead_updatedInGrid(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEdit_FeeHead_updatedInGrid Test===========");

			feehead.edit_FeeHead_updatedInGrid(feeHead);
			log.info("============= Finished tcEdit_FeeHead_updatedInGrid Test===========");
			getScreenShot("tcEdit_FeeHead_updatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcEdit_FeeHead_updatedInGrid");
		}
	}

	@Test(priority = 25)
	public void tcClickOnSaveButton_FeeHead_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_FeeHead_Edit Test===========");

			feehead.clickOnSaveButton_FeeHead();

			log.info("============= Finished tcClickOnSaveButton_FeeHead_Edit Test===========");
			getScreenShot("tcClickOnSaveButton_FeeHead_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_FeeHead_Edit");
		}
	}

	@Test(priority = 26)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			feehead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	//

	@Test(priority = 27, dataProvider = "Search_FeeHeadTestData")
	public void tcSearchBy_FeeHead_NameInGrid_ForDeactivate(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeHead_NameInGrid_ForDeactivate Test===========");

			feehead.searchBy_FeeHead_NameInGrid(feeHead);

			log.info("============= Finished tcSearchBy_FeeHead_NameInGrid_ForDeactivate Test===========");
			getScreenShot("tcSearchBy_FeeHead_NameInGrid_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeHead_NameInGrid_ForDeactivate");
		}
	}

	@Test(priority = 28, dataProvider = "Search_FeeHeadTestData")
	public void tcDeactivationOfCreated_FeeHead(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_FeeHead Test===========");

			feehead.deactivationOfCreated_FeeHead(feeHead);

			log.info("============= Finished tcDeactivationOfCreated_FeeHead Test===========");
			getScreenShot("tcDeactivationOfCreated_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_FeeHead");
		}
	}

	@Test(priority = 29)
	public void tcClickOnCancelButton_PopUp_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_deactivate Test===========");

			feehead.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_deactivate");
		}
	}

	@Test(priority = 30)
	public void tcClickOnOkSuccessButton_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivateCancel Test===========");

			feehead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 31, dataProvider = "Search_FeeHeadTestData")
	public void tcSearchBy_FeeHead_NameInGrid_ForDeactivate_AfterCancel(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeHead_NameInGrid_ForDeactivate_AfterCancel Test===========");

			feehead.searchBy_FeeHead_NameInGrid(feeHead);

			log.info("============= Finished tcSearchBy_FeeHead_NameInGrid_ForDeactivate_AfterCancel Test===========");
			getScreenShot("tcSearchBy_FeeHead_NameInGrid_ForDeactivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeHead_NameInGrid_ForDeactivate_AfterCancel");
		}
	}

	@Test(priority = 32, dataProvider = "Search_FeeHeadTestData")
	public void tcDeactivationOfCreated_FeeHead_AfterCancel(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_FeeHead_AfterCancel Test===========");

			feehead.deactivationOfCreated_FeeHead(feeHead);

			log.info("============= Finished tcDeactivationOfCreated_FeeHead_AfterCancel Test===========");
			getScreenShot("tcDeactivationOfCreated_FeeHead_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_FeeHead_AfterCancel");
		}
	}

	@Test(priority = 33)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			feehead.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}

	@Test(priority = 34)
	public void tcClickOnOkSuccessButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivate Test===========");

			feehead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}

	@Test(priority = 35, dataProvider = "Search_FeeHeadTestData")
	public void tcSearchBy_FeeHead_NameInGrid_ForActivate(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeHead_NameInGrid_ForActivate Test===========");

			feehead.searchBy_FeeHead_NameInGrid(feeHead);

			log.info("============= Finished tcSearchBy_FeeHead_NameInGrid_ForActivate Test===========");
			getScreenShot("tcSearchBy_FeeHead_NameInGrid_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeHead_NameInGrid_ForActivate");
		}
	}

	@Test(priority = 36, dataProvider = "Search_FeeHeadTestData")
	public void tcActivationOfCreated_FeeHead(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreated_FeeHead Test===========");

			feehead.activationOfCreated_FeeHead(feeHead);

			log.info("============= Finished tcActivationOfCreated_FeeHead Test===========");
			getScreenShot("tcActivationOfCreated_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreated_FeeHead");
		}
	}

	@Test(priority = 37)
	public void tcClickOnCancelButton_PopUp_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_activate Test===========");

			feehead.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_activate Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_activate");
		}
	}

	@Test(priority = 38)
	public void tcClickOnOkSuccessButton_activateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activateCancel Test===========");

			feehead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 39, dataProvider = "Search_FeeHeadTestData")
	public void tcSearchBy_FeeHead_NameInGrid_AfterCancel(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_FeeHead_NameInGrid_AfterCancel Test===========");

			feehead.searchBy_FeeHead_NameInGrid(feeHead);

			log.info("============= Finished tcSearchBy_FeeHead_NameInGrid_AfterCancel Test===========");
			getScreenShot("tcSearchBy_FeeHead_NameInGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_FeeHead_NameInGrid_AfterCancel");
		}
	}

	@Test(priority = 40, dataProvider = "Search_FeeHeadTestData")
	public void tcActivationOfCreated_FeeHead_AfterCancel(String feeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreated_FeeHead_AfterCancel Test===========");

			feehead.activationOfCreated_FeeHead(feeHead);
			log.info("============= Finished tcActivationOfCreated_FeeHead_AfterCancel Test===========");
			getScreenShot("tcActivationOfCreated_FeeHead_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreated_FeeHead_AfterCancel");
		}
	}

	@Test(priority = 41)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			feehead.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}

	@Test(priority = 42)
	public void tcClickOnOkSuccessButton_activate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activate Test===========");

			feehead.clickOnSuccessOkBtn();

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
