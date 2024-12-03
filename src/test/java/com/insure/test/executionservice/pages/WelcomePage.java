package com.insure.test.executionservice.pages;

import static com.insure.test.executionservice.pages.CommonPage.logo;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class WelcomePage extends BasePage {
  public WelcomePage(WebDriver driver) {
    super(driver);
  }

  @Value("${automation.url}")
  private String url;

  public static final By getStartedBtn = new By.ById("btn-next");

  public void launchApplication() {
    driver.get(url);
    log.info("Navigated to url: " + url);
    wait.until(visibilityOfElementLocated(getStartedBtn));
  }

  public WebElement getLogo() {
    return findElement(logo);
  }

  public void clickGetStartedBtn() {
    click(getStartedBtn);
    wait.until(elementToBeClickable(ApplicantTypePage.nextBtn));
  }
}
