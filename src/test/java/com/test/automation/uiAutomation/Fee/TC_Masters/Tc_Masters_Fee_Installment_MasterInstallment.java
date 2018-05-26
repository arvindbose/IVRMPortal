/**
 * 
 */
package com.test.automation.uiAutomation.Fee.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Fee.Masters.Masters_Fee_Installment_MasterInstallment;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_Installment_MasterInstallment extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Installment_MasterInstallment.class.getName());

	Masters_Fee_Installment_MasterInstallment feeMasterInstallment;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "FeeInstallmentTestData")
	public String[][] getTestDataFeeGroup() {
		String[][] testRecordsFeeInstallment = getData("FeeModueData.xlsx", "FeeMasterInstallmentData");
		return testRecordsFeeInstallment;
	}

	@DataProvider(name = "FeeInstallmentNameTestData")
	public String[][] getTestDataFeeInsName() {
		String[][] testRecordsFeeInsName = getData("FeeModueData.xlsx", "FeeMasterInstallmentName");
		return testRecordsFeeInsName;
	}
	
	@DataProvider(name = "Search_FeeInstallmentNameData")
	public String[][] getTestDataFeeInsNameSearch() {
		String[][] testRecordsFeeInsNameSearch = getData("FeeModueData.xlsx", "Search_MasterInstallmentName");
		return testRecordsFeeInsNameSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeMasterInstallment = new Masters_Fee_Installment_MasterInstallment(driver);
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

			feeMasterInstallment.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateToFeeInstallment_MasterInstallment() {

		try {
			log.info("============= Strting tcNevigateToFeeInstallment_MasterInstallment Test===========");

			feeMasterInstallment.nevigateToFeeInstallment_MasterInstallment();

			log.info("============= Finished tcNevigateToFeeInstallment_MasterInstallment Test===========");
			getScreenShot("tcNevigateToFeeInstallment_MasterInstallment");
		} catch (Exception e) {
			getScreenShot("tcNevigateToFeeInstallment_MasterInstallment");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeInstallmentScreen() {

		try {
			log.info("============= Strting tcVerifyFeeInstallmentScreen Test===========");

			boolean status = feeMasterInstallment.verifyFeeInstallmentScreen();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeInstallmentScreen Test===========");
			getScreenShot("tcVerifyFeeInstallmentScreen");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeInstallmentScreen");
		}
	}

	@Test(priority = 5, dataProvider = "FeeInstallmentTestData")
	public void tcFillMasterInstallmentForm(String MasterInstallmentName, String MasterInstallmentType,
			String NoOfInstallment, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillMasterInstallmentForm Test===========");

			feeMasterInstallment.fillMasterInstallmentForm(MasterInstallmentName, MasterInstallmentType,
					NoOfInstallment);

			log.info("============= Finished tcFillMasterInstallmentForm Test===========");
			getScreenShot("tcFillMasterInstallmentForm");
		} catch (Exception e) {
			getScreenShot("tcFillMasterInstallmentForm");
		}
	}

	@Test(priority = 6)
	public void tcVerifyFeeInstallmentGridIsPresent() {

		try {
			log.info("============= Strting tcVerifyFeeInstallmentGridIsPresent Test===========");

			boolean status = feeMasterInstallment.verifyFeeInstallmentGridIsPresent();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeInstallmentGridIsPresent Test===========");
			getScreenShot("tcVerifyFeeInstallmentGridIsPresent");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeInstallmentGridIsPresent");
		}
	}

	@Test(priority = 7, dataProvider = "FeeInstallmentNameTestData")
	public void tcEnterNameForSelectedNoOfInstallment(String Installment1, String Installment2, String Installment3,
			String Installment4, String Installment5, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterNameForSelectedNoOfInstallment Test===========");

			feeMasterInstallment.enterNameForSelectedNoOfInstallment(Installment1, Installment2, Installment3,
					Installment4, Installment5);

			log.info("============= Finished tcEnterNameForSelectedNoOfInstallment Test===========");
			getScreenShot("tcEnterNameForSelectedNoOfInstallment");
		} catch (Exception e) {
			getScreenShot("tcEnterNameForSelectedNoOfInstallment");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_MasterInstallment() {

		try {
			log.info("============= Strting tcMinimize_MasterInstallment Test===========");

			feeMasterInstallment.minimizeAndMaximize_MasterInstallment();

			log.info("============= Finished tcMinimize_MasterInstallment Test===========");
			getScreenShot("tcMinimize_MasterInstallment");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterInstallment");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_MasterFeeInstallmentGridView() {

		try {
			log.info("============= Strting tcMinimize_MasterFeeInstallmentGridView Test===========");

			feeMasterInstallment.minimizeAndMaximize_MasterFeeInstallmentGridView();

			log.info("============= Finished tcMinimize_MasterFeeInstallmentGridView Test===========");
			getScreenShot("tcMinimize_MasterFeeInstallmentGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterFeeInstallmentGridView");
		}
	}

	@Test(priority = 10)
	public void tcSortByMasterInstallmentName() {

		try {
			log.info("============= Strting tcSortByMasterInstallmentName Test===========");
			getScreenShot("BeforeSorting_tcSortByMasterInstallmentName");

			feeMasterInstallment.sortByMasterInstallmentName();

			log.info("============= Finished tcSortByMasterInstallmentName Test===========");
			getScreenShot("tcSortByMasterInstallmentName");
		} catch (Exception e) {
			getScreenShot("tcSortByMasterInstallmentName");
		}
	}

	@Test(priority = 11)
	public void tcMinimize_FeeMasterInstallmentGridView() {

		try {
			log.info("============= Strting tcMinimize_FeeMasterInstallmentGridView Test===========");

			feeMasterInstallment.minimizeAndMaximize_FeeMasterInstallmentGridView();

			log.info("============= Finished tcMinimize_FeeMasterInstallmentGridView Test===========");
			getScreenShot("tcMinimize_FeeMasterInstallmentGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeMasterInstallmentGridView");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_FeeMasterInstallmentGridView() {

		try {
			log.info("============= Strting tcMaximize_FeeMasterInstallmentGridView Test===========");

			feeMasterInstallment.minimizeAndMaximize_FeeMasterInstallmentGridView();

			log.info("============= Finished tcMaximize_FeeMasterInstallmentGridView Test===========");
			getScreenShot("tcMaximize_FeeMasterInstallmentGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeMasterInstallmentGridView");
		}
	}

	@Test(priority = 13)
	public void tcMaximize_MasterFeeInstallmentGridView() {

		try {
			log.info("============= Strting tcMaximize_MasterFeeInstallmentGridView Test===========");

			feeMasterInstallment.minimizeAndMaximize_MasterFeeInstallmentGridView();

			log.info("============= Finished tcMaximize_MasterFeeInstallmentGridView Test===========");
			getScreenShot("tcMaximize_MasterFeeInstallmentGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterFeeInstallmentGridView");
		}
	}

	@Test(priority = 14)
	public void tcMaximize_MasterInstallment() {

		try {
			log.info("============= Strting tcMaximize_MasterInstallment Test===========");

			feeMasterInstallment.minimizeAndMaximize_MasterInstallment();

			log.info("============= Finished tcMaximize_MasterInstallment Test===========");
			getScreenShot("tcMaximize_MasterInstallment");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterInstallment");
		}
	}

	@Test(priority = 15)
	public void tcClickOnCancelButton_ToClearedFilledForm() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearedFilledForm Test===========");

			feeMasterInstallment.clickOnCancelButton_ToClearedFilledForm();

			log.info("============= Finished tcClickOnCancelButton_ToClearedFilledForm Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearedFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearedFilledForm");
		}
	}

	@Test(priority = 16, dataProvider = "FeeInstallmentTestData")
	public void tcFillMasterInstallmentForm_AfterClearingData(String MasterInstallmentName,
			String MasterInstallmentType, String NoOfInstallment, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFillMasterInstallmentForm_AfterClearingData Test===========");

			feeMasterInstallment.fillMasterInstallmentForm(MasterInstallmentName, MasterInstallmentType,
					NoOfInstallment);

			log.info("============= Finished tcFillMasterInstallmentForm_AfterClearingData Test===========");
			getScreenShot("tcFillMasterInstallmentForm_AfterClearingData");
		} catch (Exception e) {
			getScreenShot("tcFillMasterInstallmentForm_AfterClearingData");
		}
	}

	@Test(priority = 17)
	public void tcVerifyFeeInstallmentGridIsPresent_AfterClearingData() {

		try {
			log.info("============= Strting tcVerifyFeeInstallmentGridIsPresent_AfterClearingData Test===========");

			boolean status = feeMasterInstallment.verifyFeeInstallmentGridIsPresent();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeInstallmentGridIsPresent_AfterClearingData Test===========");
			getScreenShot("tcVerifyFeeInstallmentGridIsPresent_AfterClearingData");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeInstallmentGridIsPresent_AfterClearingData");
		}
	}

	@Test(priority = 18, dataProvider = "FeeInstallmentNameTestData")
	public void tcEnterNameForSelectedNoOfInstallment_AfterClearingData(String Installment1, String Installment2,
			String Installment3, String Installment4, String Installment5, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterNameForSelectedNoOfInstallment_AfterClearingData Test===========");

			feeMasterInstallment.enterNameForSelectedNoOfInstallment(Installment1, Installment2, Installment3,
					Installment4, Installment5);

			log.info("============= Finished tcEnterNameForSelectedNoOfInstallment_AfterClearingData Test===========");
			getScreenShot("tcEnterNameForSelectedNoOfInstallment_AfterClearingData");
		} catch (Exception e) {
			getScreenShot("tcEnterNameForSelectedNoOfInstallment_AfterClearingData");
		}
	}

	@Test(priority = 19)
	public void tcClickOnSaveButton() {

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			feeMasterInstallment.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 20)
	public void tcVerifySuccessfulPopUp() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status = feeMasterInstallment.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}

	@Test(priority = 21)
	public void tcClickOnSuccessOkBtn() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			feeMasterInstallment.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	@Test(priority = 22, dataProvider = "Search_FeeInstallmentNameData")
	public void tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView Test===========");

			feeMasterInstallment.searchBy_InstallmentName_InFeeMasterInstallmentGridView(installmentName);

			log.info(
					"============= Finished tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView Test===========");
			getScreenShot("tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView");
		}
	}

	@Test(priority = 23, dataProvider = "Search_FeeInstallmentNameData")
	public void tcVerifyMasterFeeInstallment_UpdatedInGrid(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyMasterFeeInstallment_UpdatedInGrid Test===========");

			feeMasterInstallment.verifyMasterFeeInstallment_UpdatedInGrid(installmentName);

			log.info("============= Finished tcVerifyMasterFeeInstallment_UpdatedInGrid Test===========");
			getScreenShot("tcVerifyMasterFeeInstallment_UpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasterFeeInstallment_UpdatedInGrid");
		}
	}

	@Test(priority = 24, dataProvider = "Search_FeeInstallmentNameData")
	public void tcEdit_MasterFeeInstallment(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEdit_MasterFeeInstallment Test===========");

			feeMasterInstallment.edit_MasterFeeInstallment(installmentName);
			log.info("============= Finished tcEdit_MasterFeeInstallment Test===========");
			getScreenShot("tcEdit_MasterFeeInstallment");
		} catch (Exception e) {
			getScreenShot("tcEdit_MasterFeeInstallment");
		}
	}

	@Test(priority = 25)
	public void tcClickOnSaveButton_MasterFeeInstallmentForm_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_MasterFeeInstallmentForm_Edit Test===========");

			feeMasterInstallment.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_MasterFeeInstallmentForm_Edit Test===========");
			getScreenShot("tcClickOnSaveButton_MasterFeeInstallmentForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_MasterFeeInstallmentForm_Edit");
		}
	}

	@Test(priority = 26)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			feeMasterInstallment.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	//

	@Test(priority = 27, dataProvider = "Search_FeeInstallmentNameData")
	public void tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForDeactivate(String installmentName,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForDeactivate Test===========");

			feeMasterInstallment.searchBy_InstallmentName_InFeeMasterInstallmentGridView(installmentName);

			log.info(
					"============= Finished tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForDeactivate Test===========");
			getScreenShot("tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForDeactivate");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForDeactivate");
		}
	}

	@Test(priority = 28, dataProvider = "Search_FeeInstallmentNameData")
	public void tcDeactivationOfCreated_MasterFeeInstallment(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_MasterFeeInstallment Test===========");

			feeMasterInstallment.deactivationOfCreated_MasterFeeInstallment(installmentName);

			log.info("============= Finished tcDeactivationOfCreated_MasterFeeInstallment Test===========");
			getScreenShot("tcDeactivationOfCreated_MasterFeeInstallment");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_MasterFeeInstallment");
		}
	}

	@Test(priority = 29)
	public void tcClickOnCancelButton_PopUp_deactivate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_deactivate Test===========");

			feeMasterInstallment.clickOnCancelButton_PopUp();

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

			feeMasterInstallment.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivateCancel");
		}
	}

	@Test(priority = 31, dataProvider = "Search_FeeInstallmentNameData")
	public void tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForDeactivate_AfterCancel(
			String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForDeactivate_AfterCancel Test===========");

			feeMasterInstallment.searchBy_InstallmentName_InFeeMasterInstallmentGridView(installmentName);

			log.info(
					"============= Finished tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForDeactivate_AfterCancel Test===========");
			getScreenShot("tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForDeactivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForDeactivate_AfterCancel");
		}
	}

	@Test(priority = 32, dataProvider = "Search_FeeInstallmentNameData")
	public void tcDeactivationOfCreated_MasterFeeInstallment_AfterCancel(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_MasterFeeInstallment_AfterCancel Test===========");

			feeMasterInstallment.deactivationOfCreated_MasterFeeInstallment(installmentName);

			log.info("============= Finished tcDeactivationOfCreated_MasterFeeInstallment_AfterCancel Test===========");
			getScreenShot("tcDeactivationOfCreated_MasterFeeInstallment_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_MasterFeeInstallment_AfterCancel");
		}
	}

	@Test(priority = 33)
	public void tcYesDeleteOrDeactivateOrActivateIt_deactivate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			feeMasterInstallment.yesDeleteOrDeactivateOrActivateIt();

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

			feeMasterInstallment.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_deactivate Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deactivate");
		}
	}

	@Test(priority = 35, dataProvider = "Search_FeeInstallmentNameData")
	public void tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForActivate(String installmentName,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForActivate Test===========");

			feeMasterInstallment.searchBy_InstallmentName_InFeeMasterInstallmentGridView(installmentName);

			log.info(
					"============= Finished tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForActivate Test===========");
			getScreenShot("tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_ForActivate");
		}
	}

	@Test(priority = 36, dataProvider = "Search_FeeInstallmentNameData")
	public void tcActivationOfCreatedFeeInstallment_MasterInstallment(String installmentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreatedFeeInstallment_MasterInstallment Test===========");

			feeMasterInstallment.activationOfCreatedFeeInstallment_MasterInstallment(installmentName);

			log.info("============= Finished tcActivationOfCreatedFeeInstallment_MasterInstallment Test===========");
			getScreenShot("tcActivationOfCreatedFeeInstallment_MasterInstallment");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedFeeInstallment_MasterInstallment");
		}
	}

	@Test(priority = 37)
	public void tcClickOnCancelButton_PopUp_activate() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_activate Test===========");

			feeMasterInstallment.clickOnCancelButton_PopUp();

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

			feeMasterInstallment.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_activateCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_activateCancel");
		}
	}

	@Test(priority = 39, dataProvider = "Search_FeeInstallmentNameData")
	public void tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_AfterCancel(String installmentName,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_AfterCancel Test===========");

			feeMasterInstallment.searchBy_InstallmentName_InFeeMasterInstallmentGridView(installmentName);

			log.info(
					"============= Finished tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_AfterCancel Test===========");
			getScreenShot("tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchBy_InstallmentName_InFeeMasterInstallmentGridView_AfterCancel");
		}
	}

	@Test(priority = 40, dataProvider = "Search_FeeInstallmentNameData")
	public void tcActivationOfCreatedFeeInstallment_MasterInstallment_AfterCancel(String installmentName,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcActivationOfCreatedFeeInstallment_MasterInstallment_AfterCancel Test===========");

			feeMasterInstallment.activationOfCreatedFeeInstallment_MasterInstallment(installmentName);
			log.info(
					"============= Finished tcActivationOfCreatedFeeInstallment_MasterInstallment_AfterCancel Test===========");
			getScreenShot("tcActivationOfCreatedFeeInstallment_MasterInstallment_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedFeeInstallment_MasterInstallment_AfterCancel");
		}
	}

	@Test(priority = 41)
	public void tcYesDeleteOrDeactivateOrActivateIt_Activate() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_Activate Test===========");

			feeMasterInstallment.yesDeleteOrDeactivateOrActivateIt();

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

			feeMasterInstallment.clickOnSuccessOkBtn();

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
