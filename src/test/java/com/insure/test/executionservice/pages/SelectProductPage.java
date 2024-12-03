package com.insure.test.executionservice.pages;

import static com.insure.test.executionservice.pages.CommonPage.pageTitle;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.stereotype.Component;

@Component
public class SelectProductPage extends BasePage {
  public SelectProductPage(WebDriver driver) {
    super(driver);
  }

  public static final By listOfProductLabels =
      new By.ByXPath("//div[@id='form-view-wrapper']//div[@aria-label='editable-text']");

  public void waitForPageToLoad() {
    Wait<WebDriver> fluentWait =
        new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(15))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);
    fluentWait.until(
        driver1 -> driver1.findElement(pageTitle).getText().equals("Select product(s)"));
  }

  public List<String> getListOfProductLabels() {
    return getListOfTexts(listOfProductLabels);
  }
}
