package com.example.framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {
  public static Path take(WebDriver driver, String name) throws Exception {
    byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    Path out = Path.of("reports", "screenshots", name + ".png");
    Files.createDirectories(out.getParent());
    Files.write(out, png);
    return out;
  }
}