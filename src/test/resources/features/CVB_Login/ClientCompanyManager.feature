Feature: Validate client company manager add update and delete operation
 
@SmokeTest
  Scenario: Login as admin and add client company manager
    Given User is on home page and login with valid credentials
          | UserType | Action      |
          | Admin    | AddCManager |
    And navigate to dashboard and verify login
    When provides client company manager user information and add
      | LastName | FirstName | Email | Mobile     | JobTitle |
      | Adam     | william   |       | 6789345677 | Dev      |
    Then Verification status should be 'Verified'
    
@SmokeTest1
  Scenario: Login as admin and update client company manager
    Given User is on home page and login with valid credentials
          | UserType | Action         |
          | Admin    | UpdateCManager |
    And navigate to dashboard and verify login
    When provides client company manager user information and add
      | LastName | FirstName | Email | Mobile     | JobTitle |
      | Adam1    | william   |       | 6789345677 | Dev      |
    Then Verification status should be 'Verified'
    
@SmokeTest
  Scenario: Login as admin and delete client company manager
    Given User is on home page and login with valid credentials
          | UserType | Action         |
          | Admin    | DeleteCManager |
    And navigate to dashboard and verify login
    When provides client company manager user information and add
      | LastName | FirstName | Email | Mobile     | JobTitle |
      | Adam     | william   |       | 6789345677 | Dev      |
    Then Verification status should be 'Verified'