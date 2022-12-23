@SearchHotel
Feature: Verifying Adactin Hotel Search Hotel details

  Scenario Outline: Verifying Adactin Hotel Search Hotel details
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>"
    Then User should verify after Login success message "Hello jkannanr!"
    When User should enter Search Hotel fields "<location>", "<hotelName>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | username | password          | location | hotelName   | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrensPerRoom |
      | jkannanr | seleniumJAVA@2022 | London   | Hotel Creek | Standard | 5 - Five      | 03/11/2022  | 09/11/2022   | 2 - Two       | 2 - Two          |

  Scenario Outline: Verifying Adactin Hotel Search Hotel mandatory details
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>"
    Then User should verify after Login success message "Hello jkannanr!"
    When User should enter only mandatory fields "<location>","<numberofRooms>","<checkInDate>","<checkOutDate>" and "<adultsperRoom>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | username | password          | location | numberofRooms | checkInDate | checkOutDate | adultsperRoom |
      | jkannanr | seleniumJAVA@2022 | London   | 5 - Five      | 03/11/2022  | 09/11/2022   | 2 - Two       |

  Scenario Outline: Verifying Adactin Hotel date checking in Search Hotel Page
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>"
    Then User should verify after Login success message "Hello jkannanr!"
    When User should enter Search Hotel fields "<location>", "<hotelName>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel failure message "Check-In Date shall be before than Check-Out Date", "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username | password          | location | hotelName   | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrensPerRoom |
      | jkannanr | seleniumJAVA@2022 | Paris    | Hotel Creek | Standard | 5 - Five      | 10/11/2022  | 25/10/2022   | 2 - Two       | 2 - Two          |

  Scenario Outline: Verifying Adactin Hotel without entering Search Hotel details
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>"
    Then User should verify after Login success message "Hello jkannanr!"
    When User should click Search button without entering Search Hotel fields
    Then User should verify after search hotel failure message "Please Select a Location"

    Examples: 
      | username | password          | location | hotelName   | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrensPerRoom |
      | jkannanr | seleniumJAVA@2022 | London   | Hotel Creek | Standard | 5 - Five      | 03/11/2022  | 09/11/2022   | 2 - Two       | 2 - Two          |
