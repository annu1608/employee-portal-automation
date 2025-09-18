package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class FullRawCode extends BaseTest{
	
	
		@Test
		public void orangehrmFullFlow() {
			
//Login
		       driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
               driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
               driver.findElement(By.cssSelector("button[type='submit']")).click();
 // Dashboard
		       driver.findElement(By.xpath("//span[text()='My Info']")).click();
		       driver.findElement(By.xpath("//a[text()='Contact Details']")).click();
		       driver.findElement(By.xpath("//label[text()='Street 1']/../following-sibling::div/input"))
		                .sendKeys("123 Test Street");
		        driver.findElement(By.xpath("//label[text()='Street 2']/../following-sibling::div/input"))
		                .sendKeys("Apt 45");
		        driver.findElement(By.xpath("//label[text()='City']/../following-sibling::div/input"))
		                .sendKeys("Mumbai");
		        driver.findElement(By.xpath("//label[text()='State/Province']/../following-sibling::div/input"))
		                .sendKeys("Maharashtra");
		        driver.findElement(By.xpath("//label[text()='Zip/Postal Code']/../following-sibling::div/input"))
		                .sendKeys("400001");
		        
		        WebElement countryDropdown = driver.findElement(By.xpath("//div[@class='oxd-select-text--after']"));
		        countryDropdown.click();
		        WebElement indiaOption = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='India']"));
		        indiaOption.click();  
		        
		        driver.findElement(By.xpath("//label[text()='Mobile']/../following-sibling::div/input"))
		                .sendKeys("9876543210");
                driver.findElement(By.xpath("//button[@type='submit']")).click();
		       
//  Change Password
	            
		        WebElement profileName = driver.findElement(By.className("oxd-userdropdown-name"));
		        System.out.println(profileName.getText());
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		         WebElement userDrop = wait.until(
	                ExpectedConditions.elementToBeClickable(By.cssSelector("p.oxd-userdropdown-name"))
	            );
	            userDrop.click();
	            wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//a[normalize-space()='Change Password']"))).click();

	                    driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("admin123");
	                    driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("admin@123"); 
	                    driver.findElement(By.xpath("(//input[@type='password'])[3]")).sendKeys("admin@123");
	 
	        driver.findElement(By.cssSelector("button[type='submit']")).click();
//logOut	        
	       driver.findElement(By.className("oxd-userdropdown-name")).click();
	       WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//a[normalize-space()='Logout']")));
	            logoutBtn.click();
	        
		        
}}
