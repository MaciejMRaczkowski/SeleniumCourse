Feature: New account

  Scenario Outline: Create an account

    Given user is on authentication page
    When user inputs registration email as "<email>"
    And user clicks Create an account button
    When user fills form with data "<firstName>", "<lastName>", "<password>"
    And user clicks Register button
    Then user is registered

    Examples:
    |firstName|lastName|email                   |password|
    |Mariola  |Test    |m45a45il34214@test.com       |qwerty  |
    #|Janusz   |Testowy |434mail5@test.com       |qwerty  |