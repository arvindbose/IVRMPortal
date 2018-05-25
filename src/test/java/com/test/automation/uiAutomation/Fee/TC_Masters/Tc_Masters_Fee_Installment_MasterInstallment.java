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

			feeMasterInstallment.fillMasterInstallmentForm(MasterInstallmentName, MasterInstallmentType, NoOfInstallment);

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

	@Test(priority = 9)
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

	@Test(priority = 10)
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
