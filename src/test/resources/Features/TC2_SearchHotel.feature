@SearchHotel
Feature: Verifying Adactin Hotel Search Hotels Details

  Scenario Outline: Verifying Adactin Hotel Search Hotel Details
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noofroom>","<checkin>","<checkout>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName    | password    | location | hotels      | roomType | noofroom  | checkin    | checkout   | adultsPerRoom | childrenPerRoom |
      | dinesh45003 | dinesh45003 | London   | Hotel Creek | Standard | 3 - Three | 30/12/2022 | 31/12/2022 | 3 - Three     | 2 - Two         |

  Scenario Outline: Verifying Adactin Hotel Search Hotel Using Mandatory Field Details
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"
    And User should search hotels using mandatory fields "<location>","<noofroom>","<checkin>","<checkout>","<adultsPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName    | password    | location | noofroom  | checkin    | checkout   | adultsPerRoom |
      | dinesh45003 | dinesh45003 | London   | 3 - Three | 30/12/2022 | 31/12/2022 | 3 - Three     |

  Scenario Outline: Verifying Adactin Hotel Search Hotel using Invalid Date Credential
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noofroom>","<checkin>","<checkout>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel displayed Invalid date error message "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName    | password    | location | hotels      | roomType | noofroom  | checkin    | checkout   | adultsPerRoom | childrenPerRoom |
      | dinesh45003 | dinesh45003 | London   | Hotel Creek | Standard | 3 - Three | 31/12/2023 | 30/12/2022 | 3 - Three     | 2 - Two         |

  Scenario Outline: Verifying Adactin Hotel Search Hotel using Without Field Details
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"
    And User should search hotels without field details
    Then User should verify after search hotel displayed error message "Please Select a Location"

    Examples: 
      | userName    | password    |
      | dinesh45003 | dinesh45003 |
