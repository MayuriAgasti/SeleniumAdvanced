package com.example.framework.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
  public static WebDriver createLocalChrome() {
    WebDriverManager.chromedriver().setup();
    return new ChromeDriver();
  }
}