package Lydia.LydiaMobilelUI.pages;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import javax.sound.midi.Sequence;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import java.util.Map;
import java.util.NoSuchElementException;

public class SearchPage {
    private static AndroidDriver driver;
    
    public SearchPage(AndroidDriver driver) { this.driver = driver; }

    public static void searchWithCity() throws InterruptedException {
    	
    	// Type <Lydia> city and choose it from list appears  
    	
        WebElement input = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Search Wikipedia\")"));
        input.click();
        input.clear();
        input.sendKeys("Lydia");
        
        Thread.sleep(3000);
        
        WebElement choose_city = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Ancient Anatolian kingdom\")"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        choose_city.click();
        Thread.sleep(3000);

    }
    
    
    private final static By popupLocator = By.id("org.wikipedia.alpha:id/container");
    
    private final static By closeButtonLocator = AppiumBy.accessibilityId("Close");
    
    public static boolean dismissPopupIfPresent() throws InterruptedException  {
        
    	
    	final int TIMEOUT_SECONDS = 5; 
    	
        // Use WebDriverWait for explicit, intelligent waiting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        
        System.out.println("Checking for conditional popup presence...");
        
        try {

        Thread.sleep(2000);
        // Wait for the main popup element to be visible/present.
       
        WebElement popupElement = wait.until(ExpectedConditions.presenceOfElementLocated(popupLocator));
            
        System.out.println("Popup detected! Attempting to locate and click the close button.");
        
        //Locate and click the close button inside the popup.
      
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator));
        closeButton.click();
        
        Thread.sleep(2000);
        
        System.out.println("Close button clicked. Popup dismissed successfully.");
		return true;
        

        } catch (TimeoutException e) {
            // 3. IF POPUP DOES NOT APPEAR: TimeoutException is caught, and we continue the next step.
            System.out.println("Popup did not appear within " + TIMEOUT_SECONDS + " seconds. Continuing to the next step.");
            return false;
            
        }
        
        
       

}

    

public static void ValidationCity() {

	
	
	//Validation of Lydia city page 

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	By lydiaTextValidate = AppiumBy.androidUIAutomator("new UiSelector().text(\"Lydia\").instance(0)");
	
	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(lydiaTextValidate)).isDisplayed(), "Lydia not visible after changing language");

  
}

}

