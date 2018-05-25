/**
 * 
 */
package com.test.automation.uiAutomation.Fee.Masters;

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

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class Masters_Fee_Group_YearlyGroup extends TestBase{

	public static final Logger log = Logger.getLogger(Masters_Fee_Group_YearlyGroup.class.getName());

	WebDriver driver;
	Select select;
	WebElement option;

	@FindBy(xpath = "//aside[@id='style-4']/section/ul/li[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button")
	WebElement btnFee;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement feeMasters;

	@FindBy(xpath = "//span[contains(text(),'Fees')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[3]")
	WebElement btnFeeGroup;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtFeeGroupDispaly;

	@FindBy(xpath = "(//span[contains(text(),'Yearly Group')])[1]/parent::md-tab-item")
	WebElement tab_YearlyGroup;
	
	@FindBy(xpath = "//label[contains(text(),'Academic Year:')]/following-sibling::div/select")
	WebElement sel_AcademicYear;
	
	@FindBy(xpath = "(//body[@id='style-4']//div/input)[4]")
	WebElement input_GroupsSearchBox;

	@FindBy(xpath = "//span[contains(text(),'Susdiny annual Fee Group')]/preceding-sibling::input")
	WebElement chk_GroupSelection;

	@FindBy(xpath = "(//span[contains(text(),'Save')]/parent::button)[2]")
	WebElement btn_Save_YearlyGroup;

	@FindBy(xpath = "(//span[contains(text(),'Cancel')]/parent::button)[2]")
	WebElement btn_Cancel_YearlyGr;

	@FindBy(xpath = "(//div[@class='input-group']/span/following-sibling::input)[2]")
	WebElement input_SearchYearly;
	
	@FindBy(xpath = "//div[@class='sa-button-container']/div/button")
	WebElement btnOkonSuccess;

	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/tbody/tr")
	List<WebElement> tblRows_YearlyGr;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnPopUpCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[3]")
	WebElement btnMin_MaxYearlyFeeGroup;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[4]")
	WebElement btnMin_MaxYearlyGroupFeeGrGridView;
	
	@FindBy(xpath = "(//div[@class='box-body']/table)[2]/thead/tr/th[3]/a")
	WebElement btnSortByFeeGroupName_YearlyGr;

	public Masters_Fee_Group_YearlyGroup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(7000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public void navigateToMasters_FeeGroup_YearlyFeeGroup() throws Exception {
		if (btnFee.isDisplayed()) {
			btnFee.click();
			log("Clicked on Fee Button and object is:-" + btnFee.toString());
			// waitForElement(driver, 10, btnFee);
			Thread.sleep(1000);
		} else {
			log("Fee Navigation element not present.");
			Thread.sleep(500);
		}
		if (feeMasters.isDisplayed()) {
			feeMasters.click();
			log("Clicked on Fee Masters Button and object is:-" + feeMasters.toString());
			// waitForElement(driver, 10, feeMasters);
			Thread.sleep(1000);
		} else {
			log("Fee Masters Navigation element not present.");
			Thread.sleep(500);
		}
		if (btnFeeGroup.isDisplayed()) {
			btnFeeGroup.click();
			log("Clicked on Fee Group Button and object is:-" + btnFeeGroup.toString());
			Thread.sleep(20000);
		} else {
			log("Fee Group Navigation element not present.");
			Thread.sleep(500);
		}
	}

	public boolean verifyFeeGroupPage() {
		try {
			System.out.println(txtFeeGroupDispaly.getText());
			txtFeeGroupDispaly.isDisplayed();
			log("Fee group page is dispalyed and object is:-" + txtFeeGroupDispaly.toString());
			Thread.sleep(2000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	public void NavigateTo_YearlyGroupTab() throws Exception{
		if (tab_YearlyGroup.isDisplayed()) {
		tab_YearlyGroup.click();
		log("Selected yearly group tab and object is:-"+tab_YearlyGroup.toString());
		Thread.sleep(20000);
		} else {
			log("Fee Group Navigation element not present.");
			Thread.sleep(500);
		}
	}
	public void fill_FeeGroup_YearlyGroupForm(String academicYear,String groupName) throws Exception{
		
		if (sel_AcademicYear.isDisplayed()) {
			select = new Select(sel_AcademicYear);
			select.selectByVisibleText(academicYear);

			log("selected Academic Year: " + academicYear + " and object is:- " + sel_AcademicYear.toString());
			option = select.getFirstSelectedOption();
			Assert.assertEquals(option.getText().trim(), academicYear);
			Thread.sleep(22000);
		} else {
			log("Academic Year element is not present");
			Thread.sleep(500);
		}
		if (input_GroupsSearchBox.isDisplayed()) {
			input_GroupsSearchBox.clear();
			input_GroupsSearchBox.sendKeys(groupName);
			log("Entered Fee group name:-" + groupName + " and object is " + input_GroupsSearchBox.toString());
			Thread.sleep(1000);
		} else {
			log("Fee Group Name field element not present.");
			Thread.sleep(500);
		}
		if(!chk_GroupSelection.isSelected()){
			chk_GroupSelection.click();
			log("Group check box is checked and object is:-"+chk_GroupSelection.toString());
		Thread.sleep(1000);
		}else{
			log("Group check box already selected.");
			Thread.sleep(500);
		}
		
	}
	public void clickOnSaveButton_YearlyGroup() throws Exception{
		if(!btn_Save_YearlyGroup.isSelected()){
		btn_Save_YearlyGroup.click();
		log("clicked on yearly Group save button and object is:-"+btn_Save_YearlyGroup.toString());
		Thread.sleep(20000);
		}else{
			log("Group check box already selected.");
			Thread.sleep(500);
		}
	}
	public void clickOnCancelButton_YearlyFeeGroup() throws Exception {
		if (btn_Cancel_YearlyGr.isDisplayed()) {
			btn_Cancel_YearlyGr.click();
			log("clicked on Cancel button Yearly Fee group and object is:-" + btn_Cancel_YearlyGr.toString());
			Thread.sleep(20000);
		} else {
			log("Cancel Button Yearly element not present.");
			Thread.sleep(500);
		}
	}
	
	public void clickOnSuccessOkBtn_YearlyGroup() throws Exception{
		//if(!btnOkonSuccess.isDisplayed()){
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", btnOkonSuccess);
		//	btnOkonSuccess.click();
		log("clicked on OK button and object is:-"+btnOkonSuccess.toString());
		Thread.sleep(1000);
		//}else{
		//	log("Ok Button element not present.");
		//	Thread.sleep(500);
		//}
	}
	
	public void searchBy_FeeGroup_YearlyFeeGrNameInGrid(String yearlyFeeGroup) throws Exception {
		if (input_SearchYearly.isDisplayed()) {
			input_SearchYearly.clear();
			input_SearchYearly.sendKeys(yearlyFeeGroup);
			log("Entered Yearly Fee Group name:" + yearlyFeeGroup + " and object is:-" + input_SearchYearly.toString());
			Thread.sleep(1000);
		} else {
			log("Search Element not present");
			Thread.sleep(500);
		}
	}

	/**
	 * verify for the created Yearly Fee group
	 * 
	 * @param feeGroup
	 * @throws Exception
	 */
	public void verifyYearlyFeeGroup_UpdatedInGrid(String yearlyFeeGroup) throws Exception {

		int rows = tblRows_YearlyGr.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String yearlyfeegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Created Fee Group Yearly " + yearlyFeeGroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(yearlyfeegroup, yearlyFeeGroup);
				log("Master Fee group name is update in the grid:" + yearlyFeeGroup);
				Thread.sleep(1000);
				//break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Edit Yearly fee group name created
	 * 
	 * @param yearlyFeeGroup
	 * @throws Exception
	 */
	public void edit_YearlyFeeGroup(String yearlyFeeGroup) throws Exception {

		int rows = tblRows_YearlyGr.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String yearlyfeegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Created Fee Group Yearly " + yearlyfeegroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(yearlyfeegroup, yearlyFeeGroup);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[6]/a")).click();
				log("Clicked on edit link for corresponding Yearly Fee group name in grid");
				Thread.sleep(1000);
				//break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * De-activation of created Yearly Fee group
	 * 
	 * @param yearlyFeeGroup
	 * @throws Exception
	 */
	public void deactivationOfCreated_YearlyFeeGroup(String yearlyFeeGroup) throws Exception {

		int rows = tblRows_YearlyGr.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String yearlyfeegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Created Fee Group Master " + yearlyfeegroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(yearlyfeegroup, yearlyFeeGroup);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[6]/span"))
						.click();
				log("Clicked on deactivation link in Master fee group grid");
				Thread.sleep(1000);
				//break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * Confirmation validation for deactivation, activation
	 * 
	 * @throws Exception
	 */

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		if (btnYesDeleteOrDeactIt.isDisplayed()) {
			btnYesDeleteOrDeactIt.click();
			log("Clicked on yes deactivate or activate or delete it button and object is:-"
					+ btnYesDeleteOrDeactIt.toString());
			Thread.sleep(20000);
		} else {
			log("Yes Activate/Deactivate button element not present.");
			Thread.sleep(500);
		}
	}

	public void clickOnCancelButton() throws Exception {
		if (btnPopUpCancel.isDisplayed()) {
			btnPopUpCancel.click();
			log("Clicked on cancel button and object is:-" + btnPopUpCancel.toString());
			Thread.sleep(3000);
		} else {
			log("Cancel button element not present.");
			Thread.sleep(500);
		}
	}

	/**
	 * Activation of created Yearly fee group
	 * 
	 * @param yearlyFeeGroup
	 * @throws Exception
	 */
	public void activationOfCreatedFeeGroup_YearlyGroup(String yearlyFeeGroup) throws Exception {

		int rows = tblRows_YearlyGr.size();
		System.out.println(rows);
		Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String yearlyfeegroup = driver
					.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[3]")).getText()
					.trim();
			System.out.println("Created Fee Group Yearly " + yearlyfeegroup);
			Thread.sleep(2000);
			try {
				Assert.assertEquals(yearlyfeegroup, yearlyFeeGroup);
				driver.findElement(By.xpath("(//div[@class='box-body']/table)[2]/tbody/tr[" + i + "]/td[6]/span"))
						.click();
				log("Clicked on activation link in Yearly fee group in grid");
				Thread.sleep(1000);
				//break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void minimizeAndMaximize_YearlyFeeGroup() throws Exception {
		if (btnMin_MaxYearlyFeeGroup.isDisplayed()) {
			btnMin_MaxYearlyFeeGroup.click();
			log("clicked on Yearly Fee Group minimize and maximize button and object is:-"
					+ btnMin_MaxYearlyFeeGroup.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Yearly Group button element not present.");
			Thread.sleep(500);
		}
	}

	public void minimizeAndMaximize_YearlyGroupFeeGrGridView() throws Exception {
		if (btnMin_MaxYearlyGroupFeeGrGridView.isDisplayed()) {
			btnMin_MaxYearlyGroupFeeGrGridView.click();
			log("Master Group Fee Group grid table data minimize and maximize and object is:-"
					+ btnMin_MaxYearlyGroupFeeGrGridView.toString());
			Thread.sleep(1000);
		} else {
			log("MinMax Yearly Fee Group grid button element not present.");
			Thread.sleep(500);
		}
	}
	public void sortBy_YearlyFeeGroupName() throws Exception {
		if (btnSortByFeeGroupName_YearlyGr.isDisplayed()) {
			btnSortByFeeGroupName_YearlyGr.click();
		log("Sorted the record with Fee Group name and object is:-" + btnSortByFeeGroupName_YearlyGr.toString());
		Thread.sleep(2000);
	} else {
		log("Sort element not present.");
		Thread.sleep(500);
	}
	}
}
