/**
 * 
 */
package com.test.automation.uiAutomation.Fee.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.Fee.Masters.Masters_Fee_Installment_MasterInstallment_DueDate;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_Installment_MasterInstallment_DueDate extends TestBase{

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Installment_MasterInstallment_DueDate.class.getName());

	Masters_Fee_Installment_MasterInstallment_DueDate masterInstallmentDueDate;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "masterInstallmentDueDateData")
	public String[][] getTestDataFeeGroup() {
		String[][] testRecordsFeeInstallment = getData("FeeModueData.xlsx", "InstallmentDueDateData");
		return testRecordsFeeInstallment;
	}

//	@DataProvider(name = "FeeInstallmentNameTestData")
//	public String[][] getTestDataFeeInsName() {
//		String[][] testRecordsFeeInsName = getData("FeeModueData.xlsx", "FeeMasterInstallmentName");
//		return testRecordsFeeInsName;
//	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	/**
	 * Login to application
	 * @param username
	 * @param password
	 * @param runMode
	 */
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);
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
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			masterInstallmentDueDate.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateToFeeInstallment_MasterInstallmentDueDate() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcNevigateToFeeInstallment_MasterInstallmentDueDate Test===========");

			masterInstallmentDueDate.nevigateToFeeInstallment_MasterInstallmentDueDate();

			log.info("============= Finished tcNevigateToFeeInstallment_MasterInstallmentDueDate Test===========");
			getScreenShot("tcNevigateToFeeInstallment_MasterInstallmentDueDate");
		} catch (Exception e) {
			getScreenShot("tcNevigateToFeeInstallment_MasterInstallmentDueDate");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeInstallmentScreen_DueDate() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcVerifyFeeInstallmentScreen Test===========");

			boolean status = masterInstallmentDueDate.verifyFeeInstallmentScreen_DueDate();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeInstallmentScreen Test===========");
			getScreenShot("tcVerifyFeeInstallmentScreen");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeInstallmentScreen");
		}
	}
	@Test(priority = 5)
	public void tcVerifyMasterInstallmentDueDateTab() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcVerifyMasterInstallmentDueDateTab Test===========");

			boolean status = masterInstallmentDueDate.verifyMasterInstallmentDueDateTab();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasterInstallmentDueDateTab Test===========");
			getScreenShot("tcVerifyMasterInstallmentDueDateTab");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasterInstallmentDueDateTab");
		}
	}
	@Test(priority = 6)
	public void tcNavigateToMasterInstallmentDueDateTab() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcNavigateToMasterInstallmentDueDateTab Test===========");

			masterInstallmentDueDate.navigateToMasterInstallmentDueDateTab();

			log.info("============= Finished tcNavigateToMasterInstallmentDueDateTab Test===========");
			getScreenShot("tcNavigateToMasterInstallmentDueDateTab");
		} catch (Exception e) {
			getScreenShot("tcNavigateToMasterInstallmentDueDateTab");
		}
	}
	@Test(priority = 7, dataProvider = "masterInstallmentDueDateData")
	public void tcSelectAcademicYearAndInstallmentType(String academicYear,String installmentType, String runMode) {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYearAndInstallmentType Test===========");

			masterInstallmentDueDate.selectAcademicYearAndInstallmentType(academicYear, installmentType);

			log.info("============= Finished tcSelectAcademicYearAndInstallmentType Test===========");
			getScreenShot("tcSelectAcademicYearAndInstallmentType");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearAndInstallmentType");
		}
	}
	@Test(priority = 8)
	public void tcDueDateCalendarEntry() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcDueDateCalendarEntry Test===========");

			masterInstallmentDueDate.dueDateCalendarEntry();

			log.info("============= Finished tcDueDateCalendarEntry Test===========");
			getScreenShot("tcDueDateCalendarEntry");
		} catch (Exception e) {
			getScreenShot("tcDueDateCalendarEntry");
		}
	}
	
	@Test(priority = 9)
	public void tcClickOnSaveButton() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			masterInstallmentDueDate.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 10)
	public void tcVerifySuccessfulPopUp() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status = masterInstallmentDueDate.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}

	@Test(priority = 11)
	public void tcClickOnSuccessOkBtn() {
		masterInstallmentDueDate = new Masters_Fee_Installment_MasterInstallment_DueDate(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			masterInstallmentDueDate.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}
}
