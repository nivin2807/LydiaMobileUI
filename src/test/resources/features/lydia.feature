Feature: Lydia Mobile Application Testing
  As a user, I want to navigate the app, change language, and explore settings
  So that I can verify the core functionality and configuration.

  @Mobile
  Scenario: End-to-End Application Flow
    Given Launch the app
    
    # Part 1: Carousel Swipe
    When I swipe through the welcome carousel until the last image
    
    # Part 2: Search and Popup Dismissal
    And I search for Lydia city
    And I scroll until Lydia city is found and dismiss any popups
    
    # Part 3: Language Change and Scrolling
    And I change the website language to French
    And I scroll down to the bottom of the page
    
    # Part 4: Navigation to Crésus
    Then I click on Crésus link and navigate to the new page
