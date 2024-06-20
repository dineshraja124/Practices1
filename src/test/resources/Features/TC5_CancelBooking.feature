@Cancel
Feature: Verifying Adactin Hotel Cancel Booking

  Scenario Outline: Verifying Adactin Hotel with Cancel Booking
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"
    And User should search hotels "<location>","<hotels>","<roomType>","<noofroom>","<checkin>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should click continue with select hotel
    Then User should verify after select hotel success message "Book A Hotel"
    And User should book hotel "<firstName>", "<lastName>", "<address>"
      | Credit Card No.  | Credit Card Type | Select Month | Select Year | CVV Number |
      | 7851254125417485 | VISA             | May          |        2025 |        753 |
      | 6547852148963254 | MasterCard       | March        |        2027 |        951 |
      | 4789652365145254 | American Express | August       |        2028 |        412 |
    Then User should verify after book hotel success message "Booking Confirmation" and saved OrderId
    And User should cancel booking with orderId "The booking has been cancelled."
    Then User should verify after cancel booking success message "The booking has been cancelled."

    Examples: 
      | userName    | password    | location | hotels      | roomType | noofroom  | checkin    | checkOutDate | adultsPerRoom | childrenPerRoom | firstName    | lastName  | address |
      | dinesh45003 | dinesh45003 | London   | Hotel Creek | Standard | 3 - Three | 30/10/2022 | 31/10/2022   | 3 - Three     | 2 - Two         | Kamalakannan | Rajendran | Trichy  |

  Scenario Outline: Verifying Adactin Hotel with Cancel Booking with existing Order ID
    Given User is on Adactin Hotel login page
    When User should perform login "<userName>","<password>"
    Then User should verify after login success message "Hello dinesh45003!"
    And User should click booking itinerary and cancel booking with existing "<OrderId>"
    Then User should verify after cancel booking success message "The booking has been cancelled."

    Examples: 
      | userName    | password    | OrderId    |
      | dinesh45003 | dinesh45003 | ME1BX288AA |
