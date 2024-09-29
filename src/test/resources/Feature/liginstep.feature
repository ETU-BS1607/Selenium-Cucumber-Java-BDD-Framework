Feature: Feature to test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then user is navigated to the Logged In Successfully

  Examples:
    | username  | password    |
    | student   | Password123 |
    | student1  | password456 |
