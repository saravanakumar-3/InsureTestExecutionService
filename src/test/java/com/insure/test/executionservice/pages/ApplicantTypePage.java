package com.insure.test.executionservice.pages;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ApplicantTypePage extends BasePage {
  public ApplicantTypePage(WebDriver driver) {
    super(driver);
  }

  public static final By pageTitle = new By.ById("page-title");
  public static final By listOfRadioBtn =
      new By.ByXPath("//label[@aria-label='Radio option']//div[@aria-label='editable-text']");
  public static final By backBtn = new By.ById("btn-back");
  public static final By nextBtn = new By.ById("btn-next");

  public String pageTitleText() {
    return findElement(pageTitle).getText();
  }

  public List<String> getListOfRadioBtn() {
    return findElements(listOfRadioBtn).stream()
        .map(WebElement::getText)
        .collect(Collectors.toList());
  }

  public WebElement getBackBtn() {
    return findElement(backBtn);
  }

  public WebElement getNextBtn() {
    return findElement(nextBtn);
  }
}
