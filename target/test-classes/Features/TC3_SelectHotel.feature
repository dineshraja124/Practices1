Feature: Verifying Adactin Hotel Select Hotel Details

  Scenario Outline: Verifying Adactin Hotel with Select Hotel Details
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noofroom>","<checkin>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should click continue with select hotel
    Then User should verify after select hotel success message "Book A Hotel"

    Examples: 
      | userName    | password    | location | hotels      | roomType | noofroom  | checkin    | checkOutDate | adultsPerRoom | childrenPerRoom |
      | dinesh45003 | dinesh45003 | London   | Hotel Creek | Standard | 3 - Three | 30/10/2022 | 31/10/2022   | 3 - Three     | 2 - Two         |

  Scenario Outline: Verifying Adactin Hotel Without Select Hotel Details
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noofroom>","<checkin>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should click continue without select any hotel
    Then User should verify after select hotel displayed error message "Please Select a Hotel"

    Examples: 
      | userName    | password    | location | hotels      | roomType | noofroom  | checkin    | checkOutDate | adultsPerRoom | childrenPerRoom |
      | dinesh45003 | dinesh45003 | London   | Hotel Creek | Standard | 3 - Three | 30/10/2022 | 31/10/2022   | 3 - Three     | 2 - Two         |
