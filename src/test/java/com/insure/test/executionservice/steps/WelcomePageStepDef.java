package com.insure.test.executionservice.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import com.insure.test.executionservice.pages.ApplicantTypePage;
import com.insure.test.executionservice.pages.CommonPage;
import com.insure.test.executionservice.pages.WelcomePage;
import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class WelcomePageStepDef {
  @Autowired CommonPage commonPage;
  @Autowired WelcomePage welcomePage;
  @Autowired ApplicantTypePage applicantPage;

  @Given("User navigates to Welcome page")
  public void navigateToWelcomePage() {
    welcomePage.launchApplication();
  }

  @Given("Welcome page should be displayed with functionalities")
  public void validateTheFunctionalitiesInWelcomePage() {
    assertThat(welcomePage.getLogo().isDisplayed(), is(true));
    assertThat(welcomePage.pageTitleText(), containsString("Welcome"));
    commonPage.clickHelpBtn();
    assertThat(commonPage.getContactEmail(), is("yoursupport@insure.com"));
  }

  @Given("User click Get Started button")
  public void clickGetStartedBtn() {
    welcomePage.clickGetStartedBtn();
  }
}
