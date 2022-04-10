Feature: Add address

  Scenario Outline: Add first address
    Given user is logged in on account page
    When user click add my first address
    When user fills form with data "<address>", "<postalCode>", "<city>", "<country>", "<homePhone>"
    And click Save button to add first address
    Then first address is added

    Examples:
      |address |postalCode|city  |country |homePhone|
      |Gagarina|00-001    |Warsaw|Poland  |111212111|