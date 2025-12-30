package com.example.tests.cases;

import com.example.tests.base.BaseTest;
import com.example.tests.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LambdaTestScenario extends BaseTest {

    @DataProvider(name = "browserData")
    public Object[][] browserData() {
        return new Object[][] {
            {"Chrome", "latest"},
            {"Firefox", "latest"},
            {"Edge", "latest"}
        };
    }

    @Test(dataProvider = "browserData")
    public void runScenario(String browser, String version) throws Exception {
        driver = com.example.framework.drivers.DriverManager.createLTDriver("LambdaTestScenario-" + browser, browser, version);
        driver.manage().window().maximize();
        HomePage home = new HomePage(driver);
        home.open();
        home.scrollToIntegrations();
        home.clickIntegrations();

        // Step 6: Verify URL
        String expectedUrl = "https://www.lambdatest.com/integrations";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL mismatch!");

        // Step 12: Navigate to blog
        driver.get("https://www.lambdatest.com/blog");

        // Step 13: Click Community and verify
        driver.findElement(org.openqa.selenium.By.linkText("Community")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://community.lambdatest.com/", "Community URL mismatch!");

        // Step 14: Close browser
        driver.quit();
    }
}
