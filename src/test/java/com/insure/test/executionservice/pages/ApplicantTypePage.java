package com.insure.test.executionservice.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class ApplicantTypePage extends BasePage {
  public ApplicantTypePage(WebDriver driver) {
    super(driver);
  }

  public static final By listOfApplicantsLabel =
      new By.ByXPath("//label[@aria-label='Radio option']//div[@aria-label='editable-text']");
  public static final By backBtn = new By.ById("btn-back");
  public static final By nextBtn = new By.ById("btn-next");
  public static final By listOfApplicantsBtn = new By.ByXPath("//input[@type='radio']");

  public List<String> getListOfApplicantsRadioBtn() {
    return getListOfTexts(listOfApplicantsLabel);
  }

  public WebElement getBackBtn() {
    return findElement(backBtn);
  }

  public WebElement getNextBtn() {
    return findElement(nextBtn);
  }

  public void selectApplicant(String applicant) {
    List<String> labels = getListOfTexts(listOfApplicantsLabel);
    int index = labels.indexOf(applicant);
    findElements(listOfApplicantsBtn).get(index).click();
  }
}
