Feature: AddNewAddress

  Scenario Outline: AddNewAddress
    Given Open in browser mystore-testlab.coderslab.pl
    When click on sign in button
    When enter <email> in the email field
    When enter <password> in the password field
    And in login site click on sign in button
    When click on button addresses
    When click on button +Create new address
    And enter in the alias field <alias>
    And enter in the address field <address>
    And enter in the zip field <zip>
    And enter in the city field <city>
    And choose country on select list
    And enter in the phone field <phone>
    And click on button save
    Then address successfully added
    Then delete address
    And address successfully deleted
    And closed browser

    Examples:
      |email                         |password    |alias|address  |zip   |city  |phone    |
      |jannowak@player.mailinator.com|qwerty123!@#|Alias|Korkowa 8|00-111|Warsaw|501100100|