package com.insure.test.executionservice.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {
  protected WebDriver driver;
//  protected JavascriptExecutor js;
  public BasePage(WebDriver driver) {
    this.driver = driver;
//    this.js = (JavascriptExecutor) this.driver;
  }
}
