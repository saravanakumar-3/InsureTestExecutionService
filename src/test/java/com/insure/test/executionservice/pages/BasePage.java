package com.insure.test.executionservice.pages;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  protected final WebDriver driver;
  Wait<WebDriver> wait;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(15));
  }

  protected WebElement findElement(By by) {
    return driver.findElement(by);
  }

  protected List<WebElement> findElements(By by) {
    return driver.findElements(by);
  }

  protected void click(By by) {
    findElement(by).click();
  }

  protected List<String> getListOfTexts(By by) {
    return findElements(by).stream().map(WebElement::getText).collect(Collectors.toList());
  }
}
