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

import com.vapsTechnosoft.IVRM.Fee.Transaction.Transaction_Fee_Master_Concession;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class TC_Transaction_Fee_Master_Concession extends TestBase {

	public static final Logger log = Logger.getLogger(TC_Transaction_Fee_Master_Concession.class.getName());

	Transaction_Fee_Master_Concession feeMasterConcession;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "FeeMasterConcessionData_ClassWise")
	public String[][] getTestDataFeeConcession_ClassWise() {
		String[][] testRecordsFeeConcession_ClassWise = getData("FeeModueData.xlsx", "FeeMasterConcession_ClassWise");
		return testRecordsFeeConcession_ClassWise;
	}

	@DataProvider(name = "FeeMasterConcessionData_CategoryWise")
	public String[][] getTestDataFeeConcession_CategoryWise() {
		String[][] testRecordsFeeConcession_CategoryWise = getData("FeeModueData.xlsx",
				"FeeMasterConcession_CategoryWis");
		return testRecordsFeeConcession_CategoryWise;
	}

	@DataProvider(name = "Search_FeeConcession_ClassWise")
	public String[][] getTestDataFeeConcStudentSearch() {
		String[][] testRecordsFeeConcStudentSearch = getData("FeeModueData.xlsx", "Search_FeeConc_Classwise");
		return testRecordsFeeConcStudentSearch;
	}

	@DataProvider(name = "Search_FeeConcession_CategoryWise")
	public String[][] getTestDataFeeConcStudentSearch_CategoryWise() {
		String[][] testRecordsFeeConcStudentSearch_CategoryWise = getData("FeeModueData.xlsx",
				"Search_FeeConc_CategoryWise");
		return testRecordsFeeConcStudentSearch_CategoryWise;
	}

	@DataProvider(name = "FeeConcession_amountEntry")
	public String[][] getTestDataConcessionAmtEntry() {
		String[][] testRecordsConcessionAmtEntry = getData("FeeModueData.xlsx", "ConcessType_AndConcessionAmount");
		return testRecordsConcessionAmtEntry;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeMasterConcession = new Transaction_Fee_Master_Concession(driver);
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

			feeMasterConcession.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToTransaction_FeeMasterConcession() {

		try {
			log.info("============= Strting tcNavigateToTransaction_FeeMasterConcession Test===========");

			feeMasterConcession.navigateToTransaction_FeeMasterConcession();

			log.info("============= Finished tcNavigateToTransaction_FeeMasterConcession Test===========");
			getScreenShot("tcNavigateToTransaction_FeeMasterConcession");
		} catch (Exception e) {
			getScreenShot("tcNavigateToTransaction_FeeMasterConcession");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeMasterConcessionPageScreen() {

		try {
			log.info("============= Strting tcVerifyFeeMasterConcessionPageScreen Test===========");

			boolean status = feeMasterConcession.verifyFeeMasterConcessionPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeMasterConcessionPageScreen Test===========");
			getScreenShot("tcVerifyFeeMasterConcessionPageScreen");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeMasterConcessionPageScreen");
		}
	}

	@Test(priority = 5, dataProvider = "FeeMasterConcessionData_ClassWise")
	public void tcFill_FeeMasterConcessionForm_rdBtnClassWise(String academicYr, String class_ClassWise,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeMasterConcessionForm_rdBtnClassWise Test===========");

			feeMasterConcession.fill_FeeMasterConcessionForm_rdBtnClassWise(academicYr, class_ClassWise);
			log.info("============= Finished tcFill_FeeMasterConcessionForm_rdBtnClassWise Test===========");
			getScreenShot("tcFill_FeeMasterConcessionForm_rdBtnClassWise");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMasterConcessionForm_rdBtnClassWise");
		}
	}

	@Test(priority = 6)
	public void tcVerify_StudentList_IsPresent() {

		try {
			log.info("============= Strting tcVerify_StudentList_IsPresent Test===========");

			boolean status = feeMasterConcession.verify_StudentList_IsPresent();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerify_StudentList_IsPresent Test===========");
			getScreenShot("tcVerify_StudentList_IsPresent");
		} catch (Exception e) {
			getScreenShot("tcVerify_StudentList_IsPresent");
		}
	}

	@Test(priority = 7, dataProvider = "Search_FeeConcession_ClassWise")
	public void tcSearchStudentFromStudentList_rdBtnClassWise(String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentFromStudentList_rdBtnClassWise Test===========");

			feeMasterConcession.searchStudentFromStudentList(studentName);
			log.info("============= Finished tcSearchStudentFromStudentList_rdBtnClassWise Test===========");
			getScreenShot("tcSearchStudentFromStudentList_rdBtnClassWise");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentFromStudentList_rdBtnClassWise");
		}
	}

	@Test(priority = 8)
	public void tcSelectStudentForFeeConcession_FromStudentList_ClassWise() {

		try {
			log.info("============= Strting tcSelectStudentForFeeConcession_FromStudentList_ClassWise Test===========");

			feeMasterConcession.selectStudentForFeeConcession_FromStudentList();

			log.info(
					"============= Finished tcSelectStudentForFeeConcession_FromStudentList_ClassWise Test===========");
			getScreenShot("tcSelectStudentForFeeConcession_FromStudentList_ClassWise");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForFeeConcession_FromStudentList_ClassWise");
		}
	}

	@Test(priority = 9)
	public void tcVerify_FeeHeadList_IsPresent_ClassWise() {

		try {
			log.info("============= Strting tcVerify_FeeHeadList_IsPresent_ClassWise Test===========");

			boolean status = feeMasterConcession.verify_FeeHeadList_IsPresent();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerify_FeeHeadList_IsPresent_ClassWise Test===========");
			getScreenShot("tcVerify_FeeHeadList_IsPresent_ClassWise");
		} catch (Exception e) {
			getScreenShot("tcVerify_FeeHeadList_IsPresent_ClassWise");
		}
	}

	@Test(priority = 10, dataProvider = "FeeConcession_amountEntry")
	public void tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnClassWise(String concessionType, String amount,
			String remarks, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnClassWise Test===========");

			feeMasterConcession.selectFeeHeadTypeAnd_EnterConcessionAmount(concessionType, amount, remarks);
			log.info(
					"============= Finished tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnClassWise Test===========");
			getScreenShot("tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnClassWise");
		} catch (Exception e) {
			getScreenShot("tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnClassWise");
		}
	}

	@Test(priority = 11)
	public void tcMinimize_FeeConcession() {

		try {
			log.info("============= Strting tcMinimize_FeeConcession Test===========");

			feeMasterConcession.minimizeAndMaximize_FeeConcession();

			log.info("============= Finished tcMinimize_FeeConcession Test===========");
			getScreenShot("tcMinimize_FeeConcession");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeConcession");
		}
	}

	@Test(priority = 12)
	public void tcMinimize_StudentList() {

		try {
			log.info("============= Strting tcMinimize_StudentList Test===========");

			feeMasterConcession.minimizeAndMaximize_StudentList();

			log.info("============= Finished tcMinimize_StudentList Test===========");
			getScreenShot("tcMinimize_StudentList");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentList");
		}
	}

	@Test(priority = 13)
	public void tcMinimize_FeeHeadList() {

		try {
			log.info("============= Strting tcMinimize_FeeHeadList Test===========");

			feeMasterConcession.minimizeAndMaximize_FeeHeadList();

			log.info("============= Finished tcMinimize_FeeHeadList Test===========");
			getScreenShot("tcMinimize_FeeHeadList");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeHeadList");
		}
	}

	@Test(priority = 14)
	public void tcSortByStudentName_FeeMasterConcessionGrid() {

		try {
			log.info("============= Strting tcSortByStudentName_FeeMasterConcessionGrid Test===========");
			getScreenShot("BeforeSorting_tcSortByStudentName_FeeMasterConcessionGrid");

			feeMasterConcession.sortByStudentName();

			log.info("============= Finished tcSortByStudentName_FeeMasterConcessionGrid Test===========");
			getScreenShot("tcSortByStudentName_FeeMasterConcessionGrid");
		} catch (Exception e) {
			getScreenShot("tcSortByStudentName_FeeMasterConcessionGrid");
		}
	}

	@Test(priority = 15)
	public void tcMinimize_StudentFeeConcessionGridOutput() {

		try {
			log.info("============= Strting tcMinimize_StudentFeeConcessionGridOutput Test===========");

			feeMasterConcession.minimizeAndMaximize_StudentFeeConcessionGridOutput();

			log.info("============= Finished tcMinimize_StudentFeeConcessionGridOutput Test===========");
			getScreenShot("tcMinimize_StudentFeeConcessionGridOutput");
		} catch (Exception e) {
			getScreenShot("tcMinimize_StudentFeeConcessionGridOutput");
		}
	}

	@Test(priority = 16)
	public void tcMaximize_StudentFeeConcessionGridOutput() {

		try {
			log.info("============= Strting tcMaximize_StudentFeeConcessionGridOutput Test===========");

			feeMasterConcession.minimizeAndMaximize_StudentFeeConcessionGridOutput();

			log.info("============= Finished tcMaximize_StudentFeeConcessionGridOutput Test===========");
			getScreenShot("tcMaximize_StudentFeeConcessionGridOutput");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentFeeConcessionGridOutput");
		}
	}

	@Test(priority = 17)
	public void tcMaximize_FeeHeadList() {

		try {
			log.info("============= Strting tcMaximize_FeeHeadList Test===========");

			feeMasterConcession.minimizeAndMaximize_FeeHeadList();

			log.info("============= Finished tcMaximize_FeeHeadList Test===========");
			getScreenShot("tcMaximize_FeeHeadList");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeHeadList");
		}
	}

	@Test(priority = 18)
	public void tcMaximize_StudentList() {

		try {
			log.info("============= Strting tcMaximize_StudentList Test===========");

			feeMasterConcession.minimizeAndMaximize_StudentList();

			log.info("============= Finished tcMaximize_StudentList Test===========");
			getScreenShot("tcMaximize_StudentList");
		} catch (Exception e) {
			getScreenShot("tcMaximize_StudentList");
		}
	}

	@Test(priority = 19)
	public void tcMaximize_FeeConcession() {

		try {
			log.info("============= Strting tcMaximize_FeeConcession Test===========");

			feeMasterConcession.minimizeAndMaximize_FeeConcession();

			log.info("============= Finished tcMaximize_FeeConcession Test===========");
			getScreenShot("tcMaximize_FeeConcession");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeConcession");
		}
	}

	@Test(priority = 20)
	public void tcClickOnCancelButton_ToClearFilledData_ClassWise() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearFilledData_ClassWise Test===========");

			feeMasterConcession.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton_ToClearFilledData_ClassWise Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledData_ClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledData_ClassWise");
		}
	}

	@Test(priority = 21, dataProvider = "FeeMasterConcessionData_ClassWise")
	public void tcFill_FeeMasterConcessionForm_rdBtnClassWise_AfterCancel(String academicYr, String class_ClassWise,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeMasterConcessionForm_rdBtnClassWise_AfterCancel Test===========");

			feeMasterConcession.fill_FeeMasterConcessionForm_rdBtnClassWise(academicYr, class_ClassWise);
			log.info(
					"============= Finished tcFill_FeeMasterConcessionForm_rdBtnClassWise_AfterCancel Test===========");
			getScreenShot("tcFill_FeeMasterConcessionForm_rdBtnClassWise_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMasterConcessionForm_rdBtnClassWise_AfterCancel");
		}
	}

	@Test(priority = 22)
	public void tcVerify_StudentList_IsPresent_AfterCancel() {

		try {
			log.info("============= Strting tcVerify_StudentList_IsPresent_AfterCancel Test===========");

			boolean status = feeMasterConcession.verify_StudentList_IsPresent();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerify_StudentList_IsPresent_AfterCancel Test===========");
			getScreenShot("tcVerify_StudentList_IsPresent_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcVerify_StudentList_IsPresent_AfterCancel");
		}
	}

	@Test(priority = 23, dataProvider = "Search_FeeConcession_ClassWise")
	public void tcSearchStudentFromStudentList_rdBtnClassWise_AfterCancel(String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentFromStudentList_rdBtnClassWise_AfterCancel Test===========");

			feeMasterConcession.searchStudentFromStudentList(studentName);
			log.info(
					"============= Finished tcSearchStudentFromStudentList_rdBtnClassWise_AfterCancel Test===========");
			getScreenShot("tcSearchStudentFromStudentList_rdBtnClassWise_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentFromStudentList_rdBtnClassWise_AfterCancel");
		}
	}

	@Test(priority = 24)
	public void tcSelectStudentForFeeConcession_FromStudentList_ClassWise_AfterCancel() {

		try {
			log.info(
					"============= Strting tcSelectStudentForFeeConcession_FromStudentList_ClassWise_AfterCancel Test===========");

			feeMasterConcession.selectStudentForFeeConcession_FromStudentList();

			log.info(
					"============= Finished tcSelectStudentForFeeConcession_FromStudentList_ClassWise_AfterCancel Test===========");
			getScreenShot("tcSelectStudentForFeeConcession_FromStudentList_ClassWise_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForFeeConcession_FromStudentList_ClassWise_AfterCancel");
		}
	}

	@Test(priority = 25)
	public void tcVerify_FeeHeadList_IsPresent_ClassWise_AfterCancel() {

		try {
			log.info("============= Strting tcVerify_FeeHeadList_IsPresent_ClassWise_AfterCancel Test===========");

			boolean status = feeMasterConcession.verify_FeeHeadList_IsPresent();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerify_FeeHeadList_IsPresent_ClassWise_AfterCancel Test===========");
			getScreenShot("tcVerify_FeeHeadList_IsPresent_ClassWise_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcVerify_FeeHeadList_IsPresent_ClassWise_AfterCancel");
		}
	}

	@Test(priority = 26, dataProvider = "FeeConcession_amountEntry")
	public void tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnClassWise_AfterCancel(String concessionType,
			String amount, String remarks, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnClassWise_AfterCancel Test===========");

			feeMasterConcession.selectFeeHeadTypeAnd_EnterConcessionAmount(concessionType, amount, remarks);
			log.info(
					"============= Finished tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnClassWise_AfterCancel Test===========");
			getScreenShot("tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnClassWise_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnClassWise_AfterCancel");
		}
	}

	@Test(priority = 27)
	public void tcClickOnSaveButton_ClassWise() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ClassWise Test===========");

			feeMasterConcession.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_ClassWise Test===========");
			getScreenShot("tcClickOnSaveButton_ClassWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ClassWise");
		}
	}

	@Test(priority = 28)
	public void tcVerifySuccessfulPopUp() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status = feeMasterConcession.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}

	@Test(priority = 29)
	public void tcClickOnSuccessOkBtn_Classwise() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Classwise Test===========");

			feeMasterConcession.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Classwise Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Classwise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Classwise");
		}
	}
	/*
	 * Fee Concession Category Wise
	 */
	@Test(priority = 30, dataProvider = "FeeMasterConcessionData_CategoryWise")
	public void tcFill_FeeMasterConcessionForm_rdBtnCategoryWise(String category, String academicYr,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcFill_FeeMasterConcessionForm_rdBtnCategoryWise Test===========");

			feeMasterConcession.fill_FeeMasterConcessionForm_rdBtnCategoryWise(category, academicYr);
			log.info("============= Finished tcFill_FeeMasterConcessionForm_rdBtnCategoryWise Test===========");
			getScreenShot("tcFill_FeeMasterConcessionForm_rdBtnCategoryWise");
		} catch (Exception e) {
			getScreenShot("tcFill_FeeMasterConcessionForm_rdBtnCategoryWise");
		}
	}

	@Test(priority = 31)
	public void tcVerify_StudentList_IsPresent_CategoryWise() {

		try {
			log.info("============= Strting tcVerify_StudentList_IsPresent_CategoryWise Test===========");

			boolean status = feeMasterConcession.verify_StudentList_IsPresent();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerify_StudentList_IsPresent_CategoryWise Test===========");
			getScreenShot("tcVerify_StudentList_IsPresent_CategoryWise");
		} catch (Exception e) {
			getScreenShot("tcVerify_StudentList_IsPresent_CategoryWise");
		}
	}

	@Test(priority = 32, dataProvider = "Search_FeeConcession_CategoryWise")
	public void tcSearchStudentFromStudentList_rdBtnCategoryWise(String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentFromStudentList_rdBtnCategoryWise Test===========");

			feeMasterConcession.searchStudentFromStudentList(studentName);
			log.info("============= Finished tcSearchStudentFromStudentList_rdBtnCategoryWise Test===========");
			getScreenShot("tcSearchStudentFromStudentList_rdBtnCategoryWise");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentFromStudentList_rdBtnCategoryWise");
		}
	}

	@Test(priority = 33)
	public void tcSelectStudentForFeeConcession_FromStudentList_CategoryWise() {

		try {
			log.info("============= Strting tcSelectStudentForFeeConcession_FromStudentList_CategoryWise Test===========");

			feeMasterConcession.selectStudentForFeeConcession_FromStudentList();

			log.info(
					"============= Finished tcSelectStudentForFeeConcession_FromStudentList_CategoryWise Test===========");
			getScreenShot("tcSelectStudentForFeeConcession_FromStudentList_CategoryWise");
		} catch (Exception e) {
			getScreenShot("tcSelectStudentForFeeConcession_FromStudentList_CategoryWise");
		}
	}

	@Test(priority = 34)
	public void tcVerify_FeeHeadList_IsPresent_CategoryWise() {

		try {
			log.info("============= Strting tcVerify_FeeHeadList_IsPresent_CategoryWise Test===========");

			boolean status = feeMasterConcession.verify_FeeHeadList_IsPresent();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerify_FeeHeadList_IsPresent_CategoryWise Test===========");
			getScreenShot("tcVerify_FeeHeadList_IsPresent_CategoryWise");
		} catch (Exception e) {
			getScreenShot("tcVerify_FeeHeadList_IsPresent_CategoryWise");
		}
	}

	@Test(priority = 35, dataProvider = "FeeConcession_amountEntry")
	public void tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnCategoryWise(String concessionType, String amount,
			String remarks, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnCategoryWise Test===========");

			feeMasterConcession.selectFeeHeadTypeAnd_EnterConcessionAmount(concessionType, amount, remarks);
			log.info(
					"============= Finished tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnCategoryWise Test===========");
			getScreenShot("tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnCategoryWise");
		} catch (Exception e) {
			getScreenShot("tcSelectFeeHeadTypeAnd_EnterConcessionAmount_rdBtnCategoryWise");
		}
	}
	@Test(priority = 36)
	public void tcClickOnSaveButton_CategoryWise() {

		try {
			log.info("============= Strting tcClickOnSaveButton_CategoryWise Test===========");

			feeMasterConcession.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_CategoryWise Test===========");
			getScreenShot("tcClickOnSaveButton_CategoryWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_CategoryWise");
		}
	}
	@Test(priority = 37)
	public void tcVerifySuccessfulPopUp_CategoryWise() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp_CategoryWise Test===========");

			boolean status = feeMasterConcession.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp_CategoryWise Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_CategoryWise");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_CategoryWise");
		}
	}

	@Test(priority = 38)
	public void tcClickOnSuccessOkBtn_CategoryWise() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_CategoryWise Test===========");

			feeMasterConcession.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_CategoryWise Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_CategoryWise");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_CategoryWise");
		}
	}
	@Test(priority = 39, dataProvider = "Search_FeeConcession_CategoryWise")
	public void tcSearchStudentFrom_StudentFeeConcessionOutPutGrid(String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentFrom_StudentFeeConcessionOutPutGrid Test===========");

			feeMasterConcession.searchStudentFrom_StudentFeeConcessionGrid(studentName);
			log.info("============= Finished tcSearchStudentFrom_StudentFeeConcessionOutPutGrid Test===========");
			getScreenShot("tcSearchStudentFrom_StudentFeeConcessionOutPutGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentFrom_StudentFeeConcessionOutPutGrid");
		}
	}
	@Test(priority = 40)
	public void tcDeleteStudentFrom_StudentFeeConcessionGrid() {

		try {
			log.info("============= Strting tcDeleteStudentFrom_StudentFeeConcessionGrid Test===========");

			feeMasterConcession.deleteStudentFrom_StudentFeeConcessionGrid();

			log.info("============= Finished tcDeleteStudentFrom_StudentFeeConcessionGrid Test===========");
			getScreenShot("tcDeleteStudentFrom_StudentFeeConcessionGrid");
		} catch (Exception e) {
			getScreenShot("tcDeleteStudentFrom_StudentFeeConcessionGrid");
		}
	}
	@Test(priority = 41)
	public void tcClickOnCancelButton_PopUp_deleteCancel() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_deleteCancel Test===========");

			feeMasterConcession.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_deleteCancel Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_deleteCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_deleteCancel");
		}
	}
	@Test(priority = 42)
	public void tcClickOnSuccessOkBtn_PopUp_deleteCancel() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_PopUp_deleteCancel Test===========");

			feeMasterConcession.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_PopUp_deleteCancel Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_PopUp_deleteCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_PopUp_deleteCancel");
		}
	}
	@Test(priority = 43, dataProvider = "Search_FeeConcession_CategoryWise")
	public void tcSearchStudentFrom_StudentFeeConcessionOutPutGrid_AfterCancel(String studentName, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchStudentFrom_StudentFeeConcessionOutPutGrid_AfterCancel Test===========");

			feeMasterConcession.searchStudentFrom_StudentFeeConcessionGrid(studentName);
			log.info("============= Finished tcSearchStudentFrom_StudentFeeConcessionOutPutGrid_AfterCancel Test===========");
			getScreenShot("tcSearchStudentFrom_StudentFeeConcessionOutPutGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchStudentFrom_StudentFeeConcessionOutPutGrid_AfterCancel");
		}
	}
	@Test(priority = 44)
	public void tcDeleteStudentFrom_StudentFeeConcessionGrid_AfterCancel() {

		try {
			log.info("============= Strting tcDeleteStudentFrom_StudentFeeConcessionGrid_AfterCancel Test===========");

			feeMasterConcession.deleteStudentFrom_StudentFeeConcessionGrid();

			log.info("============= Finished tcDeleteStudentFrom_StudentFeeConcessionGrid_AfterCancel Test===========");
			getScreenShot("tcDeleteStudentFrom_StudentFeeConcessionGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteStudentFrom_StudentFeeConcessionGrid_AfterCancel");
		}
	}
	@Test(priority = 45)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			feeMasterConcession.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}
	@Test(priority = 46)
	public void tcClickOnSuccessOkBtn_PopUp_YesDelete() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_PopUp_YesDelete Test===========");

			feeMasterConcession.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_PopUp_YesDelete Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_PopUp_YesDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_PopUp_YesDelete");
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
