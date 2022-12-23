@CancelBooking
Feature: Verifying Adactin Hotel Booking Cancellation details

  Scenario Outline: Verifying Adactin Hotel Booking cancellation after generating Order ID
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>"
    Then User should verify after Login success message "Hello jkannanr!"
    When User should enter Search Hotel fields "<location>", "<hotelName>","<roomType>","<numberofRooms>","<checkInDate>","<checkOutDate>","<adultsperRoom>" and "<childrensPerRoom>"
    Then User should verify after search hotel success message "Select Hotel"
    When User should click continue after selecting hotel name
    Then User should verify after Select Hotel success message "Book A Hotel"
    And User should enter book hotel fields "<firstName>","<lastName>","<billingAddress>" and Credit card fields
      | creditcardNo     | creditCardType   | expiryMonth | expiryYear | cvv |
      | 8956784569851250 | VISA             | April       |       2018 | 587 |
      | 8555784569851250 | American Express | May         |       2021 | 897 |
      | 8876984569851250 | Master           | March       |       2017 | 587 |
      | 8956784569851250 | VISA             | June        |       2018 | 145 |
      | 8125478456851250 | American Express | April       |       2019 | 247 |
      | 8956784569851250 | VISA             | June        |       2017 | 456 |
      | 8356284569851250 | American Express | April       |       2018 | 417 |
      | 8956784569851250 | VISA             | July        |       2020 | 859 |
      | 8956784569851250 | VISA             | April       |       2018 | 658 |
      | 8956784569851250 | VISA             | April       |       2018 | 658 |
    Then User should verify after booking hotel success message "Booking Confirmation" and save the Order ID
    And User should cancel order ID
    Then User should verify after cancel order ID success message "The booking has been cancelled."

    Examples: 
      | username | password          | location | hotelName   | roomType | numberofRooms | checkInDate | checkOutDate | adultsperRoom | childrensPerRoom | firstName | lastName | billingAddress        |
      | jkannanr | seleniumJAVA@2022 | London   | Hotel Creek | Standard | 5 - Five      | 03/11/2022  | 09/11/2022   | 2 - Two       | 2 - Two          | Jawahar   | Kannan   | Thoriapakkam, chennai |

  Scenario Outline: Verifying Adactin Hotel Booking cancellation with existing Order ID
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>"
    Then User should verify after Login success message "Hello jkannanr!"
    And User should cancel Existing order ID "<orderId>"
    Then User should verify after cancel order ID success message "The booking has been cancelled."

    Examples: 
      | username | password          | orderId    |
      | jkannanr | seleniumJAVA@2022 | 3Q9379U2AR |
