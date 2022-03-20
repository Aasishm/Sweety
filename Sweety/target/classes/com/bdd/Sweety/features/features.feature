Feature: Sweety Application Feature

  @loginTests
  Scenario: Login Page Tests
    Given User logs into the application with incorrect password
    Then User logs into the application with incorrect username
    * User logs into the application with correct credentials
    Then Close the browser
    
    @levelEntryTests
    Scenario: Level Entry Tests
    * User logs into the application with correct credentials
    Then User navigates to "Levels" Tab
    #Then User enters "blank" value for glucose level
    #Then User enters "negative" value for glucose level
    #Then User enters "zero" value for glucose level
    Then User enters "acceptible" value for glucose level
    Then User enters values more than 4 times
    Then Close the browser
    
    @reportTests
    Scenario: Report Tests
    * User logs into the application with correct credentials
    Then User navigates to "Reports" Tab
    Then Check if daily report data values match with expected values
    Then Close the browser
    
    