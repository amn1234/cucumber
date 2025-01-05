Feature: Login functionality

  Scenario: Valid user login
    Given the user is on the login page
    When the user enters a valid username and password
    Then the user should be logged in successfully

  Scenario: Invalid user login
    Given the user is on the login page
    When the user enters an invalid username and password
    Then the user should see an error message