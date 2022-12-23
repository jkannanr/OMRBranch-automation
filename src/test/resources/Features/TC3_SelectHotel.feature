@SelectHotel
Feature: Verifying Adactin Hotel Select Hotel details

  Scenario Outline: Verifying Adactin Hotel after Selecting Hotel name
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>"
    Then User should verify after Login success message "Hello jkannanr!"
    When User should enter Search Hotel fields "<location>", "<hotelName>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    When User should click continue after selecting hotel name
    Then User should verify after Select Hotel success message "Book A Hotel"

    Examples: 
      | username | password          | location | hotelName   | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrensPerRoom |
      | jkannanr | seleniumJAVA@2022 | London   | Hotel Creek | Standard | 5 - Five      | 03/11/2022  | 09/11/2022   | 2 - Two       | 2 - Two          |

  Scenario Outline: Verifying Adactin Hotel without Selecting Hotel details
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>"
    Then User should verify after Login success message "Hello jkannanr!"
    When User should enter Search Hotel fields "<location>", "<hotelName>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    When User should click continue without selecting any hotel name
    Then User should verify after Select Hotel failure message "Please Select a Hotel"

    Examples: 
      | username | password          | location | hotelName   | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrensPerRoom |
      | jkannanr | seleniumJAVA@2022 | London   | Hotel Creek | Standard | 5 - Five      | 03/11/2022  | 09/11/2022   | 2 - Two       | 2 - Two          |
