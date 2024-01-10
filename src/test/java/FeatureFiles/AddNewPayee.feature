#Website to use: http://zero.webappsecurity.com/login.html
#Username: username
#Password: password
#
#Test Case 1:
#➢ Go to ZeroBank website.
#➢ Log in
#➢ Click on Online Banking.
#➢ Click on Pay Bills.
#➢ Click “Add New Payee”
#➢ Fill in the Name, Address, Account, Details fields.
#
#NOTE: Send 3 different data
#NOTE: Use Data Table.
#
#➢ Click on the Add button
#➢ Verify that the process was completed successfully.

Feature:  New Payee Functionality

  Background:
    Given Navigate to website
    And   Enter username that as "username" and password that as "password"
    When  Click login button
    Then  Verify that user logged in


    @RegressionTest
  Scenario Outline: Fill in the required information completely
    When  Click on the element in OnlineBanking

      | onlineBanking |
      | payBills      |
      | addNewPayee   |

    And User sending name,address,account,and details in OnlineBanking

      | payeeName    | <name>    |
      | payeeAddress | <address> |
      | payeeAccount | <account> |
      | payeeDetails | <details> |

    When Click to add button
    Then Verify that the transaction was successful




    Examples:
      | name   | address | account | details        |
      | Thomas | Berlin  | 31459   | Rent payment   |
      | Maria  | London  | 78942   | Amazon payment |
      | Senol  | Orlando | 12549   | Credit payment |















