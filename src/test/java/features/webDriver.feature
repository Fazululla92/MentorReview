Feature: Login functionality

  @Smoke @UI
  Scenario: Successful login
    Given user is on login page
    When user enters username "Admin" and password "admin123"
    Then user should be logged in successfully

  @Smoke @UI
  Scenario Outline: Login with multiple users
    Given user is on login page
    When user enters username "<username>" and password "<password>"
    Then user should see login result "<result>"

    Examples:
      | username | password  | result   |
      | Admin    | admin123  | success  |
      | Admin    | wrongpass | failure  |


  Scenario: Successful login
    Given user is on login page
    When user enters username "standard_user" and password "secret_sauce"
    Then user should be logged in successfully