package EmployeeTracker.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponent.ReusableUtils;

public class LogoutPage {

	 WebDriver driver;
	 ReusableUtils actions;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new ReusableUtils(driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(className="oxd-userdropdown-name")
	WebElement clickToDropdown ;
	
	@FindBy(css=".oxd-text.oxd-text--h5.orangehrm-login-title")
	WebElement loginPage ;

	
	 public void clickToLogoutButoon() {
		 
		 clickToDropdown.click();
		 
		 By logoutBtnLocator = By.xpath("//a[normalize-space()='Logout']");
		 WebElement logoutBtn = actions.waitForVisibleElement(logoutBtnLocator);
		 logoutBtn.click();
	 }
	 
	 public String backToLoginPage() {
		 
		String PageTitle= loginPage.getText();
		return PageTitle;
	 }
     
}
