#Test Case 2: Foreign Currency Functionality
#➢ Go to ZeroBank website.
#➢ Log in
#➢ Click on Online Banking.
#➢ Click on Pay Bills.
#➢ Click “Purchase Foreign Currency”.
#➢ Buy in 3 different currency types.
#➢ Verify that the process was completed successfully.

Feature: Purchase Foreign Currency Functionality

  Background:
    Given Navigate to website
    And   Enter username that as "username" and password that as "password"
    When  Click login button
    Then  Verify that user logged in

  @RegressionTest
  Scenario Outline: Convert amount to dollars
    When Click to Online Banking
    And  Click to Pay Bills
    And  Click to Purchase Foreign Currency
    And  Select currency that as "<value>"
    And  Enter to amount that as "<amount>"
    And  Click to U.S. dollar checkbox
    And  Click to Calculate Costs button
    And  Click to Purchase
    Then Verify that the transaction was successful

    Examples:
      | value | amount |
      | NOK   | 1000   |
      | EUR   | 100    |
      | GBP   | 90     |