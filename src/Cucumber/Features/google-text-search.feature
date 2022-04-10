Feature: Google search

  Scenario Outline: user can search any keyword

    Given an open browser with "<url>"
    When a keyword "<keyword>" is entered in input field
    Then the first one should contain <keyword>
    And close browser

  Examples:
  |keyword  |url                    |
  |selenium |http://www.google.com  |
  |java     |http://www.google.com  |
  |intellij |http://www.google.com  |