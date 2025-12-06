package Lydia.LydiaMobilelUI.pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class LanguageSettings {
	 private static AndroidDriver driver;
	 
	 public LanguageSettings(AndroidDriver driver) { 
		 
		 this.driver = driver;
		 }
	 
    

     public static boolean clickLanguageSettings() {
    	 
    	 
         final int TIMEOUT_SECONDS = 5; 
    	 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
    	 
    	 WebElement languageTabLocator = driver.findElement(By.id("org.wikipedia.alpha:id/page_language"));
    	 
    	
    	 
    	
    	 By closeButtonLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)");
    	 
    	 By popUpLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ScrollView\")");
    	 
  	
    	 
    	 
    	 //Click on LanguageTab
      	 
    	 wait.until(ExpectedConditions.elementToBeClickable(languageTabLocator)).click();
    	
    	 // close when popup message appears
    	 
    	 
         
         System.out.println("Checking for message presence...");
         
         try {

        	 
         // Wait for the main popup element to be visible/present.
        
         WebElement popupElement = wait.until(ExpectedConditions.presenceOfElementLocated(popUpLocator));
             
    
         System.out.println("Popup detected! Attempting to locate and click the close button.");
         
         //Locate and click the close button inside the popup.
          
         
         wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator)).click();
         
         System.out.println("Close button clicked. Popup dismissed successfully.");
         
 		 return true;
         

         } catch (TimeoutException e) {
             // 3. IF POPUP DOES NOT APPEAR: TimeoutException is caught, and we continue the next step.
             System.out.println("Popup did not appear within " + TIMEOUT_SECONDS + " seconds. Continuing to the next step.");
             return false;
             
         }
         
     } 
         
         public static void searchFrench() throws InterruptedException
           {
        	    // Type French language in text box
        	 
        	   final int TIMEOUT_SECONDS = 5; 
        	 
        	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        	 
        	 	By searchButtonLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)");
        	 
        	 	By chooseFrenchLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Français\")");
        	 	
        	 	By frenchTextLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"Lydie\").instance(0)");
        	 
   
        	 	
        	 	WebElement searchFrenchElement = wait.until(ExpectedConditions.elementToBeClickable(searchButtonLocator));
       
        	 	
        	 	searchFrenchElement.click();
        
        	 	Thread.sleep(3000);
        	 	
        	 	((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.F));
        	 	((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.R));
        	 	((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.E));
        	 	((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.N));
        	 	((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.C));
        	 	((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.H));


        	 	
    
        	   
        	 	wait.until(ExpectedConditions.elementToBeClickable(chooseFrenchLocator)).click();
        	 	
        	 	//Validation of French Text <Lydie>
        	 	
        	 	assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(frenchTextLocator)).isDisplayed(), "French text not visible after changing language");

        	    
        	    
        	    
        	}
     
         

         public static void scrollToBottom() throws InterruptedException
         
         {
        	
        	 
        	 // scroll until bottom of the page
        	
        		    boolean canScrollMore = true;

        		    while (canScrollMore) {

        		        // Check if element exists → STOP scrolling
        		    	List<WebElement> footer = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().text(\"roi de Lydie et dernier souverain de la dynastie des Mermnades (vers 596-Vers 546 av. J.-C.)\")"));
        		        if (!footer.isEmpty()) {
        		            System.out.println("Footer element found → stopping scroll");
        		            break;
        		        }

        		        // Try scrolling forward
        		        try {
        		            driver.findElement(AppiumBy.androidUIAutomator(
        		                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
        		            ));
        		        } catch (Exception e) {
        		            // No more scrolling possible → bottom reached
        		            canScrollMore = false;
        		        }
        		    }
        		}

        	 
}
        		

        	
        		    
        		

      
        	 
        	
         
      
         
             


     


