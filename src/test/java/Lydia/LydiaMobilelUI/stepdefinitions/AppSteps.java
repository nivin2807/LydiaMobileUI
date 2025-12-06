package Lydia.LydiaMobilelUI.stepdefinitions;


import java.net.MalformedURLException;
import java.sql.DriverManager;

import org.junit.Test;

import Lydia.Driver.DriverFactory;
import Lydia.LydiaMobilelUI.pages.LanguageSettings;
import Lydia.LydiaMobilelUI.pages.SearchPage;
import Lydia.LydiaMobilelUI.pages.CarouselPage;
import Lydia.LydiaMobilelUI.pages.CresusPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AppSteps {

	private AndroidDriver driver;
    private CarouselPage carouselPage;
    private SearchPage searchPage;
    private LanguageSettings languageSettings;
    private CresusPage cresusPage;

    @Given("Launch the app")
    public void Launch_the_app() throws MalformedURLException {
    	 driver = DriverFactory.setupDriver();
    	 carouselPage = new CarouselPage(driver);
    	
         searchPage = new SearchPage(driver);
         languageSettings = new LanguageSettings(driver);
         cresusPage = new CresusPage(driver);
    	 
    
    }

    @When("I swipe through the welcome carousel until the last image")
    public void i_swipe_through_the_welcome_carousel_until_the_last_image() {
    	CarouselPage.swipeCarouselToFinish();
    	CarouselPage.getStarted();
    	CarouselPage.dismissPopupIfPresent();
    }

    
    @And("I search for Lydia city")
    public void i_search_for_Lydia_city() throws InterruptedException {
    	SearchPage.searchWithCity();
           
    }
    
    
    @And("I scroll until Lydia city is found and dismiss any popups")
    public void i_scroll_until_Lydia_city_in_the_results_and_dismiss_any_popups() throws InterruptedException {
    	 SearchPage.dismissPopupIfPresent();
         SearchPage.ValidationCity();
    }

    
    @And("I change the website language to French")
    public void i_change_the_website_language_to_french() throws InterruptedException {
    	LanguageSettings.clickLanguageSettings();
    	LanguageSettings.searchFrench();
    }

  
    @And("I scroll down to the bottom of the page")
    public void i_scroll_down_to_the_bottom_of_the_page() throws InterruptedException {
    	LanguageSettings.scrollToBottom();
    }

    @Then("I click on Crésus link and navigate to the new page")
    public void i_click_on_crésus_link_and_navigate_to_the_new_page() throws InterruptedException {
    	CresusPage.clickCresusLinkAndNavigateToNewPage();
     
    }
    
    @After
    public void tearDown() 
    {
        DriverFactory.teardownDriver();
    }
    
    
   /* 
    @After
    public void tearDown() {
        DriverFactory.teardownDriver();
    }*/
}