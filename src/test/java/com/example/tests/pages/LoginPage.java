package com.example.tests.pages;

import com.example.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
  private final By username = By.id("username");
  private final By password = By.id("password");
  private final By submit = By.cssSelector("button[type='submit']");

  public LoginPage(WebDriver driver) { super(driver); }

  public LoginPage open(String url) {
    driver.get(url);
    return this;
  }

  public LoginPage enterUsername(String value) {
    driver.findElement(username).sendKeys(value);
    return this;
  }

  public LoginPage enterPassword(String value) {
    driver.findElement(password).sendKeys(value);
    return this;
  }

  public void submit() {
    driver.findElement(submit).click();
  }
}
