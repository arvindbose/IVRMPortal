/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.TC_Transaction;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Fee.Transaction.Transaction_Fee_Transaction;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Transaction_Fee_Transaction extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Transaction_Fee_Transaction.class.getName());

	Transaction_Fee_Transaction feeTransaction;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "FeeTransTestData")
	public String[][] getTestDataStuFeeTrns() {
		String[][] testRecordsFeeTrans = getData("FeeModueData.xlsx", "FeeTransactionStuName");
		return testRecordsFeeTrans;
	}

	@DataProvider(name = "StudentInfoTestData")
	public String[][] getTestDataStuInfo() {
		String[][] testRecordsStuInfo = getData("FeeModueData.xlsx", "FTransStudentInfoData");
		return testRecordsStuInfo;
	}

	@DataProvider(name = "HeadAmountTestData")
	public String[][] getTestDataAmount() {
		String[][] testRecordsAmt = getData("FeeModueData.xlsx", "FeeTransFeeHeadAmont");
		return testRecordsAmt;
	}

	@DataProvider(name = "bankDetailsTestData")
	public String[][] getTestBank() {
		String[][] testRecordsBank = getData("FeeModueData.xlsx", "BankDetailsData");
		return testRecordsBank;
	}

	@DataProvider(name = "searchOutputGridTestData")
	public String[][] getTestDataStuFeeMap() {
		String[][] testRecordsSFGM = getData("FeeModueData.xlsx", "studentFeeGroupTestData");
		return testRecordsSFGM;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeTransaction = new Transaction_Fee_Transaction(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		feeTransaction = new Transaction_Fee_Transaction(driver);
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
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			feeTransaction.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateTo_FeeTransaction() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcNevigateTo_FeeTransaction Test===========");

			feeTransaction.nevigateTo_FeeTransaction();

			log.info("============= Finished tcNevigateTo_FeeTransaction Test===========");
			getScreenShot("tcNevigateTo_FeeTransaction");
		} catch (Exception e) {
			getScreenShot("tcNevigateTo_FeeTransaction");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeTransactionPage() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcVerifyFeeTransactionPage Test===========");

			boolean status = feeTransaction.verifyFeeTransactionPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeTransactionPage Test===========");
			getScreenShot("tcVerifyFeeTransactionPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeTransactionPage");
		}
	}

	@Test(priority = 5)
	public void tcSelectRegularButton() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcSelectRegularButton Test===========");

			feeTransaction.selectRegularButton();

			log.info("============= Finished tcSelectRegularButton Test===========");
			getScreenShot("tcSelectRegularButton");
		} catch (Exception e) {
			getScreenShot("tcSelectRegularButton");
		}
	}

	@Test(priority = 6)
	public void tcVerifyAcademicYear() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcVerifyAcademicYear Test===========");

			boolean status = feeTransaction.verifyAcademicYear();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAcademicYear Test===========");
			getScreenShot("tcVerifyAcademicYear");
		} catch (Exception e) {
			getScreenShot("tcVerifyAcademicYear");
		}
	}

	@Test(priority = 7, dataProvider = "FeeTransTestData")
	public void tcEnterStudentNameAndSeelctFeeGrCheck(String studentName, String runMode) {
		feeTransaction = new Transaction_Fee_Transaction(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterStudentNameAndSeelctFeeGrCheck Test===========");

			feeTransaction.enterStudentNameAndSeelctFeeGrCheck(studentName);

			log.info("============= Finished tcEnterStudentNameAndSeelctFeeGrCheck Test===========");
			getScreenShot("tcEnterStudentNameAndSeelctFeeGrCheck");
		} catch (Exception e) {
			getScreenShot("tcEnterStudentNameAndSeelctFeeGrCheck");
		}
	}

	@Test(priority = 8, dataProvider = "StudentInfoTestData")
	public void tcValidateStudentInformationData(String stuName, String stuAdmNo, String stuRollNo, String stuMobNo,
			String stuClass, String stuSection, String stuFather, String stuDateOB, String runMode) {
		feeTransaction = new Transaction_Fee_Transaction(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcValidateStudentInformationData Test===========");

			feeTransaction.validateStudentInformationData(stuName, stuAdmNo, stuRollNo, stuMobNo, stuClass, stuSection,
					stuFather, stuDateOB);

			log.info("============= Finished tcValidateStudentInformationData Test===========");
			getScreenShot("tcValidateStudentInformationData");
		} catch (Exception e) {
			getScreenShot("tcValidateStudentInformationData");
		}
	}

	@Test(priority = 9, dataProvider = "HeadAmountTestData")
	public void tcTableEnterPayableAmount(String feeHead, String amount) {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcTableEnterPayableAmount Test===========");

			feeTransaction.tableEnterPayableAmount(feeHead, amount);

			log.info("============= Finished tcTableEnterPayableAmount Test===========");
			getScreenShot("tcTableEnterPayableAmount");
		} catch (Exception e) {
			getScreenShot("tcTableEnterPayableAmount");
		}
	}

	@Test(priority = 10, dataProvider = "bankDetailsTestData")
	public void tcBankDetailsAndNarration(String enterNarration, String chequeNo, String bankName, String chequeDueDate,
			String runMode) {
		feeTransaction = new Transaction_Fee_Transaction(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcBankDetailsAndNarration Test===========");

			feeTransaction.bankDetailsAndNarration(enterNarration, chequeNo, bankName, chequeDueDate);

			log.info("============= Finished tcBankDetailsAndNarration Test===========");
			getScreenShot("tcBankDetailsAndNarration");
		} catch (Exception e) {
			getScreenShot("tcBankDetailsAndNarration");
		}
	}

	@Test(priority = 11)
	public void tcClickOnSaveButton() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			feeTransaction.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 12)
	public void tcAfterSavePupUpHandlingCancel() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcAfterSavePupUpHandlingCancel Test===========");

			feeTransaction.afterSavePupUpHandlingCancel();

			log.info("============= Finished tcAfterSavePupUpHandlingCancel Test===========");
			getScreenShot("tcAfterSavePupUpHandlingCancel");
		} catch (Exception e) {
			getScreenShot("tcAfterSavePupUpHandlingCancel");
		}
	}

	@Test(priority = 13)
	public void tcClickOnFailedOkBtn() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			feeTransaction.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	@Test(priority = 14)
	public void tcClickOnSaveButtonAfterConfirmCancel() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			feeTransaction.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 15)
	public void tcAfterSavePupUpHandlingYesSaveit() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcAfterSavePupUpHandlingYesSaveit Test===========");

			feeTransaction.afterSavePupUpHandlingYesSaveit();

			log.info("============= Finished tcAfterSavePupUpHandlingYesSaveit Test===========");
			getScreenShot("tcAfterSavePupUpHandlingYesSaveit");
		} catch (Exception e) {
			getScreenShot("tcAfterSavePupUpHandlingYesSaveit");
		}
	}

	@Test(priority = 16)
	public void tcVerifySuccessfulPopUp() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status = feeTransaction.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}

	@Test(priority = 17)
	public void tcClickOnSuccessOkBtn() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			feeTransaction.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	@Test(priority = 18, dataProvider = "searchOutputGridTestData")
	public void tcValidationOfDataInOutputTableGrid(String byStudentName, String StdName, String runMode) {
		feeTransaction = new Transaction_Fee_Transaction(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcValidationOfDataInOutputTableGrid Test===========");

			feeTransaction.validationOfDataInOutputTableGrid(byStudentName, StdName);

			log.info("============= Finished tcValidationOfDataInOutputTableGrid Test===========");
			getScreenShot("tcValidationOfDataInOutputTableGrid");
		} catch (Exception e) {
			getScreenShot("tcValidationOfDataInOutputTableGrid");
		}
	}

	@Test(priority = 19, dataProvider = "FeeTransTestData")
	public void tcPrintReceiptValidation(String studentName, String runMode) {
		feeTransaction = new Transaction_Fee_Transaction(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcPrintReceiptValidation Test===========");

			feeTransaction.printReceiptValidation(studentName);

			log.info("============= Finished tcPrintReceiptValidation Test===========");
			getScreenShot("tcPrintReceiptValidation");
		} catch (Exception e) {
			getScreenShot("tcPrintReceiptValidation");
		}
	}

	@Test(priority = 20)
	public void tcClickOnFeeReceiptCloseButton() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcClickOnFeeReceiptCloseButton Test===========");

			feeTransaction.clickOnFeeReceiptCloseButton();

			log.info("============= Finished tcClickOnFeeReceiptCloseButton Test===========");
			getScreenShot("tcClickOnFeeReceiptCloseButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnFeeReceiptCloseButton");
		}
	}

	@Test(priority = 21, dataProvider = "searchOutputGridTestData")
	public void tcClickOnPrintReceiptButton(String byStudentName,String StdName, String runMode) {
		feeTransaction = new Transaction_Fee_Transaction(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcClickOnPrintReceiptButton Test===========");

			feeTransaction.clickOnPrintReceiptButton(byStudentName, StdName);

			log.info("============= Finished tcClickOnPrintReceiptButton Test===========");
			getScreenShot("tcClickOnPrintReceiptButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnPrintReceiptButton");
		}
	}

	@Test(priority = 22)
	public void tcPrintOfFeereceipt() {
		feeTransaction = new Transaction_Fee_Transaction(driver);

		try {
			log.info("============= Strting tcPrintOfFeereceipt Test===========");

			feeTransaction.printOfFeereceipt();

			log.info("============= Finished tcPrintOfFeereceipt Test===========");
			getScreenShot("tcPrintOfFeereceipt");
		} catch (Exception e) {
			getScreenShot("tcPrintOfFeereceipt");
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
