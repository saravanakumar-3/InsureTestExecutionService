package com.insure.test.executionservice.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class CommonPage extends BasePage {
  public CommonPage(WebDriver driver) {
    super(driver);
  }

  public static final By logo = new By.ById("header-logo");
  public static final By pageTitle = new By.ById("page-title");
  public static final By needHelpBtn = new By.ById("btn-need-help");
  public static final By contactEmail = new By.ById("contact-email");

  public String pageTitleText() {
    return findElement(pageTitle).getText();
  }

  public void clickHelpBtn() {
    click(needHelpBtn);
    wait.until(visibilityOfElementLocated(contactEmail));
  }

  public String getContactEmail() {
    return findElement(contactEmail).getText();
  }
}
