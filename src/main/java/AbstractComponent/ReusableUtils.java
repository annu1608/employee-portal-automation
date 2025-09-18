package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableUtils {
	
	
	 WebDriver driver;
	
	public ReusableUtils(WebDriver driver) {
		
		this.driver= driver;
	}
	
	public void setInputField(WebElement element, String value) {
		    element.click();                   
		    element.sendKeys(Keys.CONTROL + "a");  
		    element.sendKeys(Keys.DELETE);         
		    element.sendKeys(value);   
	}
	
	 
	
	public void waitForClickable(WebElement element){
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
  	  wait.until(ExpectedConditions.elementToBeClickable(element));
  	
  }
	
	public WebElement waitForVisibleElement(By locator) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
	public WebElement waitForVisibility(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	    return wait.until(ExpectedConditions.visibilityOf(element));
	}

	 public String getToastText(){
			
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
          By toastLocator = By.xpath("//div[contains(@class,'oxd-toast-content')]");
		    WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));

		    String title = toast.findElement(By.xpath(".//p[1]")).getText();
		    String message = toast.findElement(By.xpath(".//p[2]")).getText();
		    wait.until(ExpectedConditions.invisibilityOf(toast));
            return title + " - " + message;
	}
    
	
}
	
	
	
	
	
	
	





