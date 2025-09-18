package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import EmployeeTracker.PageObjects.ChangePasswordPage;
import testComponents.BaseTest;

public class ChangePassword_Validation extends BaseTest {
	
	@Test
	public void testSuccessfulPasswordChange(){
		
		
		ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
		
		loginPage.loginCredential("Admin", "admin123");
		changePasswordPage.clickToDropDown();
		String passwordType= changePasswordPage.changePasswordDetails("admin123", "admin@123", "admin@123");
		
		Assert.assertTrue(
			    passwordType.equalsIgnoreCase("Very Weak") 
			    || passwordType.equalsIgnoreCase("Better") 
			    || passwordType.equalsIgnoreCase("Strongest"),
			    "Password strength mismatch! Expected Very Weak/Better/Strong but found: " + passwordType
			);
		
		changePasswordPage.savePasswordClick();
		String toastMessage =changePasswordPage.captureToastMessage();
		Assert.assertEquals(toastMessage, "Success - Successfully Saved", "Toast message mismatch!");
		
	}

}
