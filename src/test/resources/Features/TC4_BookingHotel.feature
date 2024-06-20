@BookingConfirm
Feature: Verifying Adactin Hotel Booking Confirmation

  Scenario Outline: Verifying Adactin Hotel with Booking Confirmation Details
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noofroom>","<checkin>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should click continue with select hotel
    Then User should verify after select hotel success message "Book A Hotel"
    And User should book hotel "<firstName>", "<lastName>", "<address>"
      | ccNum            | ccType           | ccMonth | ccYear | cvvNum |
      | 7851254125417485 | VISA             | May     |   2025 |    753 |
      | 6547852148963254 | MasterCard       | March   |   2027 |    951 |
      | 4789652365145254 | American Express | August  |   2028 |    412 |
    Then User should verify after book hotel success message "Booking Confirmation"

    Examples: 
      | userName    | password    | location | hotels      | roomType | noofroom  | checkin    | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | address |
      | dinesh45003 | dinesh45003 | London   | Hotel Creek | Standard | 3 - Three | 30/10/2022 | 31/10/2022   | 3 - Three     | 2 - Two         | Dinesh    | Raja     | Trichy  |

  Scenario Outline: Verifying Adactin Hotel Without Booking Confirmation Details
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noofroom>","<checkin>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should click continue with select hotel
    Then User should verify after select hotel success message "Book A Hotel"
    And User should click book now button without field details
    Then User should verify after book hotel displayed error message "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type", "Please Select your Credit Card Expiry Month", "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName    | password    | location | hotels      | roomType | noofroom  | checkin    | checkOutDate | adultsPerRoom | childrenPerRoom |
      | dinesh45003 | dinesh45003 | London   | Hotel Creek | Standard | 3 - Three | 30/10/2022 | 31/10/2022   | 3 - Three     | 2 - Two         |
