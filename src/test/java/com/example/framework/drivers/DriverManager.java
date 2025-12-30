package com.example.framework.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    public static WebDriver createLTDriver(String testName, String browserName, String browserVersion) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", browserName);
        caps.setCapability("browserVersion", browserVersion);

        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("platformName", "Windows 11");
        ltOptions.put("build", "Selenium-Advanced-Certification");
        ltOptions.put("name", testName);
        ltOptions.put("video", true);     // record video
        ltOptions.put("visual", true);    // screenshots
        ltOptions.put("network", true);   // network logs
        ltOptions.put("console", true);   // console logs

        caps.setCapability("LT:Options", ltOptions);

        String username = System.getenv("LT_USERNAME");
        String accessKey = System.getenv("LT_ACCESS_KEY");

        return new RemoteWebDriver(
            new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"),
            caps
        );
    }

    public static WebDriver createLocalDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}