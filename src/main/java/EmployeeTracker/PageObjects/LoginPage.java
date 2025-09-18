package EmployeeTracker.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement EnterUseName ;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement EnterPassword ;
	
	@FindBy(css="button[type='submit']")
	WebElement LoginButton ;
	
	@FindBy(xpath="//h6[normalize-space()='Dashboard']")
	WebElement dashboard ;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement errorMsg ;
	
   public void goToLink() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	
	public void userNameFiled(String userName) {
		
		EnterUseName.sendKeys(userName);	
	}
	
    public void userPasswordFiled(String userPassword) {
		
    	EnterPassword.sendKeys(userPassword);	
	}
    
    public void clickLoginButton() {
		
    	LoginButton.click();
	}

    public String getDashboard() {
    
    	String	DashboardPage=dashboard.getText();
        return DashboardPage;
    }
    
    public String getErrorMsg() {
    	
    	return errorMsg.getText();
    }
    
    
    public void loginCredential(String userId, String loginPassword) {
    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    	EnterUseName.sendKeys(userId);
    	EnterPassword.sendKeys(loginPassword);	
    	LoginButton.click();
    	
	}
    
}
