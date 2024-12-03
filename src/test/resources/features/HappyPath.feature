Feature: Happy path of Insure

  @SmokeTest
  Scenario: Validate the Welcome page
    When User navigates to Welcome page
    Then Welcome page should be displayed with functionalities

  @SystemTest
  Scenario: Validate the Applicant type and Select product page
    Given User navigates to Applicant page
    When User click Get Started button
    Then Applicant type page should be displayed with below options
      | Employee |
      | Spouse   |
    And User click applicant 'Spouse' and page navigates to Select product page
    And Select product page should be displayed with below options
      | Supplemental Life for Spouse |
      | Basic Dependent              |