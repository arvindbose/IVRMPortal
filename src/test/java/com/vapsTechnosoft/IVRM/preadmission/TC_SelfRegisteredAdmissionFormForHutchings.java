/**
 * 
 */
package com.vapsTechnosoft.IVRM.preadmission;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.preAdmission.FillNewAdmissionFormForHutchings;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_SelfRegisteredAdmissionFormForHutchings extends TestBase{

	public static final Logger log = Logger.getLogger(TC_SelfRegisteredAdmissionFormForHutchings.class.getName());	

	FillNewAdmissionFormForHutchings formForhutching;
	IvrmPortalLogin ivrmportallogin;
	
	@DataProvider(name="vapsloginData")
	public String[][] getTestDataLogin(){
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	
	
	@DataProvider(name="hutchingFormData")
	public String[][] getTestData(){
		String[][] testRecords = getData("TestData.xlsx", "AdmissionFormData");
		return testRecords;
	}
	
	@DataProvider(name="hutchingOthersDetails")
	public String[][] getTestDataOthersDetails(){
		String[][] testRecordsOthers = getData("TestData.xlsx", "HutchingOthersDetails");
		return testRecordsOthers;
	}
	
	@DataProvider(name="hutchingResidentialAddress")
	public String[][] getTestDataResidentialAddress(){
		String[][] testRecordsAddress = getData("TestData.xlsx", "HutchingResidentialAddress");
		return testRecordsAddress;
	}
	
	@DataProvider(name="hutchingFatherDetails")
	public String[][] getTestDataFathersDetails(){
		String[][] testRecordsFather = getData("TestData.xlsx", "FatherDetailsHutchings");
		return testRecordsFather;
	}
	
	@DataProvider(name="hutchingMotherDetails")
	public String[][] getTestDataMothersDetails(){
		String[][] testRecordsmother = getData("TestData.xlsx", "MotherDetailsHutching");
		return testRecordsmother;
	}
	@DataProvider(name="hutchingMonthlyIncome")
	public String[][] getTestDataMonthlyIncome(){
		String[][] testRecordsmonthlyIncome = getData("TestData.xlsx", "MonthlyIncomeHutching");
		return testRecordsmonthlyIncome;
	}
	@DataProvider(name="hutchingSiblingDetailsData")
	public String[][] getTestDataSibling(){
		String[][] testRecordsSibling = getData("TestData.xlsx", "SiblingDetailsData");
		return testRecordsSibling;
	}
	
	
	
	
	@BeforeClass
	public void setUp() throws IOException {
     init();
     formForhutching = new FillNewAdmissionFormForHutchings(driver);
     ivrmportallogin = new IvrmPortalLogin(driver);
	}

	//login test
	@Test(priority=1, dataProvider="vapsloginData")
	public void loginToappWithrequiredCredentials(String username, String password, String runMode) {
		ivrmportallogin = new IvrmPortalLogin(driver);
		if(runMode.equalsIgnoreCase("n")){
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
	
	
	//login test
	
	
	@Test(priority=2,dataProvider="hutchingFormData")
	public void hutchingAdmissionForm(String fName, String mName, String sName, String mNumber,
			String birthPlace, String religion, String caste, String gender,String email, String nationality,
			String language,String selClass, String runMode){
		formForhutching = new FillNewAdmissionFormForHutchings(driver);
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting hutchingAdmissionForm Test===========");
		
		formForhutching.hutchingNewApplicationFormStudentDetails(fName, mName, sName, mNumber, birthPlace, religion, caste, gender,email, nationality, language,selClass);
		log.info("============= Finished hutchingAdmissionForm Test===========");
		getScreenShot("hutchingAdmissionForm");
		}
		catch(Exception e){
			getScreenShot("hutchingAdmissionForm");
		}
		}
	@Test(priority=3,dataProvider="hutchingOthersDetails" )
	public void hutchingOthersDetailsForm(String aadhar, String PlayGroup, String ECA){
			
		try{
			log.info("============= Strting hutchingOtherDetails Test===========");
			
			formForhutching.hutchingOtherDetails(aadhar, PlayGroup, ECA);
			log.info("============= Finished hutchingOtherDetails Test===========");
			getScreenShot("hutchingOtherDetails");
		}
		catch(Exception e){
			getScreenShot("hutchingOtherDetails");
		}
	}
	@Test(priority=3,dataProvider="hutchingResidentialAddress" )
	public void hutchingResidentialAddressForm(String rStreet,String rArea, String rCountry,String rState,String rCity, String rPinZip){
			
		try{
			log.info("============= Strting hutching form residentialAddres Test===========");
			
			formForhutching.residentialAddres(rStreet, rArea, rCountry, rState, rCity, rPinZip);
			log.info("============= Finished hutchingOtherDetails Test===========");
			getScreenShot("hutching form residentialAddres");
		}
		catch(Exception e){
			getScreenShot("hutching form residentialAddres");
		}
	}
	
	@Test(priority=4,dataProvider="hutchingFatherDetails" )
	public void hutchingFathersDetails(String fname, String fsurName, String fQualification, String fserBusiness,
			String fDesignation, String fNationality, String fOfficeAdd, String fmobileNo){
			
		try{
			log.info("============= Strting hutching form hutchingFathersDetails Test===========");
			
			formForhutching.hutchingFathersDetails(fname, fsurName, fQualification, fserBusiness, fDesignation, fNationality, fOfficeAdd, fmobileNo);
			log.info("============= Finished hutchingFathersDetails Test===========");
			getScreenShot("hutching form hutchingFathersDetails");
		}
		catch(Exception e){
			getScreenShot("hutching form hutchingFathersDetails");
		}
	}
	
	@Test(priority=5,dataProvider="hutchingMotherDetails" )
	public void hutchingMothersDetails(String mname, String msurName, String mQualification, String mserBusiness,
			String mDesignation, String mNationality, String mOfficeAdd, String mmobileNo){
			
		try{
			log.info("============= Strting hutching form hutchingMothersDetails Test===========");
			
			formForhutching.hutchingMothersDetails(mname, msurName, mQualification, mserBusiness, mDesignation, mNationality, mOfficeAdd, mmobileNo);
			log.info("============= Finished hutchingMothersDetails Test===========");
			getScreenShot("hutching form hutchingMothersDetails");
		}
		catch(Exception e){
			getScreenShot("hutching form hutchingMothersDetails");
		}
	}
	@Test(priority=6,dataProvider="hutchingMonthlyIncome" )
	public void parentsMonthlyIncomeDetails(String fIncome, String mIncome, String altrContact, String altrEmail){
			
		try{
			log.info("============= Strting hutching form parentsMonthlyIncome Test===========");
			
			formForhutching.parentsMonthlyIncome(fIncome, mIncome, altrContact, altrEmail);
			log.info("============= Finished parentsMonthlyIncome Test===========");
			getScreenShot("hutching form parentsMonthlyIncome");
		}
		catch(Exception e){
			getScreenShot("hutching form parentsMonthlyIncome");
		}
	}
	
	@Test(priority=7,dataProvider="hutchingSiblingDetailsData" )
	public void hutchingSiblingDetails(String sibingName, String siblingClass, String siblingAdmNo){
			
		try{
			log.info("============= Strting hutching form hutchingSiblingDetails Test===========");
			
			formForhutching.siblingDetails(sibingName, siblingClass, siblingAdmNo);
			log.info("============= Finished hutchingSiblingDetails Test===========");
			getScreenShot("hutching form hutchingSiblingDetails");
		}
		catch(Exception e){
			getScreenShot("hutching form hutchingSiblingDetails");
		}
	}
	@Test(priority=8)
	public void uploadRequiredDocumentForAdmissionProcess(){
		
		
		try{
			log.info("============= Strting hutching uploadRequiredDocumentForAdmissionProcess Test===========");
			
			formForhutching.requiredDocumentsUplolad();
			log.info("============= Finished uploadRequiredDocumentForAdmissionProcess Test===========");
			getScreenShot("hutching form uploadRequiredDocumentForAdmissionProcess");
		}
		catch(Exception e){
			getScreenShot("hutching form uploadRequiredDocumentForAdmissionProcess");
		}
	}
	@Test(priority=9)
	public void verifyUndertakingAndConfirm(){
		
		
		try{
			log.info("============= Strting hutching verifyUndertakingAndConfirm Test===========");
			
			boolean status = formForhutching.verifyUndertakingText();
			if(status){
				formForhutching.confirmUndertaking();
			}
			Assert.assertEquals(status, true);
			log.info("============= Finished verifyUndertakingAndConfirm Test===========");
			getScreenShot("hutching form verifyUndertakingAndConfirm");
		}
		catch(Exception e){
			getScreenShot("hutching form verifyUndertakingAndConfirm");
		}
	}
	@Test(priority=10)
	public void submitionOfFilledApplication() throws Exception{
		
		
		try{
			log.info("============= Strting hutching submitionOfFilledApplication Test===========");
			
			formForhutching.clickOnSubmitButton();
			log.info("============= Finished submitionOfFilledApplication Test===========");
			getScreenShot("hutching form submitionOfFilledApplication");
		}
		catch(Exception e){
			getScreenShot("hutching form submitionOfFilledApplication");
		}
		
	}
	@Test(priority=11)
	public void submitionOfConfirmationCancel() throws Exception{
		
		
		try{
			log.info("============= Strting hutching submitionOfConfirmationCancel Test===========");
			
			formForhutching.popUpValidationCancel();
			log.info("============= Finished submitionOfConfirmationCancel Test===========");
			getScreenShot("hutching form submitionOfConfirmationCancel");
		}
		catch(Exception e){
			getScreenShot("hutching form submitionOfConfirmationCancel");
		}
	}
	@Test(priority=12)
	public void submitionOfFilledApplicationforYes() throws Exception{
		
		try{
			log.info("============= Strting hutching submitionOfFilledApplication Test===========");
			
			formForhutching.clickOnSubmitButton();
			log.info("============= Finished submitionOfFilledApplication Test===========");
			getScreenShot("hutching form submitionOfFilledApplication");
		}
		catch(Exception e){
			getScreenShot("hutching form submitionOfFilledApplication");
		}
	}
	@Test(priority=13)
	public void submitionOfConfirmationYes() throws Exception{
		
		
		try{
			log.info("============= Strting hutching submitionOfConfirmationYes Test===========");
			
			formForhutching.popUpValidationYes();
			log.info("============= Finished submitionOfConfirmationYes Test===========");
			getScreenShot("hutching form submitionOfConfirmationYes");
		}
		catch(Exception e){
			getScreenShot("hutching form submitionOfConfirmationYes");
		}
	}
	@Test(priority=15)
	public void popUpValidationonSuccessfulReg() throws Exception{
		
		
		try{
			log.info("============= Strting hutching popUpValidationonSuccessfulReg Test===========");
			
			formForhutching.popUpValidationonSuccess();
			log.info("============= Finished popUpValidationonSuccessfulReg Test===========");
			getScreenShot("hutching form popUpValidationonSuccessfulReg");
		}
		catch(Exception e){
			getScreenShot("hutching form popUpValidationonSuccessfulReg");
		}
	}
}
