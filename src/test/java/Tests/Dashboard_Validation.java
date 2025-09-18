package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import EmployeeTracker.PageObjects.DashboardPage;
import testComponents.BaseTest;

public class Dashboard_Validation extends BaseTest{
	
	@Test
	public void verifyDashboardNavigation() {
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		loginPage.loginCredential("Admin", "admin123");
		
		 dashboardPage.goToMyInfoSection();
		 dashboardPage.fillAddress("123 Street", "45 aprt", "amroha","Up","400400" );
		 dashboardPage.selectCounty();
		 dashboardPage.fillContactDetails("123456", "456789", "789123");
		 dashboardPage.fillEmailDetails("admin@example.com", "test@example.com");
		 dashboardPage.clickToSaveDetalis();
		 String toastMessage= dashboardPage.fetchToastMessage();
		 
		Assert.assertEquals(toastMessage, "Success - Successfully Updated", "Toast message mismatch!");
		
	}

}
