
Feature: Manage Orange HRM users 
  
@AdminTest  
  Scenario: Add new ESS user
    Given User is on Admin Landing Page
    When user select the add button
    Then the add user page is open
    And user fill all fields and save changes
    Then a successfully create message is display
