Feature: Happy path of Insure

  @SmokeTest
  Scenario: Validate the Welcome page
    When User navigates to Welcome page
    Then Required functionalities should be displayed