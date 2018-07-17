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

import com.vapsTechnosoft.IVRM.Fee.Masters.Masters_Fee_Yearly_Class_Category;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Masters_Fee_Yearly_Class_Category extends TestBase {

	public static final Logger log = Logger.getLogger(Tc_Masters_Fee_Yearly_Class_Category.class.getName());

	Masters_Fee_Yearly_Class_Category yearlyClassgroup;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "YrlyClassCtgTestData")
	public String[][] getTestDataYCC() {
		String[][] testRecordsFeeYCC = getData("FeeModueData.xlsx", "YearlyClassCategoryData");
		return testRecordsFeeYCC;
	}

	@DataProvider(name = "FeeClasscategorySearchTestData")
	public String[][] getTestDataClassCategorySearch() {
		String[][] testRecordsCctg = getData("FeeModueData.xlsx", "SearchByCCategoryName");
		return testRecordsCctg;
	}

	@BeforeClass
	public void setUp() throws IOException {
		init();
		yearlyClassgroup = new Masters_Fee_Yearly_Class_Category(driver);
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

			boolean status = yearlyClassgroup.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNevigateToMasters_Fee_Yearly_ClassCategory() {

		try {
			log.info("============= Strting tcNevigateToMasters_Fee_Yearly_ClassCategory Test===========");

			yearlyClassgroup.nevigateToMasters_Fee_Yearly_ClassCategory();

			log.info("============= Finished tcNevigateToMasters_Fee_Yearly_ClassCategory Test===========");
			getScreenShot("tcNevigateToMasters_Fee_Yearly_ClassCategory");
		} catch (Exception e) {
			getScreenShot("tcNevigateToMasters_Fee_Yearly_ClassCategory");
		}
	}

	@Test(priority = 4)
	public void tcVerifyFeeClassCategoryPage() {
		try {
			log.info("============= Strting tcVerifyFeeClassCategoryPage Test===========");

			boolean status = yearlyClassgroup.verifyFeeClassCategoryPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyFeeClassCategoryPage Test===========");
			getScreenShot("tcVerifyFeeClassCategoryPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyFeeClassCategoryPage");
		}
	}

	@Test(priority = 5)
	public void tcClickOnYearly_ClassCategoryTab() {

		try {
			log.info("============= Strting tcClickOnYearly_ClassCategoryTab Test===========");

			yearlyClassgroup.clickOnYearly_ClassCategoryTab();

			log.info("============= Finished tcClickOnYearly_ClassCategoryTab Test===========");
			getScreenShot("tcClickOnYearly_ClassCategoryTab");
		} catch (Exception e) {
			getScreenShot("tcClickOnYearly_ClassCategoryTab");
		}
	}

	@Test(priority = 6, dataProvider = "YrlyClassCtgTestData")
	public void tcSelectAcademicYearClassCategoryAndClass(String academicYr, String classCategory, String className,
			String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSelectAcademicYearClassCategoryAndClass Test===========");

			yearlyClassgroup.selectAcademicYearClassCategoryAndClass(academicYr, classCategory, className);

			log.info("============= Finished tcSelectAcademicYearClassCategoryAndClass Test===========");
			getScreenShot("tcSelectAcademicYearClassCategoryAndClass");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearClassCategoryAndClass");
		}
	}

	@Test(priority = 7)
	public void tcClickOnSaveButton() {
		try {
			log.info("============= Strting tcClickOnSaveButton Test===========");

			yearlyClassgroup.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton Test===========");
			getScreenShot("tcClickOnSaveButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton");
		}
	}

	@Test(priority = 8)
	public void tcVerifySuccessfulPopUp() {

		try {
			log.info("============= Strting tcVerifySuccessfulPopUp Test===========");

			boolean status = yearlyClassgroup.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifySuccessfulPopUp Test===========");
			getScreenShot("tcVerifySuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp");
		}
	}

	@Test(priority = 9)
	public void tcClickOnSuccessOkBtn() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn Test===========");

			yearlyClassgroup.clickOnSuccessOkBtn();

			log.info("============= Finished tcClickOnSuccessOkBtn Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn");
		}
	}

	/**
	 * Due to issue in application calling again this function (after saving the
	 * data page is switching to class category from yearly class category)
	 * 
	 * @param classCategory
	 * @param runMode
	 */
	@Test(priority = 10)
	public void tcClickOnYearly_ClassCategoryTabAgain() {

		try {
			log.info("============= Strting tcClickOnYearly_ClassCategoryTabAgain Test===========");

			yearlyClassgroup.clickOnYearly_ClassCategoryTab();

			log.info("============= Finished tcClickOnYearly_ClassCategoryTabAgain Test===========");
			getScreenShot("tcClickOnYearly_ClassCategoryTabAgain");
		} catch (Exception e) {
			getScreenShot("tcClickOnYearly_ClassCategoryTabAgain");
		}
	}

	@Test(priority = 11, dataProvider = "FeeClasscategorySearchTestData")
	public void tcSearchByClassCategoryInGrid(String classCategory, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByClassCategoryInGrid Test===========");

			yearlyClassgroup.searchByClassCategoryInGrid(classCategory);

			log.info("============= Finished tcSearchByClassCategoryInGrid Test===========");
			getScreenShot("tcSearchByClassCategoryInGrid");
		} catch (Exception e) {
			getScreenShot("tcSearchByClassCategoryInGrid");
		}
	}

	@Test(priority = 12, dataProvider = "FeeClasscategorySearchTestData")
	public void tcVerifyClassCategoryUpdatedInGrid(String classCategory, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyClassCategoryUpdatedInGrid Test===========");

			yearlyClassgroup.verifyClassCategoryUpdatedInGrid(classCategory);

			log.info("============= Finished tcVerifyClassCategoryUpdatedInGrid Test===========");
			getScreenShot("tcVerifyClassCategoryUpdatedInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyClassCategoryUpdatedInGrid");
		}
	}

	@Test(priority = 13, dataProvider = "FeeClasscategorySearchTestData")
	public void tcDelete_Yearly_ClassCategoryFromGrid(String classCategory, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDelete_Yearly_ClassCategoryFromGrid Test===========");

			yearlyClassgroup.delete_Yearly_ClassCategoryFromGrid(classCategory);

			log.info("============= Finished tcDelete_Yearly_ClassCategoryFromGrid Test===========");
			getScreenShot("tcDelete_Yearly_ClassCategoryFromGrid");
		} catch (Exception e) {
			getScreenShot("tcDelete_Yearly_ClassCategoryFromGrid");
		}
	}

	@Test(priority = 14)
	public void tcConfirmationForDeletion() {

		try {
			log.info("============= Strting tcConfirmationForDeletion Test===========");

			yearlyClassgroup.confirmationForDeletion();

			log.info("============= Finished tcConfirmationForDeletion Test===========");
			getScreenShot("tcConfirmationForDeletion");
		} catch (Exception e) {
			getScreenShot("tcConfirmationForDeletion");
		}
	}

	@Test(priority = 15)
	public void tcVerifyDeletionSuccessfulPopUp() {

		try {
			log.info("============= Strting tcVerifyDeletionSuccessfulPopUp Test===========");

			boolean status = yearlyClassgroup.verifyDeletionSuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info("============= Finished tcVerifyDeletionSuccessfulPopUp Test===========");
			getScreenShot("tcVerifyDeletionSuccessfulPopUp");
		} catch (Exception e) {
			getScreenShot("tcVerifyDeletionSuccessfulPopUp");
		}
	}

	@Test(priority = 16)
	public void tcClickOnDeletionFinalOkBtn() {

		try {
			log.info("============= Strting tcClickOnDeletionFinalOkBtn Test===========");

			yearlyClassgroup.clickOnDeletionFinalOkBtn();

			log.info("============= Finished tcClickOnDeletionFinalOkBtn Test===========");
			getScreenShot("tcClickOnDeletionFinalOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnDeletionFinalOkBtn");
		}
	}

	/**
	 * After delete functionality validation again updating the record for next
	 * use YCC- Yearly Class Category
	 * 
	 * @param academicYr
	 * @param classCategory
	 * @param className
	 * @param runMode
	 */
	@Test(priority = 17, dataProvider = "YrlyClassCtgTestData")
	public void tcSelectAcademicYearClassCategoryAndClass_AfterDeletionOfPreviouslyCreatedYCC(String academicYr,
			String classCategory, String className, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info(
					"============= Strting tcSelectAcademicYearClassCategoryAndClass_AfterDeletionOfPreviouslyCreatedYCC Test===========");

			yearlyClassgroup.selectAcademicYearClassCategoryAndClass(academicYr, classCategory, className);

			log.info(
					"============= Finished tcSelectAcademicYearClassCategoryAndClass_AfterDeletionOfPreviouslyCreatedYCC Test===========");
			getScreenShot("tcSelectAcademicYearClassCategoryAndClass_AfterDeletionOfPreviouslyCreatedYCC");
		} catch (Exception e) {
			getScreenShot("tcSelectAcademicYearClassCategoryAndClass_AfterDeletionOfPreviouslyCreatedYCC");
		}
	}

	@Test(priority = 18)
	public void tcClickOnSaveButton_AfterDeletionOfPreviouslyCreatedYCC() {

		try {
			log.info("============= Strting tcClickOnSaveButton_AfterDeletionOfPreviouslyCreatedYCC Test===========");

			yearlyClassgroup.clickOnSaveButton();

			log.info("============= Finished tcClickOnSaveButton_AfterDeletionOfPreviouslyCreatedYCC Test===========");
			getScreenShot("tcClickOnSaveButton_AfterDeletionOfPreviouslyCreatedYCC");
		} catch (Exception e) {
			getScreenShot("tcClickOnSaveButton_AfterDeletionOfPreviouslyCreatedYCC");
		}
	}

	@Test(priority = 19)
	public void tcVerifySuccessfulPopUp_AfterDeletionOfPreviouslyCreatedYCC() {

		try {
			log.info(
					"============= Strting tcVerifySuccessfulPopUp_AfterDeletionOfPreviouslyCreatedYCC Test===========");

			boolean status = yearlyClassgroup.verifySuccessfulPopUp();
			Assert.assertEquals(status, true);

			log.info(
					"============= Finished tcVerifySuccessfulPopUp_AfterDeletionOfPreviouslyCreatedYCC Test===========");
			getScreenShot("tcVerifySuccessfulPopUp_AfterDeletionOfPreviouslyCreatedYCC");
		} catch (Exception e) {
			getScreenShot("tcVerifySuccessfulPopUp_AfterDeletionOfPreviouslyCreatedYCC");
		}
	}

	@Test(priority = 20)
	public void tcClickOnSuccessOkBtn_AfterDeletionOfPreviouslyCreatedYCC() {

		try {
			log.info("============= Strting tcClickOnSuccessOkBtn_AfterDeletionOfPreviouslyCreatedYCC Test===========");

			yearlyClassgroup.clickOnSuccessOkBtn();

			log.info(
					"============= Finished tcClickOnSuccessOkBtn_AfterDeletionOfPreviouslyCreatedYCC Test===========");
			getScreenShot("tcClickOnSuccessOkBtn");
		} catch (Exception e) {
			getScreenShot("tcClickOnSuccessOkBtn_AfterDeletionOfPreviouslyCreatedYCC");
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
