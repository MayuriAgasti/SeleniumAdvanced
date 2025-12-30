package com.example.tests.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By exploreIntegrationsLink = By.xpath("//a[contains(text(),'Explore all Integrations')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get("https://www.lambdatest.com");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("body")));
    }

    public void scrollToIntegrations() {
        WebElement element = driver.findElement(exploreIntegrationsLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickIntegrations() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(exploreIntegrationsLink));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
