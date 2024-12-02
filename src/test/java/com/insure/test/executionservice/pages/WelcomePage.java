package com.insure.test.executionservice.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

@Log4j2
@Component
public class WelcomePage extends BasePage {
  public WelcomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @Value("${automation.url}")
  private String url;

  @FindBy(id = "header-logo")
  public WebElement logo;

  @FindBy(id = "page-title")
  public WebElement pageTitle;

  @FindBy(id = "btn-need-help")
  public WebElement needHelpBtn;

  public void launchApplication() {
    driver.get(url);
    System.out.println("------------------------------------");
    System.out.println(driver instanceof JavascriptExecutor);
    System.out.println(driver instanceof ChromeDriver);
    System.out.println("------------------------------------");
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Wait wait = new FluentWait(driver);
    wait.until(
        o -> {
          System.out.println("Waiting.................");
          return js.executeScript("return document.readyState;").equals("complete");
        });
    log.info("Navigated to url: " + url);
  }

  public void validateLogo() {
    assertThat(logo.isDisplayed(), is(true));
  }

  public String pageTitleText() {
    return pageTitle.getText();
  }

  public void clickHelpBtn() {
    needHelpBtn.click();
  }
}
