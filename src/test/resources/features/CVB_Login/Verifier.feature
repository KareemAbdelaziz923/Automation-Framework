Feature: Validate Verifier add update and delete operation
 
@SmokeTest
  Scenario: Login as admin and add Verifier
    Given User is on home page and login with valid credentials
          | UserType | Action      |
          | Admin    | AddVerifier |
    And navigate to dashboard and verify login
    When provides verifier user information and add
      | LastName | FirstName | Email | Mobile     | JobTitle |
      | Voucher  | Mark      |       | 6789345412 | Dev      |
    Then Verification status should be 'Verified'
    
@SmokeTest1
  Scenario: Login as admin and update Verifier
    Given User is on home page and login with valid credentials
          | UserType | Action         |
          | Admin    | UpdateVerifier |
    And navigate to dashboard and verify login
    When provides verifier user information and add
      | LastName | FirstName | Email | Mobile     | JobTitle |
      | Voucher1 | Mark      |       | 6789345267 | Dev      |
    Then Verification status should be 'Verified'
    
@SmokeTest
  Scenario: Login as admin and delete Verifier
    Given User is on home page and login with valid credentials
          | UserType | Action         |
          | Admin    | DeleteVerifier |
    And navigate to dashboard and verify login
    When provides verifier user information and add
      | LastName | FirstName | Email | Mobile     | JobTitle |
      | Voucher  | Mark      |       | 6789345878 | Dev      |
    Then Verification status should be 'Verified'