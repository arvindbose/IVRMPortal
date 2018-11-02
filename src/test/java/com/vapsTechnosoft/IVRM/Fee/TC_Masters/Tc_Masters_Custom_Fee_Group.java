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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Custom_Fee_Group;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Custom_Fee_Group extends TestBase{

	public static final Logger log = Logger.getLogger(Tc_Masters_Custom_Fee_Group.class.getName());

	Masters_Custom_Fee_Group customfeegroup;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name = "CustomFeeGroupTestData")
	public String[][] getTestDataCFG() {
		String[][] testRecordsCFG = getData("FeeModueData.xlsx", "CustomFeeGroupData");
		return testRecordsCFG;
	}
	@DataProvider(name = "CustomGroupNameTestData")
	public String[][] getTestDataGrName() {
		String[][] testRecordsCGrName = getData("FeeModueData.xlsx", "CreatedCustomNameData");
		return testRecordsCGrName;
	}
	
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		customfeegroup = new Masters_Custom_Fee_Group(driver);
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

			boolean status = customfeegroup.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}
	@Test(priority = 3)
	public void tcNavigateToMasters_Custom_FeeGroup() {
	

		try {
			log.info("============= Strting tcNevigateToMasters_Custom_FeeGroup Test===========");

			customfeegroup.navigateToMasters_Custom_FeeGroup();
			
			log.info("============= Finished tcNevigateToMasters_Custom_FeeGroup Test===========");
			getScreenShot("tcNevigateToMasters_Custom_FeeGroup");
		} catch (Exception e) {
			getScreenShot("tcNevigateToMasters_Custom_FeeGroup");
		}
	}
	@Test(priority = 4)
	public void tcVerifyCustomFeeGroupPage() {
		

		try {
			log.info("============= Strting tcVerifyCustomFeeGroupPage Test===========");

			boolean status =customfeegroup.verifyCustomFeeGroupPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyCustomFeeGroupPage Test===========");
			getScreenShot("tcVerifyCustomFeeGroupPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyCustomFeeGroupPage");
		}
	}
	@Test(priority = 5)
	public void tcClickOnSaveButton_ToSubmitBlankForm() {
		

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitBlankForm Test===========");

			customfeegroup.clickOnSaveButton_Blank();
			
			log.info("============= Finished tcClickOnSaveButton_ToSubmitBlankForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		}
	}
	@Test(priority = 6, dataProvider = "CustomFeeGroupTestData")
	public void tcEnterCustomFeeGrNameGroupCodeAndSelectFeeGroup(String customFeeGrName, String feeGroupCode, String Feegroup,String runMode) {
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterCustomFeeGrNameGroupCodeAndSelectFeeGroup Test===========");

			customfeegroup.enterCustomFeeGrNameGroupCodeAndSelectFeeGroup(customFeeGrName, feeGroupCode, Feegroup);
			
			log.info("============= Finished tcEnterCustomFeeGrNameGroupCodeAndSelectFeeGroup Test===========");
			getScreenShot("tcEnterCustomFeeGrNameGroupCodeAndSelectFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcEnterCustomFeeGrNameGroupCodeAndSelectFeeGroup");
		}
	}
	@Test(priority = 7)
	public void tcClickOnSaveButton() {
		

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			customfeegroup.clickOnSaveButton();
			
			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}
	@Test(priority = 8)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {
		

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			customfeegroup.popWindowMessage_SubmitSuccessfully();
			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}
	@Test(priority = 9)
	public void tcClickOnSuccessOkBtn() {
		

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			customfeegroup.clickOnSuccessOkBtn();
			
			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}
	/**
	 * Search with the created custom group name
	 * 
	 * @param customGroupName
	 * @param runMode
	 */
	
	@Test(priority = 10, dataProvider = "CustomGroupNameTestData")
	public void tcSearchByGroupNameInGrid(String customGroupName,String runMode) {
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByGroupNameInGrid Test===========");

			customfeegroup.searchByGroupNameInGrid(customGroupName);
			
			log.info("============= Finished tcSearchByGroupNameInGrid Test===========");
			getScreenShot("tcSearchByGroupNameInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchByGroupNameInGrid");
		}
	}
	@Test(priority = 11, dataProvider = "CustomGroupNameTestData")
	public void tcVerifyCustomGroupupdatedInGrid(String customGroupName,String runMode) {
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyCustomGroupupdatedInGrid Test===========");

			customfeegroup.verifyCustomGroupupdatedInGrid(customGroupName);
			
			log.info("============= Finished tcVerifyCustomGroupupdatedInGrid Test===========");
			getScreenShot("tcVerifyCustomGroupupdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyCustomGroupupdatedInGrid");
		}
	}
	
	@Test(priority = 12, dataProvider = "CustomGroupNameTestData")
	public void tcEdit_CustomFeeGroup(String customGroupName,String runMode) {
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEdit_CustomFeeGroup Test===========");

			customfeegroup.edit_CustomFeeGroup(customGroupName);
			
			log.info("============= Finished tcEdit_CustomFeeGroup Test===========");
			getScreenShot("tcEdit_CustomFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcEdit_CustomFeeGroup");
		}
	}
	@Test(priority = 13)
	public void tcClickOnSaveButtonEdit() {
		

		try {
			log.info("============= Strting tcClickOnSaveButtonEdit Test===========");

			customfeegroup.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButtonEdit Test===========");
			getScreenShot("tcClickOnSaveButtonEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButtonEdit");
		}
	}
	@Test(priority = 14)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation() {
		

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");
			customfeegroup.popWindowMessage_SubmitSuccessfully_Edit();
			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation");
		}
	}
	@Test(priority = 15)
	public void tcClickOnSuccessOkBtnEdit() {
		

		try {
			log.info("============= Strting tcClickOnSuccessOkBtnEdit Test===========");

			customfeegroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtnEdit Test===========");
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		}
	}
	//search
	
	@Test(priority = 16, dataProvider = "CustomGroupNameTestData")
	public void tcSearchByGroupNameInGridForDeactivation(String customGroupName,String runMode) {
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByGroupNameInGridForDeactivation Test===========");

			customfeegroup.searchByGroupNameInGrid(customGroupName);
			
			log.info("============= Finished tcSearchByGroupNameInGridForDeactivation Test===========");
			getScreenShot("tcSearchByGroupNameInGridForDeactivation");
		} catch (Exception e) {
			getScreenShot("tcSearchByGroupNameInGridForDeactivation");
		}
	}
	//deactivation
	
	@Test(priority = 17, dataProvider = "CustomGroupNameTestData")
	public void tcDeactivationOfCreatedCustomGroup(String customGroupName,String runMode) {
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreatedCustomGroup Test===========");

			customfeegroup.deactivationOfCreatedCustomGroup(customGroupName);
			
			log.info("============= Finished tcDeactivationOfCreatedCustomGroup Test===========");
			getScreenShot("tcDeactivationOfCreatedCustomGroup");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreatedCustomGroup");
		}
	}
	
	
	@Test(priority = 18)
	public void tcConfirmationForDeactivation_Cancel() {
		

		try {
			log.info("============= Strting tcConfirmationForDeactivation_Cancel Test===========");

			customfeegroup.confirmationForDeactivation_Cancel();

			log.info("============= Finished tcConfirmationForDeactivation_Cancel Test===========");
			getScreenShot("tcConfirmationForDeactivation_Cancel");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForDeactivation_Cancel");
		}
	}
	@Test(priority = 19)
	public void tcPopUpWindowMessage_DeactivateCancel_Validation() {
		

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeactivateCancel_Validation Test===========");

			customfeegroup.popUpWindowMessage_DeactivateCancel_Validation();
			

			log.info("============= Finished tcPopUpWindowMessage_DeactivateCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeactivateCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeactivateCancel_Validation");
		}
	}
	@Test(priority = 20)
	public void tcClickOnDeactivationOkBtn_Cancel() {
	

		try {
			log.info("============= Strting tcClickOnDeactivationFinalOkBtn Test===========");

			customfeegroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnDeactivationFinalOkBtn Test===========");
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		}
	}
	@Test(priority = 21, dataProvider = "CustomGroupNameTestData")
	public void tcDeactivationOfCreatedCustomGroup_AfterCancel(String customGroupName,String runMode) {
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreatedCustomGroup_AfterCancel Test===========");

			customfeegroup.deactivationOfCreatedCustomGroup(customGroupName);
			
			log.info("============= Finished tcDeactivationOfCreatedCustomGroup_AfterCancel Test===========");
			getScreenShot("tcDeactivationOfCreatedCustomGroup_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreatedCustomGroup_AfterCancel");
		}
	}
	
	
	@Test(priority = 22)
	public void tcConfirmationForDeactivation() {
		

		try {
			log.info("============= Strting tcConfirmationForDeactivation Test===========");

			customfeegroup.confirmationForDeactivation();

			log.info("============= Finished tcConfirmationForDeactivation Test===========");
			getScreenShot("tcConfirmationForDeactivation");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForDeactivation");
		}
	}
	@Test(priority = 23)
	public void tcPopUpWindowMessage_DeactivateSucessfully_Validation() {
		

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeactivateSucessfully_Validation Test===========");

			customfeegroup.popUpWindowMessage_DeactivateSucessfully_Validation();
			

			log.info("============= Finished tcPopUpWindowMessage_DeactivateSucessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeactivateSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeactivateSucessfully_Validation");
		}
	}
	@Test(priority = 24)
	public void tcClickOnDeactivationOkBtn_Confirm() {
	

		try {
			log.info("============= Strting tcClickOnDeactivationOkBtn_Confirm Test===========");

			customfeegroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnDeactivationOkBtn_Confirm Test===========");
			getScreenShot("tcClickOnDeactivationOkBtn_Confirm");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeactivationOkBtn_Confirm");
		}
	}
	//search
	@Test(priority = 25, dataProvider = "CustomGroupNameTestData")
	public void tcSearchByGroupNameInGridForActivation(String customGroupName,String runMode) {
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByGroupNameInGridForActivation Test===========");

			customfeegroup.searchByGroupNameInGrid(customGroupName);
			
			log.info("============= Finished tcSearchByGroupNameInGridForActivation Test===========");
			getScreenShot("tcSearchByGroupNameInGridForActivation");
		} catch (Exception e) {
			getScreenShot("tcSearchByGroupNameInGridForActivation");
		}
	}
		
		@Test(priority = 26, dataProvider = "CustomGroupNameTestData")
		public void tcActivationOfCreatedCustomGroup(String customGroupName,String runMode) {
			
			if(runMode.equalsIgnoreCase("n")){
				throw new SkipException("user marked this record as no run");
			}
			try {
				log.info("============= Strting tcActivationOfCreatedCustomGroup Test===========");

				customfeegroup.activationOfCreatedCustomGroup(customGroupName);
				
				log.info("============= Finished tcActivationOfCreatedCustomGroup Test===========");
				getScreenShot("tcActivationOfCreatedCustomGroup");
			} catch (Exception e) {
				getScreenShot("tcActivationOfCreatedCustomGroup");
			}
		}
		@Test(priority = 27)
		public void tcConfirmationForActivation_Cancel() {
			
			try {
				log.info("============= Strting tcConfirmationForActivation_Cancel Test===========");

				customfeegroup.confirmationForActivation_Cancel();
				log.info("============= Finished tcConfirmationForActivation_Cancel Test===========");
				getScreenShot("tcConfirmationForActivation_Cancel");
			} catch (Exception e) {
				getScreenShot("tcConfirmationForActivation_Cancel");
			}
		}
		@Test(priority = 28)
		public void tcPopUpWindowMessage_ActivateCancel_Validation() {
			

			try {
				log.info("============= Strting tcPopUpWindowMessage_ActivateCancel_Validation Test===========");

				customfeegroup.popUpWindowMessage_ActivateCancel_Validation();
			

				log.info("============= Finished tcPopUpWindowMessage_ActivateCancel_Validation Test===========");
				getScreenShot("tcPopUpWindowMessage_ActivateCancel_Validation");
			} catch (Exception e) {
				getScreenShot("tcPopUpWindowMessage_ActivateCancel_Validation");
			}
		}
		@Test(priority = 29)
		public void tcClickOnActivationOkBtn_CancelActivate() {
			

			try {
				log.info("============= Strting tcClickOnActivationOkBtn_CancelActivate Test===========");

				customfeegroup.clickOnSuccessOkBtn();

				log.info("============= Finished tcClickOnActivationOkBtn_CancelActivate Test===========");
				getScreenShot("tcClickOnActivationOkBtn_CancelActivate");
			} catch (Exception e) {
				getScreenShot("tcClickOnActivationOkBtn_CancelActivate");
			}
		}
		@Test(priority = 30, dataProvider = "CustomGroupNameTestData")
		public void tcActivationOfCreatedCustomGroup_AfterCancel(String customGroupName,String runMode) {
			
			if(runMode.equalsIgnoreCase("n")){
				throw new SkipException("user marked this record as no run");
			}
			try {
				log.info("============= Strting tcActivationOfCreatedCustomGroup_AfterCancel Test===========");

				customfeegroup.activationOfCreatedCustomGroup(customGroupName);
				
				log.info("============= Finished tcActivationOfCreatedCustomGroup_AfterCancel Test===========");
				getScreenShot("tcActivationOfCreatedCustomGroup_AfterCancel");
			} catch (Exception e) {
				getScreenShot("tcActivationOfCreatedCustomGroup_AfterCancel");
			}
		}
		@Test(priority = 31)
		public void tcConfirmationForActivation_Confirm() {
			
			try {
				log.info("============= Strting tcConfirmationForActivation_Confirm Test===========");

				customfeegroup.confirmationForActivation();
				log.info("============= Finished tcConfirmationForActivation_Confirm Test===========");
				getScreenShot("tcConfirmationForActivation_Confirm");
			} catch (Exception e) {
				getScreenShot("tcConfirmationForActivation_Confirm");
			}
		}
		@Test(priority = 32)
		public void tcPopUpWindowMessage_ActivateSucessfully_Validation() {
			

			try {
				log.info("============= Strting tcPopUpWindowMessage_ActivateSucessfully_Validation Test===========");

				customfeegroup.popUpWindowMessage_ActivateSucessfully_Validation();
			

				log.info("============= Finished tcPopUpWindowMessage_ActivateSucessfully_Validation Test===========");
				getScreenShot("tcPopUpWindowMessage_ActivateSucessfully_Validation");
			} catch (Exception e) {
				getScreenShot("tcPopUpWindowMessage_ActivateSucessfully_Validation");
			}
		}
		@Test(priority = 33)
		public void tcClickOnActivationOkBtn_Activate() {
			

			try {
				log.info("============= Strting tcClickOnActivationOkBtn_Activate Test===========");

				customfeegroup.clickOnSuccessOkBtn();

				log.info("============= Finished tcClickOnActivationOkBtn_Activate Test===========");
				getScreenShot("tcClickOnActivationOkBtn_Activate");
			} catch (Exception e) {
				getScreenShot("tcClickOnActivationOkBtn_Activate");
			}
		}
		@AfterClass
		public void tearDown(){
			try {
				ivrmportallogin.logOutFromApplication();
			} catch (Exception e) {
		
				e.printStackTrace();
			}
			driver.quit();
		}
}
