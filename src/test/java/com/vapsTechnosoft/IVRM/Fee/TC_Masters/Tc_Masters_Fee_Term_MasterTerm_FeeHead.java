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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Fee_Term_MasterTerm_FeeHead;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_Term_MasterTerm_FeeHead extends TestBase{

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Term_MasterTerm_FeeHead.class.getName());

	Masters_Fee_Term_MasterTerm_FeeHead feeTermFeeHead;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name = "FeeTermFeesHeadTestData")
	public String[][] getTestDataFeeTerm() {
		String[][] testRecordsFeeTermHead = getData("FeeModueData.xlsx", "FeesTermFeesHeadData");
		return testRecordsFeeTermHead;
	}
	@DataProvider(name = "FeeTermSearchTestData")
	public String[][] getTestDataFeeTermSearch() {
		String[][] testRecordsFeeTermEdit = getData("FeeModueData.xlsx", "FeeTermMasterData");
		return testRecordsFeeTermEdit;
	}
	@DataProvider(name = "FeeHeadTestData")
	public String[][] getTestDataFeeHead() {
		String[][] testRecordsFeeHead = getData("FeeModueData.xlsx", "FeeHeadForFeeTermData");
		return testRecordsFeeHead;
	}
	
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
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
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			feeTermFeeHead.verifyHomeButton();
			
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}
	@Test(priority = 3)
	public void tcNevigateToMasters_FeeTermMasterTerm_FeeHead() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcNevigateToMasters_FeeTermMasterTerm_FeeHead Test===========");

			feeTermFeeHead.nevigateToMasters_FeeTermMasterTerm_FeeHead();
			
			log.info("============= Finished tcNevigateToMasters_FeeTermMasterTerm_FeeHead Test===========");
			getScreenShot("tcNevigateToMasters_FeeTermMasterTerm_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcNevigateToMasters_FeeTermMasterTerm_FeeHead");
		}
	}
	@Test(priority = 4)
	public void tcVerifyFeeTermPage() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcVerifyFeeTermPage Test===========");

			boolean status =feeTermFeeHead.verifyFeeTermPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeTermPage Test===========");
			getScreenShot("tcVerifyFeeTermPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeTermPage");
		}
	}
	@Test(priority = 5)
	public void tcClickOnMasterTerm_FeeHeadTab() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnMasterTerm_FeeHeadTab Test===========");

			feeTermFeeHead.clickOnMasterTerm_FeeHeadTab();
		
			log.info("============= Finished tcClickOnMasterTerm_FeeHeadTab Test===========");
			getScreenShot("tcClickOnMasterTerm_FeeHeadTab");
		} catch (Exception e) {
			getScreenShot("tcClickOnMasterTerm_FeeHeadTab");
		}
	}
	
	
	
	@Test(priority = 6, dataProvider = "FeeTermFeesHeadTestData")
	public void tcSelectTermFeeHeadAndInstallmentName(String TermName, String FeesHead,String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectTermFeeHeadAndInstallmentName Test===========");

			feeTermFeeHead.selectTermFeeHeadAndInstallmentName(TermName, FeesHead);
			
			log.info("============= Finished tcSelectTermFeeHeadAndInstallmentName Test===========");
			getScreenShot("tcSelectTermFeeHeadAndInstallmentName");
		} catch (Exception e) {
			getScreenShot("tcSelectTermFeeHeadAndInstallmentName");
		}
	}
	@Test(priority = 7)
	public void tcClickOnSaveButton() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			feeTermFeeHead.clickOnSaveButton();
			
			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}
	@Test(priority = 8)
	public void tcVerifySuccessfulPopUp() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status =feeTermFeeHead.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}
	@Test(priority = 9)
	public void tcClickOnSuccessOkBtn() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			feeTermFeeHead.clickOnSuccessOkBtn();
			
			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}
	
	
	@Test(priority = 10, dataProvider = "FeeTermSearchTestData")
	public void tcSearchTermByTermName(String feeTermName,String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchTermByTermName Test===========");

			feeTermFeeHead.searchTermByTermName(feeTermName);
			
			log.info("============= Finished tcSearchTermByTermName Test===========");
			getScreenShot("tcSearchTermByTermName");
		} catch (Exception e) {
			getScreenShot("tcSearchTermByTermName");
		}
	}
	
	@Test(priority = 11, dataProvider = "FeeTermSearchTestData")
	public void tcVerifyTermNameUpdatedInGrid(String feeTermName,String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyTermNameUpdatedInGrid Test===========");

			feeTermFeeHead.verifyTermNameUpdatedInGrid(feeTermName);
			
			log.info("============= Finished tcVerifyTermNameUpdatedInGrid Test===========");
			getScreenShot("tcVerifyTermNameUpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyTermNameUpdatedInGrid");
		}
	}
	@Test(priority = 12, dataProvider = "FeeHeadTestData")
	public void tcVerifyFeeHeadUpdatedInGrid(String feeHeadName,String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyFeeHeadUpdatedInGrid Test===========");

			feeTermFeeHead.verifyFeeHeadUpdatedInGrid(feeHeadName);
			
			log.info("============= Finished tcVerifyFeeHeadUpdatedInGrid Test===========");
			getScreenShot("tcVerifyFeeHeadUpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeHeadUpdatedInGrid");
		}
	}
	
	@Test(priority = 13, dataProvider = "FeeTermSearchTestData")
	public void tcEditFeeTerm_MasterTerm_FeeHead(String feeTermName,String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditFeeTerm_MasterTerm_FeeHead Test===========");

			feeTermFeeHead.editFeeTerm_MasterTerm_FeeHead(feeTermName);
			
			log.info("============= Finished tcEditFeeTerm_MasterTerm_FeeHead Test===========");
			getScreenShot("tcEditFeeTerm_MasterTerm_FeeHead");
		} catch (Exception e) {
			getScreenShot("tcEditFeeTerm_MasterTerm_FeeHead");
		}
	}
	@Test(priority = 14)
	public void tcClickOnSaveButtonEdit() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnSaveButtonEdit Test===========");

			feeTermFeeHead.clickOnSaveButtonEdit();
			
			log.info("============= Finished tcClickOnSaveButtonEdit Test===========");
			getScreenShot("tcClickOnSaveButtonEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButtonEdit");
		}
	}
	@Test(priority = 15)
	public void tcVerifySuccessfulPopUpEdit() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUpEdit Test===========");

			boolean status =feeTermFeeHead.verifySuccessfulPopUpEdit();
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcVerifySuccessfulPopUpEdit Test===========");
			getScreenShot("tcVerifySuccessfulPopUpEdit");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUpEdit");
		}
	}
	@Test(priority = 16)
	public void tcClickOnSuccessOkBtnEdit() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtnEdit Test===========");

			feeTermFeeHead.clickOnSuccessOkBtnEdit();
			
			log.info("============= Finished tcClickOnSuccessOkBtnEdit Test===========");
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtnEdit");
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
