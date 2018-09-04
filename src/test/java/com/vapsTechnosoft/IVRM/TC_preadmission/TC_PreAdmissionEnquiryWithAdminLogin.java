/**
 * 
 */
package com.vapsTechnosoft.IVRM.TC_preadmission;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vapsTechnosoft.IVRM.preAdmission.EnquiryForAdmissionWithAdminLogin;
import com.vapsTechnosoft.IVRM.testBase.TestBase;
import com.vapsTechnosoft.IVRM.uiActions.IvrmPortalLogin;

/**
 * @author vaps
 *
 */
public class TC_PreAdmissionEnquiryWithAdminLogin extends TestBase{
	
	public static final Logger log = Logger.getLogger(TC_PreAdmissionEnquiryWithAdminLogin.class.getName());	

	EnquiryForAdmissionWithAdminLogin enquiryadmilogin;
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
	
	@BeforeClass
	public void setUp() throws IOException {
     init();
     enquiryadmilogin = new EnquiryForAdmissionWithAdminLogin(driver);
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
	public void navigateToenquiryForAdmissionAdminLogin(){
		enquiryadmilogin = new EnquiryForAdmissionWithAdminLogin(driver);
		
		try {
			log.info("============= Strting navigateToenquiryForAdmission Test===========");
		
			enquiryadmilogin.enquiryPreAdmissionAdminLogin();
		log.info("============= Finished navigateToenquiryForAdmission Test===========");
		getScreenShot("navigateToenquiryForAdmission");
		}
		catch(Exception e){
			getScreenShot("navigateToenquiryForAdmission");
		}
		}
	@Test(priority=3,dataProvider="enquiryData")
	public void enquiryForAdmissionAdminLogin(String fName,String mName,String lName,String selectClass,
			String address1,String address2,String address3,String countryName,String stateName,
			String cityName,String pinocde,String MobileNum,String PhoneNum,String Email,String Category,String EnquiryMsg,String runMode){
		enquiryadmilogin = new EnquiryForAdmissionWithAdminLogin(driver);
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("user marked this record as no run");
		}
		try {
			log.info("============= Strting enquiryForAdmission Test===========");
		
			enquiryadmilogin.admissionEnquiryFormAdminLogin(fName, mName, lName, selectClass, address1, address2, address3, countryName, stateName, cityName, pinocde, MobileNum, PhoneNum, Email, Category, EnquiryMsg);
		log.info("============= Finished enquiryForAdmission Test===========");
		getScreenShot("enquiryForAdmission");
		}
		catch(Exception e){
			getScreenShot("enquiryForAdmission");
		}
		}
	@Test(priority=4)
	public void clickOnSaveForEnquiryFormSubmitAdminLogin(){
		enquiryadmilogin = new EnquiryForAdmissionWithAdminLogin(driver);
		
		try {
			log.info("============= Strting clickOnSaveForEnquiryFormSubmit Test===========");
		
			enquiryadmilogin.clickOnSaveButtonAdminLogin();
		log.info("============= Finished clickOnSaveForEnquiryFormSubmit Test===========");
		getScreenShot("clickOnSaveForEnquiryFormSubmit");
		}
		catch(Exception e){
			getScreenShot("clickOnSaveForEnquiryFormSubmit");
		}
		}
	@Test(priority=5)
	public void verifySuccessfulMessageadminLogin(){
		enquiryadmilogin = new EnquiryForAdmissionWithAdminLogin(driver);
		
		try {
			log.info("============= Strting verifySuccessfulMessage Test===========");
		
			enquiryadmilogin.successPopupvalidationAdminLogin();
		log.info("============= Finished verifySuccessfulMessage Test===========");
		getScreenShot("verifySuccessfulMessage");
		}
		catch(Exception e){
			getScreenShot("verifySuccessfulMessage");
		}
		}

}
