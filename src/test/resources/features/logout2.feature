@wip
Feature: logout2 feature

  Background: User logged in
    Given user on the login page

  Scenario Outline: Verify user logged out after closing all the open tabs
    When user login as "<userType>"
    And user open a new tab
    And user on the login page
    And user open a new tab
    When user close the previous tabs
    And user on the login page
    Then user should ends up the "Login" page

    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |