package com.insure.test.executionservice.steps;

import com.insure.test.executionservice.pages.WelcomePage;
import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@Log4j2
public class WelcomePageStepDef {
  @Autowired WelcomePage welcomePage;

  @Given("User navigates to Welcome page")
  public void navigateToWelcomePage() {
    welcomePage.launchApplication();
  }

  @Given("Required functionalities should be displayed")
  public void validateTheFunctionalitiesInWelcomePage() {
    assertThat(welcomePage.getLogo().isDisplayed(), is(true));
    assertThat(welcomePage.pageTitleText(), containsString("Welcome"));
    welcomePage.clickHelpBtn();
    assertThat(welcomePage.getContactEmail(), is("yoursupport@insure.com"));
  }
}
