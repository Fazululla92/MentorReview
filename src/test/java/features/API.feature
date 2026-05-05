Feature: Petstore and Users API Testing

  Scenario: Create and validate pet in Petstore
    Given Petstore base URI is set
    When I create a pet with id 12345
    Then I should get status code 200
    And I validate pet name is "snoopie"
    And I validate pet category is "dog"
    And I validate pet status is "pending"

  Scenario: Validate users API
    Given Users API base URI is set
    When I get all users
    Then status code should be 200
    And users list should contain more than 3 users
    And user "Ervin Howell" should exist

  Scenario: Full Employee lifecycle testing
    Given I fetch all employees
    Then I verify employee count
    When I create a new employee
    Then I verify employee is created
    And I verify employee count increased by 1

    When I get employee details
    Then I verify employee details

    When I update employee details
    Then I verify update is successful

    When I get employee details again
    Then I verify updated details

    When I delete employee
    Then I verify delete is successful
    And I verify employee count decreased by 1

  Scenario: Full defect lifecycle

    Given I create a Jira defect
    Then I store the defect id

    When I update the defect using id
    Then I verify defect is updated

    When I search the defect by id
    Then I verify defect is found

    When I attach a file to defect
    Then I verify attachment is successful

    When I create a defect with attachment
    Then I verify defect creation with attachment

    When I delete the defect
    Then I verify defect is deleted