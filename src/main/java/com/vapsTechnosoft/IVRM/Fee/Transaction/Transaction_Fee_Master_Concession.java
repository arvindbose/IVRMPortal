/**
 * 
 */
package com.vapsTechnosoft.IVRM.Fee.Transaction;

import java.awt.Robot;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class Transaction_Fee_Master_Concession extends TestBase {

	public static final Logger log = Logger.getLogger(Transaction_Fee_Master_Concession.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Transaction')][1]")
	WebElement feeTransaction;

	// @FindBy(xpath =
	// "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Transaction')][1]/following::li[2]")
	// WebElement btnFeeMasterConcession;

	@FindBy(xpath = "//a[@href='#/app/FeeConcession/190']")
	WebElement btnFeeMasterConcession;

	@FindBy(xpath = "//div//section//ol//li")
	WebElement txt_FeeMasterConcession;

	@FindBy(xpath = "//span[contains(text(),'Class Wise')]/preceding-sibling::input")
	WebElement rdBtn_ClassWise;

	@FindBy(xpath = "//span[contains(text(),'Category Wise')]/preceding-sibling::input")
	WebElement rdBtn_CategoryWise;

	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYear;

	@FindBy(xpath = "//label[contains(text(),'Class:')]/following-sibling::div/select")
	WebElement sel_Class;

	@FindBy(xpath = "//label[contains(text(),'Category:')]/following-sibling::div/select")
	WebElement sel_Category;

	@FindBy(xpath = "//div[@class='multiselect col-sm-8']/label/input")
	List<WebElement> Chk_GroupName;

	@FindBy(xpath = "//label[@data-ng-model='FMG_Id']/span")
	List<WebElement> List_GroupName;

	@FindBy(xpath = "//table//tbody//tr[1]/td[6]//label//input")
	WebElement chk_StudentList;

	@FindBy(xpath = "//div[@class='input-group']//input[@ng-model='searchthird']")
	WebElement input_Search_StudentList;

	@FindBy(xpath = "(//div[@class='form-group']//input[@ng-model='search'])[1]")
	WebElement input_Search_OutputGrid;

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/tbody/tr[1]/td[9]/a")
	WebElement icon_DeleteRecord_OutputGrid;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/tbody/tr[1]/td[2]//label//input[2]")
	WebElement chk_FeeHeadList;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/tbody/tr[1]/td[5]//select")
	WebElement sel_Type_FeeHeadList;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/tbody/tr[1]/td[7]//input")
	WebElement input_ConcessionAmount_FeeHeadList;

	@FindBy(xpath = "(//div[@class='box-body']/table)[1]/tbody/tr[1]/td[8]//input")
	WebElement input_Remarks_FeeHeadList;

	@FindBy(xpath = "//span[contains(text(),'Save')]//parent::button")
	WebElement btn_Save;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]//parent::button")
	WebElement btn_Cancel;

	@FindBy(xpath = "//button[contains(text(),'OK')]")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/h2")
	WebElement successfulMessage;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxFeeConcession;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxStudentList;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[4]")
	WebElement btnMin_MaxFeeHeadList;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[5]")
	WebElement btnMin_MaxStudentFeeConcessionGridOutput;

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]//thead//tr//th[2]/a")
	WebElement btnSortByStudentName;

	@FindBy(xpath = "//h3[contains(text(),'Fee Head List')]")
	WebElement txtFeeHeadList;

	@FindBy(xpath = "//h3[contains(text(),'Student List')]")
	WebElement txtStudentList;

	public Transaction_Fee_Master_Concession(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void navigateToTransaction_FeeMasterConcession() throws Exception {

		clickOnButton(btnFee);
		log("Clicked on Fee Button and object is:-" + btnFee.toString());

		clickOnButton(feeTransaction);
		log("Clicked on Transaction Button and object is:-" + feeTransaction.toString());

		clickOnButton(btnFeeMasterConcession);
		log("Clicked on Fee Master Concession Button and object is:-" + btnFeeMasterConcession.toString());

	}

	public boolean verifyFeeMasterConcessionPage() {
		try {
			System.out.println(txt_FeeMasterConcession.getText());
			txt_FeeMasterConcession.isDisplayed();
			log("Fee Master Concession page is dispalyed and object is:-" + txt_FeeMasterConcession.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean verify_StudentList_IsPresent() {
		try {
			System.out.println(txtStudentList.getText());
			txtStudentList.isDisplayed();
			log("Student List is dispalyed and object is:-" + txtStudentList.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean verify_FeeHeadList_IsPresent() {
		try {
			System.out.println(txtFeeHeadList.getText());
			txtFeeHeadList.isDisplayed();
			log("Fee Head List is dispalyed and object is:-" + txtFeeHeadList.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void fill_FeeMasterConcessionForm_rdBtnClassWise(String academicYr, String class_ClassWise, String groupName)
			throws Exception {
		isDisplayed(rdBtn_ClassWise);
		if (!rdBtn_ClassWise.isSelected()) {
			rdBtn_ClassWise.click();
			log("Radio button Class Wise is selected and object is:-" + rdBtn_ClassWise.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button Class Wise is already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_AcademicYear, academicYr);
		log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

		selectElementFromDropDown(sel_Class, class_ClassWise);
		log("Selected Class:-" + class_ClassWise + " and object is " + sel_Class.toString());

		try {
			int groupList = List_GroupName.size();
			for (int i = 0; i < groupList; i++) {
				if (List_GroupName.get(i).getText().trim().equals(groupName)) {
					if (!Chk_GroupName.get(i).isSelected()) {
						Chk_GroupName.get(i).click();
						log(i + " Group Name check box is checked.");
						Thread.sleep(1000);
					}
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fill_FeeMasterConcessionForm_rdBtnCategoryWise(String category, String academicYr,String groupName) throws Exception {
		isDisplayed(rdBtn_CategoryWise);
		if (!rdBtn_CategoryWise.isSelected()) {
			rdBtn_CategoryWise.click();
			log("Radio button Category Wise is selected and object is:-" + rdBtn_CategoryWise.toString());
			Thread.sleep(1000);
		} else {
			log("Radio button Category Wise is already selected.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Category, category);
		log("Selected Category:-" + category + " and object is " + sel_Category.toString());

		selectElementFromDropDown(sel_AcademicYear, academicYr);
		log("Selected Academic Year:-" + academicYr + " and object is " + sel_AcademicYear.toString());

		try {
			int groupList = List_GroupName.size();
			for (int i = 0; i < groupList; i++) {
				if (List_GroupName.get(i).getText().trim().equals(groupName)) {
					if (!Chk_GroupName.get(i).isSelected()) {
						Chk_GroupName.get(i).click();
						log(i + " Group Name check box is checked.");
						Thread.sleep(1000);
					}
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void searchStudentFromStudentList(String studentName) throws Exception {

		inputTextIntoInputField(input_Search_StudentList, studentName);
		log("Entered student for search is: " + studentName + " and object is:-" + input_Search_StudentList.toString());

	}

	public void selectStudentForFeeConcession_FromStudentList() throws Exception {
		isDisplayed(chk_StudentList);
		if (!chk_StudentList.isSelected()) {
			chk_StudentList.click();
			log("Student is selected for fee concession and object is:-" + chk_StudentList.toString());
			Thread.sleep(1000);
		} else {
			log("Student is already selected for fee concession.");
			Thread.sleep(500);
		}
	}

	public void selectFeeHeadTypeAnd_EnterConcessionAmount(String concessionType, String amount, String remarks)
			throws Exception {
		isDisplayed(chk_FeeHeadList);
		if (!chk_FeeHeadList.isSelected()) {
			chk_FeeHeadList.click();
			log("Fee Head is selected for fee concession and object is:-" + chk_FeeHeadList.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Head is already selected for fee concession.");
			Thread.sleep(500);
		}

		selectElementFromDropDown(sel_Type_FeeHeadList, concessionType);
		log("Selected Concession type:-" + concessionType + " and object is " + sel_Type_FeeHeadList.toString());

		inputTextIntoInputField(input_ConcessionAmount_FeeHeadList, amount);
		log("Entered Concession amount" + amount + " and object is " + input_ConcessionAmount_FeeHeadList.toString());

		inputTextIntoInputField(input_Remarks_FeeHeadList, remarks);
		log("Entered Concession Remarks" + remarks + " and object is " + input_Remarks_FeeHeadList.toString());

	}

	public void clickOnSaveButton() throws Exception {

		clickOnButton(btn_Save);
		log("clicked on save button and object is:-" + btn_Save.toString());
		Thread.sleep(3000);

	}

	public void clickOnCancelButton() throws Exception {

		clickOnButton(btn_Cancel);
		log("clicked on Cancel button and object is:-" + btn_Cancel.toString());
		Thread.sleep(3000);

	}

	public boolean verifySuccessfulPopUp() {
		try {
			System.out.println(successfulMessage.getText());
			successfulMessage.isDisplayed();
			log("Record saved successfully message is dispalyed and object is:-" + successfulMessage.toString());
			Thread.sleep(3000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void clickOnSuccessOkBtn() throws Exception {

		clickOnButton(btnOkonSuccess);
		log("clicked on OK button and object is:-" + btnOkonSuccess.toString());

	}

	public void searchStudentFrom_StudentFeeConcessionGrid(String studentName) throws Exception {

		inputTextIntoInputField(input_Search_OutputGrid, studentName);
		log("Entered student for search in Student Fee Concession Grid: " + studentName + " and object is:-"
				+ input_Search_OutputGrid.toString());
		Thread.sleep(1000);
	}

	public void deleteStudentFrom_StudentFeeConcessionGrid() throws InterruptedException {

		clickOnButton(icon_DeleteRecord_OutputGrid);
		log("Delete icon is clicked for deletion of record and object is:-" + icon_DeleteRecord_OutputGrid.toString());
		Thread.sleep(1000);

	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {

		clickOnButton(btnYesDeleteOrDeactIt);
		log("Clicked on yes delete it button and object is:-" + btnYesDeleteOrDeactIt.toString());
		Thread.sleep(5000);

	}

	public void clickOnCancelButton_PopUp() throws Exception {

		clickOnButton(btnPopUpCancel);
		log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
		Thread.sleep(1000);

	}

	public void minimizeAndMaximize_FeeConcession() throws Exception {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", txt_FeeMasterConcession);
		Thread.sleep(1000);

		clickOnButton(btnMin_MaxFeeConcession);
		log("clicked on Fee Concession minimize Or maximize button and object is:-"
				+ btnMin_MaxFeeConcession.toString());

	}

	public void minimizeAndMaximize_StudentList() throws Exception {

		clickOnButton(btnMin_MaxStudentList);
		log("clicked on Student list minimize Or maximize and object is:-" + btnMin_MaxStudentList.toString());
		Thread.sleep(1000);

	}

	public void minimizeAndMaximize_FeeHeadList() throws Exception {

		clickOnButton(btnMin_MaxFeeHeadList);
		log("clicked on Fee Head list minimize Or maximize and object is:-" + btnMin_MaxFeeHeadList.toString());
		Thread.sleep(1000);

	}

	public void minimizeAndMaximize_StudentFeeConcessionGridOutput() throws Exception {

		clickOnButton(btnMin_MaxStudentFeeConcessionGridOutput);
		log("clicked on Student Fee Concession Grid Output minimize Or maximize and object is:-"
				+ btnMin_MaxStudentFeeConcessionGridOutput.toString());
		Thread.sleep(1000);

	}

	public void sortByStudentName() throws Exception {

		clickOnButton(btnSortByStudentName);
		clickOnButton(btnSortByStudentName);
		log("Sorted the record with Student name and object is:-" + btnSortByStudentName.toString());

	}
}
