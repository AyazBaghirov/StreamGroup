Feature: Login functionality

@ui
Scenario: Login validation
Given user is on Docuport login page
  And user insert credentials as "advisor"
  When user click Login button
  Then validate user is on homepage

