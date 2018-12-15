/**
 * 
 */
package com.vapsTechnosoft.IVRM.LoginLogOut;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.vapsTechnosoft.IVRM.testBase.TestBase;

/**
 * @author Arvind
 *
 */
public class IvrmPortalLogin extends TestBase {

	public static final Logger log = Logger.getLogger(IvrmPortalLogin.class.getName());

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//input[@id='login-username']")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='login-password']")
	private WebElement passWord;

	@FindBy(xpath = "//b[text()='Sign in ']/parent::button")
	private WebElement loginButton1;

	@FindBy(xpath = "//span[contains(text(),'Logout')]/preceding-sibling::button")
	private WebElement logoutButton;

	@FindBy(xpath = "//*[@id='style-4']/section/ul/li[1]/a/span")
	private WebElement homeButton;

	@FindBy(xpath = "//table/thead/tr/th[2]")
	private WebElement header_CCAtName;

	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> list_CCAtName;

	@FindBy(xpath = "//table/thead/tr/th")
	private List<WebElement> header;

	
	public IvrmPortalLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String username, String password) throws InterruptedException {
		waitForElement(driver, 30, userName);
		inputTextIntoInputField(userName, username);
		log("UserName entered "+username+" and object is:-"+userName.toString());
		inputTextIntoInputField(passWord, password);
		log("Password entered "+password+" and object is:-"+passWord.toString());
		clickOnButton(loginButton1);
		log("Clicked on Login button and redirected to Home page, Object is:-"+loginButton1.toString());
	}

	public boolean verifyLoginToIVRMportal() {
		try {
			System.out.println(homeButton.getText());
			isDisplayed(homeButton);
			log("Home button is dispalyed and object is:-" + homeButton.toString());

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void logOutFromApplication() throws Exception {
		clickOnButton(logoutButton);
		log("Clicked on Logout button and object is:-"+logoutButton.toString());
		
	}

	public void sortingOfElement() {
		clickOnButton(header_CCAtName);
		clickOnButton(header_CCAtName);
		SortData_InColumn_AscendingOrder(list_CCAtName);
		log("Element is sorted in Ascending order and object is:- " + list_CCAtName.toString());
	}

}
