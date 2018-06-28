/**
 * 
 */
package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiAutomation.testBase.TestBase;

/**
 * @author vaps
 *
 */
public class IvrmPortalLogin extends TestBase{

public static final Logger log = Logger.getLogger(IvrmPortalLogin.class.getName());
	
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='login-username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='login-password']")
	WebElement passWord;
	
	@FindBy(xpath="//div[@class='col-xs-4']/button[1]")
	WebElement loginButton;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	WebElement logoutButton;
	
	@FindBy(xpath="//*[@id='style-4']/section/ul/li[1]/a/span")
	WebElement homeButton;
	
	public IvrmPortalLogin(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String username, String password) throws InterruptedException{
		if(userName.isDisplayed()){
		userName.sendKeys(username);
		log("entered user name:-"+username+" and object is "+userName.toString());
		Thread.sleep(2000);
		}else{
			log("UserName element not present");
		}
		if(passWord.isDisplayed()){
		passWord.sendKeys(password);
		log("entered password:-"+password+" and object is "+passWord.toString());
		Thread.sleep(10000);
		}else{
			log("Password element not present");
		}
		if(loginButton.isDisplayed()){
		loginButton.click();
		log("cliked on login button and object is:-"+loginButton.toString());
		Thread.sleep(7000);
	}else{
		log("Login button element not present");
	}
	}
	
	public boolean verifyLoginToIVRMportal() {
		try {
			System.out.println(homeButton.getText());
			homeButton.isDisplayed();
			log("Home button is dispalyed and object is:-"+homeButton.toString());
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public void logOutFromApplication() throws Exception {
		if(logoutButton.isDisplayed()){
		logoutButton.click();
		log("logout is done and object is:-"+logoutButton.toString());
		Thread.sleep(2000);
	}else{
		log("logout Button element not present");
	}
	}
}
