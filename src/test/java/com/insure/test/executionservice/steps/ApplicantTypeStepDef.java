package com.insure.test.executionservice.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.insure.test.executionservice.pages.ApplicantTypePage;
import com.insure.test.executionservice.pages.CommonPage;
import com.insure.test.executionservice.pages.SelectProductPage;
import com.insure.test.executionservice.pages.WelcomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class ApplicantTypeStepDef {
  @Autowired WelcomePage welcomePage;
  @Autowired ApplicantTypePage applicantPage;
  @Autowired CommonPage commonPage;
  @Autowired SelectProductPage selectProductPage;

  @Then("Applicant type page should be displayed with below options")
  public void validateTheFunctionalitiesInApplicantTypePage(List<String> applicantTypes) {
    assertThat(commonPage.pageTitleText(), is("Applicant type"));
    List<String> listOfApplicants = applicantPage.getListOfApplicantsRadioBtn();
    log.info("List of Applicants displayed: {}", listOfApplicants);
    assertThat(listOfApplicants, contains(applicantTypes.toArray()));
    assertThat(applicantPage.getBackBtn().isDisplayed(), is(true));
    assertThat(applicantPage.getNextBtn().isDisplayed(), is(true));
  }

  @Then("User navigates to Applicant page")
  public void navigateToApplicantPage() {
    welcomePage.launchApplication();
    welcomePage.clickGetStartedBtn();
  }

  @And("User click applicant {string} and page navigates to Select product page")
  public void userClickOptionAndPageNavigatesToSelectProductPage(String applicant) {
    applicantPage.selectApplicant(applicant);
    selectProductPage.waitForPageToLoad();
  }
}
