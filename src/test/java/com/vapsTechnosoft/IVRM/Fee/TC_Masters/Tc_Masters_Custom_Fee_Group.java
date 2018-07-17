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
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

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
	@Test(priority = 5, dataProvider = "CustomFeeGroupTestData")
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
	@Test(priority = 6)
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
	@Test(priority = 7)
	public void tcVerifySuccessfulPopUp() {
		

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status =customfeegroup.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}
	@Test(priority = 8)
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
	
	@Test(priority = 9, dataProvider = "CustomGroupNameTestData")
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
	@Test(priority = 10, dataProvider = "CustomGroupNameTestData")
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
	
	@Test(priority = 11, dataProvider = "CustomGroupNameTestData")
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
	@Test(priority = 12)
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
	@Test(priority = 13)
	public void tcVerifySuccessfulPopUpEdit() {
		

		try {
			log.info("============= Strting tcVerifySuccessfulPopUpEdit Test===========");

			boolean status = customfeegroup.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUpEdit Test===========");
			getScreenShot("tcVerifySuccessfulPopUpEdit");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUpEdit");
		}
	}
	@Test(priority = 14)
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
	
	@Test(priority = 15, dataProvider = "CustomGroupNameTestData")
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
	
	@Test(priority = 16, dataProvider = "CustomGroupNameTestData")
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
	@Test(priority = 17)
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
	@Test(priority = 18)
	public void tcVerifyDeactivationSuccessfulPopUp() {
		

		try {
			log.info("============= Strting tcVerifyDeactivationSuccessfulPopUp Test===========");

			boolean status = customfeegroup.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifyDeactivationSuccessfulPopUp Test===========");
			getScreenShot("tcVerifyDeactivationSuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifyDeactivationSuccessfulPopUp");
		}
	}
	@Test(priority = 19)
	public void tcClickOnDeactivationFinalOkBtn() {
	

		try {
			log.info("============= Strting tcClickOnDeactivationFinalOkBtn Test===========");

			customfeegroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnDeactivationFinalOkBtn Test===========");
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		}
	}
	
	//search
	@Test(priority = 20, dataProvider = "CustomGroupNameTestData")
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
		
		@Test(priority = 21, dataProvider = "CustomGroupNameTestData")
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
		@Test(priority = 22)
		public void tcConfirmationForActivation() {
			
			try {
				log.info("============= Strting tcConfirmationForActivation Test===========");

				customfeegroup.confirmationForActivation();

				log.info("============= Finished tcConfirmationForActivation Test===========");
				getScreenShot("tcConfirmationForActivation");
			} catch (Exception e) {
				getScreenShot("tcConfirmationForActivation");
			}
		}
		@Test(priority = 23)
		public void tcVerifyActivationSuccessfulPopUp() {
			

			try {
				log.info("============= Strting tcVerifyActivationSuccessfulPopUp Test===========");

				boolean status = customfeegroup.verifySuccessfulPopUp();
				Assert.assertEquals(status, true);

				log.info("============= Finished tcVerifyActivationSuccessfulPopUp Test===========");
				getScreenShot("tcVerifyActivationSuccessfulPopUp");
			} catch (Exception e) {
				getScreenShot("tcVerifyActivationSuccessfulPopUp");
			}
		}
		@Test(priority = 24)
		public void tcClickOnActivationFinalOkBtn() {
			

			try {
				log.info("============= Strting tcClickOnActivationFinalOkBtn Test===========");

				customfeegroup.clickOnSuccessOkBtn();

				log.info("============= Finished tcClickOnActivationFinalOkBtn Test===========");
				getScreenShot("tcClickOnActivationFinalOkBtn");
			} catch (Exception e) {
				getScreenShot("tcClickOnActivationFinalOkBtn");
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
