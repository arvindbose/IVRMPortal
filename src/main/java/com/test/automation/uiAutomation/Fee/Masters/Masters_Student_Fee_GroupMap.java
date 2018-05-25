/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Masters;

import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Student_Fee_GroupMap extends TestBase{
	
	public static final Logger log = Logger.getLogger(Masters_Student_Fee_GroupMap.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;
	
	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]")
	WebElement btnFee;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]")
	WebElement feeMasters;
	
	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[4]/ul/li[2]/ul/li[2]")
	WebElement btnStudentFGrMap;
	
	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtStudentFeeGrmap;
	
	@FindBy(xpath = "//span[contains(text(),'All')]/preceding-sibling::input")
	WebElement btnRadioAll;
	
	@FindBy(xpath = "(//select[@id='sel1'])[6]")
	WebElement selSearch;
	
	@FindBy(xpath = "(//div[@class='col-sm-3']/input)[1]")
	WebElement txtSearch;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/table)[1]/tbody/tr")
	List<WebElement> tblRows;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/button[1])[4]")
	WebElement btnSearch;
	
	@FindBy(xpath = "(//span[contains(text(),'Susdiny Fee Group')]/preceding-sibling::*)[1]")
	WebElement btnPlusSusdinyFGr;
	
	@FindBy(xpath = "(//span[contains(text(),'Tuition annual Fee')]/preceding-sibling::*)[1]")
	WebElement btnPlusTuitionAnnualFee;
	
	@FindBy(xpath = "(//span[contains(text(),'Test Installment I')]/preceding-sibling::*)[1]")
	WebElement chkInstallmentI;
	
	@FindBy(xpath = "(//span[contains(text(),'suresh fee group1')]/preceding-sibling::*)[1]")
	WebElement btnPlusSureshFGr1;
	
	@FindBy(xpath = "(//span[contains(text(),'suresh fee head1')]/preceding-sibling::*)[1]")
	WebElement btnPlusSureshFeeHead1;
	
	@FindBy(xpath = "(//span[contains(text(),'suresh 1 installment')]/preceding-sibling::*)[1]")
	WebElement chkSureshInstallmentI;
	
	
	@FindBy(xpath = "//button[@id='save-btn']")
	WebElement btnSave;

	@FindBy(xpath = "(//div[@class='text-center']/button)[3]")
	WebElement btnCancel;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;
	
	public Masters_Student_Fee_GroupMap(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(10000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void nevigateToMasters_StudentFeegroupMap() throws Exception {
		if(btnFee.isDisplayed()){
		btnFee.click();
		log("Clicked on Fee Button and object is:-" + btnFee.toString());
		Thread.sleep(1000);
		}
		else{
			log("Fee Button element not present.");
			Thread.sleep(500);
		}
		if(feeMasters.isDisplayed()){
		feeMasters.click();
		log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
		Thread.sleep(1000);
	}
	else{
		log("Fee masters Button element not present.");
		Thread.sleep(500);
	}
		if(btnStudentFGrMap.isDisplayed()){
		btnStudentFGrMap.click();
		log("Clicked on student Fee Group map Button and object is:-" + btnStudentFGrMap.toString());
		Thread.sleep(5000);
		}
		else{
			log("Student Fee Group map Button element not present.");
			Thread.sleep(500);
		}
	}

	public boolean verifyStudentFeeGroupMapPage() {
		try {
			System.out.println(txtStudentFeeGrmap.getText());
			txtStudentFeeGrmap.isDisplayed();
			log("student Fee Group Map page is dispalyed and object is:-" + txtStudentFeeGrmap.toString());
			Thread.sleep(10000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	public void selectByStudentName(String byStudentName, String StdName) throws Exception {
		if(!btnRadioAll.isSelected()){
		btnRadioAll.click();
		log("All radio button is selected and object is:-"+btnRadioAll.toString());
		Thread.sleep(10000);
		}
		else{
			log("All radio button is already selected and object is:-"+btnRadioAll.toString());
			Thread.sleep(500);
		}
		
		if(selSearch.isDisplayed()){
		select = new Select(selSearch);
		select.selectByVisibleText(byStudentName);
		log("selected Student name for search:-" + byStudentName + " and object is " + selSearch.toString());
		
		option = select.getFirstSelectedOption();
		Assert.assertEquals(option.getText().trim(), byStudentName);
		Thread.sleep(1000);
		} else {
			log("Select search element is not present");
			Thread.sleep(500);
		}
		if(txtSearch.isDisplayed()){
		txtSearch.clear();
		txtSearch.sendKeys(StdName);
		log("entered Student name:-" + StdName + " and object is " + txtSearch.toString());
		Thread.sleep(1000);
		}
		else{
			log("Search box element is not present.");
			Thread.sleep(500);
		}

	}
	public void clickOnSearchButton() throws Exception{
		if(btnSearch.isDisplayed()){
		btnSearch.click();
		log("clicked on search button and object is:-"+btnSearch.toString());
		Thread.sleep(2000);
		}
		else{
			log("Search button element is not present.");
			Thread.sleep(500);
		}
	}
	public void selectTheCheckBoxForCorresponingStudent(String StudentName) throws Exception{
		
		int rows = tblRows.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for(int i=1; i<=rows;i++){
		String stuName = driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr["+i+"]/td[4]")).getText();
		System.out.println(stuName);
		Thread.sleep(2000);
		if(stuName.equals(StudentName)){
			driver.findElement(By.xpath("(//body[@id='style-4']//div/table)[1]/tbody/tr["+i+"]/td[6]/label")).click();
			log("Select the check box corresponding to student with Name:"+StudentName);
			Thread.sleep(2000);
		}
		}
	}
	public void mapStudentWithGroup() throws Exception{
		btnPlusSureshFGr1.click();
		log("clicked on Plus(+) followed by Suresh fee group 1 and object is:-"+btnPlusSureshFGr1.toString());
		Thread.sleep(1000);
		
		btnPlusSureshFeeHead1.click();
		log("clicked on Plus(+) followed by Suresh fee head 1 and object is:-"+btnPlusSureshFeeHead1.toString());
		Thread.sleep(1000);
		
		chkSureshInstallmentI.click();
		log("clicked on Suresh Installment I check box and object is:-"+chkSureshInstallmentI.toString());
		Thread.sleep(1000);
	}
	public void clickOnSaveButton() throws Exception {
		btnSave.click();
		log("clicked on save button and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}

	public boolean verifySuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record saved successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(10000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSuccessOkBtn() throws Exception {
		btnOkonSuccess.click();
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());
		Thread.sleep(3000);
	}
}
