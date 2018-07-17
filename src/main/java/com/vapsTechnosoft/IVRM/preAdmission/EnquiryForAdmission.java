/**
 * 
 */
package com.vapsTechnosoft.IVRM.preAdmission;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class EnquiryForAdmission extends TestBase{

public static final Logger log = Logger.getLogger(EnquiryForAdmission.class.getName());
	
	
	WebDriver driver;
	Select select;
	
	@FindBy(xpath="//aside[@id='style-4']/section/ul/li[2]/a")
	WebElement label_preAdmission;
	
	@FindBy(xpath="//aside[@id='style-4']/section/ul/li[2]/ul/li[1]/a/span")
	WebElement sublabel_Enquiry;
	
	@FindBy(xpath="//aside[@id='style-4']/section/ul/li[2]/ul/li[1]/ul/li")
	WebElement btn_Enquiry;
	
	@FindBy(xpath="(//select[@id='sel1'])[1]")
	WebElement academicYear;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[1]/div[3]/div/input")
	WebElement firstName;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[1]/div[4]/div[1]/input")
	WebElement middleName;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[1]/div[4]/div[2]/input")
	WebElement lastName;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[1]/div[5]/div/select")
	WebElement selClass;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[1]/div[6]/div/textarea")
	WebElement addressline1;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[1]/div[7]/div/textarea")
	WebElement addressline2;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[1]/div[8]/div/textarea")
	WebElement addressline3;
	
	@FindBy(xpath="(//select[@id='sel1'])[2]")
	WebElement selCountry;
	
	@FindBy(xpath="(//select[@id='sel1'])[3]")
	WebElement selState;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[2]/div[2]/div/input")
	WebElement enquiryCity;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[2]/div[3]/div/input")
	WebElement pinCode;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[2]/div[4]/div/div/input")
	WebElement mobileNumber;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[2]/div[5]/div/div/input")
	WebElement phoneNumber;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[2]/div[6]/div/div/input")
	WebElement emailid;
	
	@FindBy(xpath="(//select[@id='sel1'])[4]")
	WebElement category;
	
	@FindBy(xpath="//body[@id='style-4']//div/div[2]/div[8]/div/textarea")
	WebElement enquiryMsg;
	
	@FindBy(xpath="//body[@id='style-4']//div/form/div[2]/span/button")
	WebElement btnSave;
	
	@FindBy(xpath="//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkSuccess;
	
	/**
	 * Table data validation selector
	 * 
	 */
	@FindBy(xpath="//body[@id='style-4']//div/table/thead/tr/th[2]")
	WebElement sortByName;
	
	@FindBy(xpath="//body[@id='style-4']//div/table/thead/tr/th[4]")
	WebElement sortByEnquiryNo;
	
	@FindBy(xpath = "//body[@id='style-4']//div/table/tbody/tr")
	List<WebElement> tblRows;
	
	@FindBy(xpath="//div[@id='style-4']/div/div[3]/div/div/input")
	WebElement inputSearch;
	
	
	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnPopUpYesDeleteit;

	

	
	/**
	 * Constructor 
	 * @param driver
	 */
	public EnquiryForAdmission(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enquiryPreAdmission() throws Exception{
		label_preAdmission.click();
		log("Clicked on preadmission label and object is:-"+label_preAdmission.toString());
		Thread.sleep(2000);
		sublabel_Enquiry.click();
		log("Clicked on main enquiry button and object is:-"+sublabel_Enquiry.toString());
		Thread.sleep(2000);
		btn_Enquiry.click();
		log("Clicked on enquiry form button and object is:-"+btn_Enquiry.toString());
		Thread.sleep(3000);
	}
	
	public void admissionEnquiryForm(String fName,String mName,String lName,String selectClass,
			String address1,String address2,String address3,String countryName,String stateName,
			String cityName,String pinocde,String MobileNum,String PhoneNum,String Email,String Category,String EnquiryMsg) throws InterruptedException{
		
		
		firstName.sendKeys(fName);
		log("entered first name:-" + fName + " and object is " + firstName.toString());
		Thread.sleep(1000);
		middleName.sendKeys(mName);
		log("entered middle name:-" + mName + " and object is " + middleName.toString());
		Thread.sleep(1000);
		lastName.sendKeys(lName);
		log("entered lastname:-" + lName + " and object is " + lastName.toString());
		Thread.sleep(1000);
		
		select = new Select(selClass);
		select.selectByVisibleText(selectClass);
		log("selected class for enquiry:-" + selectClass + " and object is " + selClass.toString());
		Thread.sleep(1000);
		
		addressline1.sendKeys(address1);
		log("entered address in line one:-" + address1 + " and object is " + addressline1.toString());
		Thread.sleep(1000);
		addressline2.sendKeys(address2);
		log("entered address in line 2:-" + address2 + " and object is " + addressline2.toString());
		Thread.sleep(1000);
		addressline3.sendKeys(address3);
		log("entered address in line 3:-" + address3 + " and object is " + addressline3.toString());
		Thread.sleep(1000);
		
		select = new Select(selCountry);
		select.selectByVisibleText(countryName);
		log("selected country from the list:-" + countryName + " and object is " + selCountry.toString());
		Thread.sleep(1000);
		
		select = new Select(selState);
		select.selectByVisibleText(stateName);
		log("selected state from the list:-" + stateName + " and object is " + selState.toString());
		Thread.sleep(1000);
		enquiryCity.sendKeys(cityName);
		log("entered city for enquiry:-" + cityName + " and object is " + enquiryCity.toString());
		Thread.sleep(1000);
		pinCode.sendKeys(pinocde);
		log("entered pin code:-" + pinocde + " and object is " + pinCode.toString());
		Thread.sleep(1000);
		mobileNumber.sendKeys(MobileNum);
		log("entered mobile number:-" + MobileNum + " and object is " + mobileNumber.toString());
		Thread.sleep(1000);
		phoneNumber.sendKeys(PhoneNum);
		log("entered phone number:-" + PhoneNum + " and object is " + phoneNumber.toString());
		Thread.sleep(1000);
		emailid.sendKeys(Email);
		log("entered email Id:-" + Email + " and object is " + emailid.toString());
		Thread.sleep(1000);
		
		select = new Select(category);
		select.selectByVisibleText(Category);
		log("selected category from the list:-" + Category + " and object is " + category.toString());
		Thread.sleep(1000);
		enquiryMsg.sendKeys(EnquiryMsg);
		log("entered email Id:-" + EnquiryMsg + " and object is " + enquiryMsg.toString());
		Thread.sleep(1000);
		
	}	
	public void clickOnSaveButton() throws Exception{
		btnSave.click();
		log("Clicked on SAVE button and object is:-"+btnSave.toString());
		Thread.sleep(5000);
	}
	public void successPopupvalidation() throws Exception{
		btnOkSuccess.click();
		log("Clicked on Ok button for Successful equiry and object is:-"+btnOkSuccess.toString());
		Thread.sleep(2000);
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}
	
	public void sortByNameHeader() throws Exception{
	
		sortByName.click();
		log("Grid table value is sort by name");
		Thread.sleep(2000);
		
	}
	
	public void sortByEnquiryNo() throws Exception{
		
		sortByEnquiryNo.click();
		log("Grid table value is sort by name");
		Thread.sleep(2000);
		
	}
	
	public void searchByStudentNameforStudentEnquiryFrom(String studentName) throws Exception{
		
		inputSearch.clear();
		inputSearch.sendKeys(studentName);
		log("Enterd student name for enquiry form search "+studentName+" and object is:-"+inputSearch.toString());
		Thread.sleep(2000);
	}
	
	public void verifyStudentNameInEnquiryGrid(String studentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String studentname = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(studentname);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(studentname, studentName);
				log("Student name for enquiry is updated in the grid:" + studentname);
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void edit_EnquiryForm(String studentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String studentname = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(studentname);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(studentname, studentName);
				driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[9]/span[1]"))
						.click();
				log("Clicked on edit link for corresponding student name in grid");

				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete_EnquiryForm(String studentName) throws Exception {

		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String studentname = driver
					.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println(studentname);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(studentname, studentName);
				driver.findElement(By.xpath("//body[@id='style-4']//div/table/tbody/tr[" + i + "]/td[9]/span[2]"))
						.click();
				log("Clicked on delete icon in enquiry form grid");

				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void confirmationForDeletion() throws Exception {
		btnPopUpYesDeleteit.click();
		log("Clicked Yes delete it button and object is:" + btnPopUpYesDeleteit.toString());
		Thread.sleep(5000);
	}
}
