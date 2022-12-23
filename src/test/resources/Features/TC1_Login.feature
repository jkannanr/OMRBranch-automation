@Login
Feature: Verifying Adactin Hotel Login Details

  Scenario Outline: Verifying Adactin Hotel Login Valid
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>"
    Then User should verify after Login success message "Hello jkannanr!"

    Examples: 
      | username | password          |
      | jkannanr | seleniumJAVA@2022 |

  Scenario Outline: Verifying Adactin Hotel Login Using Enter
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>" with Enter Key
    Then User should verify after Login success message "Hello jkannanr!"

    Examples: 
      | username | password          |
      | jkannanr | seleniumJAVA@2022 |

  Scenario Outline: Verifying Adactin Hotel Login Invalid Credentials
    Given User is on Adactin Page
    When User should perform Login "<username>", "<password>"
    Then User should verify after Login with invalid credential error message contains "Invalid Login details or Your Password might have expired. Click here to reset your password"

    Examples: 
      | username | password          |
      | jkannanr | selENiumJAVA@2020 |
