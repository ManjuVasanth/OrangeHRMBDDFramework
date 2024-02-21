@GetCEOName
Feature: This feature is to get the CFO name from the OrangeHRM website

  Scenario Outline: This test is to verify CFO name
    Given the user is logged in successfully and is on Home Page
    When the user clicks the directory option from the Menu bar
    And the user selects the job title as "Chief Financial Officer" from the drop down
    And clicks the search button
    Then the user should see the CFO name as "Peter Mac Anderson"


