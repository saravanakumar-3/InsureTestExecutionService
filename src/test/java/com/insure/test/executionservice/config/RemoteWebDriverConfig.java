package com.insure.test.executionservice.config;

import io.cucumber.spring.ScenarioScope;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("grid")
public class RemoteWebDriverConfig {
  @Value("${grid.url}")
  public URL url;

  @Bean
  @ScenarioScope
  public WebDriver getWebDriver(@Value("${automation.browser}") String browser) {
    WebDriver driver;
    switch (browser) {
      case "chrome":
        driver = new RemoteWebDriver(url, new ChromeOptions());
        break;
      case "firefox":
        driver = new RemoteWebDriver(url, new FirefoxOptions());
        break;
      default:
        throw new IllegalArgumentException("Browser '" + browser + "' is not supported");
    }
    driver.manage().window().maximize();
    return driver;
  }
}
