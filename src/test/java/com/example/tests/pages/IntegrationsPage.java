package com.example.tests.pages;

import org.openqa.selenium.*;

public class IntegrationsPage {
    private WebDriver driver;

    private By codelessAutomationSection = By.xpath("//h2[contains(text(),'Codeless Automation')]");
    private By testingWhizLink = By.xpath("//a[contains(text(),'INTEGRATE TESTING WHIZ WITH LAMBDATEST')]");

    public IntegrationsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToCodelessAutomation() {
        WebElement element = driver.findElement(codelessAutomationSection);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickTestingWhiz() {
        driver.findElement(testingWhizLink).click();
    }
}
