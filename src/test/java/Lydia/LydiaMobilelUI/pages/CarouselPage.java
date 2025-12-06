package Lydia.LydiaMobilelUI.pages;



//Xpath, id, accessibility, classname, androidUIAutomator

import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;


public class CarouselPage {
    private static AndroidDriver driver;
    
    public CarouselPage(AndroidDriver driver) { this.driver = driver; }

    // Locators
    
    
    private final static By continueButton = By.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"); 
    private final static By lastIndicatorActive = By.id("org.wikipedia.alpha:id/fragment_onboarding_done_button");

  
    // Swipe the carousel

	public static void swipeCarouselToFinish() {
        int maxSwipes = 10; 
     
        while (maxSwipes-- > 0 && driver.findElements(lastIndicatorActive).isEmpty()) {
       
            performSwipe();
        }
    }

    private static void performSwipe() {
    	 int width = driver.manage().window().getSize().width;
         int height = driver.manage().window().getSize().height;

         int startX = (int)(width * 0.8);
         int endX   = (int)(width * 0.2);
         int y      = (int)(height * 0.5);

      
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        
     
        Sequence swipe = new Sequence(finger, 1);
        
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg())) ;
        swipe.addAction(new Pause(finger, Duration.ofMillis(500))); // Wait for interaction
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Execute the action
        driver.perform(ImmutableList.of(swipe));
    }
    
    public static void getStarted() {
    	
    	 // Click on Get Started
        driver.findElement(lastIndicatorActive).click();
        
        }
    
    private final static By popupLocator = By.id("org.wikipedia.alpha:id/container");
    
    private final static By closeButtonLocator = AppiumBy.accessibilityId("Close");
    
    public static boolean dismissPopupIfPresent()  {
        
    	
    	final int TIMEOUT_SECONDS = 5; 
    	
        // Use WebDriverWait for explicit
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        
        System.out.println("Checking for conditional popup presence...");
        
        try {

        //Wait for the main popup element to be visible/present.
       
        WebElement popupElement = wait.until(ExpectedConditions.presenceOfElementLocated(popupLocator));
            
     
        System.out.println("Popup detected! Attempting to locate and click the close button.");
        
        //Locate and click the close button inside the popup.
     
        
      
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator));
        closeButton.click();
        
        System.out.println("Close button clicked. Popup dismissed successfully.");
		return true;
        

        } catch (TimeoutException e) {
            //IF POPUP DOES NOT APPEAR: TimeoutException is caught, and we continue the next step.
            System.out.println("Popup did not appear within " + TIMEOUT_SECONDS + " seconds. Continuing to the next step.");
            return false;
            
        }catch (Exception e) {
            System.err.println("Error during popup handling: " + e.getMessage());
            return false;
        }
        
        
        }
   
    	
}
    
