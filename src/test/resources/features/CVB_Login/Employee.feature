Feature: Validate Employee add update and delete operation
 
@SmokeTest1
  Scenario: Login as admin and add Employee
    Given User is on home page and login with valid credentials
          | UserType | Action      |
          | Admin    | AddEmployee |
    And navigate to dashboard and verify login
    When provides employee user information and add
      | LastName | FirstName | Email | Mobile     | JobTitle |
      | Philip   | Peter     |       | 6789345433 | Dev      |
    Then Verification status should be 'Verified'
    
@SmokeTest
  Scenario: Login as admin and update Employee
    Given User is on home page and login with valid credentials
          | UserType | Action         |
          | Admin    | UpdateEmployee |
    And navigate to dashboard and verify login
    When provides employee user information and add
      | LastName | FirstName | Email | Mobile     | JobTitle |
      | Philip1  | Peter     |       | 6789345222 | Dev      |
    Then Verification status should be 'Verified'
    
@SmokeTest
  Scenario: Login as admin and delete Employee
    Given User is on home page and login with valid credentials
          | UserType | Action         |
          | Admin    | DeleteEmployee |
    And navigate to dashboard and verify login
    When provides employee user information and add
      | LastName | FirstName | Email | Mobile     | JobTitle |
      | Philip   | Peter     |       | 6789345899 | Dev      |
    Then Verification status should be 'Verified'