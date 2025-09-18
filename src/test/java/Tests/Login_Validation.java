package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class Login_Validation extends BaseTest{

	
	@Test
	public void validateLogoinFunctionality() {
		
	    loginPage.goToLink();
		loginPage.userNameFiled("Admin");
		loginPage.userPasswordFiled("admin123");
		loginPage.clickLoginButton();
		String	pageOpen = loginPage.getDashboard();
		
		Assert.assertEquals(pageOpen, "Dashboard", "Login failed or wrong user logged in!");
		
	}
	
	@Test
	public void validateLoginWithInvalidDetalis() {
		
		    loginPage.goToLink();
			loginPage.userNameFiled("Admin");
			loginPage.userPasswordFiled("123456@abcd");
			loginPage.clickLoginButton();
			String readErrorMessage = loginPage.getErrorMsg();
			
			Assert.assertEquals(readErrorMessage, "Invalid credentials", "Check userName or Password");
			
		
		
	}
	
}
