Feature: Login functionality

  @risk_high
  Scenario: Valid user login
    Given the user is on the login page
    When the user enters a valid username and password
    Then the user should be logged in successfully

  @risk_low
  Scenario: Invalid user login
    Given the user is on the login page
    When the user enters an invalid username and password
    Then the user should see an error message

  @risk_high
  Scenario: Update user information after login
    Given the user is on the login page
    When the user enters a valid username and password
    Then the user should be logged in successfully
    When the user updates their email to "newemail@example.com"
    Then the user information should be updated

  @risk_high
  Scenario: Check cart item count after login
    Given the user is on the login page
    When the user enters a valid username and password
    Then the user should be logged in successfully
    Then the user should see "You have 0 items in your cart" on the home page

  @risk_medium
  Scenario: Logout after login
    Given the user is on the login page
    When the user enters a valid username and password
    Then the user should be logged in successfully
    When the user clicks logout
    Then the user should be redirected to the login page