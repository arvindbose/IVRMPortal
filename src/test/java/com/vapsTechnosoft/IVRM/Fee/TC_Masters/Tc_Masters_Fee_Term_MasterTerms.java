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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Fee_Term_MasterTerms;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_Term_MasterTerms extends TestBase{
	
	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Term_MasterTerms.class.getName());

	Masters_Fee_Term_MasterTerms feeTerm;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name = "FeeTermTestData")
	public String[][] getTestDataFeeTerm() {
		String[][] testRecordsFeeTerm = getData("FeeModueData.xlsx", "FeeTermMasterData");
		return testRecordsFeeTerm;
	}
	@DataProvider(name = "FeeTermNewTestData")
	public String[][] getTestDataFeeTermNew() {
		String[][] testRecordsFeeTermEdit = getData("FeeModueData.xlsx", "FeeTermMasterEditData");
		return testRecordsFeeTermEdit;
	}
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
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
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			feeTerm.verifyHomeButton();
			
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}
	@Test(priority = 3)
	public void tcNevigateToMasters_FeeTermMasterTerm() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcNevigateToMasters_FeeTermMasterTerm Test===========");

			feeTerm.nevigateToMasters_FeeTermMasterTerm();
			
			log.info("============= Finished tcNevigateToMasters_FeeTermMasterTerm Test===========");
			getScreenShot("tcNevigateToMasters_FeeTermMasterTerm");
		} catch (Exception e) {
			getScreenShot("tcNevigateToMasters_FeeTermMasterTerm");
		}
	}
	@Test(priority = 4)
	public void tcVerifyFeeTermPage() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcVerifyFeeTermPage Test===========");

			boolean status =feeTerm.verifyFeeTermPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeTermPage Test===========");
			getScreenShot("tcVerifyFeeTermPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeTermPage");
		}
	}
	@Test(priority = 5)
	public void tcClickOnSaveButton_ToSubmitBlankForm() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitBlankForm Test===========");

			feeTerm.clickOnSaveButton_ToSubmitBlankForm();
			
			log.info("============= Finished tcClickOnSaveButton_ToSubmitBlankForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		}
	}
	
	@Test(priority = 6, dataProvider = "FeeTermTestData")
	public void tcMastersFeeMasterTerms(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMastersFeeMasterTerms Test===========");

			feeTerm.mastersFeeMasterTerms(feeTermName);
			
			log.info("============= Finished tcMastersFeeMasterTerms Test===========");
			getScreenShot("tcMastersFeeMasterTerms");
		} catch (Exception e) {
			getScreenShot("tcMastersFeeMasterTerms");
		}
	}
	@Test(priority = 7)
	public void tcMinimize_MasterFeeTerm() {
		
		try {
			log.info("============= Strting tcMinimize_MasterFeeTerm Test===========");

			feeTerm.minimizeAndMaximize_FeeTerm();
			
			log.info("============= Finished tcMinimize_MasterFeeTerm Test===========");
			getScreenShot("tcMinimize_MasterFeeTerm");
		} catch (Exception e) {
			getScreenShot("tcMinimize_MasterFeeTerm");
		}
	}
	@Test(priority = 8)
	public void tcSortByFeeTermName() {

		try {
			log.info("============= Strting tcSortByFeeTermName Test===========");
			getScreenShot("tcSortByFeeTermName_BeforeSorting");

			feeTerm.sortByFeeTermName();

			log.info("============= Finished tcSortByFeeTermName Test===========");
			getScreenShot("tcSortByFeeTermName");
		} catch (Exception e) {
			getScreenShot("tcSortByFeeTermName");
		}
	}
	@Test(priority = 9)
	public void tcMinimize_FeeMasterTermGridView() {
		
		try {
			log.info("============= Strting tcMinimize_FeeMasterTermGridView Test===========");

			feeTerm.minimizeAndMaximize_FeeMasterTermGridView();
			
			log.info("============= Finished tcMinimize_FeeMasterTermGridView Test===========");
			getScreenShot("tcMinimize_FeeMasterTermGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeMasterTermGridView");
		}
	}
	@Test(priority = 10)
	public void tcMaximize_FeeMasterTermGridView() {
		
		try {
			log.info("============= Strting tcMaximize_FeeMasterTermGridView Test===========");

			feeTerm.minimizeAndMaximize_FeeMasterTermGridView();
			
			log.info("============= Finished tcMaximize_FeeMasterTermGridView Test===========");
			getScreenShot("tcMaximize_FeeMasterTermGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeMasterTermGridView");
		}
	}
	@Test(priority = 11)
	public void tcMaximize_MasterFeeTerm() {
		
		try {
			log.info("============= Strting tcMaximize_MasterFeeTerm Test===========");

			feeTerm.minimizeAndMaximize_FeeTerm();
			
			log.info("============= Finished tcMaximize_MasterFeeTerm Test===========");
			getScreenShot("tcMaximize_MasterFeeTerm");
		} catch (Exception e) {
			getScreenShot("tcMaximize_MasterFeeTerm");
		}
	}
	@Test(priority = 12)
	public void tcClickOnCancelButton_ToClearFilledData() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearFilledData Test===========");

			feeTerm.clickOnCancelButton_ToClearFilledData();
			
			log.info("============= Finished tcClickOnCancelButton_ToClearFilledData Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledData");
		}
	}
	//
	@Test(priority = 13, dataProvider = "FeeTermTestData")
	public void tcMastersFeeMasterTerms_AfterCancel(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMastersFeeMasterTerms_AfterCancel Test===========");

			feeTerm.mastersFeeMasterTerms(feeTermName);
			
			log.info("============= Finished tcMastersFeeMasterTerms_AfterCancel Test===========");
			getScreenShot("tcMastersFeeMasterTerms_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcMastersFeeMasterTerms_AfterCancel");
		}
	}
	@Test(priority = 14)
	public void tcClickOnSaveButton() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			feeTerm.clickOnSaveButton();
			
			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}
	@Test(priority = 15)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			feeTerm.popWindowMessage_SubmitSuccessfully();

			
			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}
	@Test(priority = 16)
	public void tcClickOnSuccessOkBtn() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			feeTerm.clickOnSuccessOkBtn();
			
			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}
	@Test(priority = 17, dataProvider = "FeeTermTestData")
	public void tcSearchTermByTermName(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchTermByTermName Test===========");

			feeTerm.searchTermByTermName(feeTermName);
			
			log.info("============= Finished tcSearchTermByTermName Test===========");
			getScreenShot("tcSearchTermByTermName");
		} catch (Exception e) {
			getScreenShot("tcSearchTermByTermName");
		}
	}
	@Test(priority = 18, dataProvider = "FeeTermTestData")
	public void tcVerifyTermNameUpdatedInGrid(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyTermNameUpdatedInGrid Test===========");

			feeTerm.verifyTermNameUpdatedInGrid(feeTermName);
			
			log.info("============= Finished tcVerifyTermNameUpdatedInGrid Test===========");
			getScreenShot("tcVerifyTermNameUpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyTermNameUpdatedInGrid");
		}
	}
	@Test(priority = 19, dataProvider = "FeeTermTestData")
	public void tcDeactivationOfCreatedTerm(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreatedTerm Test===========");

			feeTerm.deactivationOfCreatedTerm(feeTermName);
			
			log.info("============= Finished tcDeactivationOfCreatedTerm Test===========");
			getScreenShot("tcDeactivationOfCreatedTerm");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreatedTerm");
		}
	}
	@Test(priority = 20)
	public void tcClickOnCancelButton_PopUp_ForDeactivation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_ForDeactivation Test===========");

			feeTerm.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_ForDeactivation Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_ForDeactivation");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_ForDeactivation");
		}
	}
	@Test(priority = 21)
	public void tcPopUpWindowMessage_DeactivateCancel_Validation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeactivateCancel_Validation Test===========");

			feeTerm.popUpWindowMessage_DeactivateCancel_Validation();

			log.info("============= Finished tcPopUpWindowMessage_DeactivateCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeactivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeactivateCancel_Validation");
		}
	}
	@Test(priority = 22)
	public void tcClickOnOkButton_DeactivateCancel() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnOkButton_DeactivateCancel Test===========");

			feeTerm.clickOnDeactivationFinalOkBtn();

			log.info("============= Finished tcClickOnOkButton_DeactivateCancel Test===========");
			getScreenShot("tcClickOnOkButton_DeactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButton_DeactivateCancel");
		}
	}
	//
	@Test(priority = 23, dataProvider = "FeeTermTestData")
	public void tcSearchTermByTermName_AfterDeactivateCancel(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchTermByTermName_AfterDeactivateCancel Test===========");

			feeTerm.searchTermByTermName(feeTermName);
			
			log.info("============= Finished tcSearchTermByTermName_AfterDeactivateCancel Test===========");
			getScreenShot("tcSearchTermByTermName_AfterDeactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchTermByTermName_AfterDeactivateCancel");
		}
	}
	@Test(priority = 24, dataProvider = "FeeTermTestData")
	public void tcVerifyTermNameUpdatedInGrid_AfterDeactivateCancel(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyTermNameUpdatedInGrid_AfterDeactivateCancel Test===========");

			feeTerm.verifyTermNameUpdatedInGrid(feeTermName);
			
			log.info("============= Finished tcVerifyTermNameUpdatedInGrid_AfterDeactivateCancel Test===========");
			getScreenShot("tcVerifyTermNameUpdatedInGrid_AfterDeactivateCancel");
		} catch (Exception e) {
			getScreenShot("tcVerifyTermNameUpdatedInGrid_AfterDeactivateCancel");
		}
	}
	@Test(priority = 25, dataProvider = "FeeTermTestData")
	public void tcDeactivationOfCreatedTerm_AfterDeactivateCancel(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreatedTerm Test===========");

			feeTerm.deactivationOfCreatedTerm(feeTermName);
			
			log.info("============= Finished tcDeactivationOfCreatedTerm Test===========");
			getScreenShot("tcDeactivationOfCreatedTerm");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreatedTerm");
		}
	}
	@Test(priority = 26)
	public void tcClickOnYesDeleteOrDeactivateOrActivateIt_PopUp_ForDeactivation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnYesDeleteOrDeactivateOrActivateIt_PopUp_ForDeactivation Test===========");

			feeTerm.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcClickOnYesDeleteOrDeactivateOrActivateIt_PopUp_ForDeactivation Test===========");
			getScreenShot("tcClickOnYesDeleteOrDeactivateOrActivateIt_PopUp_ForDeactivation");
		} catch (Exception e) {
			getScreenShot("tcClickOnYesDeleteOrDeactivateOrActivateIt_PopUp_ForDeactivation");
		}
	}
	@Test(priority = 27)
	public void tcPopUpWindowMessage_DeactivateSucessfully_Validation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeactivateSucessfully_Validation Test===========");

			feeTerm.popUpWindowMessage_DeactivateSucessfully_Validation();

			log.info("============= Finished tcPopUpWindowMessage_DeactivateSucessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeactivateSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeactivateSucessfully_Validation");
		}
	}
	@Test(priority = 28)
	public void tcClickOnOkButton_DeactivateSucessfully() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnOkButton_DeactivateSucessfully Test===========");

			feeTerm.clickOnDeactivationFinalOkBtn();

			log.info("============= Finished tcClickOnOkButton_DeactivateSucessfully Test===========");
			getScreenShot("tcClickOnOkButton_DeactivateSucessfully");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButton_DeactivateSucessfully");
		}
	}
	//Activation
	@Test(priority = 29, dataProvider = "FeeTermTestData")
	public void tcSearchTermByTermName_ToActivate(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchTermByTermName_ToActivate Test===========");

			feeTerm.searchTermByTermName(feeTermName);
			
			log.info("============= Finished tcSearchTermByTermName_ToActivate Test===========");
			getScreenShot("tcSearchTermByTermName_ToActivate");
		} catch (Exception e) {
			getScreenShot("tcSearchTermByTermName_ToActivate");
		}
	}
	@Test(priority = 30, dataProvider = "FeeTermTestData")
	public void tcVerifyTermNameUpdatedInGrid_ToActivate(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyTermNameUpdatedInGrid_ToActivate Test===========");

			feeTerm.verifyTermNameUpdatedInGrid(feeTermName);
			
			log.info("============= Finished tcVerifyTermNameUpdatedInGrid_ToActivate Test===========");
			getScreenShot("tcVerifyTermNameUpdatedInGrid_ToActivate");
		} catch (Exception e) {
			getScreenShot("tcVerifyTermNameUpdatedInGrid_ToActivate");
		}
	}
	@Test(priority = 31, dataProvider = "FeeTermTestData")
	public void tcActivationOfCreatedTerm(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreatedTerm Test===========");

			feeTerm.activationOfCreatedTerm(feeTermName);
			
			log.info("============= Finished tcActivationOfCreatedTerm Test===========");
			getScreenShot("tcActivationOfCreatedTerm");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedTerm");
		}
	}
	@Test(priority = 32)
	public void tcClickOnCancelButton_PopUp_ForActivation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_ForActivation Test===========");

			feeTerm.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_ForActivation Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_ForActivation");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_ForActivation");
		}
	}
	@Test(priority = 33)
	public void tcPopUpWindowMessage_ActivateCancel_Validation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_ActivateCancel_Validation Test===========");

			feeTerm.popUpWindowMessage_ActivateCancel_Validation();

			log.info("============= Finished tcPopUpWindowMessage_ActivateCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_ActivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_ActivateCancel_Validation");
		}
	}
	@Test(priority = 34)
	public void tcClickOnOkButton_ActivateCancel() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnOkButton_ActivateCancel Test===========");

			feeTerm.clickOnDeactivationFinalOkBtn();

			log.info("============= Finished tcClickOnOkButton_ActivateCancel Test===========");
			getScreenShot("tcClickOnOkButton_ActivateCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButton_ActivateCancel");
		}
	}
	//
	@Test(priority = 35, dataProvider = "FeeTermTestData")
	public void tcSearchTermByTermName_ToActivate_AfterCancel(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchTermByTermName_ToActivate_AfterCancel Test===========");

			feeTerm.searchTermByTermName(feeTermName);
			
			log.info("============= Finished tcSearchTermByTermName_ToActivate_AfterCancel Test===========");
			getScreenShot("tcSearchTermByTermName_ToActivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchTermByTermName_ToActivate_AfterCancel");
		}
	}
	@Test(priority = 36, dataProvider = "FeeTermTestData")
	public void tcVerifyTermNameUpdatedInGrid_ToActivate_AfterCancel(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyTermNameUpdatedInGrid_ToActivate_AfterCancel Test===========");

			feeTerm.verifyTermNameUpdatedInGrid(feeTermName);
			
			log.info("============= Finished tcVerifyTermNameUpdatedInGrid_ToActivate_AfterCancel Test===========");
			getScreenShot("tcVerifyTermNameUpdatedInGrid_ToActivate_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcVerifyTermNameUpdatedInGrid_ToActivate_AfterCancel");
		}
	}
	@Test(priority = 37, dataProvider = "FeeTermTestData")
	public void tcActivationOfCreatedTerm_AfterCancel(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreatedTerm_AfterCancel Test===========");

			feeTerm.activationOfCreatedTerm(feeTermName);
			
			log.info("============= Finished tcActivationOfCreatedTerm_AfterCancel Test===========");
			getScreenShot("tcActivationOfCreatedTerm_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedTerm_AfterCancel");
		}
	}
	@Test(priority = 38)
	public void tcYesDeleteOrDeactivateOrActivateIt_ForActivation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_ForActivation Test===========");

			feeTerm.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_ForActivation Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_ForActivation");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_ForActivation");
		}
	}
	@Test(priority = 39)
	public void tcPopUpWindowMessage_ActivateSucessfully_Validation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_ActivateSucessfully_Validation Test===========");

			feeTerm.popUpWindowMessage_ActivateSucessfully_Validation();

			log.info("============= Finished tcPopUpWindowMessage_ActivateSucessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_ActivateSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_ActivateSucessfully_Validation");
		}
	}
	@Test(priority = 40)
	public void tcClickOnOkButton_ActivateSucessfully() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnOkButton_ActivateSucessfully Test===========");

			feeTerm.clickOnActivationFinalOkBtn();

			log.info("============= Finished tcClickOnOkButton_ActivateSucessfully Test===========");
			getScreenShot("tcClickOnOkButton_ActivateSucessfully");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkButton_ActivateSucessfully");
		}
	}
	//Edit
	@Test(priority = 41, dataProvider = "FeeTermTestData")
	public void tcSearchTermByTermName_ToEdit(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchTermByTermName_ToEdit Test===========");

			feeTerm.searchTermByTermName(feeTermName);
			
			log.info("============= Finished tcSearchTermByTermName_ToEdit Test===========");
			getScreenShot("tcSearchTermByTermName_ToEdit");
		} catch (Exception e) {
			getScreenShot("tcSearchTermByTermName_ToEdit");
		}
	}
	@Test(priority = 42, dataProvider = "FeeTermTestData")
	public void tcEditFeeTerm_MasterTerm(String feeTermName,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditFeeTerm_MasterTerm Test===========");

			feeTerm.editFeeTerm_MasterTerm(feeTermName);
			
			log.info("============= Finished tcEditFeeTerm_MasterTerm Test===========");
			getScreenShot("tcEditFeeTerm_MasterTerm");
		} catch (Exception e) {
			getScreenShot("tcEditFeeTerm_MasterTerm");
		}
	}
//	@Test(priority = 43, dataProvider = "FeeTermNewTestData")
//	public void tcEditmastersFeeMasterTerms(String feeTermNameNew,String runMode) {
//		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
//		if(runMode.equalsIgnoreCase("n")){
//			throw new SkipException("user marked this record as no run");
//		}
//		try {
//			log.info("============= Strting tcEditmastersFeeMasterTerms Test===========");
//
//			feeTerm.editmastersFeeMasterTerms(feeTermNameNew);
//			
//			log.info("============= Finished tcEditmastersFeeMasterTerms Test===========");
//			getScreenShot("tcEditmastersFeeMasterTerms");
//		} catch (Exception e) {
//			getScreenShot("tcEditmastersFeeMasterTerms");
//		}
//	}
	
	@Test(priority = 44)
	public void tcClickOnSaveButtonEdit() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnSaveButtonEdit Test===========");

			feeTerm.clickOnSaveButtonEdit();
			
			log.info("============= Finished tcClickOnSaveButtonEdit Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}
	@Test(priority = 45)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Edit() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Edit Test===========");

			feeTerm.popWindowMessage_SubmitSuccessfully_Edit();
		
			
			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Edit Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit");
		}
	}
	@Test(priority = 46)
	public void tcClickOnSuccessOkBtnEdit() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtnEdit Test===========");

			feeTerm.clickOnSuccessOkBtnEdit();
			
			log.info("============= Finished tcClickOnSuccessOkBtnEdit Test===========");
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtnEdit");
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
