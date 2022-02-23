@wip
Feature: Logout function

  Background: User logged in
    Given user on the login page

@test
  Scenario Outline: Verify user can logged out
    When user login as "<userType>"
    And user click logout button
    Then user should ends up the "Login" page
    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |


  Scenario Outline: Verify user can not land on Dashboard by clicking back button after logged out
    When user login as "<userType>"
    And user click logout button
    Then user should ends up the "Login" page
    When user click back button
    Then user should ends up the "Login" page
    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |

#@try123
#  Scenario Outline: Verify user logged out after closing the open tab
#    When user login as "<userType>"
#    And user open a new tab
#    When user close the previous tab
#    And user on the login page
#    Then user should ends up the "Login" page
#
#    Examples:
#      | userType      |
#      | driver        |
#      | store manager |
#      | sales manager |

#@tabs
#  Scenario Outline: Verify user logged out after closing all the open tabs
#    When user login as "<userType>"
#    And user open a new tab
#    And user on the login page
#    And user open a new tab
#    When user close the previous tabs
#    And user on the login page
#    Then user should ends up the "Login" page
#
#    Examples:
#      | userType      |
#      | driver        |
#      | store manager |
#      | sales manager |