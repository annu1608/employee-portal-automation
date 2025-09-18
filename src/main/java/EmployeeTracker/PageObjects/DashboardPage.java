package EmployeeTracker.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponent.ReusableUtils;

public class DashboardPage {

	 WebDriver driver;

	  ReusableUtils actions;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.actions=new ReusableUtils(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Info']")
	WebElement MyInfoButton ;
	
	@FindBy(xpath="//a[text()='Contact Details']")
	WebElement contactDetalisButton ;
	
	@FindBy(xpath="//label[text()='Street 1']/../following-sibling::div/input")
	WebElement enterStreet1 ;
	
	@FindBy(xpath="//label[text()='Street 2']/../following-sibling::div/input")
	WebElement enterStreet2 ;

	@FindBy(xpath="//label[text()='City']/../following-sibling::div/input")
	WebElement enterCity ;
	
	@FindBy(xpath="//label[text()='State/Province']/../following-sibling::div/input")
	WebElement enterState ;

	@FindBy(xpath="//label[text()='Zip/Postal Code']/../following-sibling::div/input")
	WebElement enterZipCode ;
	
	@FindBy(xpath="//div[@class='oxd-select-text--after']")
	WebElement countyDropdown ;
    
	@FindBy(xpath="//div[@role='listbox']//span[text()='India']")
	WebElement indiaOption ;
	
	@FindBy(xpath="//label[text()='Home']/../following-sibling::div/input")
	WebElement homePhoneNum;

	@FindBy(xpath="//label[text()='Mobile']/../following-sibling::div/input")
	WebElement mobilePhoneNum;

	@FindBy(xpath="//label[text()='Work']/../following-sibling::div/input")
	WebElement workPhoneNum;

	// Email section
	@FindBy(xpath="//label[text()='Work Email']/../following-sibling::div/input")
	WebElement workEmail;

	@FindBy(xpath="//label[text()='Other Email']/../following-sibling::div/input")
	WebElement otherEmail;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	
    
	public void goToMyInfoSection() {
		MyInfoButton.click();
		contactDetalisButton.click();
	   }
	
	
	public void fillAddress(String street1, String street2, String city, String state, String zipCode) {
		actions.setInputField(enterStreet1, street1);
		actions.setInputField(enterStreet2, street2);
		actions.setInputField(enterCity, city);
		actions.setInputField(enterState, state);
		actions.setInputField(enterZipCode, zipCode); 
	}
	
	
	
	 public void selectCounty() {
		 countyDropdown.click();
		 indiaOption.click();
	 }
   
    public void fillContactDetails(String houseNum, String mobileNum, String workNum) {
    	
    	 actions.setInputField(homePhoneNum, houseNum);
    	 actions.setInputField(mobilePhoneNum, mobileNum);
    	 actions.setInputField(workPhoneNum, workNum);
    	 
    }
    
    public void fillEmailDetails(String email, String OtherEmail)  {
    	
    	actions.setInputField(workEmail, email);
    	actions.setInputField(otherEmail, OtherEmail);
    	   }
    
	 

    public void clickToSaveDetalis() {
    	
    	saveButton.click();
    }
   
	public String  fetchToastMessage() {
		
		return actions.getToastText();
	}
}
