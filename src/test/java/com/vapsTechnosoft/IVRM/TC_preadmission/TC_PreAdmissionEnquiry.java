/**
 * 
 */
package com.vapsTechnosoft.IVRM.TC_preadmission;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.preAdmission.EnquiryForAdmission;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_PreAdmissionEnquiry extends TestBase{

	public static final Logger log = Logger.getLogger(TC_PreAdmissionEnquiry.class.getName());	

	EnquiryForAdmission enquiry;
	IvrmPortalLogin ivrmportallogin;
	
	@DataProvider(name="vapsloginData")
	public String[][] getTestDataLogin(){
		String[][] testRecordsLogin = getData("TestData.xlsx", "VapsIVRMlogindata");
		return testRecordsLogin;
	}
	@DataProvider(name="enquiryData")
	public String[][] getTestEnquiryData(){
		String[][] testRecordsEnquiryData = getData("TestData.xlsx", "preAdmEnquiryData");
		return testRecordsEnquiryData;
	}
	
	@DataProvider(name="SearchEnquiryData")
	public String[][] getTestEnquirysearchData(){
		String[][] testRecordsEnquiryValData = getData("TestData.xlsx", "PreAdmission_EnquirySearchData");
		return testRecordsEnquiryValData;
	}
	
	@BeforeClass
	public void setUp() throws IOException {
     init();
     enquiry = new EnquiryForAdmission(driver);
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
	@Test(priority=2)
	public void navigateToenquiryForAdmission(){
		enquiry = new EnquiryForAdmission(driver);
		
		try {
			log.info("============= Strting navigateToenquiryForAdmission Test===========");
		
			enquiry.enquiryPreAdmission();
		log.info("============= Finished navigateToenquiryForAdmission Test===========");
		getScreenShot("navigateToenquiryForAdmission");
		}
		catch(Exception e){
			getScreenShot("navigateToenquiryForAdmission");
		}
		}
	@Test(priority=3,dataProvider="enquiryData")
	public void enquiryForAdmission(String fName,String mName,String lName,String selectClass,
			String address1,String address2,String address3,String countryName,String stateName,
			String cityName,String pinocde,String MobileNum,String PhoneNum,String Email,String Category,String EnquiryMsg,String runMode){
		enquiry = new EnquiryForAdmission(driver);
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting enquiryForAdmission Test===========");
		
			enquiry.admissionEnquiryForm(fName, mName, lName, selectClass, address1, address2, address3, countryName, stateName, cityName, pinocde, MobileNum, PhoneNum, Email, Category, EnquiryMsg);
		log.info("============= Finished enquiryForAdmission Test===========");
		getScreenShot("enquiryForAdmission");
		}
		catch(Exception e){
			getScreenShot("enquiryForAdmission");
		}
		}
	@Test(priority=4)
	public void clickOnSaveForEnquiryFormSubmit(){
		enquiry = new EnquiryForAdmission(driver);
		
		try {
			log.info("============= Strting clickOnSaveForEnquiryFormSubmit Test===========");
		
			enquiry.clickOnSaveButton();
		log.info("============= Finished clickOnSaveForEnquiryFormSubmit Test===========");
		getScreenShot("clickOnSaveForEnquiryFormSubmit");
		}
		catch(Exception e){
			getScreenShot("clickOnSaveForEnquiryFormSubmit");
		}
		}
	@Test(priority=5)
	public void verifySuccessfulMessage(){
		enquiry = new EnquiryForAdmission(driver);
		
		try {
			log.info("============= Strting verifySuccessfulMessage Test===========");
		
			enquiry.successPopupvalidation();
		log.info("============= Finished verifySuccessfulMessage Test===========");
		getScreenShot("verifySuccessfulMessage");
		}
		catch(Exception e){
			getScreenShot("verifySuccessfulMessage");
		}
		}
	
	@Test(priority=6)
	public void tcSortByNameHeader(){
		enquiry = new EnquiryForAdmission(driver);
		
		try {
			log.info("============= Strting tcSortByNameHeader Test===========");
			getScreenShot("Before sorting by name");
			
			enquiry.sortByNameHeader();
		log.info("============= Finished tcSortByNameHeader Test===========");
		getScreenShot("tcSortByNameHeader");
		}
		catch(Exception e){
			getScreenShot("tcSortByNameHeader");
		}
		}
	
	@Test(priority=7)
	public void tcSortByEnquiryNo(){
		enquiry = new EnquiryForAdmission(driver);
		
		try {
			log.info("============= Strting tcSortByEnquiryNo Test===========");
			getScreenShot("Before sorting by Enquiry number");
			
			enquiry.sortByEnquiryNo();
		log.info("============= Finished tcSortByEnquiryNo Test===========");
		getScreenShot("tcSortByEnquiryNo");
		}
		catch(Exception e){
			getScreenShot("tcSortByEnquiryNo");
		}
		}
	
	@Test(priority=8,dataProvider="SearchEnquiryData")
	public void tcSearchByStudentNameforStudentEnquiryFrom(String studentName,String runMode){
		enquiry = new EnquiryForAdmission(driver);
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByStudentNameforStudentEnquiryFrom Test===========");
		
			enquiry.searchByStudentNameforStudentEnquiryFrom(studentName);
		log.info("============= Finished tcSearchByStudentNameforStudentEnquiryFrom Test===========");
		getScreenShot("tcSearchByStudentNameforStudentEnquiryFrom");
		}
		catch(Exception e){
			getScreenShot("tcSearchByStudentNameforStudentEnquiryFrom");
		}
		}
	
	@Test(priority=9,dataProvider="SearchEnquiryData")
	public void tcVerifyStudentNameInEnquiryGrid(String studentName,String runMode){
		enquiry = new EnquiryForAdmission(driver);
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentNameInEnquiryGrid Test===========");
		
			enquiry.verifyStudentNameInEnquiryGrid(studentName);
		log.info("============= Finished tcVerifyStudentNameInEnquiryGrid Test===========");
		getScreenShot("tcVerifyStudentNameInEnquiryGrid");
		}
		catch(Exception e){
			getScreenShot("tcVerifyStudentNameInEnquiryGrid");
		}
		}
	
	@Test(priority=10,dataProvider="SearchEnquiryData")
	public void tcEdit_EnquiryForm(String studentName,String runMode){
		enquiry = new EnquiryForAdmission(driver);
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcVerifyStudentNameInEnquiryGrid Test===========");
		
			enquiry.edit_EnquiryForm(studentName);
		log.info("============= Finished tcVerifyStudentNameInEnquiryGrid Test===========");
		getScreenShot("tcVerifyStudentNameInEnquiryGrid");
		}
		catch(Exception e){
			getScreenShot("tcVerifyStudentNameInEnquiryGrid");
		}
		}
	
	@Test(priority=11)
	public void clickOnSaveForEnquiryFormSubmitAfterEdit(){
		enquiry = new EnquiryForAdmission(driver);
		
		try {
			log.info("============= Strting clickOnSaveForEnquiryFormSubmitAfterEdit Test===========");
		
			enquiry.clickOnSaveButton();
		log.info("============= Finished clickOnSaveForEnquiryFormSubmitAfterEdit Test===========");
		getScreenShot("clickOnSaveForEnquiryFormSubmitAfterEdit");
		}
		catch(Exception e){
			getScreenShot("clickOnSaveForEnquiryFormSubmitAfterEdit");
		}
		}
	@Test(priority=12)
	public void verifySuccessfulMessageAfterEdit(){
		enquiry = new EnquiryForAdmission(driver);
		
		try {
			log.info("============= Strting verifySuccessfulMessageAfterEdit Test===========");
		
			enquiry.successPopupvalidation();
		log.info("============= Finished verifySuccessfulMessageAfterEdit Test===========");
		getScreenShot("verifySuccessfulMessageAfterEdit");
		}
		catch(Exception e){
			getScreenShot("verifySuccessfulMessageAfterEdit");
		}
		}
	
	@Test(priority=13,dataProvider="SearchEnquiryData")
	public void tcSearchByStudentNameforStudentEnquiryFromFordelete(String studentName,String runMode){
		enquiry = new EnquiryForAdmission(driver);
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcSearchByStudentNameforStudentEnquiryFromFordelete Test===========");
		
			enquiry.searchByStudentNameforStudentEnquiryFrom(studentName);
		log.info("============= Finished tcSearchByStudentNameforStudentEnquiryFromFordelete Test===========");
		getScreenShot("tcSearchByStudentNameforStudentEnquiryFromFordelete");
		}
		catch(Exception e){
			getScreenShot("tcSearchByStudentNameforStudentEnquiryFromFordelete");
		}
		}
	@Test(priority=14,dataProvider="SearchEnquiryData")
	public void tcDelete_EnquiryForm(String studentName,String runMode){
		enquiry = new EnquiryForAdmission(driver);
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting tcDelete_EnquiryForm Test===========");
		
			enquiry.delete_EnquiryForm(studentName);
		log.info("============= Finished tcDelete_EnquiryForm Test===========");
		getScreenShot("tcDelete_EnquiryForm");
		}
		catch(Exception e){
			getScreenShot("tcDelete_EnquiryForm");
		}
		}
	
	@Test(priority=15)
	public void tcConfirmationForDeletion(){
		enquiry = new EnquiryForAdmission(driver);
		
		try {
			log.info("============= Strting tcConfirmationForDeletion Test===========");
		
			enquiry.confirmationForDeletion();
		log.info("============= Finished tcConfirmationForDeletion Test===========");
		getScreenShot("tcConfirmationForDeletion");
		}
		catch(Exception e){
			getScreenShot("tcConfirmationForDeletion");
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
