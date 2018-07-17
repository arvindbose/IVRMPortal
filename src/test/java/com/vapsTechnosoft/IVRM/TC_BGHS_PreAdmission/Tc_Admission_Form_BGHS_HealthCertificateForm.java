/**
 * 
 */
package com.vapsTechnosoft.IVRM.TC_BGHS_PreAdmission;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.BGHS_PreAdmission.Admission_Form_BGHS_HealthCertificateForm;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class Tc_Admission_Form_BGHS_HealthCertificateForm extends TestBase{

	public static final Logger log = Logger.getLogger(Tc_Admission_Form_BGHS_HealthCertificateForm.class.getName());

	Admission_Form_BGHS_HealthCertificateForm bghsHealthCertificateForm;
	IvrmPortalLogin ivrmportallogin;

	@DataProvider(name = "vapsloginData")
	public String[][] getTestDataLogin() {
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}

	@DataProvider(name = "BGHSHealthCertificateFormData")
	public String[][] getTestData() {
		String[][] testRecordsStuDetails = getData("BGHS_PreAdmissionData.xlsx", "BGHS_HealthCertificateData");
		return testRecordsStuDetails;
	}

	@DataProvider(name = "SearchByStudentNameData")
	public String[][] getTestSearchData() {
		String[][] testRecordsStuName = getData("BGHS_PreAdmissionData.xlsx", "BGHS_SearchInGridData");
		return testRecordsStuName;
	}

	
	@DataProvider(name = "SearchByStudentNameExistingData")
	public String[][] getTestDataSearch() {
		String[][] testRecordsSearch= getData("BGHS_PreAdmissionData.xlsx", "BGHS_searchExistingStuNameData");
		return testRecordsSearch;
	}
	
	
	
	
	@BeforeClass
	public void setUp() throws IOException {
		init();
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		ivrmportallogin = new IvrmPortalLogin(driver);
	}

	// login test
	@Test(priority = 1, dataProvider = "vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
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
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcHomeButtonValidation Test===========");

			boolean status = bghsHealthCertificateForm.verifyHomeButton();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcHomeButtonValidation Test===========");
			getScreenShot("tcHomeButtonValidation");
		} catch (Exception e) {
			getScreenShot("tcHomeButtonValidation");
		}
	}

	@Test(priority = 3)
	public void tcNavigateToAdmission_ApplicationForm_BGHS() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcNavigateToAdmission_ApplicationForm_BGHS Test===========");

			bghsHealthCertificateForm.navigateToAdmission_ApplicationForm_BGHS();

			log.info("============= Finished tcNavigateToAdmission_ApplicationForm_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_ApplicationForm_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_ApplicationForm_BGHS");
		}
	}
	@Test(priority = 4)
	public void tcSwitchedToHealthCertificateForm() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcSwitchedToHealthCertificateForm Test===========");

			bghsHealthCertificateForm.switchedToHealthCertificateForm();

			log.info("============= Finished tcSwitchedToHealthCertificateForm Test===========");
			getScreenShot("tcSwitchedToHealthCertificateForm");
		} catch (Exception e) {
			getScreenShot("tcSwitchedToHealthCertificateForm");
		}
	}
	
	

	@Test(priority = 5)
	public void tcVerifyAdmission_ApplicationForm_BGHSPage() {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcVerifyAdmission_ApplicationForm_BGHSPage Test===========");

			boolean status = bghsHealthCertificateForm.verifyAdmission_ApplicationForm_BGHSPage();
			Assert.assertEquals(status, true);
			log.info("============= Finished tcVerifyAdmission_ApplicationForm_BGHSPage Test===========");
			getScreenShot("tcVerifyAdmission_ApplicationForm_BGHSPage");
		} catch (Exception e) {
			getScreenShot("tcVerifyAdmission_ApplicationForm_BGHSPage");
		}
	}

	@Test(priority = 6, dataProvider = "BGHSHealthCertificateFormData")
	public void tcHealthCertificateInformationForBGHS(String StudentName, String vaccinationDate, String hepatitisBDate,
			String typhoidFeverDate, String AilmentsName, String HealthProblem, String bloodGroup,String runMode) {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEnterStudentInformationFor_BGHSPreAdmApplicationForm Test===========");

			bghsHealthCertificateForm.healthCertificateInformationForBGHS(StudentName, vaccinationDate, hepatitisBDate, typhoidFeverDate, AilmentsName, HealthProblem, bloodGroup);
			log.info("============= Finished tcEnterStudentInformationFor_BGHSPreAdmApplicationForm Test===========");
			getScreenShot("tcEnterStudentInformationFor_BGHSPreAdmApplicationForm");
		} catch (Exception e) {
			getScreenShot("tcEnterStudentInformationFor_BGHSPreAdmApplicationForm");
		}
	}
	
	@Test(priority = 7)
	public void tcClearFilledHealthCertificateForm() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcClearFilledHealthCertificateForm Test===========");

			bghsHealthCertificateForm.clearFilledHealthCertificateForm();

			log.info("============= Finished tcClearFilledHealthCertificateForm Test===========");
			getScreenShot("tcClearFilledHealthCertificateForm");
		} catch (Exception e) {
			getScreenShot("tcClearFilledHealthCertificateForm");
		}
	}
	
	@Test(priority = 8)
	public void tcMinimizeHealthCertificate() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcMinimizeHealthCertificate Test===========");

			bghsHealthCertificateForm.minimizeHealthCertificate();

			log.info("============= Finished tcMinimizeHealthCertificate Test===========");
			getScreenShot("tcMinimizeHealthCertificate");
		} catch (Exception e) {
			getScreenShot("tcMinimizeHealthCertificate");
		}
	}
	
	@Test(priority = 9)
	public void tcMaximizeHealthCertificate() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcMaximizeHealthCertificate Test===========");

			bghsHealthCertificateForm.maximizeHealthCertificate();

			log.info("============= Finished tcMaximizeHealthCertificate Test===========");
			getScreenShot("tcMaximizeHealthCertificate");
		} catch (Exception e) {
			getScreenShot("tcMaximizeHealthCertificate");
		}
	}
	
	
	@Test(priority = 10, dataProvider = "BGHSHealthCertificateFormData")
	public void tcHealthCertificateInformationForBGHS_AfterClear(String StudentName, String vaccinationDate, String hepatitisBDate,
			String typhoidFeverDate, String AilmentsName, String HealthProblem, String bloodGroup,String runMode) {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcHealthCertificateInformationForBGHS_AfterClear Test===========");

			bghsHealthCertificateForm.healthCertificateInformationForBGHS(StudentName, vaccinationDate, hepatitisBDate, typhoidFeverDate, AilmentsName, HealthProblem, bloodGroup);
			log.info("============= Finished tcHealthCertificateInformationForBGHS_AfterClear Test===========");
			getScreenShot("tcHealthCertificateInformationForBGHS_AfterClear");
		} catch (Exception e) {
			getScreenShot("tcHealthCertificateInformationForBGHS_AfterClear");
		}
	}
	@Test(priority = 11)
	public void tcSubmitHealthCertificateForm() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcSubmitHealthCertificateForm Test===========");

			bghsHealthCertificateForm.submitHealthCertificateForm();

			log.info("============= Finished tcSubmitHealthCertificateForm Test===========");
			getScreenShot("tcSubmitHealthCertificateForm");
		} catch (Exception e) {
			getScreenShot("tcSubmitHealthCertificateForm");
		}
	}
	
	@Test(priority = 12)
	public void tcClickOnOkSuccessButton() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcClickOnOkSuccessButton Test===========");

			bghsHealthCertificateForm.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton Test===========");
			getScreenShot("tcClickOnOkSuccessButton");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton");
		}
	}
	
	@Test(priority = 13, dataProvider = "SearchByStudentNameData")
	public void tcSearchWithStudentName(String studentName, String runMode) {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithStudentName Test===========");

			bghsHealthCertificateForm.searchWithStudentName(studentName);
			log.info("============= Finished tcSearchWithStudentName Test===========");
			getScreenShot("tcSearchWithStudentName");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStudentName");

		}
	}
	
	@Test(priority = 14, dataProvider = "SearchByStudentNameData")
	public void tcVerifyStudentNameInGrid(String studentName, String runMode) {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentNameInGrid Test===========");

			bghsHealthCertificateForm.verifyStudentNameInGrid(studentName);
			log.info("============= Finished tcVerifyStudentNameInGrid Test===========");
			getScreenShot("tcVerifyStudentNameInGrid");
		} catch (Exception e) {
			getScreenShot("tcVerifyStudentNameInGrid");

		}
	}
	@Test(priority = 15, dataProvider = "SearchByStudentNameData")
	public void tcEditSubmittedHealthCertificate(String studentName,String runMode) {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcEditSubmittedHealthCertificate Test===========");

			bghsHealthCertificateForm.editSubmittedHealthCertificate(studentName);
			log.info("============= Finished tcEditSubmittedHealthCertificate Test===========");
			getScreenShot("tcEditSubmittedHealthCertificate");
		} catch (Exception e) {
			getScreenShot("tcEditSubmittedHealthCertificate");

		}
	}
	
	@Test(priority = 16)
	public void tcEdit_SubmitHealthCertificateForm_() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcEdit_SubmitHealthCertificateForm_Edit Test===========");

			bghsHealthCertificateForm.submitHealthCertificateForm();

			log.info("============= Finished tcEdit_SubmitHealthCertificateForm_Edit Test===========");
			getScreenShot("tcEdit_SubmitHealthCertificateForm_Edit");
		} catch (Exception e) {
			getScreenShot("tcEdit_SubmitHealthCertificateForm_Edit");
		}
	}
	
	@Test(priority = 17)
	public void tcClickOnOkSuccessButton_Edit() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcClickOnOkSuccessButton_Edit Test===========");

			bghsHealthCertificateForm.clickOnOkSuccessButton();

			log.info("============= Finished tcClickOnOkSuccessButton_Edit Test===========");
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		} catch (Exception e) {
			getScreenShot("tcClickOnOkSuccessButton_Edit");
		}
	}
	
	/*@Test(priority = 18, dataProvider = "SearchByStudentNameData")
	public void tcPayRegistrationFeeBGHS(String studentName, String runMode) {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcPayRegistrationFeeBGHS Test===========");

			bghsHealthCertificateForm.payRegistrationFeeBGHS(studentName);
			log.info("============= Finished tcPayRegistrationFeeBGHS Test===========");
			getScreenShot("tcPayRegistrationFeeBGHS");
		} catch (Exception e) {
			getScreenShot("tcPayRegistrationFeeBGHS");

		}
	}
	

	@Test(priority = 19)
	public void tcReturnBacktoApplicationPageFromPaymentPage() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcReturnBacktoApplicationPageFromPaymentPage Test===========");

			bghsHealthCertificateForm.returnBacktoApplicationPageFromPaymentPage();

			log.info("============= Finished tcReturnBacktoApplicationPageFromPaymentPage Test===========");
			getScreenShot("tcReturnBacktoApplicationPageFromPaymentPage");
		} catch (Exception e) {
			getScreenShot("tcReturnBacktoApplicationPageFromPaymentPage");
		}
	}
	
	@Test(priority = 20)
	public void tcNavigateToAdmission_ApplicationForm_BGHSAfterPayments() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcNavigateToAdmission_ApplicationForm_BGHS Test===========");

			bghsHealthCertificateForm.navigateToAdmission_ApplicationForm_BGHS();

			log.info("============= Finished tcNavigateToAdmission_ApplicationForm_BGHS Test===========");
			getScreenShot("tcNavigateToAdmission_ApplicationForm_BGHS");
		} catch (Exception e) {
			getScreenShot("tcNavigateToAdmission_ApplicationForm_BGHS");
		}
	}*/
	
	@Test(priority = 21, dataProvider = "SearchByStudentNameExistingData")
	public void tcSearchWithStudentNameForViewDownload(String studentname, String runMode) {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchWithStudentNameForViewDownload Test===========");

			bghsHealthCertificateForm.searchWithStudentName(studentname);
			log.info("============= Finished tcSearchWithStudentNameForViewDownload Test===========");
			getScreenShot("tcSearchWithStudentNameForViewDownload");
		} catch (Exception e) {
			getScreenShot("tcSearchWithStudentNameForViewDownload");

		}
	}
	
	@Test(priority = 22, dataProvider = "SearchByStudentNameExistingData")
	public void tcdownloadProspectus_BGHS(String studentname, String runMode) {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcdownloadProspectus_BGHS Test===========");

			bghsHealthCertificateForm.downloadProspectus(studentname);
			log.info("============= Finished tcdownloadProspectus_BGHS Test===========");
			getScreenShot("tcdownloadProspectus_BGHS");
		} catch (Exception e) {
			getScreenShot("tcdownloadProspectus_BGHS");

		}
	}
	
	@Test(priority = 23)
	public void tcSwitchWindowsForProspectusDownload() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcSwitchWindowsForProspectusDownload Test===========");

			bghsHealthCertificateForm.switchWindowsForProspectusDownload();

			log.info("============= Finished tcSwitchWindowsForProspectusDownload Test===========");
			getScreenShot("tcSwitchWindowsForProspectusDownload");
		} catch (Exception e) {
			getScreenShot("tcSwitchWindowsForProspectusDownload");
		}
	}

	
	@Test(priority = 24, dataProvider = "SearchByStudentNameExistingData")
	public void tcViewAdmissionForm_BGHS(String studentname, String runMode) {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcViewAdmissionForm_BGHS Test===========");

			bghsHealthCertificateForm.viewAdmissionForm_BGHS(studentname);
			log.info("============= Finished tcViewAdmissionForm_BGHS Test===========");
			getScreenShot("tcViewAdmissionForm_BGHS");
		} catch (Exception e) {
			getScreenShot("tcViewAdmissionForm_BGHS");

		}
	}
	@Test(priority = 25)
	public void tcCloseOpenAdmissionForm() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcCloseOpenAdmissionForm Test===========");

			bghsHealthCertificateForm.closeOpenAdmissionForm();

			log.info("============= Finished tcCloseOpenAdmissionForm Test===========");
			getScreenShot("tcCloseOpenAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenAdmissionForm");
		}
	}
	
	/*@Test(priority = 26, dataProvider = "SearchByStudentNameExistingData")
	public void tcViewAdmissionForm_BGHSPrint(String studentname, String runMode) {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcViewAdmissionForm_BGHSPrint Test===========");

			bghsHealthCertificateForm.viewAdmissionForm_BGHS(studentname);
			log.info("============= Finished tcViewAdmissionForm_BGHSPrint Test===========");
			getScreenShot("tcViewAdmissionForm_BGHSPrint");
		} catch (Exception e) {
			getScreenShot("tcViewAdmissionForm_BGHSPrint");

		}
	}
	@Test(priority = 27)
	public void tcPrintOpenAdmissionForm() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcPrintOpenAdmissionForm Test===========");

			bghsHealthCertificateForm.printOpenAdmissionForm();

			log.info("============= Finished tcPrintOpenAdmissionForm Test===========");
			getScreenShot("tcPrintOpenAdmissionForm");
		} catch (Exception e) {
			getScreenShot("tcPrintOpenAdmissionForm");
		}
	}
	
	@Test(priority = 28)
	public void tcSwitchToWindowUsingTab() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcSwitchToWindowUsingTab Test===========");

			bghsHealthCertificateForm.switchToWindowUsingTab();

			log.info("============= Finished tcSwitchToWindowUsingTab Test===========");
			getScreenShot("tcSwitchToWindowUsingTab");
		} catch (Exception e) {
			getScreenShot("tcSwitchToWindowUsingTab");
		}
	}
*/
	
	@Test(priority = 29, dataProvider = "SearchByStudentNameExistingData")
	public void tcViewHealthCertificateForm_BGHS(String studentname, String runMode) {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcViewHealthCertificateForm_BGHS Test===========");

			bghsHealthCertificateForm.viewHealthCertificateForm_BGHS(studentname);
			log.info("============= Finished tcViewHealthCertificateForm_BGHS Test===========");
			getScreenShot("tcViewHealthCertificateForm_BGHS");
		} catch (Exception e) {
			getScreenShot("tcViewHealthCertificateForm_BGHS");

		}
	}
	@Test(priority = 30)
	public void tcCloseOpenHealthCertficateForm() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcCloseOpenHealthCertficateForm Test===========");

			bghsHealthCertificateForm.closeOpenHealthCertficateForm();

			log.info("============= Finished tcCloseOpenHealthCertficateForm Test===========");
			getScreenShot("tcCloseOpenHealthCertficateForm");
		} catch (Exception e) {
			getScreenShot("tcCloseOpenHealthCertficateForm");
		}
	}
	
	@Test(priority = 31, dataProvider = "SearchByStudentNameExistingData")
	public void tcViewHealthCertificateForm_BGHSPrint(String studentname, String runMode) {

		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcViewHealthCertificateForm_BGHSPrint Test===========");

			bghsHealthCertificateForm.viewHealthCertificateForm_BGHS(studentname);
			log.info("============= Finished tcViewHealthCertificateForm_BGHSPrint Test===========");
			getScreenShot("tcViewHealthCertificateForm_BGHSPrint");
		} catch (Exception e) {
			getScreenShot("tcViewHealthCertificateForm_BGHSPrint");

		}
	}
	@Test(priority = 32)
	public void tcPrintOpenHealthCertficateForm() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcPrintOpenHealthCertficateForm Test===========");

			bghsHealthCertificateForm.printOpenHealthCertficateForm();

			log.info("============= Finished tcPrintOpenHealthCertficateForm Test===========");
			getScreenShot("tcPrintOpenHealthCertficateForm");
		} catch (Exception e) {
			getScreenShot("tcPrintOpenHealthCertficateForm");
		}
	}
	
	@Test(priority = 33)
	public void tcSwitchToWindowUsingTabHealthCertificate() {
		bghsHealthCertificateForm = new Admission_Form_BGHS_HealthCertificateForm(driver);

		try {
			log.info("============= Strting tcSwitchToWindowUsingTabHealthCertificate Test===========");

			bghsHealthCertificateForm.switchToWindowUsingTab();

			log.info("============= Finished tcSwitchToWindowUsingTabHealthCertificate Test===========");
			getScreenShot("tcSwitchToWindowUsingTabHealthCertificate");
		} catch (Exception e) {
			getScreenShot("tcSwitchToWindowUsingTabHealthCertificate");
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
