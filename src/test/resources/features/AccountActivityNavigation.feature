Feature: Navigating	to specific	accounts in	Accounts Activity


  Background:
    Given the user is logged in


  Scenario Outline: <accountType> account redirect
    When the user clicks on "<link>" link on the Account Summary page
    Then the Account Activity page should be displayed
    And Account drop down should have "<option>" selected
    Examples:
      | accountType | link        | option      |
      | Savings     | Savings     | Savings     |
      | Brokerage   | Brokerage   | Brokerage   |
      | Checking    | Checking    | Checking    |
      | Credit Card | Credit Card | Credit Card |
      | Loan        | Loan        | Loan        |


