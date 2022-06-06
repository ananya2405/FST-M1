@activity5
Feature: Login Test

  Scenario Outline: Testing Login with Example
    Given User is on Login page
    When User enters "<Usernames>" and "<Passwords>"
    Then Read the page title and confirmation "<Message>"
    ##And Close the browser

    Examples:
      | Usernames | Passwords | Message             |
      | admin     | password  | Welcome Back, admin |
      | adminUser | Password  | Invalid Credentials |
