/**
 * 
 */
package com.vapsTechnosoft.IVRM.selfRegistration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class SelfRegistrationProductionBGHS extends TestBase{

public static final Logger log = Logger.getLogger(SelfRegistrationProductionBGHS.class.getName());
	
	
WebDriver driver;

@FindBy(xpath="//body[@id='style-4']//div/form/footer/div/div[2]/button")
WebElement link_Registration;

@FindBy(xpath="(//body[@id='style-4']//div/form/div[1]/label)[2]")
WebElement image_upload;

@FindBy(xpath="(//body[@id='style-4']//div/form/div[2]/div/input)[2]")
WebElement txt_Name;

@FindBy(xpath="(//body[@id='style-4']//div/form/div[3]/div[1]/input)[2]")
WebElement txt_RegEmail;

@FindBy(xpath="(//body[@id='style-4']//div/form/div[6]/div[1]/input)[2]")
WebElement txt_MobileNumber;

@FindBy(xpath="(//body[@id='style-4']//div/form/div[9]/div/input)[2]")
WebElement txt_UserName;

@FindBy(xpath="(//body[@id='style-4']//div/form/div[10]/div/input)[2]")
WebElement txt_Password;

@FindBy(xpath="(//body[@id='style-4']//div/form/div[11]/div/input)[2]")
WebElement txt_ConfirmPassword;

@FindBy(xpath="(//body[@id='style-4']//div/form/div[12]/div[1]/button)[2]")
WebElement btn_Register;

@FindBy(xpath="(//body[@id='style-4']//div/form/div[12]/div[2]/button)[2]")
WebElement btn_calcel;

@FindBy(xpath="//body[@id='style-4']/div[5]/div[7]/div/button")
WebElement btn_OK_Success;

/**
 * Constructor
 * @param driver
 */

public SelfRegistrationProductionBGHS(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
/**
 * Cancel button validation 
 * @throws InterruptedException
 */
public void cancelButtonValidation() throws InterruptedException{
	link_Registration.click();
	log("cliked on registration link and object is:-"+link_Registration.toString());
	Thread.sleep(1000);
	btn_calcel.click();
	log("clicked on cancel button and object is:-"+btn_calcel.toString());
	Thread.sleep(2000);
}
/**
 * Student registration 
 * @param name
 * @param Email
 * @param mobileNo
 * @param userName
 * @param password
 * @param confirmPass
 * @throws Exception
 */
public void studentRegistrationForm(String name, String Email, String mobileNo, String userName, 
		String password, String confirmPass) throws Exception {
	
	link_Registration.click();
	log("cliked on registration link and object is:-"+link_Registration.toString());
	Thread.sleep(1000);
	imageAndDocumentUpload(image_upload, "Photo.jpg");
	log("Student photograph uploaded successfully");
	Thread.sleep(1000);
	txt_Name.sendKeys(name);
	log("entered student name:-"+name+" and object is "+txt_Name.toString());
	Thread.sleep(1000);
	txt_RegEmail.sendKeys(Email);
	log("entered Email:-"+Email+" and object is "+txt_RegEmail.toString());
	Thread.sleep(1000);
	txt_MobileNumber.sendKeys(mobileNo);
	log("entered Mobile No.:-"+mobileNo+" and object is "+txt_MobileNumber.toString());
	Thread.sleep(1000);
	txt_UserName.sendKeys(userName);
	log("entered user name:-"+userName+" and object is "+txt_UserName.toString());
	Thread.sleep(1000);
	txt_Password.sendKeys(password);
	log("entered password:-"+password+" and object is "+txt_Password.toString());
	Thread.sleep(1000);
	txt_ConfirmPassword.sendKeys(confirmPass);
	log("entered Mobile No.:-"+confirmPass+" and object is "+txt_ConfirmPassword.toString());
	Thread.sleep(1000);
	
}
public void registerButtonValidation() throws Exception{
	btn_Register.click();
	log("cliked on register(Submit) button and object is:-"+btn_Register.toString());
	Thread.sleep(2000);
	
}
public void successmessageValidation() throws Exception{
	btn_OK_Success.click();
	log("cliked on OK button success alert popup and object is:-"+btn_OK_Success.toString());
	Thread.sleep(2000);
}

}
