package com.insure.test.executionservice.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CommonPage extends BasePage {
  public CommonPage(WebDriver driver) {
    super(driver);
  }

  public static final By logo = new By.ById("header-logo");
  public static final By needHelpBtn = new By.ById("btn-need-help");
  public static final By contactEmail = new By.ById("contact-email");

  public void clickHelpBtn() {
    click(needHelpBtn);
    wait.until(visibilityOfElementLocated(contactEmail));
  }

  public String getContactEmail() {
    return findElement(contactEmail).getText();
  }
}
