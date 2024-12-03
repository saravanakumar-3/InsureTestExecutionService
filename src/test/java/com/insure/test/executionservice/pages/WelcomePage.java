package com.insure.test.executionservice.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

@Log4j2
@Component
public class WelcomePage extends BasePage {
  public WelcomePage(WebDriver driver) {
    super(driver);
  }

  @Value("${automation.url}")
  private String url;

  public By logo = new By.ById("header-logo");
  public By pageTitle = new By.ById("page-title");
  public By needHelpBtn = new By.ById("btn-need-help");
  public By getStartedBtn = new By.ById("btn-next");
  public By contactEmail = new By.ById("contact-email");

  public void launchApplication() {
    driver.get(url);
    log.info("Navigated to url: " + url);
    wait.until(ExpectedConditions.visibilityOfElementLocated(getStartedBtn));
  }

  public WebElement getLogo() {
    return findElement(logo);
  }

  public String pageTitleText() {
    return findElement(pageTitle).getText();
  }

  public void clickHelpBtn() {
    click(needHelpBtn);
  }

  public String getContactEmail() {
    return findElement(contactEmail).getText();
  }
}
