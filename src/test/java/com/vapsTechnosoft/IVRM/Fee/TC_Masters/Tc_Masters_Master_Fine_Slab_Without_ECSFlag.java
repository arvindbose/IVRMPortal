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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Master_Fine_Slab_Without_ECSFlag;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Master_Fine_Slab_Without_ECSFlag extends TestBase{
	
	public static final Logger log = Logger.getLogger(Tc_Masters_Master_Fine_Slab_Without_ECSFlag.class.getName());

	Masters_Master_Fine_Slab_Without_ECSFlag masterfineslab;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name = "MasterFineSlabTestBWData")
	public String[][] getTestDataMFSBw() {
		String[][] testRecordsMFSBW = getData("FeeModueData.xlsx", "MasterFineSlabBetweenData");
		return testRecordsMFSBW;
	}
	@DataProvider(name = "MasterFineSlabTestGr&LessData")
	public String[][] getTestDataMFSGr() {
		String[][] testRecordsMFSGr = getData("FeeModueData.xlsx", "MasterFineSlabGreater&LThanData");
		return testRecordsMFSGr;
	}
	
	@DataProvider(name = "FromDAYFineSlabTestData")
	public String[][] getTestDataMFSfromDay() {
		String[][] testRecordsMFSFD = getData("FeeModueData.xlsx", "FromDAYFineSlab");
		return testRecordsMFSFD;
	}
	
	
	
	@DataProvider(name = "ToDAYFineSlabTestData")
	public String[][] getTestDataToDay() {
		String[][] testRecordsToDay = getData("FeeModueData.xlsx", "ToDAYFineSlab");
		return testRecordsToDay;
	}
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
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
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			boolean status = masterfineslab.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}
	@Test(priority = 3)
	public void tcNavigateToMasters_masterFineSlab() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcNavigateToMasters_masterFineSlab Test===========");

			masterfineslab.navigateToMasters_masterFineSlab();
			
			log.info("============= Finished tcNavigateToMasters_masterFineSlab Test===========");
			getScreenShot("tcNavigateToMasters_masterFineSlab");
		} catch (Exception e) {
			getScreenShot("tcNavigateToMasters_masterFineSlab");
		}
	}
	@Test(priority = 4)
	public void tcVerifyMasterFineSlabPage() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcVerifyMasterFineSlabPage Test===========");

			boolean status =masterfineslab.verifyMasterFineSlabPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasterFineSlabPage Test===========");
			getScreenShot("tcVerifyMasterFineSlabPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasterFineSlabPage");
		}
	}
	@Test(priority = 5, dataProvider = "MasterFineSlabTestBWData")
	public void tcMastersFineSlabTypeFromDayAndToDay_Between(String fineslabType, String fromDay, String toDay,String runMode) {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMastersFineSlabTypeFromDayAndToDay_Between Test===========");

			masterfineslab.mastersFineSlabTypeFromDayAndToDay_Between(fineslabType, fromDay, toDay);
			log.info("============= Finished tcMastersFineSlabTypeFromDayAndToDay_Between Test===========");
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_Between");
		} catch (Exception e) {
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_Between");
		}
	}
	@Test(priority = 6)
	public void tcClickOnSaveButton_Between() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton_Between Test===========");

			masterfineslab.clickOnSaveButton();
			
			log.info("============= Finished tcClickOnSaveButton_Between Test===========");
			getScreenShot("tcClickOnSaveButton_Between");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_Between");
		}
	}
	@Test(priority = 7)
	public void tcVerifySuccessfulPopUp_Between() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_Between Test===========");

			boolean status =masterfineslab.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcVerifySuccessfulPopUp_Between Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_Between");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_Between");
		}
	}
	@Test(priority = 8)
	public void tcClickOnSuccessOkBtn_Between() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Between Test===========");

			masterfineslab.clickOnSuccessOkBtn();
			
			log.info("============= Finished tcClickOnSuccessOkBtn_Between Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Between");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Between");
		}
	}
	
	@Test(priority = 9, dataProvider = "MasterFineSlabTestGr&LessData")
	public void tcMastersFineSlabTypeFromDayAndToDay_GreaterThan(String fineslabType, String fromDay,String runMode) {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		if(runMode.equalsIgnoreCase("Ln")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMastersFineSlabTypeFromDayAndToDay_GreaterThan Test===========");

			masterfineslab.mastersFineSlabTypeFromDayAndToDay_GreaterThan(fineslabType, fromDay);
			log.info("============= Finished tcMastersFineSlabTypeFromDayAndToDay_GreaterThan Test===========");
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_GreaterThan");
		} 
		catch (Exception e) {
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_GreaterThan");
		}
	}
	@Test(priority = 10)
	public void tcClickOnSaveButton_GreaterThan() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton_GreaterThan Test===========");

			masterfineslab.clickOnSaveButton();
			
			log.info("============= Finished tcClickOnSaveButton_GreaterThan Test===========");
			getScreenShot("tcClickOnSaveButton_GreaterThan");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_GreaterThan");
		}
	}
	@Test(priority = 11)
	public void tcVerifySuccessfulPopUp_GreaterThan() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_GreaterThan Test===========");

			boolean status =masterfineslab.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcVerifySuccessfulPopUp_GreaterThan Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_GreaterThan");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_GreaterThan");
		}
	}
	@Test(priority = 12)
	public void tcClickOnSuccessOkBtn_GreaterThan() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_GreaterThan Test===========");

			masterfineslab.clickOnSuccessOkBtn();
			
			log.info("============= Finished tcClickOnSuccessOkBtn_GreaterThan Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_GreaterThan");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_GreaterThan");
		}
	}

	@Test(priority = 13, dataProvider = "MasterFineSlabTestGr&LessData")
	public void tcMastersFineSlabTypeFromDayAndToDay_LessThan(String fineslabType, String fromDay,String runMode) {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		if(runMode.equalsIgnoreCase("Gr")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcMastersFineSlabTypeFromDayAndToDay_LessThan Test===========");

			masterfineslab.mastersFineSlabTypeFromDayAndToDay_LessThan(fineslabType, fromDay);
			log.info("============= Finished tcMastersFineSlabTypeFromDayAndToDay_LessThan Test===========");
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_LessThan");
		} 
		catch (Exception e) {
			getScreenShot("tcMastersFineSlabTypeFromDayAndToDay_LessThan");
		}
	}
	@Test(priority = 14)
	public void tcClickOnSaveButton_LessThan() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton_LessThan Test===========");

			masterfineslab.clickOnSaveButton();
			
			log.info("============= Finished tcClickOnSaveButton_LessThan Test===========");
			getScreenShot("tcClickOnSaveButton_LessThan");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_LessThan");
		}
	}
	@Test(priority = 15)
	public void tcVerifySuccessfulPopUp_LessThan() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_LessThan Test===========");

			boolean status =masterfineslab.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcVerifySuccessfulPopUp_LessThan Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_LessThan");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_LessThan");
		}
	}
	@Test(priority = 16)
	public void tcClickOnSuccessOkBtn_LessThan() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_LessThan Test===========");

			masterfineslab.clickOnSuccessOkBtn();
			
			log.info("============= Finished tcClickOnSuccessOkBtn_LessThan Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_LessThan");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_LessThan");
		}
	}
	
	@Test(priority = 17, dataProvider = "ToDAYFineSlabTestData")
	public void tcSearchByToDayInGrid(String toDay,String runMode) {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByToDayInGrid Test===========");

			masterfineslab.searchByToDayInGrid(toDay);
			
			log.info("============= Finished tcSearchByToDayInGrid Test===========");
			getScreenShot("tcSearchByToDayInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchByToDayInGrid");
		}
	}
	@Test(priority = 18, dataProvider = "ToDAYFineSlabTestData")
	public void tcVerifyMasterFineSlabUpdatedInGrid(String toDay,String runMode) {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyMasterFineSlabUpdatedInGrid Test===========");

			masterfineslab.verifyMasterFineSlabUpdatedInGrid(toDay);
			
			log.info("============= Finished tcVerifyMasterFineSlabUpdatedInGrid Test===========");
			getScreenShot("tcVerifyMasterFineSlabUpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasterFineSlabUpdatedInGrid");
		}
	}
	
	@Test(priority = 19, dataProvider = "ToDAYFineSlabTestData")
	public void tcEdit_masterFineSlab(String toDay,String runMode) {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEdit_masterFineSlab Test===========");

			masterfineslab.edit_masterFineSlab(toDay);
			
			log.info("============= Finished tcEdit_masterFineSlab Test===========");
			getScreenShot("tcEdit_masterFineSlab");
		} catch (Exception e) {
			getScreenShot("tcEdit_masterFineSlab");
		}
	}
	@Test(priority = 20, dataProvider = "FromDAYFineSlabTestData")
	public void tcEditMasterFineSlab(String fromDay, String runMode){
		
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		
		try {
			log.info("============= Strting tcEditMasterFineSlab Test===========");

			masterfineslab.editMasterFineSlab(fromDay);

			log.info("============= Finished tcEditMasterFineSlab Test===========");
			getScreenShot("tcEditMasterFineSlab");
		} catch (Exception e) {
			getScreenShot("tcEditMasterFineSlab");
		}
	}
	
	@Test(priority = 21)
	public void tcClickOnSaveButtonEdit() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcClickOnSaveButtonEdit Test===========");

			masterfineslab.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButtonEdit Test===========");
			getScreenShot("tcClickOnSaveButtonEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButtonEdit");
		}
	}
	@Test(priority = 22)
	public void tcVerifySuccessfulPopUpEdit() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUpEdit Test===========");

			boolean status = masterfineslab.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUpEdit Test===========");
			getScreenShot("tcVerifySuccessfulPopUpEdit");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUpEdit");
		}
	}
	@Test(priority = 23)
	public void tcClickOnSuccessOkBtnEdit() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtnEdit Test===========");

			masterfineslab.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtnEdit Test===========");
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		}
	}
	
	@Test(priority = 24, dataProvider = "ToDAYFineSlabTestData")
	public void tcSearchByToDayInGridForDeactivation(String toDay,String runMode) {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByToDayInGridForDeactivation Test===========");

			masterfineslab.searchByToDayInGrid(toDay);
			
			log.info("============= Finished tcSearchByToDayInGridForDeactivation Test===========");
			getScreenShot("tcSearchByToDayInGridForDeactivation");
		} catch (Exception e) {
			getScreenShot("tcSearchByToDayInGridForDeactivation");
		}
	}
	//deactivation
	
	@Test(priority = 25, dataProvider = "ToDAYFineSlabTestData")
	public void tcDeactivationOfCreated_MasterFineslab(String toDay,String runMode) {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreated_MasterFineslab Test===========");

			masterfineslab.deactivationOfCreated_MasterFineslab(toDay);
			
			log.info("============= Finished tcDeactivationOfCreated_MasterFineslab Test===========");
			getScreenShot("tcDeactivationOfCreated_MasterFineslab");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreated_MasterFineslab");
		}
	}
	@Test(priority = 26)
	public void tcConfirmationForDeactivation() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcConfirmationForDeactivation Test===========");

			masterfineslab.confirmationForDeactivation();

			log.info("============= Finished tcConfirmationForDeactivation Test===========");
			getScreenShot("tcConfirmationForDeactivation");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForDeactivation");
		}
	}
	@Test(priority = 27)
	public void tcVerifyDeactivationSuccessfulPopUp() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcVerifyDeactivationSuccessfulPopUp Test===========");

			boolean status = masterfineslab.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifyDeactivationSuccessfulPopUp Test===========");
			getScreenShot("tcVerifyDeactivationSuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifyDeactivationSuccessfulPopUp");
		}
	}
	@Test(priority = 28)
	public void tcClickOnDeactivationFinalOkBtn() {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

		try {
			log.info("============= Strting tcClickOnDeactivationFinalOkBtn Test===========");

			masterfineslab.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnDeactivationFinalOkBtn Test===========");
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		}
	}
	
	//search
	@Test(priority = 29, dataProvider = "ToDAYFineSlabTestData")
	public void tcSearchByToDayInGridForActivation(String toDay,String runMode) {
		masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByToDayInGridForActivation Test===========");

			masterfineslab.searchByToDayInGrid(toDay);
			
			log.info("============= Finished tcSearchByToDayInGridForActivation Test===========");
			getScreenShot("tcSearchByToDayInGridForActivation");
		} catch (Exception e) {
			getScreenShot("tcSearchByToDayInGridForActivation");
		}
	}
		
		@Test(priority = 30, dataProvider = "ToDAYFineSlabTestData")
		public void tcActivationOf_MasterFineSlab(String toDay,String runMode) {
			masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
			if(runMode.equalsIgnoreCase("n")){
				throw new SkipException("user marked this record as no run");
			}
			try {
				log.info("============= Strting tcActivationOf_MasterFineSlab Test===========");

				masterfineslab.activationOf_MasterFineSlab(toDay);
				
				log.info("============= Finished tcActivationOf_MasterFineSlab Test===========");
				getScreenShot("tcActivationOf_MasterFineSlab");
			} catch (Exception e) {
				getScreenShot("tcActivationOf_MasterFineSlab");
			}
		}
		@Test(priority = 31)
		public void tcConfirmationForActivation() {
			masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
			try {
				log.info("============= Strting tcConfirmationForActivation Test===========");

				masterfineslab.confirmationForActivation();

				log.info("============= Finished tcConfirmationForActivation Test===========");
				getScreenShot("tcConfirmationForActivation");
			} catch (Exception e) {
				getScreenShot("tcConfirmationForActivation");
			}
		}
		@Test(priority = 32)
		public void tcVerifyActivationSuccessfulPopUp() {
			masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);
			try {
				log.info("============= Strting tcVerifyActivationSuccessfulPopUp Test===========");

				boolean status = masterfineslab.verifySuccessfulPopUp();
				Assert.assertEquals(status, true);

				log.info("============= Finished tcVerifyActivationSuccessfulPopUp Test===========");
				getScreenShot("tcVerifyActivationSuccessfulPopUp");
			} catch (Exception e) {
				getScreenShot("tcVerifyActivationSuccessfulPopUp");
			}
		}
		@Test(priority = 33)
		public void tcClickOnActivationFinalOkBtn() {
			masterfineslab = new Masters_Master_Fine_Slab_Without_ECSFlag(driver);

			try {
				log.info("============= Strting tcClickOnActivationFinalOkBtn Test===========");

				masterfineslab.clickOnSuccessOkBtn();

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
