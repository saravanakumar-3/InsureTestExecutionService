package com.insure.test.executionservice.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import com.insure.test.executionservice.pages.ApplicantTypePage;
import io.cucumber.java.en.Then;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class ApplicantTypeStepDef {
  @Autowired ApplicantTypePage applicantPage;

  @Then("Applicant type page should be displayed with functionalities")
  public void validateTheFunctionalitiesInApplicantTypePage() {
    assertThat(applicantPage.pageTitleText(), is("Applicant type"));
    validateRatioBtn();
    assertThat(applicantPage.getBackBtn().isDisplayed(), is(true));
    assertThat(applicantPage.getNextBtn().isDisplayed(), is(true));
  }

  private void validateRatioBtn() {
    List<String> listOfRadioBtn = applicantPage.getListOfRadioBtn();
    assertThat(listOfRadioBtn.get(0), is("Employee"));
    assertThat(listOfRadioBtn.get(1), is("Spouse"));
  }
}
