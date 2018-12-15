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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Fee_UserGroup_LoginPrivilege;
import com.vapsTechnosoft.IVRM.LoginLogOut.IvrmPortalLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_UserGroup_LoginPrivilege extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_UserGroup_LoginPrivilege.class.getName());

	Masters_Fee_UserGroup_LoginPrivilege groupLoginPreviledge;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "FeePreviledgeTestData")
	public String[][] getTestDataLoginPrevilege() {
		String[][] testRecordsLoginPrevilege = getData("FeeModueData.xlsx", "FeeLoginPreviledge");
		return testRecordsLoginPrevilege;
	}

	@DataProvider(name = "Search_FeePreviledgeTestData")
	public String[][] getTestDataYGHMap() {
		String[][] testRecordsLoginPrevilegeSearch = getData("FeeModueData.xlsx", "Search_FeeLoginPreviledge");
		return testRecordsLoginPrevilegeSearch;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		groupLoginPreviledge = new Masters_Fee_UserGroup_LoginPrivilege(driver);
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

			groupLoginPreviledge.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateToFeeUserGr_LoginPreviledge() {

		try {
			log.info("============= Strting tcNevigateToFeeUserGr_LoginPreviledge Test===========");

			groupLoginPreviledge.nevigateToFeeUserGr_LoginPreviledge();

			log.info("============= Finished tcNevigateToFeeUserGr_LoginPreviledge Test===========");
			getScreenShot("tcNevigateToFeeUserGr_LoginPreviledge");
		} catch (Exception e) {
			getScreenShot("tcNevigateToFeeUserGr_LoginPreviledge");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeUserGrLoginPreviledgePagee() {

		try {
			log.info("============= Strting tcVerifyFeeUserGrLoginPreviledgePagee Test===========");

			boolean status = groupLoginPreviledge.verifyFeeUserGrLoginPreviledgePage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeUserGrLoginPreviledgePagee Test===========");
			getScreenShot("tcVerifyFeeUserGrLoginPreviledgePagee");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeUserGrLoginPreviledgePagee");
		}
	}

	@Test(priority = 5)
	public void tcClickOnSaveButton_ToSubmitBlankForm() {

		try {
			log.info("============= Strting tcClickOnSaveButton_ToSubmitBlankForm Test===========");

			groupLoginPreviledge.clickOnSaveButton_ToSubmitBlankForm();

			log.info("============= Finished tcClickOnSaveButton_ToSubmitBlankForm Test===========");
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_ToSubmitBlankForm");
		}
	}

	@Test(priority = 6, dataProvider = "FeePreviledgeTestData")
	public void tcSelectAcademicYear_GroupAndRole(String AcademicYear, String userGroup, String role, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYear_GroupAndRole Test===========");

			groupLoginPreviledge.selectAcademicYear_GroupAndRole(AcademicYear, userGroup, role);

			log.info("============= Finished tcSelectAcademicYear_GroupAndRole Test===========");
			getScreenShot("tcSelectAcademicYear_GroupAndRole");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYear_GroupAndRole");
		}
	}

	@Test(priority = 7)
	public void tcMinimize_FeePrevilege() {

		try {
			log.info("============= Strting tcMinimize_FeePrevilege Test===========");

			groupLoginPreviledge.minimizeAndMaximize_FeePrevilege();

			log.info("============= Finished tcMinimize_FeePrevilege Test===========");
			getScreenShot("tcMinimize_FeePrevilege");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeePrevilege");
		}
	}

	@Test(priority = 8)
	public void tcSortByUserName_InOutPutGrid() {

		try {
			log.info("============= Strting tcSortByUserName_InOutPutGrid Test===========");

			groupLoginPreviledge.sortByUserName();

			log.info("============= Finished tcSortByUserName_InOutPutGrid Test===========");
			getScreenShot("tcSortByUserName_InOutPutGrid");
		} catch (Exception e) {
			getScreenShot("tcSortByUserName_InOutPutGrid");
		}
	}

	@Test(priority = 9)
	public void tcMinimize_FeePrevilegeGridView() {

		try {
			log.info("============= Strting tcMinimize_FeePrevilegeGridView Test===========");

			groupLoginPreviledge.minimizeAndMaximize_FeePrevilegeGridView();

			log.info("============= Finished tcMinimize_FeePrevilegeGridView Test===========");
			getScreenShot("tcMinimize_FeePrevilegeGridView");
		} catch (Exception e) {
			getScreenShot("tcMinimize_FeePrevilegeGridView");
		}
	}

	@Test(priority = 10)
	public void tcMaximize_FeePrevilegeGridView() {

		try {
			log.info("============= Strting tcMaximize_FeePrevilegeGridView Test===========");

			groupLoginPreviledge.minimizeAndMaximize_FeePrevilegeGridView();

			log.info("============= Finished tcMaximize_FeePrevilegeGridView Test===========");
			getScreenShot("tcMaximize_FeePrevilegeGridView");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeePrevilegeGridView");
		}
	}

	@Test(priority = 11)
	public void tcMaximize_FeePrevilege() {

		try {
			log.info("============= Strting tcMaximize_FeePrevilege Test===========");

			groupLoginPreviledge.minimizeAndMaximize_FeePrevilege();

			log.info("============= Finished tcMaximize_FeePrevilege Test===========");
			getScreenShot("tcMaximize_FeePrevilege");
		} catch (Exception e) {
			getScreenShot("tcMaximize_FeePrevilege");
		}
	}

	@Test(priority = 12)
	public void tcClickOnCancelButton_ToClearFilledData() {

		try {
			log.info("============= Strting tcClickOnCancelButton_ToClearFilledData Test===========");

			groupLoginPreviledge.clickOnCancelButton_ToClearFilledData();

			log.info("============= Finished tcClickOnCancelButton_ToClearFilledData Test===========");
			getScreenShot("tcClickOnCancelButton_ToClearFilledData");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_ToClearFilledData");
		}
	}

	@Test(priority = 13, dataProvider = "FeePreviledgeTestData")
	public void tcSelectAcademicYear_GroupAndRole_AfterCancel(String AcademicYear, String userGroup, String role,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYear_GroupAndRole_AfterCancel Test===========");

			groupLoginPreviledge.selectAcademicYear_GroupAndRole(AcademicYear, userGroup, role);

			log.info("============= Finished tcSelectAcademicYear_GroupAndRole_AfterCancel Test===========");
			getScreenShot("tcSelectAcademicYear_GroupAndRole_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYear_GroupAndRole_AfterCancel");
		}
	}

	@Test(priority = 14)
	public void tcClickOnSaveButton() {

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			groupLoginPreviledge.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 15)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");

			groupLoginPreviledge.popWindowMessage_SubmitSuccessfully();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation");
		}
	}

	@Test(priority = 16)
	public void tcClickOnSuccessOkBtn() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			groupLoginPreviledge.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	@Test(priority = 17, dataProvider = "Search_FeePreviledgeTestData")
	public void tcSearchLoginPrevilegeByUserName(String userName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchLoginPrevilegeByUserName Test===========");

			groupLoginPreviledge.searchLoginPrevilegeByUserName(userName);

			log.info("============= Finished tcSearchLoginPrevilegeByUserName Test===========");
			getScreenShot("tcSearchLoginPrevilegeByUserName");
		} catch (Exception e) {
			getScreenShot("tcSearchLoginPrevilegeByUserName");
		}
	}

	@Test(priority = 18, dataProvider = "Search_FeePreviledgeTestData")
	public void tcVerifyUserNameUpdatedInGrid(String userName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyUserNameUpdatedInGrid Test===========");

			groupLoginPreviledge.verifyUserNameUpdatedInGrid(userName);

			log.info("============= Finished tcVerifyUserNameUpdatedInGrid Test===========");
			getScreenShot("tcVerifyUserNameUpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyUserNameUpdatedInGrid");
		}
	}

	@Test(priority = 19, dataProvider = "Search_FeePreviledgeTestData")
	public void tcEditLoginPreviele_FeeUserGrLoginPrevilege(String userName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditLoginPreviele_FeeUserGrLoginPrevilege Test===========");

			groupLoginPreviledge.editLoginPreviele_FeeUserGrLoginPrevilege(userName);

			log.info("============= Finished tcEditLoginPreviele_FeeUserGrLoginPrevilege Test===========");
			getScreenShot("tcEditLoginPreviele_FeeUserGrLoginPrevilege");
		} catch (Exception e) {
			getScreenShot("tcEditLoginPreviele_FeeUserGrLoginPrevilege");
		}
	}

	@Test(priority = 20)
	public void tcClickOnSaveButton_Edit() {

		try {
			log.info("============= Strting tcClickOnSaveButton_Edit Test===========");

			groupLoginPreviledge.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_Edit Test===========");
			getScreenShot("tcClickOnSaveButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_Edit");
		}
	}

	@Test(priority = 21)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");

			groupLoginPreviledge.popWindowMessage_SubmitSuccessfully_Edit();

			log.info("============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Edit_Validation");
		}
	}

	@Test(priority = 22)
	public void tcClickOnSuccessOkBtn_Edit() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Edit Test===========");

			groupLoginPreviledge.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Edit Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Edit");
		}
	}

	@Test(priority = 23, dataProvider = "Search_FeePreviledgeTestData")
	public void tcSearchLoginPrevilegeByUserName_ForDelete(String userName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchLoginPrevilegeByUserName_ForDelete Test===========");

			groupLoginPreviledge.searchLoginPrevilegeByUserName(userName);

			log.info("============= Finished tcSearchLoginPrevilegeByUserName_ForDelete Test===========");
			getScreenShot("tcSearchLoginPrevilegeByUserName_ForDelete");
		} catch (Exception e) {
			getScreenShot("tcSearchLoginPrevilegeByUserName_ForDelete");
		}
	}

	@Test(priority = 24, dataProvider = "Search_FeePreviledgeTestData")
	public void tcDeletiontionOfCreatedFeeUserGroupLoginPrevilege(String userName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeletiontionOfCreatedFeeUserGroupLoginPrevilege Test===========");

			groupLoginPreviledge.deletiontionOfCreatedFeeUserGroupLoginPrevilege(userName);

			log.info("============= Finished tcDeletiontionOfCreatedFeeUserGroupLoginPrevilege Test===========");
			getScreenShot("tcDeletiontionOfCreatedFeeUserGroupLoginPrevilege");
		} catch (Exception e) {
			getScreenShot("tcDeletiontionOfCreatedFeeUserGroupLoginPrevilege");
		}
	}

	@Test(priority = 25)
	public void tcClickOnCancelButton_PopUp_Delete() {

		try {
			log.info("============= Strting tcClickOnCancelButton_PopUp_Delete Test===========");

			groupLoginPreviledge.clickOnCancelButton_PopUp();

			log.info("============= Finished tcClickOnCancelButton_PopUp_Delete Test===========");
			getScreenShot("tcClickOnCancelButton_PopUp_Delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnCancelButton_PopUp_Delete");
		}
	}

	@Test(priority = 26)
	public void tcPopUpWindowMessage_DeleteCancel_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeleteCancel_Validation Test===========");

			groupLoginPreviledge.popUpWindowMessage_DeleteCancel_Validation();

			log.info("============= Finished tcPopUpWindowMessage_DeleteCancel_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeleteCancel_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeleteCancel_Validation");
		}
	}

	@Test(priority = 27)
	public void tcClickOnSuccessOkBtn_DeleteCancel() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_DeleteCancel Test===========");

			groupLoginPreviledge.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_DeleteCancel Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_DeleteCancel");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_DeleteCancel");
		}
	}
	@Test(priority = 28, dataProvider = "Search_FeePreviledgeTestData")
	public void tcSearchLoginPrevilegeByUserName_AfterDeleteCancel(String userName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchLoginPrevilegeByUserName_ForDelete Test===========");

			groupLoginPreviledge.searchLoginPrevilegeByUserName(userName);

			log.info("============= Finished tcSearchLoginPrevilegeByUserName_ForDelete Test===========");
			getScreenShot("tcSearchLoginPrevilegeByUserName_ForDelete");
		} catch (Exception e) {
			getScreenShot("tcSearchLoginPrevilegeByUserName_ForDelete");
		}
	}
	@Test(priority = 29, dataProvider = "Search_FeePreviledgeTestData")
	public void tcDeletiontionOfCreatedFeeUserGroupLoginPrevilege_AfterCancel(String userName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcDeletiontionOfCreatedFeeUserGroupLoginPrevilege_AfterCancel Test===========");

			groupLoginPreviledge.deletiontionOfCreatedFeeUserGroupLoginPrevilege(userName);

			log.info(
					"============= Finished tcDeletiontionOfCreatedFeeUserGroupLoginPrevilege_AfterCancel Test===========");
			getScreenShot("tcDeletiontionOfCreatedFeeUserGroupLoginPrevilege_AfterCancel");
		} catch (Exception e) {
			getScreenShot("tcDeletiontionOfCreatedFeeUserGroupLoginPrevilege_AfterCancel");
		}
	}

	@Test(priority = 30)
	public void tcYesDeleteOrDeactivateOrActivateIt_PopUp_Delete() {

		try {
			log.info("============= Strting tcYesDeleteOrDeactivateOrActivateIt_PopUp_Delete Test===========");

			groupLoginPreviledge.yesDeleteOrDeactivateOrActivateIt();

			log.info("============= Finished tcYesDeleteOrDeactivateOrActivateIt_PopUp_Delete Test===========");
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_PopUp_Delete");
		} catch (Exception e) {
			getScreenShot("tcYesDeleteOrDeactivateOrActivateIt_PopUp_Delete");
		}
	}

	@Test(priority = 31)
	public void tcPopUpWindowMessage_DeleteSucessfully_Validation() {

		try {
			log.info("============= Strting tcPopUpWindowMessage_DeleteSucessfully_Validation Test===========");

			groupLoginPreviledge.popUpWindowMessage_DeleteSucessfully_Validation();

			log.info("============= Finished tcPopUpWindowMessage_DeleteSucessfully_Validation Test===========");
			getScreenShot("tcPopUpWindowMessage_DeleteSucessfully_Validation");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_DeleteSucessfully_Validation");
		}
	}

	@Test(priority = 32)
	public void tcClickOnSuccessOkBtn_Delete() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_Delete Test===========");

			groupLoginPreviledge.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn_Delete Test===========");
			getScreenShot("tcClickOnSuccessOkBtn_Delete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_Delete");
		}
	}

	@Test(priority = 33, dataProvider = "FeePreviledgeTestData")
	public void tcSelectAcademicYear_GroupAndRole_AfterDelete(String AcademicYear, String userGroup, String role,
			String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYear_GroupAndRole_AfterDelete Test===========");

			groupLoginPreviledge.selectAcademicYear_GroupAndRole(AcademicYear, userGroup, role);
			;

			log.info("============= Finished tcSelectAcademicYear_GroupAndRole_AfterDelete Test===========");
			getScreenShot("tcSelectAcademicYear_GroupAndRole_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYear_GroupAndRole_AfterDelete");
		}
	}

	@Test(priority = 34)
	public void tcClickOnSaveButton_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnSaveButton_AfterDelete Test===========");

			groupLoginPreviledge.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_AfterDelete Test===========");
			getScreenShot("tcClickOnSaveButton_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_AfterDelete");
		}
	}

	@Test(priority = 35)
	public void tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete() {

		try {
			log.info(
					"============= Strting tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete Test===========");

			groupLoginPreviledge.popWindowMessage_SubmitSuccessfully();

			log.info(
					"============= Finished tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete Test===========");
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete");
		} catch (Exception e) {
			getScreenShot("tcPopUpWindowMessage_SubmitSuccessfully_Validation_AfterDelete");
		}
	}

	@Test(priority = 36)
	public void tcClickOnSuccessOkBtn_AfterDelete() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_AfterDelete Test===========");

			groupLoginPreviledge.clickOnSuccessOkBtn();

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
