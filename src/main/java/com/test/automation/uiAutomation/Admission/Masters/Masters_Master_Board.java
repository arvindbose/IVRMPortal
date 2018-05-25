/**
 * 
 */
package com.test.automation.uiAutomation.Admission.Masters;

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
public class Masters_Master_Board extends TestBase{
	
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

	@FindBy(xpath = "//span[contains(text(),'Admission')]/preceding-sibling::button/following::span[contains(text(),'Masters')][1]/following::li[22]")
	WebElement btnMasters_masterBoard;

	@FindBy(xpath = "//body[@id='style-4']/ui-view/div[1]/div/section/ol/li")
	WebElement txtMasters_MasterBoardMsgDispaly;

	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnSave;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/parent::button")
	WebElement btnCancelClear;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[1]")
	WebElement input_BoardName;

	@FindBy(xpath = "//textarea[@name='desc']")
	WebElement input_BoardDescription;

	@FindBy(xpath = "(//body[@id='style-4']//div/input)[3]")
	WebElement inputSearch;

	@FindBy(xpath = "//div[@class='box-body']/table/tbody/tr")
	List<WebElement> tblRows;

	@FindBy(xpath = "//div[@class='box-body']/table/thead/tr/th[2]/a")
	WebElement btnSortByBoardName;

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

	public Masters_Master_Board(WebDriver driver) {
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

	/**
	 * Navigate to Admission Masters Master Board
	 * 
	 * @throws Exception
	 */
	public void navigateToAdmission_Masters_MasterBoard_BGHS() throws Exception {
		btn_Admission.click();
		log("Clicked on admission Button and object is:-" + btn_Admission.toString());
		waitForElement(driver, 10, btnAdmission_Masters);
		
		btnAdmission_Masters.click();
		log("Clicked on Masters Button and object is:-" + btnAdmission_Masters.toString());
		waitForElement(driver, 10, btnMasters_masterBoard);
				
		btnMasters_masterBoard.click();
		log("Clicked on master Board Button and object is:-" + btnMasters_masterBoard.toString());
		waitForElement(driver, 10, btnSave);
		
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
	
	public void enterMasterBoardData(String boardName, String boardDescription) {

		input_BoardName.clear();
		input_BoardName.sendKeys(boardName);
		log("Entered board name " + boardName + " and object is:-" + input_BoardName.toString());

		input_BoardDescription.clear();
		input_BoardDescription.sendKeys(boardDescription);
		log("Entered board discription " + boardDescription + " and object is:-"
				+ input_BoardDescription.toString());
		
		}
	
	public void submitBlankMasterBoardForm() throws Exception {

		btnSave.click();
		log("Submit blank master Board form and object is:-" + btnSave.toString());
		Thread.sleep(2000);
	}


	public void clearBoardInfoData() throws Exception {
		btnCancelClear.click();
		log("Clicked on cancel button to clear filled Board info and object is:-" + btnCancelClear.toString());
		Thread.sleep(15000);
	}

	public void saveBoardInfoData() throws Exception {
		btnSave.click();
		log("Clicked on save button to save filled Board info and object is:-" + btnSave.toString());
		Thread.sleep(15000);
	}

	public void minimizeMasterBoard() throws Exception {
		btnMin_MaxMasterBoard.click();
		log("clicked on master Board minimize button and object is:-" + btnMin_MaxMasterBoard.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterBoard() throws Exception {
		btnMin_MaxMasterBoard.click();
		log("clicked on master Board maximize button and object is:-" + btnMin_MaxMasterBoard.toString());
		Thread.sleep(2000);
	}

	public void minimizeMasterBoardList() throws Exception {

		btnMin_MaxMasterBoardList.click();
		log("Master Board list table data minimize and object is:-" + btnMin_MaxMasterBoardList.toString());
		Thread.sleep(2000);
	}

	public void maximizeMasterBoardList() throws Exception {

		btnMin_MaxMasterBoardList.click();
		log("Master Board list table table data maximized and object is:-" + btnMin_MaxMasterBoardList.toString());
		Thread.sleep(2000);
	}

	public void clickOnOkSuccessButton() throws Exception {

		btnOKSuccess.click();
		log("Clciked on Ok button for final submission and object is:-" + btnOKSuccess.toString());
		Thread.sleep(2000);
	}

	public void sortByBoardName() throws Exception {
		btnSortByBoardName.click();
		log("Sorted the record with Board name and object is:-" + btnSortByBoardName.toString());
		Thread.sleep(3000);
	}

	public void searchWithBoardNameInTheGrid(String boardName) {

		inputSearch.clear();
		inputSearch.sendKeys(boardName);
		log("Entered Board name to search: " + boardName + " and object is:-" + inputSearch.toString());
	}

	public void verifyBoardNameInTheGrid(String boardName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String boardname = driver
					.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]")).getText();
			System.out.println("Board Name: " + boardname);
			// Thread.sleep(2000);
			try {
				
				Assert.assertEquals(boardname, boardName);
				log("Board name created is updated in the record grid.");
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void editMasterBoard(String boardName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String boardname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Board Name: " + boardname);
			// Thread.sleep(2000);
			try {
				if (boardname.equalsIgnoreCase(boardName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[1]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the edit link in the master board list grid to edit record");

					break;
				} else {
					log("Board Name not matched with the master board list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void deleteMasterBoard(String boardName) {

		int rows = tblRows.size();
		System.out.println(rows);
		// Thread.sleep(2000);
		for (int i = 1; i <= rows; i++) {
			String boardname = driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println("Board Name: " + boardname);
			// Thread.sleep(2000);
			try {
				if (boardname.equalsIgnoreCase(boardName)) {

					driver.findElement(By.xpath("//div[@class='box-body']/table/tbody/tr[" + i + "]/td[4]/a[2]"))
							.click();
					Thread.sleep(5000);
					log("Clicked on the delete link in the master board list grid to delete record");

					break;
				} else {
					log("Board Name not matched with the master board list grid");
					// Thread.sleep(1000);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
	public void yesDeleteOrDeactivateOrActivateIt() throws Exception {
		btnYesDeleteOrDeactIt.click();
		log("Clicked on yes deactivate or activate or delete it button and object is:-"
				+ btnYesDeleteOrDeactIt.toString());
		Thread.sleep(15000);
	}

	public void clickOnCancelButton() throws Exception {

		btnCancel.click();
		log("Clicked on cancel button and object is:-" + btnCancel.toString());
		Thread.sleep(15000);
	}

}
