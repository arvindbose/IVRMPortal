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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Fee_Class_Category;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_Class_Category extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Class_Category.class.getName());

	Masters_Fee_Class_Category feeclasscategory;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "FeeClassCategoryData")
	public String[][] getTestDataFeeCategory() {
		String[][] testRecordsFeeCC = getData("FeeModueData.xlsx", "FeeCategoryNameCodeData");
		return testRecordsFeeCC;
	}

	@DataProvider(name = "CCSearchTestData")
	public String[][] getTestDataFeeTermNew() {
		String[][] testRecordsFeeCCS = getData("FeeModueData.xlsx", "SearchByCCategoryName");
		return testRecordsFeeCCS;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		feeclasscategory = new Masters_Fee_Class_Category(driver);
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

			feeclasscategory.verifyHomeButton();

			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateToMasters_Fee_ClassCategory() {

		try {
			log.info("============= Strting tcNevigateToMasters_Fee_ClassCategory Test===========");

			feeclasscategory.nevigateToMasters_Fee_ClassCategory();

			log.info("============= Finished tcNevigateToMasters_Fee_ClassCategory Test===========");
			getScreenShot("tcNevigateToMasters_Fee_ClassCategory");
		} catch (Exception e) {
			getScreenShot("tcNevigateToMasters_Fee_ClassCategory");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeClassCategoryPage() {

		try {
			log.info("============= Strting tcVerifyFeeClassCategoryPage Test===========");

			boolean status = feeclasscategory.verifyFeeClassCategoryPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeClassCategoryPage Test===========");
			getScreenShot("tcVerifyFeeClassCategoryPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeClassCategoryPage");
		}
	}

	@Test(priority = 5, dataProvider = "FeeClassCategoryData")
	public void tcEnterClassCategoryNameAndCode(String classCategoryName, String classCategoryCode, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterClassCategoryNameAndCode Test===========");

			feeclasscategory.enterClassCategoryNameAndCode(classCategoryName, classCategoryCode);

			log.info("============= Finished tcEnterClassCategoryNameAndCode Test===========");
			getScreenShot("tcEnterClassCategoryNameAndCode");
		} catch (Exception e) {
			getScreenShot("tcEnterClassCategoryNameAndCode");
		}
	}

	@Test(priority = 6)
	public void tcClickOnSaveButton() {

		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			feeclasscategory.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 7)
	public void tcVerifySuccessfulPopUp() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status = feeclasscategory.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}

	@Test(priority = 8)
	public void tcClickOnSuccessOkBtn() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			feeclasscategory.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	@Test(priority = 9, dataProvider = "CCSearchTestData")
	public void tcSearchByClassCategoryName(String classCtgName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByClassCategoryName Test===========");

			feeclasscategory.searchByClassCategoryName(classCtgName);

			log.info("============= Finished tcSearchByClassCategoryName Test===========");
			getScreenShot("tcSearchByClassCategoryName");
		} catch (Exception e) {
			getScreenShot("tcSearchByClassCategoryName");
		}
	}

	@Test(priority = 10, dataProvider = "CCSearchTestData")
	public void tcVerifyClassCategoryNameUpdatedInGrid(String classCtgName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyClassCategoryNameUpdatedInGrid Test===========");

			feeclasscategory.verifyClassCategoryNameUpdatedInGrid(classCtgName);

			log.info("============= Finished tcVerifyClassCategoryNameUpdatedInGrid Test===========");
			getScreenShot("tcVerifyClassCategoryNameUpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyClassCategoryNameUpdatedInGrid");
		}
	}

	@Test(priority = 11, dataProvider = "CCSearchTestData")
	public void tcDeactivationOfCreatedClassCategory(String classCtgName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDeactivationOfCreatedClassCategory Test===========");

			feeclasscategory.deactivationOfCreatedClassCategory(classCtgName);

			log.info("============= Finished tcDeactivationOfCreatedClassCategory Test===========");
			getScreenShot("tcDeactivationOfCreatedClassCategory");
		} catch (Exception e) {
			getScreenShot("tcDeactivationOfCreatedClassCategory");
		}
	}

	@Test(priority = 12)
	public void tcConfirmationForDeactivation() {

		try {
			log.info("============= Strting tcConfirmationForDeactivation Test===========");

			feeclasscategory.confirmationForDeactivation();

			log.info("============= Finished tcConfirmationForDeactivation Test===========");
			getScreenShot("tcConfirmationForDeactivation");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForDeactivation");
		}
	}

	@Test(priority = 13)
	public void tcVerifyDeactivationSuccessfulPopUp() {

		try {
			log.info("============= Strting tcVerifyDeactivationSuccessfulPopUp Test===========");

			boolean status = feeclasscategory.verifyDeactivationSuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifyDeactivationSuccessfulPopUp Test===========");
			getScreenShot("tcVerifyDeactivationSuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifyDeactivationSuccessfulPopUp");
		}
	}

	@Test(priority = 14)
	public void tcClickOnDeactivationFinalOkBtn() {

		try {
			log.info("============= Strting tcClickOnDeactivationFinalOkBtn Test===========");

			feeclasscategory.clickOnDeactivationFinalOkBtn();

			log.info("============= Finished tcClickOnDeactivationFinalOkBtn Test===========");
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeactivationFinalOkBtn");
		}
	}

	// search
	@Test(priority = 15, dataProvider = "CCSearchTestData")
	public void tcSearchByClassCategoryNameForActivation(String classCtgName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByClassCategoryNameForActivation Test===========");

			feeclasscategory.searchByClassCategoryName(classCtgName);

			log.info("============= Finished tcSearchByClassCategoryNameForActivation Test===========");
			getScreenShot("tcSearchByClassCategoryNameForActivation");
		} catch (Exception e) {
			getScreenShot("tcSearchByClassCategoryNameForActivation");
		}
	}

	// Activation

	@Test(priority = 16, dataProvider = "CCSearchTestData")
	public void tcActivationOfCreatedClassCategory(String classCtgName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcActivationOfCreatedClassCategory Test===========");

			feeclasscategory.activationOfCreatedClassCategory(classCtgName);

			log.info("============= Finished tcActivationOfCreatedClassCategory Test===========");
			getScreenShot("tcActivationOfCreatedClassCategory");
		} catch (Exception e) {
			getScreenShot("tcActivationOfCreatedClassCategory");
		}
	}

	@Test(priority = 17)
	public void tcConfirmationForActivation() {

		try {
			log.info("============= Strting tcConfirmationForActivation Test===========");

			feeclasscategory.confirmationForActivation();

			log.info("============= Finished tcConfirmationForActivation Test===========");
			getScreenShot("tcConfirmationForActivation");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForActivation");
		}
	}

	@Test(priority = 18)
	public void tcVerifyActivationSuccessfulPopUp() {

		try {
			log.info("============= Strting tcVerifyActivationSuccessfulPopUp Test===========");

			boolean status = feeclasscategory.verifyActivationSuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifyActivationSuccessfulPopUp Test===========");
			getScreenShot("tcVerifyActivationSuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifyActivationSuccessfulPopUp");
		}
	}

	@Test(priority = 19)
	public void tcClickOnActivationFinalOkBtn() {

		try {
			log.info("============= Strting tcClickOnActivationFinalOkBtn Test===========");

			feeclasscategory.clickOnActivationFinalOkBtn();

			log.info("============= Finished tcClickOnActivationFinalOkBtn Test===========");
			getScreenShot("tcClickOnActivationFinalOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnActivationFinalOkBtn");
		}
	}

	// search
	@Test(priority = 20, dataProvider = "CCSearchTestData")
	public void tcSearchByClassCategoryNameForEditing(String classCtgName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByClassCategoryNameForEditing Test===========");

			feeclasscategory.searchByClassCategoryName(classCtgName);

			log.info("============= Finished tcSearchByClassCategoryNameForEditing Test===========");
			getScreenShot("tcSearchByClassCategoryNameForEditing");
		} catch (Exception e) {
			getScreenShot("tcSearchByClassCategoryNameForEditing");
		}
	}

	// Edit

	@Test(priority = 21, dataProvider = "CCSearchTestData")
	public void tcCreatedClassCategoryEdit(String classCtgName, String runMode) {

		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcCreatedClassCategoryEdit Test===========");

			feeclasscategory.editFeeClassCategory(classCtgName);

			log.info("============= Finished tcCreatedClassCategoryEdit Test===========");
			getScreenShot("tcCreatedClassCategoryEdit");
		} catch (Exception e) {
			getScreenShot("tcCreatedClassCategoryEdit");
		}
	}

	@Test(priority = 22)
	public void tcClickOnSaveButtonEdit() {

		try {
			log.info("============= Strting tcClickOnSaveButtonEdit Test===========");

			feeclasscategory.clickOnSaveButtonEdit();

			log.info("============= Finished tcClickOnSaveButtonEdit Test===========");
			getScreenShot("tcClickOnSaveButtonEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButtonEdit");
		}
	}

	@Test(priority = 23)
	public void tcVerifySuccessfulPopUpEdit() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUpEdit Test===========");

			boolean status = feeclasscategory.verifySuccessfulPopUpEdit();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUpEdit Test===========");
			getScreenShot("tcVerifySuccessfulPopUpEdit");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUpEdit");
		}
	}

	@Test(priority = 24)
	public void tcClickOnSuccessOkBtnEdit() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtnEdit Test===========");

			feeclasscategory.clickOnSuccessOkBtnEdit();

			log.info("============= Finished tcClickOnSuccessOkBtnEdit Test===========");
			getScreenShot("tcClickOnSuccessOkBtnEdit");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtnEdit");
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
