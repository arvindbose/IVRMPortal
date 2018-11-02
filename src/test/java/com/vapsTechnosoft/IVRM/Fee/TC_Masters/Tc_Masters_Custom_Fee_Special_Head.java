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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Custom_Fee_Special_Head;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 * 
 *         "Fee Module - Custom Fee Special Head"
 * 
 *         TC_F1_263,TC_F1_265,TC_F1_267,TC_F1_268
 *
 */
public class Tc_Masters_Custom_Fee_Special_Head extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Custom_Fee_Group.class.getName());

	Masters_Custom_Fee_Special_Head customSplfeeHead;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "CustomSPlFeeHeadTestData")
	public String[][] getTestDataCSFH() {
		String[][] testRecordsCSFH = getData("FeeModueData.xlsx", "CustomSPlFeeHeadData");
		return testRecordsCSFH;
	}

	@DataProvider(name = "searchBySpecialFeeHeadName")
	public String[][] getTestDataSplHeadName() {
		String[][] testRecordsCSplHeadName = getData("FeeModueData.xlsx", "Search_CustomSplFeeHead");
		return testRecordsCSplHeadName;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		customSplfeeHead = new Masters_Custom_Fee_Special_Head(driver);
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

			boolean status = customSplfeeHead.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToMasters_Custom_Special_FeeHead() {

		try {
			log.info("============= Strting tcNavigateToMasters_Custom_Special_FeeHead Test===========");

			customSplfeeHead.navigateToMasters_Custom_Special_FeeHead();

			log.info("============= Finished tcNavigateToMasters_Custom_Special_FeeHead Test===========");
			getScreenShot("tcNavigateToMasters_Custom_Special_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcNavigateToMasters_Custom_Special_FeeHead");
		}
	}

	@Test(priority = 4)
	public void tcVerifyCustomSpecialFeeHeadPage() {

		try {
			log.info("============= Strting tcVerifyCustomSpecialFeeHeadPage Test===========");

			boolean status = customSplfeeHead.verifyCustomSpecialFeeHeadPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyCustomSpecialFeeHeadPage Test===========");
			getScreenShot("tcVerifyCustomSpecialFeeHeadPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyCustomSpecialFeeHeadPage");
		}
	}

	@Test(priority = 5)
	public void tcClickOnSaveButton_ToSubmitBlankForm() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitBlankForm Test===========");

			customSplfeeHead.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitBlankForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		}
	}

	@Test(priority = 6, dataProvider = "CustomSPlFeeHeadTestData")
	public void tcFill_CustomSpecialFeeHeadForm(String specialFeeHead, String feehead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_CustomSpecialFeeHeadForm Test===========");

			customSplfeeHead.fill_CustomSpecialFeeHeadForm(specialFeeHead, feehead);

			log.info("============= Finished tcFill_CustomSpecialFeeHeadForm Test===========");
			getScreenShot("tcFill_CustomSpecialFeeHeadForm");
		} catch (Exception e) {
			getScreenShot("tcFill_CustomSpecialFeeHeadForm");
		}
	}

	@Test(priority = 7)
	public void tcMinimize_SpecialFeeHead() {

		try {
			log.info("============= Strting tcMinimize_SpecialFeeHead Test===========");

			customSplfeeHead.minimizeAndMaximize_SpecialFeeHead();

			log.info("============= Finished tcMinimize_SpecialFeeHead Test===========");
			getScreenShot("tcMinimize_SpecialFeeHead");
		} catch (Exception e) {
			getScreenShot("tcMinimize_SpecialFeeHead");
		}
	}

	@Test(priority = 8)
	public void tcSortByFeeHead() {

		try {
			log.info("============= Strting tcSortByFeeHead Test===========");
			getScreenShot("BeforeSorting_tcSortByFeeHead");

			customSplfeeHead.sortByFeeHead();

			log.info("============= Finished tcSortByFeeHead Test===========");
			getScreenShot("tcSortByFeeHead");
		} catch (Exception e) {
			getScreenShot("tcSortByFeeHead");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_SpecialHeadGridView() {

		try {
			log.info("============= Strting tcMinimize_SpecialHeadGridView Test===========");

			customSplfeeHead.minimizeAndMaximize_SpecialHeadGridView();

			log.info("============= Finished tcMinimize_SpecialHeadGridView Test===========");
			getScreenShot("tcMinimize_SpecialHeadGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_SpecialHeadGridView");
		}
	}

	@Test(priority = 10)
	public void tcMaximize_SpecialHeadGridView() {

		try {
			log.info("============= Strting tcMaximize_SpecialHeadGridView Test===========");

			customSplfeeHead.minimizeAndMaximize_SpecialHeadGridView();

			log.info("============= Finished tcMaximize_SpecialHeadGridView Test===========");
			getScreenShot("tcMaximize_SpecialHeadGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_SpecialHeadGridView");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_SpecialFeeHead() {

		try {
			log.info("============= Strting tcMaximize_SpecialFeeHead Test===========");

			customSplfeeHead.minimizeAndMaximize_SpecialFeeHead();

			log.info("============= Finished tcMaximize_SpecialFeeHead Test===========");
			getScreenShot("tcMaximize_SpecialFeeHead");
		} catch (Exception e) {
			getScreenShot("tcMaximize_SpecialFeeHead");
		}
	}

	@Test(priority = 12)
	public void tcClickOnCancelButton_ClearFilledForm() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ClearFilledForm Test===========");

			customSplfeeHead.clickOnCancelButton_ClearFilledForm();

			log.info("============= Finished tcClickOnCancelButton_ClearFilledForm Test===========");
			getScreenShot("tcClickOnCancelButton_ClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ClearFilledForm");
		}
	}

	@Test(priority = 13, dataProvider = "CustomSPlFeeHeadTestData")
	public void tcFill_CustomSpecialFeeHeadForm_AfterClearingFilledData(String specialFeeHead, String feehead,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_CustomSpecialFeeHeadForm_AfterClearingFilledData Test===========");

			customSplfeeHead.fill_CustomSpecialFeeHeadForm(specialFeeHead, feehead);

			log.info("============= Finished tcFill_CustomSpecialFeeHeadForm_AfterClearingFilledData Test===========");
			getScreenShot("tcFill_CustomSpecialFeeHeadForm_AfterClearingFilledData");
		} catch (Exception e) {
			getScreenShot("tcFill_CustomSpecialFeeHeadForm_AfterClearingFilledData");
		}
	}

	@Test(priority = 14)
	public void tcClickOnSaveButton() {

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			customSplfeeHead.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 15)
	public void tcPopUpWindowMessage_SubmitSuccessfully() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully Test===========");

			customSplfeeHead.popWindowMessage_SubmitSuccessfully();
		
			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully");
		}
	}

	@Test(priority = 16)
	public void tcClickOnSuccessOkBtn() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			customSplfeeHead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	/**
	 * Search with the created custom special fee head name
	 * 
	 * @param specialFeeHead
	 * @param runMode
	 */

	@Test(priority = 17, dataProvider = "searchBySpecialFeeHeadName")
	public void tcSearchBySpLFeeHeadNameInGrid(String specialfeehead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User Marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyCustomSPLFeeHeadupdatedInGrid Test =============");

			customSplfeeHead.searchBySpLFeeHeadNameInGrid(specialfeehead);

			log.info("============= tcSearchBySpLFeeHeadNameInGrid =============");

			getScreenShot("tcSearchBySpLFeeHeadNameInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchBySpLFeeHeadNameInGrid");
		}
	}

	@Test(priority = 18, dataProvider = "searchBySpecialFeeHeadName")
	public void tcVerifyCustomSPLFeeHeadupdatedInGrid(String specialFeeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyCustomSPLFeeHeadupdatedInGrid Test===========");

			customSplfeeHead.verifyCustomSPLFeeHeadupdatedInGrid(specialFeeHead);

			log.info("============= Finished tcVerifyCustomSPLFeeHeadupdatedInGrid Test===========");
			getScreenShot("tcVerifyCustomSPLFeeHeadupdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyCustomSPLFeeHeadupdatedInGrid");
		}
	}

	@Test(priority = 19, dataProvider = "searchBySpecialFeeHeadName")
	public void tcEdit_CustomSpecialFeeHead(String specialFeeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEdit_CustomSpecialFeeHead Test===========");

			customSplfeeHead.edit_CustomSplFeeHead(specialFeeHead);
			log.info("============= Finished tcEdit_CustomSpecialFeeHead Test===========");
			getScreenShot("tcEdit_CustomSpecialFeeHead");
		} catch (Exception e) {
			getScreenShot("tcEdit_CustomSpecialFeeHead");
		}
	}

	@Test(priority = 20)
	public void tcClickOnSaveButton_CustomSpecialFeeHead_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_CustomSpecialFeeHead_Edit Test===========");

			customSplfeeHead.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_CustomSpecialFeeHead_Edit Test===========");
			getScreenShot("tcClickOnSaveButton_CustomSpecialFeeHead_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_CustomSpecialFeeHead_Edit");
		}
	}
	@Test(priority = 21)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");

			customSplfeeHead.popWindowMessage_SubmitSuccessfully_Edit();
		
			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation");
		}
	}

	@Test(priority = 22)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			customSplfeeHead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	//

	@Test(priority = 23, dataProvider = "searchBySpecialFeeHeadName")
	public void tcSearchBySpLFeeHeadNameInGrid_ForDeactivate(String specialfeehead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBySpLFeeHeadNameInGrid_ForDeactivate Test===========");

			customSplfeeHead.searchBySpLFeeHeadNameInGrid(specialfeehead);

			log.info("============= Finished tcSearchBySpLFeeHeadNameInGrid_ForDeactivate Test===========");
			getScreenShot("tcSearchBySpLFeeHeadNameInGrid_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchBySpLFeeHeadNameInGrid_ForDeactivate");
		}
	}

	@Test(priority = 24, dataProvider = "searchBySpecialFeeHeadName")
	public void tcDeactivationOfCreatedCustomSPLFeeHead(String specialFeeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreatedCustomSPLFeeHead Test===========");

			customSplfeeHead.deactivationOfCreatedCustomSPLFeeHead(specialFeeHead);

			log.info("============= Finished tcDeactivationOfCreatedCustomSPLFeeHead Test===========");
			getScreenShot("tcDeactivationOfCreatedCustomSPLFeeHead");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreatedCustomSPLFeeHead");
		}
	}

	@Test(priority = 25)
	public void tcClickOnCancelButton_PopUp_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_deactivate Test===========");

			customSplfeeHead.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_deactivate Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_deactivate");
		}
	}
	@Test(priority = 26)
	public void tcPopUpWindowMessage_DeactivateCancel_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeactivateCancel_Validation Test===========");

			customSplfeeHead.popUpWindowMessage_DeactivateCancel_Validation();
		
			log.info("============= Finished tcPopUpWindowMessage_DeactivateCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeactivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeactivateCancel_Validation");
		}
	}
	@Test(priority = 27)
	public void tcClickOnOkSuccessButton_deactivateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivateCancel Test===========");

			customSplfeeHead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 28, dataProvider = "searchBySpecialFeeHeadName")
	public void tcSearchBySpLFeeHeadNameInGrid_ForDeactivate_AfterCancel(String specialfeehead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBySpLFeeHeadNameInGrid_ForDeactivate_AfterCancel Test===========");

			customSplfeeHead.searchBySpLFeeHeadNameInGrid(specialfeehead);

			log.info("============= Finished tcSearchBySpLFeeHeadNameInGrid_ForDeactivate_AfterCancel Test===========");
			getScreenShot("tcSearchBySpLFeeHeadNameInGrid_ForDeactivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBySpLFeeHeadNameInGrid_ForDeactivate_AfterCancel");
		}
	}

	@Test(priority = 29, dataProvider = "searchBySpecialFeeHeadName")
	public void tcDeactivationOfCreatedCustomSPLFeeHead_AfterCancel(String specialFeeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreatedCustomSPLFeeHead_AfterCancel Test===========");

			customSplfeeHead.deactivationOfCreatedCustomSPLFeeHead(specialFeeHead);

			log.info("============= Finished tcDeactivationOfCreatedCustomSPLFeeHead_AfterCancel Test===========");
			getScreenShot("tcDeactivationOfCreatedCustomSPLFeeHead_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreatedCustomSPLFeeHead_AfterCancel");
		}
	}

	@Test(priority = 30)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			customSplfeeHead.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}
	@Test(priority = 31)
	public void tcPopUpWindowMessage_DeactivateSucessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeactivateSucessfully_Validation Test===========");

			customSplfeeHead.popUpWindowMessage_DeactivateSucessfully_Validation();
		
			log.info("============= Finished tcPopUpWindowMessage_DeactivateSucessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeactivateSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeactivateSucessfully_Validation");
		}
	}
	@Test(priority = 32)
	public void tcClickOnOkSuccessButton_deactivate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deactivate Test===========");

			customSplfeeHead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}

	@Test(priority = 33, dataProvider = "searchBySpecialFeeHeadName")
	public void tcSearchBySpLFeeHeadNameInGrid_ForActivate(String specialfeehead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBySpLFeeHeadNameInGrid_ForActivate Test===========");

			customSplfeeHead.searchBySpLFeeHeadNameInGrid(specialfeehead);

			log.info("============= Finished tcSearchBySpLFeeHeadNameInGrid_ForActivate Test===========");
			getScreenShot("tcSearchBySpLFeeHeadNameInGrid_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchBySpLFeeHeadNameInGrid_ForActivate");
		}
	}

	@Test(priority = 34, dataProvider = "searchBySpecialFeeHeadName")
	public void tcActivationOfCreatedCustomSPLFeeHead(String specialFeeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreatedCustomSPLFeeHead Test===========");

			customSplfeeHead.activationOfCreatedCustomSPLFeeHead(specialFeeHead);

			log.info("============= Finished tcActivationOfCreatedCustomSPLFeeHead Test===========");
			getScreenShot("tcActivationOfCreatedCustomSPLFeeHead");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedCustomSPLFeeHead");
		}
	}

	@Test(priority = 35)
	public void tcClickOnCancelButton_PopUp_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_activate Test===========");

			customSplfeeHead.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_activate Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_activate");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_activate");
		}
	}
	@Test(priority = 36)
	public void tcPopUpWindowMessage_ActivateCancel_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_ActivateCancel_Validation Test===========");

			customSplfeeHead.popUpWindowMessage_ActivateCancel_Validation();
		
			log.info("============= Finished tcPopUpWindowMessage_ActivateCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_ActivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_ActivateCancel_Validation");
		}
	}
	@Test(priority = 37)
	public void tcClickOnOkSuccessButton_activateCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activateCancel Test===========");

			customSplfeeHead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 38, dataProvider = "searchBySpecialFeeHeadName")
	public void tcSearchBySpLFeeHeadNameInGrid_AfterCancel(String specialfeehead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBySpLFeeHeadNameInGrid_AfterCancel Test===========");

			customSplfeeHead.searchBySpLFeeHeadNameInGrid(specialfeehead);

			log.info("============= Finished tcSearchBySpLFeeHeadNameInGrid_AfterCancel Test===========");
			getScreenShot("tcSearchBySpLFeeHeadNameInGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBySpLFeeHeadNameInGrid_AfterCancel");
		}
	}

	@Test(priority = 39, dataProvider = "searchBySpecialFeeHeadName")
	public void tcActivationOfCreatedCustomSPLFeeHead_AfterCancel(String specialFeeHead, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreatedCustomSPLFeeHead_AfterCancel Test===========");

			customSplfeeHead.activationOfCreatedCustomSPLFeeHead(specialFeeHead);
			log.info("============= Finished tcActivationOfCreatedCustomSPLFeeHead_AfterCancel Test===========");
			getScreenShot("tcActivationOfCreatedCustomSPLFeeHead_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedCustomSPLFeeHead_AfterCancel");
		}
	}

	@Test(priority = 40)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			customSplfeeHead.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_Activate");
		}
	}
	@Test(priority = 41)
	public void tcPopUpWindowMessage_ActivateSucessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_ActivateSucessfully_Validation Test===========");

			customSplfeeHead.popUpWindowMessage_ActivateSucessfully_Validation();
		
			log.info("============= Finished tcPopUpWindowMessage_ActivateSucessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_ActivateSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_ActivateSucessfully_Validation");
		}
	}
	@Test(priority = 42)
	public void tcClickOnOkSuccessButton_activate() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_activate Test===========");

			customSplfeeHead.clickOnSuccessOkBtn();

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
