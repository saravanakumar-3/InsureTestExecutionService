package com.insure.test.executionservice.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.insure.test.executionservice.pages.ApplicantTypePage;
import com.insure.test.executionservice.pages.CommonPage;
import com.insure.test.executionservice.pages.SelectProductPage;
import com.insure.test.executionservice.pages.WelcomePage;
import io.cucumber.java.en.Then;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

@Log4j2
public class SelectProductPageStepDef {
  @Autowired WelcomePage welcomePage;
  @Autowired ApplicantTypePage applicantPage;
  @Autowired CommonPage commonPage;
  @Autowired SelectProductPage selectProductPage;

  @Then("Select product page should be displayed with below options")
  public void validateTheFunctionalitiesInApplicantTypePage(List<String> productList) {
    assertThat(commonPage.pageTitleText(), is("Select product(s)"));
    List<String> listOfProductLabels = selectProductPage.getListOfProductLabels();
    log.info("List of Products displayed: {}", listOfProductLabels);
    assertThat(listOfProductLabels, contains(productList.toArray()));
  }
}
