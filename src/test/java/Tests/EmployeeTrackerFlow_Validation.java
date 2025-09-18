package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import EmployeeTracker.PageObjects.ChangePasswordPage;
import EmployeeTracker.PageObjects.DashboardPage;
import EmployeeTracker.PageObjects.LogoutPage;
import testComponents.BaseTest;

public class EmployeeTrackerFlow_Validation extends BaseTest{
	
	@Test
	public void verifyUserAppFlow() {
		
		loginPage.goToLink();
		loginPage.userNameFiled("Admin");
		loginPage.userPasswordFiled("admin123");
		loginPage.clickLoginButton();
		String	pageOpen = loginPage.getDashboard();
		Assert.assertEquals(pageOpen, "Dashboard", "Login failed or wrong user logged in!");
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		 dashboardPage.goToMyInfoSection();
		 dashboardPage.fillAddress("123 Street", "45 aprt", "amroha","Up","400400" );
		 dashboardPage.selectCounty();
		 dashboardPage.fillContactDetails("123456", "456789", "789123");
		 dashboardPage.fillEmailDetails("annu@gmail.com", "amit@gmail.com");
		 dashboardPage.clickToSaveDetalis();
		 String saveToastMessage= dashboardPage.fetchToastMessage();
		 
		Assert.assertEquals(saveToastMessage, "Success - Successfully Updated", "Toast message mismatch!");
		
		ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
	    changePasswordPage.clickToDropDown();
		String passwordType= changePasswordPage.changePasswordDetails("admin123", "admin@123", "admin@123");
		
		Assert.assertTrue(
			    passwordType.equalsIgnoreCase("Very Weak") 
			    || passwordType.equalsIgnoreCase("Better") 
			    || passwordType.equalsIgnoreCase("Strongest"),
			    "Password strength mismatch! Expected Very Weak/Better/Strong but found: " + passwordType
			);
		
		changePasswordPage.savePasswordClick();
		String passwordToastMessage =changePasswordPage.captureToastMessage();
		Assert.assertEquals(passwordToastMessage, "Success - Successfully Saved", "Toast message mismatch!");
		
		LogoutPage logoutPage = new LogoutPage(driver);
		
		logoutPage.clickToLogoutButoon();
		String pageTitle=logoutPage.backToLoginPage();
		
		 Assert.assertEquals(pageTitle, "Login", 
	            "User did not navigate back to Login page after logout!");
	}
	
}
