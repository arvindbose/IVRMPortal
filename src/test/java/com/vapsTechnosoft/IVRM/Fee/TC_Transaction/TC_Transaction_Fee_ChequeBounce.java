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

import com.vapsTechnosoft.IVRM.Fee.Transaction.Transaction_Fee_ChequeBounce;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Transaction_Fee_ChequeBounce extends TestBase{
	public static final Logger log = Logger.getLogger(TC_Transaction_Fee_ChequeBounce.class.getName());

	Transaction_Fee_ChequeBounce chequebounce;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "FeeChequeBounceData")
	public String[][] getTestData() {
		String[][] testRecordsChequeBounce = getData("FeeTransaction.xlsx", "FeeChequeBounce_Form");
		return testRecordsChequeBounce;
	}

	@DataProvider(name = "Search_FeeChequeBounceData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearchDetails = getData("FeeTransaction.xlsx", "Search_FeeChequeBounce");
		return testRecordsSearchDetails;
	}
	@DataProvider(name = "Verify_ChequeBounceGridRecords")
	public String[][] getTestChequeBounceGridRecords() {
		String[][] testRecordsChequeBounceGridRecords = getData("FeeTransaction.xlsx", "Verify_ChequeBounceGridData");
		return testRecordsChequeBounceGridRecords;
	}

	
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		chequebounce = new Transaction_Fee_ChequeBounce(driver);
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

			boolean status = chequebounce.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToFeeTransaction_ChequeBounce() {

		try {
			log.info("============= Strting tcNavigateToFeeTransaction_ChequeBounce Test===========");

			chequebounce.navigateToFeeTransaction_ChequeBounce();

			log.info("============= Finished tcNavigateToFeeTransaction_ChequeBounce Test===========");
			getScreenShot("tcNavigateToFeeTransaction_ChequeBounce");
		} catch (Exception e) {
			getScreenShot("tcNavigateToFeeTransaction_ChequeBounce");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeChequeBounce_Page() {

		try {
			log.info("============= Strting tcVerifyFeeChequeBounce_Page Test===========");

			boolean status = chequebounce.verifyFeeChequeBouncePage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeChequeBounce_Page Test===========");
			getScreenShot("tcVerifyFeeChequeBounce_Page");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeChequeBounce_Page");
		}
	}

//	@Test(priority = 5)
//	public void tcSubmitBlank_FeeChequeBounceForm() {
//
//		try {
//			log.info("============= Strting tcSubmitBlank_FeeChequeBounceForm Test===========");
//
//			chequebounce.submitBlank_FeeChequeBounceForm();
//
//			log.info("============= Finished tcSubmitBlank_FeeChequeBounceForm Test===========");
//			getScreenShot("tcSubmitBlank_FeeChequeBounceForm");
//		} catch (Exception e) {
//			getScreenShot("tcSubmitBlank_FeeChequeBounceForm");
//		}
//	}

	@Test(priority = 6, dataProvider = "FeeChequeBounceData")
	public void tcFill_FeeChequeBounce_Form(String academicYear, String stu_Class,String studentName,String receiptNo,String remarks, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeChequeBounce_Form Test===========");

			chequebounce.fill_FeeChequeBounce_Form(academicYear, stu_Class, studentName, receiptNo, remarks);

			log.info("============= Finished tcFill_FeeChequeBounce_Form Test===========");
			getScreenShot("tcFill_FeeChequeBounce_Form");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeChequeBounce_Form");
		}
	}

	@Test(priority = 7)
	public void tcMinimize_FeeChequeBounce_Form() {

		try {
			log.info("============= Strting tcMinimize_FeeChequeBounce_Form Test===========");

			chequebounce.min_Max_FeeChequeBounce();

			log.info("============= Finished tcMinimize_FeeChequeBounce_Form Test===========");
			getScreenShot("tcMinimize_FeeChequeBounce_Form");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeChequeBounce_Form");
		}
	}

//	@Test(priority = 8)
//	public void tcSortRecordsByStudentName() {
//
//		try {
//			log.info("============= Strting tcSortRecordsByStudentName Test===========");
//			getScreenShot("BeforeSorting_tcSortRecordsByStudentName");
//
//			chequebounce.sortRecordsByFeeHeadName();
//
//			log.info("============= Finished tcSortRecordsByStudentName Test===========");
//			getScreenShot("tcSortRecordsByStudentName");
//		} catch (Exception e) {
//			getScreenShot("tcSortRecordsByStudentName");
//		}
//	}

	@Test(priority = 9)
	public void tcMinimize_FeeChequeBounce_GridView() {

		try {
			log.info("============= Strting tcMinimize_FeeChequeBounce_GridView Test===========");

			chequebounce.min_Max_FeeChequeBounce_GridView();
			log.info("============= Finished tcMinimize_FeeChequeBounce_GridView Test===========");
			getScreenShot("tcMinimize_FeeChequeBounce_GridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeChequeBounce_GridView");
		}
	}

	@Test(priority = 10)
	public void tcMaximize_FeeChequeBounce_GridView() {

		try {
			log.info("============= Strting tcMaximize_FeeChequeBounce_GridView Test===========");

			chequebounce.min_Max_FeeChequeBounce_GridView();

			log.info("============= Finished tcMaximize_FeeChequeBounce_GridView Test===========");
			getScreenShot("tcMaximize_FeeChequeBounce_GridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeChequeBounce_GridView");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_FeeChequeBounce_Form() {

		try {
			log.info("============= Strting tcMaximize_FeeChequeBounce_Form Test===========");

			chequebounce.min_Max_FeeChequeBounce();

			log.info("============= Finished tcMaximize_FeeChequeBounce_Form Test===========");
			getScreenShot("tcMaximize_FeeChequeBounce_Form");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeChequeBounce_Form");
		}
	}

	@Test(priority = 12)
	public void tcClickOnCancelButton_ToClearFilledChequeBounceForm() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearFilledChequeBounceForm Test===========");

			chequebounce.clickOnCancelButton_ToClearFilledChequeBounceForm();

			log.info("============= Finished tcClickOnCancelButton_ToClearFilledChequeBounceForm Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledChequeBounceForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledChequeBounceForm");
		}
	}
	@Test(priority = 13, dataProvider = "FeeChequeBounceData")
	public void tcFill_FeeChequeBounce_Form_AfterCancel(String academicYear, String stu_Class,String studentName,String receiptNo,String remarks, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeChequeBounce_Form_AfterCancel Test===========");

			chequebounce.fill_FeeChequeBounce_Form(academicYear, stu_Class, studentName, receiptNo, remarks);

			log.info("============= Finished tcFill_FeeChequeBounce_Form_AfterCancel Test===========");
			getScreenShot("tcFill_FeeChequeBounce_Form_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeChequeBounce_Form_AfterCancel");
		}
	}
	@Test(priority = 14)
	public void tcClickOnSaveButton_ToSubmitChequeBounceForm() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitChequeBounceForm Test===========");

			chequebounce.clickOnSaveButton_ToSubmitChequeBounceForm();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitChequeBounceForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitChequeBounceForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitChequeBounceForm");
		}
	}
	@Test(priority = 15)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			chequebounce.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}
	
	@Test(priority = 16, dataProvider = "Search_FeeChequeBounceData")
	public void tcSearchByStudentNameInGrid(String byStudentName,String studentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByStudentNameInGrid Test===========");

			chequebounce.searchByStudentNameInGrid(byStudentName, studentName);

			log.info("============= Finished tcSearchByStudentNameInGrid Test===========");
			getScreenShot("tcSearchByStudentNameInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchByStudentNameInGrid");
		}
	}
	@Test(priority = 17, dataProvider = "Verify_ChequeBounceGridRecords")
	public void tcVerifyChequeBounceStudentDetailsUpdatedInGrid(String studentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyChequeBounceStudentDetailsUpdatedInGrid Test===========");

			chequebounce.verifyChequeBounceStudentDetailsUpdatedInGrid(studentName);

			log.info("============= Finished tcVerifyChequeBounceStudentDetailsUpdatedInGrid Test===========");
			getScreenShot("tcVerifyChequeBounceStudentDetailsUpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyChequeBounceStudentDetailsUpdatedInGrid");
		}
	}
	

	@Test(priority = 18, dataProvider = "Verify_ChequeBounceGridRecords")
	public void tcDeleteChequeBounceDetailsFromGrid(String studentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteChequeBounceDetailsFromGrid Test===========");

			chequebounce.deleteChequeBounceDetailsFromGrid(studentName);

			log.info("============= Finished tcDeleteChequeBounceDetailsFromGrid Test===========");
			getScreenShot("tcDeleteChequeBounceDetailsFromGrid");
		} catch (Exception e) {
			getScreenShot("tcDeleteChequeBounceDetailsFromGrid");
		}
	}

	@Test(priority = 19)
	public void tcCancel_DeletePopUp() {

		try {
			log.info("============= Strting tcCancel_DeletePopUp Test===========");

			chequebounce.cancel_DeletePopUp();

			log.info("============= Finished tcCancel_DeletePopUp Test===========");
			getScreenShot("tcCancel_DeletePopUp");
		} catch (Exception e) {
			getScreenShot("tcCancel_DeletePopUp");
		}
	}

	@Test(priority = 20)
	public void tcClickOnOkSuccessButton_cancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_cancel Test===========");

			chequebounce.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_cancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		}
	}
	

	@Test(priority = 21, dataProvider = "Verify_ChequeBounceGridRecords")
	public void tcDeleteChequeBounceDetailsFromGrid_AfterCancel(String studentName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteChequeBounceDetailsFromGrid_AfterCancel Test===========");

			chequebounce.deleteChequeBounceDetailsFromGrid(studentName);

			log.info("============= Finished tcDeleteChequeBounceDetailsFromGrid_AfterCancel Test===========");
			getScreenShot("tcDeleteChequeBounceDetailsFromGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteChequeBounceDetailsFromGrid_AfterCancel");
		}
	}

	@Test(priority = 22)
	public void tcConfirmationForDelete_YesDeleteIt() {

		try {
			log.info("============= Strting tcConfirmationForDelete_YesDeleteIt Test===========");

			chequebounce.confirmationForDelete();

			log.info("============= Finished tcConfirmationForDelete_YesDeleteIt Test===========");
			getScreenShot("tcConfirmationForDelete_YesDeleteIt");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForDelete_YesDeleteIt");
		}
	}

	@Test(priority = 23)
	public void tcClickOnOkSuccessButton_delete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_delete Test===========");

			chequebounce.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}
	@Test(priority = 24, dataProvider = "FeeChequeBounceData")
	public void tcFill_FeeChequeBounce_Form_AfterDelete(String academicYear, String stu_Class,String studentName,String receiptNo,String remarks, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeChequeBounce_Form_AfterDelete Test===========");

			chequebounce.fill_FeeChequeBounce_Form(academicYear, stu_Class, studentName, receiptNo, remarks);

			log.info("============= Finished tcFill_FeeChequeBounce_Form_AfterDelete Test===========");
			getScreenShot("tcFill_FeeChequeBounce_Form_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeChequeBounce_Form_AfterDelete");
		}
	}
	
	@Test(priority = 25)
	public void tcClickOnSaveButton_ToSubmitChequeBounceForm_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitChequeBounceForm_AfterDelete Test===========");

			chequebounce.clickOnSaveButton_ToSubmitChequeBounceForm();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitChequeBounceForm_AfterDelete Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitChequeBounceForm_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitChequeBounceForm_AfterDelete");
		}
	}

	@Test(priority = 26)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			chequebounce.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_AfterDelete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_AfterDelete");
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
