package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import EmployeeTracker.PageObjects.LogoutPage;
import testComponents.BaseTest;

public class Logout_Validation extends BaseTest {

	
	@Test
	public void validateLogoutFunctionality() {
		
		LogoutPage logoutPage = new LogoutPage(driver);
		loginPage.loginCredential("Admin", "admin123");
		
		logoutPage.clickToLogoutButoon();
		String pageTitle=logoutPage.backToLoginPage();
		
		 Assert.assertEquals(pageTitle, "Login", 
	            "User did not navigate back to Login page after logout!");
		
		
	}
	
	
}
