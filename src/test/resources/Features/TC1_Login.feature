@login
Feature: Verifying Adactin Hotel login details

  Scenario Outline: Verifying Adactin Hotel login page with valid credentials
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"

    Examples: 
      | userName    | password    |
      | dinesh45003 | dinesh45003 |
      | dinesh45003 | dinesh45 |

  Scenario Outline: Verifying Adactin Hotel login using Enter
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>" with Enter key
    Then User should verify after login success message "Hello dinesh45003!"

    Examples: 
      | userName    | password    |
      | dinesh45003 | dinesh45003 |

  Scenario Outline: Verifying Adactin Hotel login with Invalid credentials
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login with invalid credentials error message "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName    | password    |
      | dinesh45003 | dinesh45003@123 |
