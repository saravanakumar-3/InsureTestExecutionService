Feature: Happy path of Insure

  @SmokeTest
  Scenario: Validate the Welcome page
    When User navigates to Welcome page
    Then Welcome page should be displayed with functionalities

  @SystemTest
  Scenario: Validate the Applicant type page
    Given User navigates to Welcome page
    When User click Get Started button
    Then Applicant type page should be displayed with functionalities