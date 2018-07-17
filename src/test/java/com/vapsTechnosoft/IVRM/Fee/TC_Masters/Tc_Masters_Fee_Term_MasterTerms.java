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
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

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
	@Test(priority = 5, dataProvider = "FeeTermTestData")
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
	@Test(priority = 6)
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
	@Test(priority = 7)
	public void tcVerifySuccessfulPopUp() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status =feeTerm.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}
	@Test(priority = 8)
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
	@Test(priority = 9, dataProvider = "FeeTermTestData")
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
	@Test(priority = 10, dataProvider = "FeeTermTestData")
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
	@Test(priority = 11, dataProvider = "FeeTermTestData")
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
	@Test(priority = 12)
	public void tcConfirmationForDeactivation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcConfirmationForDeactivation Test===========");

			feeTerm.confirmationForDeactivation();

			log.info("============= Finished tcConfirmationForDeactivation Test===========");
			getScreenShot("tcConfirmationForDeactivation");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForDeactivation");
		}
	}
	@Test(priority = 13)
	public void tcVerifyDeactivationSuccessfulPopUp() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcVerifyDeactivationSuccessfulPopUp Test===========");

			boolean status = feeTerm.verifyDeactivationSuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifyDeactivationSuccessfulPopUp Test===========");
			getScreenShot("tcVerifyDeactivationSuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifyDeactivationSuccessfulPopUp");
		}
	}
	@Test(priority = 14)
	public void tcClickOnDeactivationFinalOkBtn() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnDeactivationFinalOkBtn Test===========");

			feeTerm.clickOnDeactivationFinalOkBtn();

			log.info("============= Finished tcClickOnDeactivationFinalOkBtn Test===========");
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		}
	}
	//Activation
	
	@Test(priority = 15, dataProvider = "FeeTermTestData")
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
	@Test(priority = 16)
	public void tcConfirmationForActivation() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcConfirmationForActivation Test===========");

			feeTerm.confirmationForActivation();

			log.info("============= Finished tcConfirmationForActivation Test===========");
			getScreenShot("tcConfirmationForActivation");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForActivation");
		}
	}
	@Test(priority = 17)
	public void tcVerifyActivationSuccessfulPopUp() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcVerifyActivationSuccessfulPopUp Test===========");

			boolean status = feeTerm.verifyActivationSuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifyActivationSuccessfulPopUp Test===========");
			getScreenShot("tcVerifyActivationSuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifyActivationSuccessfulPopUp");
		}
	}
	@Test(priority = 18)
	public void tcClickOnActivationFinalOkBtn() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcClickOnActivationFinalOkBtn Test===========");

			feeTerm.clickOnActivationFinalOkBtn();

			log.info("============= Finished tcClickOnActivationFinalOkBtn Test===========");
			getScreenShot("tcClickOnActivationFinalOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnActivationFinalOkBtn");
		}
	}
	
	@Test(priority = 19, dataProvider = "FeeTermTestData")
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
	@Test(priority = 20, dataProvider = "FeeTermNewTestData")
	public void tcEditmastersFeeMasterTerms(String feeTermNameNew,String runMode) {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditmastersFeeMasterTerms Test===========");

			feeTerm.editmastersFeeMasterTerms(feeTermNameNew);
			
			log.info("============= Finished tcEditmastersFeeMasterTerms Test===========");
			getScreenShot("tcEditmastersFeeMasterTerms");
		} catch (Exception e) {
			getScreenShot("tcEditmastersFeeMasterTerms");
		}
	}
	
	@Test(priority = 21)
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
	@Test(priority = 22)
	public void tcVerifySuccessfulPopUpEdit() {
		feeTerm = new Masters_Fee_Term_MasterTerms(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUpEdit Test===========");

			boolean status =feeTerm.verifySuccessfulPopUpEdit();
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcVerifySuccessfulPopUpEdit Test===========");
			getScreenShot("tcVerifySuccessfulPopUpEdit");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUpEdit");
		}
	}
	@Test(priority = 23)
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
