@timesheets
Feature: This feature is to get pending timesheet

  Scenario Outline: This test is to verify the pending timesheet
    Given the user is on the homepage
    When the user clicks on the time option from the menu
    And the user enters the name as "John Smith"
    And clicks on the View button
    Then the user should see the message as "<message>"

    Examples: 
      | message             |
      | No Timesheets Found |
