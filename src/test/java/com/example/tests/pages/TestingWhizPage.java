package com.example.tests.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestingWhizPage {
    private WebDriver driver;

    public TestingWhizPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyTitle() {
        String expected = "TestingWhiz Integration With LambdaTest";
        Assert.assertEquals(driver.getTitle(), expected, "Page title mismatch!");
    }
}