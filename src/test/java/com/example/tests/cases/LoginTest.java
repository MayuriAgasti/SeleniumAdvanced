package com.example.tests.cases;

import com.example.tests.base.BaseTest;
import com.example.tests.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
  @Test
  public void validLoginShowsDashboard() {
    new LoginPage(driver)
      .open("https://the-internet.herokuapp.com/login")
      .enterUsername("tomsmith")
      .enterPassword("SuperSecretPassword!")
      .submit();

    Assert.assertTrue(driver.getTitle().toLowerCase().contains("internet"));
  }
}