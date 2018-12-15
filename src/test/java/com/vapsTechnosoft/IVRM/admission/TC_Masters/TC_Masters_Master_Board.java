/**
 * 
 */
package com.vapsTechnosoft.IVRM.admission.TC_Masters;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.Admission.Masters.Masters_Master_Board;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class TC_Masters_Master_Board extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_Masters_Master_Board.class.getName());

	Masters_Master_Board masterboard;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "MastersMasterBoardData")
	public String[][] getTestData() {
		String[][] testRecordsBoardDetails = getData("BGHS_AdmissionData.xlsx", "BGHS_MasterBoardInfoData");
		return testRecordsBoardDetails;
	}

	@DataProvider(name = "MasterBoardSearchData")
	public String[][] getTestSearchData() {
		String[][] testRecordsSearch = getData("BGHS_AdmissionData.xlsx", "BGHS_SearchByBoardNameData");
		return testRecordsSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		masterboard = new Masters_Master_Board(driver);
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

			boolean status = masterboard.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_Masters_MasterBoard_BGHS() {

		try {
			log.info("============= Strting tcNavigateToAdmission_Masters_MasterBoard_BGHS Test===========");

			masterboard.navigateToAdmission_Masters_MasterBoard_BGHS();

			log.info("============= Finished tcNavigateToAdmission_Masters_MasterBoard_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_Masters_MasterBoard_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_Masters_MasterBoard_BGHS");
		}
	}

	@Test(priority = 4)
	public void tcVerifyMasters_MasterBoard_BGHSPage() {

		try {
			log.info("============= Strting tcVerifyMasters_MasterBoard_BGHSPage Test===========");

			boolean status = masterboard.verifyMasters_MasterBoard_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyMasters_MasterBoard_BGHSPage Test===========");
			getScreenShot("tcVerifyMasters_MasterBoard_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyMasters_MasterBoard_BGHSPage");
		}
	}

	@Test(priority = 5)
	public void tcSubmitBlankMasterBoardForm() {

		try {
			log.info("============= Strting tcSubmitBlankMasterBoardForm Test===========");

			masterboard.submitBlankMasterBoardForm();

			log.info("============= Finished tcSubmitBlankMasterBoardForm Test===========");
			getScreenShot("tcSubmitBlankMasterBoardForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitBlankMasterBoardForm");
		}
	}
	
	@Test(priority = 6, dataProvider = "MastersMasterBoardData")
	public void tcEnterMasterBoardData(String boardName, String boardDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterBoardData Test===========");

			masterboard.enterMasterBoardData(boardName, boardDescription);

			log.info("============= Finished tcEnterMasterBoardData Test===========");
			getScreenShot("tcEnterMasterBoardData");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterBoardData");
		}
	}

	//
	@Test(priority = 7)
	public void tcClearBoardInfoData() {

		try {
			log.info("============= Strting tcClearBoardInfoData Test===========");

			masterboard.clearBoardInfoData();

			log.info("============= Finished tcClearBoardInfoData Test===========");
			getScreenShot("tcClearBoardInfoData");
		} catch (Exception e) {
			getScreenShot("tcClearBoardInfoData");
		}
	}

	@Test(priority = 8)
	public void tcMinimizeMasterBoard() {

		try {
			log.info("============= Strting tcMinimizeMasterBoard Test===========");

			masterboard.minimizeMasterBoard();

			log.info("============= Finished tcMinimizeMasterBoard Test===========");
			getScreenShot("tcMinimizeMasterBoard");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterBoard");
		}
	}
	@Test(priority = 9)
	public void tcSortByBoardName() {

		try {
			log.info("============= Strting tcSortByBoardName Test===========");
			getScreenShot("tcSortByBoardName_BeforeSort");
			
			masterboard.sortByBoardName();

			log.info("============= Finished tcSortByBoardName Test===========");
			getScreenShot("tcSortByBoardName");
		} catch (Exception e) {
			getScreenShot("tcSortByBoardName");
		}
	}

	@Test(priority = 10)
	public void tcMaximizeMasterBoard() {

		try {
			log.info("============= Strting tcMaximizeMasterBoard Test===========");

			masterboard.maximizeMasterBoard();

			log.info("============= Finished tcMaximizeMasterBoard Test===========");
			getScreenShot("tcMaximizeMasterBoard");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterBoard");
		}
	}

	@Test(priority = 11)
	public void tcMinimizeMasterBoardList() {

		try {
			log.info("============= Strting tcMinimizeMasterBoardList Test===========");

			masterboard.minimizeMasterBoardList();

			log.info("============= Finished tcMinimizeMasterBoardList Test===========");
			getScreenShot("tcMinimizeMasterBoardList");
		} catch (Exception e) {
			getScreenShot("tcMinimizeMasterBoardList");
		}
	}

	@Test(priority = 12)
	public void tcMaximizeMasterBoardList() {

		try {
			log.info("============= Strting tcMaximizeMasterBoardList Test===========");

			masterboard.maximizeMasterBoardList();

			log.info("============= Finished tcMaximizeMasterBoardList Test===========");
			getScreenShot("tcMaximizeMasterBoardList");
		} catch (Exception e) {
			getScreenShot("tcMaximizeMasterBoardList");
		}
	}
	
	@Test(priority = 13, dataProvider = "MastersMasterBoardData")
	public void tcEnterMasterBoardDData_AfterClear(String boardName, String boardDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterBoardDData_AfterClear Test===========");

			masterboard.enterMasterBoardData(boardName, boardDescription);

			log.info("============= Finished tcEnterMasterBoardDData_AfterClear Test===========");
			getScreenShot("tcEnterMasterBoardDData_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterBoardDData_AfterClear");
		}
	}
	
	@Test(priority = 14)
	public void tcSaveBoardInfoData() {

		try {
			log.info("============= Strting tcSaveBoardInfoData Test===========");

			masterboard.saveBoardInfoData();

			log.info("============= Finished tcSaveBoardInfoData Test===========");
			getScreenShot("tcSaveBoardInfoData");
		} catch (Exception e) {
			getScreenShot("tcSaveBoardInfoData");
		}
	}
	@Test(priority = 15)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			masterboard.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}

	@Test(priority = 16)
	public void tcClickOnOkSuccessButton() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			masterboard.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}
	
	@Test(priority = 17, dataProvider = "MasterBoardSearchData")
	public void tcSearchWithBoardNameInTheGrid(String boardName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithBoardNameInTheGrid Test===========");

			masterboard.searchWithBoardNameInTheGrid(boardName);

			log.info("============= Finished tcSearchWithBoardNameInTheGrid Test===========");
			getScreenShot("tcSearchWithBoardNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchWithBoardNameInTheGrid");
		}
	}

	@Test(priority = 18, dataProvider = "MasterBoardSearchData")
	public void tcVerifyBoardNameInTheGrid(String boardName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyBoardNameInTheGrid Test===========");

			masterboard.verifyBoardNameInTheGrid(boardName);

			log.info("============= Finished tcVerifyBoardNameInTheGrid Test===========");
			getScreenShot("tcVerifyBoardNameInTheGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyBoardNameInTheGrid");
		}
	}
	
	@Test(priority = 19, dataProvider = "MasterBoardSearchData")
	public void tcEditMasterBoard(String boardName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditMasterBoard Test===========");

			masterboard.editMasterBoard(boardName);

			log.info("============= Finished tcEditMasterBoard Test===========");
			getScreenShot("tcEditMasterBoard");
		} catch (Exception e) {
			getScreenShot("tcEditMasterBoard");
		}
	}

	@Test(priority = 20)
	public void tcSaveBoardInfoData_Edit() {

		try {
			log.info("============= Strting tcSaveBoardInfoData_Edit Test===========");

			masterboard.saveBoardInfoData();

			log.info("============= Finished tcSaveBoardInfoData_Edit Test===========");
			getScreenShot("tcSaveBoardInfoData_Edit");
		} catch (Exception e) {
			getScreenShot("tcSaveBoardInfoData_Edit");
		}
	}
	@Test(priority = 21)
	public void tcPopWindowMessage_SubmitSuccessfully_Edit_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");

			masterboard.popWindowMessage_SubmitSuccessfully_Edit();

			log.info("============= Finished tcPopWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_SubmitSuccessfully_Edit_Validation");
		}
	}

	@Test(priority = 22)
	public void tcClickOnOkSuccessButton_Edit() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			masterboard.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}

	@Test(priority = 23, dataProvider = "MasterBoardSearchData")
	public void tcSearchWithBoardNameInTheGrid_delete(String boardName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithBoardNameInTheGrid_delete Test===========");

			masterboard.searchWithBoardNameInTheGrid(boardName);

			log.info("============= Finished tcSearchWithBoardNameInTheGrid_delete Test===========");
			getScreenShot("tcSearchWithBoardNameInTheGrid_delete");
		} catch (Exception e) {
			getScreenShot("tcSearchWithBoardNameInTheGrid_delete");
		}
	}

	@Test(priority = 24, dataProvider = "MasterBoardSearchData")
	public void tcDeleteMasterBoard(String boardName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterBoard Test===========");

			masterboard.deleteMasterBoard(boardName);

			log.info("============= Finished tcDeleteMasterBoard Test===========");
			getScreenShot("tcDeleteMasterBoard");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterBoard");
		}
	}

	@Test(priority = 25)
	public void tcClickOnCancelButton() {

		try {
			log.info("============= Strting tcClickOnCancelButton Test===========");

			masterboard.clickOnCancelButton();

			log.info("============= Finished tcClickOnCancelButton Test===========");
			getScreenShot("tcClickOnCancelButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton");
		}
	}
	@Test(priority = 26)
	public void tcPopUpWindowMessage_DeleteCancel_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeleteCancel_Validation Test===========");

			masterboard.popWindowMessage_DeleteCancel_Validation();

			log.info("============= Finished tcPopUpWindowMessage_DeleteCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeleteCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeleteCancel_Validation");
		}
	}

	@Test(priority = 27)
	public void tcClickOnOkSuccessButton_cancel() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_cancel Test===========");

			masterboard.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_cancel Test===========");
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_cancel");
		}
	}
	

	@Test(priority = 28, dataProvider = "MasterBoardSearchData")
	public void tcSearchWithBoardNameInTheGrid_AfterDeleteCancel(String boardName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithBoardNameInTheGrid_AfterDeleteCancel Test===========");

			masterboard.searchWithBoardNameInTheGrid(boardName);

			log.info("============= Finished tcSearchWithBoardNameInTheGrid_AfterDeleteCancel Test===========");
			getScreenShot("tcSearchWithBoardNameInTheGrid_AfterDeleteCancel");
		} catch (Exception e) {
			getScreenShot("tcSearchWithBoardNameInTheGrid_AfterDeleteCancel");
		}
	}

	@Test(priority = 29, dataProvider = "MasterBoardSearchData")
	public void tcDeleteMasterBoard_AfterCancel(String boardName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeleteMasterBoard_AfterCancel Test===========");

			masterboard.deleteMasterBoard(boardName);

			log.info("============= Finished tcDeleteMasterBoard_AfterCancel Test===========");
			getScreenShot("tcDeleteMasterBoard_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeleteMasterBoard_AfterCancel");
		}
	}
	
	@Test(priority = 30)
	public void tcYesDeleteOrDeactivateOrActivateIt() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt Test===========");

			masterboard.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt");
		}
	}
	@Test(priority = 31)
	public void tcPopWindowMessage_DeletedSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopWindowMessage_DeletedSuccessfully_Validation Test===========");

			masterboard.popWindowMessage_DeletedSuccessfully();

			log.info("============= Finished tcPopWindowMessage_DeletedSuccessfully_Validation Test===========");
			getScreenShot("tcPopWindowMessage_DeletedSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopWindowMessage_DeletedSuccessfully_Validation");
		}
	}

	@Test(priority = 32)
	public void tcClickOnOkSuccessButton_delete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_delete Test===========");

			masterboard.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_delete Test===========");
			getScreenShot("tcClickOnOkSuccessButton_delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_delete");
		}
	}
	@Test(priority = 33, dataProvider = "MastersMasterBoardData")
	public void tcEnterMasterBoardData_AfterDelete(String boardName, String boardDescription, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterMasterBoardData_AfterDelete Test===========");

			masterboard.enterMasterBoardData(boardName, boardDescription);

			log.info("============= Finished tcEnterMasterBoardData_AfterDelete Test===========");
			getScreenShot("tcEnterMasterBoardData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcEnterMasterBoardData_AfterDelete");
		}
	}
	
	@Test(priority = 34)
	public void tcSaveBoardInfoData_AfterDelete() {

		try {
			log.info("============= Strting tcSaveBoardInfoData_AfterDelete Test===========");

			masterboard.saveBoardInfoData();

			log.info("============= Finished tcSaveBoardInfoData_AfterDelete Test===========");
			getScreenShot("tcSaveBoardInfoData_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSaveBoardInfoData_AfterDelete");
		}
	}
	@Test(priority = 35)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete Test===========");

			masterboard.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete");
		}
	}
	@Test(priority = 36)
	public void tcClickOnOkSuccessButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_AfterDelete Test===========");

			masterboard.clickOnOkSuccessButton();

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
