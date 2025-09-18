package EmployeeTracker.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponent.ReusableUtils;

public class ChangePasswordPage {

	 WebDriver driver;
	  ReusableUtils actions;

	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new ReusableUtils(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="p.oxd-userdropdown-name")
	WebElement userDrop ;
	
	@FindBy(xpath="//a[normalize-space()='Change Password']")
	WebElement changePasswordOption;
        
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement currentPasswordOption;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement newPasswordOption;
        
	@FindBy(xpath="(//input[@type='password'])[3]")
	WebElement confirmPasswordOption;
	
	@FindBy(xpath="//span[contains(@class,'oxd-chip') and contains(@class,'--strength-better')]")
	WebElement passwordType;
   
	@FindBy(css="button[type='submit']")
	WebElement savePasswordButton;
  
	@FindBy(xpath = "//p[text()='Succesfully Saved']")
	WebElement toastMsg;
	
	
	public void clickToDropDown() {
		userDrop.click();
		actions.waitForVisibility(changePasswordOption);
		changePasswordOption.click();
	}
  
    public String changePasswordDetails(String currentPassword, String newPassword, String confirmPassword) {
    	actions.setInputField(currentPasswordOption, currentPassword);
    	actions.setInputField(newPasswordOption, newPassword);
    	actions.setInputField(confirmPasswordOption, confirmPassword);
    	String typeOfPassword = passwordType.getText();
    	return typeOfPassword;
    }
    	
    
    public void savePasswordClick() {
    	savePasswordButton.click();
    	
    }
    
    public String getToastMsg() {
    	String Message =toastMsg.getTagName();
    	return Message;
    }
    
    
    public String captureToastMessage(){
		
		return actions.getToastText();
	}
    
}
