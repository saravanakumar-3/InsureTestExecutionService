package com.insure.test.executionservice.pages;

import static com.insure.test.executionservice.pages.CommonPage.pageTitle;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class SelectProductPage extends BasePage {
  public SelectProductPage(WebDriver driver) {
    super(driver);
  }

  public static final By listOfProductLabels =
      new By.ByXPath("//div[@id='form-view-wrapper']//div[@aria-label='editable-text']");

  public void waitForPageToLoad() {
    fluentWait.until(
        driver1 -> driver1.findElement(pageTitle).getText().equals("Select product(s)"));
  }

  public List<String> getListOfProductLabels() {
    return getListOfTexts(listOfProductLabels);
  }
}
