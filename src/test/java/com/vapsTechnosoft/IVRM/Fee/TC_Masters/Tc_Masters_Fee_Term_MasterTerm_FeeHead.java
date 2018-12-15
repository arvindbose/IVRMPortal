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
public class Tc_Masters_Fee_Term_MasterTerm_FeeHead extends TestBase {

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

			boolean status = feeTermFeeHead.verifyFeeTermPage();
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

	@Test(priority = 6)
	public void tcClickOnSaveButton_ToSubmitBlankForm() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitBlankForm Test===========");

			feeTermFeeHead.clickOnSaveButton_ToSubmitBlankForm();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitBlankForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		}
	}

	@Test(priority = 7, dataProvider = "FeeTermFeesHeadTestData")
	public void tcSelectTermFeeHeadAndInstallmentName(String TermName, String FeesHead, String installmentName,
			String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectTermFeeHeadAndInstallmentName Test===========");

			feeTermFeeHead.selectTermFeeHeadAndInstallmentName(TermName, FeesHead, installmentName);

			log.info("============= Finished tcSelectTermFeeHeadAndInstallmentName Test===========");
			getScreenShot("tcSelectTermFeeHeadAndInstallmentName");
		} catch (Exception e) {
			getScreenShot("tcSelectTermFeeHeadAndInstallmentName");
		}
	}

	@Test(priority = 8)
	public void tcMinimize_FeeTerm() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcMinimize_FeeTerm Test===========");

			feeTermFeeHead.minimizeAndMaximize_FeeTerm();

			log.info("============= Finished tcMinimize_FeeTerm Test===========");
			getScreenShot("tcMinimize_FeeTerm");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeTerm");
		}
	}

	@Test(priority = 9)
	public void tcSortByFeeTermName() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcSortByFeeTermName Test===========");

			feeTermFeeHead.sortByFeeTermName();

			log.info("============= Finished tcSortByFeeTermName Test===========");
			getScreenShot("tcSortByFeeTermName");
		} catch (Exception e) {
			getScreenShot("tcSortByFeeTermName");
		}
	}

	@Test(priority = 10)
	public void tcMinimize_FeeMasterTermGridView() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcMinimize_FeeMasterTermGridView Test===========");

			feeTermFeeHead.minimizeAndMaximize_FeeMasterTermGridView();

			log.info("============= Finished tcMinimize_FeeMasterTermGridView Test===========");
			getScreenShot("tcMinimize_FeeMasterTermGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeeMasterTermGridView");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_FeeMasterTermGridView() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcMaximize_FeeMasterTermGridView Test===========");

			feeTermFeeHead.minimizeAndMaximize_FeeMasterTermGridView();

			log.info("============= Finished tcMaximize_FeeMasterTermGridView Test===========");
			getScreenShot("tcMaximize_FeeMasterTermGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeMasterTermGridView");
		}
	}

	@Test(priority = 12)
	public void tcMaximize_FeeTerm() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcMaximize_FeeTerm Test===========");

			feeTermFeeHead.minimizeAndMaximize_FeeTerm();

			log.info("============= Finished tcMaximize_FeeTerm Test===========");
			getScreenShot("tcMaximize_FeeTerm");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeeTerm");
		}
	}

	@Test(priority = 13)
	public void tcClickOnCancelButton_ToClearFilledForm() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearFilledForm Test===========");

			feeTermFeeHead.clickOnCancelButton_ToClearFilledForm();

			log.info("============= Finished tcClickOnCancelButton_ToClearFilledForm Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledForm");
		}
	}

	@Test(priority = 14, dataProvider = "FeeTermFeesHeadTestData")
	public void tcSelectTermFeeHeadAndInstallmentName_AfterCancel(String TermName, String FeesHead,
			String installmentName, String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectTermFeeHeadAndInstallmentName_AfterCancel Test===========");

			feeTermFeeHead.selectTermFeeHeadAndInstallmentName(TermName, FeesHead, installmentName);

			log.info("============= Finished tcSelectTermFeeHeadAndInstallmentName_AfterCancel Test===========");
			getScreenShot("tcSelectTermFeeHeadAndInstallmentName_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectTermFeeHeadAndInstallmentName_AfterCancel");
		}
	}

	@Test(priority = 15)
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

	@Test(priority = 16)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			feeTermFeeHead.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}

	@Test(priority = 17)
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

	@Test(priority = 18, dataProvider = "FeeTermSearchTestData")
	public void tcSearchTermByTermName(String feeTermName, String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if (runMode.equalsIgnoreCase("n")) {
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

	@Test(priority = 19, dataProvider = "FeeTermSearchTestData")
	public void tcVerifyTermNameUpdatedInGrid(String feeTermName, String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if (runMode.equalsIgnoreCase("n")) {
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

	@Test(priority = 20, dataProvider = "FeeHeadTestData")
	public void tcVerifyFeeHeadUpdatedInGrid(String feeHeadName, String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if (runMode.equalsIgnoreCase("n")) {
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

	@Test(priority = 21, dataProvider = "FeeTermSearchTestData")
	public void tcEditFeeTerm_MasterTerm_FeeHead(String feeTermName, String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if (runMode.equalsIgnoreCase("n")) {
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

	@Test(priority = 22)
	public void tcClickOnSaveButtonEdit() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnSaveButtonEdit Test===========");

			feeTermFeeHead.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButtonEdit Test===========");
			getScreenShot("tcClickOnSaveButtonEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButtonEdit");
		}
	}

	@Test(priority = 23)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Edit() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Edit Test===========");

			feeTermFeeHead.popWindowMessage_SubmitSuccessfully_Edit();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Edit Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit");
		}
	}

	@Test(priority = 24)
	public void tcClickOnSuccessOkBtnEdit() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtnEdit Test===========");

			feeTermFeeHead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtnEdit Test===========");
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		}
	}
	@Test(priority = 25, dataProvider = "FeeTermSearchTestData")
	public void tcSearchTermByTermName_ToDelete(String feeTermName, String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchTermByTermName_ToDelete Test===========");

			feeTermFeeHead.searchTermByTermName(feeTermName);

			log.info("============= Finished tcSearchTermByTermName_ToDelete Test===========");
			getScreenShot("tcSearchTermByTermName_ToDelete");
		} catch (Exception e) {
			getScreenShot("tcSearchTermByTermName_ToDelete");
		}
	}
	
	@Test(priority = 26, dataProvider = "FeeTermSearchTestData")
	public void tcDeletiontionOfCreatedTermfeeHeadFromGrid(String feeTermName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeletiontionOfCreatedTermfeeHeadFromGrid Test===========");

			feeTermFeeHead.deletiontionOfCreatedTermfeeHead(feeTermName);

			log.info("============= Finished tcDeletiontionOfCreatedTermfeeHeadFromGrid Test===========");
			getScreenShot("tcDeletiontionOfCreatedTermfeeHeadFromGrid");
		} catch (Exception e) {
			getScreenShot("tcDeletiontionOfCreatedTermfeeHeadFromGrid");
		}
	}

	@Test(priority = 27)
	public void tcClickOnCancelButton_PopUp_delete() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_delete Test===========");

			feeTermFeeHead.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_delete Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_delete");
		}
	}
	@Test(priority = 28)
	public void PopUpWindowMessage_DeleteCancel_Validation() {
		try {
			log.info("============= Strting PopUpWindowMessage_DeleteCancel_Validation Test===========");

			feeTermFeeHead.popUpWindowMessage_DeleteCancel_Validation();

			log.info("============= Finished PopUpWindowMessage_DeleteCancel_Validation Test===========");
			getScreenShot("PopUpWindowMessage_DeleteCancel_Validation");
		} catch (Exception e) {
			getScreenShot("PopUpWindowMessage_DeleteCancel_Validation");
		}
	}
	@Test(priority = 29)
	public void tcClickOnOkSuccessButton_deleteCancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_deleteCancel Test===========");

			feeTermFeeHead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_deleteCancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_deleteCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_deleteCancel");
		}
	}

	@Test(priority = 30, dataProvider = "FeeTermSearchTestData")
	public void tcSearchTermByTermName_ToDelete_AfterCancel(String feeTermName, String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchTermByTermName_ToDelete_AfterCancel Test===========");

			feeTermFeeHead.searchTermByTermName(feeTermName);

			log.info("============= Finished tcSearchTermByTermName_ToDelete_AfterCancel Test===========");
			getScreenShot("tcSearchTermByTermName_ToDelete_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchTermByTermName_ToDelete_AfterCancel");
		}
	}


	@Test(priority = 31, dataProvider = "FeeTermSearchTestData")
	public void tcDeletiontionOfCreatedTermfeeHeadFromGrid_AfterCancel(String feeTermName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeletiontionOfCreatedTermfeeHeadFromGrid_AfterCancel Test===========");

			feeTermFeeHead.deletiontionOfCreatedTermfeeHead(feeTermName);

			log.info("============= Finished tcDeletiontionOfCreatedTermfeeHeadFromGrid_AfterCancel Test===========");
			getScreenShot("tcDeletiontionOfCreatedTermfeeHeadFromGrid_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeletiontionOfCreatedTermfeeHeadFromGrid_AfterCancel");
		}
	}
	@Test(priority = 32)
	public void tcYesDeleteOrDeactivateOrActivateIt_delete() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_delete Test===========");

			feeTermFeeHead.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_delete Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_delete");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_delete");
		}
	}
	@Test(priority = 33)
	public void PopUpWindowMessage_DeletedSucessfully_Validation() {
		
		try {
			log.info("============= Strting PopUpWindowMessage_DeletedSucessfully_Validation Test===========");

			feeTermFeeHead.popUpWindowMessage_DeleteSucessfully_Validation();

			log.info("============= Finished PopUpWindowMessage_DeletedSucessfully_Validation Test===========");
			getScreenShot("PopUpWindowMessage_DeletedSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("PopUpWindowMessage_DeletedSucessfully_Validation");
		}
	}
	@Test(priority = 34)
	public void tcClickOnOkSuccessButton_delete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_delete Test===========");

			feeTermFeeHead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}
	@Test(priority = 35, dataProvider = "FeeTermFeesHeadTestData")
	public void tcSelectTermFeeHeadAndInstallmentName_AfterDelete(String TermName, String FeesHead,
			String installmentName, String runMode) {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectTermFeeHeadAndInstallmentName_AfterDelete Test===========");

			feeTermFeeHead.selectTermFeeHeadAndInstallmentName(TermName, FeesHead, installmentName);

			log.info("============= Finished tcSelectTermFeeHeadAndInstallmentName_AfterDelete Test===========");
			getScreenShot("tcSelectTermFeeHeadAndInstallmentName_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSelectTermFeeHeadAndInstallmentName_AfterDelete");
		}
	}

	@Test(priority = 36)
	public void tcClickOnSaveButton_AfterDelete() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnSaveButton_AfterDelete Test===========");

			feeTermFeeHead.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_AfterDelete Test===========");
			getScreenShot("tcClickOnSaveButton_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_AfterDelete");
		}
	}

	@Test(priority = 37)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete Test===========");

			feeTermFeeHead.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete");
		}
	}

	@Test(priority = 38)
	public void tcClickOnSuccessOkBtn_AfterDelete() {
		feeTermFeeHead = new Masters_Fee_Term_MasterTerm_FeeHead(driver);

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_AfterDelete Test===========");

			feeTermFeeHead.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_AfterDelete Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_AfterDelete");
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
