@wip
Feature: logout1 feature


  Background: User logged in
    Given user on the login page

  @try123
  Scenario Outline: Verify user logged out after closing the open tab
    When user login as "<userType>"
    And user open a new tab
    When user close the previous tab
    And user on the login page
    Then user should ends up the "Login" page

    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |