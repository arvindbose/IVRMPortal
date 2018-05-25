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

import com.test.automation.uiAutomation.Fee.Masters.Masters_Fee_Amount_Entry;
import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_Amount_Entry extends TestBase{

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Amount_Entry.class.getName());

	Masters_Fee_Amount_Entry feeamountentry;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name = "FeeAmountEntryTestData")
	public String[][] getTestDataFAE() {
		String[][] testRecordsFAE = getData("FeeModueData.xlsx", "FeeAmountEntryData");
		return testRecordsFAE;
	}
	@DataProvider(name = "FeeAmountEntryInstallmentTestData")
	public String[][] getTestDataInstall() {
		String[][] testRecordsInstall = getData("FeeModueData.xlsx", "InstallmentIData");
		return testRecordsInstall;
	}
	
	@DataProvider(name = "FeeAmountEntryInstallment2TestData")
	public String[][] getTestDataInstall2() {
		String[][] testRecordsInstall2 = getData("FeeModueData.xlsx", "InstallmentIIData");
		return testRecordsInstall2;
	}
	@DataProvider(name = "FeeAmountEntryInstallment3TestData")
	public String[][] getTestDataInstall3() {
		String[][] testRecordsInstall3 = getData("FeeModueData.xlsx", "InstallmentIIIData");
		return testRecordsInstall3;
	}
	@DataProvider(name = "FeeAmountEntryInstallment4TestData")
	public String[][] getTestDataInstall4() {
		String[][] testRecordsInstall4 = getData("FeeModueData.xlsx", "InstallmentIVData");
		return testRecordsInstall4;
	}
	@DataProvider(name = "FeeAmountEntryInstallment5TestData")
	public String[][] getTestDataInstall5() {
		String[][] testRecordsInstall5 = getData("FeeModueData.xlsx", "InstallmentVData");
		return testRecordsInstall5;
	}
	
	
	
	@DataProvider(name = "FeeSlabDetailsTestData")
	public String[][] getTestDataMFSfromDay() {
		String[][] testRecordsMFSFD = getData("FeeModueData.xlsx", "FeeSlabPopUpDetails");
		return testRecordsMFSFD;
	}
	
	
	
	@DataProvider(name = "SearchAndDeleteData")
	public String[][] getTestDataSearch() {
		String[][] testRecordsInstall = getData("FeeModueData.xlsx", "SearchAndDeleteTestData");
		return testRecordsInstall;
	}
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeamountentry = new Masters_Fee_Amount_Entry(driver);
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

			boolean status = feeamountentry.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}
	@Test(priority = 3)
	public void tcNavigateToMasters_FeeAmountEntry() {
			try {
			log.info("============= Strting tcNavigateToMasters_FeeAmountEntry Test===========");

			feeamountentry.navigateToMasters_FeeAmountEntry();
			
			log.info("============= Finished tcNavigateToMasters_FeeAmountEntry Test===========");
			getScreenShot("tcNavigateToMasters_FeeAmountEntry");
		} catch (Exception e) {
			getScreenShot("tcNavigateToMasters_FeeAmountEntry");
		}
	}
	@Test(priority = 4)
	public void tcVerifyFeeAmountEntryPage() {
	
		try {
			log.info("============= Strting tcVerifyFeeAmountEntryPage Test===========");

			boolean status =feeamountentry.verifyFeeAmountEntryPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeAmountEntryPage Test===========");
			getScreenShot("tcVerifyFeeAmountEntryPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeAmountEntryPage");
		}
	}
	@Test(priority = 5, dataProvider = "FeeAmountEntryTestData")
	public void tcSelectAcademicYrCategoryAndFeeGroup(String academicYear, String category, String feeGroup,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYrCategoryAndFeeGroup Test===========");

			feeamountentry.selectAcademicYrCategoryAndFeeGroup(academicYear, category, feeGroup);
			log.info("============= Finished tcSelectAcademicYrCategoryAndFeeGroup Test===========");
			getScreenShot("tcSelectAcademicYrCategoryAndFeeGroup");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYrCategoryAndFeeGroup");
		}
	}
	
	@Test(priority = 6, dataProvider = "FeeAmountEntryInstallmentTestData")
	public void tcAmountEntrytabledata(String installment, String amount, String dueMonth,String dueDate,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcAmountEntrytabledata Test===========");

			feeamountentry.amountEntrytabledata(installment, amount, dueMonth, dueDate);
			
			log.info("============= Finished tcAmountEntrytabledata Test===========");
			getScreenShot("tcAmountEntrytabledata");
		} catch (Exception e) {
			getScreenShot("tcAmountEntrytabledata");
		}
	}
	@Test(priority = 7, dataProvider = "FeeSlabDetailsTestData")
	public void tcFeeSlabDetailsPopUpTable1stIns(String serialNo, String  Per_Day, String fine_amount,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFeeSlabDetailsPopUpTable1stIns Test===========");

			feeamountentry.feeSlabDetailsPopUpTable(serialNo, Per_Day, fine_amount);
			log.info("============= Finished tcFeeSlabDetailsPopUpTable1stIns Test===========");
			getScreenShot("tcFeeSlabDetailsPopUpTable1stIns");
		} catch (Exception e) {
			getScreenShot("tcFeeSlabDetailsPopUpTable1stIns");
		}
	}
	
	@Test(priority = 8)
	public void tcclickOnAddToCartButton1stIns() {
	
		try {
			log.info("============= Strting tcclickOnAddToCartButton1stIns Test===========");

			feeamountentry.clickOnAddToCartButton();
			
			log.info("============= Finished tcclickOnAddToCartButton1stIns Test===========");
			getScreenShot("tcclickOnAddToCartButton1stIns");
		} catch (Exception e) {
			getScreenShot("tcclickOnAddToCartButton1stIns");
		}
	}

	@Test(priority = 9)
	public void tcClickOn_AddToCart_SuccessOkBtn_1stIns() {
			try {
			log.info("============= Strting tcClickOn_AddToCart_SuccessOkBtn_1stIns Test===========");

			feeamountentry.clickOn_AddToCart_SuccessOkBtn();
			
			log.info("============= Finished tcClickOn_AddToCart_SuccessOkBtn_1stIns Test===========");
			getScreenShot("tcClickOn_AddToCart_SuccessOkBtn_1stIns");
		} catch (Exception e) {
			getScreenShot("tcClickOn_AddToCart_SuccessOkBtn_1stIns");
		}
	}

	
	@Test(priority = 10, dataProvider = "FeeAmountEntryInstallment2TestData")
	public void tcAmountEntrytabledataIns2(String installment, String amount, String dueMonth,String dueDate,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcAmountEntrytabledataIns2 Test===========");

			feeamountentry.amountEntrytabledata(installment, amount, dueMonth, dueDate);
			log.info("============= Finished tcAmountEntrytabledataIns2 Test===========");
			getScreenShot("tcAmountEntrytabledataIns2");
		} catch (Exception e) {
			getScreenShot("tcAmountEntrytabledataIns2");
		}
	}
	@Test(priority = 11, dataProvider = "FeeSlabDetailsTestData")
	public void tcFeeSlabDetailsPopUpTable2ndIns(String serialNo, String  Per_Day, String fine_amount,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFeeSlabDetailsPopUpTable2ndIns Test===========");

			feeamountentry.feeSlabDetailsPopUpTable(serialNo, Per_Day, fine_amount);
			log.info("============= Finished tcFeeSlabDetailsPopUpTable2ndIns Test===========");
			getScreenShot("tcFeeSlabDetailsPopUpTable2ndIns");
		} catch (Exception e) {
			getScreenShot("tcFeeSlabDetailsPopUpTable2ndIns");
		}
	}
	
	@Test(priority = 12)
	public void tcclickOnAddToCartButton2ndIns() {
		try {
			log.info("============= Strting tcclickOnAddToCartButton2ndIns Test===========");

			feeamountentry.clickOnAddToCartButton();
			
			log.info("============= Finished tcclickOnAddToCartButton2ndIns Test===========");
			getScreenShot("tcclickOnAddToCartButton2ndIns");
		} catch (Exception e) {
			getScreenShot("tcclickOnAddToCartButton2ndIns");
		}
	}
	
	@Test(priority = 13)
	public void tcClickOn_AddToCart_SuccessOkBtn_2ndIns() {
		try {
			log.info("============= Strting tcClickOn_AddToCart_SuccessOkBtn_2ndIns Test===========");

			feeamountentry.clickOn_AddToCart_SuccessOkBtn();
			
			log.info("============= Finished tcClickOn_AddToCart_SuccessOkBtn_2ndIns Test===========");
			getScreenShot("tcClickOn_AddToCart_SuccessOkBtn_2ndIns");
		} catch (Exception e) {
			getScreenShot("tcClickOn_AddToCart_SuccessOkBtn_2ndIns");
		}
	}

	@Test(priority = 14, dataProvider = "FeeAmountEntryInstallment3TestData")
	public void tcAmountEntrytabledataIns3(String installment, String amount, String dueMonth,String dueDate,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcAmountEntrytabledataIns3 Test===========");

			feeamountentry.amountEntrytabledata(installment, amount, dueMonth, dueDate);
			log.info("============= Finished tcAmountEntrytabledataIns3 Test===========");
			getScreenShot("tcAmountEntrytabledataIns3");
		} catch (Exception e) {
			getScreenShot("tcAmountEntrytabledataIns3");
		}
	}
	@Test(priority = 15, dataProvider = "FeeSlabDetailsTestData")
	public void tcFeeSlabDetailsPopUpTable3rdIns(String serialNo, String  Per_Day, String fine_amount,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFeeSlabDetailsPopUpTable3rdIns Test===========");

			feeamountentry.feeSlabDetailsPopUpTable(serialNo, Per_Day, fine_amount);
			log.info("============= Finished tcFeeSlabDetailsPopUpTable3rdIns Test===========");
			getScreenShot("tcFeeSlabDetailsPopUpTable3rdIns");
		} catch (Exception e) {
			getScreenShot("tcFeeSlabDetailsPopUpTable3rdIns");
		}
	}
	
	@Test(priority = 16)
	public void tcclickOnAddToCartButton3rdIns() {
		try {
			log.info("============= Strting tcclickOnAddToCartButton3rdIns Test===========");

			feeamountentry.clickOnAddToCartButton();
			
			log.info("============= Finished tcclickOnAddToCartButton3rdIns Test===========");
			getScreenShot("tcclickOnAddToCartButton3rdIns");
		} catch (Exception e) {
			getScreenShot("tcclickOnAddToCartButton3rdIns");
		}
	}

	@Test(priority = 17)
	public void tcClickOn_AddToCart_SuccessOkBtn_3rdIns() {
		try {
			log.info("============= Strting tcClickOn_AddToCart_SuccessOkBtn_3rdIns Test===========");

			feeamountentry.clickOn_AddToCart_SuccessOkBtn();
			
			log.info("============= Finished tcClickOn_AddToCart_SuccessOkBtn_3rdIns Test===========");
			getScreenShot("tcClickOn_AddToCart_SuccessOkBtn_3rdIns");
		} catch (Exception e) {
			getScreenShot("tcClickOn_AddToCart_SuccessOkBtn_3rdIns");
		}
	}
	@Test(priority =18, dataProvider = "FeeAmountEntryInstallment4TestData")
	public void tcAmountEntrytabledataIns4(String installment, String amount, String dueMonth,String dueDate,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcAmountEntrytabledataIns4 Test===========");

			feeamountentry.amountEntrytabledata(installment, amount, dueMonth, dueDate);
			log.info("============= Finished tcAmountEntrytabledataIns4 Test===========");
			getScreenShot("tcAmountEntrytabledataIns4");
		} catch (Exception e) {
			getScreenShot("tcAmountEntrytabledataIns4");
		}
	}
	@Test(priority = 19, dataProvider = "FeeSlabDetailsTestData")
	public void tcFeeSlabDetailsPopUpTable4thIns(String serialNo, String  Per_Day, String fine_amount,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFeeSlabDetailsPopUpTable4thIns Test===========");

			feeamountentry.feeSlabDetailsPopUpTable(serialNo, Per_Day, fine_amount);
			log.info("============= Finished tcFeeSlabDetailsPopUpTable4thIns Test===========");
			getScreenShot("tcFeeSlabDetailsPopUpTable4thIns");
		} catch (Exception e) {
			getScreenShot("tcFeeSlabDetailsPopUpTable4thIns");
		}
	}
	
	@Test(priority = 20)
	public void tcclickOnAddToCartButton4thIns() {
		try {
			log.info("============= Strting tcclickOnAddToCartButton4thIns Test===========");

			feeamountentry.clickOnAddToCartButton();
			
			log.info("============= Finished tcclickOnAddToCartButton4thIns Test===========");
			getScreenShot("tcclickOnAddToCartButton4thIns");
		} catch (Exception e) {
			getScreenShot("tcclickOnAddToCartButton4thIns");
		}
	}
	@Test(priority = 21)
	public void tcClickOn_AddToCart_SuccessOkBtn_4thIns() {
		try {
			log.info("============= Strting tcClickOn_AddToCart_SuccessOkBtn_4thIns Test===========");

			feeamountentry.clickOn_AddToCart_SuccessOkBtn();
			
			log.info("============= Finished tcClickOn_AddToCart_SuccessOkBtn_4thIns Test===========");
			getScreenShot("tcClickOn_AddToCart_SuccessOkBtn_4thIns");
		} catch (Exception e) {
			getScreenShot("tcClickOn_AddToCart_SuccessOkBtn_4thIns");
		}
	}

	@Test(priority = 22, dataProvider = "FeeAmountEntryInstallment5TestData")
	public void tcAmountEntrytabledataIns5(String installment, String amount, String dueMonth,String dueDate,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcAmountEntrytabledataIns5 Test===========");

			feeamountentry.amountEntrytabledata(installment, amount, dueMonth, dueDate);
			log.info("============= Finished tcAmountEntrytabledataIns5 Test===========");
			getScreenShot("tcAmountEntrytabledataIns5");
		} catch (Exception e) {
			getScreenShot("tcAmountEntrytabledataIns5");
		}
	}
	
	@Test(priority = 23, dataProvider = "FeeSlabDetailsTestData")
	public void tcFeeSlabDetailsPopUpTable5thIns(String serialNo, String  Per_Day, String fine_amount,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFeeSlabDetailsPopUpTable5thIns Test===========");

			feeamountentry.feeSlabDetailsPopUpTable(serialNo, Per_Day, fine_amount);
			log.info("============= Finished tcFeeSlabDetailsPopUpTable5thIns Test===========");
			getScreenShot("tcFeeSlabDetailsPopUpTable5thIns");
		} catch (Exception e) {
			getScreenShot("tcFeeSlabDetailsPopUpTable5thIns");
		}
	}
	
	@Test(priority = 24)
	public void tcclickOnAddToCartButton5thIns() {
		try {
			log.info("============= Strting tcclickOnAddToCartButton5thIns Test===========");

			feeamountentry.clickOnAddToCartButton();
			
			log.info("============= Finished tcclickOnAddToCartButton5thIns Test===========");
			getScreenShot("tcclickOnAddToCartButton5thIns");
		} catch (Exception e) {
			getScreenShot("tcclickOnAddToCartButton5thIns");
		}
	}
	@Test(priority = 25)
	public void tcClickOn_AddToCart_SuccessOkBtn_5thIns() {
		try {
			log.info("============= Strting tcClickOn_AddToCart_SuccessOkBtn_5thIns Test===========");

			feeamountentry.clickOn_AddToCart_SuccessOkBtn();
			
			log.info("============= Finished tcClickOn_AddToCart_SuccessOkBtn_5thIns Test===========");
			getScreenShot("tcClickOn_AddToCart_SuccessOkBtn_5thIns");
		} catch (Exception e) {
			getScreenShot("tcClickOn_AddToCart_SuccessOkBtn_5thIns");
		}
	}
	
	@Test(priority = 26)
	public void tcClickOnSaveButton() {
		try {
			log.info("============= Strting tcClickOnSaveButton_Between Test===========");

			feeamountentry.clickOnSaveButton();
			
			log.info("============= Finished tcClickOnSaveButton_Between Test===========");
			getScreenShot("tcClickOnSaveButton_Between");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_Between");
		}
	}
	@Test(priority = 27)
	public void tcVerifySuccessfulPopUp() {
		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_Between Test===========");

			boolean status =feeamountentry.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);
			
			log.info("============= Finished tcVerifySuccessfulPopUp_Between Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_Between");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_Between");
		}
	}
	@Test(priority = 28)
	public void tcClickOnSuccessOkBtn() {
		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			feeamountentry.clickOnSuccessOkBtn();
			
			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}
	
	@Test(priority = 29, dataProvider = "SearchAndDeleteData")
	public void tcSearchWithInstallmentName(String InstallmentName,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithInstallmentName Test===========");

			feeamountentry.searchWithInstallmentName(InstallmentName);
			log.info("============= Finished tcSearchWithInstallmentName Test===========");
			getScreenShot("tcSearchWithInstallmentName");
		} catch (Exception e) {
			getScreenShot("tcSearchWithInstallmentName");
		}
	}
	@Test(priority = 30, dataProvider = "SearchAndDeleteData")
	public void tcDeleteRecordsFromAmountEntryGrid(String InstallmentName,String runMode) {
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteRecordsFromAmountEntryGrid Test===========");

			feeamountentry.deleteRecordsFromAmountEntryGrid(InstallmentName);
			log.info("============= Finished tcDeleteRecordsFromAmountEntryGrid Test===========");
			getScreenShot("tcDeleteRecordsFromAmountEntryGrid");
		} catch (Exception e) {
			getScreenShot("tcDeleteRecordsFromAmountEntryGrid");
		}
	}
	@Test(priority = 31)
	public void tcRecordDeleteConfirmation() {
	
		try {
			log.info("============= Strting tcRecordDeleteConfirmation Test===========");
			feeamountentry.recordDeleteConfirmation();
			log.info("============= Finished tcRecordDeleteConfirmation Test===========");
			getScreenShot("tcRecordDeleteConfirmation");
		} catch (Exception e) {
			getScreenShot("tcRecordDeleteConfirmation");
		}
	}
	@Test(priority = 32)
	public void tcClickOnSuccessOkBtn_Delete() {
		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Delete Test===========");

			feeamountentry.clickOnSuccessOkBtn();
			
			log.info("============= Finished tcClickOnSuccessOkBtn_Delete Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Delete");
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
