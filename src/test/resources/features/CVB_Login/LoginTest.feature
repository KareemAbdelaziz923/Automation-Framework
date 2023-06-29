Feature: Validate login of all user types in application
 
@SmokeTest
  Scenario: Login as admin and validate to dashboard menu
    Given User is on home page and login with valid credentials
          | UserType | Action |
          | Admin    | Login  |
    When navigate to dashboard and verify login
    Then Verification status should be 'Verified'
    
@SmokeTest
  Scenario: Login as employee and validate to dashboard menu
    Given User is on home page and login with valid credentials
          | UserType | Action |
          | Employee | Login  |
    When navigate to dashboard and verify login
    Then Verification status should be 'Verified'
    
@SmokeTest
  Scenario: Login as verifier and validate to dashboard menu
    Given User is on home page and login with valid credentials
          | UserType | Action |
          | Verifier | Login  |
    When navigate to dashboard and verify login
    Then Verification status should be 'Verified'
    
@SmokeTest
  Scenario: Login as Contractor and validate to dashboard menu
    Given User is on home page and login with valid credentials
          | UserType   | Action |
          | Contractor | Login  |
    When navigate to dashboard and verify login
    Then Verification status should be 'Verified'