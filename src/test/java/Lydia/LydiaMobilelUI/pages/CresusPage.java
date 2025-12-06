package Lydia.LydiaMobilelUI.pages;



import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CresusPage {
	
private static AndroidDriver driver;
    
    public CresusPage(AndroidDriver driver) { this.driver = driver; }

    public static void clickCresusLinkAndNavigateToNewPage() throws InterruptedException {
    	
    	final int TIMEOUT_SECONDS = 10; 
    	 
 	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
    	
    	// Click on cresus link 
    	
    	By cresusLinkLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Crésus\")");
   	 
	 	 	
	 	WebElement cresusLinkElement = wait.until(ExpectedConditions.elementToBeClickable(cresusLinkLocator));

	 	Thread.sleep(TIMEOUT_SECONDS);
	 	
	 	cresusLinkElement.click();
    	
    	
    	// Navigate to new page
	 	

    	By newPageLocator = By.id("org.wikipedia.alpha:id/link_preview_secondary_button");
   	 
	 	 	
	 	WebElement newPageElement = wait.until(ExpectedConditions.elementToBeClickable(newPageLocator));

	 	
	 	newPageElement.click();
	 	
	 	Thread.sleep(5000);
	 	
	 	//click on Tab to navigate to new page
	 	
	 	By newTabLocator = By.id("org.wikipedia.alpha:id/tabsCountText");
	   	 
 	 	
	 	WebElement newTabElement = wait.until(ExpectedConditions.elementToBeClickable(newTabLocator));

	 	
	 	newTabElement.click();
	 	
	 	Thread.sleep(5000);
	 	
	 	By navigateCresusPageLocator = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"org.wikipedia.alpha:id/tabContainer\").instance(1)");
	   	 
 	 	
	 	WebElement navigateCresusPageElement = wait.until(ExpectedConditions.elementToBeClickable(navigateCresusPageLocator));

	 	
	 	navigateCresusPageElement.click();
	 	
	 	//Validation of newly opened page with text <Cresus>
	 
	 	
	 	//WebElement cresusPageValidationElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Crésus\").instance(0)"));
	    
	    //assert cresusPageValidationElement.isDisplayed() :"Cresus text visible on newly opened page ";
	 	
	   
		
		By cresusPageValidationElement = AppiumBy.androidUIAutomator("new UiSelector().text(\"Crésus\").instance(0)");
		
		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(cresusPageValidationElement)).isDisplayed(), "Crésus not visible after navigating cresus page");

	  
	 	
	 	
	 	
	 	
	 	
    	
   
        
    }
}