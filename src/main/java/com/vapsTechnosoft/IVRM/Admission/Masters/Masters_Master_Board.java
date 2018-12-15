/**
 * 
 */
package com.vapsTechnosoft.IVRM.Admission.Masters;

import static org.testng.Assert.assertEquals;

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

import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class Masters_Master_Board extends TestBase {

	public static final Logger log = Logger.getLogger(Masters_Master_Board.class.getName());

	WebDriver driver;
	Select select;
	Actions oAction;
	Robot robot;
	WebElement option;

	@FindBy(xpath = "(//aside[@id='style-4']/section/ul/li)[1]")
	WebElement btnHome;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button")
	WebElement btn_Admission;

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]")
	WebElement btnAdmission_Masters;

	// @FindBy(xpath =
	// "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[22]")
	// WebElement btnMasters_masterBoard;

	@FindBy(xpath = "//a[@href='#/app/masterboard/34']")
	WebElement btnMasters_masterBoard;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterBoardMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "//input[@name='name']")
	WebElement input_BoardName;

	@FindBy(xpath = "//textarea[@name='desc']")
	WebElement input_BoardDescription;

	@FindBy(xpath = "//input[@ng-model='searchValue']")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByBoardName;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> list_BoardName;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnOKSuccess;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/div/button")
	WebElement btnYesDeleteOrDeactIt;

	@FindBy(xpath = "//body[@id='style-4']/div[5]/div[7]/button")
	WebElement btnCancel;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[1]")
	WebElement btnMin_MaxMasterBoard;

	@FindBy(xpath = "(//button[@class='btn btn-box-tool'])[2]")
	WebElement btnMin_MaxMasterBoardList;

	@FindBy(xpath = "//h2")
	WebElement validate_PopUpText;

	public Masters_Master_Board(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeButton() {
		try {
			btnHome.isDisplayed();
			log("Home button is dispalyed and object is:-" + btnHome.toString());
			Thread.sleep(2000);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * Navigate to Admission Masters Master Board
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterBoard_BGHS() throws Exception {
		clickOnButton(btn_Admission);
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());

		clickOnButton(btnAdmission_Masters);
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());

		clickOnButton(btnMasters_masterBoard);
		log("Clicked on master Board Button and object is:-" + btnMasters_masterBoard.toString());

	}

	/**
	 * Validation of masters master document screen message
	 * 
	 * @return
	 */
	public boolean verifyMasters_MasterBoard_BGHSPage() {
		try {
			System.out.println(txtMasters_MasterBoardMsgDispaly.getText());
			txtMasters_MasterBoardMsgDispaly.isDisplayed();
			log("Master Board page is dispalyed and object is:-" + txtMasters_MasterBoardMsgDispaly.toString());
			Thread.sleep(1000);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void enterMasterBoardData(String boardName, String boardDescription) throws Exception {

		inputTextIntoInputField(input_BoardName, boardName);
		log("Entered board name " + boardName + " and object is:-" + input_BoardName.toString());

		inputTextIntoInputField(input_BoardDescription, boardDescription);
		log("Entered board discription " + boardDescription + " and object is:-" + input_BoardDescription.toString());

	}

	public void submitBlankMasterBoardForm() throws Exception {

		clickOnButton(btnSave);
		log("Submit blank master Board form and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}

	public void clearBoardInfoData() throws Exception {

		clickOnButton(btnCancelClear);
		log("Clicked on cancel button to clear filled Board info and object is:-" + btnCancelClear.toString());

	}

	public void saveBoardInfoData() throws Exception {
		clickOnButton(btnSave);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on save button to save filled Board info and object is:-" + btnSave.toString());

	}

	public void minimizeMasterBoard() throws Exception {

		clickOnButton(btnMin_MaxMasterBoard);
		log("clicked on master Board minimize button and object is:-" + btnMin_MaxMasterBoard.toString());

	}

	public void maximizeMasterBoard() throws Exception {

		clickOnButton(btnMin_MaxMasterBoard);
		log("clicked on master Board maximize button and object is:-" + btnMin_MaxMasterBoard.toString());

	}

	public void minimizeMasterBoardList() throws Exception {

		clickOnButton(btnMin_MaxMasterBoardList);
		log("Master Board list table data minimize and object is:-" + btnMin_MaxMasterBoardList.toString());

	}

	public void maximizeMasterBoardList() throws Exception {

		clickOnButton(btnMin_MaxMasterBoardList);
		log("Master Board list table table data maximized and object is:-" + btnMin_MaxMasterBoardList.toString());

	}

	public void clickOnOkSuccessButton() throws Exception {

		clickOnButton(btnOKSuccess);
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());

	}

	public void sortByBoardName() throws Exception {

		clickOnButton(btnSortByBoardName);
		SortData_InColumn_DescendingOrder(list_BoardName);
		log("Sorted the record with Board name in Descending Order and object is:-" + btnSortByBoardName.toString());

	}

	public void searchWithBoardNameInTheGrid(String boardName) {

		inputTextIntoInputField(inputSearch, boardName);
		log("Entered Board name to search: " + boardName + " and object is:-" + inputSearch.toString());
	}

	public void verifyBoardNameInTheGrid(String boardName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String boardname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Board Name: " + boardname);
				// Thread.sleep(2000);

				if (boardname.equals(boardName)) {
					Assert.assertEquals(boardname, boardName);
					log("Board name created is updated in the record grid.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editMasterBoard(String boardName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String boardname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Board Name: " + boardname);
				// Thread.sleep(2000);

				if (boardname.equalsIgnoreCase(boardName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the edit link in the master board list grid to edit record");

					break;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMasterBoard(String boardName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		try {
			for (int i = 1; i <= rows; i++) {

				String boardname = driver
						.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
				System.out.println("Board Name: " + boardname);
				// Thread.sleep(2000);

				if (boardname.equalsIgnoreCase(boardName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(2000);
					log("Clicked on the delete link in the master board list grid to delete record");

					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {

		clickOnButton(btnYesDeleteOrDeactIt);
		Thread.sleep(3000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());

	}

	public void clickOnCancelButton() throws Exception {

		clickOnButton(btnCancel);
		Thread.sleep(2000);
		assertEquals(btnOKSuccess.getText().trim(), "OK");
		log("Clicked on cancel button and object is:-" + btnCancel.toString());

	}

	public void popWindowMessage_SubmitSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Saved Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void popWindowMessage_SubmitSuccessfully_Edit() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Updated Successfully");
			log("Record submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void popWindowMessage_DeleteCancel_Validation() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Cancelled");
			log("Record Delete Cancelled message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void popWindowMessage_DeletedSuccessfully() throws Exception {
		try {
			validate_PopUpText.isDisplayed();
			String text = validate_PopUpText.getText().trim();
			assertEquals(text, "Record Deleted Successfully");
			log("Record delete submitted sucessfully message validated.");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
